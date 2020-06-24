/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerController;

import DAO.CatalogImpl;
import DAO.HomeImpl;
import DAO.ProductImpl;
import DAO.UserIO;
import Model.Catalog;
import Model.Product;
import Model.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dell
 */
@WebServlet(urlPatterns = {""})
public class HomeServlet extends HttpServlet {

    private HomeImpl homeImpl = new HomeImpl();
    private CatalogImpl catalogImpl = new CatalogImpl();
    private ProductImpl productImpl = new ProductImpl();
    private UserIO userIO = new UserIO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession ss = req.getSession();
        Object object = ss.getAttribute("user");
        if (object == null) {
            Cookie[] cookies = req.getCookies();
            System.out.println("Legnth= " + cookies.length);
            String name = "userName";
            String userName = "";
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (name.equals(cookie.getName())) {
                    userName = cookie.getValue();
                    break;
                }
            }
            if (!userName.equals("")) {
                User user = userIO.getByName(userName);
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
            }
        }

        List<Product> listProductNew = homeImpl.getAll();
        List<Product> listproduct = productImpl.getAll();
        listproduct.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.getQuantity() - o1.getQuantity();
            }
        });
        List<Product> listTopSale = new ArrayList();
        for (int i = 0; i < (listproduct.size()>=10?10:listproduct.size()) ; i++) {
            listTopSale.add(listproduct.get(i));
        }
        listproduct.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                int x = (int) o1.getSale();
                int y = (int) o2.getSale();
                return y - x;
            }
        });
        List<Product> listBestSale = new ArrayList();
        for (int i = 0; i < (listproduct.size()>=10?10:listproduct.size()); i++) {
            listBestSale.add(listproduct.get(i));
        }
        req.setAttribute("listBestSale", listBestSale);
        req.setAttribute("listTopSale", listTopSale);
        req.setAttribute("listProductNew", listProductNew);
        List<Catalog> listCatalog = catalogImpl.getAll();
        req.setAttribute("catalog", listCatalog);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }

}

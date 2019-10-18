/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerController;

import DAO.CatalogImpl;
import Model.Cart;
import Model.Catalog;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dell
 */
@WebServlet(urlPatterns = {"/customer/cart"})
public class CartServlet extends HttpServlet{
    private CatalogImpl catalogImpl = new CatalogImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object object = session.getAttribute("cart");
        Map<Integer,Cart> mapCart = (Map<Integer,Cart>) object;
        float totalMoney = 0;
        if(mapCart!=null){
            for(Map.Entry<Integer,Cart> i:mapCart.entrySet()){
                totalMoney += i.getValue().getTotalPrice();
            }
        }
        List<Catalog> listCatalog = catalogImpl.getAll();
        req.setAttribute("catalog", listCatalog);
        req.setAttribute("totalMoney", totalMoney);
        req.setAttribute("mapCart", mapCart);
        RequestDispatcher rd = req.getRequestDispatcher("/customer/cart.jsp");
        rd.forward(req, resp);
    }
}

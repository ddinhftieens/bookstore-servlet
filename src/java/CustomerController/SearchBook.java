/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerController;

import DAO.CatalogImpl;
import DAO.ProductImpl;
import DAO.ViewDAO;
import Model.Catalog;
import Model.Product;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NguyenDinhTien
 */
@WebServlet(urlPatterns = {"/customer/timkiemtheoten"})
public class SearchBook extends HttpServlet {
    private ProductImpl productImpl = new ProductImpl();
    private CatalogImpl catalogImpl = new CatalogImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String IDcode = req.getParameter("timkiem");
//        int viewCount = ViewDAO.readView(Integer.parseInt(IDcode));
//        ViewDAO.addView(Integer.parseInt(IDcode));
        List<Product> list = productImpl.getAllbyName(IDcode);
//        List<Catalog> listCatalog = catalogImpl.getAll();
//        req.setAttribute("catalog", listCatalog);
        req.setAttribute("listProductNew", list);
        req.setAttribute("viewCount", 10);
        RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
        rd.forward(req, resp);
    }  
}

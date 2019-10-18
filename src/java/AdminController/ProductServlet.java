/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminController;

import DAO.ProductImpl;
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
 * @author Dell
 */
@WebServlet(name="productServlet", urlPatterns = {"/admin/catalog/product"})
public class ProductServlet extends HttpServlet{
    
    private ProductImpl productImpl = new ProductImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        String IDcatalog = req.getParameter("IDcatalog");
        List<Product> listProduct = productImpl.getAllbyID(Integer.parseInt(IDcatalog));
        req.setAttribute("listProduct", listProduct);
        req.setAttribute("IDcatalog", IDcatalog);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/admin-product.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    } 
}

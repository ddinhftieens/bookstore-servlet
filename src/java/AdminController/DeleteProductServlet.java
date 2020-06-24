/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminController;

import DAO.ProductImpl;
import DAO.ViewDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
@WebServlet(name = "deleteProductServlet", urlPatterns = {"/admin/catalog/product/delete"})
public class DeleteProductServlet extends HttpServlet{
    private ProductImpl produceImpl = new ProductImpl();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String IDproduct = req.getParameter("IDproduct");
        ViewDAO.delete(Integer.parseInt(IDproduct));
        produceImpl.delete(Integer.parseInt(IDproduct));
        resp.sendRedirect(req.getContextPath()+"/admin/catalog/product?IDcatalog="+req.getParameter("IDcatalog"));
    }
    
}

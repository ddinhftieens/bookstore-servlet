/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminController;

import DAO.CatalogImpl;
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
@WebServlet(urlPatterns = {"/admin/catalog/delete"})
public class DeleteCatalogServlet extends HttpServlet{
    private CatalogImpl catalogImpl = new CatalogImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String IDcatalog = req.getParameter("IDcatalog");
        catalogImpl.delete(Integer.parseInt(IDcatalog));
        resp.sendRedirect(req.getContextPath()+"/admin/catalog");
    }
    
}

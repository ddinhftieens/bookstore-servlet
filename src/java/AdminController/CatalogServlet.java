/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminController;

import DAO.CatalogImpl;
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
 * @author Dell
 */
@WebServlet(urlPatterns = {"/admin/catalog"})
public class CatalogServlet extends HttpServlet{
    private CatalogImpl catalogImpl = new CatalogImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        List<Catalog> listCatalog = catalogImpl.getAll();
        req.setAttribute("listCatalog", listCatalog);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/admin-catalog.jsp");
        requestDispatcher.forward(req, resp);
    }
    
}

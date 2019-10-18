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
import java.util.Calendar;
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
@WebServlet(urlPatterns = {"/admin/catalog/add"})
public class AddCatalogServlet extends HttpServlet{
    private CatalogImpl catalogImpl = new CatalogImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/admin-add-catalog.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        Catalog catalog = new Catalog();
        catalog.setNameCatalog(req.getParameter("catalog"));
        Calendar calendar = Calendar.getInstance();
        String datecreated = "" +(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.DATE)+"/"+(calendar.get(Calendar.YEAR))+" "+calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND);
        catalog.setDatecreated(datecreated);
        catalogImpl.add(catalog);
        resp.sendRedirect(req.getContextPath()+"/admin/catalog");
    }
}

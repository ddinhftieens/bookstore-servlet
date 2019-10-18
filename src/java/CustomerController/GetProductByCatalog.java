/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerController;

import DAO.CatalogImpl;
import DAO.ProductImpl;
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
@WebServlet(urlPatterns = {"/customer/catalog"})
public class GetProductByCatalog extends HttpServlet{
    private CatalogImpl catalogImpl = new CatalogImpl();
    private ProductImpl productImpl = new ProductImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Catalog> listCatalog = catalogImpl.getAll();
        req.setAttribute("catalog", listCatalog);
        String IDcatalog = req.getParameter("IDcatalog");
        List<Product> listProduct = productImpl.getAllbyID(Integer.parseInt(IDcatalog));
        Catalog catalog = catalogImpl.getByID(Integer.parseInt(IDcatalog));
        req.setAttribute("nameCatalog", catalog.getNameCatalog());
        req.setAttribute("product", listProduct);
        RequestDispatcher rd = req.getRequestDispatcher("/customer/getProductbyCatalog.jsp");
        rd.forward(req, resp);
    }
    
}

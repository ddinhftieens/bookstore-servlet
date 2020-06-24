/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminController;

import DAO.CatalogImpl;
import DAO.ProductImpl;
import Model.Catalog;
import Model.Product;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Dell
 */
@WebServlet(name="addProductServlet",urlPatterns={"/admin/catalog/product/add"})
@MultipartConfig(maxRequestSize = 1024*1024*50,maxFileSize = 1024*1024*10,fileSizeThreshold = 1024*1024*2)
public class AddProductServlet extends HttpServlet{
    
    private ProductImpl productImpl = new ProductImpl();
    private CatalogImpl catalogImpl = new CatalogImpl();
    private int IDcatalog;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        this.IDcatalog = Integer.parseInt(req.getParameter("IDcatalog"));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/admin-add-product.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        Catalog catalog = new Catalog();
        catalog = catalogImpl.getByID(this.IDcatalog);
        Product product = new Product();
        product.setNameBook(req.getParameter("nameBook"));
        product.setAuthor(req.getParameter("author"));
        product.setNXB(req.getParameter("NXB"));
        product.setDateofissue(req.getParameter("dateofissue"));
        String number = req.getParameter("numberPage");
        product.setNumberpage(Integer.parseInt(number));
        String quantity = req.getParameter("quantity");
        product.setQuantity(Integer.parseInt(quantity));
        product.setDescription(req.getParameter("description"));
        String price = req.getParameter("price");
        product.setPrice(Float.parseFloat(price));
        String sale = req.getParameter("sale");
        product.setSale(Float.parseFloat(sale));
        String IDcode = System.currentTimeMillis()+"";
        product.setIDcode(IDcode);
        Calendar calendar = Calendar.getInstance();
        String datecreated = "" +(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.DATE)+"/"+(calendar.get(Calendar.YEAR))+" "+calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND);
        product.setDatecreated(datecreated);
        product.setIDcatalog(this.IDcatalog);
        Part part = req.getPart("fileImage");
        final String UPLOAD = "D:\\LTWeb\\product";
        File uploadDir = new File(UPLOAD);
        if (!uploadDir.exists()) uploadDir.mkdir();
        part.write(UPLOAD + File.separator + IDcode+".jpg");
        product.setStatus(req.getParameter("status"));
        productImpl.add(product);
        resp.sendRedirect(req.getContextPath()+"/admin/catalog/product?IDcatalog="+this.IDcatalog+"&name=" + catalog.getNameCatalog());
    }
}

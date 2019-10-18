/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminController;

import DAO.ProductImpl;
import Model.Product;
import java.io.IOException;
import java.util.Calendar;
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
@WebServlet(name="editproductServlet",urlPatterns = {"/admin/catalog/product/edit"})
public class EditProductServlet extends HttpServlet{
    private ProductImpl productImpl = new ProductImpl();
    private int IDproduct;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        String IDproduct = req.getParameter("IDproduct");
        this.IDproduct = Integer.parseInt(IDproduct);
        req.setAttribute("product", productImpl.getByID(this.IDproduct));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/admin-edit-product.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        Product product = new Product();
        product.setID(this.IDproduct);
        product.setNameBook(req.getParameter("tensach"));
        product.setAuthor(req.getParameter("tacgia"));
        product.setNXB(req.getParameter("nhaxuatban"));
        product.setDateofissue(req.getParameter("ngayphathanh"));
        String number = req.getParameter("sotrang");
        product.setNumberpage(Integer.parseInt(number));
        String quantity = req.getParameter("soluong");
        product.setQuantity(Integer.parseInt(quantity));
        product.setDescription(req.getParameter("mota"));
        String price = req.getParameter("gia");
        product.setPrice(Float.parseFloat(price));
        String sale = req.getParameter("giamgia");
        product.setSale(Float.parseFloat(sale));
//        String IDcode = System.currentTimeMillis()+"";
//        product.setIDcode(IDcode);
        Calendar calendar = Calendar.getInstance();
        String datecreated = "" +(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.DATE)+"/"+(calendar.get(Calendar.YEAR))+" "+calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND);
        product.setDatecreated(datecreated);
        product.setStatus(req.getParameter("status"));
        productImpl.edit(product);
        resp.sendRedirect(req.getContextPath()+"/admin/catalog/product?IDcatalog="+req.getParameter("IDcatalog"));
    }
}

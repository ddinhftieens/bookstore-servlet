/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminController;

import DAO.InvoiceDB;
import DAO.ProductImpl;
import Model.Cart;
import Model.Invoice;
import Model.Product;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
@WebServlet(urlPatterns = {"/admin/showOrder"})
public class ReceiveOrderServlet extends HttpServlet{
    private InvoiceDB invoiceDB = new InvoiceDB();
    private ProductImpl productImpl = new ProductImpl();
    private int IDorder=0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        String IDorder = req.getParameter("IDorder");
        this.IDorder = Integer.parseInt(IDorder);
        Invoice invoice = invoiceDB.getByID(Integer.parseInt(IDorder));
        String idProduct[] = invoice.getIDproduct().split(",");
        String quantity[] = invoice.getQuantity().split(",");
        String price[] = invoice.getPrice().split(",");
        String totalPrice[] = invoice.getTotalPrice().split(",");
        Map<Integer,Cart> myCart = new HashMap<Integer, Cart>();
        float totalMoney = 0;
        for(int i=0;i<idProduct.length;i++){
            Cart cart = new Cart();
            Product product = productImpl.getByID(Integer.parseInt(idProduct[i]));
            cart.setIDproduct(Integer.parseInt(idProduct[i]));
            cart.setIDcode(product.getIDcode());
            cart.setName(product.getNameBook());
            cart.setQuantity(Integer.parseInt(quantity[i]));
            cart.setPrice(Float.parseFloat(price[i]));
            cart.setTotalPrice(Float.parseFloat(totalPrice[i]));
            totalMoney += Float.parseFloat(totalPrice[i]);
            myCart.put(Integer.parseInt(idProduct[i]), cart);
        }
        req.setAttribute("invoice", invoice);
        req.setAttribute("myCart", myCart);
        req.setAttribute("totalMoney", totalMoney);
        RequestDispatcher rd = req.getRequestDispatcher("/admin/admin-detailOrder.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        String status = req.getParameter("status");
        invoiceDB.updateStatus(IDorder, status);
        resp.sendRedirect("/admin/order");
    }
    
}

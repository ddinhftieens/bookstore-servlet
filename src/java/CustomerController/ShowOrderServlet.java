/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerController;

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
@WebServlet(urlPatterns = {"/customer/logined/showOrder"})
public class ShowOrderServlet extends HttpServlet{
    private InvoiceDB invoiceDB = new InvoiceDB();
    private ProductImpl productImpl = new ProductImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String IDorder = req.getParameter("IDorder");
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
        RequestDispatcher rd = req.getRequestDispatcher("/customer/showOrder.jsp");
        rd.forward(req, resp);
    }
    
}

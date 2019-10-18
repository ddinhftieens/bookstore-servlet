/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerController;

import DAO.CatalogImpl;
import DAO.InvoiceDB;
import DAO.ProductImpl;
import Model.Cart;
import Model.Catalog;
import Model.Invoice;
import Model.User;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dell
 */
@WebServlet(urlPatterns = {"/customer/logined/payment"})
public class PayServlet extends HttpServlet {
    
    private ProductImpl productImpl = new ProductImpl();
    private CatalogImpl catalogImpl = new CatalogImpl();
    private InvoiceDB invoiceDB = new InvoiceDB();
    private float totalMoney = 0;
    private Map<Integer, Cart> mapCart;
    private String time;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        Object object = session.getAttribute("cart");
        mapCart = (Map<Integer, Cart>) object;
        if (mapCart != null) {
            for (Map.Entry<Integer, Cart> i : mapCart.entrySet()) {
                totalMoney += i.getValue().getTotalPrice();
            }
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 3);
        time = calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR);
        req.setAttribute("time", time);
        List<Catalog> listCatalog = catalogImpl.getAll();
        req.setAttribute("catalog", listCatalog);
        req.setAttribute("totalMoney", totalMoney);
        req.setAttribute("mapCart", mapCart);
        RequestDispatcher rd = req.getRequestDispatcher("/customer/order.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        Invoice invoice = new Invoice();
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String note = req.getParameter("note");
        String pay = req.getParameter("pay");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String datecreated = dateFormat.format(new Date());
        String IDproduct="",quantity="",price="",totalPrice="";
        for (Map.Entry<Integer, Cart> i : mapCart.entrySet()) {
            productImpl.updateQuantity(i.getKey(),i.getValue().getQuantity());
            IDproduct += i.getKey() + ",";
            quantity += i.getValue().getQuantity() + ",";
            price += i.getValue().getPrice() + ",";
            totalPrice += i.getValue().getTotalPrice() + ",";
        }
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        invoice.setIdcustomer(user.getID());
        invoice.setName(name);
        invoice.setPhone(phone);
        invoice.setAddress(address);
        invoice.setEmail(email);
        invoice.setNote(note);
        invoice.setStatus("New");
        invoice.setIDproduct(IDproduct);
        invoice.setQuantity(quantity);
        invoice.setPrice(price);
        invoice.setTotalPrice(totalPrice);
        invoice.setTimerevice(time);
        invoice.setDateCreated(datecreated);
        invoice.setPayment(pay);
        invoiceDB.add(invoice);
        session.setAttribute("cart", null);
        resp.sendRedirect("/");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminController;

import DAO.InvoiceDB;
import Model.Invoice;
import java.io.IOException;
import java.util.Comparator;
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
@WebServlet(urlPatterns = {"/admin/order"})
public class OrderServlet extends HttpServlet{
    private InvoiceDB invoice = new InvoiceDB();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Invoice> listInvoice = invoice.getAll();
        listInvoice.sort(new Comparator<Invoice>(){
            @Override
            public int compare(Invoice o1, Invoice o2) {
                return o2.getDateCreated().compareTo(o1.getDateCreated());
            }
            
        });
        req.setAttribute("listInvoice", listInvoice);
        RequestDispatcher rd = req.getRequestDispatcher("/admin/admin-order.jsp");
        rd.forward(req, resp);
    }
    
}

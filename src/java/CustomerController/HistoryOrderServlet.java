/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerController;

import DAO.CatalogImpl;
import DAO.InvoiceDB;
import Model.Catalog;
import Model.Invoice;
import Model.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
@WebServlet(urlPatterns = {"/customer/logined/history"})
public class HistoryOrderServlet extends HttpServlet{
    private InvoiceDB invoiceDB = new InvoiceDB();
    private CatalogImpl catalogImpl = new CatalogImpl();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Invoice> listInvoice = new ArrayList<Invoice>();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        listInvoice = invoiceDB.getAllbyID(user.getID());
        listInvoice.sort(new Comparator<Invoice>(){
            @Override
            public int compare(Invoice o1, Invoice o2) {
                return o2.getDateCreated().compareTo(o1.getDateCreated());
            }    
        });
        req.setAttribute("listInvoice", listInvoice);
        List<Catalog> listCatalog = catalogImpl.getAll();
        req.setAttribute("catalog", listCatalog);
        RequestDispatcher rd = req.getRequestDispatcher("/customer/historyTransaction.jsp");
        rd.forward(req, resp);
    }
}

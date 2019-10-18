/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminController;

import DAO.UserIO;
import Model.User;
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
@WebServlet(urlPatterns = {"/admin/customer"})
public class CustomerServlet extends HttpServlet{
    private UserIO userIO = new UserIO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        List<User> listUser = userIO.getAll();
        req.setAttribute("listUser", listUser);
        RequestDispatcher rd = req.getRequestDispatcher("/admin/admin-customer.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        String IDuser = req.getParameter("IDuser");
        String role = req.getParameter("role");
        userIO.updateRole(Integer.parseInt(IDuser), role);
        resp.sendRedirect("/admin/customer");
    }
    
}

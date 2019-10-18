/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerController;

import DAO.UserIO;
import Model.User;
import java.io.IOException;
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
@WebServlet(urlPatterns = {"/customer/logined/infor"})
public class InforUserServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        RequestDispatcher rd = req.getRequestDispatcher("/customer/infor.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        String user = req.getParameter("user");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        if(!UserIO.checkUpdate(user, phone, email)){
            UserIO.update(user, phone, email, address);
            HttpSession session = req.getSession();
            User us = (User) session.getAttribute("user");
            us.setAddress(address);
            us.setPhone(phone);
            us.setEmail(email);
            session.setAttribute("user", us);
            resp.sendRedirect("/customer/logined/infor?message=cap nhat thanh cong");
        }
        else{
            resp.sendRedirect("/customer/logined/infor?message=cap nhat loi");
        }
    }
}

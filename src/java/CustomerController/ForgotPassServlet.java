/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerController;

import DAO.UserIO;
import Model.SendEmailConfim;
import Model.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
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
@WebServlet(urlPatterns = {"/customer/forgot"})
public class ForgotPassServlet extends HttpServlet {
    private UserIO userIO = new UserIO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/customer/forgotPass-findUser.jsp");
        rd.forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        if (UserIO.findUser(user)) {
            HttpSession session = req.getSession();
            User us = userIO.getByName(user);
            session.setAttribute("userName", user);
            session.setAttribute("email", us.getEmail());
            session.setAttribute("salt", us.getSaltEncoder());
            int code = 0;
            try {
                // nhap dia chi email va password
                code = SendEmailConfim.send("diachi_email","matkhau_email",us.getEmail());
                session.setAttribute("code", code+"");
            } catch (MessagingException ex) {
                Logger.getLogger(ForgotPassServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            RequestDispatcher rd = req.getRequestDispatcher("/customer/forgotPass.jsp");
            rd.forward(req, resp);
        } else {
            req.setAttribute("message", "Tài khoản không tồn tại! Xin vui lòng nhập lại");
            RequestDispatcher rd = req.getRequestDispatcher("/customer/forgotPass-findUser.jsp");
            rd.forward(req, resp);
        }
    }
}

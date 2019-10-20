/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerController;

import DAO.UserIO;
import Model.PasswordEncoder;
import Model.SendEmailConfim;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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
@WebServlet(urlPatterns = {"/customer/getconfim"})
public class GetConfimServlet extends HttpServlet {

    private UserIO userIO = new UserIO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("email");
        int code = 0;
        try {
            code = SendEmailConfim.send("tiennd2503@gmail.com", "Tjeens03251997", email);
            session.setAttribute("code", code+"");
        } catch (MessagingException ex) {
            Logger.getLogger(ForgotPassServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher rd = req.getRequestDispatcher("/customer/forgotPass.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String codeEmail = (String) session.getAttribute("code");
        String user = req.getParameter("user");
        String newpass = req.getParameter("newpass");
        String salt = (String) session.getAttribute("salt");
        String codeInput = req.getParameter("code");
        if (codeEmail.equals(codeInput)) {
            try {
                String encoderPass = PasswordEncoder.encoder(newpass + salt);
                UserIO.updatePass(user, encoderPass);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(GetConfimServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            session.invalidate();
            HttpSession ss = req.getSession();
            ss.setAttribute("user", userIO.getByName(user));
            resp.sendRedirect("/");
        } else {
            req.setAttribute("codeconfim", "Mã xác minh nhập không chính xác");
            RequestDispatcher rd = req.getRequestDispatcher("/customer/forgotPass.jsp");
            rd.forward(req, resp);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerController;

import DAO.UserIO;
import Model.PasswordEncoder;
import Model.User;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(urlPatterns = {"/customer/logined/pass"})
public class ChangePassServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/customer/changePass.jsp");
        rd.forward(req, resp);
    }
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oldpass = req.getParameter("oldpass");
        String newpass = req.getParameter("newpass");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        try {
            if (PasswordEncoder.encoder(oldpass + user.getSaltEncoder()).equals(user.getPass())) {
                String pass = PasswordEncoder.encoder(newpass + user.getSaltEncoder());
                UserIO.updatePass(user.getUser(), pass);
                resp.sendRedirect("/");
            } else {
                resp.sendRedirect("/customer/logined/pass?message=cap nhat mat khau khong thanh cong");
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ChangePassServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

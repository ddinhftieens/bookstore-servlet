/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserController;

import DAO.UserIO;
import Model.PasswordEncoder;
import Model.SaltEncoder;
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
@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

    private UserIO userIO = new UserIO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/user/register.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        String user = req.getParameter("user");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        String lastName = req.getParameter("lastName");
        String firstName = req.getParameter("firstName");
        String address = req.getParameter("address");
        User us = new User();
        us.setUser(user);
        us.setSaltEncoder(SaltEncoder.salt());
        try {
            us.setPass(PasswordEncoder.encoder(pass + us.getSaltEncoder()));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        us.setFristName(firstName);
        us.setLastName(lastName);
        us.setAddress(address);
        us.setPhone(phone);
        us.setEmail(email);
        us.setRole("ROLE_USER");
        if (userIO.checkUser(user, phone, email)) {
            resp.sendRedirect("/register?message=register error");
        } else {
            userIO.add(us);
            resp.sendRedirect("/");
        }
    }
}

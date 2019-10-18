/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserController;

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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dell
 */
@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    private UserIO userIO = new UserIO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/user/login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String pass = req.getParameter("pass");
        String remember = req.getParameter("remember");
        User us = userIO.getByName(user);
        if (us.getUser() == null) {
            resp.sendRedirect("/login?message=login error");
        } else {
            try {
                String s = PasswordEncoder.encoder(pass + us.getSaltEncoder());
                if (s.equals(us.getPass())) {
                    if (remember != null && remember.equals("remember")) {
                        Cookie cookie = new Cookie("userName", user);
                        cookie.setMaxAge(60 * 60 * 24 * 30);
                        cookie.setPath("/");
                        resp.addCookie(cookie);
                    } else {
                        HttpSession session = req.getSession();
                        session.setAttribute("user", us);
                    }
                    resp.sendRedirect("");
                } else {
                    resp.sendRedirect("/login?message=login error");
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

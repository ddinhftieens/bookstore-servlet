/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserController;

import Model.User;
import java.io.IOException;
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
@WebServlet(urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession ss = req.getSession();
        User user = (User) ss.getAttribute("user");
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getValue().equals(user.getUser())){
                cookie.setMaxAge(0);
                cookie.setPath("/");
                resp.addCookie(cookie);
                break;
            }
        }
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect("");
    }
    
}

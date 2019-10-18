/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerController;

import Model.Cart;
import java.io.IOException;
import java.util.Map;
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
@WebServlet(urlPatterns = {"/customer/cart/delete"})
public class DeleteProductFromCart extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String IDproduct = req.getParameter("IDproduct");
        HttpSession session = req.getSession();
        Map<Integer,Cart> mapCart = (Map<Integer,Cart>) session.getAttribute("cart");
        mapCart.remove(Integer.parseInt(IDproduct));
        session.setAttribute("cart", mapCart);
        resp.sendRedirect("/customer/cart");
    }
    
}

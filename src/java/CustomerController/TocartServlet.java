/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerController;

import DAO.ProductImpl;
import Model.Cart;
import Model.Product;
import java.io.IOException;
import java.util.HashMap;
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
@WebServlet(urlPatterns = {"/customer/tocart"})
public class TocartServlet extends HttpServlet{
    private ProductImpl productImpl = new ProductImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String IDproduct = req.getParameter("IDproduct");
        String quantity = req.getParameter("quantity");
        Product product = productImpl.getByID(Integer.parseInt(IDproduct));
        Cart cart = new Cart();
        cart.setIDproduct(product.getID());
        cart.setIDcode(product.getIDcode());
        cart.setName(product.getNameBook());
        cart.setPrice(product.getPrice()-(product.getPrice()*product.getSale())/100);
        cart.setQuantity(Integer.parseInt(quantity));
        cart.setTotalPrice(cart.getPrice()*cart.getQuantity());
        HttpSession session = req.getSession();
        Object object = session.getAttribute("cart");
        if(object==null){
            Map<Integer,Cart> mapCart = new HashMap<>();
            mapCart.put(Integer.parseInt(IDproduct),cart);
            session.setAttribute("cart", mapCart);
        }
        else{
            Map<Integer,Cart> mapCart = (Map<Integer,Cart>) object;
            mapCart.put(Integer.parseInt(IDproduct), cart);
            session.setAttribute("cart", mapCart);
        }
        resp.sendRedirect("/customer/cart");
    }   
}

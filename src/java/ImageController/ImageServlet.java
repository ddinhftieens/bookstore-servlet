/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImageController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
@WebServlet(urlPatterns = {"/image/product"})
public class ImageServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String UPLOAD = "D:\\LTWeb\\product";
        String IDcode = req.getParameter("IDcode");
        File file = new File(UPLOAD+File.separator+IDcode+".jpg");
        if(file.exists()){
            try {
                Files.copy(file.toPath(),resp.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}

package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ttt on 22.08.2017.
 */
@WebServlet(name = "Folders")
public class Folders extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nameFolder = (String) request.getAttribute("name");
//        String nameFolder = "you";
        response.getWriter().write(nameFolder + " 4mo");
    }
}

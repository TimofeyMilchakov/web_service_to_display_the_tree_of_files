package servlets;

import javax.servlet.ServletException;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameFolder = (String) request.getParameter("data");
        StringBuilder htmlText = new StringBuilder();
        htmlText.
                append("<li>" +
                        "div id =\""+nameFolder+"-div\">"+
                        "<i class=\"fa fa-angle-right\" aria-hidden=\"true\" id=\"sub"+nameFolder+"\" onclick=\"getSubfolders('sub"+ nameFolder +"','sub"+nameFolder+"')\"></i>"+

                        "<i class=\"fa fa-folder-o\" onclick=\"colorFolder('sub"+nameFolder+"')\" id=\"sub"+nameFolder+"-folder\" aria-hidden=\"true\">sub"+nameFolder+"</i>" +
                        "<ul id=\"sub"+nameFolder+"-list\">" +
                        "</ul>"+
                        "</div>"+
                        "</li>");
        response.getWriter().write(htmlText.toString());
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder fiestFolder = new StringBuilder();
        fiestFolder.
                append( "<i class=\"fa fa-angle-right\" aria-hidden=\"true\" id=\"fiestFolder\" onclick=\"getSubfolders('name2','fiestFolder')\"></i>"+

                        "<i class=\"fa fa-folder-o\" id=\"fiestFolder-folder\" aria-hidden=\"true\">fiestFolder</i>" +
                        "<ul id=\"fiestFolder-list\">" +
                        "</ul>");
        resp.getWriter().write(fiestFolder.toString());
    }
}

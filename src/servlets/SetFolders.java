package servlets;

import Models.FolderEntity;
import Repositories.FolderRepositories;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebService(name = "SetFolders")
public class SetFolders extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FolderEntity newFolder = new FolderEntity();
        newFolder.setParent_id(Integer.parseInt(req.getParameter("parent_id")));
        newFolder.setName(req.getParameter("name"));
        FolderRepositories.addFolder(newFolder);
        newFolder = FolderRepositories.getFolden(newFolder.getParent_id(),newFolder.getName());
        StringBuilder htmlText = new StringBuilder();
        String nameFolder = newFolder.getName();
        int id = newFolder.getId();
        htmlText.
                append("<li id =\"" + id + "-li\">" +
//                        "div id =\"" + id + "-div\">" +
                        "<i class=\"fa fa-angle-right\" aria-hidden=\"true\" id=\"" + id + "\" onclick=\"getSubfolders('" + id + "')\"></i>" +
                        "<i class=\"fa fa-spinner fa-spin\" id=\""+ id +"-spinner\" style=\"display: none;\" aria-hidden=\"true\"></i>"+
                        "<i class=\"fa fa-folder-o\" onclick=\"colorFolder('" + id + "')\" id=\"" + id + "-folder\" aria-hidden=\"true\">" + nameFolder + "</i>" +
                        "<ul id=\"" + id + "-list\">" +
                        "</ul>" +
//                        "</div>" +
                        "</li>");
        resp.getWriter().write(htmlText.toString());

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        FolderEntity newFolder = FolderRepositories.getFolden(Integer.parseInt(req.getParameter("id")));
//        newFolder.setId(Integer.parseInt(req.getParameter("id")));
        newFolder.setName(req.getParameter("name"));
        FolderRepositories.upDateFolder(newFolder);
    }
}

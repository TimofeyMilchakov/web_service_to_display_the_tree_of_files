package servlets;

import Models.FolderEntity;
import Repositories.FolderRepositories;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ttt on 22.08.2017.
 */
@WebServlet(name = "Folders")
public class Folders extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idFolder = (String) request.getParameter("id");
        ArrayList<FolderEntity> childFolder = FolderRepositories.getChildren(Integer.parseInt(idFolder));
        StringBuilder htmlText = new StringBuilder();
        for (int i = 0; i < childFolder.size(); i++) {
            String nameFolder = childFolder.get(i).getName();
            int id = childFolder.get(i).getId();
            htmlText.
                    append("<li id =\"" + id + "-li\">" +
//                            "div id =\"" + id + "-div\">" +
                            "<i class=\"fa fa-angle-right\" aria-hidden=\"true\" id=\"" + id + "\" onclick=\"getSubfolders('" + id + "')\"></i>" +
                            "<i class=\"fa fa-spinner fa-spin\" id=\"" + id + "-spinner\" style=\"display: none;\" aria-hidden=\"true\"></i>" +
                            "<i class=\"fa fa-folder-o\" onclick=\"colorFolder('" + id + "')\" id=\"" + id + "-folder\"  aria-hidden=\"true\">" + nameFolder + "</i>" +
                            "<ul id=\"" + id + "-list\">" +
                            "</ul>" +
//                            "</div>" +
                            "</li>");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        response.getWriter().write(htmlText.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuilder htmlText = new StringBuilder();

        FolderEntity folderEntity = FolderRepositories.getFolden(1);
        String nameFolder = folderEntity.getName();
        int id = folderEntity.getId();
        htmlText.
                append("<li id =\"" + id + "-li\">" +
//                        "div id =\"" + id + "-div\">" +
                        "<i class=\"fa fa-angle-right\" aria-hidden=\"true\" id=\"" + id + "\" onclick=\"getSubfolders('" + id + "')\"></i>" +
                        "<i class=\"fa fa-spinner fa-spin\" id=\"" + id + "-spinner\" style=\"display: none;\" aria-hidden=\"true\"></i>" +
                        "<i class=\"fa fa-folder-o\" onclick=\"colorFolder('" + id + "')\" id=\"" + id + "-folder\" aria-hidden=\"true\">" + nameFolder + "</i>" +
                        "<ul id=\"" + id + "-list\">" +
                        "</ul>" +
//                        "</div>" +
                        "</li>");
        response.getWriter().write(htmlText.toString());
    }


}

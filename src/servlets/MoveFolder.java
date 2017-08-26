package servlets;

import Models.FolderEntity;
import Repositories.FolderRepositories;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MoveFolder")
public class MoveFolder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameFolder = request.getParameter("name");
        String newPart = request.getParameter("part");
        FolderEntity newFolder = FolderRepositories.getFolden(Integer.parseInt(nameFolder));
//        newFolder.setId(Integer.parseInt(nameFolder));
        newFolder.setParent_id(Integer.parseInt(newPart));
        FolderRepositories.upDateFolder(newFolder);
    }
}

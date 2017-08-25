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
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        FolderEntity newFolder = FolderRepositories.getFolden(Integer.parseInt(req.getParameter("id")));
//        newFolder.setId(Integer.parseInt(req.getParameter("id")));
        newFolder.setName(req.getParameter("name"));
        FolderRepositories.upDateFolder(newFolder);
    }
}

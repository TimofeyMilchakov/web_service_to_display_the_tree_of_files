package servlets;

import Models.FolderEntity;
import Repositories.FolderRepositories;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebService(name = "DeleteFolders")
public class DeleteFolders extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        ArrayList<FolderEntity> deleteList=new ArrayList<>();
        deleteList.add(FolderRepositories.getFolden(id));
        while (deleteList.size()!=0){
            FolderEntity tempFolder = deleteList.remove(0);
            deleteList.addAll(FolderRepositories.getChildren(tempFolder.getId()));
            FolderRepositories.deleteFolder(tempFolder.getId());
//            deleteList.remove(tempFolder);
        }
    }
}

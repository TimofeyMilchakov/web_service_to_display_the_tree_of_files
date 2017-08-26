package servlets;

import Repositories.FolderRepositories;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ttt on 27.08.2017.
 */
public class returnInfo extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        resp.getWriter().write(FolderRepositories.getChildren(id).size());

    }
}

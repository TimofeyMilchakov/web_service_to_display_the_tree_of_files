package Repositories;

import DBTools.HibernateUtil;
import Models.FolderEntity;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ttt on 24.08.2017.
 */
public class FolderRepositories {
    public static ArrayList<FolderEntity> getAll(){
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List allItems = session.createQuery("FROM FolderEntity ").list();
        ArrayList<FolderEntity> folderEntities = (ArrayList<FolderEntity>) allItems;
        session.getTransaction().commit();
        session.close();
        return folderEntities;
    }
}

package Repositories;

import DBTools.HibernateUtil;
import Models.FolderEntity;
import org.hibernate.Session;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ttt on 24.08.2017.
 */
public class FolderRepositories {

    public static ArrayList<FolderEntity> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List allItems = session.createQuery("FROM FolderEntity ").list();
        ArrayList<FolderEntity> folderEntities = (ArrayList<FolderEntity>) allItems;
        session.getTransaction().commit();
        session.close();
        return folderEntities;
    }

    public static ArrayList<FolderEntity> getChildren(int parent_id ){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ArrayList<FolderEntity> childItem = (ArrayList<FolderEntity>) session.createQuery("from FolderEntity WHERE FolderEntity.parent_id="+parent_id).list();
        session.getTransaction().commit();
        session.close();
        return childItem;
    }

    public static FolderEntity getFolden(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List folderEntity = session.createQuery("FROM  FolderEntity WHERE FolderEntity.id="+id).list();
        session.getTransaction().commit();
        session.close();
        return (FolderEntity) folderEntity.get(0);
    }

    public static void moveFolder(int idFolden, int newIdParent){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("UPDATE FolderEntity set FolderEntity.parent_id=:newParent where FolderEntity.id=:id")
                .setString("newParent", String.valueOf(newIdParent))
                .setString("id", String.valueOf(idFolden))
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public static void deleteFolder(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("delete FolderEntity where FolderEntity .id="+id);
        session.getTransaction().commit();
        session.close();

    }

    public static void addFolder(int idParent,String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        FolderEntity folderEntity = new FolderEntity();
        folderEntity.setId(null);
        folderEntity.setName(name);
        folderEntity.setParent_id(idParent);
        session.save(folderEntity);

    }
}

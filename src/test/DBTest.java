import Models.FolderEntity;
import Repositories.FolderRepositories;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by ttt on 24.08.2017.
 */
public class DBTest {
    @Test
    public void testConnectDB(){
        ArrayList<FolderEntity> folderEntities = FolderRepositories.getAll();
    }

    @Test
    public void testSetAndGet(){
//        FolderRepositories.addFolder(1,"cild1");
//        FolderRepositories.addFolder(1,"cild2");
//        FolderRepositories.getChildren(1);
//        FolderRepositories.getFolden(1);
        FolderRepositories.getFolden(10,"sdas");
        FolderEntity folderEntity = new FolderEntity();
        folderEntity.setParent_id(10);
        folderEntity.setName("sdas");
        FolderRepositories.addFolder(folderEntity);
    }

    @Test
    public void testMoveFolder(){
//        FolderRepositories.upDateFolder();
        FolderRepositories.deleteFolder(5);
    }
}

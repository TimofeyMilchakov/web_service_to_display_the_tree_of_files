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
        Assert.assertEquals(1,folderEntities.size());
    }

    @Test
    public void testSetAndGet(){
//        FolderRepositories.addFolder(1,"cild1");
//        FolderRepositories.addFolder(1,"cild2");
        FolderRepositories.getChildren(1);
        FolderRepositories.getFolden(1);
    }

    @Test
    public void testMoveFolder(){
//        FolderRepositories.upDateFolder();
        FolderRepositories.deleteFolder(5);
    }
}

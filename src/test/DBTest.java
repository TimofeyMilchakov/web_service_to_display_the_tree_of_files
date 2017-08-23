package test;

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
        Assert.assertEquals(9,folderEntities.size());
    }

}

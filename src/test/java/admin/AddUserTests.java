package admin;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AdminPage;


public class AddUserTests extends BaseTests {

    public AdminPage adminPage;

    @BeforeClass
    public void navigate2Admin(){
        dashboard.navigate2adminPage();
        adminPage = new AdminPage(driver);
    }


    @Test
    public void testAddUser(){
        adminPage.addNewUser();
        Assert.assertTrue(adminPage.isUserSaved(), "User creation failed!");
    }



}

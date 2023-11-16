package PIM;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PIMPage;

public class AddEmployeeTests extends BaseTests {

    public PIMPage pimPage;

    @BeforeClass
    public void navigate2PIM(){
        dashboard.navigate2PIMPage();
        pimPage = new PIMPage(driver);
    }


    @Test
    public void testAddEmployee(){
        pimPage.addEmployee();
        Assert.assertTrue(pimPage.isEmployeeSaved(), "Employee creation failed!");
    }





}

package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.*;



public class LoginTests extends BaseTests{

    @BeforeClass
    public void logout(){
        loginPage.logout();
    }

    @Test
    public void testLogin(){
        loginPage.login(false);
        Assert.assertTrue(loginPage.isLoginSuccess(), "Login Failed!");
    }


}

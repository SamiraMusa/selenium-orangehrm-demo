package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {

    public  String  baseURL = "https://opensource-demo.orangehrmlive.com/";
    public WebDriver driver;
    public ChromeOptions op = new ChromeOptions();
    public LoginPage loginPage;

    @BeforeTest
    public void launchWebsite(){
        op.addArguments("--remote-allow-origins=*","--start-maximized");
        driver  = new ChromeDriver(op);
        driver.get(baseURL);
        loginPage = new LoginPage(driver);

    }


    @Test
    public void testLogin(){
        loginPage.getCred();
        loginPage.login();
        Assert.assertTrue(loginPage.isLogginSuccess(), "Login failed!");
    }


    @AfterTest
    public void closeWebsite(){
        driver.close();
    }


}

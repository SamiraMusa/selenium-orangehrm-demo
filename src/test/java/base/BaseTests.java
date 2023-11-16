package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.DashboardPage;
import pages.LoginPage;



public class BaseTests {

    public  String  baseURL = "https://opensource-demo.orangehrmlive.com/";
    public static WebDriver driver;
    public ChromeOptions op = new ChromeOptions();
    public static LoginPage loginPage;
    public static DashboardPage dashboard;

    @BeforeSuite
    public void launchWebsite(){
        op.addArguments("--remote-allow-origins=*","--start-maximized");
        driver  = new ChromeDriver(op);
        driver.get(baseURL);
        loginPage = new LoginPage(driver);
        dashboard = new DashboardPage(driver);
        loginPage.login(true);
    }


    @AfterSuite
    public void closeWebsite(){
        driver.close();
    }

}

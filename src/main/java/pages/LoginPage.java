package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginPage {
    public WebDriver driver;
    private By usernameLocator = By.name("username");
    private By passwordLocator = By.name("password");
    private By loginButtonLocator = By.xpath("//div/button");
    private By  logo = By.cssSelector(".oxd-brand-banner");
    private By  userCredLocator = By.cssSelector(".orangehrm-demo-credentials > p:first-child");
    private By  passCredLocator = By.cssSelector(".orangehrm-demo-credentials > p:nth-of-type(2)");
    String  username;
    String password;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void getCred(){
        username = driver.findElement(userCredLocator).getText();
        password = driver.findElement(passCredLocator).getText();

        username = username.replace("Username : ","");
        password = password.replace("Password : ","");

    }

    public void login(){
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }

    public boolean isLogginSuccess(){
        return !driver.findElements(logo).isEmpty();
    }

}

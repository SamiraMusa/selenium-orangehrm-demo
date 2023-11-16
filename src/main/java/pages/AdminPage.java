package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;

public class AdminPage {

    WebDriver driver;
    private By  addUserButtonLocator = By.xpath("//div[2]/div/div[2]/div/button");
    private By  userRoleDropdown = By.xpath("//div/div/div/div[2]/div/div/div");
    private By  essRoleLocator  = By.xpath("//div[@class='oxd-select-wrapper']/div/div[contains(.,'ESS')]");
    private By  employeenameLocator = By.xpath("//input[@placeholder='Type for hints...']");
    private By  employeeOption = By.xpath("//div[@role='option'][1]");
    private By  statusDropdown  =   By.xpath("//div[3]/div/div[2]/div/div/div");
    private By  usernameLocator =   By.xpath("//div[@class='oxd-form-row']//div[4]//input");
    private By  passwordLocator =   By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//input");
    private By  confirmpassword = By.xpath("//div[@class='oxd-form-row user-password-row']//div[@class='oxd-grid-item oxd-grid-item--gutters']//input");
    private By  saveButtonLocator   = By.xpath("//button[@type='submit']");
    private By  successMsg  =   By.xpath("//p[contains(.,'Successfully Saved')]");


    public AdminPage(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    public void navigate2addUser(){
        driver.findElement(addUserButtonLocator).click();
    }
    public void addNewUser(){
        navigate2addUser();
        driver.findElement(userRoleDropdown).click();
        driver.findElement(essRoleLocator).click();

        driver.findElement(employeenameLocator).sendKeys("Sam  Smith");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@role='listbox']//div[contains(.,'Search')]"))));
        driver.findElement(employeeOption).click();

        driver.findElement(statusDropdown).click();
        driver.findElement(statusDropdown).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(statusDropdown).sendKeys(Keys.ENTER);

        driver.findElement(usernameLocator).sendKeys("test_user");

        driver.findElement(passwordLocator).sendKeys("P@ssw0rd");
        driver.findElement(confirmpassword).sendKeys("P@ssw0rd");

        driver.findElement(saveButtonLocator).click();

    }

    public boolean isUserSaved(){
        return !driver.findElements(successMsg).isEmpty();
    }

}

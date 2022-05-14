package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity6 {

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");

    }
    @Test
    @Parameters({"username","password"})
    public void loginForm(String username,String password){

        //Find the login input fields - username and password
        WebElement userName = driver.findElement(By.id("username"));
        WebElement pwd = driver.findElement(By.id("password"));
        WebElement loginIn = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        //Enter the credentials - admin and password - and click the "Log in" button.
        userName.clear();
        userName.isEnabled();
        userName.sendKeys(username);
        pwd.clear();
        pwd.isEnabled();
        pwd.sendKeys(password);
        loginIn.isEnabled();
        loginIn.click();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

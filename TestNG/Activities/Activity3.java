package Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity3 {

    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp(){

        driver  = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.training-support.net/selenium/login-form");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public  void loginForm(){
        //Find the login input fields - username and password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        WebElement userName = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginIn = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        //Enter the credentials - admin and password - and click the "Log in" button.
        userName.clear();
        userName.isEnabled();
        userName.sendKeys("admin");
        password.clear();
        password.isEnabled();
        password.sendKeys("password");
        loginIn.isEnabled();
        loginIn.click();

        //Read the confirmation message and make and assertion to check if the correct message has been printed
        String actualMessage = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(actualMessage,"Welcome Back, admin");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

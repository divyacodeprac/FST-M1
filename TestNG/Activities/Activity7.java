package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));

    }

    @DataProvider(name = "Authentication")
    public static Object[][] credentials(){
        return  new Object[][]{
                {"admin","password"}
        };
    }

    @Test(dataProvider =  "Authentication")
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

package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity1 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Navigate to ‘http://alchemy.hguy.co/orangehrm
        driver.get("http://alchemy.hguy.co/orangehrm");
        Reporter.log("Opened the application url ");
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    @Test
    public  void pageTitle(){
        //Get the title of the website
        String title = driver.getTitle();
        System.out.println("Actual Title : "+title);
        Reporter.log("Title of the page is : " +title);
        //Make sure it matches “OrangeHRM” exactly
        Assert.assertEquals(title,"OrangeHRM");

    }
    @AfterTest
    public void tearDown(){
        //If it matches, close the browser
        driver.quit();
    }

}

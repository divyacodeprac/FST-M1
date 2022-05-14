package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity1 {

    WebDriver driver;
    @BeforeTest
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
        driver.manage().window().maximize();
    }

    @Test
    public  void  launchApplication(){
        //Use getTitle() to get and print the title of the page
        String title = driver.getTitle();
        System.out.println("Title of the page is  "+ title);
        Assert.assertEquals(title,"Training Support");

        //Use findElement() to find the "About Us" Button on the page and click it
        WebElement aboutUsbtn = driver.findElement(By.id("about-link"));
        aboutUsbtn.isEnabled();
        aboutUsbtn.click();

        //Get and print the title of the new page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'About Us')]")));
        String newTitle = driver.getTitle();
        System.out.println("New title of page is : " +newTitle);
        Assert.assertEquals(newTitle,"About Training Support");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

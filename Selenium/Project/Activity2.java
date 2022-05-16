package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity2 {
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
    public void headerImage(){
        //Get the url of the header image
       WebElement headerImage = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
       String headerUrl = headerImage.getAttribute("src");
       //Print the url to the console.
        System.out.println("Header Image url : " +headerUrl);
        Reporter.log("Url of the header image is : " +headerUrl);
    }
    @AfterTest
    public void tearDown(){
        //If it matches, close the browser
        driver.quit();
    }
}

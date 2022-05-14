package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.SkipException;

public class Activity2 {

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver  = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }
    @Test
    public void firstMethod(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"Target Practice");
    }

    @Test
    public  void secondMethod(){
        WebElement blackButton = driver.findElement(By.xpath("//button[contains(text(),'Black')]"));
        Assert.assertEquals(blackButton.getText(),"Green");
    }

    @Test(enabled = false)
    public void thirdMethod(){
        System.out.println("The third method will be skipped, but will not be shown as skipped");
    }

    @Test
    public void fourthMethod () throws  SkipException {
        throw new SkipException("The fourth method will be skipped and it will be shown as skipped.");

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

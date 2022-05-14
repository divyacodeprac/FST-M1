package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity10 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUp(){
        driver = new FirefoxDriver();
        Reporter.log("Launching application");
        driver.manage().window().maximize();
        driver.get("https://www.training-support.net/selenium/sliders");
        Reporter.log("Application logged");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test()
    public void maxValue(){

        WebElement slider = driver.findElement(By.id("slider"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(75,0).release().build().perform();
        String volumeLevel = driver.findElement(By.id("value")).getText();
        Reporter.log("Max value: " + volumeLevel);
        Assert.assertEquals(volumeLevel, "100");
    }

    @Test
    public void middleValue(){
        WebElement slider = driver.findElement(By.id("slider"));
       slider.click();
        String volumeLevel = driver.findElement(By.id("value")).getText();
        Reporter.log("Middle value: " + volumeLevel);
        Assert.assertEquals(volumeLevel, "50");
    }

    @Test
    public void minValue(){
        WebElement slider = driver.findElement(By.id("slider"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(-75,0).release().build().perform();
        String volumeLevel = driver.findElement(By.id("value")).getText();
        Reporter.log("Min value: " + volumeLevel);
        Assert.assertEquals(volumeLevel, "0");
    }

    @Test
    public void Value30(){
        WebElement slider = driver.findElement(By.id("slider"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(-30,0).release().build().perform();
        String volumeLevel = driver.findElement(By.id("value")).getText();
        Reporter.log("Min value: " + volumeLevel);
        Assert.assertEquals(volumeLevel, "30");
    }

    @Test
    public void Value80(){
        WebElement slider = driver.findElement(By.id("slider"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(45,0).release().build().perform();
        String volumeLevel = driver.findElement(By.id("value")).getText();
        Reporter.log("Min value: " + volumeLevel);
        Assert.assertEquals(volumeLevel, "80");
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}

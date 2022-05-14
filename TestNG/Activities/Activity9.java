package Activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity9 {

        WebDriver driver;
        WebDriverWait wait;

        @BeforeTest
        public void setUp(){
            driver = new FirefoxDriver();
            Reporter.log("Launching application");
            driver.manage().window().maximize();
            driver.get("https://www.training-support.net/selenium/javascript-alerts");
            Reporter.log("Application logged");
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        @Test(priority = 0)
        public void simpleAlertTestCase(){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'JavaScript Alert Generator')]")));
            Reporter.log("simpleAlertTestCase() started |");
            WebElement simpleAlert = driver.findElement(By.id("simple"));
            simpleAlert.click();
            Reporter.log("Simple Alert opened");
            Alert alert = driver.switchTo().alert();
            String simpleAlertText = alert.getText();
            System.out.println("Simple Alert Text : " +simpleAlertText);
            Assert.assertEquals("This is a JavaScript Alert!", simpleAlertText);
            alert.accept();
            Reporter.log("Closed the Simple Alert");
            Reporter.log("simpleAlertTestCase() ended |");
        }

        @Test(priority = 1)
        public void confirmAlertTestCase(){
            Reporter.log("confirmAlertTestCase() started |");
            WebElement confirmAlert = driver.findElement(By.id("confirm"));
            confirmAlert.click();

            Alert alert = driver.switchTo().alert();
            Reporter.log("Confirm Alert opened");
            String confirmAlertText = alert.getText();
            System.out.println("confirmAlert Alert Text : " +confirmAlertText);
            Assert.assertEquals("This is a JavaScript Confirmation!", confirmAlertText);
            alert.accept();
            Reporter.log("Closed the confirm Alert");
            Reporter.log("confirmAlertTestCase() ended |");
        }

        @Test(priority = 2)
        public void promptAlertTestCase(){
            Reporter.log("promptAlertTestCase() started |");
            WebElement prompt = driver.findElement(By.id("prompt"));
            prompt.click();
            Alert alert = driver.switchTo().alert();
            Reporter.log("Entering text in prompt Alert input field");
           alert.sendKeys("This is prompt Alert ");
           alert.accept();
            Reporter.log("promptAlertTestCase() ended |");
        }
        @BeforeMethod
        public void switchToDefault(){
            driver.switchTo().defaultContent();
        }
        @AfterTest
        public void tearDown(){
            driver.quit();
        }
}

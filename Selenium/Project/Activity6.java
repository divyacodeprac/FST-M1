package project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity6 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Navigate to ‘http://alchemy.hguy.co/orangehrm
        driver.get("http://alchemy.hguy.co/orangehrm");
        Reporter.log("Launched application");
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    @Test(priority = 0)
    public  void login()
    {
        //Find and select the username and password fields
        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement pwd = driver.findElement(By.id("txtPassword"));
        //Enter login credentials into the respective fields
        username.isEnabled();
        pwd.isEnabled();
        username.sendKeys("orange");
        pwd.sendKeys("orangepassword123");
        Reporter.log("Entered user name and password");
        WebElement login = driver.findElement(By.id("btnLogin"));
        login.click();
        Reporter.log("Clicked on login button");
        //Verify that the homepage has opened
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wrapper")));
        Assert.assertTrue(driver.findElement(By.className("menu")).isDisplayed());
        Reporter.log("Home page is launched");

    }

    @Test(priority = 1)
    public void directoryMenu(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_dashboard_index")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Dashboard')]")));
        Reporter.log("Locate the navigation menu");
        //Locate the navigation menu.
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_directory_viewDirectory")));
        WebElement directoryMenu = driver.findElement(By.id("menu_directory_viewDirectory"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", directoryMenu);
        Reporter.log("Clicked on the Directory Menu");
        //Verify that the “Directory” menu item is visible and clickable
        Reporter.log("Verify that the “Directory” menu item is visible and clickable");
        directoryMenu.isDisplayed();
        directoryMenu.isEnabled();
        Reporter.log("Directory Menu Item is diplayed and clickable");
        //If clickable, click on the menu item.
        directoryMenu.click();
        Reporter.log("Directory Menu Item is clicked");
        //Verify that the heading of the page matches “Search Directory
        Reporter.log("Heading of the page matches Search Directory");
        WebElement searchDirectory = driver.findElement(By.xpath("//h1[contains(text(),'Search Directory')]"));
       wait.until(ExpectedConditions.textToBePresentInElement(searchDirectory,"Search Directory"));
       Reporter.log("Search Directory Heading is displayed");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}

package project;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity9 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Navigate to ‘http://alchemy.hguy.co/orangehrm
        driver.get("http://alchemy.hguy.co/orangehrm");
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        Reporter.log("Application is launched");
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
        Reporter.log("Clicked on login");
        //Verify that the homepage has opened
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wrapper")));
        Assert.assertTrue(driver.findElement(By.className("menu")).isDisplayed());
        Reporter.log("Home Page is launched");
    }

    @Test(priority = 1)
    public void emergencyContacts(){
        //Find the PIM option in the menu and click it.

        Reporter.log("Dashboard page is displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_dashboard_index")));
        WebElement myInfo = driver.findElement(By.id("menu_pim_viewMyDetails"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", myInfo);
        Reporter.log("Clicked My Info Menu Item");

        //On the new page, find the Qualification option on the left side menu and click it
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personal_txtEmpFirstName")));
        WebElement emergencyContact = driver.findElement(By.linkText("Emergency Contacts"));
        emergencyContact.click();
        Reporter.log("Clicked on Emergency Contacts link");

        //Retrieve information about all the contacts listed in the table
        List<WebElement> emergencyContacts = driver.findElements(By.xpath("//table[@id='emgcontact_list']//tbody//tr"));
        System.out.println("Size of emergency contact list : "+emergencyContacts.size());
        for(int i = 1;i<=emergencyContacts.size();i++){
            String contact = driver.findElement(By.xpath("//table[@id='emgcontact_list']//tbody//tr["+i+"]//td[last()-1]")).getText();
            System.out.println("Contact is : " +contact);
        }
        Reporter.log("Retrieved all contact information");
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}

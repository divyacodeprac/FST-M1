package project;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity5 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Navigate to ‘http://alchemy.hguy.co/orangehrm
        driver.get("http://alchemy.hguy.co/orangehrm");
        Reporter.log("Application launched");
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
        Reporter.log("Clicked on login");
        //Verify that the homepage has opened
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wrapper")));
        Assert.assertTrue(driver.findElement(By.className("menu")).isDisplayed());
        Reporter.log("Home Page is launched");

    }
    @Test(priority = 1)
    public void editUserInfo(){
        //Find the PIM option in the menu and click it.
        Reporter.log("Dashboard page is displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_dashboard_index")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Dashboard')]")));
        WebElement myInfo = driver.findElement(By.id("menu_pim_viewMyDetails"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", myInfo);
        Reporter.log("Clicked My Info Menu Item");
        //On the new page, click the Edit button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Edit']")));
        WebElement editBtn = driver.findElement(By.xpath("//input[@value='Edit']"));
        editBtn.click();
        Reporter.log("Clicked on Edit button ");
        //Fill in the Name, Gender, Nationality, and the DOB fields
        WebElement firstName = driver.findElement(By.id("personal_txtEmpFirstName"));
        WebElement lastName = driver.findElement(By.id("personal_txtEmpLastName"));
        WebElement gender = driver.findElement(By.id("personal_optGender_2"));
        WebElement nation = driver.findElement(By.id("personal_cmbNation"));
        Select nationality = new Select(nation);
        WebElement dob = driver.findElement(By.id("personal_DOB"));
        firstName.clear();
        firstName.sendKeys("Activity5_FirstName");
        lastName.clear();
        lastName.sendKeys("Activity5_LastName");
        gender.click();
        nationality.selectByVisibleText("Indian");
        dob.clear();
        dob.sendKeys("2000-07-07");
        Reporter.log("Edited the user information");
        WebElement btnSave = driver.findElement(By.id("btnSave"));
        btnSave.click();
        Reporter.log("Clicked on Save after edit information");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Edit']")));
        editBtn = driver.findElement(By.xpath("//input[@value='Edit']"));
        Assert.assertTrue(editBtn.isDisplayed());
        Reporter.log("Saved employee information");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}

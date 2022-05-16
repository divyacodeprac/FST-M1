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

public class Activity7 {

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
        Reporter.log("Home page is launched");

    }
    @Test(priority = 1)
    public void addEmployeeQualification(){
        //Find the PIM option in the menu and click it.
        Reporter.log("Dashboard page is displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_dashboard_index")));
        WebElement myInfo = driver.findElement(By.id("menu_pim_viewMyDetails"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", myInfo);
        Reporter.log("Clicked My Info Menu Item");

        //On the new page, find the Qualification option on the left side menu and click it
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personal_txtEmpFirstName")));
        WebElement qualificationLink = driver.findElement(By.linkText("Qualifications"));
        qualificationLink.click();
        Reporter.log("Clicked on Qualification link");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addWorkExperience")));
        //Add Work Experience and click Save.
        WebElement addWork = driver.findElement(By.id("addWorkExperience"));
        addWork.click();
        Reporter.log("Adding work experience ");
        WebElement company = driver.findElement(By.id("experience_employer"));
        WebElement jobTitle = driver.findElement(By.id("experience_jobtitle"));
        WebElement comment = driver.findElement(By.id("experience_comments"));
        WebElement fromDate  = driver.findElement(By.id("experience_from_date"));
        WebElement toDate  = driver.findElement(By.id("experience_to_date"));

        String companyName = "Activity_Company";
        company.sendKeys(companyName);
        jobTitle.sendKeys("Activity_JobTitle");
        comment.sendKeys("Activity Test Comments ");
        fromDate.clear();
        toDate.clear();
        fromDate.sendKeys("2020-07-07");
        toDate.sendKeys("2022-07-15");
        comment.click();
        comment.clear();
        comment.sendKeys("Activity comment");
        WebElement saveBtn = driver.findElement(By.id("btnWorkExpSave"));
        saveBtn.click();
        Reporter.log("Added work experience and saved");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td/a[contains(text(),'"+companyName+"')]")));
        WebElement addedCompany = driver.findElement(By.xpath("//td/a[contains(text(),'"+companyName+"')]"));
        Assert.assertTrue(addedCompany.isDisplayed());
        Reporter.log("Work experience is added" +companyName);

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}

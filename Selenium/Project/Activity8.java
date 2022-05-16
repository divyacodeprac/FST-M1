package project;

import org.openqa.selenium.*;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity8 {
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
    public void applyLeave(){
        //Find the PIM option in the menu and click it.
        Reporter.log("Dashboard page is displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_dashboard_index")));
        //Navigate to the Dashboard page and click on the Apply Leave option
        WebElement applyLeave = driver.findElement(By.xpath("//span[contains(text(),'Apply Leave')]/parent::a"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", applyLeave);
        Reporter.log("Apply leave button is clicked");
        //Select leave type and duration of the leave
        wait.until(ExpectedConditions.elementToBeClickable(By.id("applyBtn")));
        Select leaveType = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
        leaveType.selectByValue("1");
        WebElement fromDate = driver.findElement(By.id("applyleave_txtFromDate"));
        WebElement toDate = driver.findElement(By.id("applyleave_txtToDate"));
        WebElement comment = driver.findElement(By.id("applyleave_txtComment"));
        String fromDateLeave ="2021-07-09";
        String toDateLeave = "2021-07-09";
        fromDate.clear();
        fromDate.sendKeys(fromDateLeave);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
        toDate.clear();
        toDate.sendKeys(toDateLeave);
        action.sendKeys(Keys.ENTER).build().perform();
        comment.clear();
        comment.sendKeys("Activity Leave comments");
        driver.findElement(By.id("applyBtn")).click();
        Reporter.log("Leave is applied");
        //Navigate to the My Leave page to check the status of the leave application
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("My Leave")));
        driver.findElement(By.linkText("My Leave")).click();
        driver.findElement(By.id("calFromDate")).clear();
        driver.findElement(By.id("calToDate")).clear();
        driver.findElement(By.id("calFromDate")).sendKeys("2022-05-16");
        driver.findElement(By.id("calToDate")).sendKeys("2022-05-16");
        driver.findElement(By.id("btnSearch")).click();
        Reporter.log("Verify the status of the leave");
        driver.findElement(By.xpath("//table[@id='resultTable']//tbody//td/a[contains(text(),'Pending Approval')]")).isDisplayed();
        Reporter.log("Status of the leave is Pending Approval");
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}

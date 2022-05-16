package project;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity4 {

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
        Reporter.log("Enter user name and password");

        WebElement login = driver.findElement(By.id("btnLogin"));
        login.click();
        Reporter.log("Clicked on login button");

        //Verify that the homepage has opened
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wrapper")));
        Assert.assertTrue(driver.findElement(By.className("menu")).isDisplayed());
        Reporter.log("Home page has opened");

    }

    @Test(priority = 1)
    public void addEmployees(){
        //Find the PIM option in the menu and click it.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_dashboard_index")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewPimModule")));
        WebElement pIM = driver.findElement(By.id("menu_pim_viewPimModule"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", pIM);
        Reporter.log("Clicked PIM menu");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBtn")));
        //Click the Add button to add a new Employee
        WebElement add = driver.findElement(By.name("btnAdd"));
        add.click();
        Reporter.log("Clicked on Add button to new employee");
        //Fill in the required fields and click Save
        wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("Activity_Emp_1_FirstName");
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys("Activity_Emp_1_LastName");
        String empId = driver.findElement(By.id("employeeId")).getAttribute("value");
        System.out.println("Employee Id is : "+empId);
        driver.findElement(By.id("btnSave")).click();
        Reporter.log("Entered the required fields to create a new employee");
        //Navigate back to the PIM page (Employee List tab) and verify the creation of your employee.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewEmployeeList")));
        WebElement employeeList = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        employeeList.click();
        Reporter.log("Search for the details of the employee created");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("searchBtn")));
        driver.findElement(By.id("empsearch_employee_name_empName")).click();
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Activity_Emp_1_FirstName Activity_Emp_1_LastName");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
        driver.findElement(By.id("searchBtn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultTable")));
        String firstName = driver.findElement(By.xpath("//a[contains(text(),'"+empId+"')]/parent::td/following-sibling::td/a")).getText();
        String lastName = driver.findElement(By.xpath("//a[contains(text(),'"+empId+"')]/parent::td/following-sibling::td[2]/a")).getText();
        System.out.println("First Name : " +firstName);
        System.out.println("Last Name : " +lastName);
        Assert.assertEquals(firstName,"Activity_Emp_1_FirstName");
        Assert.assertEquals(lastName,"Activity_Emp_1_LastName");
        Reporter.log("Employee details of the newly created employee is displayed");
    }

        @AfterTest
        public void tearDown(){
        // close the browser
        driver.quit();
    }

}

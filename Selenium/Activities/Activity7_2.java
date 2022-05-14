package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7_2 {
    public static void main(String[] args) {
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        //Open a browser with https://training-support.net/selenium/dynamic-attributes
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        //Get the title of the page using driver.getTitle() and print out the title.
        String title = driver.getTitle();
        System.out.println("Title of the page :"+title);
        driver.manage().window().maximize();
        //Find the input fields of the Sign Up form. Fill in the details in the fields with your own data
        WebElement userName = driver.findElement(By.xpath("//div[contains(text(),'Sign Up!')]/following::input[@placeholder='Username']"));
        WebElement password = driver.findElement(By.xpath("//div[contains(text(),'Sign Up!')]/following::input[@placeholder='Password']"));
        WebElement confirmPassword = driver.findElement(By.xpath("//label[contains(text(),'Confirm Password')]/following-sibling::input"));
        WebElement email = driver.findElement(By.xpath("//label[contains(text(),'Email')]/following-sibling::input"));
        WebElement signUp = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));
        userName.sendKeys("admin1");
        password.sendKeys("password");
        confirmPassword.sendKeys("password");
        email.sendKeys("testmail@mail.com");
        signUp.click();
        //Wait for success message to appear and print it to the console
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='action-confirmation']")));
        WebElement confirmRegister = driver.findElement(By.xpath("//div[@id='action-confirmation']"));
        System.out.println("Confirmation message is :"+confirmRegister.getText());
        driver.quit();


    }
}

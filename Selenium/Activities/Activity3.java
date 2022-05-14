package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Activity3 {

    public static void main(String[] args) {
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        //Open a browser with https://training-support.net/selenium/simple-form
        driver.get("https://www.training-support.net/selenium/simple-form");
        driver.manage().window().maximize();
        //Get the title of the page using driver.getTitle() and print out the title.
        String title = driver.getTitle();
        System.out.println("Title of the page is :" + title);

       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
       //Use findElement() with name() to find the text fields - firstname and lastname
       WebElement firstName = driver.findElement(By.id("firstName"));
       WebElement lastName = driver.findElement(By.id("lastName"));
       //Use WebElement.sendKeys() to type in those text fields
       firstName.sendKeys("Test dat first name");
       lastName.sendKeys("Test data last name");
        //Similarly, find and type into the email and contact number fields.
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("TestData@mail.com");
        WebElement contact = driver.findElement(By.id("number"));
        contact.sendKeys("9989889876");
        //Finally, submit the form by clicking the Submit button.
        WebElement submit = driver.findElement(By.xpath("//input[@value='submit']"));
        submit.click();
        //Close the browser with driver.close()
        driver.quit();
    }

}

package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {

    public static void main(String[] args) {
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        //Open a browser with https://www.training-support.net/selenium/simple-form
        driver.get("https://www.training-support.net/selenium/simple-form");
        //Get the title of the page using driver.getTitle() and print out the title
        String title = driver.getTitle();
        System.out.println("Title of the page is " + title);
        //Use findElement() with xpath() to find all the input fields on the page
        WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
        firstName.sendKeys("Firstname");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
        lastName.sendKeys("LastName");
        WebElement message = driver.findElement(By.xpath("//textarea"));
        message.sendKeys("Sample test message");
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("testmail@mail.com");
        WebElement contact = driver.findElement(By.xpath("//input[@id='number']"));
        contact.sendKeys("7857575757");
        //Click the submit button at the end of the form to submit the form
        WebElement submit = driver.findElement(By.xpath("//input[@value='submit']"));
        submit.click();

    }
}

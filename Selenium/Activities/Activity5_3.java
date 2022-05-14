package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Activity5_3 {
    public static void main(String[] args) {
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        //Launch the web browser and open https://training-support.net/selenium/dynamic-controls using the get() method
        driver.get("https://training-support.net/selenium/dynamic-controls");
        //Get the page title and print it to the console.
        String title = driver.getTitle();
        System.out.println("Title of the page :"+title);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        //Use findElement() to find the text field
        WebElement textField = driver.findElement(By.id("input-text"));
        // //Use the isEnabled() method to check if the text field is enabled.
        System.out.println("Text field is enabled  :" +textField.isEnabled());
        WebElement enableInput = driver.findElement(By.id("toggleInput"));
        //Click the "Enable Input" button to enable the input field.
        enableInput.click();
        //Use the isEnabled() method again and print the result.
        System.out.println("Text field after clicking enable input : "+textField.isEnabled());
        //Close
         driver.quit();
    }
}

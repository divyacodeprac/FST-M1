package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Activity5_1 {
    public static void main(String[] args) {
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        // Launch the web browser and open https://training-support.net/selenium/dynamic-controls using the get() method.
        driver.get("https://training-support.net/selenium/dynamic-controls");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        //Get the page title and print it to the console.
        String title = driver.getTitle();
        System.out.println("Title of the page is : "+ title);
        //Use findElement() to find the checkbox input element.
        WebElement checkBox = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input[@type='checkbox']"));
        //Use the isDisplayed() method to check if it is visible on the page.
        System.out.println("Check Box is displayed on the page : " +checkBox.isDisplayed());
        //Click the "Remove Checkbox".
        WebElement removeButton = driver.findElement(By.id("toggleCheckbox"));
        removeButton.click();
        //Print the result of the isDisplayed() method again.
        System.out.println("Check Box after clicking Remove check box button :" +checkBox.isDisplayed());
        driver.quit();
    }
}

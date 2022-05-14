package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_2 {

    public static void main(String[] args) {
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        // Launch the web browser and open https://training-support.net/selenium/dynamic-controls using the get() method.
        driver.get("https://training-support.net/selenium/dynamic-controls");
        //Get the page title and print it to the console.
        String title = driver.getTitle();
        System.out.println("Title of the page :"+title);
        //Use findElement() to find the checkbox input element.
        WebElement checkBox = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input[@type='checkbox']"));
        System.out.println("Check Box is displayed on the page : " +checkBox.isDisplayed());
        checkBox.click();
        //Use the isSelected() method to check if the checkbox is selected.
        System.out.println("Check box is selected: " +checkBox.isSelected());
        //Click the checkbox to select it.
        checkBox.click();
        //Use the isSelected() method again and print the result.
        System.out.println("Check box is selected after selecting again: " +checkBox.isSelected());
        driver.quit();
    }

}

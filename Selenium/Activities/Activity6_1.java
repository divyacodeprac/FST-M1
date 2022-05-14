package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_1 {
    public static void main(String[] args) {
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        //Open a browser with https://training-support.net/selenium/dynamic-controls
        driver.get("https://training-support.net/selenium/dynamic-controls");
        //Get the title of the page using driver.getTitle() and print out the title.
        String title = driver.getTitle();
        System.out.println("Title of the page : "+title);
        //Find the checkbox toggle button and click it.
        WebElement removeButton = driver.findElement(By.id("toggleCheckbox"));
        removeButton.click();

        WebElement checkBox = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input[@type='checkbox']"));
        //Wait till the checkbox disappears.
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.invisibilityOf(checkBox));
        System.out.println("Check box is displayed :" +checkBox.isDisplayed());
        //Click the button again. Wait till it appears and check the checkbox.
        removeButton.click();
        wait.until(ExpectedConditions.visibilityOf(checkBox));
        System.out.println("check box is present :" +checkBox.isDisplayed());
        checkBox.click();
        //close
        driver.quit();



    }
}

package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Activity9_1 {

    public static void main(String[] args) {
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        //Open the browser with https://training-support.net/selenium/selects using the get() method.
        driver.get("https://training-support.net/selenium/selects");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Use findElement() to find the dropdown WebElement on the page.
        WebElement element = driver.findElement(By.id("single-select"));
        //Create a new Select class object with the WebElement.
        Select select = new Select(element);
        //Select the second option using selectByVisibleText()
        select.selectByVisibleText("Option 2");
        //Select the third option using selectByIndex()
        select.selectByIndex(3);
        //Select the fourth option using selectByValue()
        select.selectByValue("4");
        //Finally, get all the options in the dropdown and print them one by one
        List<WebElement> options = select.getOptions();
        for (WebElement el:options){
            System.out.println("Options are :" +el.getText());
        }

    }
}

package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Activity9_2 {

    public static void main(String[] args) {
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        //Open the browser with https://training-support.net/selenium/selects using the get() method.
        driver.get("https://training-support.net/selenium/selects");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Use findElement() to find the multi-select WebElement on the page.
        WebElement multiselect = driver.findElement(By.id("multi-select"));
        //Create a new Select class object with the WebElement.
        Select select = new Select(multiselect);
        //Check if the HTML element is a multi-list. Proceed with other actions if it is.
        if(select.isMultiple()){
            //Select the 'JavaScript' option by visible text.
            select.selectByVisibleText("Javascript");
            //select the 'NodeJS' option by value.
            select.selectByValue("node");
            //Select the 4th, 5th, and the 6th options by index.
            select.selectByIndex(4);
            select.selectByIndex(5);
            select.selectByIndex(6);
            //Deselect the 'NodeJS' option by value attribute
            select.deselectByValue("node");
            //Deselect the 7th option by index.
            select.deselectByIndex(7);
            //Print the first selected option.
            System.out.println("First selected option :" +select.getFirstSelectedOption().getText());
            List<WebElement> selectedOptions = select.getAllSelectedOptions();
            //Print all selected options one by one and deselect all options.
            for (WebElement el: selectedOptions){
                System.out.println("Selected options are : " +el.getText());
            }
            select.deselectAll();
        }else{
            System.out.println("Not a multi select drop down ");
        }
    }

}

package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class Activity8_1 {

    public static void main(String[] args) {
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        //Open the browser with https://training-support.net/selenium/tables using get() method.
        driver.get("https://training-support.net/selenium/tables");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Use findElements() in combination with xpath() to find the number of columns and rows (not counting the table header) and print them.
        List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr[1]/td"));
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr"));
        System.out.println("No of cols : " +cols.size());
        System.out.println("No of rows : " + rows.size());
        //Find and print the all the cell values of the third row of the table.
        List<WebElement> thirdRow = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr[3]/td"));
        for(WebElement el : thirdRow){
            System.out.println("Third row elements are : " +el.getText());
        }
        //Find and print the cell value at the second row and second column.
        WebElement secondRowCol = driver.findElement(By.xpath("//table[contains(@class,'striped')]/tbody/tr[2]/td[2]"));
        System.out.println("Second Row second column :" + secondRowCol.getText());
        driver.quit();
    }
}

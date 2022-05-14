package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.time.Duration;
import java.util.List;

public class Activity8_2 {

    public static void main(String[] args) {
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        //Open the browser with https://training-support.net/selenium/tables using get() method.
        driver.get("https://training-support.net/selenium/tables");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Use findElements() in combination with xpath() to find the number of columns and rows (not counting the table header) and print them.
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        List<WebElement> cols = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));
        System.out.println("No of rows : " +rows.size());
        System.out.println("No of cols : " +cols.size());
        //Find and print the cell value at the second row and second column.
        WebElement secondRowCol = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Second Row and second col :" + secondRowCol.getText());
        //Click the header of the first column to sort by name.
        WebElement nameHeader = driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[1]"));
        nameHeader.click();
        //Find and print the cell value at the second row and second column again.
        WebElement secondRowCol1 = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
       System.out.println("Second Row and second col :" + secondRowCol1.getText());
        //Print the cell values of the table footer.
        List<WebElement> footerElements = driver.findElements(By.xpath("//table[@id='sortableTable']//tfoot/tr"));
        System.out.println("Size of footer"+footerElements.size());
        for (WebElement el:footerElements){
            System.out.println("Footer elements are  : " +el.getText());
        }

        driver.quit();

    }
}

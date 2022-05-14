package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Activity4_1 {
    public static void main(String[] args) {
        //Create a WebDriver instance, named driver, with the FirefoxDriver()
        WebDriver driver = new FirefoxDriver();
        //Open a browser with https://www.training-support.net
        driver.get("https://www.training-support.net");
        //Get the title of the page using driver.getTitle() and print out the title.
        String title = driver.getTitle();
        System.out.println("Title of the page :" +title);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        //Use findElement() with xpath() to find and click the "About Us" link on the page
        WebElement aboutUsLink = driver.findElement(By.xpath("//a[@id='about-link']"));
        aboutUsLink.click();
        //Print the title of the new page that open when the link is clicked
        String newTitle = driver.getTitle();
        System.out.println("Tilte of the page of new window :" +newTitle);
        driver.quit();

}
}

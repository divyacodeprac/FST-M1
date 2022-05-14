package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Acitivty6_2 {
    public static void main(String[] args) {
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        //Open a browser with https://training-support.net/selenium/ajax
        driver.get("https://training-support.net/selenium/ajax");
        driver.manage().window().maximize();
        //Get the title of the page using driver.getTitle() and print out the title.
        String title = driver.getTitle();
        System.out.println("Title of the page is "+title);
        //Find and click the "Change content" button on the page
        WebElement changeContent = driver.findElement(By.xpath("//button[contains(text(),'Change Content')]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(changeContent));
        changeContent.click();
        //Wait for the text to say "HELLO!". Print the message that appears on the page.
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"),"HELLO!"));
        String text = driver.findElement(By.xpath("//div[@id='ajax-content']//h1")).getText();
        System.out.println("Text on the page is : "+text);
        //Wait for the text to change to contain "I'm late!". Print the new message on the page.
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"),"I'm late!"));
        String lateText = driver.findElement(By.xpath("//div[@id='ajax-content']//h3")).getText();
        System.out.println("lateText Text on the page is : "+lateText);
        driver.quit();



    }
}

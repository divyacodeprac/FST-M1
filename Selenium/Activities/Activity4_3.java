package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {
    public static void main(String[] args) {
        //Create a WebDriver instance, named driver, with the FirefoxDriver().
        WebDriver driver = new FirefoxDriver();
        //Open a browser with https://www.training-support.net/selenium/target-practice
        driver.get("https://www.training-support.net/selenium/target-practice");
        //Get the title of the page using driver.getTitle() and print out the title
        String title = driver.getTitle();
        System.out.println("Title of the page :"+title);
        //Find the third header on the page.
        WebElement thirdHeader = driver.findElement(By.xpath("//h3[@id='third-header']"));
        System.out.println("Third Header is present /displayed : " +thirdHeader.isDisplayed());
        //Find the fifth header on the page and get it's 'colour' CSS Property.
        WebElement fifthHeader = driver.findElement(By.xpath("//h5[contains(@class,'green')]"));
        System.out.println("Fifth Header is present : " +fifthHeader.isDisplayed());
        System.out.println("Color of fifth header is " +fifthHeader.getCssValue("color"));
        //Find the violet button on the page and print all the class attribute values.
        WebElement violetButton = driver.findElement(By.xpath("//button[contains(text(),'Violet')]"));
        System.out.println("Violet button class attribute:"+violetButton.getAttribute("class"));
        //Find the grey button on the page with Absolute XPath.
        WebElement greyButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]"));
        System.out.println("Grey button is found by absolute path :" +greyButton.isDisplayed());

        driver.quit();

    }
}

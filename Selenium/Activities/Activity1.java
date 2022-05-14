package activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) {
       //Create an instance of webdriver
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/");
        driver.quit();

    }


}

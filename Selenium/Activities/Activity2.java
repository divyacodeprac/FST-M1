package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
    public class Activity2 {

    public static void main(String[] args) {

        //Create a WebDriver instance, named driver, with the FirefoxDriver()
        WebDriver driver = new FirefoxDriver();
        //Open a browser with https://www.training-support.net
        driver.get("https://www.training-support.net");
        driver.manage().window().maximize();
        //Get the title of the page using driver.getTitle() and print out the title
        String title = driver.getTitle();
        System.out.println("Tite of the page is : " +title);
        //Use findElement() with the following locators to find the "About Us" link by id
        WebElement byId = driver.findElement(By.id("about-link"));
        //Print the text in the WebElement using the getText() method.
        System.out.println("About Us Link text by id is  : "  + byId.getText());
        ////Use findElement() with the following locators to find the "About Us" link by linkText()
        WebElement bylinkText =driver.findElement(By.linkText("About Us"));
        System.out.println("About Us link text  by class name" +bylinkText.getText());
        //Use findElement() with the following locators to find the "About Us" link by className()
        WebElement byClassName =driver.findElement(By.className("green"));
        //Print the text in the WebElement using the getText() method.
        System.out.println("About Us link text by class name" +byClassName.getText());
        WebElement bycssSelector =driver.findElement(By.cssSelector("#about-link"));
        System.out.println("About Us link text by css selector  " +bycssSelector.getText());
        driver.quit();
    }



}

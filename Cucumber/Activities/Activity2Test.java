package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity2Test {
    private WebDriver driver;
    private WebDriverWait wait;

    @Given("^User is on Login page$")
    public void user_is_on_login_page(){
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @When("^User enters username and password$")
    public void user_enters_username_and_password(){
        WebElement userName = driver.findElement(By.id("username"));
        WebElement pwd  =driver.findElement(By.id("password"));
        userName.sendKeys("admin");
        pwd.sendKeys("password");
        WebElement submit = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        submit.click();
    }

    @Then("^Read the page title and confirmation message$")
    public void read_the_page_title_adn_confirmation_message(){
        String pageTitle = driver.getTitle();
        String confirmationMsg = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Page Title is : " + pageTitle);
        System.out.println("Confirmation Message is : " +confirmationMsg);
        if(confirmationMsg.contains("admin")) {
            Assert.assertEquals(confirmationMsg, "Welcome Back, admin");
        } else {
            Assert.assertEquals(confirmationMsg, "Invalid Credentials");
        }
    }

    @When("^User enters \"(.*)\" and \"(.*)\"$")
    public void enter_user_pwd(String username,String pwd){
        WebElement userName = driver.findElement(By.id("username"));
        WebElement password  =driver.findElement(By.id("password"));
        userName.sendKeys(username);
        password.sendKeys(pwd);
        WebElement submit = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        submit.click();
    }

    @And("^Close the Browser$")
    public void close_the_browser(){
        driver.quit();
    }
}

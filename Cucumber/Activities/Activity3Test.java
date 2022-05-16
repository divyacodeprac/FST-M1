package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity3Test {

    private WebDriver driver;
    private WebDriverWait wait;
    Alert alert;

    @Given("^User is on the page$")
    public void user_is_on_login_page(){
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
    }

    @When("^User clicks the Simple Alert button$")
    public void user_clicks_the_simple_alert_button(){
        WebElement simpleAlert = driver.findElement(By.id("simple"));
        simpleAlert.click();
    }

    @Then("^Alert opens$")
    public void alert_open(){
        wait.until(ExpectedConditions.alertIsPresent());
        alert=driver.switchTo().alert();
    }

    @And("^Read the text from it and print it$")
    public void read_the_text_from_it_and_print_it(){
        String alertText = alert.getText();
        System.out.println("Alert Text : "+alertText);
    }

    @And("^Close the alert$")
    public void close_the_alert(){
        alert.accept();
    }

    @When("^User clicks the Confirm Alert button$")
    public void user_clicks_the_confirm_alert(){
        WebElement confirmAlert = driver.findElement(By.id("confirm"));
        confirmAlert.click();
    }

    @And("^Write a custom message in it$")
    public void write_a_custom_message_in_it(){
        alert.sendKeys("Alert Text");
    }

    @When("^User clicks the Prompt Alert button$")
    public void user_clicks_the_prompt_alert(){
        WebElement promptAlert = driver.findElement(By.id("prompt"));
        promptAlert.click();
      }

    @And("^Close the alert with Cancel$")
    public void close_the_alert_with_cancel(){
        alert.dismiss();
    }
    @And("^Close Browser$")
    public void close_the_browser(){
        driver.quit();
    }
}

package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity1Test {

    private WebDriver driver;
    private WebDriverWait wait;

    @Given("^User is on Google Home Page$")
    public void user_Is_On_HomePage(){
        driver = new FirefoxDriver();
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://google.com");
    }

    @When("^User types in Cheese and hits ENTER$")
    public void user_types_in_Cheese_and_hits_Enter(){
        driver.findElement(By.name("q")).sendKeys("Cheese", Keys.RETURN);
    }

    @Then("^Show how many search results were shown$")
    public void show_how_many_search_results(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));
        System.out.println("Number of search result is : " +driver.findElement(By.id("result-stats")).getText());
    }

    @And("^Close the browser$")
    public void close_the_browser(){
        driver.quit();
    }
}

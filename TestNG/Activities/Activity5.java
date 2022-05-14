package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {

    WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test (groups = {"HeaderTests", "ButtonTests"})
    public  void pageTitle(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"Target Practice");
    }

    @Test (dependsOnMethods ={"pageTitle"} , groups = {"HeaderTests"})
    public void headerTest(){
        //Find the third header and assert the text in the h3 tag
        WebElement thirdHeader = driver.findElement(By.id("third-header"));
        String thirdHeaderText = thirdHeader.getText();
        Assert.assertEquals(thirdHeaderText,"Third header");

        //Find and assert the colour of the fifth header tag element
        WebElement fifthHeader = driver.findElement(By.tagName("h5"));
        String fifthHeaderTitle = fifthHeader.getCssValue("color");
        System.out.println(fifthHeaderTitle);
        Assert.assertEquals(fifthHeaderTitle,"rgb(33, 186, 69)");

    }

    @Test (dependsOnMethods ={"pageTitle"},groups = {"ButtonTests"})
    public  void buttonTest(){
        //Find the button with the class olive and assert it text.
        WebElement oliveBtn = driver.findElement(By.xpath("//button[contains(@class,'olive')]"));
        String oliveText = oliveBtn.getText();
        Assert.assertEquals(oliveText,"Olive");
        //Find and assert the colour of the first button in the third row
        WebElement brownBtn = driver.findElement(By.xpath("//button[contains(@class,'brown')]"));
        String brownColor = brownBtn.getCssValue("color");
        System.out.println("Brown :" +brownColor);
        Assert.assertEquals(brownColor,"rgb(255, 255, 255)");

    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}

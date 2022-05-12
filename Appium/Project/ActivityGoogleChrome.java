package liveProject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ActivityGoogleChrome {

    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;
    @BeforeClass
    public  void setUp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceId","48b5d0c5");
        cap.setCapability("platformName","android");
        cap.setCapability("automationName","UiAutomator2");
        cap.setCapability("appPackage","com.android.chrome");
        cap.setCapability("appActivity","com.google.android.apps.chrome.Main");
        cap.setCapability("noReset",true);

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        //Driver Initialization
        driver = new AndroidDriver<MobileElement>(serverURL,cap);
        wait = new WebDriverWait(driver, 10);
    }


    @Test
    public  void testToDoList(){
        driver.get("https://www.training-support.net/selenium");
        //Scroll to find the To-Do List card and click it.
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")));
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        driver.findElement(
                MobileBy.AndroidUIAutomator(UiScrollable + ".scrollForward().scrollIntoView(text(\"To-Do List\"))"));
        driver.findElement(
                MobileBy.AndroidUIAutomator(UiScrollable + ".scrollForward().scrollIntoView(text(\"To-Do List\"))")).click();

        //Once the page loads, find the input field on the page and enter the following three tasks:
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.webkit.WebView[@text='Todo List']")));
        driver.findElementByXPath("//android.webkit.WebView[@text='Todo List']").isDisplayed();
        List<String> tasksListToAdd = new ArrayList<>();
        tasksListToAdd.add("Add tasks to list");
        tasksListToAdd.add("Get number of tasks");
        tasksListToAdd.add("Clear the list");
        String taskBox = "resourceId(\"taskInput\")";
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(taskBox)));
        driver.findElement(MobileBy.AndroidUIAutomator(taskBox)).click();
        driver.findElement(MobileBy.AndroidUIAutomator(taskBox)).sendKeys(tasksListToAdd.get(0));
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Add Task']")));
        driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
        driver.findElement(MobileBy.AndroidUIAutomator(taskBox)).sendKeys(tasksListToAdd.get(1));
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Add Task']")));
        driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
        driver.findElement(MobileBy.AndroidUIAutomator(taskBox)).sendKeys(tasksListToAdd.get(2));
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@text='Add Task']")));
        driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();

        //Click on each of the tasks added to strike them out
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add tasks to list\")")).click();
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Get number of tasks\")")).click();
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Clear the list\")")).click();

        //Finally, clear the list.
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.TextView[2][contains(@text,'Clear List')]")));
        driver.findElementByXPath("//android.widget.TextView[contains(@text,'Clear List')]").click();
        String actual = driver.findElementByXPath("//android.view.View[contains(@text, '')]").getText();
        String expected = "";

        Assert.assertEquals(actual, expected);


    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

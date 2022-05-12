package activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity4 {

    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;
    @BeforeClass
    public  void setUp() throws MalformedURLException {
        //DesiredCapabilities
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceId","48b5d0c5");
        cap.setCapability("platformName","android");
        cap.setCapability("automationName","UiAutomator2");
        cap.setCapability("appPackage","com.android.contacts");
        cap.setCapability("appActivity",".activities.PeopleActivity");
        cap.setCapability("noReset",true);

        //Appium Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        //Driver Initialization
        driver = new AndroidDriver<MobileElement>(serverURL,cap);
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void addContact(){
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Add")));
        //Click on add new contact
        driver.findElementByAccessibilityId("Add").click();
        //Add first name
        driver.findElementByXPath("//android.widget.EditText[@text = 'Name']").click();
        driver.findElementByXPath("//android.widget.EditText[@text = 'Name']").clear();
        driver.findElementByXPath("//android.widget.EditText[@text = 'Name']").sendKeys("Aditya Varma");

        //Add phone number
        driver.findElementByXPath("//android.widget.EditText[@text = 'Phone']").click();
        driver.findElementByXPath("//android.widget.EditText[@text = 'Phone']").clear();
        driver.findElementByXPath("//android.widget.EditText[@text = 'Phone']").sendKeys("9966885523");

        //Click on save
        driver.findElementByAccessibilityId("OK").click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("custom_title")));
        driver.findElementById("custom_title").isDisplayed();
        String addedContact = driver.findElementById("custom_title").getText();
        System.out.println("Added contact" + addedContact);

        Assert.assertEquals(addedContact,"Aditya Varma");
    }

    @AfterClass
    public  void  tearDown(){
        driver.quit();
    }
}

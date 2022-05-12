package activities;

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

public class Activity2 {

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
    public  void launchApplication(){
        driver.get("https://www.training-support.net/");
        final MobileElement aboutUs = driver.findElementByAccessibilityId("About Us");
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("About Us")));
        String pageTitle = driver.findElementByXPath("//android.widget.TextView[@text='Training Support']").getText();
        System.out.println("Page title is : " +pageTitle);

        driver.findElementByAccessibilityId("About Us").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.TextView[@text='About Us']")));
        String newTitle = driver.findElementByXPath("//android.widget.TextView[@text='About Us']").getText();
        System.out.println("New Page title is : " +newTitle);

        Assert.assertEquals(pageTitle,"Training Support");
        Assert.assertEquals(newTitle,"About Us");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

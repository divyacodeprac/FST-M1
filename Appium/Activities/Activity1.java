package activities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {

    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public  void setUp() throws MalformedURLException {

        //DesiredCapabilities
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceId","48b5d0c5");
        cap.setCapability("platformName","android");
        cap.setCapability("automationName","UiAutomator2");
        cap.setCapability("appPackage","com.miui.calculator");
        cap.setCapability("appActivity","cal.CalculatorActivity");
        cap.setCapability("noReset",true);

        //Appium Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Driver Initialization
        driver = new AndroidDriver<MobileElement>(serverURL,cap);
}

    @Test
    public  void calc(){
        driver.findElementByAccessibilityId("clear").click();
        //Locate a number on cal and click on it.
        driver.findElementById("btn_1_s").click();
        //Click on multiply
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementById("btn_5_s").click();
        //Click on =
        driver.findElementByAccessibilityId("equals").click();
        //Get the result
        String result = driver.findElementById("result").getText();
        System.out.println("Result is  : " +result);

        Assert.assertEquals("= 5" , result);


    }
    @AfterClass
    public  void tearDown(){
        //Close the app
        driver.quit();
    }
}

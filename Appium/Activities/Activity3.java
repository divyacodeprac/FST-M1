package activities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {

    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public  void setUp() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceId","48b5d0c5");
        cap.setCapability("platformName","android");
        cap.setCapability("automationName","UiAutomator2");
        cap.setCapability("appPackage","com.miui.calculator");
        cap.setCapability("appActivity","cal.CalculatorActivity");
        cap.setCapability("noReset",true);

        URL serverlURL = new URL("http://localhost:4723/wd/hub");


        driver = new AndroidDriver<MobileElement>(serverlURL,cap);
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void operation(){
        //Addition of 5 +9
        driver.findElementByAccessibilityId("clear").click();
        //Click on 5
        driver.findElementById("btn_5_s").click();
        //Click on plus
        driver.findElementByAccessibilityId("plus").click();
        //Click on 9
        driver.findElementById("btn_9_s").click();
        //Click on =
        driver.findElementByAccessibilityId("equals").click();
        //Get the result
        String result = driver.findElementById("result").getText();
        System.out.println("Result is  : " +result);

        Assert.assertEquals("= 14" , result);

        driver.findElementByAccessibilityId("clear").click();

        //Subtraction of 10 - 5
        driver.findElementById("btn_1_s").click();
        driver.findElementById("btn_0_s").click();
        driver.findElementByAccessibilityId("minus").click();
        driver.findElementById("btn_5_s").click();
        //Click on =
        driver.findElementByAccessibilityId("equals").click();
        //Get the result

        result = driver.findElementById("result").getText();
        System.out.println("Result is  : " +result);

        Assert.assertEquals("= 5" , result);
        driver.findElementByAccessibilityId("clear").click();

        //Multiply 5*100
        driver.findElementById("btn_1_s").click();
        driver.findElementById("btn_0_s").click();
        driver.findElementById("btn_0_s").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementById("btn_5_s").click();
        //Click on =
        driver.findElementByAccessibilityId("equals").click();
        //Get the result
        result = driver.findElementById("result").getText();
        System.out.println("Result is  : " +result);

        Assert.assertEquals("= 500" , result);
        driver.findElementByAccessibilityId("clear").click();

        //Divide 50/2
        driver.findElementById("btn_5_s").click();
        driver.findElementById("btn_0_s").click();
        driver.findElementByAccessibilityId("divide").click();
        driver.findElementById("btn_2_s").click();
        //Click on =
        driver.findElementByAccessibilityId("equals").click();
        //Get the result
        result = driver.findElementById("result").getText();
        System.out.println("Result is  : " +result);

        Assert.assertEquals("= 25" , result);

    }
    @AfterClass
    public  void tearDown(){
        driver.quit();
    }
}

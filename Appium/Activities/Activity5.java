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

public class Activity5 {

    WebDriverWait wait;
    AndroidDriver<MobileElement> driver;
    @BeforeClass
    public void  setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId","48b5d0c5");
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage", "com.android.mms");
        caps.setCapability("appActivity", "ui.MmsTabActivity");
        caps.setCapability("noReset", true);

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<MobileElement>(serverURL,caps);
        wait =  new WebDriverWait(driver,10);
    }
    @Test
    public  void sendMessage(){
        //Click the "Create New Message" button to write a new SMS
       /* wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Compose")));
        driver.findElementByAccessibilityId("Compose").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("recipients_editor")));
        //Locate the contact fields and enter your own phone number to send a message to your own phone number.
        driver.findElementById("recipients_editor").click();
        driver.findElementById("recipients_editor").sendKeys("Divya");
        driver.findElementByAccessibilityId("OK").click();

        //Locate the message input field and enter the message "Hello from Appium"
        driver.findElementById("embedded_text_editor").click();
        driver.findElementById("embedded_text_editor").sendKeys("Hello from Appium");

        //Locate the send button and click it.
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("send_button")));
        driver.findElementById("send_button").click();
*/

        //Click the "Create New Message" button to write a new SMS
        String compose = "resourceId(\"com.android.mms:id/fab\")";
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(compose)));
        driver.findElement(MobileBy.AndroidUIAutomator(compose)).click();

        //Locate the contact fields and enter your own phone number to send a message to your own phone number.
        String recipients = "resourceId(\"com.android.mms:id/recipients_editor\")";
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(recipients)));
        driver.findElement(MobileBy.AndroidUIAutomator(recipients)).click();
        driver.findElement(MobileBy.AndroidUIAutomator(recipients)).sendKeys("9985004082");
        String ok = "resourceId(\"com.android.mms:id/confirm_recipient\")";
        driver.findElement(MobileBy.AndroidUIAutomator(ok)).click();
        //Locate the message input field and enter the message "Hello from Appium"
        String message = "resourceId(\"com.android.mms:id/embedded_text_editor\")";
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(message)));
        driver.findElement(MobileBy.AndroidUIAutomator(message)).click();
        driver.findElement(MobileBy.AndroidUIAutomator(message)).sendKeys("Hello from Appium");
        //Locate the send button and click it.
       // String send = "resourceId(\"com.android.mms:id/send_button\")";
        String send = "description(\"Send message\")";
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(send)));
        driver.findElement(MobileBy.AndroidUIAutomator(send)).click();

        // Wait for message to show
        String messageLocator = "resourceId(\"com.android.mms:id/message_body\")";
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(messageLocator)));
        // Assertion
        String sentMessageText = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
        Assert.assertEquals(sentMessageText, "Hello from Appium");
    }



    @AfterClass
    public  void tearDown(){
        driver.quit();
    }

}

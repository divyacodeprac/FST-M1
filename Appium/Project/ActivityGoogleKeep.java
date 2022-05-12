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

public class ActivityGoogleKeep {

    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass()
    public  void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId","48b5d0c5");
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        URL serverURL = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(serverURL,caps);
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void googleKeep(){

        //Click the Create New Note button to add a new Note.
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("new_note_button")));
        driver.findElementById("new_note_button").click();

        //Add a title for the note and add a small description
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("editable_title")));
        String expectedTitle = "Activity Title";
        String expectedNote = "Activity Description ";
        driver.findElementById("editable_title").sendKeys(expectedTitle);
        driver.findElementById("edit_note_text").sendKeys(expectedNote);

        //Press the back button and make an assertion to ensure that the note was added.
        driver.findElementByAccessibilityId("Open navigation drawer").click();

        String title = "resourceId(\"com.google.android.keep:id/index_note_title\")";
        String note = "resourceId(\"com.google.android.keep:id/index_note_text_description\")";
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("new_note_button")));
        String actualTitle = driver.findElement(MobileBy.AndroidUIAutomator(title)).getText();
        String actualNote = driver.findElement(MobileBy.AndroidUIAutomator(note)).getText();

        Assert.assertEquals(actualTitle,expectedTitle);
        Assert.assertEquals(actualNote,expectedNote);

    }
    @AfterClass
    public  void tearDown(){
        driver.quit();
    }


}

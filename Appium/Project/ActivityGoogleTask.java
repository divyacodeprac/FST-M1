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

public class ActivityGoogleTask {

    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass()
    public  void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId","48b5d0c5");
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        URL serverURL = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(serverURL,caps);
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void googleTask(){


        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task")));
        //Click the button to add a new task
        driver.findElementByAccessibilityId("Create new task").click();

        //Add the following tasks:Complete Activity with Google Tasks ,Complete Activity with Google Keep,Complete the second Activity Google Keep
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("add_task_title")));
        driver.findElementById("add_task_title").click();
        List<String> taskListtoAdd = new ArrayList<>();
        taskListtoAdd.add("Complete Activity with Google Tasks");
        taskListtoAdd.add("Complete Activity with Google Keep");
        taskListtoAdd.add("Complete the second Activity Google Keep");

        driver.findElementById("add_task_title").sendKeys(taskListtoAdd.get(0).trim());
        //After each task is added, the Save button should be clicked
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_done")));
        driver.findElementById("add_task_done").click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task")));
        driver.findElementByAccessibilityId("Create new task").click();
        driver.findElementById("add_task_title").sendKeys(taskListtoAdd.get(1).trim());
        //After each task is added, the Save button should be clicked
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_done")));
        driver.findElementById("add_task_done").click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task")));
        driver.findElementByAccessibilityId("Create new task").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("add_task_title")));
        driver.findElementById("add_task_title").click();
        driver.findElementById("add_task_title").sendKeys(taskListtoAdd.get(2).trim());
        //After each task is added, the Save button should be clicked
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_done")));
        driver.findElementById("add_task_done").click();


       //Write an assertion to ensure all three tasks have been added to the list.
        String tasks = "resourceId(\"com.google.android.apps.tasks:id/task_name\")";
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.AndroidUIAutomator(tasks)));
        List<MobileElement> taskList =  driver.findElements(MobileBy.AndroidUIAutomator(tasks));
        System.out.println("Size of the task list : " + taskList.size());


        boolean hasTasks = false;
        for(MobileElement task: taskList){
            System.out.println(" Task Name  : " + task.getText());
            if(taskListtoAdd.contains(task.getText())){
                hasTasks= true;
            }
        }
        Assert.assertEquals(hasTasks,true);
    }

    @AfterClass
    public  void tearDown(){
        driver.quit();
    }
    
}

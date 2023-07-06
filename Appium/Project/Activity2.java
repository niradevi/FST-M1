package LiveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity2 {

    AppiumDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("android");
        caps.setAutomationName("UiAutomator2");
        caps.setAppPackage("com.google.android.apps.tasks");
        caps.setAppActivity(".ui.TaskListsActivity");
        caps.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL,caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void enterTest() {
        addTask("abc");
        addTask("def");
        addTask("ghi");
        wait.until(ExpectedConditions.numberOfElementsToBe(AppiumBy.id("com.google.android.apps.tasks:id/task_name"),3));
        List<WebElement> taskListelems = driver.findElements(AppiumBy.id("com.google.android.apps.tasks:id/task_name"));
        for(WebElement elem: taskListelems){
            System.out.println(elem.getText());

        }
        Assert.assertEquals(taskListelems.get(0).getText(),"ghi");
        Assert.assertEquals(taskListelems.get(1).getText(),"def");
        Assert.assertEquals(taskListelems.get(2).getText(),"abc");
        System.out.println("test");
    }

    public void addTask(String tasktxt){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(AppiumBy.accessibilityId("Create new task")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"))));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys(tasktxt);
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

    }

}

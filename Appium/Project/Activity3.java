package LiveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AndroidBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static examples.ActionsBase.doSwipe;

public class Activity3 {

    AppiumDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("android");
        caps.setAutomationName("UiAutomator2");
        caps.setAppPackage("com.android.chrome");
        caps.setAppActivity("com.google.android.apps.chrome.Main");
        caps.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL,caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium");
    }

    @Test
    public void webAppTest(){
        Dimension dims = driver.manage().window().getSize();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));
        Point start = new Point((int)(dims.getWidth()*0.5), (int)(dims.getHeight()*0.9));
        Point end = new Point((int)(dims.getWidth()*0.5), (int)(dims.getHeight()*0.2));
        doSwipe(driver, start, end, 200);
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']"))).click();

        By addTaskBtn = AppiumBy.xpath("//android.widget.Button[@text='Add Task']");
        By taskField = AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']");
        By clearBtn = AppiumBy.xpath("//android.widget.TextView[@text=' Clear List']");
        By taskList = AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View");
        driver.findElement(taskField).sendKeys("test1");
        driver.findElement(addTaskBtn).click();
        driver.findElement(taskField).sendKeys("test2");
        driver.findElement(addTaskBtn).click();
        driver.findElement(taskField).sendKeys("test3");
        driver.findElement(addTaskBtn).click();
        List<WebElement> taskListelems = driver.findElements(taskList);
        Assert.assertEquals(taskListelems.size(),4);
        for(WebElement elem: taskListelems){
            elem.click();
        }
        driver.findElement(clearBtn).click();
        taskListelems = driver.findElements(taskList);
        Assert.assertEquals(taskListelems.size(),0);
    }
}

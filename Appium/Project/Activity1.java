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

public class Activity1 {

    AppiumDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("android");
        caps.setAutomationName("UiAutomator2");
        caps.setAppPackage("com.google.android.keep");
        caps.setAppActivity(".activities.BrowseActivity");
        caps.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL,caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void enterTest() {
        String title = "Test";
        String desc = "sample text";
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(AppiumBy.accessibilityId("New text note")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title"))));
        driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys(title);
        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys(desc);
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_title"))));
        Assert.assertEquals(driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_title")).getText(),title);
        Assert.assertEquals(driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_text_description")).getText(),desc);
    }

}

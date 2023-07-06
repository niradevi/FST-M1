package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    WebDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("android");
        caps.setAutomationName("UiAutomator2");
        caps.setAppPackage("com.android.dialer");
        caps.setAppActivity(".main.impl.MainActivity");
        caps.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL,caps);
    }

    @Test
    public void enterTest() {
        driver.findElement(AppiumBy.accessibilityId("key pad")).click();
        System.out.println("test");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class TestNgexample {

    WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");

        driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/");

    }

    @Test(priority = 1)
    public void homepageTest() {
        String heading1 = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(heading1, "Training Support");
    }

    @Test(groups = {"HeaderTests"})
    public void aboutUsTest() {
        String heading1 = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(heading1, "Training Support");
    }
    @Test(priority = 2)
    public void aboutUsTest2() {
        String heading1 = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(heading1, "Training Support");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

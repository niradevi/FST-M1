package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ActivityDataProvider {

    WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");

        driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/login-form");

    }

    @DataProvider(name = "Credentials")
    public static Object[][] credentials() {
        return new Object[][]{
                {"admin", "password", "Welcome Back, admin"},
                {"admin1", "password", "Invalid Credentials"
                }
        };
    }
    @Test(dataProvider = "Credentials")
    public void loginTest(String uname, String pwd, String msg){
    driver.findElement(By.id("username")).sendKeys(uname);
    driver.findElement(By.id("password")).sendKeys(pwd);
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Assert.assertEquals(msg,driver.findElement(By.id("action-confirmation")).getText());

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

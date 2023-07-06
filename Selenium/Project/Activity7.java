import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    public void test1(){
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        Assert.assertTrue(driver.findElement(By.id("recentlyViewedSidebar")).isDisplayed());
        driver.findElement(By.xpath("//a[text()='Sales']")).click();
        driver.findElement(By.id("moduleTab_9_Leads")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Additional Details'][1]")));
        driver.findElement(By.xpath("//span[@title='Additional Details'][1]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println(driver.findElement(By.xpath("//span[@class='phone']")).getText());

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

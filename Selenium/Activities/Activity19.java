package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity19 {

    public static void main(String[] args) throws InterruptedException {
        // Install driver
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        driver.findElement(By.id("simple")).click();
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();

        driver.findElement(By.id("confirm")).click();
        Alert confAlert = driver.switchTo().alert();
        confAlert.dismiss();

        driver.quit();
    }
}

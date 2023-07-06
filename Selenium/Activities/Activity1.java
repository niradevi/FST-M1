package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) throws InterruptedException {
        // Install driver
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/");

        String pageTitle = driver.getTitle();

        System.out.println(pageTitle);

        driver.findElement(By.id("about-link")).click();

        String pageTitle2 = driver.getTitle();
        System.out.println(pageTitle2);        driver.quit();
    }
}


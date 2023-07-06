package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class TablesExamples {

    public static void main(String[] args) throws InterruptedException {
        // Install driver
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/tables");

        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        System.out.println(rows.size());

        List<WebElement> columns = driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
        System.out.println(columns.size());
        driver.quit();
    }
}

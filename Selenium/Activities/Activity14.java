package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity14 {

    public static void main(String[] args) throws InterruptedException {
        // Install driver
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");

        WebDriver driver = new FirefoxDriver();
//
//        driver.get("https://www.training-support.net/selenium/tables");
//
//       List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
//        System.out.println(rows.size());
//
//        List<WebElement> col = driver.findElements(By.xpath("//table/tbody/tr"));
//        System.out.println(col.size());

        driver.get("https://www.training-support.net/selenium/tables");

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        System.out.println(rows.size());

        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));
        System.out.println(columns.size());

        String value = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]")).getText();
        System.out.println(value);

        driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[1]")).click();
        value = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]")).getText();
        System.out.println(value);
        List<WebElement> footer = driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr/th"));
        for(WebElement elem: footer){
            System.out.println(elem.getText());
        }

        driver.quit();
    }
}

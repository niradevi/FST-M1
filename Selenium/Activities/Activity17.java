package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity17 {


    public static void main(String[] args) throws InterruptedException {
        // Install driver
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/selects");

        WebElement selectElem = driver.findElement(By.id("single-select"));
        Select selec = new Select(selectElem);
        selec.selectByVisibleText("Option 2");
        System.out.println(selec.getFirstSelectedOption().getText());
        selec.selectByIndex(3);
        System.out.println(selec.getFirstSelectedOption().getText());
        selec.selectByValue("4");
        System.out.println(selec.getFirstSelectedOption().getText());
        List<WebElement> options = selec.getOptions();
        System.out.println("options");
        for(WebElement option:options){
            System.out.println(option.getText());
        }

        driver.quit();
    }
}

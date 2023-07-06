package stepDefinitions;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstTest extends BaseClass{
    @BeforeAll
    public static void setup(){
        WebDriverManager.firefoxdriver().setup();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Given("user is on homepage")
    public void openHomepage() {
        driver.get("https://www.training-support.net");
        Assertions.assertEquals("Training Support", driver.getTitle());
    }

    @When("the user clicks on About Us link")
    public void clickAboutLink() {
        WebElement aboutLink = driver.findElement(By.id("about-link"));
        Assertions.assertTrue(aboutLink.isEnabled());
        aboutLink.click();
    }

    @Then("the user is redirected to About Us page")
    public void verifyAboutPage(){
        Assertions.assertEquals("About Training Support", driver.getTitle());

    }


    @Then("close the browser")
    public void closeBrowser(){
        driver.quit();
    }
}

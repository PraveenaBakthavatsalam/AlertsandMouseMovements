package uk.axone.alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * @author Praveena.Bakthavatsalam
 */
public class TestHowToHandleAlerts {
    WebDriver driver;

    @BeforeTest
    public void setupBrowser() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //to maximize the window
        driver.manage().window().maximize();
        driver.get("http://uitest.automationtester.uk/javascript-alert-box-demo.html");
         Thread.sleep(3000);
        //driver.navigate().refresh();
    }
    @Test
    public void testHandleAlerts() throws InterruptedException {
        driver.findElement(By.xpath("//button[text()='Click for Prompt Box']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        System.out.println(alert.getText());
        Thread.sleep(6000);
        alert.sendKeys("Axone UK");
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

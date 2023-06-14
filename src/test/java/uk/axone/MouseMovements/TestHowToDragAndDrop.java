package uk.axone.MouseMovements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Praveena.Bakthavatsalam
 */
public class TestHowToDragAndDrop {
    WebDriver driver;

    @BeforeTest
    public void setUpBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
        driver.manage().window().maximize();
    }

    @Test
    public void testDragAndDrop() throws InterruptedException {
        Thread.sleep(5000);
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, drop).perform();
        Thread.sleep(5000);
    }

    @AfterTest
    public void clearDownBrowser() {
        driver.quit();
    }

}

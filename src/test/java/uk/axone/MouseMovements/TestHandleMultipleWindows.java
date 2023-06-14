package uk.axone.MouseMovements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

/**
 * @author Praveena.Bakthavatsalam
 */
public class TestHandleMultipleWindows {

    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://seleniumpractice.axone-tech.uk/index.php");
        Thread.sleep(2000);
        System.out.println("Title: " + driver.getTitle());
    }

    @Test
    public void testNewWindowTab() throws InterruptedException {
        WebDriver newWindow = driver.switchTo().newWindow(WindowType.WINDOW);
        driver.manage().window().maximize();
        newWindow.get("http://seleniumpractice.axone-tech.uk/index.php?controller=prices-drop");
        System.out.println("Title: " + driver.getTitle());
        Thread.sleep(2000);
    }

    @Test
    public void testWorkingInBothWindowTabs() throws InterruptedException {
// Automatically Open & Switch To The New Window Or Tab
        driver.manage().window().maximize();
        driver.switchTo().newWindow(WindowType.TAB)
                .get("http://seleniumpractice.axone-tech.uk/index.php?controller=authentication&back=my-account");
        System.out.println("Title: " + driver.getTitle());

// Work In The New Window Or Tab
        driver.findElement(By.id("email_create")).sendKeys("Selenium4@axone.uk");
        driver.findElement(By.id("SubmitCreate")).click();
        Thread.sleep(2000);

// Get The Window ID Handles
        Set<String> allWindowTabss= driver.getWindowHandles();
        Iterator<String> iterate = allWindowTabss.iterator();
        String mainFirstWindow = iterate.next();

// Switch & Work In The Main Window Or Tab
        driver.switchTo().window(mainFirstWindow);
        driver.manage().window().maximize();
        driver.findElement(By.id("search_query_top")).sendKeys("Shirt");
        driver.findElement(By.name("submit_search")).click();
        System.out.println("Title: " + driver.getTitle());
        Thread.sleep(2000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}


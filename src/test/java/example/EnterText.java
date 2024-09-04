package example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class EnterText {


        /**Enter text using javascriptExecutor*/

        @Test()
        public void textUsingJS() {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.google.com");
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("document.getElementById('APjFqb').value='hello';");
            //System.out.println("Before method");
        }

        /**Enter text using Actions class*/

        @Test(dataProvider = "data-provider", dataProviderClass = Dataprovider.class)
        //@Parameters("searchText")
        public void textUsingAction(String text) {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.google.com");
            Actions action = new Actions(driver);
            WebElement ele = driver.findElement(By.id("APjFqb"));
            action.moveToElement(ele).click().sendKeys(text).build().perform();
            System.out.println("Test method");
        }

        /**Enter text using robot class*/

        //@AfterSuite
        public void textUsingRobot() throws AWTException {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.google.com");
            Robot robot = new Robot();
            WebElement element = driver.findElement(By.id("APjFqb"));
            element.sendKeys("");
            robot.keyPress(KeyEvent.VK_CAPS_LOCK);
            robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
            robot.keyPress(KeyEvent.VK_O);
            robot.keyRelease(KeyEvent.VK_O);
            robot.keyPress(KeyEvent.VK_K);
            robot.keyRelease(KeyEvent.VK_K);
            robot.keyPress(KeyEvent.VK_CAPS_LOCK);
            robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
            System.out.println("After suite");
            driver.quit();
        }
    }

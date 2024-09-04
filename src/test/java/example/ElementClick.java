package example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class ElementClick {


        /**click element using javaScript executor*/

        @Test(groups = "click")
        public void clickUsingJSExe() {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demoqa.com");
            WebElement ele = driver.findElement(By.className("banner-image"));
            JavascriptExecutor exe = (JavascriptExecutor) driver;
            exe.executeScript("arguments[0].click();", ele);
        }

        /**Double-click on the element using actions class*/
        @BeforeSuite
        public void doubleClickUsingActions() {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/elements");
            WebElement ele = driver.findElement(By.xpath("//div[@class = 'header-text']//following::span[text()= 'Buttons']"));
            JavascriptExecutor exe = (JavascriptExecutor) driver;
            exe.executeScript("arguments[0].scrollIntoView();", ele);
            ele.click();
            Actions action = new Actions(driver);
            WebElement dClick = driver.findElement(By.id("doubleClickBtn"));
            exe.executeScript("arguments[0].scrollIntoView();", dClick);
            dClick.click();
            action.doubleClick(dClick).perform();
            System.out.println("Before suite");
        }

        /**right-click on the element using actions class*/
        @Test(groups = "click")
        public void rightClickUsingAction() {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/elements");
            WebElement ele = driver.findElement(By.xpath("//div[@class = 'header-text']//following::span[text()= 'Buttons']"));
            JavascriptExecutor exe = (JavascriptExecutor) driver;
            exe.executeScript("arguments[0].scrollIntoView();", ele);
            ele.click();
            Actions action = new Actions(driver);
            WebElement rClick = driver.findElement(By.id("rightClickBtn"));
            exe.executeScript("arguments[0].scrollIntoView();", rClick);
            rClick.click();
            action.contextClick(rClick).perform();
        }


        /**click on the element using actions class*/
        @AfterMethod
        public void clickUsingActions() {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/elements");
            WebElement ele = driver.findElement(By.xpath("//img[contains(@src, 'Toolsqa')]"));
            Actions action = new Actions(driver);
            action.moveToElement(ele).build().perform();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
            wait.until(ExpectedConditions.elementToBeClickable(ele));
            action.click(ele).build().perform();
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
            driver.quit();
            try {
                ele.click();
            } catch (NoSuchSessionException e) {
                System.out.println("Driver has been closed and unable to perform actions");
            }
            System.out.println("After method");
        }
}

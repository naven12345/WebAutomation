package example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alerts {

    //normal alert
    @Test(priority = -1)
    public void normalAlert() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com");
        WebElement ele = driver.findElement(By.xpath("//div[contains(@class,'top-card')]//child::h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        exe.executeScript("arguments[0].scrollIntoView();", ele);
        ele.click();
        WebElement ele1 = driver.findElement(By.xpath("//div[@class = 'header-text']//following::span[text()= 'Alerts']"));
        exe.executeScript("arguments[0].scrollIntoView();", ele1);
        ele1.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
        WebElement alert = driver.findElement(By.xpath("//h1[text()='Alerts']"));
        exe.executeScript("arguments[0].scrollIntoView();", alert);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        WebElement normalAlert = driver.findElement(By.id("alertButton"));
        normalAlert.click();
        wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    //confirm alert
    @Test(priority = 1)
    public void confirmAlert() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com");
        WebElement ele = driver.findElement(By.xpath("//div[contains(@class,'top-card')]//child::h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        exe.executeScript("arguments[0].scrollIntoView();", ele);
        ele.click();
        WebElement ele1 = driver.findElement(By.xpath("//div[@class = 'header-text']//following::span[text()= 'Alerts']"));
        exe.executeScript("arguments[0].scrollIntoView();", ele1);
        ele1.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
        WebElement alert = driver.findElement(By.xpath("//h1[text()='Alerts']"));
        exe.executeScript("arguments[0].scrollIntoView();", alert);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        WebElement ConfirmAlert = driver.findElement(By.id("confirmButton"));
        ConfirmAlert.click();
        wait.until(ExpectedConditions.alertIsPresent());
        try {
            driver.switchTo().alert().accept();
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
            ConfirmAlert.click();
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            System.out.println("Alert not found");
        }
    }

    //prompt alert
    @Test(priority = 0)
    public void promptAlert() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com");
        WebElement ele = driver.findElement(By.xpath("//div[contains(@class,'top-card')]//child::h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        exe.executeScript("arguments[0].scrollIntoView();", ele);
        ele.click();
        WebElement ele1 = driver.findElement(By.xpath("//div[@class = 'header-text']//following::span[text()= 'Alerts']"));
        exe.executeScript("arguments[0].scrollIntoView();", ele1);
        ele1.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
        WebElement alert = driver.findElement(By.xpath("//h1[text()='Alerts']"));
        exe.executeScript("arguments[0].scrollIntoView();", alert);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        WebElement promptAlert = driver.findElement(By.id("promtButton"));
        promptAlert.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys("hello");
        driver.switchTo().alert().accept();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        driver.quit();
    }
}

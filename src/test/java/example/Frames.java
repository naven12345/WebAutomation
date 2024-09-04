package example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Frames {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        WebElement ele = driver.findElement(By.xpath("//div[contains(@class,'top-card')]//child::h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        exe.executeScript("arguments[0].scrollIntoView();", ele);
        ele.click();
        WebElement ele1 = driver.findElement(By.xpath("//div[@class = 'header-text']//following::span[text()= 'Frames']"));
        exe.executeScript("arguments[0].scrollIntoView();", ele1);
        ele1.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
        try {
            WebElement frame = driver.findElement(By.xpath("//h1[text()='Frames']"));
            exe.executeScript("arguments[0].scrollIntoView();", frame);
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame1"));
            //driver.switchTo().frame("frame1");
            WebElement element = driver.findElement(By.id("sampleHeading"));
            System.out.println("Frame one text is " + element.getText());
        } catch (NoSuchFrameException e) {
            System.out.println("Unable to find the frame in the page");
        }
    }
}

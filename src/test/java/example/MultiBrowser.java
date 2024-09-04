package example;

import base.BaseTest;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class MultiBrowser extends BaseTest {

    @Test
    public void enterText(){
        DriverManager.getDriver().get("https://www.google.com");
        JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();
        jse.executeScript("document.getElementById('APjFqb').value='hello';");
    }

    @Test
    public void clickJs(){
        DriverManager.getDriver().get("https://demoqa.com");
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofMillis(2000));
        WebElement ele = DriverManager.getDriver().findElement(By.className("banner-image"));
        wait.until(ExpectedConditions.visibilityOf(ele));
        JavascriptExecutor exe = (JavascriptExecutor) DriverManager.getDriver();
        exe.executeScript("arguments[0].click();", ele);
    }

    @Test
    public void scrollTillEle(){
        DriverManager.getDriver().get("https://demo.guru99.com/test/guru99home/");
        WebElement ele = DriverManager.getDriver().findElement(By.xpath("//h3[text()='Email Submission']"));
        JavascriptExecutor exe = (JavascriptExecutor)DriverManager.getDriver();
        exe.executeScript("arguments[0].scrollIntoView();", ele);
    }
}

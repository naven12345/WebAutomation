package example;

import TestData.TestDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;

public class ReadJsonData {


    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "jsonTestData")
    public void enterTextUsingJsonData(HashMap<String,String> input){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
        WebElement ele = driver.findElement(By.xpath("//h1[text()='Practice Form']"));
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        exe.executeScript("arguments[0].scrollIntoView();", ele);
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        firstName.sendKeys(input.get("firstName"));
        lastName.sendKeys(input.get("lastName"));
    }
}

package base;

import com.aventstack.extentreports.ExtentTest;
import driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class BasePage {

    public static void scrollToElement(WebElement element){
        JavascriptExecutor exe = (JavascriptExecutor) DriverManager.getDriver();
        exe.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void moveToElementAndClick(WebElement element){
        Actions a = new Actions(DriverManager.getDriver());
        a.moveToElement(element).click().perform();
    }

    public String getScreenShot(String testCaseName) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot)DriverManager.getDriver();
        File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(System.getProperty("user.dir") + "//screenShots//" + testCaseName + ".png");
        FileUtils.copyFile(scrFile,destFile);
        return System.getProperty("user.dir") + "//screenShots//" + testCaseName + ".png";
    }
}

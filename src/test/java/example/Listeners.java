package example;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class Listeners implements ITestListener {
    WebDriver driver = new ChromeDriver();

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("Test case successfully passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./screenShots/fail.png");
        try {
            Files.copy(scrFile,destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package listeners;

import base.BasePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentReport;

import java.io.IOException;

public class ExtentListener extends BasePage implements ITestListener {

    ExtentTest test;
    ExtentReports extent = ExtentReport.initReport();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable().getMessage());
        String filePath = null;
        try{
            filePath = getScreenShot(result.getMethod().getMethodName());
        } catch (IOException e){
            e.printStackTrace();
        }
        extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass(result.getMethod().getDescription() + " Test is passed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().skip(result.getMethod().getDescription() + " Test Skipped");
    }


    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}

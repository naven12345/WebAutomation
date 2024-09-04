package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

    public static ExtentReports extent;
    private static final String reportPath = System.getProperty("user.dir") + "\\extent-test-output\\" + "ExtentReport.html";


    public static ExtentReports initReport(){

        extent = new ExtentReports();
        //test = extent.createTest("loginAndAddProductToCart");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Web Automation Report");
        sparkReporter.config().setReportName("End To End Flow Report");
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Windows 11","HP");
        return extent;
    }


    public static void flushReport(){
        if(extent != null){
            extent.flush();
        }
    }
}

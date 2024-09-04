package base;

import driver.Driver;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.FormAPage;
import reports.ExtentReport;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    @BeforeMethod
    @Parameters({"browser", "runMode"})
    public void setUp(String browser, String runType) throws IOException {
        Properties prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\" + "GlobalData.properties");
        prop.load(fileInputStream);
        String browserName = System.getProperty("browser")!=null? System.getProperty("browser") : prop.getProperty("browser");
        Driver.initializeDriver(browserName,runType);
        DriverManager.getDriver().get("https://rahulshettyacademy.com/client");
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}


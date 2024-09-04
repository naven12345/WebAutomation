package factory;

import constants.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public static WebDriver prepareDriver(String browser, String runMode) {
        Capabilities cap;
        WebDriver driver = null;
        if (browser.equalsIgnoreCase(BrowserType.CHROME.name())) {
            if (runMode.equalsIgnoreCase("local")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions Options = new ChromeOptions();
                Options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                Options.addArguments("--remote-allow-origins=*");
                Options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(Options);
            }
            else if (runMode.equalsIgnoreCase("remote")) {
            }
        }
        else if (browser.equalsIgnoreCase(BrowserType.EDGE.name())) {
            if (runMode.equalsIgnoreCase("local")) {
                WebDriverManager.edgedriver().setup();
                EdgeOptions Options = new EdgeOptions();
                Options.addArguments("--remote-allow-origins=*");
                driver = new EdgeDriver(Options);
            }
            else if (runMode.equalsIgnoreCase("remote")) {
            }
        }
        else if (browser.equalsIgnoreCase(BrowserType.SAFARI.name())) {
            if(runMode.equalsIgnoreCase("local")){
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
        }
            else if (runMode.equalsIgnoreCase("remote")) {
            }
        }
        else if (browser.equalsIgnoreCase(BrowserType.FIREFOX.name())) {
            if (runMode.equalsIgnoreCase("local")){
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            else if (runMode.equalsIgnoreCase("remote")) {
            }
        }
        driver.manage().window().maximize();
        return driver;
    }
}

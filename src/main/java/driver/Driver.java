package driver;

import factory.DriverFactory;
import org.openqa.selenium.remote.NoSuchDriverException;
import java.util.Objects;

public class Driver {

    public static void initializeDriver(String browser, String runMode) {
        if (Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setDriver(DriverFactory.prepareDriver(browser, runMode));
            } catch (Exception e) {
                throw new NoSuchDriverException("Problem with driver initialization");
            }
        }
    }

    public static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}

package example;

import org.testng.annotations.DataProvider;

public class Dataprovider {

    @DataProvider(name = "data-provider", parallel = true)
    public Object[][] dpMethod(){
        return new Object[][] {{"Selenium"},{"appium"}};
    }
}

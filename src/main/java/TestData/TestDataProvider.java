package TestData;

import org.testng.annotations.DataProvider;

import java.util.HashMap;

public class TestDataProvider extends jsonReader {

    @DataProvider
    public Object[] jsonTestData() throws Exception{
        HashMap<String,String> data = getJsonDataToMap();
        return new Object[] {data};
    }

    @DataProvider
    public Object[] jsonData() throws Exception{
        HashMap<String,String> data = getJsonData();
        return new Object[] {data};
    }
}

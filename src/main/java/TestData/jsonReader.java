package TestData;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class jsonReader {
    public HashMap<String,String> getJsonDataToMap() throws Exception{
        String jsonData = FileUtils.readFileToString(new File("src/main/resources/InputData.json"), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> data = mapper.readValue(jsonData, new TypeReference<HashMap<String, String>>() {
        });
        return data;
    }

    public HashMap<String,String> getJsonData() throws Exception{
        String jsonData = FileUtils.readFileToString(new File("src/main/resources/TestData.json"), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> data = mapper.readValue(jsonData, new TypeReference<HashMap<String, String>>() {
        });
        return data;
    }
}

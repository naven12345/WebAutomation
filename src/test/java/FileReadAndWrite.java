import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileReadAndWrite {

    @Test
    public void fileRead() throws Exception {
        WebDriver driver;
        String textFile = "D:\\Automation Practice\\SeleniumConcepts\\textData.txt";
        FileReader reader = new FileReader(textFile);
        BufferedReader br = new BufferedReader(reader);
        String text = "";
        while ((text = br.readLine())!= null){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(text);
            String title = driver.getTitle();
            FileWriter write = new FileWriter(textFile);
            BufferedWriter bw = new BufferedWriter(write);
            bw.newLine();
            bw.write(title);
            bw.close();
        }
    }
}

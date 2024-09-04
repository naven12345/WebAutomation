package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException, URISyntaxException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bstackdemo.com/");
        List<WebElement> urlLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total links in the page are "+ urlLinks.size());
        for (WebElement urLink : urlLinks){
            String url = urLink.getAttribute("href");
            URL link = new URI(url).toURL();
            HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200){
                System.out.println(url +" - " + httpURLConnection.getResponseMessage());
            }
            else {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage() + "is a broken link");
            }
        }
    }
}

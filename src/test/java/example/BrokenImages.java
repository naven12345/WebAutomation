package example;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;

public class BrokenImages {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/broken_images");
        driver.manage().window().maximize();
        int brokenImgCount = 0;
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Total images in the page are " +images.size());
        try {
            for (WebElement image : images){
                if (image!= null){
                    HttpClient client = HttpClientBuilder.create().build();
                    HttpGet request = new HttpGet(image.getAttribute("src"));
                    HttpResponse response = client.execute(request);
                    if (response.getCode() != 200){
                        brokenImgCount++;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("No of broken images in the page are "+brokenImgCount);
    }
}

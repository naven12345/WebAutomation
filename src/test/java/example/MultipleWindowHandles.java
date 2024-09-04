package example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class MultipleWindowHandles {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.naukri.com");
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window is " + parentWindow);
        Thread.sleep(10000);
        WebElement ele1 = driver.findElement(By.xpath("//span[@title='Remote']"));
        WebElement ele2 = driver.findElement(By.xpath("//span[@title='MNC']"));
        /*JavascriptExecutor exe = (JavascriptExecutor)driver;
        exe.executeScript("arguments[0].scrollIntoView();", ele1);*/
        ele1.click();
        ele2.click();
        try {
            Set<String> s = driver.getWindowHandles();
            Iterator<String> iterator = s.iterator();
            while (iterator.hasNext()) {
                String childWindow = iterator.next();
                if (!parentWindow.equals(childWindow)) {
                    driver.switchTo().window(childWindow);
                    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
                    System.out.println("Child Window title is " + driver.switchTo().window(childWindow).getTitle() + " and URL is " + driver.switchTo().window(childWindow).getCurrentUrl());
                    driver.close();
                }
            }
        }
        catch(NoSuchWindowException e){
            System.out.println("Child window is not opened");
        }
        driver.switchTo().window(parentWindow);
        System.out.println("Parent window title is " + driver.switchTo().window(parentWindow).getTitle());
    }
}

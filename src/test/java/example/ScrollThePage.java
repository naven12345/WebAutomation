package example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollThePage {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/guru99home/");
        WebElement ele = driver.findElement(By.xpath("//h3[text()='Email Submission']"));
        JavascriptExecutor exe = (JavascriptExecutor)driver;

        /** Scroll down by pixel */
        /*exe.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(3000);*/

        /** Scroll up by pixel */
        /*exe.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(3000);*/

        /** Scroll by element visible */
        //exe.executeScript("arguments[0].scrollIntoView();", ele);

        /** Scroll down to end of page */
        //exe.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        /** Scroll horizontal till element visible */

        driver.get("https://demo.guru99.com/test/guru99home/scrolling.html");
        WebElement ele2 = driver.findElement(By.linkText("VBScript"));
        exe.executeScript("arguments[0].scrollIntoView();", ele2);
    }
}

package example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragAndDrop {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com");
        WebElement ele = driver.findElement(By.xpath("//div[contains(@class,'top-card')]//child::h5[text()='Interactions']"));
        JavascriptExecutor exe = (JavascriptExecutor)driver;
        exe.executeScript("arguments[0].scrollIntoView();", ele);
        ele.click();
        WebElement ele1 = driver.findElement(By.xpath("//div[@class = 'header-text']//following::span[text()= 'Droppable']"));
        exe.executeScript("arguments[0].scrollIntoView();", ele1);
        ele1.click();
        WebElement drag = driver.findElement(By.xpath("//div[@id = 'simpleDropContainer']//child::div[@id='draggable']"));
        exe.executeScript("arguments[0].scrollIntoView();", drag);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));

        /** using action class dragAndDrop method by locators*/
        /*WebElement drop = driver.findElement(By.xpath("//div[@id = 'simpleDropContainer']//child::div[@id='droppable']"));
        Actions action = new Actions(driver);
        action.dragAndDrop(drag,drop).build().perform();*/

        /**using dragAndDropBy method with locator and pixel*/
        WebElement accept = driver.findElement(By.id("droppableExample-tab-accept"));
        accept.click();
        WebElement acceptable = driver.findElement(By.xpath("//div[@id = 'acceptDropContainer']//child::div[@id='acceptable']"));
        Actions action = new Actions(driver);
        action.dragAndDropBy(acceptable,250,40).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        driver.quit();
    }
}



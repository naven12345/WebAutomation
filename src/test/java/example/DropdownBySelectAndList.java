package example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class DropdownBySelectAndList {
    public static void main(String[] args) throws InterruptedException, AWTException {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /**Select the dropdown value using robot calss*/

        /*driver.get("https://demoqa.com");
        WebElement ele = driver.findElement(By.xpath("//div[contains(@class,'top-card')]//child::h5[text()='Widgets']"));
        JavascriptExecutor exe = (JavascriptExecutor)driver;
        exe.executeScript("arguments[0].scrollIntoView();", ele);
        ele.click();
        WebElement ele1 = driver.findElement(By.xpath("//div[@class = 'header-text']//following::span[text()= 'Select Menu']"));
        exe.executeScript("arguments[0].scrollIntoView();", ele1);
        ele1.click();
        WebElement ele2 = driver.findElement(By.xpath("//div[text()='Select One']//following::div[contains(text(), 'Select Title')]"));
        exe.executeScript("arguments[0].scrollIntoView();", ele2);
        Thread.sleep(4000);
        ele2.click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);*/

        driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");

        /**select single value from dropdown using select class*/

        /*Select dropdown = new Select(driver.findElement(By.id("select-demo")));
        dropdown.selectByIndex(1);
        dropdown.selectByValue("Tuesday");
        dropdown.selectByVisibleText("Saturday");*/

        /**Multi Select values from dropdown using select class*/

        WebElement multi = driver.findElement(By.id("multi-select"));
        Select dropdown = new Select(multi);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", multi);
        dropdown.selectByIndex(0);
        dropdown.selectByValue("New Jersey");
        dropdown.selectByVisibleText("Ohio");
        dropdown.selectByValue("Washington");
        //to get first selected element
        WebElement selEle = dropdown.getFirstSelectedOption();
        System.out.println(selEle.getText());
        //to get all selected elements
        List<WebElement> multiEle = dropdown.getAllSelectedOptions();
        for(WebElement ele : multiEle){
            System.out.println(ele.getText());
        }
        dropdown.deselectByIndex(0);
        dropdown.deselectAll();

        /** select the random value from dropdown*/

        List<WebElement> allEle = dropdown.getOptions();
        int size = allEle.size();
        //using random class
        Random random = new Random();
        int rnum = random.nextInt(0,size);
        //using threadLocalRandom
        //int randomNumber = ThreadLocalRandom.current().nextInt(0,size);
        allEle.get(rnum).click();
    }
}

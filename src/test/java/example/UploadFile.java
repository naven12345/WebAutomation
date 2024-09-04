package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class UploadFile {
    public static void main(String[] args) throws AWTException {
        String filePath = "C:\\Users\\NAVEEN\\Downloads\\UI Automation Framework.txt";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/upload/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        WebElement element = driver.findElement(By.id("uploadfile_0"));
        element.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        /** upload file using sendkeys and file separator*/
        //String path =System.getProperty("user.home")+ File.separator +"Downloads"+File.separator+"UI Automation Framework.txt";
        //element.sendKeys(path);

        /** using javascript executor */
        /*JavascriptExecutor jsx = (JavascriptExecutor) driver;
        String jse = "arguments[0].type='file'";
        jsx.executeScript(jse, element);
        element.sendKeys(filePath);*/

        /** upload using robot class by copying path using clipboard  */
        StringSelection s = new StringSelection(filePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(s, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}

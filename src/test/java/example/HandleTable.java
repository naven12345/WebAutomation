package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.List;

public class HandleTable {

    @BeforeTest
    public void Table(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/web-table-element.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
        List<WebElement> columnsCount = driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"));
        int columns = columnsCount.size();
        System.out.println("No of columns in table are: " +columns);
        List<WebElement> rowsCount = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
        int rows = rowsCount.size();
        System.out.println("No of columns in table are: " +rows);
        WebElement value = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[3]/td[4]"));
        System.out.println("Current price of PI industries is: " +value.getText());
        System.out.println("Before test");
    }
}

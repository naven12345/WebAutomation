package example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CalendarException {

        /** select date in current month */

        @BeforeClass
        public void dateInCurrentMonth () {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/automation-practice-form");
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
            WebElement ele = driver.findElement(By.xpath("//h1[text()='Practice Form']"));
            JavascriptExecutor exe = (JavascriptExecutor) driver;
            exe.executeScript("arguments[0].scrollIntoView();", ele);
        try {
            WebElement calendar = driver.findElement(By.id("dateOfBirthInput"));
            calendar.click();
        } catch (ElementClickInterceptedException exception) {
            System.out.println("Element is not interactable to click");
        }
            System.out.println("Before class");
    }
        /*List<WebElement> dates = driver.findElements(By.xpath("//div[@class='react-datepicker__week']//following::div[contains(@aria-label, 'Choose')]"));
        for(WebElement date : dates){
            String dateList =date.getText();
            if (dateList.equalsIgnoreCase("30")){
                date.click();
                break;
            }
        }*/

        /** select month year and date in a calendar */
        @Test(enabled = false)
        public void totalDateInCalendar(){
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/automation-practice-form");
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
            WebElement ele = driver.findElement(By.xpath("//h1[text()='Practice Form']"));
            JavascriptExecutor exe = (JavascriptExecutor)driver;
            exe.executeScript("arguments[0].scrollIntoView();", ele);
            try {
                WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
                Select select = new Select(monthDropdown);
                List<WebElement> months = select.getOptions();
                for (WebElement month : months) {
                    String monthText = month.getText();
                    if (monthText.equalsIgnoreCase("August")) {
                        month.click();
                        break;
                    }
                }
            }
            catch (NoSuchElementException e){
                System.out.println("Month dropdown is not found to click");
            }
            try{
                WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
                Select select1 = new Select(yearDropdown);
                List<WebElement> years = select1.getOptions();
                for(WebElement year : years){
                    String monthText = year.getText();
                    if(monthText.equalsIgnoreCase("1998")){
                        year.click();
                        break;
                    }
                }
            }
            catch (NoSuchElementException e){
                System.out.println("Year dropdown is not found to click");
            }

            try{
                List<WebElement> dates = driver.findElements(By.xpath("//div[@class='react-datepicker__week']//following::div[contains(@aria-label, 'Choose')]"));
                for(WebElement date : dates){
                    String dateList =date.getText();
                    if (dateList.equalsIgnoreCase("15")){
                        date.click();
                        break;
                    }
                }
            }
            catch (NoSuchElementException e){
                System.out.println("Date is not found to click");
            }
        }
    }

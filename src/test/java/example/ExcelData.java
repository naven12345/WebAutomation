package example;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.time.Duration;

public class ExcelData {
    public static void main(String[] args){
        try{
            File file = new File("./Excels/students.xlsx");
            FileInputStream inputStream = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = wb.getSheet("Student Details");

            /** get the particular cell value */

            /*XSSFRow row = sheet.getRow(1);
            XSSFCell cell = row.getCell(1);
            String lastName = cell.getStringCellValue();
            System.out.println("last name of first student is " + lastName);*/

            /** get entire sheet data */

            /*int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
            for (int i=1; i<=rowCount; i++){
                int cellCount = sheet.getRow(i).getLastCellNum();
                System.out.println("Row "+ i + " data is: ");
                for(int j=0; j<cellCount; j++){
                    System.out.println(sheet.getRow(i).getCell(j).getRichStringCellValue() + ",");
                }
                System.out.println();
            }*/

            /** get data from sheet and enter in form */

            int rowCount = sheet.getLastRowNum()- sheet.getFirstRowNum();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/automation-practice-form");
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
            WebElement ele = driver.findElement(By.xpath("//h1[text()='Practice Form']"));
            JavascriptExecutor exe = (JavascriptExecutor) driver;
            exe.executeScript("arguments[0].scrollIntoView();", ele);
            WebElement firstName = driver.findElement(By.id("firstName"));
            WebElement lastName = driver.findElement(By.id("lastName"));
            firstName.sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
            lastName.sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
            XSSFCell createCell = sheet.getRow(1).createCell(3);
            createCell.setCellValue("PASS");
            XSSFRow createRow = sheet.createRow(5);
            createRow.createCell(0).setCellValue("Mobile");
            createRow.createCell(1).setCellValue("Appium");
            createRow.createCell(2).setCellValue("mobile@automation.com");
            FileOutputStream outputStream = new FileOutputStream(file);
            wb.write(outputStream);
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

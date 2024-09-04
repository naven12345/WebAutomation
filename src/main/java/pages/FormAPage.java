package pages;

import base.BasePage;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pojo.formAPojo;
import utils.JacksonUtils;

import java.time.Duration;
public class FormAPage extends BasePage {

    formAPojo formA = JacksonUtils.deserializeJson("formAlocators.json", formAPojo.class);


    public FormAPage  scrollToPageForm(){

        WebElement WebPage = DriverManager.getDriver().findElement(By.xpath(formA.getFormPage()));
        scrollToElement(WebPage);
        return this;
    }


        public FormAPage  EnterfirstName(){

            WebElement userFirstName = DriverManager.getDriver().findElement(By.id(formA.getFirstName()));
            userFirstName.sendKeys("selenium");
            return this;
        }

    public FormAPage  EnterlastName(){

        WebElement userLastName = DriverManager.getDriver().findElement(By.id(formA.getLastName()));
        userLastName.sendKeys("java");
        return this;
    }

    public FormAPage  EnterEmail(){

        WebElement userEmail = DriverManager.getDriver().findElement(By.id(formA.getEmail()));
        userEmail.sendKeys("frgdth@esgdrh.ej");
        return this;
    }
    public FormAPage  SelectGender(){
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        WebElement userGender = DriverManager.getDriver().findElement(By.xpath(formA.getGender()));
        userGender.click();
        return this;
    }
    public FormAPage  EnterNumber(){

        WebElement userNumber = DriverManager.getDriver().findElement(By.id(formA.getNumber()));
        userNumber.sendKeys("6764554343");
        return this;
    }



}

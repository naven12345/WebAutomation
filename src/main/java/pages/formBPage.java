package pages;

import base.BasePage;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pojo.formBPojo;
import utils.JacksonUtils;

public class formBPage extends BasePage {

        formBPojo formB = JacksonUtils.deserializeJson("formBlocators.json", formBPojo.class);

    public formBPage  EnterSubject(){

        WebElement userSubject = DriverManager.getDriver().findElement(By.id(formB.getSubject()));
        userSubject.sendKeys("fcdegrhyju");
        return this;
    }


    public formBPage  EnterHobbies(){

        WebElement userHobbies = DriverManager.getDriver().findElement(By.id(formB.getHobbies()));
        userHobbies.click();
        return this;
    }
}

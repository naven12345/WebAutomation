package pages;

import base.BasePage;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pojo.TestDataPojo;
import pojo.loginPojo;
import utils.JacksonUtils;


public class LoginPage extends BasePage {

    TestDataPojo data = JacksonUtils.deserializeJson("TestData.json", TestDataPojo.class);
    loginPojo login = JacksonUtils.deserializeJson("LoginPage.json", loginPojo.class);

    public LoginPage loginToApplication(){

        WebElement userEmail = DriverManager.getDriver().findElement(By.id(login.getEmail()));
        WebElement userPassword = DriverManager.getDriver().findElement(By.id(login.getPassword()));
        WebElement userLogin = DriverManager.getDriver().findElement(By.id(login.getLoginBtn()));
        userEmail.sendKeys(data.getEmail());
        userPassword.sendKeys(data.getPassword());
        userLogin.click();
        return this;
    }
}

package pages;

import base.BasePage;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pojo.TestDataPojo;
import pojo.checkoutPagePojo;
import utils.JacksonUtils;

public class CheckoutPage extends BasePage {

    TestDataPojo data = JacksonUtils.deserializeJson("TestData.json", TestDataPojo.class);
    checkoutPagePojo checkoutPage = JacksonUtils.deserializeJson("CheckOutPage.json", checkoutPagePojo.class);

    public CheckoutPage enterCountryName(){
        WebElement country = DriverManager.getDriver().findElement(By.cssSelector(checkoutPage.getSelectCountry()));
        country.sendKeys(data.getCountry());
        WebElement countryName = DriverManager.getDriver().findElement(By.xpath(checkoutPage.getCountryName()));
        moveToElementAndClick(countryName);
        //test.info("Entered country name");
        return this;
    }

    public CheckoutPage clickOnPlaceOrder(){
        WebElement placeOrder = DriverManager.getDriver().findElement(By.cssSelector(checkoutPage.getPlaceOrderBtn()));
        moveToElementAndClick(placeOrder);
        //test.info("Clicked on place order button");
        return this;
    }

    public CheckoutPage verifyTheOrderPage(){
        String confirmMessage = DriverManager.getDriver().findElement(By.cssSelector(checkoutPage.getOrderPageTitle())).getText();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(data.getOrderPageTitle()));
        //test.info("Verified the placed order page");
        return this;
    }
}

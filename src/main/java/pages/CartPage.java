package pages;

import base.BasePage;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pojo.TestDataPojo;
import pojo.cartPagePojo;
import utils.JacksonUtils;
import java.util.List;

public class CartPage extends BasePage {

    TestDataPojo data = JacksonUtils.deserializeJson("TestData.json", TestDataPojo.class);
    cartPagePojo cartPage = JacksonUtils.deserializeJson("CartPage.json", cartPagePojo.class);

    public CartPage validateTheAddedProduct(){

        List<WebElement> cartProducts = DriverManager.getDriver().findElements(By.cssSelector(cartPage.getCartProducts()));
        Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(data.getProductName()));
        Assert.assertTrue(match);
        //test.info("Verified the added product in cart");
        return this;
    }

    public CartPage clickOnCheckOut(){

        WebElement checkOutBtn = DriverManager.getDriver().findElement(By.xpath(cartPage.getCheckoutBtn()));
        moveToElementAndClick(checkOutBtn);
        //test.info("Clicked on checkout button");
        return this;
    }
}

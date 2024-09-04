package pages;

import base.BasePage;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pojo.TestDataPojo;
import pojo.loginPojo;
import pojo.productsPagePojo;
import utils.JacksonUtils;

import java.time.Duration;
import java.util.List;

public class ProductsPage extends BasePage {
    TestDataPojo data = JacksonUtils.deserializeJson("TestData.json", TestDataPojo.class);
    productsPagePojo productPage = JacksonUtils.deserializeJson("ProductsPage.json", productsPagePojo.class);

    public ProductsPage addProductToCart(){
        productsPagePojo productPage = JacksonUtils.deserializeJson("ProductsPage.json", productsPagePojo.class);

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(productPage.getProducts())));
        List<WebElement> products = DriverManager.getDriver().findElements(By.cssSelector(productPage.getProducts()));

        WebElement prod = products.stream().filter(product->
                product.findElement(By.cssSelector(productPage.getProductName())).getText().equals(data.getProductName())).findFirst().orElse(null);
        prod.findElement(By.cssSelector(productPage.getAddToCartBtn())).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(productPage.getProductAddedToaster())));
        //test.info("Added product to the cart");
        return this;
    }

    public ProductsPage clickOnCartIcon(){
        DriverManager.getDriver().findElement(By.cssSelector(productPage.getCartIcon())).click();
        //test.info("Clicked on cart icon");
        return this;
    }
}

package example;

import base.BaseTest;
import listeners.Retry;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class EndToEndFlow extends BaseTest {

    ProductsPage productsPage = new ProductsPage();
    LoginPage loginPage = new LoginPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();


    @Test(description = "Login to the application, add product to cart and verify the place the order",retryAnalyzer = Retry.class)
    public void loginAndAddProductToCart(){
        loginPage.loginToApplication();
        productsPage.addProductToCart();
        productsPage.clickOnCartIcon();
        cartPage.validateTheAddedProduct();
        cartPage.clickOnCheckOut();
        checkoutPage.enterCountryName();
        checkoutPage.clickOnPlaceOrder();
        checkoutPage.verifyTheOrderPage();
    }

    @Test(description = "Login to the application with user credentials")
    public void loginToApplication() {
        loginPage.loginToApplication();
    }
}

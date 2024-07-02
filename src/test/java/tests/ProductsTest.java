package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest {

    private String goodsName = "Sauce Labs Backpack";

    @Test
    public void buyProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isOpened();
        productsPage.addToCart(goodsName);
        productsPage.addToCart(2);
        productsPage.openCart();
        assertTrue(cartPage.getProductsNames().contains(goodsName));
    }
}

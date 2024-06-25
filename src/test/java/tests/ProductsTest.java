package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest {

    private String goodsName = "Sause Labs Backpack";

    @Test
    public void buyProduct() {
        loginPage.open();
        loginPage.pushSubmitButton();
//        loginPage.login("standard_user", "secret_sauce");
        productsPage.isOpened();
        productsPage.addToCart(goodsName);
        productsPage.addToCart("Sause Labs Bike Light");
        productsPage.openCart();
        assertTrue(productsPage.getProductsNames().contains(goodsName));

//        Alert alert = (Alert) driver.findElement(By.xpath("")); //- Алерты
//        alert.accept(); //- Принимаем
//        alert.dismiss(); // - Не принимаем

//        driver.switchTo().frame("") //-Frame
//        driver.switchTo().defaultContent(); //-возвращаемся назад обязательно

        Actions actions = new Actions(driver);
        actions
                .moveToElement(driver.findElement(By.id("")))
                .clickAndHold()
                .moveToElement(driver.findElement(By.id("")))
                .release()
                .build();
    }
}

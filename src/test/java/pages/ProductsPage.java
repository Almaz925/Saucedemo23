package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private final By TITLE = By.cssSelector("[class=title]");
    private final By CART = By.cssSelector(".shping_cart_link");
    private final By ADD_TO_CART_PATTERN =
            By.xpath("//div[text()='%s']//ancestor::div[@class='inventory_item']//button[text()='Add to cart']");

    public void isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public void addToCart(String product) {
        By addToCartButton = By.xpath(String.format(product, ADD_TO_CART_PATTERN));
        driver.findElement(addToCartButton).click();
    }

    public void addToCart(int index) {
        driver.findElements(By.xpath("//*[@class='inventory_item']//button")).get(2).click();
    }

    public void openCart() {
        driver.findElement(CART).click();
    }

    public ArrayList<String> getProductsNames() {
        List<WebElement> allProductsNames = driver.findElements(By.cssSelector(".inventory_item"));
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product: allProductsNames) {
            names.add(product.getText());
        }
        return names;
    }
}

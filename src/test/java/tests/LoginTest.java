package tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void correctLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][] {
                {"","secret_sauce","Epic sadface: Username is required"},
                {"standard_user","","Epic sadface: Password is required"},
                {"locked_out_user","secret_sauce","Epic sadface: Sorry, this user has been locked out."}
        };
    }

    @Test(dataProvider = "loginData")
    public void emptyLogin(String user, String password, String expectedEror) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(driver.findElement(By.xpath("//h3[@data-test='error']")).getText(), expectedEror);
    }

    @Test
    public void emptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(driver.findElement(By.xpath("//h3[@data-test='error']")).getText(), "Epic sadface: Password is required");
    }

    @Test
    public void lockedUser() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(driver.findElement(By.xpath("//h3[@data-test='error']")).getText(), "Epic sadface: Sorry, this user has been locked out.");
    }
}

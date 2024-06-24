package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    @Test
    public void correctLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(driver.findElement(By.xpath("//span[@class='title']")).getText(), "Products");
    }

    @Test
    public void emptyLogin(){
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(driver.findElement(By.xpath("//h3[@data-test='error']")).getText(),"Epic sadface: Username is required");

    }

    @Test
    public void emptyPassword(){
        loginPage.open();
        loginPage.login("standard_user","");
assertEquals(driver.findElement(By.xpath("//h3[@data-test='error']")).getText(),"Epic sadface: Password is required" );
    }

    @Test
    public void lockedUser(){
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(driver.findElement(By.xpath("//h3[@data-test='error']")).getText(),"Epic sadface: Sorry, this user has been locked out." );
    }
}

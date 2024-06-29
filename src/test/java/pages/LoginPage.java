package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By USERNAME_INPUT = By.id("user-name");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MESSAGE = By.xpath("//h3[@data-test='error']");

    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }

    public void login(String user, String password) {
    fillInUserName(user);
    fillInPassword(password);
    pushSubmitButton();
    }

    public void fillInUserName(String user) {
        driver.findElement(USERNAME_INPUT).sendKeys(user);
    }

    public void fillInPassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void pushSubmitButton() {
        driver.findElement(LOGIN_BUTTON).submit();
    }

    public String getErrorMesage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}

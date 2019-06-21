package PageObjects;

import Config.WebDriverHelper;
import com.google.inject.Inject;
import org.openqa.selenium.By;

/**
 * Created by Petert on 5/4/19.
 */
public class LoginPage extends BasePage {

    @Inject
    public LoginPage(WebDriverHelper webDriverHelper) {
        super(webDriverHelper.driver);
    }

    //***Web elements***
    By loginInput = By.id("login");
    By passwordInput = By.id("password");
    By loginButton = By.cssSelector("[type='submit']");

    //Page methods
    public LoginPage goToLoginPage(String url) {
        driver.get(url);
        return this;
    }

    public LoginPage loginToAdmin(String email, String password) {
        //fill in email
        writeText(loginInput, email);
        //fill in password
        writeText(passwordInput, password);
        //click on Login button
        click(loginButton);
        return this;
    }

    public void successfulLogin() {
        //go to dosvit page
        driver.get("https://someURL/admin/");
        //fill in email
        writeText(loginInput, "LOGIN");
        //fill in password
        writeText(passwordInput, "PASSWORD");
        //click on Login button
        click(loginButton);
    }
}

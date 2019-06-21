package PageObjects;

import Config.WebDriverHelper;
import com.google.inject.Inject;
import org.openqa.selenium.By;

/**
 * Created by Petert on 5/5/19.
 */
public class AdminMainPage extends BasePage {

    @Inject
    public AdminMainPage(WebDriverHelper webDriverHelper) {
        super(webDriverHelper.driver);
    }

    //*****Web elements*****
    By newsButton = new By.ByCssSelector("[href='/admin/application/news/']");

    //*****Methods******
    public void clickOnNewsButton() {
        click(newsButton);
    }

    public void checkNewsButtonIsDisplayed() {
        assertElementIsDisplayed(newsButton);
    }
}

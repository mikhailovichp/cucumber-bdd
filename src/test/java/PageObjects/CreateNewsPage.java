package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Petert on 5/5/19.
 */
public class CreateNewsPage extends BasePage {
    public CreateNewsPage(WebDriver driver) {
        super(driver);
    }

    //***Web elements***
    By nazva = new By.ByCssSelector("TYPE SELECTOR HERE!!!");
    By zagolovok = new By.ByCssSelector("TYPE SELECTOR HERE!!!");
    By shortText = new By.ByCssSelector("TYPE SELECTOR HERE!!!");

}

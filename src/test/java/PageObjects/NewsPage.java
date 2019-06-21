package PageObjects;

import Config.VarVault;
import Config.WebDriverHelper;
import CustomExceptions.DeletedElementIsPresentException;
import com.google.inject.Inject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * Created by Petert on 5/5/19.
 */
public class NewsPage extends BasePage{

    @Inject
    public NewsPage(WebDriverHelper webDriverHelper) {
        super(webDriverHelper.driver);
    }

    //***Web elements***
    By addNewsButton = new By.ByCssSelector("[name='add']");
    By nazva = new By.ById("news-slug");
    By zagolovok = new By.ById("news-title");
    By shortText = new By.ById("news-teaser");
    By newsDropdown = new By.ById("news-type");
    By newsSubmit = new By.ById("news-submit");
    By newsTable = new By.ById("news-list");
    By successButton = new By.ByCssSelector(".css-1mksbi-PrimaryBtn");
    By firstNewsItem = new By.ByCssSelector(".css-5msylx-ClickableTitle");
    By deleteNewsItemButton = new By.ByCssSelector(".e1cm62nl5[type='button']");

    //***Page methods***
    public void goToNewsPage() {
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.get("https://someURL/application/news/list");
    }

    public void clickOnaddNewNewsButton() {
        click(addNewsButton);
    }

    public void setNazva() {
        String randomNazva = generateRandomNazva();
        writeText(nazva, randomNazva);
    }

    public void setZagolovok() {
        String randomZagolovok = generateRandomZagolovok();
        writeText(zagolovok, randomZagolovok);
        VarVault.getInstance().setNewsZagolovok(randomZagolovok);
    }

    public void setShortText(String arg) {
        writeText(shortText, arg);
    }

    public void selectNewsType(String type) {
        writeText(newsDropdown, type);
        driver.findElement(newsDropdown).sendKeys(Keys.RETURN);
    }

    public void clickOnSubmitButton() {
        click(newsSubmit);
    }

    public void clickOnSuccessButton() {
        click(successButton);
    }

    public void waitForNewsTableToLoad() {
        waitForVisibility(newsTable);
    }

    public void assertTextOfLastAddedNews() {
        WebElement newsTabl = driver.findElement(By.id("news-list"));
        Assert.assertTrue(newsTabl.findElement(By.xpath("//*[contains(text(), '" + VarVault.getInstance().getNewsZagolovok() + "')]")).isDisplayed());
    }

    public void assertDeletedNewsItemIsAbsent() {
        WebElement newsTabl = driver.findElement(By.id("news-list"));
        try {
            if (newsTabl.findElement(By.xpath("//*[contains(text(), '" + VarVault.getInstance().getNewsZagolovok() + "')]")).isDisplayed()) {
                System.out.println("Deleted news item is still here");
                throw new DeletedElementIsPresentException();
            }
        }
        catch (Exception e) {
            System.out.println("No deleted news item was found - success!");
        }
    }

    public void clickOnTheFirstNewsItem() {
        getFirstNewsItemText();
        click(firstNewsItem);
    }

    public void clickOnDeleteNewsItemButton() {
        click(deleteNewsItemButton);
    }

    public void clickOnDeleteConfirmationButton() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("document.querySelector(\".css-1xup5vd-PrimaryBtn\").click()");
    }

    private String generateRandomNazva() {
        String randomNazva = "nazva";
        double NazvaAddition = (Math.random()*((99999-10000)+1))+10000;
        return randomNazva + NazvaAddition;
    }

    private String generateRandomZagolovok() {
        String randomZagolovok = "zagolovok";
        double zagolovokAddition = (Math.random()*((99999-10000)+1))+10000;
        return randomZagolovok + zagolovokAddition;
    }

    private String getFirstNewsItemText() {
        String firstNewsItemText = readText(firstNewsItem);
        VarVault.getInstance().setNewsZagolovok(firstNewsItemText);
        return firstNewsItemText;
    }

}

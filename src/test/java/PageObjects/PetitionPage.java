package PageObjects;

import Config.VarVault;
import Config.WebDriverHelper;
import com.google.inject.Inject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * Created by Petert on 6/12/19.
 */
public class PetitionPage extends BasePage {

    @Inject
    public PetitionPage(WebDriverHelper webDriverHelper) {
        super(webDriverHelper.driver);
    }

    //***Web elements***
    By addPetitionButton = new By.ById("petition-create");
    By userInput = new By.ByCssSelector("[type='text']");
    By selectUserFromDropdown = new By.ByCssSelector(".eyaizos3");
    By viznachitiButton = new By.ByCssSelector(".css-s8asp7-Button-SubmitButton");
    By zagolovokInput = new By.ById("petitions-title");
    By petitionCategoryInput = new By.ById("petitions-category");
    By petitionTextInput = new By.ById("petitions-body");
    By stvoritButton = new By.ById("petitions-submit");

    //***Page methods***
    public void goToPetitionPage() {
        driver.get("https://someURL/application/petitions/list");
    }

    public void clickOnAddPetitionButton() {
        click(addPetitionButton);
    }

    public void fillInUser(String userName) {
        writeText(userInput, userName);
        click(selectUserFromDropdown);
    }

    public void clickOnViznachitiButton() {
        click(viznachitiButton);
    }

    public void fillInZagolovok() {
        String randomZagolovok = generateRandomPetitionZagolovok();
        writeText(zagolovokInput,randomZagolovok);
        VarVault.getInstance().setPetitionZagolovok(randomZagolovok);
    }

    public void selectPetitionType(String type) {
        writeText(petitionCategoryInput, type);
        driver.findElement(petitionCategoryInput).sendKeys(Keys.RETURN);
    }

    public void fillPetitionText(String petitionText) {
        writeText(petitionTextInput, petitionText);
    }

    public void clickOnStrvoritiButton() {
        click(stvoritButton);
    }

    public void assertAddedPetitionIsPresent() {
        WebElement petitionTable = driver.findElement(By.cssSelector(".css-13c2mhq-TableStyled"));
        Assert.assertTrue(petitionTable.findElement(By.xpath("//*[contains(text(), '" + VarVault.getInstance().getPetitionZagolovok() + "')]")).isDisplayed());
    }

    //Private functions
    private String generateRandomPetitionZagolovok() {
        String randomLZagolovok = "Zagolovok";
        double zagolovokAddition = (Math.random()*((99999-10000)+1))+10000;
        return randomLZagolovok + zagolovokAddition;
    }

}

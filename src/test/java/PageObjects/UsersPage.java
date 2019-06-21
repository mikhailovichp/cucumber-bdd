package PageObjects;

import Config.VarVault;
import Config.WebDriverHelper;
import Helpers.Helpers;
import com.google.inject.Inject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.net.URISyntaxException;

/**
 * Created by Petert on 5/10/19.
 */
public class UsersPage extends BasePage {

    private String inn;

    @Inject
    public UsersPage(WebDriverHelper webDriverHelper) {
        super(webDriverHelper.driver);
    }

    //***Web elements***
    By addUserButton = new By.ByCssSelector("[name='add']");
    By INNinput = new By.ByCssSelector("[name='inn'][aria-required='true']");
    By lastName = new By.ByCssSelector("[name='surname'][aria-required='true']");
    By name = new By.ByCssSelector("[aria-required='true'][name='first_name']");
    By passport = new By.ByCssSelector("[aria-required='true'][name='passport']");
    By passportPhoto = new By.ById("user-scans");
    By INNPhoto = new By.ById("user-innScan");
    By photoWithPassport = new By.ById("user-photo");
    By login = new By.ByCssSelector("[name='login'][aria-required='true']");
    By password = new By.ByCssSelector("[aria-required='true'][name='password']");
    By addressMain = new By.ByCssSelector("#select-address[required='']");
    By editAddress = new By.ByXPath("(//input[@id='select-address'])[2]");
    By addressDropdown = new By.ByCssSelector("[role='menuitem']");
    By saveButton = new By.ByCssSelector(".exry2qn2");
    By successButton = new By.ByCssSelector(".css-1mksbi-PrimaryBtn");
    By usersTable = new By.ByCssSelector("table");
    By userSettingsIcon = new By.ByXPath("(//button)[2]");
    By editUserItem = new By.ByCssSelector("[role='menuitem']");
    By street = new By.ById("street");
    By city = new By.ById("city");
    By state = new By.ById("state");
    By district = new By.ById("district");
    By building = new By.ById("building");
    By apartment = new By.ById("apartment");
    By postcode = new By.ById("postcode");


    //***Page methods***
    public void goToUsersPage() {
        driver.get("https://someURL/admin/users");
    }

    public void clickOnAddButton() {
        try {
            click(addUserButton);
        }
        catch (Exception e) {
            driver.findElement(addUserButton).click();
        }
    }

    public void fillINN() {
        String generatedInn = VarVault.getInstance().getInn();
        writeText(INNinput,generatedInn);
    }

    public void fillINNwithValue(String inn) {
        writeText(INNinput, inn);
    }

    public void fillLastName(String lName) {
        writeText(lastName, lName);
    }

    public void fillName(String nam) {
        writeText(name, nam);
    }

    public void fillFirstNameRandom() {
        String randonFirstName = generateRandomString("FirstName");
        VarVault.getInstance().setfirstName(randonFirstName);
        clearThenWriteText(name, randonFirstName);
    }

    public void fillLastNameRandom() {
        String randomLastName = generateRandomString("LastName");
        VarVault.getInstance().setLastName(randomLastName);
        clearThenWriteText(lastName, randomLastName);
    }

    public void fillPassport(String param) {
        writeText(passport, param);
    }

    public void addPassportPhoto() throws URISyntaxException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("document.querySelector(\"div[class*=css-1hak2z0-Wrapper]\").setAttribute('class', 'a')");
        jse.executeScript("document.querySelector(\"div[class*=css-14j7rxv-Wrapper]\").setAttribute('class', 'a')");
        writeText(passportPhoto, Helpers.getInstance().getFileFromResources("stetim.jpg"));
    }

    public void addInnPhoto() throws URISyntaxException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("document.querySelector(\"div[class*=css-1hak2z0-Wrapper]\").setAttribute('class', 'a')");
        jse.executeScript("document.querySelector(\"div[class*=css-14j7rxv-Wrapper]\").setAttribute('class', 'a')");
        writeText(INNPhoto, Helpers.getInstance().getFileFromResources("stetim.jpg"));
    }

    public void addPhotoWithPassport() throws URISyntaxException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("document.querySelector(\"div[class*=css-1hak2z0-Wrapper]\").setAttribute('class', 'a')");
//        jse.executeScript("document.querySelector(\"div[class*=css-14j7rxv-Wrapper]\").setAttribute('class', 'a')");
        writeText(photoWithPassport, Helpers.getInstance().getFileFromResources("stetim.jpg"));
    }

    public void fillRandomLogin() {
        writeText(login, generateRandomString("TestUser"));
    }

    public void fillPassword(String passwordText) {
        writeText(password, passwordText);
    }

    public void fillAddress() {
        writeText(addressMain, "12");
        click(addressDropdown);
    }

    public void fillRandomAddress() {
        writeText(editAddress, "asdaasdzxczxczcxadsdad");
        try{
            click(addressDropdown);
        }
        catch (Exception e) {
            //Do nothing
        }
        String randomStreet = generateRandomString("street");
        VarVault.getInstance().setStreet(randomStreet);
        click(street);
        clearThenWriteText(street, randomStreet);
        String randomCity = generateRandomString("city");
        VarVault.getInstance().setCity(randomCity);
        click(city);
        clearThenWriteText(city, randomCity);
        String randomBuilding = generateRandomString("building");
        VarVault.getInstance().setBuilding(randomBuilding);
        click(building);
        clearThenWriteText(building, randomBuilding);
        click(passport);
    }

    public void clickOnZberegtiButton() {
        click(saveButton);
    }

    public void clickOnSuccessButton() {
        click(successButton);
    }

    public void openEditUserPanel() {
        click(userSettingsIcon);
        click(editUserItem);
    }

    public void checkUserWithDefinedTextExists(String text) {
        waitForVisibility(usersTable);
        WebElement userTable = driver.findElement(usersTable);
        Assert.assertTrue(userTable.findElement(By.xpath("//*[contains(text(), '"+text+"')]")).isDisplayed());
    }

    public void assertUserWithSuchInnPopupErrorIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'GraphQL error: Користувач з таким ІПН вже зареєстрований')]")).isDisplayed());
    }

//Private functions
    private String generateRandomString(String goal) {
        double addition = (Math.random()*((99999-10000)+1))+10000;
        return goal + addition;
    }

    public void findNotUsedINN() {
        WebElement userTable = driver.findElement(usersTable);

        JSONArray jsonArray = Helpers.getInstance().getAllInns();
        for (int i=0; i<jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            try {
                if (!userTable.findElement(By.xpath("//*[contains(text(), '" + jsonObject.get("inn").toString() + "')]")).isDisplayed()) {
                    VarVault.getInstance().setInn(jsonObject.get("inn").toString());
                    break;
                }
            } catch (Exception e) {
                VarVault.getInstance().setInn(jsonObject.get("inn").toString());
                break;
            }
        }

    }

}

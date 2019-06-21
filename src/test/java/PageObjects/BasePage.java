package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Petert on 5/4/19.
 */
public class BasePage {
    protected WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 7);
    }

    //Wait wrapper
    public void waitForVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void waitForElementIsClickable(By elementBy) {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    //Click method
    public void click(By elementBy) {
        waitForVisibility(elementBy);
        waitForElementIsClickable(elementBy);
        driver.findElement(elementBy).click();
    }

    //Write text
    public void writeText(By elementBy, String text) {
        waitForVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    //Write text
    public void clearThenWriteText(By elementBy, String text) {
        waitForVisibility(elementBy);
        writeText(elementBy, "123");
        for (int i=0; i<60; i++) {
            driver.findElement(elementBy).sendKeys(Keys.BACK_SPACE);
        }
        driver.findElement(elementBy).sendKeys(text);
    }

    //Read text
    public String readText(By elementBy) {
        waitForVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    //Assert
    public void assertTextMatches(By elementBy, String assertedText) {
        waitForVisibility(elementBy);
        Assert.assertEquals(readText(elementBy), assertedText);
    }

    public void assertElementIsDisplayed (By elementBy) {
        waitForVisibility(elementBy);
        Assert.assertTrue(driver.findElement(elementBy).isDisplayed());
    }

    //Select from dropdown
    public void selectOptionFromDropdownByText(By element, String text) {
        Select dropdown = new Select(driver.findElement(element));
        dropdown.selectByVisibleText(text);
    }
}

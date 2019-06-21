package BaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Petert on 5/9/19.
 */
public class DriverBase {

    private RemoteWebDriver driver = null;

    public WebDriver getDriver() {
        boolean isRemote = Boolean.parseBoolean(System.getProperty("remote", "false"));
        System.out.println("isRemote:" + isRemote);

        if (driver == null) {
            if (isRemote) {
                ChromeOptions chromeOptions = new ChromeOptions();
                try {
                    driver = new RemoteWebDriver(new URL("https://SPECIFY-LINK-TO-SELENIUM-HUB/wd/hub"), chromeOptions);
                    driver.setFileDetector(new LocalFileDetector());
                }
                catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else {
                driver = new ChromeDriver();
            }
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

}

package Config;

import BaseClasses.DriverBase;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;

/**
 * Created by Petert on 5/18/19.
 */

@ScenarioScoped
public class WebDriverHelper {

    public DriverBase driverBase = new DriverBase();
    public WebDriver driver = driverBase.getDriver();
}

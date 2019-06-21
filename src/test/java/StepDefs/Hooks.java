package StepDefs;

import Config.WebDriverHelper;
import com.google.inject.Inject;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

/**
 * Created by Petert on 5/17/19.
 */
public class Hooks {
    @Inject
    private WebDriverHelper webDriverHelper;

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            try {
                File scrFile = ((TakesScreenshot) webDriverHelper.driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File(("user.dir") + "screenshots.png"));
            } catch (Exception e) {
                System.out.println(e.getCause());
            }
        }
        webDriverHelper.driver.quit();
    }
}

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Petert on 5/5/19.
 */
@CucumberOptions(
        features = "src/test/java/Features/",
        glue = {"StepDefs"},
        format = {"pretty"}
)

@RunWith(Cucumber.class)
public class TestRunner {
}

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features/findRestaurants.feature"},
        strict = false, plugin = {"pretty",
        "json:target/cucumber_json_reports/just-eat.json",
        "html:target/just-eat-html"},
        glue = {"utilties",
        		"com.justeat.testing.steps"})
public class FindRestaurantsTest {
}
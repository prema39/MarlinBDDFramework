import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = {"pretty" ,"html:target" , "json:target/cucumber.json" , "junit:test/cucumber.xml"}
        ,features = "src/test/resources/features"
, tags = "@addKPI"
        , dryRun = false
)
public class Runner extends AbstractTestNGCucumberTests {

}

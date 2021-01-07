package runner;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/cuke/DemoSite.feature",plugin = {"pretty"}, monochrome=true,glue = {"stepdef"})
public class Runner {

}

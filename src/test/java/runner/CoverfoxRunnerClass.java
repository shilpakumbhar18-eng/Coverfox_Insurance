package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {
				"C:\\Users\\shilp\\Desktop\\clone project\\31May25SoftwareTesting\\src\\test\\resources\\coverFoxFeatures\\coverFoxHealthInsurance.feature"
		}
		,glue= {"stepDefinitions", "hooks"}, 
				plugin={"pretty","html:target/CucumberReports/reports.html"}, 
				publish= true,  
				dryRun= false
				
		)
public class CoverfoxRunnerClass extends AbstractTestNGCucumberTests {

}

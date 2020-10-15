package SetupClass.TestStep;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import SetupClass.Setup;
import cucumber.api.Scenario;
import cucumber.api.java.After;


	public class TakeImageStep extends Setup {
		@After
		public void tearDown(Scenario scenario) {
		    if (scenario.isFailed()) {	    	
		      log.info("Scenario failed, now taking screenshot");
		      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		      scenario.embed(screenshot, "image/png");
		    }
		}
	}

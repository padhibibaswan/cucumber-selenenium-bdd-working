package StepDefinations;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	TestContext testContext;

	public Hooks(TestContext context) {
	testContext = context;
	}
	
	@Before
public void BeforeSteps(Scenario scenario) {
	if (scenario.getName().equals("Login as a authenticated user")) Reporter.assignAuthor("Sanjit");
	else if (scenario.getName().equals("Create a Site")) Reporter.assignAuthor("Some Other User");
	Reporter.addScenarioLog("testing at your door step");
}
	 @After
	 public void AfterSteps(Scenario scenario) {
	 //if (scenario.isFailed()) {
		 String screenshotName = scenario.getName().replaceAll(" ", "_");
		 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 try {
		 //This takes a screenshot from the driver at save it to the specified location
		 File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
		 
		 //Building up the destination path for the screenshot to save
		 //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
		 File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName +timeStamp+ ".png");
		 
		 //Copy taken screenshot from source location to destination location
		 Files.copy(sourcePath, destinationPath);   
		 
		 //This attach the specified screenshot to the test
		 Reporter.addScreenCaptureFromPath("screenshots\\"+screenshotName+timeStamp+".png".toString());
		 //Reporter.addScreenCaptureFromPath(destinationPath.toString());
		 } catch (IOException e) {
		 } 
		 //}
	 testContext.getWebDriverManager().closeDriver();
	 }
}

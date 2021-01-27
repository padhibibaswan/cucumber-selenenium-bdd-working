package Runner;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/java/Features/2_CreateDI.feature"
,glue= {"StepDefinations"}
,plugin = { "com.cucumber.listener.ExtentCucumberFormatter:"}
,monochrome = true
)
public class testRunner {
	@BeforeClass
	public static void setup() {
	ExtentProperties extentProperties = ExtentProperties.INSTANCE;
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	String userDir =System.getProperty("user.dir");
	
	extentProperties.setReportPath(userDir+ "/target/cucumber-reports/report_"+timeStamp+".html");
	}
//target/cucumber-reports/report.html	
@AfterClass
public static void writeExtentReport() {
    Reporter.loadXMLConfig(new File("configs/report.xml"));
    Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
    Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
    Reporter.setSystemInfo("Selenium", "3.7.0");
    Reporter.setSystemInfo("Maven", "3.5.2");
    Reporter.setSystemInfo("Java Version", "1.8.0_151");

}
	
}

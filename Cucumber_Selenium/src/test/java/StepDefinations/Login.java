package StepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

import Managers.PageObjectManager;
import Managers.WebDriverManager;
import cucumber.TestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProviders.ConfigFileReader;
import pageObjects_ObjectRepository.HomePage;
import pageObjects_ObjectRepository.LoginPage;
import Managers.FileReaderManager;
public class Login {
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	PageObjectManager pageObjectManager;
	ConfigFileReader configFileReader;
	WebDriverManager webDriverManager;
	TestContext testContext;
	public Login(TestContext context) {
		 testContext = context;
		 loginpage = testContext.getPageObjectManager().getLoginPage();
		 }
	@Given("^Launch the application$")
	public void Launch_the_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//configFileReader= new ConfigFileReader();
		//System.setProperty("webdriver.chrome.driver",FileReaderManager.getInstance().getConfigReader().getDriverPath());
		//webDriverManager = new WebDriverManager();
		//driver = webDriverManager.getDriver();
		pageObjectManager = new PageObjectManager(driver);
		Reporter.addStepLog("Application launched successfully");
		
		
	}

	@When("^User open url$")
	public void User_open_url() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	
		pageObjectManager = new PageObjectManager(driver);
		 
		 loginpage.navigateTo_LoginPage(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		 //driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		 Reporter.addStepLog("navigated to URL successfully");
		 
	}

	@Then("^login to application$")
	public void login_to_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		pageObjectManager = new PageObjectManager(driver);
		
		loginpage.changeframeto("nav");
		loginpage.login.click();
		
		Reporter.addStepLog("Login successfully");
		Thread.sleep(3000);
		
	}
	
	

	


	
}

package StepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects_ObjectRepository.HomePage;

public class Home {
	TestContext testContext;
	 HomePage homepage;
 public Home(TestContext context) {
	 testContext = context;
	 homepage = testContext.getPageObjectManager().getHomePage();
	 }
	 
@When("^create Site from the Home Page$")
public void create_Site_from_the_Home_Page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Reporter.addStepLog("user is creating the site");
}

@Then("^Site creation messgas should appear$")
public void site_creation_messgas_should_appear() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	Reporter.addStepLog("User has successfully created the site");
    
}

@Then("^success message is displayed$")
public void success_message_is_displayed() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	
	String a=homepage.lbl_home.getText();
	
	Reporter.addStepLog(" in the hoemapge "+a);
	Reporter.addStepLog("Home page verified successfully");
}	
}
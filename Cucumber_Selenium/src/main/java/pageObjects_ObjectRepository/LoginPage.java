package pageObjects_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
			 this.driver = driver;
			 PageFactory.initElements(driver, this);
	}

	public void navigateTo_LoginPage(String url) {
	driver.get(url);
	}
	
	public void changeframeto(String name) {
		name="driks"+name;
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(name)); 
	}

	@FindBy(how = How.XPATH, using = "/html/body/table/tbody/tr/td[21]/a") 
										
	public WebElement login;
	
	@FindBy(how = How.LINK_TEXT, using ="Opret driftinfo")
	public WebElement OperateDI;
	
	@FindBy(how = How.NAME, using ="driksnav")
	public WebElement topframe;
	
	
	
}

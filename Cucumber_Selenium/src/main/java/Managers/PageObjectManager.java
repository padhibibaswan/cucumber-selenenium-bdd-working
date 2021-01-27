package Managers;

import org.openqa.selenium.WebDriver;

import pageObjects_ObjectRepository.ChangeDIpage;
import pageObjects_ObjectRepository.CreateTaskPage;
import pageObjects_ObjectRepository.FasDriksPage;
import pageObjects_ObjectRepository.HomePage;
import pageObjects_ObjectRepository.LoginPage;
import pageObjects_ObjectRepository.StartSubtaskPage;
import pageObjects_ObjectRepository.ViewTaskPage;

public class PageObjectManager {

private WebDriver driver;
private LoginPage loginpage;
private HomePage homepage;
private CreateTaskPage createtaskpage;
public ViewTaskPage viewtaskpage;
public StartSubtaskPage startsubtaskpage;
public ChangeDIpage changepage;
public FasDriksPage faspage;

public PageObjectManager(WebDriver driver) {	 
	 this.driver = driver;
	 }
public LoginPage getLoginPage(){
	 
return (loginpage == null) ? loginpage = new LoginPage(driver) : loginpage;

	}	

public HomePage getHomePage(){
	 
return (homepage == null) ? homepage = new HomePage(driver) : homepage;

	}
public CreateTaskPage getCreateTaskPage() {
	// TODO Auto-generated method stub
	return (createtaskpage == null) ? createtaskpage = new CreateTaskPage(driver) : createtaskpage;
}
public ViewTaskPage getViewTaskPage() {
	// TODO Auto-generated method stub
	return (viewtaskpage == null) ? viewtaskpage = new ViewTaskPage(driver) : viewtaskpage;	
}
public StartSubtaskPage getStartSubtaskPage() {
	// TODO Auto-generated method stub
	return (startsubtaskpage == null) ? startsubtaskpage = new StartSubtaskPage(driver) : startsubtaskpage;
}
public ChangeDIpage getChangeDIpage() {
	// TODO Auto-generated method stub
	return (changepage == null) ? changepage = new ChangeDIpage(driver) : changepage;
}
public FasDriksPage getFasDriksPage() {
	// TODO Auto-generated method stub
	 return (faspage == null) ? faspage = new FasDriksPage(driver) : faspage;
}

}

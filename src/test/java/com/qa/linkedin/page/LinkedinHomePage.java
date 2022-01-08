package com.qa.linkedin.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.log4testng.Logger;

public class LinkedinHomePage extends BasePageWeb{
	
	private static Logger log=Logger.getLogger(LinkedinHomePage.class);
	
	public LinkedinHomePage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(@class,'nav-logo lazy-loaded')]")
	private WebElement linkedinLogo;
	
	@FindBy(linkText="Sign in")
	private WebElement SigninLink;
		
	@FindBy(css="h1.header__content__heading ")
	private WebElement welcomeBackHeaderTxt;
	
	@FindBy(id="username")
	private WebElement emailEditbox;
	
	@FindBy(name="session_password")
	private WebElement passwordEditbox;
	
	@FindBy(css="button[class*='btn__primary--large']")
	private WebElement signinBtn;
	
	String homePgTitle="LinkedIn: Log In or Sign Up";
	String loginPagTitle="LinkedIn Login, Sign in | LinkedIn";
	public void verifyLinkedinHomePageTitle() {
		log.debug("Verifying the Linkedin Home page title: "+homePgTitle);
		wait.until(ExpectedConditions.titleIs(homePgTitle));
		Assert.assertEquals(driver.getTitle(), homePgTitle);
	}
	
	public void verifyLinkedinLogo() throws InterruptedException {
		log.debug("Verifying the Linkedin Logo presence...");
		Assert.assertTrue(isDisplayedElement(linkedinLogo));
	}
	
	public void clickSigninLink() throws InterruptedException {
		log.debug("click on Signin Link in LinkedinHomepage");
		click(SigninLink);
		
	}
	
	public void verifyLinkedinLoginPageTitle() {
		log.debug("Verifying the Linkedin login page title: "+loginPagTitle);
		wait.until(ExpectedConditions.titleIs(loginPagTitle));
		Assert.assertEquals(driver.getTitle(), loginPagTitle);
	}
	
	public void verifyWelcomeBackHeaderText() throws InterruptedException {
		log.debug("Verifying the WelcomeBackHeaderText...");
		Assert.assertTrue(isPresentElement(welcomeBackHeaderTxt));
	}
	
	public void clickSigninBtn() throws InterruptedException {
		log.debug("click on Signin Button in LinkedinLoginpage");
		click(signinBtn);
		
	}
	
	public LinkedinLoggedInPage doLogin(String uname,String pwd) throws Exception {
		log.debug("clear the content in  email editbox");
		clearText(emailEditbox);
		log.debug("type the email value "+uname+" in email editbox");
		sendKey(emailEditbox, uname);
		log.debug("clear the content in password editbox");
		clearText(passwordEditbox);
		log.debug("type the password value "+pwd+" in password editbox");
		sendKey(passwordEditbox, pwd);
		clickSigninBtn();
		return new LinkedinLoggedInPage();
	}
}

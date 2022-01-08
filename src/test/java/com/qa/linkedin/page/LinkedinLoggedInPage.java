package com.qa.linkedin.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.log4testng.Logger;

public class LinkedinLoggedInPage extends BasePageWeb{

	private static Logger log=Logger.getLogger(LinkedinLoggedInPage.class);
	
	public LinkedinLoggedInPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(@class,'profile-rail-card')]")
	private WebElement profileRailCard;
	
	@FindBy(xpath="//img[contains(@class,'profile-member-photo nav-item__icon')]")
	private WebElement profileIcon;
	
	@FindBy(xpath="//*[@data-control-name='nav.settings_signout']")
	private WebElement signOutLink;
	
	@FindBy(xpath="//*[contains(@class,'search-global-typeahead__input')]")
	private WebElement searchEditbox;
	
	public void verifyProfileRailCard() throws InterruptedException {
		log.debug("Verifying the Linkedin profileRailCard presence...");
		Assert.assertTrue(isDisplayedElement(profileRailCard));
	}
	
	public void doLogout() throws InterruptedException {
		log.debug("perform the Logout operation");
		log.debug("click on profile Icon ");
		click(profileIcon);
		log.debug("click on Signout Link");
		click(signOutLink);
	}
	
	public SearchResultsPage doPeopleSearch(String keyword) throws InterruptedException {
		log.debug("Perform the People search for ..."+keyword);
		log.debug("clear the content in search editbox");
		clearText(searchEditbox);
		log.debug("type the "+keyword+" in search editbox");
		sendKey(searchEditbox, keyword);
		log.debug("Press the ENTER key on search editbox");
		searchEditbox.sendKeys(Keys.ENTER);
		return new SearchResultsPage();
	}
	
	
	
}

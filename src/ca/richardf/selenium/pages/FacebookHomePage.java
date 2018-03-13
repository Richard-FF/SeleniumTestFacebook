package ca.richardf.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import ca.richardf.selenium.utility.CommonConstants;
import ca.richardf.selenium.utility.Logger;

public class FacebookHomePage extends BasePage{
	@FindBy(id = "logoutMenu")
	@CacheLookup
	private WebElement logout_menu;

	@FindBy(xpath = "//a[contains(@data-gt,'menu_logout')]")
	@CacheLookup
	private WebElement logout_button;

    public FacebookHomePage(WebDriver webDriver) {
    	super(webDriver);
    	Logger.logInfo("FacebookHomePage");
    }
    
    public FacebookHomePage(WebDriver webDriver, String title) {
    	super(webDriver, title);
    	Logger.logInfo("FacebookHomePage" + title );
    }
   
    public void logout() throws InterruptedException {
    	Logger.logInfo("FacebookHomePage logout");
    	logout_menu.click();
    	Thread.sleep(CommonConstants.TIME_1000MS);
    	logout_button.click();
    }
}

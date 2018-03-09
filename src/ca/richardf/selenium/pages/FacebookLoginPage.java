package ca.richardf.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import ca.richardf.selenium.utility.Logger;

public class FacebookLoginPage extends BasePage{
	@FindBy(xpath = "//*[@id=\"email\"]")
	@CacheLookup
    private WebElement user_textbox;
	
	@FindBy(xpath = "//*[@id=\"pass\"]")
	@CacheLookup
	private WebElement password_textbox;
	
	@FindBy(xpath = "//*[@id=\"loginbutton\"]")
	@CacheLookup
	private WebElement login_button;
	
    public FacebookLoginPage(WebDriver webDriver) {
    	super(webDriver);
    	Logger.logInfo("FacebookLoginPage");
    }
    
    public FacebookLoginPage(WebDriver webDriver, String title) {
    	super(webDriver, title);
    	Logger.logInfo("FacebookLoginPage" + title );
    }
    
    public void login(String username, String password) {
    	Logger.logInfo("FacebookLoginPage login"); 
    	
    	user_textbox.sendKeys(username);
    	password_textbox.sendKeys(password);
    	login_button.click();
    }
}


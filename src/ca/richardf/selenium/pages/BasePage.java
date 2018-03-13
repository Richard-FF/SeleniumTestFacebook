package ca.richardf.selenium.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import ca.richardf.selenium.utility.CommonConstants;
import ca.richardf.selenium.utility.Logger;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public BasePage(WebDriver driver){
		Logger.logInfo("BasePage");
		this.driver = driver;
		wait = new WebDriverWait(driver, CommonConstants.TIME_10S);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, CommonConstants.TIME_10S) , this);
	}

	public BasePage(WebDriver driver,final String title)
	{
		Logger.logInfo("BasePage title");
	    this.driver=driver;
	    wait = new WebDriverWait(driver, CommonConstants.TIME_10S);
	    try{
	    	boolean flag = wait.until(new ExpectedCondition<Boolean>(){
		  	@Override
		  	public Boolean apply(WebDriver arg0) {
		  		// TODO Auto-generated method stub
		  		String acttitle = arg0.getTitle();
		  		return acttitle.equals(title);
		  		}
		  	});
		}catch(TimeoutException te) {
			throw new IllegalStateException("It's not expected page, current page is: " + getTitle());
	    }
	    PageFactory.initElements(new AjaxElementLocatorFactory(driver, CommonConstants.TIME_10S) , this);
	}
	
	public String getTitle() {
		Logger.logInfo("BasePage getTitle");
		return driver.getTitle();
	}
	
	public String getInfo() {
		Logger.logInfo("BasePage getInfo");
		return driver.getPageSource().toString();
	}
}

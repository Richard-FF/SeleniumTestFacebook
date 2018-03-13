package ca.richardf.selenium.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ca.richardf.selenium.pages.FacebookHomePage;
import ca.richardf.selenium.pages.FacebookLoginPage;
import ca.richardf.selenium.utility.CommonConstants;
import ca.richardf.selenium.utility.Logger;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import junit.framework.Assert;

public class TestFacebookLogin extends TestBase {
	private FacebookLoginPage facebookLoginPage;
	private FacebookHomePage facebookHomePage;
	private String userName;
	private String password;
	private String loginPageTitle;
	
	@Parameters({ "browser" })
	@BeforeClass
    public void setUp(String browser) throws Exception{
		Logger.logInfo("TestFacebookLogin setup");
		super.init(browser);
		facebookLoginPage = new FacebookLoginPage(driver);
		facebookHomePage = new FacebookHomePage(driver);
		userName = testData.getAsJsonObject("loginpage").get("user").getAsString();
		password = testData.getAsJsonObject("loginpage").get("password").getAsString();
		loginPageTitle = testData.getAsJsonObject("loginpage").get("title").getAsString();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
    	Logger.logInfo("TestFacebookLogin tearDown");
    	//Thread.sleep(CommonConstants.TIME_2000MS);
    	super.close();
    }
    
    @Test
    @Description("Test Description: Login/logout test with right username and password.")
    @Step("Login/logout steps with username and password for method: {method}.")
    public void testFacebookLogin() throws InterruptedException {
    	Logger.logInfo("TestFacebookLogin testFacebookLogin");
    	Assert.assertEquals(loginPageTitle, facebookLoginPage.getTitle());
    	
    	facebookLoginPage.login(userName, password);
    	facebookHomePage.logout();
    }
}

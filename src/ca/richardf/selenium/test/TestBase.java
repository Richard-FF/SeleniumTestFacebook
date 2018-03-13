package ca.richardf.selenium.test;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.google.gson.JsonObject;

import ca.richardf.selenium.utility.CommonConstants;
import ca.richardf.selenium.utility.CommonUtils;
import ca.richardf.selenium.utility.Logger;

public class TestBase {
	protected static JsonObject testConfig;
	protected static String osName;
	protected static String baseUrl;
	protected static String testDataFile;
	protected static String driverPath;
	protected static JsonObject testData;
	
	protected static WebDriver driver;
	
    public void init(String browserName) throws Exception{
    	Logger.logInfo("TestBase init");
    	initConfig();
    	initTestData();
    	
		driver = getDriver(browserName);
        driver.manage().timeouts().implicitlyWait(CommonConstants.TIME_10S, TimeUnit.SECONDS);
        driver.navigate().to(baseUrl);
    }

    public void close() {
    	Logger.logInfo("TestBase close");
        driver.close();
        driver.quit();
    }
    /**
     * Get Webdriver according configure.
     * @throws UnknownHostException
     */
    public WebDriver getDriver(String browser) throws UnknownHostException {
    	Logger.logInfo("TestBase getDriver");
		WebDriver driver = null;
		try {
			String chromedriverFilePath = driverPath + CommonConstants.CHROME_DRIVER_NAME;
			File file = new File(chromedriverFilePath);
			System.setProperty(CommonConstants.CHROME_DRIVER_PROPERTY, file.getAbsolutePath());
			//file = new File(driverPath + "IEDriverServer.exe");
			//System.setProperty("webdriver.ie.driver", file.getAbsolutePath());	
			//file = new File(driverPath + "geckodriver.exe");
			//System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());			
			if(browser.equalsIgnoreCase("firefox")){					
				//to do
			}else if(browser.equalsIgnoreCase("IE")){
				//to do						
			}else if(browser.equalsIgnoreCase("Chrome")){
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put(CommonConstants.CHROME_SETTING_NOTIFICATIONS, 2);				
				prefs.put(CommonConstants.CHROME_SETTING_POPUPS, 1);
				prefs.put(CommonConstants.CHROME_SETTING_LANGUAGE, "en");
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);				
				driver = new ChromeDriver(options);
					
			}else if(browser.equalsIgnoreCase("Safari")){
				//to do
			}else if(browser.equalsIgnoreCase("Edge")){
				//to do
			}else {
				Logger.logInfo("Not a supported local browser. Need to modify testng.xml.");
			}//end if
			driver.manage().window().maximize();
			return driver;
		} catch (Exception e) {
			Logger.logException("Could not creae a web driver: " + e.getMessage());
			return null;
		}//end try
	}
    
    /**
     * Initiate Json object of config.
     * @throws Exception
     */
	private void initConfig() throws IOException{
		Logger.logInfo("TestBase initConfig");
		testConfig = CommonUtils.getJsonObject(CommonConstants.TEST_CONFIG_FILE);
		osName = testConfig.get(CommonConstants.CONFIG_OSNAME).getAsString();
		baseUrl = testConfig.get(CommonConstants.CONFIG_BASEURL).getAsString();
		testDataFile = testConfig.get(CommonConstants.CONFIG_TESTDATAFILE).getAsString();
		driverPath = testConfig.get(CommonConstants.CONFIG_DRIVERPATH).getAsString();
	}
	
	/**
     * Initiate Json object of testing data.
     * @throws Exception
     */
	private void initTestData() throws IOException{
		Logger.logInfo("TestBase initTestData");
		if(testDataFile == null) {
			Logger.logException("testdata file isn't initialized");
		}
		else {
			testData = CommonUtils.getJsonObject(testDataFile);
		}
	}
}

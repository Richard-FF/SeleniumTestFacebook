package ca.richardf.selenium.utility;

public final class CommonConstants {
	
	public static final String TEST_CONFIG_FILE = "config/config.json";
	
	public static final String CONFIG_OSNAME = "osname";
	public static final String CONFIG_BASEURL = "baseurl";
	public static final String CONFIG_TESTDATAFILE= "testdatafile";
	public static final String CONFIG_DRIVERPATH = "driverpath";
	
	public static final String CHROME_DRIVER_NAME = "chromedriver.exe";
	public static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	
	public static final String CHROME_SETTING_NOTIFICATIONS = "profile.default_content_setting_values.notifications";				
	public static final String CHROME_SETTING_POPUPS = "profile.default_content_setting_values.popups";
	public static final String CHROME_SETTING_LANGUAGE = "intl.accept_languages";
	
	public static final int TIME_10S = 10;
    public static final int TIME_15S = 15;
    public static final int TIME_20S = 20;

    public static final long TIME_1000MS = 1000;
    public static final long TIME_2000MS = 2000;
    public static final long TIME_3000MS = 3000;
    public static final long TIME_5000MS = 5000;
    public static final long TIME_10000MS = 10000;
    
    public static final int RETRY_1 = 1;
    public static final int RETRY_3 = 3;
    public static final int RETRY_5 = 5;
    public static final int RETRY_10 = 10;
}

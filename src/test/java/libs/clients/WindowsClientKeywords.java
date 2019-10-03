package libs.clients;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.windows.WindowsDriver;
import libs.common.DriverManagement;
import libs.common.Selenium;


public class WindowsClientKeywords {

	Selenium selenium = new Selenium();
	WindowsClientLocators windowsClient = new WindowsClientLocators();
	final static Logger logger = LogManager.getLogger("AADS Web Actions");
	WindowsDriver winClientDriver;
	DriverManagement driverMgnt = new DriverManagement();
	int timeout = 50;

	
	public boolean verifyEnterpriseContactSearch (WindowsDriver windowsDriverRoot, String name, String expected) throws Exception 
	{

		logger.info("verifyEnterpriseContactSearchOn - starting...\n");
		winClientDriver = createWinHandleDriver(windowsDriverRoot, "Avaya Equinox");
		
		try {
			boolean flag = false;
			//winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
			logger.info("**** verifyEnterprieseContactSearchOnACW - Get number of result ****");
			selenium.inputText(winClientDriver, windowsClient.SEARCH_TEXT_BOX, name);	
			selenium.waitUntilElementVisible(winClientDriver, windowsClient.search_contact_enterprise_result());
			String s1 = selenium.getAttribute(winClientDriver, windowsClient.SEARCH_CONTACT_ENTERPRISE_CONTACT_TITLE_BAR,"Name");
			String number = s1.replaceAll("[^0-9]", "");
			int num = Integer.parseInt(number);
			
			logger.info("verifyEnterprieseContactSearch - Number of result: " + num);
			logger.info("**** verifyEnterprieseContactSearch - Verify search ****");
			logger.info("verifyEnterprieseContactSearch - Expected result: " + expected);
			
			for (int i = 0; i < num; i++) {
				String s2 = selenium.getAttribute(winClientDriver, windowsClient.search_contact_enterprise_result(expected), "Name");
				logger.info("verifyEnterprieseContactSearch - result "+(i+1)+": " + s2);
				if (s2.contains(expected)) {
					logger.info("verifyEnterprieseContactSearch - Existed the expected result - PASSED ");
					return true;
				}
			}
			if (flag == false) {
				logger.error("verifyEnterprieseContactSearch - FAILED - Expected result didn't exist");
				throw new Exception("verifyEnterprieseContactSearch - Expected result didn't exist");
			}
			
			clickCancelSearch(winClientDriver);
			logger.info("verifyEnterprieseContactSearch - PASSED");
			
		} catch (Exception e) {
			
			logger.error("ContactsSearch - Failed with Exception: " + e + "...\n");
			//throw new Exception("ContactsUuSearch - Failed - Exception occurs: " + e);
		}
		return false;
	}
	
	
	
	public boolean autoConfigLogin(WindowsDriver winRootDriver, String address,  String user, String pwd) throws Exception{
		logger.info("autoConfigLogin - starting...\n");
		try {
			
			Thread.sleep(2000);
			
			WindowsDriver winClientDriver = createWinHandleDriver(winRootDriver, "Settings");
			
			if(selenium.isElementExisted(winClientDriver, windowsClient.FIRST_SCREEN_SETTING_BTN)) {
				Thread.sleep(1000);
				selenium.clickElement(winClientDriver, windowsClient.FIRST_SCREEN_SETTING_BTN);
			}
			selenium.clickElement(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_BTN);
			Thread.sleep(1000);
			selenium.clickElement(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_BTN);
			Thread.sleep(1000);
			selenium.inputText(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_TXT,address);
			Thread.sleep(1000);
			Thread.sleep(1000);
			selenium.clickElement(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_NEXT_BTN);
			Thread.sleep(5000);
			selenium.inputText(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_USER_TXT,user);
			selenium.inputText(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_PWD_TXT,pwd);
			logger.info("Insert login information successfully \n");
			Thread.sleep(1000);
			if(selenium.isElementExisted(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_USER_TXT)) {
				selenium.inputText(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_USER_TXT,user);
				selenium.inputText(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_PWD_TXT,pwd);
			}
			selenium.clickElement(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_NEXT_BTN);
			Thread.sleep(9000);
			logger.info("Login successfully \n");
			
		//	winClientDriver = createWinHandleDriver(winRootDriver, "Settings");
			selenium.clickElement(winRootDriver, windowsClient.WELCOME_SKIP_TUTORIAL_BTN);
			Thread.sleep(9000);
			
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
			if(selenium.isElementExisted(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_USER_TXT)==true)
			{
				selenium.inputText(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_PWD_TXT,pwd);
				Thread.sleep(1000);
				selenium.clickElement(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_USE_WEB_NEXT_BTN);
			}
		} catch (Exception exception) {
			logger.error("autoConfigLogin - Failed with Exception: " + exception + "...\n");
			return false;
		}
		logger.info("autoConfigLogin - completed...\n");	
		return true;
    }
	
	
	public void resetApplication(WindowsDriver winRootDriver) throws Exception{
		logger.info("resetApplication - starting...\n");
		int i=0;
		//Screen sikuli = new Screen();
		
		while (true) {
			if(i==3) break;
		
		try {
			//if(sikuli.exists("imgs//ACW_Configure.png")!=null) {
			//	break;
			//	}
			
			
			WindowsDriver winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");

			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_OPEN_SETTING_BTN);
			Thread.sleep(3000);

			
			winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Engage Settings");
			
			
			
			selenium.clickElement(winClientDriver, windowsClient.settingWindowsTabLocators("Support"));
		//	selenium.doubleClickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN);
			selenium.doubleClickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN);
			Thread.sleep(3000);
			selenium.clickElement(winClientDriver,windowsClient.settingWindowsOptionsInsideTabLocators("Reset Application"));
			Thread.sleep(3000);
			selenium.clickElement(winClientDriver,windowsClient.settingWindowsOptionsInsideTabLocators("Clear"));
			Thread.sleep(2000);
//			Robot robot = new Robot();
//		    robot.keyPress(KeyEvent.VK_ALT);
//		    robot.keyPress(KeyEvent.VK_F4);
//		    robot.delay(100);
//		    robot.keyRelease(KeyEvent.VK_ALT);
//		    robot.keyRelease(KeyEvent.VK_F4);
		    break;
		} catch (Exception exception) {
//			driverMgnt.setFailedWinClientDriver(winClientDriver);
//			logger.error("resetApplication - Failed with Exception: " + exception + "...\n");
//			throw new Exception("resetApplication - Failed - Exception occurs: " + exception);
			i++;
			selenium.clickElement(winClientDriver,windowsClient.SETTING_WINDOWS_CLOSE_BTN);
			
		}}
		logger.info("resetApplication - completed...\n");		
    }
	
	
	public WindowsDriver createWinHandleDriver(WindowsDriver windowDriver, String window) throws Exception{	
		WindowsDriver windowsClientDriver = null;
		String currentURL = windowDriver.getRemoteAddress().toString();
	
			try {
				WebElement handle = windowDriver.findElementByName(window);
				String st = handle.getAttribute("NativeWindowHandle");
				logger.info(st);
				
				String s2 = Integer.toHexString(Integer.parseInt(st));
				System.out.println(s2);
				String equinox = "0x"+s2;
				logger.info("Hex: " + equinox);
				
				
	            DesiredCapabilities capabilities = new DesiredCapabilities();
	            capabilities.setCapability("appTopLevelWindow", equinox);
	            windowsClientDriver = new WindowsDriver(new URL(currentURL), capabilities);
	            windowsClientDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			} catch (Exception e) {
				logger.info("createWindowsHandleDriver - Failed...\n + E: " + e);
				// TODO: handle exception
			}
			logger.info("createWindowsHandleDriver - completed...\n");
	
		return windowsClientDriver;
    }
	
	public WindowsDriver createWinHandleDriverContainsName(WindowsDriver windowDriver, String window) throws Exception{	
		WindowsDriver windowsClientDriver = null;
		String currentURL = windowDriver.getRemoteAddress().toString();
	
			try {
				WebElement handle = windowDriver.findElementByXPath("//*[contains(@Name,'"+window+"')]");
				String st = handle.getAttribute("NativeWindowHandle");
				logger.info(st);
				
				String s2 = Integer.toHexString(Integer.parseInt(st));
				System.out.println(s2);
				String equinox = "0x"+s2;
				logger.info("Hex: " + equinox);
				
				
	            DesiredCapabilities capabilities = new DesiredCapabilities();
	            capabilities.setCapability("appTopLevelWindow", equinox);
	            windowsClientDriver = new WindowsDriver(new URL(currentURL), capabilities);
	            windowsClientDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			} catch (Exception e) {
				logger.info("createWindowsHandleDriver - Failed...\n + E: " + e);
				// TODO: handle exception
			}
			logger.info("createWindowsHandleDriver - completed...\n");
	
		return windowsClientDriver;
    }
	
	
	public String getWinHandle(WindowsDriver windowDriver, String windowName) {
		try {
			WebElement handle = windowDriver.findElementByName("Avaya Equinox");
			String st = handle.getAttribute("NativeWindowHandle");
			String s2 = Integer.toHexString(Integer.parseInt(st));
			System.out.println(s2);
			String equinox = "0x"+s2;
			return equinox;
		} catch (Exception e) {
			return null;
		}
	}
	
	public void confirmOpenApp(WindowsDriver winRootDriver) throws Exception{
		try {
			winClientDriver = createWinHandleDriver(winRootDriver, "Other Avaya Equinox instances are detected");
	
            if (selenium.isElementExisted(winClientDriver, windowsClient.ACW_LOGIN_DIALOG_TXT_OPEN_CONFIRM_QUESTION)){
            	selenium.clickElement(winClientDriver,windowsClient.ACW_LOGIN_DIALOG_BTN_NO);
            }

		} catch (Exception exception) {
			logger.error("confirmOpenApp - Failed with Exception: " + exception + "...\n");
			throw new Exception("confirmOpenApp - Failed - Exception occurs: " + exception);
		}
		logger.info("confirmOpenApp - completed...\n");		
    }
	
	
	
	public void enterString(WindowsDriver winRootDriver, String string) throws Exception{
		logger.info("Entering string: " + string + "\n");
		Thread.sleep(3000);
		winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
		try {
			Thread.sleep(2000);
		    StringSelection stringSelection = new StringSelection(string);
		    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		    clipboard.setContents(stringSelection, stringSelection);
		    
		    Robot robot = new Robot();
		    robot.keyPress(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_V);
		    robot.keyRelease(KeyEvent.VK_CONTROL);
		    robot.delay(3000);
			Thread.sleep(2000);	
		} catch (Exception exception) {
			driverMgnt.setFailedWinClientDriver(winClientDriver);
			logger.error("Input a string directly from keyboard - Failed with Exception: " + exception + "...\n");
			throw new Exception("Input a string directly from keyboard - Failed - Exception occurs: " + exception);
		}
		logger.info("Enter string - completed...\n");		
	}


	public void mainWindowsNavigateToContactTab (WindowsDriver windowsDriverRoot) throws Exception{
		logger.info("mainWindowsNavigateToContactTab - starting...\n");
		winClientDriver = createWinHandleDriver(windowsDriverRoot, "Avaya Equinox");
		try {
			if(!selenium.isElementExisted(winClientDriver, windowsClient.MAIN_WINDOWS_CONTACT_LIST_BOX)){
				selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_CONTACT_BTN);
				Thread.sleep(1000);		
			}
		} catch (Exception exception) {
			logger.error("mainWindowsNavigateToContactTab - Failed with Exception: " + exception + "...\n");
			throw new Exception("mainWindowsNavigateToContactTab - Failed - Exception occurs: " + exception);
		}
		logger.info("mainWindowsNavigateToContactTab - completed...\n");		
    }
	
	public void resetcontactTab (WindowsDriver windowClientDriver) throws Exception{
		logger.info("mainWindowsNavigateToContactTab - starting...\n");
		try {

			if(!selenium.isElementExisted(windowClientDriver, windowsClient.MAIN_WINDOWS_CONTACT_LIST_BOX)){
				selenium.clickElement(windowClientDriver, windowsClient.MAIN_WINDOWS_CONTACT_BTN);}
			Thread.sleep(1000);	
		} catch (Exception exception) {
			logger.error("mainWindowsNavigateToContactTab - Failed with Exception: " + exception + "...\n");
		}
		logger.info("mainWindowsNavigateToContactTab - completed...\n");		
    }
	
	public void settingWindowsMainClickBackButton(WindowsDriver windowClientDriver) throws Exception{
		logger.info("settingWindowsMainClickBackButton - starting...\n");
		Thread.sleep(3000);
		try {
			if(selenium.isElementExisted(windowClientDriver, windowsClient.SETTING_WINDOWS_BACK_BTN)) {
			selenium.clickElement(windowClientDriver, windowsClient.SETTING_WINDOWS_BACK_BTN);
			}
		} catch (Exception exception) {
			logger.error("settingWindowsMainClickBackButton - Failed with Exception: " + exception + "...\n");
			throw new Exception("settingWindowsMainClickBackButton - Failed - Exception occurs: " + exception);
		}
		logger.info("settingWindowsMainClickBackButton - completed...\n");		
    }
	
	public void clickCancelSearch (WindowsDriver windowClientDriver) throws Exception{
		logger.info("clickCancelSearch - starting...\n");
		try {
				selenium.clickElement(windowClientDriver, windowsClient.CONTACT_LIST_CANCLE_SEARCH_BTN);
			Thread.sleep(3000);	
		} catch (Exception exception) {
			logger.error("clickCancelSearch - Failed with Exception: " + exception + "...\n");
		}
		logger.info("clickCancelSearch - completed...\n");		
    }
	
	public void openSettingWindows(WindowsDriver winRootDriver) throws Exception{
		logger.info("openSettingWindows - starting...\n");
		Thread.sleep(3000);
		winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
		
		try {
			if (selenium.isElementExisted(winClientDriver, windowsClient.MAIN_WINDOWS_OPEN_SETTING_BTN)){
				selenium.waitUntilElementClickable(winClientDriver, windowsClient.MAIN_WINDOWS_OPEN_SETTING_BTN);
				selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_OPEN_SETTING_BTN);	
			} else {
		
				selenium.waitUntilElementClickable(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_BTN);
				selenium.clickElement(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_BTN);
				selenium.waitUntilElementClickable(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_MANUALLY_CONF_BTN);
				selenium.clickElement(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_MANUALLY_CONF_BTN);
				Thread.sleep(2000);
			}
		} catch (Exception exception) {
			driverMgnt.setFailedWinClientDriver(winClientDriver);
			logger.error("openSettingWindows - Failed with Exception: " + exception + "...\n");
			throw new Exception("openSettingWindows - Failed - Exception occurs: " + exception);
		}
		logger.info("openSettingWindows - completed...\n");			
    }
	
	public void settingWindowsMainClickOnTab(WindowsDriver winRootDriver, String tabName) throws Exception{
		logger.info("settingWindowsMainClickOnTab - starting...\n");
		logger.info("tabName is: " + tabName + "\n");
		Thread.sleep(2000);
		winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Engage Settings");
		try {
			selenium.waitUntilElementClickable(winClientDriver, windowsClient.settingWindowsTabLocators(tabName));
			selenium.clickElement(winClientDriver, windowsClient.settingWindowsTabLocators(tabName));
		} catch (Exception exception) {
			driverMgnt.setFailedWinClientDriver(winClientDriver);
			logger.error("settingWindowsMainClickOnTab - Failed with Exception: " + exception + "...\n");
			throw new Exception("settingWindowsMainClickOnTab - Failed - Exception occurs: " + exception);
		}
		logger.info("settingWindowsMainClickOnTab - completed...\n");		
    }
	
	public void settingWindowsServicesTabShowDetails(WindowsDriver winRootDriver) throws Exception{
		logger.info("settingWindowsServicesTabShowDetails - starting...\n");
		Thread.sleep(2000);
		winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Engage Settings");

		try {
			if (selenium.isElementExisted(winClientDriver, windowsClient.SETTING_WINDOWS_SERVICES_TAB_SHOW_DETAILS_BTN)){
				selenium.clickElement(winClientDriver, windowsClient.SETTING_WINDOWS_SERVICES_TAB_SHOW_DETAILS_BTN);
				Thread.sleep(2000);		
			}
		} catch (Exception exception) {
			driverMgnt.setFailedWinClientDriver(winClientDriver);
			logger.error("settingWindowsServicesTabShowDetails - Failed with Exception: " + exception + "...\n");
			throw new Exception("settingWindowsServicesTabShowDetails - Failed - Exception occurs: " + exception);
		}
		logger.info("settingWindowsServicesTabShowDetails - completed...\n");		
    }
	
	public void settingWindowsMainSelectOptionInsideTab(WindowsDriver winRootDriver, String option) throws Exception{
		logger.info("settingWindowsMainSelectOptionInsideTab - starting...\n");
		winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Engage Settings");
		logger.info("option is: " + option + "\n");
		try {
			selenium.waitUntilElementClickable(winClientDriver, windowsClient.settingWindowsOptionsInsideTabLocators(option));
			selenium.clickElement(winClientDriver, windowsClient.settingWindowsOptionsInsideTabLocators(option));
		} catch (Exception exception) {
			driverMgnt.setFailedWinClientDriver(winClientDriver);
			logger.error("settingWindowsMainSelectOptionInsideTab - Failed with Exception: " + exception + "...\n");
			throw new Exception("settingWindowsMainSelectOptionInsideTab - Failed - Exception occurs: " + exception);
		}
		logger.info("settingWindowsMainSelectOptionInsideTab - completed...\n");		
    }
	
	public void verifyServerConfig(WindowsDriver winRootDriver, String add, String port ) throws Exception{
		logger.info("Verify Server Config");		
		Thread.sleep(2000);
		winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Engage Settings");
		
		try {
			String server = selenium.getAttribute(winClientDriver, windowsClient.SETTING_WINDOWS_LDAP_SERVER, "Name");
			
			String aport = selenium.getAttribute(winClientDriver, windowsClient.SETTING_WINDOWS_LDAP_PORT, "Name");
			System.out.println(server + aport );
			if(add.equalsIgnoreCase(server)&port.equalsIgnoreCase(aport)){
				logger.info("Verify Server Config - PASSED");
			}else
			{
				driverMgnt.setFailedWinClientDriver(winClientDriver);
				throw new Exception("Failed - Actual Address: " + server + " and Port: " + aport );
				
			}
		} catch (Exception e) {
			driverMgnt.setFailedWinClientDriver(winClientDriver);
			logger.error("checkForUpdates - Failed with Exception: " + e + "...\n");
			throw new Exception("checkForUpdates - Failed - Exception occurs: " + e);
		}}
	
	public void closeSettingWindow(WindowsDriver winRootDriver) throws Exception{	
		Thread.sleep(2000);
		winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Engage Settings");
		try {
			selenium.waitUntilElementClickable(winClientDriver, windowsClient.SETTING_WINDOWS_CLOSE_BTN);
			selenium.clickElement(winClientDriver, windowsClient.SETTING_WINDOWS_CLOSE_BTN);
		} catch (Exception e) {
			driverMgnt.setFailedWinClientDriver(winClientDriver);
			logger.error("closeSettingWindow - Failed with Exception: " + e + "...\n");
			throw new Exception("closeSettingWindow - Failed - Exception occurs: " + e);
		}
	}
	
	public void verifyIfContactExisted(WindowsDriver winRootDriver, String name) throws Exception{
		winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
		
		try {
			selenium.waitUntilElementVisible(winClientDriver, windowsClient.CONTACT_LIST_CONTACT_NAME(name));
			if(selenium.isElementExisted(winClientDriver, windowsClient.CONTACT_LIST_CONTACT_NAME(name))){
				logger.info("verifyEnterpriseSearch - PASSED");
			} else {
				driverMgnt.setFailedWinClientDriver(winClientDriver);
				throw new Exception("verifyEnterpriseSearch - FAILED");
			}
			
		} catch (Exception e) {
			driverMgnt.setFailedWinClientDriver(winClientDriver);
			logger.error("verifyIfContactExisted - Failed with Exception: " + e + "...\n");
			throw new Exception("verifyIfContactExisted - Failed - Exception occurs: " + e);
		}
	}
	
	public boolean contactsIsContactFavorite (WindowsDriver winRootDriver, String user) throws Exception{
		logger.info("contactsIsContactFavorite - starting...\n");
		try {
			contactsSearchF3(winClientDriver);
			enterString(winClientDriver, user);
			selenium.mouseHover(winClientDriver, windowsClient.mainWindowsContactsTabUserLocatorsAfterSearch(user));
			if (selenium.isElementExisted(winClientDriver, windowsClient.MAIN_WINDOWS_FAVORITES_ICON_ENABLED(user))) {
				logger.info(user + " is favorite");
				return true;
			} else {
				if (selenium.isElementExisted(winClientDriver, windowsClient.MAIN_WINDOWS_FAVORITES_ICON_DISABLED(user))) {
					logger.info(user + " is not favorite");
					return false;
				} else {
					logger.info("Favorites icon is not present");
					throw new Exception("contactsMarkContactAsFavorites - Failed - Favorites icon is not present");
				}
			}

		} catch (Exception exception) {
			driverMgnt.setFailedWinClientDriver(winClientDriver);
			logger.error("contactsMarkContactAsFavorites - Failed with Exception: " + exception + "...\n");
			throw new Exception("contactsMarkContactAsFavorites - Failed - Exception occurs: " + exception);
		}
	   }
	
	public void contactsSearchF3(WindowsDriver winRootDriver) throws Exception{
		logger.info("Move cursor to Search textbox - starting...\n");
		Thread.sleep(3000);
		winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
		try {
			Thread.sleep(1000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_F3);
		    robot.keyRelease(KeyEvent.VK_F3);
		    robot.delay(3000);
		} catch (Exception exception) {
			driverMgnt.setFailedWinClientDriver(winClientDriver);
			logger.error("Move cursor to Search textbox - Failed with Exception: " + exception + "...\n");
			throw new Exception("Move cursor to Search textbox - Failed - Exception occurs: " + exception);
		}
		logger.info("Move cursor to Search textbox - completed...\n");		
    }
	
	public boolean addLocalContactManual(WindowsDriver winRootDriver, String firstname,  String lastname, String phone, String address) throws Exception{
		logger.info("addLocalContactManual - starting...\n");
		boolean s=false;;
		winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
		try {
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(winClientDriver, windowsClient.CONTACT_TAB_SCREEN_ADD_CONTACT_BTN);
			selenium.clickElement(winClientDriver, windowsClient.CONTACT_TAB_SCREEN_ADD_CONTACT_BTN);
			Thread.sleep(1000);
			selenium.waitUntilElementClickable(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_FISRT_NAME_TXT);
			selenium.inputText(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_FISRT_NAME_TXT, firstname);
			Thread.sleep(1000);
			selenium.waitUntilElementClickable(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_LAST_NAME_TXT);
			selenium.inputText(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_LAST_NAME_TXT, lastname);
			Thread.sleep(1000);
			selenium.waitUntilElementClickable(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_NUMBER_PHONE_TXT);
			selenium.inputText(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_NUMBER_PHONE_TXT,phone);
			Thread.sleep(1000);
//			selenium.waitUntilElementClickable(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN);
//			selenium.doubleClickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN);
//			selenium.doubleClickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN);
//			selenium.doubleClickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN);
//			selenium.doubleClickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN);
//			selenium.doubleClickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN);
//			selenium.doubleClickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN);
//			selenium.doubleClickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN);
//			selenium.doubleClickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN);
//			Thread.sleep(3000);
//			selenium.waitUntilElementClickable(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_AMM_ADDRESS_TXT, 30);
//			selenium.inputText(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_AMM_ADDRESS_TXT,address);
//			Thread.sleep(4000);
			selenium.waitUntilElementClickable(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_EMAIL_ADDRESS_TXT);
			selenium.inputText(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_EMAIL_ADDRESS_TXT,address);
			Thread.sleep(2000);
//			if(selenium.isElementExisted(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_ADD_CONTACT_BTN)) {
//			selenium.clickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_ADD_CONTACT_BTN);}
			if(selenium.isElementExisted(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_ADD_CONTACT_BTN)) {
				selenium.clickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_ADD_CONTACT_BTN);
				s=true;
				}
			Thread.sleep(10000);
			if(selenium.isElementExisted(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_ADD_CONTACT_BTN)) {
				selenium.clickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_ADD_CONTACT_BTN);
				s=true;
				}
			
		} catch (Exception exception) {
			escapeAddContact(winClientDriver);
			logger.error("addLocalContactManual - Failed with Exception: " + exception + "...\n");
			//resetApplicationbutnotclose(winClientDriver);
		}
		logger.info("addLocalContactManual - completed...\n");
		return s;
    }
	
	public void resetApplicationbutnotclose(WindowsDriver winRootDriver) throws Exception{
		logger.info("resetApplication - starting...\n");
		winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
		
		while(true) {
		try {
			if(selenium.isElementExisted(winClientDriver, windowsClient.MAIN_WINDOWS_OPEN_SETTING_BTN)){
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(winClientDriver, windowsClient.MAIN_WINDOWS_OPEN_SETTING_BTN);
			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_OPEN_SETTING_BTN);
			
			Thread.sleep(1000);
			if(selenium.isElementExisted(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_MANUALLY_CONFIGURE_BTN)) {
				selenium.waitUntilElementClickable(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_MANUALLY_CONFIGURE_BTN);
				selenium.clickElement(winClientDriver, windowsClient.FIRST_WINDOWS_SETTING_MANUALLY_CONFIGURE_BTN);
			}
			Thread.sleep(1000);
			selenium.waitUntilElementClickable(winClientDriver, windowsClient.settingWindowsTabLocators("Support"));
			selenium.clickElement(winClientDriver, windowsClient.settingWindowsTabLocators("Support"));
			selenium.waitUntilElementClickable(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN);
			selenium.doubleClickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN);
			selenium.doubleClickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_VERTICAL_SMALL_INCREASE_BTN);
			Thread.sleep(1000);
			selenium.waitUntilElementClickable(winClientDriver, windowsClient.settingWindowsOptionsInsideTabLocators("Reset Application"));
			selenium.clickElement(winClientDriver,windowsClient.settingWindowsOptionsInsideTabLocators("Reset Application"));
			Thread.sleep(1000);
			selenium.waitUntilElementClickable(winClientDriver, windowsClient.settingWindowsOptionsInsideTabLocators("Clear"));
			if(selenium.isElementExisted(winClientDriver, windowsClient.settingWindowsOptionsInsideTabLocators("Clear"))) {
			selenium.clickElement(winClientDriver,windowsClient.settingWindowsOptionsInsideTabLocators("Clear"));
			Thread.sleep(2000);}
			break;
			}} catch (Exception exception) {
			driverMgnt.setFailedWinClientDriver(winClientDriver);
			logger.error("resetApplication - Failed with Exception: " + exception + "...\n");
			throw new Exception("resetApplication - Failed - Exception occurs: " + exception);
		} }
		logger.info("resetApplication - completed...\n");		
   }
	
	public boolean deleteContact(WindowsDriver winClientDriver, String name ) throws Exception{
		boolean s= false;
		try{
			while (true) {
			//selenium.waitUntilElementClickable(winClientDriver, windowsClient.ACW_CALL_TXT_SEARCH_NAME_OR_NUMBER, 200);
			//selenium.clickElement(winClientDriver, windowsClient.ACW_CALL_TXT_SEARCH_NAME_OR_NUMBER);
			//selenium.inputText(winClientDriver,  windowsClient.ACW_CALL_TXT_SEARCH_NAME_OR_NUMBER, name);
			if(selenium.isElementExisted(winClientDriver, windowsClient.CONTACT_LIST_CONTACT_NAME(name))) {
				selenium.mouseHover(winClientDriver, windowsClient.CONTACT_LIST_CONTACT_NAME(name));
				Thread.sleep(3000);
			
				}else break;
			if(selenium.isElementExisted(winClientDriver, windowsClient.CONTACT_LIST_CONTACT_DETAIL(name))) {
				selenium.mouseHover(winClientDriver, windowsClient.CONTACT_LIST_CONTACT_DETAIL(name));
				Thread.sleep(3000);
				selenium.clickElement(winClientDriver, windowsClient.CONTACT_LIST_REMOVE_CONTACT);
				Thread.sleep(3000);
				selenium.clickElement(winClientDriver, windowsClient.CONTACT_LIST_REMOVE_CONTACT_CONFIRM_YES);
				s=true;
				}else break;
			}}catch (Exception e) {
			logger.error("verifyIfContactExisted - Failed with Exception: " + e + "...\n");
			if(selenium.isElementExisted(winClientDriver, windowsClient.SETTING_WINDOWS_BACK_BTN))
				selenium.clickElement(winClientDriver, windowsClient.SETTING_WINDOWS_BACK_BTN);
		}
		return s;
	}
	
	public boolean addContactFollowingSearch(WindowsDriver winRootDriver, String user) throws Exception{
		logger.info("addContactFollowingSearch - starting...\n");
		winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
		boolean s= false;

		try {
			Thread.sleep(1000);
			selenium.doubleClickElement(winClientDriver, windowsClient.mainWindowsContactsTabUserLocatorsAfterSearch(user));
			
			if(!selenium.isElementExisted(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_ADD_CONTACT_BTN)) {
				logger.info("addContactFollowingSearch - Contact already exists\n");
				settingWindowsMainClickBackButton(winClientDriver);
				escapeAddContact(winClientDriver);
				return s = true;
			}
			
			selenium.clickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_ADD_CONTACT_BTN);
			Thread.sleep(1000);		
			selenium.waitUntilElementVisible(winClientDriver, windowsClient.SEARCH_TEXT_BOX);
			Thread.sleep(1000);		
			clickCancelSearch(winClientDriver);
			if(selenium.isElementExisted(winClientDriver, windowsClient.CONTACT_IN_CONTACT_LIST(user))) {
				s=true;
			}
			
		} catch (Exception exception) {
			s=false;
			escapeAddContact(winClientDriver);
			clickCancelSearch(winClientDriver);
		}
		logger.info("addContactBySearch - completed...\n");	
		return s;
    }
	
	public boolean editContactinContactList(WindowsDriver winRootDriver, String name ,String fieldname,String value) throws Exception{
		logger.info("editContactinContactList - starting");
		winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
		boolean s= false;
				try {
				Thread.sleep(1000);
				//winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
				selenium.doubleClickElement(winClientDriver, windowsClient.CONTACT_IN_CONTACT_LIST(name));
				
				selenium.clickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_EDIT_BTN);
				switch (fieldname) {
				
				case "company":
					selenium.inputText(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_COMPANY_TXT, value);
					selenium.clickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_DONE_BTN);
					Thread.sleep(3000);
					if(!selenium.isElementExisted(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_DONE_BTN)&& selenium.isElementExisted(winClientDriver, windowsClient.ElementByName(value) )) {
					s=true;
					System.out.println(s);
					Thread.sleep(2000);
					settingWindowsMainClickBackButton(winClientDriver);			
					}
					break;
					
				case "last_name":
					selenium.inputText(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_LAST_NAME_TXT, value);
					selenium.clickElement(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_DONE_BTN);
					Thread.sleep(3000);
					if(!selenium.isElementExisted(winClientDriver, windowsClient.ADD_CONTACT_SCREEN_DONE_BTN) ) {
						//&&selenium.isElementExisted(winClientDriver, windowsClient.ElementByName(value))
					s=true;
					logger.info("Edit user PASSED");
					System.out.println(s);
					Thread.sleep(2000);
					settingWindowsMainClickBackButton(winClientDriver);		
					}
					else {
						s = false;
						System.out.println(s);
						logger.info("Edit user Failed");
					}
					break;
				}
			}catch (Exception e) {
			logger.error("editContactinContactList - Failed with Exception: " + e + "...\n");
			escapeAddContact(winClientDriver);
			settingWindowsMainClickBackButton(winClientDriver);
			}
				logger.info("editContactinContactList - completed");
		return s;
		
	}
	
	public boolean removeContactinContactList(WindowsDriver winRootDriver, String name) throws Exception{
		
		logger.info("removeContactinContactList - starting");
		winClientDriver = createWinHandleDriver(winRootDriver, "Avaya Equinox");
		boolean s= false;
				try {
					Thread.sleep(1000);
					if(selenium.isElementExisted(winClientDriver, windowsClient.mainWindowsContactsTabUserLocators(name))) {
						selenium.doubleClickElement(winClientDriver, windowsClient.mainWindowsContactsTabUserLocators(name));
			
					Thread.sleep(1000);
					selenium.clickElement(winClientDriver, windowsClient.CONTACT_LIST_REMOVE_CONTACT);
					selenium.clickElement(winClientDriver, windowsClient.CONTACT_LIST_REMOVE_CONTACT_CONFIRM_YES);
					
					Thread.sleep(3000);
					selenium.waitUntilElementVisible(winClientDriver, windowsClient.SEARCH_TEXT_BOX);
					
					
					//clickCancelSearch(winClientDriver);
					
	

					if(!selenium.isElementExisted(winClientDriver, windowsClient.CONTACT_LIST_CONTACT_NAME(name))){
						logger.info("Verify" +name +"is removed sucessfully - PASSED");
						s = true;
					} 

					else {
						removeContactinContactList(winClientDriver, name);
						s= false;
						
					//	driverMgnt.setFailedWinClientDriver(winClientDriver);	
					}
				
				//resetcontactTab(winClientDriver);
	//			break;
					}else s = false;
			}catch (Exception e) {
			escapeAddContact(winClientDriver);
			logger.error("verifyIfContactExisted - Failed with Exception: " + e + "...\n");
			settingWindowsMainClickBackButton(winClientDriver);
		}
		return s;
	}
	
	public void escapeAddContact (WindowsDriver windowClientDriver) throws Exception{
		logger.info("escapeAddContact - starting...\n");
		try {
			if (selenium.isElementExisted(windowClientDriver, windowsClient.CONTACT_LIST_CONTACT_DETAIL_DISMISS_BTN )) {
				logger.info("escapeAddContact - Contact already exists\n");
				selenium.clickElement(windowClientDriver, windowsClient.CONTACT_LIST_CONTACT_DETAIL_DISMISS_BTN);
			}
			
			if (selenium.isElementExisted(windowClientDriver, windowsClient.CONTACT_LIST_CONTACT_DETAIL_OK_BTN )) {
				logger.info("escapeAddContact - Internal Error\n");
				selenium.clickElement(windowClientDriver, windowsClient.CONTACT_LIST_CONTACT_DETAIL_OK_BTN);
			}
			
			if (selenium.isElementExisted(windowClientDriver, windowsClient.CONTACT_LIST_CANCLE_SEARCH_BTN)) {
				selenium.clickElement(windowClientDriver, windowsClient.CONTACT_LIST_CANCLE_SEARCH_BTN);}
				
			Thread.sleep(3000);	
		} catch (Exception exception) {
			logger.error("escapeAddContact - Failed with Exception: " + exception + "...\n");
		}
		logger.info("escapeAddContact - completed...\n");		
    }
	
	
	
	
	public boolean verifyUserisExistedContactTab(WindowsDriver windowsDriverRoot, String user) throws Exception{
		logger.info("verifyUserisExistedContactTab - starting...\n");
		winClientDriver = createWinHandleDriver(windowsDriverRoot, "Avaya Equinox");
		logger.info("user is: " + user + "\n");
		boolean s= false;
		try {
			Thread.sleep(2000);
			s = selenium.isElementExisted(winClientDriver, windowsClient.mainWindowsContactsTabUserLocators(user));
			Thread.sleep(2000);	
			
		} catch (Exception exception) {
//			driverMgnt.setFailedWinClientDriver(winClientDriver);
//			logger.error("verifyUserisExistedContactTab - Failed with Exception: " + exception + "...\n");
//			throw new Exception("verifyUserisExistedContactTab - Failed - Exception occurs: " + exception);
			s=false;
		}
		logger.info("verifyUserisExistedContactTab - completed...\n");		
		return s;
    }
	
	public boolean verifyLocalContactSearch (WindowsDriver windowsDriverRoot, String name, String expected) throws Exception 
	{
		logger.info("verifylocalContactSearch - starting...\n");
		winClientDriver = createWinHandleDriver(windowsDriverRoot, "Avaya Equinox");
		boolean flag = false;
		try {
			Thread.sleep(1000);
			selenium.inputText(winClientDriver, windowsClient.ACW_CALL_TXT_SEARCH_NAME_OR_NUMBER, name);
			Thread.sleep(10000);
			logger.info("**** verifyLocalContactSearch - Get number of result ****");
			
			String s1 = selenium.getAttribute(winClientDriver, windowsClient.SEARCH_CONTACT_LOCAL_CONTACT_TITLE_BAR, 
					"Name");
			String number = s1.replaceAll("[^0-9]", "");
			int num = Integer.parseInt(number);
			
			logger.info("verifyLocalContactSearch - Number of result: " + num);
			logger.info("**** verifyLocalContactSearch - Verify search ****");
			logger.info("verifyLocalContactSearch - Expected result: " + expected);
			
			for (int i = 0; i < num; i++) {
				String s2 = selenium.getAttribute(winClientDriver, windowsClient.search_contact_local_result(expected), 
						"AutomationId");
				logger.info("verifyLocalContactSearch - result "+(i+1)+": " + s2);
				if (s2.contains(expected)) {
					logger.info("verifyLocalContactSearch - Existed the expected result - PASSED ");
					flag = true;
					break;
				}
			}
			if (flag == false) {
				logger.error("verifyLocalContactSearch - FAILED - Expected result didn't exist");
				throw new Exception("verifyLocalContactSearch - Expected result didn't exist");
			}
			
			clickCancelSearch(winClientDriver);
			logger.info("verifyLocalContactSearch - PASSED");
		} catch (Exception e) {
			logger.error("ContactsSearch - Failed with Exception: " + e + "...\n");
			throw new Exception("ContactsUuSearch - Failed - Exception occurs: " + e);
		}
		logger.info("verifylocalContactSearch - completed...\n");
		return flag;
	}
	
	public void mainWindowsContactsTabCallUser(WindowsDriver windowsDriverRoot, String user) throws Exception{
		logger.info("mainWindowsContactsTabOpenNewConversationWithUser - starting...\n");
		winClientDriver = createWinHandleDriver(windowsDriverRoot, "Avaya Equinox");
		logger.info("user is: " + user + "\n");
		try {
			
			selenium.waitUntilElementClickable(winClientDriver, windowsClient.mainWindowsContactsTabUserLocators(user));
			selenium.mouseHover(winClientDriver, windowsClient.mainWindowsContactsTabUserLocators(user));
			Thread.sleep(3000);
			selenium.waitUntilElementClickable(winClientDriver, windowsClient.mainWindowsContactsTabUserActionLocators("Call",user));
			selenium.clickElement(winClientDriver, windowsClient.mainWindowsContactsTabUserActionLocators("Call",user));
			Thread.sleep(3000);
			selenium.waitUntilElementClickable(winClientDriver, windowsClient.MAIN_WINDONS_CONTACT_TAB_START_CONVERSATION_BTN(user));
			selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDONS_CONTACT_TAB_START_CONVERSATION_BTN(user));
			Thread.sleep(2000);
//		    Robot r =  new Robot();
//			r.mousePress(InputEvent.BUTTON1_MASK);
//			r.mouseRelease(InputEvent.BUTTON1_MASK);
		} catch (Exception exception) {
			driverMgnt.setFailedWinClientDriver(winClientDriver);
			logger.error("mainWindowsContactsTabOpenNewConversationWithUser - Failed with Exception: " + exception + "...\n");
			throw new Exception("mainWindowsContactsTabOpenNewConversationWithUser - Failed - Exception occurs: " + exception);
		}
		logger.info("mainWindowsContactsTabOpenNewConversationWithUser - completed...\n");		
    }
	
	public boolean verifyCalleeName(WindowsDriver windowsDriverRoot,String Expected) throws Exception{
		logger.info("verifyCalleeName - starting...\n");
		winClientDriver = createWinHandleDriver(windowsDriverRoot, "Avaya Equinox");
		boolean s = false;
		try {
            if(selenium.isElementExisted(winClientDriver, windowsClient.ACW_CALLEE_INFO(Expected))){
                logger.info("*** makeCallBySearching: "+Expected+ " *** PASSED");
                s = true;
            }
            else{
                String msg = String.format(" *** Wrong callee: "+Expected+" info displayed ***");
                logger.error(msg);
                throw new AssertionError(msg);
                
            }
		} catch (Exception e) {
			// TODO: handle exception
			s = false;
		}
		return s;
	}
	
	  public void answerCall(WindowsDriver windowsDriverRoot) throws Exception {
		  winClientDriver = createWinHandleDriver(windowsDriverRoot, "Avaya Equinox");
	        String message = String.format("*** answerCall - Answer Call ***");
	    	
	        logger.warn(message);
	        try {
	            //WebElementActions.isElementDisplayed(driver, ACWinElements.ACW_CALLER_INFO);
	            if (selenium.isElementExisted(winClientDriver, windowsClient.ACW_CALL_BTN_ANSWER_CALL)) {
	            	selenium.clickElement(winClientDriver, windowsClient.ACW_CALL_BTN_ANSWER_CALL);
	            }
	            
	            if(selenium.isElementExisted(winClientDriver, windowsClient.ACW_CALL_BTN_HOLD_CALL)){
	            logger.info("*** answerCall *** PASSED");
	            }
	            else{
	                String msg = String.format(" *** No HOLD button ***");
	                logger.error(msg);
	                throw new AssertionError(message);
	            }
	        } catch (Exception e) {
	            message = String.format("*** answerCall *** FAILED - %s.", e.toString());
	            logger.error(message);
	            throw new AssertionError(message);
	        }
	    }
	  
		public void incomingCallWindowsAcceptCall (WindowsDriver windowsDriverRoot) throws Exception{
			
			logger.info("IncomingCallWindowsAcceptCall - starting...\n");
			winClientDriver = createWinHandleDriver(windowsDriverRoot, "Avaya Equinox");
			try {
				Thread.sleep(3000);
				if(selenium.isElementExisted(winClientDriver, windowsClient.INCOMING_CALL_NOTIFICATION_ACCEPT_BTN)){
					
				selenium.clickElement(winClientDriver, windowsClient.INCOMING_CALL_NOTIFICATION_ACCEPT_BTN);
				Thread.sleep(3000);	
				}else{
					logger.error("*** There is no Answer button ****");
					
					throw new Exception("*** There is no Answer button ****");
				}
					
			} catch (Exception exception) {
				driverMgnt.setFailedWinClientDriver(winClientDriver);
				logger.error("conversationWindowsAcceptedCall - Failed with Exception: " + exception + "...\n");
				throw new Exception("conversationWindowsAcceptedCall - Failed - Exception occurs: " + exception);
			}
			logger.info("conversationWindowsAcceptedCall - completed...\n");		
	    }
		
		public void outgoingCallDropCallButton(WindowsDriver winClientDriver) throws Exception{
			logger.info("conversationWindowsMakeACall - starting...\n");
			try {
				selenium.clickElement(winClientDriver, windowsClient.OUTGOING_CALL_DROP_BTN);
				Thread.sleep(3000);
			} catch (Exception exception) {
				driverMgnt.setFailedWinClientDriver(winClientDriver);
				logger.error("outgoingCallDropCallButton - Failed with Exception: " + exception + "...\n");
				throw new Exception("outgoingCallDropCallButton - Failed - Exception occurs: " + exception);
			}
			logger.info("outgoingCallDropCallButton - completed...\n");		
	    }
		
		public boolean verifyCallHistoryContact(WindowsDriver windowsDriverRoot,String Expected) throws Exception{
			logger.info("verifyCallHistoryContact - starting...\n");
			winClientDriver = createWinHandleDriver(windowsDriverRoot, "Avaya Equinox");
			boolean s = false;
			try {
                if(selenium.isElementExisted(winClientDriver, windowsClient.CALL_HISTORY_CONTACT_NAME(Expected))){
                    logger.info("*** verifyCallHistoryContact: "+Expected+" *** PASSED");
                    s = true;
                }
                else{
                    String msg = String.format(" *** Wrong callee: "+Expected+" info displayed ***");
                    logger.error(msg);
                    throw new AssertionError(msg);
                }
			} catch (Exception e) {
				// TODO: handle exception
				s = false;
			}
			return s;
		}
		
		public void mainWindowsNavigateToHistoryTab (WindowsDriver windowsDriverRoot) throws Exception{
			logger.info("mainWindowsNavigateToHistoryTab - starting...\n");
			winClientDriver = createWinHandleDriver(windowsDriverRoot, "Avaya Equinox");
			try {
				selenium.waitUntilElementClickable(winClientDriver, windowsClient.MAIN_WINDOWS_HISTORY_BTN);
				selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_HISTORY_BTN);
				Thread.sleep(1000);	
			} catch (Exception exception) {
				driverMgnt.setFailedWinClientDriver(winClientDriver);
				logger.error("mainWindowsNavigateToHistoryTab - Failed with Exception: " + exception + "...\n");
				throw new Exception("mainWindowsNavigateToHistoryTab - Failed - Exception occurs: " + exception);
			}
			logger.info("mainWindowsNavigateToHistoryTab - completed...\n");		
	    }
		
		public void mainWindowsNavigateToTopOfMind (WindowsDriver windowsDriverRoot) throws Exception{
			logger.info("mainWindowsNavigateToTopMind - starting...\n");
			winClientDriver = createWinHandleDriver(windowsDriverRoot, "Avaya Equinox");
			try {
				selenium.waitUntilElementClickable(winClientDriver, windowsClient.MAIN_WINDOWS_TOP_OF_MIND_BTN);
				selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_TOP_OF_MIND_BTN);
				Thread.sleep(1000);	
			} catch (Exception exception) {
				driverMgnt.setFailedWinClientDriver(winClientDriver);
				logger.error("mainWindowsNavigateToTopMind - Failed with Exception: " + exception + "...\n");
				throw new Exception("mainWindowsNavigateToTopMind - Failed - Exception occurs: " + exception);
			}
			logger.info("mainWindowsNavigateToTopMind - completed...\n");		
	    }
		
		public boolean verifyEnhancedSearchContact(WindowsDriver windowsDriverRoot,String searchName, String searchLocation, String searchDepartment, String expected) throws Exception {
			logger.info("verifyEnhancedSearchContact - starting...\n");
			winClientDriver = createWinHandleDriver(windowsDriverRoot, "Avaya Equinox");
			boolean s = false;
			try {
				
				logger.info("**** verifyEnhancedSearchContact - Get number of result ****");
			//	selenium.waitUntilElementVisible(winClientDriver, windowsClient.ENHANCED_SEARCH_NAME_TXT);
				selenium.inputText(winClientDriver, windowsClient.ENHANCED_SEARCH_NAME_TXT, searchName );
				logger.info("**** Input Name ****");
				Thread.sleep(1000);
				selenium.inputText(winClientDriver, windowsClient.ENHANCED_SEARCH_LOCATION_TXT, searchLocation );
				logger.info("**** Input Location ****");
				Thread.sleep(1000);
				selenium.inputText(winClientDriver, windowsClient.ENHANCED_SEARCH_DEPARTMENT_TXT, searchDepartment );
				logger.info("**** Input Department ****");
				Thread.sleep(1000);
				
				selenium.clickElement(winClientDriver, windowsClient.ENHANCED_SEARCH_BTN);
				Thread.sleep(5000);
				
				//selenium.waitUntilElementVisible(winClientDriver, windowsClient.search_contact_enterprise_result());
				String s1 = selenium.getAttribute(winClientDriver, windowsClient.SEARCH_CONTACT_ENTERPRISE_CONTACT_TITLE_BAR,"Name");
				String number = s1.replaceAll("[^0-9]", "");
				int num = Integer.parseInt(number);
				
				logger.info("verifyEnterprieseContactSearch - Number of result: " + num);
				logger.info("**** verifyEnterprieseContactSearch - Verify search ****");
				logger.info("verifyEnterprieseContactSearch - Expected result: " + expected);
				
				for (int i = 0; i < num; i++) {
					String s2 = selenium.getAttribute(winClientDriver, windowsClient.search_contact_enterprise_result(expected), "Name");
					logger.info("verifyEnterprieseContactSearch - result "+(i+1)+": " + s2);
					if (s2.contains(expected)) {
						logger.info("verifyEnterprieseContactSearch - Existed the expected result - PASSED ");
						s = true;
					}
				}
				if (s == false) {
					logger.error("verifyEnterprieseContactSearch - FAILED - Expected result didn't exist");
					throw new Exception("verifyEnterprieseContactSearch - Expected result didn't exist");
				}
				
				//clickCancelSearch(winClientDriver);
				logger.info("verifyEnterprieseContactSearch - PASSED");
				
			} catch (Exception e) {
				
				logger.error("ContactsSearch - Failed with Exception: " + e + "...\n");
				//throw new Exception("ContactsUuSearch - Failed - Exception occurs: " + e);
			}
			
			logger.info("verifylocalContactSearch - completed...\n");
			return s;	
		}
		
		public void clickDropDownEnhanceSearch (WindowsDriver windowsDriverRoot) throws Exception{
			logger.info("clickCancelSearch - starting...\n");
			winClientDriver = createWinHandleDriver(windowsDriverRoot, "Avaya Equinox");
			try {
				Thread.sleep(1000);
				selenium.clickElement(winClientDriver, windowsClient.ENHANCED_SEARCH_DROP_BTN);
				Thread.sleep(10000);
			} catch (Exception exception) {
				logger.error("clickCancelSearch - Failed with Exception: " + exception + "...\n");
			}
			logger.info("clickCancelSearch - completed...\n");		
	    }
		
		public void signout(WindowsDriver windowsDriverRoot) throws Exception{
			logger.info("signout - starting...\n");
			winClientDriver = createWinHandleDriver(windowsDriverRoot, "Avaya Equinox");
			try {
				Thread.sleep(200);
				selenium.waitUntilElementClickable(winClientDriver, windowsClient.MAIN_WINDOWS_AVATAR_BTN);
				selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_AVATAR_BTN);
				Thread.sleep(1000);
				selenium.waitUntilElementClickable(winClientDriver, windowsClient.MAIN_WINDOWS_SIGN_OUT_TEXT);
				selenium.clickElement(winClientDriver, windowsClient.MAIN_WINDOWS_SIGN_OUT_TEXT);
			} catch (Exception exception) {
				driverMgnt.setFailedWinClientDriver(winClientDriver);
				logger.error("sign out - Failed with Exception: " + exception + "...\n");
				throw new Exception("sign out - Failed - Exception occurs: " + exception);
			}
			logger.info("sign out - completed...\n");		
	    }
		
		public void signin(WindowsDriver windowsDriverRoot) throws Exception{
			logger.info("signin - starting...\n");
			WindowsDriver winClientDriver = createWinHandleDriver(windowsDriverRoot, "Settings");
			try {
				Thread.sleep(200);
				selenium.waitUntilElementClickable(winClientDriver, windowsClient.FIRST_WINDOWS_SIGN_IN_BTN);
				selenium.clickElement(winClientDriver, windowsClient.FIRST_WINDOWS_SIGN_IN_BTN);
			} catch (Exception exception) {
				driverMgnt.setFailedWinClientDriver(winClientDriver);
				logger.error("sign in - Failed with Exception: " + exception + "...\n");
				throw new Exception("sign in - Failed - Exception occurs: " + exception);
			}
			logger.info("sign in - completed...\n");		
	    }
	
}

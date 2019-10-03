package libs.clients;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.windows.WindowsDriver;
import libs.common.DriverManagement;
import libs.common.Selenium;
import libs.clients.AndroidClientLocators;

public class AndroidClientKeywords {
	
	final static Logger logger = LogManager.getLogger("androidClient");
	Selenium selenium = new Selenium();
	AndroidClientLocators androidClient = new AndroidClientLocators();
	DriverManagement driverMgnt = new DriverManagement();

	AndroidDriver androidClientDriver;
	
	ExtentHtmlReporter htmlReporter;
	static ExtentReports reports;
	ExtentTest test;
	int timeout = 1000;

	public boolean autoConfigLogin(AndroidDriver androidClientDriver,
			String address, String usr, String pwd) throws Exception {
		boolean n = false;
		logger.info("autoConfigLogin - starting");
		try {
			selenium.clickElement(androidClientDriver,	androidClient.FIRST_SCREEN_SETTING_BTN);

			selenium.clickElement(androidClientDriver,	androidClient.FIRST_SCREEN_SETTING_USE_WEB_BTN);

			selenium.clickElement(androidClientDriver,androidClient.FIRST_SCREEN_SETTING_WEB_ADDRESS_TXT);
			selenium.inputText(androidClientDriver,	androidClient.FIRST_SCREEN_SETTING_WEB_ADDRESS_TXT, address);
			selenium.clickElement(androidClientDriver,	androidClient.FIRST_SCREEN_SETTING_USE_WEB_NEXT_BTN);

			selenium.clickElement(androidClientDriver,androidClient.AADS_LOGIN_SCREEN_SETTING_USER_TXT);
			selenium.inputText(androidClientDriver,	androidClient.AADS_LOGIN_SCREEN_SETTING_USER_TXT, usr);

			selenium.clickElement(androidClientDriver,	androidClient.AADS_LOGIN_SCREEN_SETTING_PWD_TXT);
			selenium.inputText(androidClientDriver,	androidClient.AADS_LOGIN_SCREEN_SETTING_PWD_TXT, pwd);
			Thread.sleep(1000);
			selenium.clickElement(androidClientDriver,	androidClient.FIRST_SCREEN_SETTING_USE_WEB_NEXT_BTN);
			androidClientDriver.navigate().back();
			androidClientDriver.navigate().back();
			Thread.sleep(1000);

			for (int i = 0; i < 2; i++) // 4
			{
				selenium.clickElement(androidClientDriver,
						androidClient.AADS_LOGIN_SCREEN_ALLOW_TXT);
				Thread.sleep(1000);
			}
			selenium.clickElement(androidClientDriver,
					androidClient.AADS_LOGIN_SCREEN_OK_BTN);
			selenium.clickElement(androidClientDriver,
					androidClient.AADS_LOGIN_SCREEN_ACCEPT_BTN);
			selenium.clickElement(androidClientDriver,
					androidClient.AADS_LOGIN_SCREEN_ACCEPT_COMFIRM_BTN);
			selenium.clickElement(androidClientDriver,
					androidClient.AADS_LOGIN_SCREEN_SKIP_TUTORIAL_BTN);
			n = true;
		} catch (Exception exception) {
		}
		logger.info("autoConfigLogin - complete");
		return n;
	}
	
	public void cancelSearch(AndroidDriver androidClientDriver) throws Exception{
		try {
			
			Thread.sleep(3000);
			if (selenium.isElementExisted(androidClientDriver, androidClient.CONTACT_DETAIL_SCREEN_SEARCH_CANCEL_BTN)) {
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_DETAIL_SCREEN_SEARCH_CANCEL_BTN);	
			}
			
		} catch (Exception exception) {
			//throw new Exception("cancelSearch - Failed - Exception occurs: " + exception);
		}
    }
	

	
	public void clickDoneEnhanceSearch(AndroidDriver androidClientDriver) throws Exception{
		try {
			logger.info("clickDoneEnhanceSearch - starting");
			Thread.sleep(3000);
			if (selenium.isElementExisted(androidClientDriver, androidClient.ENHANCED_SEARCH_DONE_BTN)) {
			selenium.clickElement(androidClientDriver, androidClient.ENHANCED_SEARCH_DONE_BTN);	
			}
			
		} catch (Exception exception) {
			//throw new Exception("cancelSearch - Failed - Exception occurs: " + exception);
		}
    }
	
	
	
	public void clickDropDownEnhanceSearch (AndroidDriver androidClientDriver) throws Exception{
		logger.info("clickDropDownEnhanceSearch - starting...\n");
		try {
			selenium.clickElement(androidClientDriver, androidClient.ENHANCED_SEARCH_DROP_BTN);
		} catch (Exception exception) {
			logger.error("clickDropDownEnhanceSearch - Failed with Exception: " + exception + "...\n");
		}
		logger.info("clickDropDownEnhanceSearch - completed...\n");		
    }
	
	public boolean verifyEnhancedSearchContact(AndroidDriver androidClientDriver,String searchName, String searchLocation, String searchDepartment, String expected) throws Exception {
		logger.info("verifyEnhancedSearchContact - starting...\n");
		boolean s = false;
		try {
			
			logger.info("**** verifyEnhancedSearchContact - Get number of result ****");
		//	selenium.waitUntilElementVisible(winClientDriver, windowsClient.ENHANCED_SEARCH_NAME_TXT);
			selenium.inputText(androidClientDriver, androidClient.ENHANCED_SEARCH_NAME_TXT, searchName );
			logger.info("**** Input Name ****");
			selenium.inputText(androidClientDriver, androidClient.ENHANCED_SEARCH_LOCATION_TXT, searchLocation );
			logger.info("**** Input Location ****");
			selenium.inputText(androidClientDriver, androidClient.ENHANCED_SEARCH_DEPARTMENT_TXT, searchDepartment );
			logger.info("**** Input Department ****");
			androidClientDriver.navigate().back();
			androidClientDriver.navigate().back();
			//androidClientDriver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(2000);
			selenium.clickElement(androidClientDriver, androidClient.ENHANCED_SEARCH_BTN);
			Thread.sleep(7000);
			
			//selenium.waitUntilElementVisible(winClientDriver, windowsClient.search_contact_enterprise_result());	
			logger.info("**** verifyEnterprieseContactSearchOnACA - Get number of result ****");
			String s1 = selenium.getAttribute(androidClientDriver, androidClient.SEARCH_CONTACT_ENTERPRISE_CONTACT_TITLE_BAR, "text");
			String number = s1.replaceAll("[^0-9]", "");
			int num = Integer.parseInt(number);
			
			logger.info("verifyEnterprieseContactSearch - Number of result: " + num);
			logger.info("**** verifyEnterprieseContactSearch - Verify search ****");
			logger.info("verifyEnterprieseContactSearch - Expected result: " + expected);
			
			for (int i = 0; i < num; i++) {
				String order = String.valueOf(i + 1);
				// get value in Enterprise if found
				String s2 = selenium.getText(androidClientDriver, androidClient.enterprise_result_by_order(order));
				logger.info("verifyEnterprieseContactSearch - result "+(i+1)+": " + s2);
				if (s2.contains(expected)) {
					logger.info("verifyEnterprieseContactSearch - Existed the expected result - PASSED ");
					s = true;
					break;
				}
			}
			if (s == false) {
				logger.error("verifyEnterprieseContactSearch - FAILED - Expected result didn't exist");
				throw new Exception("verifyEnterprieseContactSearch - Expected result didn't exist");
			}
			
			logger.info("verifyEnterprieseContactSearch - PASSED");
			
		} catch (Exception e) {
			
			logger.error("ContactsSearch - Failed with Exception: " + e + "...\n");
			//throw new Exception("ContactsUuSearch - Failed - Exception occurs: " + e);
		}
		
		logger.info("verifylocalContactSearch - completed...\n");
		return s;	
	}


	public void openEnhanceSearch(AndroidDriver androidClientDriver) throws Exception{
		logger.info("EnhanceShearch - starting...\n");
		try {
			selenium.clickElement(androidClientDriver, androidClient.CONTACT_SCREEN_SEARCH_TXT);
			clickDropDownEnhanceSearch(androidClientDriver);
		}catch (Exception e) {
			driverMgnt.setFailedWinClientDriver(androidClientDriver);
			logger.error("OpenEnhanceSearch - Failed with Exception: " + e + "...\n");
			}
		}

	public void relogin(AndroidDriver androidClientDriver) throws Exception{
		logger.info("relogin - starting...\n");
		try {
			selenium.clickElement(androidClientDriver, androidClient.PROFILE_AVATAR);
			boolean signoutButtonExist = selenium.isElementExisted(androidClientDriver, androidClient.SIGN_OUT_BTN);
			if(!signoutButtonExist){
				logger.info("Need to swipe screen");
				selenium.scrollFromElementToElement(androidClientDriver, androidClient.PREFERENCES, androidClient.LOCAL_USER_AVATAR);
			}
			selenium.clickElement(androidClientDriver, androidClient.SIGN_OUT_BTN);
			selenium.waitUntilElementClickable(androidClientDriver, androidClient.SIGN_IN_BTN);
			selenium.clickElement(androidClientDriver, androidClient.SIGN_IN_BTN);
			Thread.sleep(5000);
			
		}catch (Exception e){
			driverMgnt.setFailedWinClientDriver(androidClientDriver);
			logger.error("signin - Failed with Exception: " + e + "...\n");
			throw new Exception("signin - Failed - Exception occurs: " + e);
		}
		logger.info("relogin - completed...\n");
		
	}
	
}
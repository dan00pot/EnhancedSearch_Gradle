package libs.clients;

import java.awt.Event;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.lang.reflect.Field;

import org.apache.logging.log4j.Logger;

import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.remote.http.W3CHttpCommandCodec;
import org.openqa.selenium.remote.http.W3CHttpResponseCodec;

import excel.Constant;
import excel.ExcelUtils;
import io.qameta.allure.Step;

import libs.clients.AADSWebLocators;
import libs.common.DriverManagement;
import libs.common.Selenium;
import testData.*;


public class AADSWebKeywords {
	final static Logger logger = LogManager.getLogger("AADS Web Actions");
	Selenium selenium = new Selenium();
	AADSWebLocators AADSWeb = new AADSWebLocators();
	aadsData aadsData = new aadsData();
	DriverManagement driverMgnt = new DriverManagement();

	@Step("Type {user.name} / {user.password}.")
	public void loginAADSMainPage(WebDriver driver, String userName,
			String password) throws Exception {
		try {
			selenium.inputText(driver, AADSWeb.AADS_LOGIN_PAGE_USERNAME_TXT,userName);
			selenium.inputText(driver, AADSWeb.AADS_LOGIN_PAGE_PASSWORD_TXT,password);
			selenium.clickElement(driver, AADSWeb.AADS_SIGN_IN_BTN);
			Assert.assertTrue(true);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	

	public void logoutAADSMainPage(WebDriver driver) throws Exception {
		try {
			selenium.switchToDefaultContent(driver);
			selenium.clickElement(driver, AADSWeb.AADS_MAIN_PAGE_LOGOFF_BTN);
			Assert.assertTrue(true);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	public void navigateToFeaturesPage(WebDriver webDriver, String featurename)throws Exception {
		logger.info("navigateToFeaturesPage - " + featurename + "\n");
		webDriver.switchTo().defaultContent();
		try {
			selenium.clickElement(webDriver, AADSWeb.mainPageGroupFeaturesLocators(featurename));
		} catch (Exception exception) {
			throw new Exception("navigateToFeaturesPage - Failed - Exception occurs: "+ exception);
		}

	}

	

	public void configurationPageSelectConfigurationUser(WebDriver webDriver,String user) throws Exception {
		logger.info("configurationPageSelectConfigurationUser - starting...\n");
		try {
			if (selenium.isElementExisted(webDriver,
					AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_IFRAME)) {
				selenium.switchToFrame(webDriver,
						AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_IFRAME);
			}
			selenium.clickElement(webDriver,AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SELECT_CONFIGURATION_BTN);
			selenium.dropDownListBox(webDriver,	AADSWeb.DYNAMIC_CONFIGURATION_CONFIGURATION_PAGE_SELECT_USER_LIST,user);
		} catch (Exception exception) {
			throw new Exception("configurationPageSelectConfigurationUser - Failed - Exception occurs: "+ exception);

		}

	}

	
	

	public void selectEnhancedSearchOption(WebDriver webDriver, String option) throws Exception {
		logger.info("selectEnhancedSearchOption - starting...\n");
		try {

			Thread.sleep(1000);
			selenium.dropDownListBox(webDriver, AADSWeb.ENHANCE_SEARCH_OPTION, option);
			Thread.sleep(1000);
			selenium.doubleClickElement(webDriver, AADSWeb.ENHANCE_SEARCH_SAVE_BTN);
			Thread.sleep(2000);
		} catch (Exception exception) {
			driverMgnt.setFailedWinClientDriver(webDriver);
			logger.error("configurationPageVerifyGroupDisplay - Failed with Exception: " + exception + "...\n");
			throw new Exception("configurationPageVerifyGroupDisplay - Failed - Exception occurs: " + exception);
		}
	}

	public void configurationEnhanceSearch(WebDriver webDriver, String string) throws Exception{
		logger.info("configurationEnhanceSearch - starting...\n");
		try {
		navigateToFeaturesPage(webDriver, "Client Administration");
		Thread.sleep(1000);
		navigateToFeaturesPage(webDriver, "Enhanced Search Configuration");
		Thread.sleep(2000);
		selectEnhancedSearchOption(webDriver, string);
		Thread.sleep(3000);
		webDriver.close();
		
		}catch (Exception e) {
			
		}logger.info("configurationEnhanceSearch -completed...\n");
		}
	
}

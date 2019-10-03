package libs.clients;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import libs.common.DriverManagement;
import libs.common.Selenium;;

public class IOSClientKeywords {
	
	final static Logger logger = LogManager.getLogger("iosClient");
	Selenium selenium = new Selenium();
	IOSClientLocators iOSClient = new IOSClientLocators();

	IOSDriver iOSClientDriver;
	int timeout = 10;
	DriverManagement driverMgnt = new DriverManagement();
	
	public void resetApp(IOSDriver iOSClientDriver) throws Exception {
		int i=0;

		logger.info("resetApp- start");
		while (true) {
			if(i==3) break;

		try {
			if (selenium.isElementExisted(iOSClientDriver, iOSClient.LICENSE_AGREEMENT_ACCEPT_BTN)) {
				selenium.clickElement(iOSClientDriver, iOSClient.LICENSE_AGREEMENT_ACCEPT_BTN);		
			}
			Thread.sleep(2000);
			if (!selenium.isElementExisted(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_CONFIGURE_MY_ACCOUNT_BTN)) {
				if(!selenium.isElementExisted(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN)){
					if(selenium.isElementExisted(iOSClientDriver, iOSClient.SETTING_SCREEN_DONE_BTN)){
					selenium.clickElement(iOSClientDriver, iOSClient.SETTING_SCREEN_DONE_BTN);
					Thread.sleep(4000);}
					selenium.clickElement(iOSClientDriver, iOSClient.MAIN_SCREEN_SERVICE_SETTING_BUTTON);
				} else {
					Thread.sleep(2000);
					selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN);
					Thread.sleep(2000);
					selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_SETTING_BTN);
				}
				Thread.sleep(3000);
				selenium.clickElement(iOSClientDriver, iOSClient.SETTING_SCREEN_SUPPORT_TAB_BTN);
				selenium.clickElement(iOSClientDriver, iOSClient.SETTING_SCREEN_SUPPORT_TAB_RESET_APP_BTN);
				if(selenium.isElementExisted(iOSClientDriver, iOSClient.SETTING_SCREEN_SUPPORT_TAB_RESET_APP_OK_BTN)) {
				selenium.clickElement(iOSClientDriver, iOSClient.SETTING_SCREEN_SUPPORT_TAB_RESET_APP_OK_BTN);
				break;}
			}

		} catch (Exception e) {
			logger.error("resetApp - Failed with Exception: " + e + "...\n");
//			throw new Exception("resetApp - Failed - Exception occurs: " + e);
			i++;
		}}

	}
	
	
	public boolean autoConfigLogin(IOSDriver iOSClientDriver, String url, String user, String pwd) throws Exception {
		logger.info("autoConfigLogin - starting...\n");
		boolean n=false;
		try {
			Thread.sleep(1000);
			if(selenium.isElementExisted(iOSClientDriver, iOSClient.LICENSE_AGREEMENT_ACCEPT_BTN)) {
				selenium.clickElement(iOSClientDriver, iOSClient.LICENSE_AGREEMENT_ACCEPT_BTN);
				Thread.sleep(2000);}
			
			if(selenium.isElementExisted(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_CONFIGURE_MY_ACCOUNT_BTN)) {
				selenium.clickElement(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_CONFIGURE_MY_ACCOUNT_BTN);
				Thread.sleep(2000);} 
			else {
				if (selenium.isElementExisted(iOSClientDriver, iOSClient.MEETING_SIGN_IN_BTN)) {
				selenium.clickElement(iOSClientDriver, iOSClient.MEETING_SIGN_IN_BTN);}
				Thread.sleep(2000);
			}
			
			if (selenium.isElementExisted(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_CONFIGURE_MY_ACCOUNT_BTN)) {
				selenium.clickElement(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_CONFIGURE_MY_ACCOUNT_BTN);}
			
			Thread.sleep(2000);
			selenium.clickElement(iOSClientDriver, iOSClient.MAIN_SCREEN_SERVICE_SETTING_BUTTON);
			Thread.sleep(2000);
			selenium.clickElement(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_SETTING_USE_WEB_ADDRESS_BTN);
			Thread.sleep(3000);
			Thread.sleep(2000);
			selenium.inputText(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_WEB_ADDRESS_TXT, url);
			Thread.sleep(1000);
			selenium.clickElement(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_NEXT_BTN);
			Thread.sleep(5000);
			selenium.inputText(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_USER_TXT, user);
			Thread.sleep(2000);
			selenium.inputText(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_PWD_TXT, pwd);
			Thread.sleep(1000);
			selenium.clickElement(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_NEXT_BTN);
			
			if(selenium.isElementExisted(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_USER_TXT))
			{
				logger.info("autoConfigLogin - Need to login Multimedia Messaging account starting...\n");
				selenium.inputText(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_USER_TXT, user);
				Thread.sleep(2000);
				selenium.inputText(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_PWD_TXT, pwd);
				Thread.sleep(1000);
				if(selenium.isElementExisted(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_NEXT_BTN)) {
				selenium.clickElement(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_NEXT_BTN);}
				else selenium.clickElement(iOSClientDriver, iOSClient.LOGIN_BTN_SIGNIN);
				logger.info("autoConfigLogin - Need to login Multimedia Messaging account completed...\n");
				
			}
			
			
			Thread.sleep(3000);
			if (selenium.isElementExisted(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_OK_BTN)) {
				selenium.clickElement(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_OK_BTN);
			}
			Thread.sleep(3000);
			if (selenium.isElementExisted(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_SKIP_BTN)) {
				selenium.clickElement(iOSClientDriver, iOSClient.AUTOLOGIN_SCREEN_SKIP_BTN);
				n=true;	
			}
			Thread.sleep(2000);

		} catch (Exception exception) {
			logger.error("autoConfigLogin - Failed with Exception: " + exception + "...\n");
			Thread.sleep(2000);
			resetApp(iOSClientDriver);
			Thread.sleep(5000);
			iOSClientDriver = driverMgnt.createIOSClientDriver();
		}
		logger.info("autoConfigLogin - completed...\n");
		return n;
	}
	
	
	public boolean addContactBySearch(IOSDriver iOSClientDriver, String user) throws Exception {
		String message = String.format("*** addContactBySearch - Add Contact by Search ");
		logger.warn(message);
		try {
			selenium.inputText(iOSClientDriver, iOSClient.CONTACT_SCREEN_SEARCH_TXT, user);
			Thread.sleep(10000);
			selenium.clickElement(iOSClientDriver, iOSClient.SEARCH_RESULT_USER_BTN(user));
			selenium.clickElement(iOSClientDriver, iOSClient.SEARCH_RESULT_USER_BTN(user));
			Thread.sleep(3000);
			selenium.clickElement(iOSClientDriver, iOSClient.ADD_CONTACT_BTN); //CONTACT_SEARCH_CANCEL_BTN	
			Thread.sleep(10000);
			selenium.clickElement(iOSClientDriver, iOSClient.CONTACT_SEARCH_CANCEL_BTN	);
			return true;
		} catch (Exception e) {

			Escape(iOSClientDriver);
			
			return false;
		}
		
	}
	
	public void clickBack(IOSDriver iOSClientDriver) {
		try {
			if(selenium.isElementExisted(iOSClientDriver, iOSClient.PRESENCES_DETAIL_BACK_BTN)) {
				selenium.clickElement(iOSClientDriver, iOSClient.PRESENCES_DETAIL_BACK_BTN);}
			Thread.sleep(2000);
			if(selenium.isElementExisted(iOSClientDriver, iOSClient.CONTACT_SEARCH_CANCEL_BTN)) {
				selenium.clickElement(iOSClientDriver, iOSClient.CONTACT_SEARCH_CANCEL_BTN);}
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void cancelSearch(IOSDriver iOSClientDriver) throws Exception{
		try {
			
			Thread.sleep(3000);
			if (selenium.isElementExisted(iOSClientDriver, iOSClient.CONTACT_SEARCH_CANCEL_BTN)) {
			selenium.clickElement(iOSClientDriver, iOSClient.CONTACT_SEARCH_CANCEL_BTN);	
			}
			
		} catch (Exception exception) {
			//throw new Exception("cancelSearch - Failed - Exception occurs: " + exception);
		}
	}


	public void Escape(IOSDriver iOSClientDriver) {
		try {
			if(selenium.isElementExisted(iOSClientDriver, iOSClient.CONTACT_DETAIL_DISMISS)) {
				selenium.clickElement(iOSClientDriver, iOSClient.CONTACT_DETAIL_DISMISS);}
			Thread.sleep(2000);
			if(selenium.isElementExisted(iOSClientDriver, iOSClient.ADD_CONTACT_SCREEN_DONE_BTN)) {
				selenium.clickElement(iOSClientDriver, iOSClient.ADD_CONTACT_SCREEN_DONE_BTN);}
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public boolean removeContact(IOSDriver iOSClientDriver, String user) throws Exception {
		String message = String.format("*** removeContact - Add Contact by Search ");
		logger.warn(message);
		boolean s=false;
		try {
			Thread.sleep(2000);
			selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN);
			Thread.sleep(3000);
			selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_NAVIGATE_CONTACTS_TAB_BTN);
			Thread.sleep(2000);
			selenium.clickElement(iOSClientDriver, iOSClient.SEARCH_RESULT_USER_BTN(user));
			selenium.clickElement(iOSClientDriver, iOSClient.SEARCH_RESULT_USER_BTN(user));
			Thread.sleep(3000);
			selenium.clickElement(iOSClientDriver, iOSClient.CONTACT_DETAIL_REMOVE_CONTACT);
			selenium.clickElement(iOSClientDriver, iOSClient.CONTACT_DETAIL_REMOVE_CONTACT_CONFIRM);
			Thread.sleep(10000);
			if (!selenium.isElementExisted(iOSClientDriver, iOSClient.CONTACT_DETAIL_REMOVE_CONTACT)) 
				s=true;
		} catch (Exception e) {
			Escape(iOSClientDriver);
			message = String.format("*** removeContact *** FAILED - %s.", e.toString());
			logger.error(message);

//			throw new AssertionError(message);
		}
		return s;
	}
	public boolean editContact(IOSDriver iOSClientDriver, String user, String field, String value) throws Exception {
		String message = String.format("*** editContact - Add Contact by Search ");
		logger.warn(message);
		try {
			navigateToContactDetailScreen(iOSClientDriver, user);
			Thread.sleep(3000);
			selenium.clickElement(iOSClientDriver, iOSClient.CONTACT_DETAIL_EDIT_CONTACT);
			Thread.sleep(3000);
			// selenium.inputText(iOSClientDriver,
			// iOSClient.EDIT_CONTACT_SCREEN_TXT_FIELD(field), value);
			selenium.inputText(iOSClientDriver, iOSClient.EDIT_CONTACT_SCREEN_TXT_FIELD_TEXT, value);
			selenium.clickElement(iOSClientDriver, iOSClient.EDIT_CONTACT_SCREEN_DONE_BTN);
			return true;
		} catch (Exception e) {
			message = String.format("*** editContact *** FAILED - %s.", e.toString());
			logger.error(message);
			return false;
		}

	}

	public void editContactPhone(IOSDriver iOSClientDriver, String user, String number) throws Exception {
		String message = String.format("*** removeContact - Add Contact by Search ");
		logger.warn(message);
		try {
			navigateToContactDetailScreen(iOSClientDriver, user);
			Thread.sleep(3000);
			selenium.clickElement(iOSClientDriver, iOSClient.CONTACT_DETAIL_EDIT_CONTACT);
			Thread.sleep(3000);
			selenium.inputText(iOSClientDriver, iOSClient.EDIT_CONTACT_SCREEN_OLD_PHONE_TXT(user), number);
			selenium.clickElement(iOSClientDriver, iOSClient.EDIT_CONTACT_SCREEN_DONE_BTN);
		} catch (Exception e) {
			message = String.format("*** removeContact *** FAILED - %s.", e.toString());
			logger.error(message);
			throw new AssertionError(message);
		}

	}
	
	public boolean verifyEnterpriseContactSearch(IOSDriver iOSClientDriver, String email, String name)
			throws Exception {
		try {
			boolean flag = false;
			logger.info("**** verifyEnterprieseContactSearch - Start verify contact search****");
			logger.info("verifyEnterprieseContactSearch - Search string: " + email);
			selenium.inputText(iOSClientDriver, iOSClient.CONTACT_SCREEN_SEARCH_TXT, email);
			Thread.sleep(10000);
			logger.info("**** verifyEnterprieseContactSearch - Get number of result ****");
			String s1 = selenium.getAttribute(iOSClientDriver, iOSClient.SEARCH_CONTACT_ENTERPRISE_CONTACT_TITLE_BAR,
					"name");
			String stringNumber = s1.replaceAll("[^0-9]", "");
			int num = Integer.parseInt(stringNumber);
			logger.info("verifyEnterprieseContactSearch - Number of result: " + num);
			logger.info("**** verifyEnterprieseContactSearch - Verify search ****");
			logger.info("verifyEnterprieseContactSearch - Expected result: " + name);
			for (int i = 0; i < num; i++) {
				String order = String.valueOf(i + 1);
				String s2 = selenium.getAttribute(iOSClientDriver, iOSClient.enterprise_result_by_order(order),
						"value");
				logger.info("verifyEnterprieseContactSearch - result " + (i + 1) + ": " + s2);
				if (s2.contains(name)) {
					logger.error("verifyEnterprieseContactSearch - Existed the expected result - PASSED OH YEAH");
					flag = true;
					break;
				}
			}
			if (flag == false) {
				logger.error("verifyEnterprieseContactSearch - FAILED - Expected result didn't exist");
				return false;
			}
			logger.error("verifyEnterprieseContactSearch - PASSED OH YEAH");
			return true;
		} catch (Exception e) {
			logger.error("verifyEnterprieseContactSearch - Failed with Exception: " + e + "...\n");
			throw new Exception("verifyEnterprieseContactSearch - Failed - Exception occurs: " + e);
		}
		
	}
	
	public void navigateToContactDetailScreen(IOSDriver iOSClientDriver, String user) throws Exception {
		logger.info("navigateToContactDetailScreen - starting...\n");
		try {
			Thread.sleep(2000);
			selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN);
			Thread.sleep(3000);
			selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_NAVIGATE_CONTACTS_TAB_BTN);
			Thread.sleep(2000);
			selenium.clickElement(iOSClientDriver, iOSClient.SEARCH_RESULT_USER_BTN(user));
			selenium.clickElement(iOSClientDriver, iOSClient.SEARCH_RESULT_USER_BTN(user));
		} catch (Exception exception) {
			logger.error("navigateToContactDetailScreen - Failed with Exception: " + exception + "...\n");
			throw new Exception("navigateToContactDetailScreen - Failed - Exception occurs: " + exception);
		}
		logger.info("navigateToContactDetailScreen - completed...\n");

	}
	
	public boolean verifyContactIsExistedContactList(IOSDriver iOSClientDriver, String contact) throws Exception {
		logger.info("verifyContactIsExistedContactList - starting...\n");
		boolean s= false;
		try {
			selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN);
			Thread.sleep(3000);
			selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_NAVIGATE_CONTACTS_TAB_BTN);
			Thread.sleep(2000);
			if (selenium.isElementExisted(iOSClientDriver, iOSClient.SEARCH_RESULT_USER_BTN(contact))) {
				s=true;
			}
				else {
					s = false;	
				throw new Exception("Contact is not existed - Failed - Contact: " + contact);
			}
		} catch (Exception exception) {
			//driverMgnt.setFailedWinClientDriver((WebDriver) iOSClientDriver);
			logger.error("verifyContactIsExistedContactList - Failed with Exception: " + exception + "...\n");
			throw new Exception("verifyContactIsExistedContactList - Failed - Exception occurs: " + exception);
		}
		logger.info("verifyContactIsExistedContactList - completed...\n");
		return s;
	}
	
	public boolean addLocalContact(IOSDriver iOSClientDriver, String firstname, String lastname, String number,
			String address) throws Exception {
		String message = String.format("*** addLocalContact - Add Contact ");
		boolean s = false;
		logger.warn(message);
		try {
			selenium.waitUntilElementClickable(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN);
			selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN);
			Thread.sleep(3000);
			selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_NAVIGATE_CONTACTS_TAB_BTN);
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(iOSClientDriver, iOSClient.CONTACT_SCREEN_ADD_BTN);
			selenium.clickElement(iOSClientDriver, iOSClient.CONTACT_SCREEN_ADD_BTN);
			Thread.sleep(3000);
			selenium.waitUntilElementClickable(iOSClientDriver, iOSClient.CONTACT_SCREEN_NEW_CONTACT_BTN);
			selenium.clickElement(iOSClientDriver, iOSClient.CONTACT_SCREEN_NEW_CONTACT_BTN);
			Thread.sleep(3000);
			selenium.waitUntilElementClickable(iOSClientDriver, iOSClient.ADD_CONTACT_SCREEN_FIRST_NAME_TXT);
			selenium.inputText(iOSClientDriver, iOSClient.ADD_CONTACT_SCREEN_FIRST_NAME_TXT, firstname);
			selenium.inputText(iOSClientDriver, iOSClient.ADD_CONTACT_SCREEN_LAST_NAME_TXT, lastname);
			selenium.inputText(iOSClientDriver, iOSClient.ADD_CONTACT_SCREEN_PHONE_TXT, number);
			selenium.inputText(iOSClientDriver, iOSClient.ADD_CONTACT_SCREEN_ADDRESS_TXT, address);
			selenium.waitUntilElementClickable(iOSClientDriver, iOSClient.ADD_CONTACT_SCREEN_DONE_BTN);
			selenium.clickElement(iOSClientDriver, iOSClient.ADD_CONTACT_SCREEN_DONE_BTN);
			Thread.sleep(2000);
			s = true;
			
		} catch (Exception e) {
			
			logger.error(message);
			s = false;
			Escape(iOSClientDriver);
		}
//		clickBack(iOSClientDriver);
		return s;
	}
	
	public void settingScreenMainClickOnTab(IOSDriver iOSClientDriver, String tabName) throws Exception {
		logger.info("settingScreenMainClickOnTab - starting...\n");
		logger.info("tabName is: " + tabName + "\n");
		try {
			// appium.waitUntilElementClickable(iOSClientDriver,
			// iOSClient.settingScreenTabLocators(tabName), timeout);
			selenium.clickElement(iOSClientDriver, iOSClient.settingScreenTabLocators(tabName));
		} catch (Exception exception) {
			//driverMgnt.setFailedWinClientDriver((WebDriver) iOSClientDriver);
			logger.error("settingScreenMainClickOnTab - Failed with Exception: " + exception + "...\n");
			throw new Exception("settingScreenMainClickOnTab - Failed - Exception occurs: " + exception);
		}
		logger.info("settingScreenMainClickOnTab - completed...\n");
	}
	
	public void navigateToContactsScreen(IOSDriver iOSClientDriver) throws Exception {
		logger.info("navigateToContactsScreen - starting...\n");
		try {
			selenium.waitUntilElementClickable(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN);
			//appium.tapElement(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN);
			selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN);
			Thread.sleep(1000);
			settingScreenMainClickOnTab(iOSClientDriver, "Contacts");
		} catch (Exception exception) {
			driverMgnt.setFailedWinClientDriver(iOSClientDriver);
			logger.error("navigateToContactsScreen - Failed with Exception: " + exception + "...\n");
			throw new Exception("navigateToContactsScreen - Failed - Exception occurs: " + exception);
		}
		logger.info("navigateToContactsScreen - completed...\n");
	}
	
	public void makeSureContactIsFavorite(IOSDriver iOSClientDriver, String user) throws Exception {
		logger.info("makeSureContactIsFavorite - starting...\n");
		logger.info("user is: " + user + "\n");
		try {
			navigateToContactsScreen(iOSClientDriver);
			selenium.waitUntilElementClickable(iOSClientDriver, iOSClient.CONTACT_SCREEN_SEARCH_TXT);
			selenium.mobileInputTextIos(iOSClientDriver, iOSClient.CONTACT_SCREEN_SEARCH_TXT, user);
			iOSClientDriver.getKeyboard().sendKeys(Keys.RETURN);
			Thread.sleep(2000);
			selenium.waitUntilElementClickable(iOSClientDriver, iOSClient.contactDetailScreenFileNameLocator(user));
			selenium.clickElement(iOSClientDriver, iOSClient.contactDetailScreenFileNameLocator(user));
			Thread.sleep(2000);
			if (selenium.isElementExisted(iOSClientDriver, iOSClient.CONTACT_DETAILS_FAVORITE_BTN)) {
				logger.info("Contact has been already marked as Favorite...\n");
			} else {
				if (selenium.isElementExisted(iOSClientDriver, iOSClient.CONTACT_DETAILS_NOTFAVORITE_BTN)) {
					logger.info("Contact hasn't been marked as Favorite yet...\n");
					logger.info("Marking the contact as Favorite - starting...\n");
					selenium.clickElement(iOSClientDriver, iOSClient.CONTACT_DETAILS_NOTFAVORITE_BTN);
					Thread.sleep(7000);
					if (selenium.isElementExisted(iOSClientDriver, iOSClient.CONTACT_DETAILS_FAVORITE_BTN)) {
						logger.info("Contact has been marked as Favorite...\n");
						logger.info("Marking the contact as Favorite - completed...\n");
					} else {
						logger.info(
								"Marking the contact as Favorite - FAILED - Could not mark the contact as Favorite...\n");
					}

				} else {
					logger.info("makeSureContactIsFavorite - FAILED - Favorite icon not found...\n");
				}
			}
			selenium.clickElement(iOSClientDriver, iOSClient.CONTACT_SEARCH_CANCEL_BTN);

		} catch (Exception exception) {
			driverMgnt.setFailedWinClientDriver(iOSClientDriver);
			logger.error("makeSureContactIsFavorite - Failed with Exception: " + exception + "...\n");
			throw new Exception("makeSureContactIsFavorite - Failed - Exception occurs: " + exception);
		}
		logger.info("makeSureContactIsFavorite - completed...\n");
	}
	
	public boolean SearchContact(IOSDriver iOSClientDriver, String input, String result) throws Exception{
		logger.info("TestSearchContact - starting...\n");
		boolean s;
		try {
			Thread.sleep(2000);
		
			selenium.waitUntilElementClickable(iOSClientDriver, iOSClient.CONTACT_SCREEN_SEARCH_TXT);
			selenium.clickElement(iOSClientDriver, iOSClient.CONTACT_SCREEN_SEARCH_TXT);
			Thread.sleep(2000);
			selenium.inputText(iOSClientDriver, iOSClient.CONTACT_SCREEN_SEARCH_TXT, input);
			Thread.sleep(8000);
			//selenium.clickElement(androidClientDriver, androidClient.CONTACT_SCREN_STRING_MUST_CONTAIN(result));
			s=selenium.isElementExisted(iOSClientDriver, iOSClient.SEARCH_RESULT_USER_BTN(result));
			
		} catch (Exception exception) { 
			//driverMgnt.setFailedWinClientDriver((WebDriver) androidClientDriver);
			logger.error("TestSearchContact - Failed with Exception: " + exception + "...\n");
			throw new Exception("TestSearchContact - Failed - Exception occurs: " + exception);
		}
		logger.info("TestSearchContact - completed...\n");
		return s;
    }
	
	public boolean addContactfollowingSearch(IOSDriver iOSClientDriver, String user) throws Exception{

		try {
			Thread.sleep(1000);
			/*appium.waitUntilElementClickable(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN, timeout);
			appium.tapElement(androidClientDriver, androidClient.FIRST_SCREEN_MENU_BTN);*/

//			selenium.clickElement(androidClientDriver, androidClient.CONTACT_SCREEN_LIST_CONTACT_ITEM);
//			Thread.sleep(2000);
			selenium.clickElement(iOSClientDriver, iOSClient.SEARCH_RESULT_USER_BTN(user));
			Thread.sleep(1000);
			selenium.clickElement(iOSClientDriver, iOSClient.ADD_CONTACT_BTN);
			Thread.sleep(2000);	
		} catch (Exception exception) {
//			driverMgnt.setFailedWinClientDriver((WebDriver) androidClientDriver);
//			logger.error("addContactToContactList - Failed with Exception: " + exception + "...\n");
//			throw new Exception("addContactToContactList - Failed - Exception occurs: " + exception);
			Escape(iOSClientDriver);
			cancelSearch(iOSClientDriver);
			return false;
		}
		clickBack(iOSClientDriver);
		cancelSearch(iOSClientDriver);
		return true;
    }
	
	public void signin(IOSDriver iOSClientDriver) throws Exception {
		String message = String.format("*** signout - Log out Equinox for iOS ***");
		logger.warn(message);
		try {

			selenium.waitUntilElementClickable(iOSClientDriver, iOSClient.LOGIN_BTN_SIGNIN);
			selenium.clickElement(iOSClientDriver, iOSClient.LOGIN_BTN_SIGNIN);

			Thread.sleep(2000);
			;
		} catch (Exception e) {
			message = String.format("*** signout *** FAILED - %s.", e.toString());
			logger.error(message);
			throw new AssertionError(message);
		}
	}
	
	public void signout(IOSDriver iOSClientDriver) throws Exception {
		String message = String.format("*** signout - Log out Equinox for iOS ***");
		logger.warn(message);
		try {
/*			if (selenium.isElementExisted(iOSClientDriver, iOSClient.MAIN_SCREEN_USER_IMAGE)) {
				selenium.clickElement(iOSClientDriver, iOSClient.MAIN_SCREEN_USER_IMAGE);
				Thread.sleep(3000);
				selenium.clickElement(iOSClientDriver, iOSClient.BTN_SIGNOUT);
			} else {*/
				selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_BTN);
				Thread.sleep(2000);
				selenium.clickElement(iOSClientDriver, iOSClient.FIRST_SCREEN_EBAR_SETTING_BTN);
				Thread.sleep(2000);
				selenium.clickElement(iOSClientDriver, iOSClient.SETTING_SCREEN_ACOUNTS_TAB_BTN);
				Thread.sleep(3000);
				selenium.clickElement(iOSClientDriver, iOSClient.BTN_SIGNOUT);
				//selenium.clickElement(iOSClientDriver, iOSClient.);
			//}
			Thread.sleep(2000);
		} catch (Exception e) {
			message = String.format("*** signout *** FAILED - %s.", e.toString());
			logger.error(message);
			throw new AssertionError(message);
		}
	}
	
	public void clickDropDownEnhanceSearch (IOSDriver iOSClientDriver) throws Exception{
		logger.info("clickDropDownEnhanceSearch - starting...\n");
		try {
			Thread.sleep(1000);
			selenium.clickElement(iOSClientDriver, iOSClient.ENHANCED_SEARCH_DROP_BTN);
			Thread.sleep(10000);
		} catch (Exception exception) {
			logger.error("clickDropDownEnhanceSearch - Failed with Exception: " + exception + "...\n");
		}
		logger.info("clickDropDownEnhanceSearch - completed...\n");		
    }
	
	public void clickDoneEnhanceSearch(IOSDriver iOSClientDriver) throws Exception{
		try {
			
			Thread.sleep(3000);
			if (selenium.isElementExisted(iOSClientDriver, iOSClient.ENHANCED_SEARCH_DONE_BTN)) {
			selenium.clickElement(iOSClientDriver, iOSClient.ENHANCED_SEARCH_DONE_BTN);	
			}
			
		} catch (Exception exception) {
			//throw new Exception("cancelSearch - Failed - Exception occurs: " + exception);
		}
    }
	
	public boolean verifyEnhancedSearchContact(IOSDriver iOSClientDriver,String searchName, String searchLocation, String searchDepartment, String expected) throws Exception {
		logger.info("verifyEnhancedSearchContact - starting...\n");
		boolean s = false;
		try {
			
			logger.info("**** verifyEnhancedSearchContact - Get number of result ****");
		//	selenium.waitUntilElementVisible(winClientDriver, windowsClient.ENHANCED_SEARCH_NAME_TXT);
			selenium.inputText(iOSClientDriver, iOSClient.ENHANCED_SEARCH_NAME_TXT, searchName );
			logger.info("**** Input Name ****");
			Thread.sleep(1000);
			selenium.inputText(iOSClientDriver, iOSClient.ENHANCED_SEARCH_LOCATION_TXT, searchLocation );
			logger.info("**** Input Location ****");
			Thread.sleep(1000);
			selenium.inputText(iOSClientDriver, iOSClient.ENHANCED_SEARCH_DEPARTMENT_TXT, searchDepartment );
			logger.info("**** Input Department ****");
			Thread.sleep(1000);
			
			selenium.clickElement(iOSClientDriver, iOSClient.ENHANCED_SEARCH_BTN);
			Thread.sleep(10000);
			
//			selenium.waitUntilElementVisible(iOSClientDriver, iOSClient.search_contact_enterprise_result());
			logger.info("**** verifyEnterprieseContactSearch - Get number of result ****");
			String s1 = selenium.getAttribute(iOSClientDriver, iOSClient.SEARCH_CONTACT_ENTERPRISE_CONTACT_TITLE_BAR,
					"name");
			String stringNumber = s1.replaceAll("[^0-9]", "");
			int num = Integer.parseInt(stringNumber);
			logger.info("verifyEnhancedSearchContact - Number of result: " + num);
			logger.info("**** verifyEnhancedSearchContact - Verify search ****");
			logger.info("verifyEnhancedSearchContact - Expected result: " + expected);
			for (int i = 0; i < num; i++) {
				String order = String.valueOf(i + 1);
				String s2 = selenium.getAttribute(iOSClientDriver, iOSClient.enterprise_result_by_order(order),
						"value");
				logger.info("verifyEnhancedSearchContact - result " + (i + 1) + ": " + s2);
				if (s2.contains(expected)) {
					logger.error("verifyEnhancedSearchContact - Existed the expected result - PASSED");
					s = true;
					break;
				}
			}
			if (s == false) {
				logger.error("verifyEnhancedSearchContact - FAILED - Expected result didn't exist");
			}
			logger.error("verifyEnterprieseContactSearch - PASSED");
			
		} catch (Exception e) {
			
			logger.error("ContactsSearch - Failed with Exception: " + e + "...\n");
			throw new Exception("verifyEnhancedSearchContact - Failed - Exception occurs: " + e);
		}
		
		logger.info("verifyEnhancedSearchContact - completed...\n");
		return s;	
	}
	
	public boolean verifyContactNameCommingCallBeforeAccept(IOSDriver iOSClientDriver, String Expected)
			throws Exception {
		boolean flag = false;
		try {
			Thread.sleep(1000);
			if (selenium.isElementExisted(iOSClientDriver,
					iOSClient.INCOMING_CALL_CONTACT_NAME_BEFORE_ACCEPT_CALL(Expected))) {
				flag = true;
				logger.info("PASSED");
			} else {
				logger.error("verifyContactName - Failed");
				throw new Exception("verifyContactName - Failed");
			}
		} catch (Exception e) {
			logger.error("verifyContactName - Failed with Exception: " + e + "...\n");
			throw new Exception("verifyContactName - Failed - Exception occurs: " + e);
		}
		return flag;
	}
	
	public void conversationWindowsAnswerCall(IOSDriver iOSClientDriver) throws Exception {
		logger.info("conversationWindowsAnswerCall - starting...\n");
		try {
			selenium.waitUntilElementClickable(iOSClientDriver, iOSClient.CONVERSATION_DETAIL_SCREEN_ANSWER_VIDEO_BTN);
			selenium.clickElement(iOSClientDriver, iOSClient.CONVERSATION_DETAIL_SCREEN_ANSWER_VIDEO_BTN);
			Thread.sleep(1000);
		} catch (Exception exception) {
			driverMgnt.setFailedWinClientDriver((WebDriver) iOSClientDriver);
			logger.error("conversationWindowsAnswerCall - Failed with Exception: " + exception + "...\n");
			throw new Exception("conversationWindowsAnswerCall - Failed - Exception occurs: " + exception);
		}
		logger.info("conversationWindowsAnswerCall - completed...\n");
	}
	
}

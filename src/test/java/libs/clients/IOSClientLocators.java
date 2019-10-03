package libs.clients;

import org.openqa.selenium.By;

public class IOSClientLocators {

	public By LICENSE_AGREEMENT_ACCEPT_BTN = By.id("ACCEPT");
	public By LICENSE_AGREEMENT_DECLINE_BTN = By.id("DECLINE");
	
	public By SETTING_SCREEN_SUPPORT_TAB_RESET_ABOUT_BTN = By.id("About");
	public By SETTING_SCREEN_SUPPORT_TAB_RESET_TUTORIAL_BTN = By.id("Tutorial");
	public By SETTING_SCREEN_SUPPORT_TAB_ENABLE_DIANOCTICS_SWT = By.xpath("//XCUIElementTypeSwitch[contains(@Name,'Enable Diagnostics')]");
	public By SETTING_SCREEN_SUPPORT_TAB_QUALITY_IMPROVEMENT_SWT = By.xpath("//XCUIElementTypeSwitch[contains(@Name,'Quality Improvement')]");
	public By SETTING_SCREEN_SUPPORT_TAB_REPORT_BTN = By.id("Report a problem");
	public By SETTING_SCREEN_SUPPORT_TAB_LEGAL_BTN = By.id("Legal");
	public By SETTING_SCREEN_SUPPORT_TAB_EMERGENCY_DISCLAIMER = By.id("Emergency Disclaimer");
	public By SETTING_SCREEN_SUPPORT_TAB_RESET_APP_BTN = By.id("Reset Application");
	
	public By SETTING_SCREEN_SUPPORT_TAB_RESET_APP_WARN = By.xpath("//XCUIElementTypeStaticText[contains(@Name,'as a new install?')]");
	public By SETTING_SCREEN_SUPPORT_TAB_RESET_APP_OK_BTN = By.id("OK");
	public By SETTING_SCREEN_SUPPORT_TAB_RESET_APP_CANCEL_BTN = By.id("Cancel");
	
	
	public By AUTOLOGIN_SCREEN_CONFIGURE_MY_ACCOUNT_BTN = By.id("configure");
	public By AUTOLOGIN_SCREEN_SETTING_USE_WEB_ADDRESS_BTN = By.id("ServiceDiscoverySettingsUse");
	//public By LOGIN_SCREEN_SETTING_USE_WEB_ADDRESS_BTN = By.name("USE A WEB ADDRESS");
	public By AUTOLOGIN_SCREEN_WEB_ADDRESS_TXT = By.xpath("//XCUIElementTypeTextField");
	public By AUTOLOGIN_SCREEN_USER_TXT = By.xpath("//XCUIElementTypeTextField");
	public By AUTOLOGIN_SCREEN_PWD_TXT = By.xpath("//XCUIElementTypeSecureTextField");
	public By AUTOLOGIN_SCREEN_NEXT_BTN = By.id("NEXT");
	public By AUTOLOGIN_SCREEN_OK_BTN = By.id("OK");
	public By AUTOLOGIN_SCREEN_SKIP_BTN = By.id("Skip");
	
	public By MAIN_SCREEN_USER_IMAGE = By.id("UserImage");
	
	//###########################################################################################################################
	//########################################LOCATOR OF ELEMENTS IN FIRST SCREEN WHEN LAUNCHING ANDROID CLIENT##################
	//###########################################################################################################################
	public By FIRST_SCREEN_EBAR_BTN									=	By.id("EBarButton");
	public By FIRST_SCREEN_EBAR_SETTING_BTN							=	By.id("EBarSettings");
	public By FIRST_SCREEN_NAVIGATE_TOP_OF_MIND_TAB_BTN				=	By.id("EBarTopOfMind");
	public By FIRST_SCREEN_NAVIGATE_FAVORITES_TAB_BTN				=	By.id("EBarFavorites");
	public By FIRST_SCREEN_NAVIGATE_CONTACTS_TAB_BTN				=	By.id("EBarContacts");
	public By FIRST_SCREEN_NAVIGATE_HISTORY_TAB_BTN					=	By.id("EBarRecents");
	public By FIRST_SCREEN_NAVIGATE_METTINGS_TAB_BTN				=	By.id("EBarMeetings");
	public By FIRST_SCREEN_NAVIGATE_MESSAGES_TAB_BTN				=	By.id("EBarMessaging");
	public By FIRST_SCREEN_NAVIGATE_FEATURES_TAB_BTN				=	By.id("EBarFeatures");
	public By FIRST_SCREEN_MENU_NEW_MSG_COUNT						=	By.id("ebar.badge");
	public By firstScreenEbarTabLocators(String tabname)			{	return By.id(tabname);}
	
	//###########################################################################################################################
		//########################################LOCATOR OF ELEMENTS IN SETTING SCREEN##############################################
		//###########################################################################################################################
		
		public By settingScreenTabLocators(String tabname)			{	return By.id(tabname);}
		
		public By SETTING_SCREEN_DONE_BTN												=	By.id("DONE");
		public By SETTING_SCREEN_BACK_BTN												=	By.id("Back");
		
		public By SETTING_SCREEN_USER_PREFERENCES_TAB_BTN								=	By.id("User Preferences");
		public By SETTING_SCREEN_ACOUNTS_TAB_BTN										=	By.id("Accounts");
		public By SETTING_SCREEN_SERVICES_TAB_BTN										=	By.id("Services");
		public By SETTING_SCREEN_ADVANCED_TAB_BTN										=	By.id("Advanced");
		public By SETTING_SCREEN_SUPPORT_TAB_BTN										=	By.id("Support");
		
		public By settingScreenOptionsInsideTabLocators(String tabname)			{	return By.id(tabname);}
		
		public By SETTING_SCREEN_SERVICES_TAB_SERVICE_DETAILS_SWITCH					=	By.className("XCUIElementTypeSwitch");
		
//		public By SETTING_SCREEN_SERVICES_TAB_UNIFIED_LOGIN_BTN							=	By.id("Unified Login");
//		public By SETTING_SCREEN_SERVICES_TAB_PHONE_SERVICES_BTN						=	By.id("Phone Service");
//		public By SETTING_SCREEN_SERVICES_TAB_MEETING_BTN								=	By.id("Meetings");
//		public By SETTING_SCREEN_SERVICES_TAB_MULTIMEDIA_MESSAGING_BTN					=	By.id("Multimedia Messaging");
//		public By SETTING_SCREEN_SERVICES_TAB_DEVICES_SERVICES_BTN						=	By.id("Device Services");
//		public By SETTING_SCREEN_SERVICES_TAB_CLIENT_ENABLEMENT_BTN						=	By.id("Client Enablement (CES)");
		
		public By SETTING_SCREEN_SERVICES_TAB_PHONE_SERVICE_ON_OFF_SWITCH				=	By.className("XCUIElementTypeSwitch");
		public By SETTING_SCREEN_SERVICES_TAB_PHONE_SERVICES_SV_ADDRESS_TXT				=	By.id("Server Address");
		public By SETTING_SCREEN_SERVICES_TAB_PHONE_SERVICES_DOMAIN_TXT					=	By.id("Domain");
		public By SETTING_SCREEN_SERVICES_TAB_PHONE_SERVICES_SV_PORT_TX					=	By.id("Sever Port");
		
		public By SETTING_SCREEN_SERVICES_TAB_MM_ON_OFF_TOGGLE							=	By.className("XCUIElementTypeSwitch");
		public By SETTING_SCREEN_SERVICES_TAB_MM_SV_ADDRESS_TXT							=	By.id("Server Address");
		public By SETTING_SCREEN_SERVICES_TAB_MM_SV_PORT_TXT							=	By.id("Sever Port");
		public By SETTING_SCREEN_SERVICES_TAB_MM_POLLING_INTERVAL_BTN					=	By.id("Polling Interval");
		
		
		public By SETTING_SCREEN_ACCOUNT_TAB_COMMUNICATOR_USERNAME_TXT					=	By.id("User Name");
		public By SETTING_SCREEN_ACCOUNT_TAB_COMMUNICATOR_PASSWORD_TXT					=	By.id("Password");
		public By SETTING_SCREEN_ACCOUNT_TAB_COMMUNICATOR_CONNECT_BTN					=	By.id("Connect");
//		public By SETTING_SCREEN_ACCOUNT_TAB_COMMUNICATOR_CONNECTED_TXT					=	By.id("com.avaya.android.flare:id/service_connected_as_user");
		
//		public By SETTING_SCREEN_ACCOUNT_TAB_PHONE_EXTENSION_TXT						=	By.id("Extension");
		public By SETTING_SCREEN_ACCOUNT_TAB_PHONE_EXTENSION_TXT						=	By.xpath("//*[contains(@Id,'user_extension_id')]//XCUIElementTypeTextField");
		public By SETTING_SCREEN_ACCOUNT_TAB_PHONE_PASSWORD_TXT							=	By.id("Password");
		public By SETTING_SCREEN_ACCOUNT_TAB_PHONE_SERVICE_CONNECT_BTN					=	By.id("Connect");
//		public By SETTING_SCREEN_ACCOUNT_TAB_PHONE_SERVICE_CONNECTED_TXT				=	By.id("com.avaya.android.flare:id/voip_service_connected_as_user");
		
		public By SETTING_SCREEN_POP_UP_APPLY_CHANGES_BTN								=	By.id("Apply Changes");
		public By SETTING_SCREEN_POP_UP_CONTINUE_EDITING_BTN							=	By.id("Continue Editing");
		public By SETTING_SCREEN_POP_UP_UNDO_CHANGES_BTN								=	By.id("Undo Changes");
		
		
		
		//###########################################################################################################################
		//################################LOCATOR OF ELEMENTS TOP OF MIND SCREEN#####################################################
		//###########################################################################################################################
				
		public By TOP_OF_MIND_SCREEN_CONVERSATION_LIST_TXT							=	By.id("timeStamp");
		
		//ServiceDiscoverySettings
		
		public By MAIN_SCREEN_SERVICE_SETTING_BUTTON							=	By.id("ServiceDiscoverySettings");
		public By MAIN_SCREEN_URL_TXT											=	By.xpath("//XCUIElementTypeTextField");
		public By MAIN_SCREEN_NEXT_BTN											=	By.id("NEXT");
		
		public By LOGIN_BTN_SIGNIN    = By.id("SIGN IN");
		public By MEETING_SIGN_IN_BTN = By.id("Sign In");
		//public By BTN_SIGNOUT     = By.name("SIGN OUT");
		public By BTN_SIGNOUT	  = By.id("Sign Out");
		
		
		//###########################################################################################################################
		//########################################LOCATOR OF ELEMENTS IN CONTACT SCREEN##############################################
		//###########################################################################################################################
		
		public By CONTACT_SCREEN_SEARCH_TXT														=	By.id("find someone");
		public By contactDetailScreenFileNameLocator(String filename)			
		{	return By.xpath("//XCUIElementTypeStaticText[contains(@name,'" +filename+ "')]");}
		public By CONTACT_SCREEN_CONTACT_DETAIL_AMMMSG_BTN										=	By.xpath("//XCUIElementTypeCell[contains(@name,'contactEndPointMessagingCell')]/XCUIElementTypeButton[contains(@name,'primaryEndpointActionButton')]");
		public By contactDetailsAMMmsgBtnNameConversationLocator(String nameconversation)			
		{	return By.xpath("//XCUIElementTypeButton[contains(@name,'" +nameconversation+ "')]");}
		
		public By CONTACT_SCREEN_AMMMSG_BTN_START_NEW_CONVERSATiON								=	By.xpath("//XCUIElementTypeButton[contains(@name,'Start New Conversation')]");
		
		public By CONTACT_SCREEN_LIST_CONTACT_CALLVIDEO_BTN										=	By.xpath("//XCUIElementTypeCell[contains(@name,'contactEndPointPhoneCell')]/XCUIElementTypeButton[contains(@name,'primaryEndpointActionButton')]");
		public By CONTACT_SCREEN_LIST_CONTACT_CALLVOICE_BTN										=	By.xpath("//XCUIElementTypeCell[contains(@name,'contactEndPointPhoneCell')]/XCUIElementTypeButton[contains(@name,'secondaryEndpointActionButton')]");
		public By CONTACT_DETAILS_FAVORITE_BTN													=	By.xpath("//XCUIElementTypeButton[@name='Favorite']");
		public By CONTACT_DETAILS_NOTFAVORITE_BTN												=	By.xpath("//XCUIElementTypeButton[@name='NotFavorite']");
		public By CONTACT_SEARCH_CANCEL_BTN														=	By.xpath("//XCUIElementTypeButton[@name='Cancel']");
		
	    public By SEARCH_RESULT_USER_BTN(String name){
	    	return By.xpath("//XCUIElementTypeStaticText[contains(@label,'"+name+"')]");
	    	//return By.xpath("//XCUIElementTypeStaticText[@label='"+name+"']");
	    }
	    public By SEARCH_RESULT_USER_BTN_ID(String name){
	    	return By.id(name);
	    }
	    public By search_contact_enterprise_result (String name) {
	    	return By.xpath("//XCUIElementTypeStaticText[contains(@label,'"+name+"')]");
		}
	    
	    public By ADD_CONTACT_BTN = By.id("addButton");
	    public By CONTACT_DETAIL_DISMISS=By.xpath("//XCUIElementTypeButton[@name=\"Dismiss\"]");
	    public By CONTACT_DETAIL_REMOVE_CONTACT = By.id("Remove Contact");
	    public By CONTACT_DETAIL_REMOVE_CONTACT_CONFIRM = By.xpath("//XCUIElementTypeButton[contains(@label,'Remove Contact')]");
	    public By CONTACT_DETAIL_EDIT_CONTACT = By.id("Edit");
	    
	    public By EDIT_CONTACT_SCREEN_FIRSTNAME_TXT = By.id("firstNameTextField");
		public By EDIT_CONTACT_SCREEN_LASTNAME_TXT = By.id("lastNameTextField");
		public By EDIT_CONTACT_SCREEN_COMPANY_TXT = By.id("companyTextField");
		public By EDIT_CONTACT_SCREEN_DEPARTMENT_TXT = By.id("departmentTextField");
		public By EDIT_CONTACT_SCREEN_ADDRESS_TXT = By.id("companyStreetAddressTextField");
	    
	    public By ADD_CONTACT_SCREEN_DONE_BTN = By.id("Done");
		public By EDIT_CONTACT_SCREEN_TXT_FIELD_TEXT 			= By.id("companyTextField");
		
		public By PRESENCES_DETAIL_CONTACT (String status) {
			return By.id(status);
		}
	    public By EDIT_CONTACT_SCREEN_DONE_BTN 					= By.id("Done");
	    
	    public By EDIT_CONTACT_SCREEN_OLD_PHONE_TXT(String phoneNumber){
	    	return By.xpath("//XCUIElementTypeTextField[contains(@value,'"+phoneNumber+"')]");
	    }
	    
	    public By enterprise_result_by_order(String order){
			return By.xpath("//XCUIElementTypeTable[@name='unifiedSearchResultsTable']/XCUIElementTypeOther[contains(@name,'Enterprise')]/following-sibling::XCUIElementTypeCell["+order+"]/XCUIElementTypeStaticText");
		}
		
		public By SEARCH_CONTACT_ENTERPRISE_CONTACT_TITLE_BAR = By.xpath("//XCUIElementTypeTable[@name='unifiedSearchResultsTable']/XCUIElementTypeOther[contains(@name,'Enterprise')]");
		
		 //################################# ADD CONTACT LOCATOR ###############################
	    //HuyD
	    public By CONTACT_SCREEN_ADD_BTN = By.id("addChatCallConatctButton");
	    public By CONTACT_SCREEN_NEW_CONTACT_BTN = By.id("New Contact");
	    public By ADD_CONTACT_SCREEN_FIRST_NAME_TXT = By.id("firstNameTextField");
	    public By ADD_CONTACT_SCREEN_LAST_NAME_TXT = By.id("lastNameTextField");
	    public By ADD_CONTACT_SCREEN_PHONE_TXT = By.xpath("//XCUIElementTypeTextField[contains(@value,'Number')]");
	    public By ADD_CONTACT_SCREEN_ADDRESS_TXT = By.xpath("//XCUIElementTypeTextField[contains(@value,'Address')]");
	    
	    public By PRESENCES_DETAIL_BACK_BTN	=By.id("Back");

	 // ###########################################################################################################################
		// ########################################LOCATOR OF ENHANCED SEARCH
		// ###########################################################################################################################
		public By ENHANCED_SEARCH_DROP_BTN		    =	By.xpath("//XCUIElementTypeButton[@name = 'ic contacts details more']");	
		public By ENHANCED_SEARCH_NAME_TXT			= 	By.xpath("//XCUIElementTypeSearchField[@name = 'find someone']");
		public By ENHANCED_SEARCH_LOCATION_TXT		= 	By.xpath("//XCUIElementTypeSearchField[@name = 'Location']");
		public By ENHANCED_SEARCH_DEPARTMENT_TXT	= 	By.xpath("//XCUIElementTypeSearchField[@name = 'Department']");
		public By ENHANCED_SEARCH_BTN 				= 	By.xpath("//XCUIElementTypeButton[@name = 'Search']");
		public By ENHANCED_SEARCH_DONE_BTN 			= 	By.xpath("//XCUIElementTypeButton[@name = 'Done']");
		
		 // ###########################################################################################################################
		// ########################################CALL
		// ###########################################################################################################################
		public By INCOMING_CALL_CONTACT_NAME_AFTER_ACCEPT_CALL = By.id("name");
		public By INCOMING_CALL_CONTACT_NAME_BEFORE_ACCEPT_CALL (String name){
			return By.xpath("//XCUIElementTypeOther/XCUIElementTypeStaticText[contains(@value,'"+name+"')]");
		}
		
		 // ###########################################################################################################################
		// ########################################
		// ###########################################################################################################################
		public By CONVERSATION_DETAILS_SCREEN_DROP_DOWN_BTN                              = By.id("ammDropDownActionButton");
		public By CONVERSATION_DETAIL_SCREEN_ANSWER_VIDEO_BTN					=	By.id("Accept");
		public By CONVERSATION_DETAILS_SCREEN_VIDEOCALLSCREEN                   = By.id("videoView");
		public By CONVERSATION_DETAILS_SCREEN_VIDEO_CALL_END_BTN                  = By.id("endButton");
		public By CONVERSATION_DETAILS_SCREEN_MARK_AS_READ                        = By.id("Mark All as Read");
		public By CONVERSATION_DETAILS_SCREEN_MESSAGE_VIEW_IDENTIFIER                        = By.id("ammMessageViewIdentifier");
	
}

package testData;

import excel.ExcelData;

public class aadsData {
	
	
	ExcelData excelData = new ExcelData();
	ExcelData setting = new ExcelData();
	
	
	public static  String AADS_USER_TEST_PWD = "tma_12Tma";
	public static  String AADS_USER_TEST_NAME = "hiep000@aam1.com";
	
	
	public String lab = excelData.getTestSetting("Setting", 1, 1);
	public String user1 = excelData.getTestSetting("Setting", 2, 1);
	public String user2 = excelData.getTestSetting("Setting", 3, 1);
	public String user3 = excelData.getTestSetting("Setting", 4, 1);
	
	public String AADS_ADMIN_ROLE_USER = "huydao@aam1.com";
	public String AADS_USER_PWD = "tma_12Tma";
	
//################################ AADS USERS ###############################################################
	
	public String AADS_USER_1_NAME = excelData.getLabInfo(user1, 5, 1);
	public String AADS_USER_1_NAME_SIP_PHONE = excelData.getLabInfo(user1, 6, 1);
	public String AADS_ADD_CONTACT_USER1_FIRST_NAME= excelData.getLabInfo(user1, 9, 1);
	public String AADS_ADD_CONTACT_USER1_LAST_NAME= excelData.getLabInfo(user1, 10, 1);
	public String AADS_ADD_CONTACT_USER1_FULL_NAME= excelData.getLabInfo(user1, 8, 1);
	public String AADS_USER_1_STANDARD_CONFIG = excelData.getLabInfo(user1, 7, 1);
	
	
	public String AADS_USER_2_NAME = excelData.getLabInfo(user2, 5, 1);
	public String AADS_USER_2_NAME_SIP_PHONE = excelData.getLabInfo(user2, 6, 1);
	public String AADS_ADD_CONTACT_USER2_FIRST_NAME= excelData.getLabInfo(user2, 9, 1);
	public String AADS_ADD_CONTACT_USER2_LAST_NAME= excelData.getLabInfo(user2, 10, 1);
	public String AADS_ADD_CONTACT_USER2_FULL_NAME= excelData.getLabInfo(user2, 8, 1);
	public String AADS_ADD_CONTACT_USER2_EMAIL = excelData.getLabInfo(user2, 5, 1);
	
	public String AADS_USER_3_NAME = excelData.getLabInfo(user3, 5, 1);
	public String AADS_USER_3_NAME_SIP_PHONE = excelData.getLabInfo(user3, 6, 1);
	public String AADS_ADD_CONTACT_USER3_FIRST_NAME= excelData.getLabInfo(user3, 9, 1);
	public String AADS_ADD_CONTACT_USER3_LAST_NAME= excelData.getLabInfo(user3, 10, 1);
	public String AADS_ADD_CONTACT_USER3_FULL_NAME= excelData.getLabInfo(user3, 8, 1);
	public String AADS_ADD_CONTACT_USER3_EMAIL = excelData.getLabInfo(user3, 5, 1);
	
	public String SECURITY_ROLE_USER = excelData.getLabInfo(user1, 3, 1);
	public String AADS_USER_NAME = excelData.getLabInfo(user1, 5, 1);
	
	
	
	
	

	public String AADS_SERVER = excelData.getLabInfo(lab, 2, 1);

//	public String AADS_SERVER = "https://aads25072.aam1.com";
//
//	public String AADS_SERVER = "https://aads.aam1.com";


	public String AADS_SERVER_ADDRESS = "https://"+ AADS_SERVER + ":8445/admin";
	public String AADS_SERVER_ADDRESS_AUTOCONFIG = "https://"+ AADS_SERVER + ":8445/acs/resources/configurations/testconfigs/hiep000";
	
	public String AADS_USER_1_GROUP = "USERS";
	

	
	public String WiniumURL(int i) {
		String Winium = excelData.getNetworkData("windows", i+1, 1)+":9999";	
		return Winium;
	}
	
	public String WinAppURL(int i) {
		String WinApp = excelData.getNetworkData("windows", i+1, 1)+":4724";	
		return WinApp;
	}
	
	
	public String SMGR_SERVER_ADDRESS = excelData.getLabInfo(lab, 4, 1);
	public String SMGR_ADMIN_USR = "admin";
	public String SMGR_ADMIN_PWD = "tma_12Tma";


	//public String SM_ADDRESS = excelData.getLabInfo(lab, 5, 1);
	//public String SIP_CONTROL_LIST = SM_ADDRESS + ":5061;transport=TLS";
	
	public String SIP_SERVER1_NAME									= excelData.getLabInfo(lab, 5, 1);
	public String SIP_SERVER1_PORT_NAME								= "5061";
	public String SIP_CONTROL_LIST									= SIP_SERVER1_NAME+":5061;transport=TLS";
	public String SIP_SERVER2_NAME									= "10.255.250.23:5060;transport=tls";

	public String SMGR_ADDR = excelData.getLabInfo(lab, 4, 1);
	public String AADS_COMMON_NAME = "aads25072.aam1.com";

	public String ALIAS = "AADSCluster";
	public String AADS_VERSION = "7.1.3.1.23";
	public String SMGRCA = "smgrca";
	public String WEBLMURL = "https://smgr25080.aam1.com:443/WebLM/LicenseServer";

	
	

	//public String AADS_ADD_CONTACT_SEARCH_BY_LAST_NAME1	= "user00";
	public String AADS_ADD_CONTACT_SEARCH_BY_LAST_NAME1	= "73911";
	//public String AADS_ADD_CONTACT_DISPLAY_IN_CONTACT_LIST_1	= "smgr user00";
	public String AADS_ADD_CONTACT_DISPLAY_IN_CONTACT_LIST_1	= "AMM 73911";
	
	public int AADS_ADD_PRIVATE_CONTACT_USER1 = 73940;
	public String AADS_VERIFY_PRIVATE_CONTACT_LIST_ON_SMGR	= "7394";

	public String SECURITY_ROLE_PWD = "tma_12Tma";


	public String AADS_USER_NAME_SIP_PHONE = "83807";

	// Constant
	public static String AADS_USER_GROUP_INPUT_5_CHARACTER = "AMMUsers"; // AD
																			// 2016

	public String AADS_EMAIL_SEARCH_CRQS = "amm83910@aam1.com";

	public String AADS_USER_PWD_INVALID = "invalidPass";
	public String AADS_USER_PWD_BLANK = "";
	public String AADS_USER_NAME_INVALID = "invalidUser";
	public String AADS_USER_NAME_BLANK = "";

	// Application Property
	public String ADMIN_HTTPSESSION_TIMEOUT = "15";
	public String APPLICATION_HTTPSESSION_TIMEOUT = "15";
	public String MAX_CONCURRENT_HTTP_SESSIONS = "200000";
	public String CONCURRENT_HTTP_SESSIONS_PER_USER = "50";

	// New enterprise directory_2016 data
	public String NEW_ENTERPRISE_DIRECTORY_TYPE = "ActiveDirectory_2016";
	public String NEW_ENTERPRISE_DIRECTORY_PRIORITY = "6";
	public String NEW_ENTERPRISE_DIRECTORY_ADRR = "10.255.253.47";
	public String NEW_ENTERPRISE_DIRECTORY_BINDDN = "adminex16";
	public String NEW_ENTERPRISE_DIRECTORY_PORT = "3268";
	public String NEW_ENTERPRISE_DIRECTORY_BIND_CREDENTIAL = "tma_12Tma";
	public String NEW_ENTERPRISE_DIRECTORY_UID = "sAMAccountName";
	public String NEW_ENTERPRISE_DIRECTORY__BASE_CONTEXT_DN = "dc=aam1,dc=com";
	public String NEW_ENTERPRISE_DIRECTORY__LAST_UPDATE_TIME_ATTRIBUTE_ID = "whenChanged";

	public String AADS_CLUSTER_NODES_CLUSTER = "10.255.250.36";
	public String AADS_CLUSTER_NODES_SINGLE = "10.255.250.72";

	public String AADS_USER_GROUP = "CN=Users,CN=Builtin,DC=aam1,DC=com";
	public String CORS_CONFIG_SPECIFIC_DOMAIN = "aam1.com";

	// public String AADS_ADMIN_ROLE_USER = excelData.getLabInfo(user, 2, 1);
	public String AADS_SECURITY_ROLE_USER = excelData.getLabInfo(user1, 3, 1);
	public String AADS_AUDITOR_ROLE_USER = excelData.getLabInfo(user1, 4, 1);




	// public String AADS_USER_2_NAME = dataExcel.getDataFromExcel(user, 8, 1);
	// public String AADS_USER_2_FULL_NAME = dataExcel.getDataFromExcel(user, 9,
	// 1);

	// public String AADS_USER_3_NAME = dataExcel.getDataFromExcel(user, 10, 1);
	// public String AADS_USER_3_FULL_NAME = dataExcel.getDataFromExcel(user,
	// 11, 1);

	public String AADS_APPCAST_FILE_NAME = "Avaya Equinox Setup 3.4.0.146.37";
	public String AADS_APPCAST_FILE_NAME_NEW = "Avaya Equinox Setup 3.4.0.146.37 new";
	public String AADS_APPCAST_VERSION = "3.4.0.146.37";

	public String AADS_GROUP_VIEW = "CN=AMMUsers,OU=Roles,OU=AMM,DC=aam1,DC=com";
	
	//################################## APPIUM SERVER FOR ANDROID CLIENT##########################
	public String APPIUM_SERVER_ANDROID = excelData.getNetworkData("android", 2, 1);
	public String APPIUM_PORT_ANDROID = excelData.getNetworkData("android", 3, 1);
	public String MOBILE_UDID_ANDROID = excelData.getNetworkData("android", 4, 1);
	
	//################################## APPIUM SERVER FOR IOS CLIENT##########################
	public String APPIUM_SERVER_iOS = excelData.getNetworkData("iOS", 2, 1);
	public String APPIUM_PORT_iOS = excelData.getNetworkData("iOS", 3, 1);
	public String MOBILE_UDID_iOS = excelData.getNetworkData("iOS", 4, 1);
	
}

package scripts.EnhancedSearch;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import excel.ExcelData;
import excel.Constant;
import io.appium.java_client.android.AndroidDriver;
import libs.clients.AADSWebKeywords;
import libs.clients.AndroidClientKeywords;
import libs.clients.AndroidClientLocators;
import libs.common.DriverManagement;
import libs.listener.ExtentManager;
import testData.aadsData;


public class ENHSEA_ACA {

		
			static AndroidDriver<?> androidClientDriver;
			static WebDriver webDriver;
			static DriverManagement driverMgt = new DriverManagement();
			AndroidClientKeywords androidClient = new AndroidClientKeywords();
			AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
			AndroidClientLocators androidLocator = new AndroidClientLocators();
			aadsData aadsData = new aadsData();
			final static Logger logger = LogManager.getLogger("ACA Performance");
			ExtentHtmlReporter htmlReporter;
			static ExtentReports reports;
			ExtentTest Cresult;
			ExtentTest Sresult;
		

			@Before
			public void setUp() throws Exception {
				logger.info("beforeTest_AddContact starting...\n");
				reports = ExtentManager.GetExtent();
				webDriver = driverMgt.createChromeDriver();
				webDriver.manage().window().maximize();
				androidClientDriver = driverMgt.createAndroidClientDriver();
				logger.info("beforeTest_AddContact completed...\n");
				
			}
		
			@Test
			public void test() {
				logger.info("testAddContact - Starting\n");
				Sresult = reports.createTest("[ACA] ACS-Enhance Search User startwith", "Search user when AADS server enhance search choosing STARTWITH option ");
				Cresult = reports.createTest("[ACA] ACS-Enhance Search User contains", "Search user when AADS server enhance search choosing CONTAINS option");
				try {
					
					//Login web and set EnhanceSearchOption startsWith
					webDriver.get(aadsData.AADS_SERVER_ADDRESS);	
					AADSWebDriver.loginAADSMainPage(webDriver, aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
					AADSWebDriver.configurationEnhanceSearch(webDriver, "startsWith");
					
					//AutoConfig Login android and Open Enhance Search
					//androidClient.autoConfigLogin(androidClientDriver, aadsData.AADS_SERVER_ADDRESS_AUTOCONFIG, aadsData.AADS_USER_TEST_NAME, aadsData.AADS_USER_TEST_PWD);
					androidClient.relogin(androidClientDriver);
					androidClient.openEnhanceSearch(androidClientDriver);
		
					//test StartsWith EnhanceSearch
					for (int i=1;i>=1;i++) {
						String TCname = ExcelData.getTextUser(Constant.PATH_ENHANCE_SEARCH_DATA, "Startwith", i, 0);
						String name=ExcelData.getTextUser(Constant.PATH_ENHANCE_SEARCH_DATA, "Startwith", i, 1);
						System.out.println(name);
						String location=ExcelData.getTextUser(Constant.PATH_ENHANCE_SEARCH_DATA, "Startwith", i, 2);
						System.out.println(location);
						String department=ExcelData.getTextUser(Constant.PATH_ENHANCE_SEARCH_DATA, "Startwith", i, 3);
						System.out.println(department);
						String userName = ExcelData.getTextUser(Constant.PATH_ENHANCE_SEARCH_DATA, "Startwith", i, 4);
						System.out.println(userName);
						if(name.isEmpty()&&location.isEmpty()&&department.isEmpty()) {
							androidClient.clickDoneEnhanceSearch(androidClientDriver);
							break;
						}
						Sresult.log(Status.INFO,"TCs for " + TCname);
						boolean s = androidClient.verifyEnhancedSearchContact(androidClientDriver, name,location,department,userName);
						if(s) {System.out.println("Search name, location, department as follows: " +name+" "+location+" "+department+ " - PASSED...");
						Sresult.log(Status.PASS, "Search name, location, department as follows: " +name+", "+location+", "+department+ " - PASSED...");
						}
						else {
							System.out.println("Search name, location, department as follows: " +name+" "+location+" "+department+ " - FAILED...");
							Sresult.log(Status.FAIL, "Search name, location, department as follows: " +name+", "+location+", "+department+ " - FAILED...");
							continue;
						}
					}Thread.sleep(10000);
					
					//Login web and set EnhanceSearchOption Contains
					webDriver = driverMgt.createFFDriver();
					webDriver.manage().window().maximize();
					webDriver.get(aadsData.AADS_SERVER_ADDRESS);	
					AADSWebDriver.loginAADSMainPage(webDriver, aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
					AADSWebDriver.configurationEnhanceSearch(webDriver, "constains");
					
					//android login again and open EnhanceSearch
					androidClient.relogin(androidClientDriver);
					androidClient.openEnhanceSearch(androidClientDriver);
					
					//Test Contains EnhanceSearch
					for (int i=1;i>=1;i++) {
						String TCname = ExcelData.getTextUser(Constant.PATH_ENHANCE_SEARCH_DATA, "Contains", i, 0);
						String name=ExcelData.getTextUser(Constant.PATH_ENHANCE_SEARCH_DATA, "Contains", i, 1);
						System.out.println(name);
						String location=ExcelData.getTextUser(Constant.PATH_ENHANCE_SEARCH_DATA, "Contains", i, 2);
						System.out.println(location);
						String department=ExcelData.getTextUser(Constant.PATH_ENHANCE_SEARCH_DATA, "Contains", i, 3);
						System.out.println(department);
						String userName = ExcelData.getTextUser(Constant.PATH_ENHANCE_SEARCH_DATA, "Contains", i, 4);
						System.out.println(userName);
						if(name.isEmpty()&&location.isEmpty()&&department.isEmpty()) {
							androidClient.clickDoneEnhanceSearch(androidClientDriver);
							break;
						}
						Cresult.log(Status.INFO,"TCs for " + TCname);
						boolean s = androidClient.verifyEnhancedSearchContact(androidClientDriver, name,location,department,userName);
						if(s) {System.out.println("Search name, location, department as follows: " +name+" "+location+" "+department+ " - PASSED...");
						Cresult.log(Status.PASS, "Search name, location, department as follows: " +name+", "+location+", "+department+ " - PASSED...");
						}
						else {
							System.out.println("Search name, location, department as follows: " +name+" "+location+" "+department+ " - FAILED...");
							Cresult.log(Status.FAIL, "Search name, location, department as follows: " +name+", "+location+", "+department+ " - FAILED...");
							continue;
						}
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
			@After
			public void tearDown() throws Exception {
				logger.info("tearDown starting...\n");
				reports.flush();
				webDriver.quit();
				logger.info("tearDown completed...\n");
			}
		
}

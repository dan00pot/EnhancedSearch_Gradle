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
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import libs.clients.AADSWebKeywords;
import libs.clients.AndroidClientKeywords;
import libs.clients.AndroidClientLocators;
import libs.clients.IOSClientKeywords;
import libs.clients.IOSClientLocators;
import libs.common.DriverManagement;
import libs.common.Selenium;
import libs.listener.ExtentManager;
import testData.aadsData;
public class ENHSEA_ACI {
	static IOSDriver<?> iOSClientDriver;
	static WebDriver webDriver;
	static DriverManagement driverMgt = new DriverManagement();
	
	IOSClientKeywords iOSClient = new IOSClientKeywords();
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	IOSClientLocators iOSLocator = new IOSClientLocators();
	Selenium selenium = new Selenium();

	aadsData aadsData = new aadsData();

	final static Logger logger = LogManager.getLogger("ACA Performance");
	String linkExcel = "C:\\AADS\\AADS_Configuration\\FullcaseACS-6589.xlsx" ;
	String sheetName = "Startwith" ;
	
	ExtentHtmlReporter htmlReporter;
	static ExtentReports reports;
	ExtentTest Cresult;
	ExtentTest Sresult;

	@Before
	public void setUp() throws Exception {
		logger.info("beforeTest_AddContact starting...\n");
		reports = ExtentManager.GetExtent();
		webDriver = driverMgt.createFFDriver();
		webDriver.manage().window().maximize();
		iOSClientDriver = driverMgt.createIOSClientDriver();
		logger.info("beforeTest_AddContact completed...\n");
	}

	@Test
	public void test() {
		logger.info("testAddContact - Starting\n");
		Sresult = reports.createTest("[ACI] ACS-Enhance Search User startwith", "Search user when AADS server enhance search choosing STARTWITH option ");
		Cresult = reports.createTest("[ACI] ACS-Enhance Search User contains", "Search user when AADS server enhance search choosing CONTAINS option");
			
		try {
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);	
			AADSWebDriver.loginAADSMainPage(webDriver, aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Client Administration");
			Thread.sleep(1000);
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Enhanced Search Configuration");
			Thread.sleep(2000);
			AADSWebDriver.selectEnhancedSearchOption(webDriver, "startsWith");
			Thread.sleep(3000);
			webDriver.close();
			Thread.sleep(3000);
			
			iOSClient.signout(iOSClientDriver);
			Thread.sleep(1000);
			iOSClient.signin(iOSClientDriver);
			Thread.sleep(5000);
			selenium.clickElement(iOSClientDriver, iOSLocator.CONTACT_SCREEN_SEARCH_TXT);
			Thread.sleep(2000);
			iOSClient.clickDropDownEnhanceSearch(iOSClientDriver);
			Thread.sleep(2000);
			
			for (int i=1;i>=1;i++) {
				String TCname = ExcelData.getTextUser(linkExcel, sheetName, i, 0);
				String name=ExcelData.getTextUser(linkExcel, sheetName, i, 1);
				System.out.println(name);
				String location=ExcelData.getTextUser(linkExcel, sheetName, i, 2);
				System.out.println(location);
				String department=ExcelData.getTextUser(linkExcel, sheetName, i, 3);
				System.out.println(department);
				String userName = ExcelData.getTextUser(linkExcel, sheetName, i, 4);
				System.out.println(userName);
				if(name.isEmpty()&&location.isEmpty()&&department.isEmpty()) {
					iOSClient.clickDoneEnhanceSearch(iOSClientDriver);
					break;
				}
				Sresult.log(Status.INFO,"TCs for " + TCname);
				boolean s = iOSClient.verifyEnhancedSearchContact(iOSClientDriver, name,location,department,userName);
				if(s) {System.out.println("Search name, location, department as follows: " +name+" "+location+" "+department+ " - PASSED...");
				Sresult.log(Status.PASS, "Search name, location, department as follows: " +name+", "+location+", "+department+ " - PASSED...");
				}
				else {
					System.out.println("Search name, location, department as follows: " +name+" "+location+" "+department+ " - FAILED...");
					Sresult.log(Status.FAIL, "Search name, location, department as follows: " +name+", "+location+", "+department+ " - FAILED...");
					continue;
				}
			}
			
			Thread.sleep(10000);
			
			sheetName = "Contains";
			
			webDriver = driverMgt.createFFDriver();
			webDriver.manage().window().maximize();
			
			webDriver.get(aadsData.AADS_SERVER_ADDRESS);	
			AADSWebDriver.loginAADSMainPage(webDriver, aadsData.AADS_ADMIN_ROLE_USER, aadsData.AADS_USER_PWD);
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Client Administration");
			Thread.sleep(1000);
			AADSWebDriver.navigateToFeaturesPage(webDriver, "Enhanced Search Configuration");
			Thread.sleep(2000);
			AADSWebDriver.selectEnhancedSearchOption(webDriver, "contains");
			Thread.sleep(3000);
			webDriver.close();
			Thread.sleep(3000);
			
			iOSClient.signout(iOSClientDriver);
			Thread.sleep(1000);
			iOSClient.signin(iOSClientDriver);
			Thread.sleep(5000);
			selenium.clickElement(iOSClientDriver, iOSLocator.CONTACT_SCREEN_SEARCH_TXT);
			Thread.sleep(2000);
			iOSClient.clickDropDownEnhanceSearch(iOSClientDriver);
			Thread.sleep(2000);
			
			for (int i=1;i>=1;i++) {
				String TCname = ExcelData.getTextUser(linkExcel, sheetName, i, 0);
				String name=ExcelData.getTextUser(linkExcel, sheetName, i, 1);
				System.out.println(name);
				String location=ExcelData.getTextUser(linkExcel, sheetName, i, 2);
				System.out.println(location);
				String department=ExcelData.getTextUser(linkExcel, sheetName, i, 3);
				System.out.println(department);
				String userName = ExcelData.getTextUser(linkExcel, sheetName, i, 4);
				System.out.println(userName);
				if(name.isEmpty()&&location.isEmpty()&&department.isEmpty()) {
					iOSClient.clickDoneEnhanceSearch(iOSClientDriver);
					break;
				}
				Cresult.log(Status.INFO,"TCs for " + TCname);
				boolean s = iOSClient.verifyEnhancedSearchContact(iOSClientDriver, name,location,department,userName);
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
			// TODO Auto-generated catch block
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

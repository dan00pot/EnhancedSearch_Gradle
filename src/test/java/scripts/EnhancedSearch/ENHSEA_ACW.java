package scripts.EnhancedSearch;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.winium.WiniumDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import excel.Constant;
import excel.ExcelData;
import io.appium.java_client.windows.WindowsDriver;
import libs.clients.AADSWebKeywords;
import libs.clients.WindowsClientKeywords;
import libs.common.DriverManagement;
import libs.listener.ExtentManager;
import testData.aadsData;

public class ENHSEA_ACW {
	WindowsClientKeywords winClient = new WindowsClientKeywords();
	AADSWebKeywords AADSWebDriver = new AADSWebKeywords();
	
	static WebDriver webDriver;
	static DriverManagement driverMgt = new DriverManagement();
	static WiniumDriver winClientDriver;
	static WindowsDriver<?> windowsDriver;
	static WindowsDriver<?> windowsDriverRoot;
	aadsData aadsData = new aadsData();
	
//	String Winium_URL1 = aadsData.WiniumURL(1);
//	String WinApp_URL1 = aadsData.WinAppURL(1);

	final static Logger logger = LogManager.getLogger("AddContact");
	String configurationName = "configuration1";
	int numberOfContact = 3;
	String linkExcel = "C:\\AADS\\AADS_Configuration\\FullcaseACS-6589.xlsx" ;
	String sheetName = "Startwith" ;
	
	ExtentHtmlReporter htmlReporter;
	static ExtentReports reports;
	ExtentTest Cresult;
	ExtentTest Sresult;

	@Before
	public void setUp() throws Exception {
		logger.info("beforeTest_SearchlocalContact...\n");
		reports = ExtentManager.GetExtent();
		//winClientDriver = driverMgt.createWindowsClientDriver("http://10.255.251.25:9999");
		windowsDriverRoot = driverMgt.createWinAppDriver("http://10.255.251.25:4724");
		webDriver = driverMgt.createFFDriver();
		webDriver.manage().window().maximize();
		//winClient.confirmOpenApp(windowsDriverRoot);
		logger.info("beforeTest_SearchlocalContact completed...\n");	
	}

	@Test
	public void test() {
		logger.info("testAddContact - Starting\n");
		Sresult = reports.createTest("[ACW] ACS-Enhance Search User startwith", "Search user when AADS server enhance search choosing STARTWITH option ");
		Cresult = reports.createTest("[ACW] ACS-Enhance Search User contains", "Search user when AADS server enhance search choosing CONTAINS option");
			
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
			
			winClient.signout(windowsDriverRoot);
			Thread.sleep(1000);
			winClient.signin(windowsDriverRoot);
			Thread.sleep(5000);
			winClient.clickDropDownEnhanceSearch(windowsDriverRoot);
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
					winClient.clickCancelSearch(windowsDriverRoot);
					break;
				}
				Sresult.log(Status.INFO,"TCs for " + TCname);
				boolean s = winClient.verifyEnhancedSearchContact(windowsDriverRoot, name,location,department,userName);
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
			
			winClient.signout(windowsDriverRoot);
			Thread.sleep(1000);
			winClient.signin(windowsDriverRoot);
			Thread.sleep(5000);
			winClient.clickDropDownEnhanceSearch(windowsDriverRoot);
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
					winClient.clickCancelSearch(windowsDriverRoot);
					break;
				}
				Cresult.log(Status.INFO,"TCs for " + TCname);
				boolean s = winClient.verifyEnhancedSearchContact(windowsDriverRoot, name,location,department,userName);
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


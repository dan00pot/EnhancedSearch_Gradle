package libs.common;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import testData.aadsData;

//import io.appium.java_client.windows.WindowsDriver;

import org.apache.logging.log4j.Logger;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.http.W3CHttpCommandCodec;
import org.openqa.selenium.remote.http.W3CHttpResponseCodec;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import excel.ExcelData;



public class DriverManagement {

	public WebDriver webDriver;
	public RemoteWebDriver RemotewebDriver;
	public AndroidDriver androidClientDriver;
	static WiniumDriver winClientDriver;
	static WindowsDriver windowsClientDriver; 
	static IOSDriver iOSClientDriver;
	static WebDriver failedWinClientDriver;
	aadsData aadsData = new aadsData();
	
	static Logger logger = LogManager.getLogger("Driver Managerment");
	

	/**
	 * @return
	 * @throws Exception
	 */

	public WebDriver createFFDriver() throws Exception {
		try {
			System.setProperty("wdm.proxy", "http://10.10.10.10:8080");
			System.setProperty("wdm.proxy", "https://10.10.10.10:8080"); 
			WebDriverManager.firefoxdriver().setup();
			DesiredCapabilities capabilities = new DesiredCapabilities();
			FirefoxProfile profile = new FirefoxProfile();
			capabilities.setCapability(FirefoxDriver.PROFILE, profile);
			capabilities.setCapability("acceptInsecureCerts", true);
			profile.setPreference("browser.tabs.remote.autostart.2", false);
			FirefoxOptions ffoption = new FirefoxOptions(capabilities);
		//	ffoption.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			ffoption.setCapability("marionette", true);
			webDriver = new FirefoxDriver(ffoption);
		} catch (Exception e) {
			throw new Exception("createWebDriver - Failed - Exception occurs: "
					+ e);
		}
		return webDriver;
	}
	

	public WebDriver createChromeDriver() throws Exception {
		try {
			logger.info("createWebDriverChrome - starting...\n");
			System.out.println("launching Chorme browser");
			System.setProperty("webdriver.chrome.driver","C:\\Automation\\WebDriver\\ChromeDriver\\chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("disable-infobars");
			chromeOptions.addArguments("start-maximized");
			chromeOptions.addArguments("--use-fake-ui-for-media-stream");
	//		chromeOptions.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability("chrome.switches",
					Arrays.asList("--ignore-certificate-errors"));
			capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,
					true);
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			webDriver = new ChromeDriver(chromeOptions);
			// webDriver = new ChromeDriver();
			logger.info("createWebDriverChrome - completed...\n");
		} catch (Exception exception) {
			logger.error("createWebDriverChrome - Failed with Exception: "
					+ exception + "...\n");
			throw new Exception(
					"createWebDriverChrome - Failed - Exception occurs: "
							+ exception);
		}
		return webDriver;
	}

	public WebDriver createIEDriver() throws Exception {
		try {
			logger.info("createWebDriverIE - starting...\n");
			System.out.println("launching IE browser");
			System.setProperty("webdriver.ie.driver","C:\\AADS\\AADS_Driver\\IEDriverServer.exe");
			InternetExplorerOptions ieOption = new InternetExplorerOptions();
			DesiredCapabilities capabilities = DesiredCapabilities
					.internetExplorer();
			capabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			InternetExplorerOptions ieOptions = new InternetExplorerOptions(
					capabilities);
			webDriver = new InternetExplorerDriver(ieOptions);
			logger.info("createWebDriverIE - completed...\n");
		} catch (Exception exception) {
			logger.error("createWebDriverIE - Failed with Exception: "
					+ exception + "...\n");
			throw new Exception(
					"createWebDriverIE - Failed - Exception occurs: "
							+ exception);
		}
		return webDriver;
	}

	public AndroidDriver createAndroidClientDriver() throws Exception {
		try {
			String appiumServer ="10.255.251.27";
			String appiumPort = "4723";
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("noReset", true);
			capabilities.setCapability("automationName", "uiautomator1");
			capabilities.setCapability("deviceName", "Galaxy J7 Prime");
			capabilities.setCapability("platformName", "ANDROID");
			capabilities.setCapability("platformVersion", "7.0");
			capabilities.setCapability("udid", "3300c15529937303");
			capabilities.setCapability("appPackage", "com.avaya.android.flare");
			capabilities.setCapability("appActivity","com.avaya.android.flare.MainActivity");
			capabilities.setCapability("newCommandTimeout", 300000);
			// disable the soft keyboard
			// capabilities.setCapability("unicodeKeyboard", true);
			// capabilities.setCapability("resetKeyboard", true);
			String url = "http://" + appiumServer + ":" + appiumPort
					+ "/wd/hub";
			androidClientDriver = new AndroidDriver(new URL(url), capabilities);
		} catch (Exception exception) {
			throw new Exception(
					"createAndroidClientDriver - Failed - Exception occurs: "
							+ exception);
		}
		return androidClientDriver;
	}
	
	public WiniumDriver createWindowsClientDriver(String winiumURL) throws Exception{	
		WiniumDriver tempDriver = null;
		try {
			try {
				DesktopOptions options = new DesktopOptions();
				options.setApplicationPath("C:\\Program Files (x86)\\Avaya\\Avaya Equinox\\Avaya Equinox.exe");
				winClientDriver = new WiniumDriver(new URL(winiumURL), options);
				tempDriver = winClientDriver;
			} catch (Exception e) {
				DesktopOptions options = new DesktopOptions();
				options.setApplicationPath("C:\\Program Files (x86)\\Avaya\\Avaya Equinox\\Avaya Equinox.exe");
				winClientDriver = new WiniumDriver(new URL(winiumURL), options);
				tempDriver = winClientDriver;
				// TODO: handle exception
			}
			Thread.sleep(15000);
			logger.info("createWindowsClientDriver - completed...\n");
		} catch (Exception exception) {
			logger.error("createWindowsClientDriver - Failed with Exception: " + exception + "...\n");
			throw new Exception("createWindowsClientDriver - Failed - Exception occurs: " + exception);
		}
		return tempDriver;
    }
	
	public WindowsDriver createWinAppDriver(String winiumURL) throws Exception{	
		WindowsDriver tempDriver = null;
		try {
			try {
	            DesiredCapabilities capabilities = new DesiredCapabilities();
	            capabilities.setCapability("app", "Root");
	            windowsClientDriver = new WindowsDriver(new URL(winiumURL), capabilities);
	            windowsClientDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			} catch (Exception e) {
				logger.info("createWindowsAppDriver - Failed...\n");
				// TODO: handle exception
			}
			Thread.sleep(15000);
			logger.info("createWindowsAppDriver - completed...\n");
		} catch (Exception exception) {
			logger.error("createWindowsAppDriver - Failed with Exception: " + exception + "...\n");
			throw new Exception("createWindowsAppDriver - Failed - Exception occurs: " + exception);
		}
		return windowsClientDriver;
    }
	

	public IOSDriver createIOSClientDriver() throws Exception{
		try { 
			logger.info("createIOSClientDriver - starting...\n");
			String appiumServer 		= 	aadsData.APPIUM_SERVER_iOS;
			String appiumPort 			= 	aadsData.APPIUM_PORT_iOS;		
			DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
	        capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.8.2");
	        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "IPad 2018");
	        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "/Users/Msg/Desktop/xcodeConfig.xcconfig"); 
	        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
	        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"1800");
	        capabilities.setCapability("appWaitActivity", "1800");
	        capabilities.setCapability("simpleIsVisibleCheck", true);
	        capabilities.setCapability("appWaitPackage", "1800");
	        capabilities.setCapability("preventWDAAttachments", true);
	        capabilities.setCapability("xcodeConfigFile","/Users/Msg/Desktop/xcodeConfig.xcconfig");
	        capabilities.setCapability("newCommandTimeout", 180000);
	        capabilities.setCapability(MobileCapabilityType.UDID,aadsData.MOBILE_UDID_iOS );
	        capabilities.setCapability("bundleId", "com.avaya.internal.Equinox"); 
	        capabilities.setCapability("noReset", true);
//	        capabilities.setCapability(MobileCapabilityType.APP, "/Users/macbookpro/Downloads/TestApp.ipa");
	        String url = "http://" + appiumServer + ":" + appiumPort + "/wd/hub";
	        logger.info("capabilities_IOS are: " + capabilities + "\n" + "url is: " + url + "\n");
	        iOSClientDriver = new IOSDriver<>(new URL(url), capabilities);
	        Thread.sleep(10000);
			logger.info("createIOSClientDriver - completed...\n");
		} catch (Exception exception) {
			logger.error("createIOSClientDriver - Failed with Exception: " + exception + "...\n");
			throw new Exception("createIOSClientDriver - Failed - Exception occurs: " + exception);
		}
		return iOSClientDriver;
    }
	
	public void setFailedWinClientDriver(WebDriver driver) throws Exception {
		logger.info("setFailedWinClientDriver is: " + driver + "...\n");
		failedWinClientDriver = driver;
	}
	
	
	public WebDriver getWebDriver() throws Exception {
		WebDriver WebDriver;
		logger.info("webDriver is: " + webDriver);
		if (webDriver == null) {
			WebDriver = createFFDriver();
		}
		return this.webDriver;
	}
	
	public static RemoteWebDriver createDriverFromSession() throws Exception{
		String command_executor = ExcelData.getSessionInfo(0);
		final String sessionId = ExcelData.getSessionInfo(1);
		URL command_executorURL = new URL(command_executor);
	    CommandExecutor executor = new HttpCommandExecutor(command_executorURL) {
	    	
	    @Override
	    public Response execute(Command command) throws IOException {
	        Response response = null;
	        if (command.getName() == "newSession") {
	            response = new Response();
	            response.setSessionId(sessionId);
	            response.setStatus(0);
	            response.setValue(Collections.<String, String>emptyMap());

	            try {
	                Field commandCodec = null;
	                commandCodec = this.getClass().getSuperclass().getDeclaredField("commandCodec");
	                commandCodec.setAccessible(true);
	                commandCodec.set(this, new W3CHttpCommandCodec());
	                System.out.println("abc ahaha");
	                
	                Field responseCodec = null;
	                responseCodec = this.getClass().getSuperclass().getDeclaredField("responseCodec");
	                responseCodec.setAccessible(true);
	                responseCodec.set(this, new W3CHttpResponseCodec());
	            } catch (NoSuchFieldException e) {
	                e.printStackTrace();
	            } catch (IllegalAccessException e) {
	                e.printStackTrace();
	            }

	        } else {
	            response = super.execute(command);
	        }
	        return response;
	    }
	    };

	    return new RemoteWebDriver(executor, new DesiredCapabilities());
	}
}

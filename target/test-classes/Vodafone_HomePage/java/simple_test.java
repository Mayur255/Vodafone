import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class simple_test {
	
	static AppiumDriver<MobileElement> driver;


	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub

/*		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("diviceName", "Samsung A50");
		cap.setCapability("udid", "RZ8M73GM83W");
		cap.setCapability("platformnName", "Android");
		cap.setCapability("platformVersion", "9");
		
		cap.setCapability("appPackage", "com.mventus.selfcare.activity");
		cap.setCapability("appActivity", "com.mventus.selfcare.activity.MainActivity ");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver=new AppiumDriver<MobileElement>(url,cap);
	
		System.out.println("==================");*/
		
		
	/*	DesiredCapabilities cap=new DesiredCapabilities();
		
		cap.setCapability("diviceName", "RedmiNote5Pro");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformnName", "Android");
		cap.setCapability("platformVersion", "9");
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver=new AppiumDriver<MobileElement>(url,cap);
	
		System.out.println("==================");*/
		System.out.println("inside android native...");
    	DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
		//capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"b28e6aea");
		//capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"RZ8M73GM83W");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		//capabilities.setCapability("app", PropertiesAndConstants.CurrentDirectory +"/Drivers/"+PropertiesAndConstants.envDictionary.get("APK_IPA_Path"));
		capabilities.setCapability(MobileCapabilityType.APP, "C:\\Vodafone apk files\\BAUR68_BASE_BUILD_21012020_1153.apk");
	//	capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "520");
        //capabilities.setCapability("browserName", "");
        //capabilities.setCapability("noReset", "true");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
        //capabilities.setCapability("deviceReadyTimeout", "300");
        capabilities.setCapability("appWaitActivity", "com.mventus.selfcare.activity.MainActivity");
        capabilities.setCapability("appWaitDuration", "15000");	            	        
	    System.out.println("Please wait:- Connecting to Mobile...");
	//    PropertiesAndConstants.Appium = new AppiumDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
     //   PropertiesAndConstants.Selenium = PropertiesAndConstants.Appium;
	    
	    URL url = new URL("http://127.0.0.1:4723/wd/hub");
	    System.out.println("=========");
		driver=new AppiumDriver<MobileElement>(url,capabilities);
	
		
		
		
		
	}
		
	
 
	public static void openApp() throws MalformedURLException
	{

		
	}
}

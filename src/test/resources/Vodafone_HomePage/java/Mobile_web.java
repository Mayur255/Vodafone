import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Mobile_web {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", "RZ8M73GM83W"); //Give Device ID of your mobile phone
	//	caps.setCapability("udid", "d11ade7c0703");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "9.0");
		caps.setCapability("browserName", "Chrome");
	//	caps.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
	//	caps.setCapability(MobileCapabilityType.BROWSER_NAME, "org.mozilla.fennec");
	//		caps.setCapability("noReset", true);
		
		//Set ChromeDriver location
	/*	String path = System.getProperty("user.dir") + "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		*/
	//		System.setProperty("webdriver.chrome.driver","C:\\Users\\MayurDugad\\Downloads\\Note 4 Chrome_driver\\chromedriver_win32\\chromedriver.exe");

		
		//Instantiate Appium Driver
	//	AppiumDriver<MobileElement> driver = null;
		
		AppiumDriver<MobileElement> driver=null;
		
		try {
			
			System.out.println("@@@@@@@@@@@@@");
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			
		} catch (MalformedURLException e) {
			System.out.println("&&&&&&&&&&"+e.getMessage());
		}
				
		//Open URL in Chrome Browser
		driver.get("http://www.vodafone.in");
		

	
		
		/*DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", "RZ8M73GM83W"); //Give Device ID of your mobile phone
	//	caps.setCapability("udid", "d11ade7c0703");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "9.0");
		caps.setCapability("browserName", "Chrome");
		
		AppiumDriver<MobileElement> driver=null;
		
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		driver.get("www.google.com");
		*/
		
		
		
	}	

}

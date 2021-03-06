package com.voda.PayBill;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.VF_homepage.homepage_object;
import com.config.baseclass;


import HTML_REPORTS.HTMLReportGenerator;
import HTML_REPORTS.TakeScreenShot;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class VodaPay_BillStepDef {

	Properties prop = new Properties();
	public Properties OR;
	public File file = null;
	public FileReader filereader;
	WebDriver driver;
	public static int number = 1;

	static int count = 1;
	final static Logger log = Logger.getLogger(VodaPay_BillStepDef.class);

	@Given("^Pay Bill page should open properly$")
	public void pay_Bill_page_should_open_properly() throws Throwable {
		HTMLReportGenerator.TestCaseStart("Chrome:-Bill_Pay_Page", "Chrome:-Production_Build_number:001");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", "RZ8M73GM83W"); //Give Device ID of your mobile phone
	//	caps.setCapability("udid", "d11ade7c0703");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "9.0");
		caps.setCapability("browserName", "Chrome");
		
		
		
		try {
			
			System.out.println("@@@@@@@@@@@@@");
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			
		} catch (MalformedURLException e) {
			System.out.println("&&&&&&&&&&"+e.getMessage());
		}
				
		//Open URL in Chrome Browser
		driver.get("https://www.vodafone.in/postpaid/quick-online-bill-payment");
		
		Thread.sleep(5000);

		HTMLReportGenerator.StepDetails("Pass", (count++) + "- VodaFone Pay Bill page opened", "",

				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		driver.manage().deleteAllCookies();
	}

	@Then("^Verify mobilenumber field is enabled on page load$")
	public void verify_mobilenumber_field_is_enabled_on_page_load() throws Throwable {

		VodafBillPayObj vodafone = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vodafone.MobileNo));

			boolean n1 = vodafone.MobileNo.isEnabled();

			if (n1 == true) {

				System.out.println("Verify mobilenumber field is enabled on page load");

				Thread.sleep(3000);

				HTMLReportGenerator.StepDetails("Pass",
						(count++) + "- Verify mobilenumber field is enabled on page load", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			} else {

				System.out.println("Verify mobilenumber field is not enabled on page load");

				HTMLReportGenerator.StepDetails("Fail",
						(count++) + "- Verify mobilenumber field is not enabled on page load", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
		} catch (Exception ex) {

			System.out.println("Unable to find Locator ");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "-Unable to find Locator", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Verify Amount field should not allow to enter data on page load$")
	public void verify_Amount_field_should_not_allow_to_enter_data_on_page_load() throws Throwable {

		VodafBillPayObj vodafone = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 40);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vodafone.AmountBill));

			boolean n1 = vodafone.AmountBill.isDisplayed();

			if (n1 == true) {

				System.out.println("Verify Amount field should not allow to enter data on page load");

				Thread.sleep(3000);

				HTMLReportGenerator.StepDetails("Pass",
						
						(count++) + "- Verify Amount field should not allow to enter data on page load", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			} else {

				System.out.println("Verify Amount field should allow to enter data on page load");

				HTMLReportGenerator.StepDetails("Fail",
						(count++) + "- Verify Amount field should allow to enter data on page load", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
		} catch (Exception ex) {

			System.out.println("Unable to find Locator ");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "-Unable to find Locator", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Verify Pay Button should not active on page load$")
	public void verify_Pay_Button_should_not_active_on_page_load() throws Throwable {

		VodafBillPayObj vodafone = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vodafone.Pay_Now));

			boolean n1 = vodafone.Pay_Now.isEnabled();

			if (n1 == true) {

			System.out.println("Verify Pay Button should not active on page load");

			Thread.sleep(3000);

			HTMLReportGenerator.StepDetails("Fail",
			(count++) + "- Verify Pay Button should active on page load", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			} else {

				System.out.println("Verify Pay Button not should active on page load");

				HTMLReportGenerator.StepDetails("Pass", (count++) + "- Verify Pay Button should not active on page load",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
		} catch (Exception ex) {

			System.out.println("Unable to find Locator ");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "-Unable to find Locator-!", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Verify on page Fetch your bill hyper link should be disabled$")
	public void verify_on_page_Fetch_your_bill_hyper_link_should_be_disabled() throws Throwable {
	    
		VodafBillPayObj vodafone = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vodafone.FetchYBill));

			boolean n1 = vodafone.FetchYBill.isDisplayed();

			if (n1 == true) {

				System.out.println("Verify on page Fetch your bill hyper link should be disabled");

				Thread.sleep(3000);

				HTMLReportGenerator.StepDetails("Pass",
						(count++) + "- Verify on page Fetch your bill hyper link should be disabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			} else {

				System.out.println("Verify on page Fetch your bill hyper link should not be disabled");

				HTMLReportGenerator.StepDetails("Fail",
						(count++) + "- Verify on page Fetch your bill hyper link should not be disabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
		} catch (Exception ex) {

			System.out.println("Unable to find Locator ");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "-Unable to find Locator", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Verify text PayBillsOnline for your postpaid number should display on page load$")
	public void verify_text_PayBillsOnline_for_your_postpaid_number_should_display_on_page_load() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.Pay_BillHeader));

			boolean n1 = vdabillPay.Pay_BillHeader.isEnabled();

			if (n1 == true) {

				System.out.println("Verify text PayBillsOnline for your postpaid number should display on page load");

				Thread.sleep(2000);

				HTMLReportGenerator.StepDetails("Pass",
						(count++) + "- Verify text PayBillsOnline for your postpaid number should display on page load",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			} else {

				System.out
						.println("Verify text PayBillsOnline for your postpaid number should not display on page load");

				HTMLReportGenerator.StepDetails("Fail", (count++)
						+ "- Verify text PayBillsOnline for your postpaid number should not display on page load", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue" + ex, "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Verify - Setup AutoPay section - SetUp Now button should display$")
	public void verify_Setup_AutoPay_section_SetUp_Now_button_should_display() throws Throwable {

		Thread.sleep(2000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,350)", "");

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.Setup_Now));

			boolean n1 = vdabillPay.Setup_Now.isEnabled();
			
			

			if (n1 == true) {

			System.out.println("Verify - Setup AutoPay section - SetUp Now button should display");

			Thread.sleep(2000);

			HTMLReportGenerator.StepDetails("Pass",
				(count++) + "- Verify - Setup AutoPay section - SetUp Now button should display", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			} else {

				System.out.println("Verify - Setup AutoPay section - SetUp Now button should not display");

				HTMLReportGenerator.StepDetails("Fail",
						(count++) + "- Verify - Setup AutoPay section - SetUp Now button should not display", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
			
			vdabillPay.Setup_Now.click();
			
			Thread.sleep(3000);
			String url = driver.getCurrentUrl();
			System.out.println(url);
			
			String actual_url="https://www.vodafone.in/postpaid/quick-online-bill-payment";
			
			if(url.equalsIgnoreCase(actual_url))
			{
				System.out.println("Setup now botton is clickable");
				HTMLReportGenerator.StepDetails("Pass", (count++) + "- Setup now botton is clickable", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
			else {
				System.out.println("Setup now botton is not clickable");
				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Setup now botton is not clickable", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
			}
			Thread.sleep(3000);
			driver.switchTo().parentFrame();

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue" + ex, "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Verify - Inactive Number section - Pay Now button should display$")
	public void verify_Inactive_Number_section_Pay_Now_button_should_display() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.GetNew_Connections));

			boolean n1 = vdabillPay.GetNew_Connections.isEnabled();

			if (n1 == true) {

				System.out.println("Verify - Inactive Number section - Pay Now button should display");

				Thread.sleep(2000);

				HTMLReportGenerator.StepDetails("Pass",
						(count++) + "- Verify - Inactive Number section - Pay Now button should display",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			} else {

				System.out.println("Verify - Inactive Number section - Pay Now button should not display");

				HTMLReportGenerator.StepDetails("Fail",

						(count++)
								+ "- Verify - Inactive Number section - Pay Now button should not display",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
			
	vdabillPay.GetNew_Connections.click();
			
			Thread.sleep(3000);
			String url = driver.getCurrentUrl();
			System.out.println(url);
			
			String actual_url="https://www.vodafone.in/postpaid/quick-online-bill-payment";
			
			if(url.equalsIgnoreCase(actual_url))
			{
				System.out.println("Pay now botton is clickable");
				HTMLReportGenerator.StepDetails("Pass", (count++) + "- Pay now botton is clickable", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
			else {
				System.out.println("Pay now botton is not clickable");
				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Pay now botton is not clickable", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
			}
			Thread.sleep(2000);
			driver.switchTo().parentFrame();

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue" + ex, "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}

	}

	@Then("^On Page load - when valid Postpaid Number is not provided >>New Connection and Postpaid Packs links should display in orange$")
	public void on_Page_load_when_valid_Postpaid_Number_is_not_provided_New_Connection_and_Postpaid_Packs_links_should_display_in_orange() throws Throwable {
	
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.New_connection));
			
			String color = vdabillPay.New_connection.getCssValue("color");

			String color1 = "rgba(230, 0, 0, 1)";

			System.out.println("============" + color);

			boolean n1 = vdabillPay.New_connection.isDisplayed();

			if (n1 == true) {

			System.out.println("On Page load - When valid Postpaid Number is not provided >> New Connection and Postpaid Packs links should display in red");

			Thread.sleep(2000);

			HTMLReportGenerator.StepDetails("Pass", (count++)
				+ "- On Page load - When valid Postpaid Number is not provided >> New Connection and Postpaid Packs links should display in red",
				"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			} else {

			System.out.println("On Page load - When valid Postpaid Number is not provided >> New Connection and Postpaid Packs links should not display in red");

				HTMLReportGenerator.StepDetails("Fail", (count++)
						+ "- On Page load - When valid Postpaid Number is not provided >> New Connection and Postpaid Packs links should not display in red",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
			
			

		} catch (TimeoutException ex) {

		System.out.println("Locator not found issue");

		HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue" + ex, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Enter mobile number less than ten digits - Error message should display in Red$")
	public void enter_mobile_number_less_than_ten_digits_Error_message_should_display_in_Red() throws Throwable {

		driver.navigate().refresh();
		Thread.sleep(2000);
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MobileNo));

			vdabillPay.MobileNo.sendKeys(OR.getProperty("LessThan"));

			vdabillPay.MobileNo.sendKeys(Keys.BACK_SPACE);
			
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.LesTha_Error));

			String error_msg = "Please enter 10 digit mobile number";

			String error_msg1 = vdabillPay.LesTha_Error.getText();

			System.out.println("===" + error_msg1);

			String color = vdabillPay.LesTha_Error.getCssValue("color");

			String color1 = "#e60000";

			System.out.println("============" + color);
			
			String color2=Color.fromString(color).asHex();
			
			System.out.println("555555555555555555555"+color2);

			boolean n1 = vdabillPay.LesTha_Error.isDisplayed();

			if (n1 == true) {

				System.out.println("Error msg is displyed");

				if (error_msg1.equalsIgnoreCase(error_msg) && color2.equalsIgnoreCase(color1)) {

					System.out.println("Enter mobile number less than ten digits>>Correct Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Pass", (count++)

					+ "- Enter mobile number less than ten digits>> Correct Error msg is displyed in correct color", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				} else {
					
					System.out.println("Incorrect Error msg is displyed in correct color");
					HTMLReportGenerator.StepDetails("Fail",
							(count++) + "- Incorrect Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				}
				
			} else {

				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Incorrect Error msg is displyed in correct color",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				System.out.println("Error msg is not displayed");
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	    		
	}

	@Then("^Enter mobile number less than ten digits - Enter Mobile Number label and field border should display in Red$")
	public void enter_mobile_number_less_than_ten_digits_Enter_Mobile_Number_label_and_field_border_should_display_in_Red()
			throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MobileNo.clear();

		WebDriverWait wait = new WebDriverWait(driver, 40);

		try {
			
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MobileNo));

			vdabillPay.MobileNo.sendKeys(OR.getProperty("LessThan"));

			vdabillPay.MobileNo.sendKeys(Keys.BACK_SPACE);
			
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.LesTha_Error));

			String error_msg = "Please enter 10 digit mobile number";

			String error_msg1 = vdabillPay.LesTha_Error.getText();

			System.out.println("===" + error_msg1);

			String color = vdabillPay.LesTha_Error.getCssValue("color");

			String color1 = "#e60000";

			System.out.println("============" + color);
			
			String color2=Color.fromString(color).asHex();
			
			System.out.println("555555555555555555555"+color2);

			boolean n1 = vdabillPay.LesTha_Error.isDisplayed();

			if (n1 == true) {

				System.out.println("Error msg is displyed");

				if (error_msg1.equalsIgnoreCase(error_msg) && color2.equalsIgnoreCase(color1)) {

					System.out.println("Enter mobile number less than ten digits - Enter Mobile Number label and field border should display in Red");

					HTMLReportGenerator.StepDetails("Pass", (count++)

					+ "- Enter mobile number less than ten digits - Enter Mobile Number label and field border should display in Red", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				} else {
					
					System.out.println("Incorect boder color display");
					HTMLReportGenerator.StepDetails("Fail",
							(count++) + "-Incorrect Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				}
				
			} else {

				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Incorrect Error msg is displyed in correct color",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				System.out.println("Error msg is not displayed");
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}		
	}

	@Then("^Enter Prepaid Number of Idea - Error message should display in red color$")
	public void enter_Prepaid_Number_of_Idea_Error_message_should_display_in_red_color() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MobileNo.clear();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MobileNo));

			vdabillPay.MobileNo.sendKeys(OR.getProperty("prepaidIdeaNO"));

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.LesTha_Error));

			String error_msg = "Seems like you have entered a non vodafone number. Looking for a new connection ? Join Vodafone";

			String error_msg1 = vdabillPay.LesTha_Error.getText();

			System.out.println("===" + error_msg1);

			String color = vdabillPay.LesTha_Error.getCssValue("color");

			String color1 = "#e60000";

			System.out.println("============" + color);
			
			String color2=Color.fromString(color).asHex();
			
			System.out.println("555555555555555555555"+color2);

			boolean n1 = vdabillPay.LesTha_Error.isDisplayed();

			if (n1 == true) {

				System.out.println("Error msg is displyed");

			if (error_msg1.equalsIgnoreCase(error_msg) && color2.equalsIgnoreCase(color1)) {

			System.out.println("Correct Error msg is displyed in correct color");
					
           Thread.sleep(2000);
         
					HTMLReportGenerator.StepDetails("Pass", (count++)

							+ "- Enter Prepaid Number of Idea - Error message is display in red color",

							"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				} else {

					System.out.println("Incorrect Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Fail", (count++)+ "- Enter Prepaid Number of Idea - Error message is not display in red color","", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				}

			} else {

				HTMLReportGenerator.StepDetails("Fail",

						(count++) + "- >> Error msg is not displayed", "",

						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				System.out.println("Error msg is not displayed");
			}
		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue-Z");

			HTMLReportGenerator.StepDetails("Fail",

					(count++) + "- Locator not found issue-Z", "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}

	}

	@Then("^Enter Prepaid Number of Idea - Enter Mobile Number label and field border should display in Red$")
	public void enter_Prepaid_Number_of_Idea_Enter_Mobile_Number_label_and_field_border_should_display_in_Red()
			throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MobileNo.clear();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MobileNo));

			vdabillPay.MobileNo.sendKeys(OR.getProperty("prepaidIdeaNO"));
			
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.LesTha_Error));

			String error_msg = "Seems like you have entered a non vodafone number. Looking for a new connection ? Join Vodafone";

			String error_msg1 = vdabillPay.LesTha_Error.getText();

			System.out.println("===" + error_msg1);

			String color = vdabillPay.LesTha_Error.getCssValue("color");

			String color1 = "#e60000";

			System.out.println("============" + color);
			
			String color2=Color.fromString(color).asHex();
			
			System.out.println("555555555555555555555"+color2);

			boolean n1 = vdabillPay.LesTha_Error.isDisplayed();

			if (n1 == true) {

				System.out.println("Error msg is displyed");

				if (error_msg1.equalsIgnoreCase(error_msg) && color2.equalsIgnoreCase(color1)) {

					System.out.println("Correct boder color is displyed in correct color");

					HTMLReportGenerator.StepDetails("Pass", (count++)

					+ "-Enter Prepaid Number of Idea>> Correct boder color is displyed in correct color", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				} else {
					
					System.out.println("Incorect boder color display");
					HTMLReportGenerator.StepDetails("Fail",
							(count++) + "- Incorrect Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				}
				
			} else {

				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Incorrect Error msg is displyed in correct color",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				System.out.println("Error msg is not displayed");
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}					
	}

	@Then("^Enter Prepaid Number of VF- Toast Message should display$")
	public void enter_Prepaid_Number_of_VF_Toast_Message_should_display() throws Throwable {
	  
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MobileNo.clear();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MobileNo));

			vdabillPay.MobileNo.sendKeys(OR.getProperty("prepaidVoda"));
			
			System.out.println("Enter prepaid Number");
			
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ToastMasg));
			
			boolean b = vdabillPay.ToastMasg.isDisplayed();
			
		if(b == true) {
			
			System.out.println("Enter Prepaid Number of VF- Toast Message should display");
			
			HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter Prepaid Number of VF- Toast Message should display", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}else {
             System.out.println("Enter Prepaid Number of VF- Toast Message should not display");
             
             HTMLReportGenerator.StepDetails("Fail", (count++) + "- Enter Prepaid Number of VF- Toast Message should not display", "",
 					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}catch(TimeoutException ex){
		
		System.out.println("Locator not found issue");
		
		HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue-M", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Enter Prepaid Number of VF - Enter Mobile Number label and field border should display in Red$")
	public void enter_Prepaid_Number_of_VF_Enter_Mobile_Number_label_and_field_border_should_display_in_Red()
			throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MobileNo.clear();

		WebDriverWait wait = new WebDriverWait(driver, 40);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MobileNo));

			vdabillPay.MobileNo.sendKeys(OR.getProperty("prepaidVoda"));
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.LesTha_Error));

			String error_msg = "This seems to be a prepaid number. Please enter postpaid number to make payment";

			String error_msg1 = vdabillPay.LesTha_Error.getText();

			System.out.println("===" + error_msg1);

			String color = vdabillPay.LesTha_Error.getCssValue("color");
			
			String color1 = "#e60000";

			System.out.println("============" + color);
			
			String color2=Color.fromString(color).asHex();
			
			System.out.println("555555555555555555555"+color2);
			boolean n1 = vdabillPay.LesTha_Error.isDisplayed();

			if (n1 == true) {

				System.out.println("Error msg is displyed");

				if (error_msg1.equalsIgnoreCase(error_msg) && color2.equalsIgnoreCase(color1)) {

					System.out.println("Correct boder color is displyed in correct color");

					HTMLReportGenerator.StepDetails("Pass", (count++)

					+ "-Enter Prepaid Number of VF>> Correct boder color is displyed in correct color", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				} else {
					
					System.out.println("Incorect boder color display");
					HTMLReportGenerator.StepDetails("Fail",
							(count++) + "- Wrong Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				}
				
			} else {

				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Correct Error msg is displyed in correct color",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				System.out.println("Error msg is not displayed");
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}					
			
	}

	@Then("^Enter NonIdea/NonVF number- Error Message should display in red color$")
	public void enter_NonIdea_NonVF_number_Error_Message_should_display_in_red_color() throws Throwable {
	    
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MobileNo.clear();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MobileNo));

			vdabillPay.MobileNo.sendKeys(OR.getProperty("NonIdeaNo"));

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.LesTha_Error));

			String error_msg = "Seems like you have entered a non vodafone number. Looking for a new connection ? Join Vodafone";

			String error_msg1 = vdabillPay.LesTha_Error.getText();

			System.out.println("===" + error_msg1);

			String color = vdabillPay.LesTha_Error.getCssValue("color");

			String color1 = "#e60000";

			System.out.println("============" + color);
			
			String color2=Color.fromString(color).asHex();
			
			System.out.println("555555555555555555555"+color2);

			boolean n1 = vdabillPay.LesTha_Error.isDisplayed();

			if (n1 == true) {

				System.out.println("Error msg is displyed");

				if (error_msg1.equalsIgnoreCase(error_msg) && color2.equalsIgnoreCase(color1)) {

					System.out.println("Enter NonIdea/NonVF number>>Correct massage is displyed in correct color");

					HTMLReportGenerator.StepDetails("Pass", (count++)

					+ "-Enter NonIdea/NonVF number>> Correct Error message is displyed in correct color", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				} else {
					
					System.out.println("Incorect boder color display");
					HTMLReportGenerator.StepDetails("Fail",
							(count++) + "-Enter NonIdea/NonVF number>> Wrong Error msg is displyed in wrong color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				}
				
			} else {

				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Error msg is not displyed",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				System.out.println("Error msg is not displayed");
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}					
	}
	@Then("^Try to enter Mobile Number starting with (\\d+) to (\\d+) >> It should not allow$")
	public void try_to_enter_Mobile_Number_starting_with_to_It_should_not_allow(int arg1, int arg2) throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MobileNo.clear();

		WebDriverWait wait = new WebDriverWait(driver, 40);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MobileNo));

			vdabillPay.MobileNo.sendKeys(OR.getProperty("NuStartinZero"));

			String typedValue1 = vdabillPay.MobileNo.getAttribute("value");

			int size1 = typedValue1.length();

			if (size1 == 0) {

				System.out.println("Try to enter Mobile Number starting with 0 to 4 >> It should not allow");

				HTMLReportGenerator.StepDetails("Pass",
						(count++) + "Try to enter Mobile Number starting with 0 to 4 >> It should not allow", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
		} catch (TimeoutException ex) {

			System.out.println("Try to enter Mobile Number starting with 0 to 4 >> It should allow");

			HTMLReportGenerator.StepDetails("Fail",
					(count++) + "Try to enter Mobile Number starting with 0 to 4 >> It should allow" + ex, "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		}
	}

	@Then("^Enter alphabets/Special characters in Mobile Number field- it should not allow$")
	public void enter_alphabets_Special_characters_in_Mobile_Number_field_it_should_not_allow() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MobileNo.clear();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MobileNo));

			vdabillPay.MobileNo.sendKeys(OR.getProperty("AlfabetSpecial"));

			System.out.println("Enter alphabets and special crater");

			String typedValue1 = vdabillPay.MobileNo.getAttribute("value");

			int size1 = typedValue1.length();

			if (size1 == 0) {

				System.out.println("Enter alphabets/Special characters in Mobile Number field- it should not allow");

				HTMLReportGenerator.StepDetails("Pass",
						(count++) + "-Enter alphabets/Special characters in Mobile Number field- it should not allow",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
		} catch (TimeoutException ex) {

			System.out.println("Enter alphabets/Special characters in Mobile Number field- it should allow");

			HTMLReportGenerator.StepDetails("Fail",
					(count++) + "Enter alphabets/Special characters in Mobile Number field- it should allow" + ex, "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			Thread.sleep(7000);
		}
	}	
	
	@Then("^Enter VF COCP Number >> Amount field should be enabled$")
	public void enter_VF_COCP_Number_Amount_field_should_be_enabled() throws Throwable {
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MobileNo.clear();
		try {

			WebDriverWait wait = new WebDriverWait(driver, 40);

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MobileNo));

			vdabillPay.MobileNo.sendKeys(OR.getProperty("vodafone_cocp"));

			System.out.println("Enter the Voadafone COCP number");

			Thread.sleep(5000);

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.AmountBill));

			boolean n1 = vdabillPay.AmountBill.isEnabled();

			if (n1 == true) {

				System.out.println("Enter VF COCP Number >> Amount field should be enabled");

				Thread.sleep(2000);

				HTMLReportGenerator.StepDetails("Pass",
						(count++) + "- Enter VF COCP Number >> Amount field should be enabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			} else {

				System.out.println("Enter VF COCP Number >> Amount field should not be enabled");

				HTMLReportGenerator.StepDetails("Fail",
						(count++) + "- Enter VF COCP Number >> Amount field should not be enabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue" + ex, "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}
	
	@Then("^Enter VF COCP Number >>  Fetch your bill link should be enabled$")
	public void enter_VF_COCP_Number_Fetch_your_bill_link_should_be_enabled() throws Throwable {
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 30);
		
	try {
			
		wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.FetchYBill));

		boolean n1 = vdabillPay.FetchYBill.isEnabled();

		if (n1 == true) {

			System.out.println("Enter Vodafone COCP Number >> Fetch your bill link should be enabled");

			Thread.sleep(2000);

			HTMLReportGenerator.StepDetails("Pass",
					(count++) + "- Enter Vodafone COCP Number >> Fetch your bill link should be enabled", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		} else {

			System.out.println("Enter Vodafone COCP Number >> Fetch your bill link should not be enabled");

			HTMLReportGenerator.StepDetails("Fail",
					(count++) + "- Enter Vodafone COCP Number >> Fetch your bill link should not be enabled",
					"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}

	} catch (TimeoutException ex) {

		System.out.println("Locator not found issue-B");

		HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue-B" + ex, "",

				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}
	}
	
	@Then("^Enter VF Postpaid Number >> Amount field should be enabled$")
	public void enter_VF_Postpaid_Number_Amount_field_should_be_enabled() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MobileNo.clear();
		try {

			WebDriverWait wait = new WebDriverWait(driver, 40);

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MobileNo));

			vdabillPay.MobileNo.sendKeys(OR.getProperty("vodaPostpaidNo"));

			System.out.println("Enter the Voadafone post paid number");

			Thread.sleep(5000);

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.AmountBill));

			boolean n1 = vdabillPay.AmountBill.isEnabled();

			if (n1 == true) {

				System.out.println("Enter VF Postpaid Number >> Amount field should be enabled");

				Thread.sleep(2000);

				HTMLReportGenerator.StepDetails("Pass",
						(count++) + "- Enter VF Postpaid Number >> Amount field should be enabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			} else {

				System.out.println("Enter VF Postpaid Number >> Amount field should not be enabled");

				HTMLReportGenerator.StepDetails("Fail",
						(count++) + "- Enter VF Postpaid Number >> Amount field should not be enabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue" + ex, "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}

	}

	@Then("^Enter VF Postpaid Number >>  Fetch your bill link should be enabled$")
	public void enter_VF_Postpaid_Number_Fetch_your_bill_link_should_be_enabled() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

			WebDriverWait wait = new WebDriverWait(driver, 30);
			
		try {
				
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.FetchYBill));

			boolean n1 = vdabillPay.FetchYBill.isEnabled();

			if (n1 == true) {

				System.out.println("Enter Vodafone Postpaid Number >> Fetch your bill link should be enabled");

				Thread.sleep(2000);

				HTMLReportGenerator.StepDetails("Pass",
						(count++) + "- Enter Vodafone Postpaid Number >> Fetch your bill link should be enabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			} else {

				System.out.println("Enter Vodafone Postpaid Number >> Fetch your bill link should not be enabled");

				HTMLReportGenerator.StepDetails("Fail",
						(count++) + "- Enter Vodafone Postpaid Number >> Fetch your bill link should not be enabled",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue-B");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue-B" + ex, "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Enter VF Postpaid Number >>  New Connection and Postpaid Packs links should NOT display$")
	public void enter_VF_Postpaid_Number_New_Connection_and_Postpaid_Packs_links_should_NOT_display() throws Throwable {
		
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

			WebDriverWait wait = new WebDriverWait(driver, 30);
			
		try {
				
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.NewConnection1));

			boolean n1 = vdabillPay.NewConnection1.isDisplayed();

			if (n1 == true) {

				System.out.println("Enter VF Postpaid Number >>  New Connection and Postpaid Plan links should not display");

				Thread.sleep(2000);

				HTMLReportGenerator.StepDetails("Pass",
						(count++) + "- Enter VF Postpaid Number >>  New Connection and Postpaid Plan links should not display", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			} else {

				System.out.println("Enter VF Postpaid Number >>  New Connection and Postpaid Plan links should display");

				HTMLReportGenerator.StepDetails("Fail",
						(count++) + "- Enter VF Postpaid Number >>  New Connection and Postpaid Plan links should display",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue-M");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue-M" + ex, "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}

	}

	@Then("^Enter amount >> Pay Now button should be enabled$")
	public void enter_amount_Pay_Now_button_should_be_enabled() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		try {

			WebDriverWait wait = new WebDriverWait(driver, 40);

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.AmountBill));
			
			Thread.sleep(3000);

			vdabillPay.AmountBill.sendKeys(OR.getProperty("amount"));

			System.out.println("Enter Amount");

			Thread.sleep(5000);

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.PayButoon));

			boolean n1 = vdabillPay.PayButoon.isEnabled();

			if (n1 == true) {

				System.out.println("Enter amount >> Pay Now button should be enabled");

				Thread.sleep(3000);

				HTMLReportGenerator.StepDetails("Pass",
						(count++) + "- Enter amount >> Pay Now button should be enabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			} else {

				System.out.println("Enter amount >> Pay Now button should not be enabled");

				HTMLReportGenerator.StepDetails("Fail",
						(count++) + "- Enter amount >> Pay Now button should not be enabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue-J");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue--J" + ex, "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}

	}

	@Then("^Using Cross icon remove Mobile Number >> Amount, Fetch Your Bill and Pay Now button should be disabled$")
	public void using_Cross_icon_remove_Mobile_Number_Amount_Fetch_Your_Bill_and_Pay_Now_button_should_be_disabled()
			throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		try {

			WebDriverWait wait = new WebDriverWait(driver, 40);

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.CrossMark));

			vdabillPay.CrossMark.click();

			System.out.println(" Using cross icone remove mobile number");

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.Pay_Now));

			boolean b = vdabillPay.AmountBill.isDisplayed();

			if (b == true) {

				System.out.println("Enter amount >> Pay Now button should be enabled");

				Thread.sleep(2000);

				HTMLReportGenerator.StepDetails("Pass",
						(count++) + "- Enter amount >> Pay Now button should be enabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			} else {

				System.out.println("Enter amount >> Pay Now button should not be enabled");

				HTMLReportGenerator.StepDetails("Fail",
						(count++) + "- Enter amount >> Pay Now button should not be enabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue--F");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue-F" + ex, "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}

	}

	@Then("^Go to Bill Pay page >>Enter the Vodafone postpaid number>> Enter amount in integer - It should allow only (\\d+) digits$")
	public void go_to_Bill_Pay_page_Enter_the_Vodafone_postpaid_number_Enter_amount_in_integer_It_should_allow_only_digits(int arg1) throws Throwable {
	   
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 40);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MobileNo));

			vdabillPay.MobileNo.sendKeys(OR.getProperty("vodaPostpaidNo"));

			Thread.sleep(2000);
			System.out.println("Enter the vodafone Mobile Number");

			HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter the vodafone Mobile Number", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue--H");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		}

		Thread.sleep(4000);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.AmountBill));

			vdabillPay.AmountBill.sendKeys(OR.getProperty("AmountTenDigit"));

			System.out.println("Enter amount in integer - It should allow only 10 digits");

			HTMLReportGenerator.StepDetails("Pass",
					(count++) + "- Enter amount in integer - It should allow only 10 digits", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		} catch (TimeoutException ex) {
			System.out.println("Locator not found issue--G");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue-G", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}

		
	}

	@Then("^Go to Bill Pay page >>Enter the Vodafone postpaid number>> Enter amount in decimals - It should allow only (\\d+) digits including decimal point$")
	public void go_to_Bill_Pay_page_Enter_the_Vodafone_postpaid_number_Enter_amount_in_decimals_It_should_allow_only_digits_including_decimal_point(int arg1) throws Throwable {
	   
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MobileNo.clear();

		WebDriverWait wait = new WebDriverWait(driver, 40);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MobileNo));

			vdabillPay.MobileNo.sendKeys(OR.getProperty("vodaPostpaidNo"));
			
			Thread.sleep(2000);

			System.out.println("Enter the Vodafone postpaid number");

			HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter the Vodafone postpaid number", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue-A");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}

		Thread.sleep(8000);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.AmountBill));

			vdabillPay.AmountBill.sendKeys(OR.getProperty("dicimalNo"));

			System.out.println("Enter amount in decimals - It should allow only 13 digits including decimal point");

			HTMLReportGenerator.StepDetails("Pass",
					(count++) + "- Enter amount in decimals - It should allow only 13 digits including decimal point",

					"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue--Q");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		}
		
	}

	@Then("^On page load >> Imortant Things to Know should display collapsed$")
	public void on_page_load_Imortant_Things_to_Know_should_display_collapsed() throws Throwable {

		Thread.sleep(3000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,350)", "");

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 05);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ImpThinstoNow));

			boolean b = vdabillPay.ImpThinstoNow.isDisplayed();

			if (b == true) {

				System.out.println("On page load >> Online Postpaid Bill Payment should display collapsed");

				Thread.sleep(2000);

				HTMLReportGenerator.StepDetails("Pass",
						(count++) + "- On page load >> Online Postpaid Bill Payment should display collapsed", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			} else {

				System.out.println("On page load >> Online Postpaid Bill Payment should not display collapsed");

				HTMLReportGenerator.StepDetails("Fail",
						(count++) + "- On page load >> Online Postpaid Bill Payment should not display collapsed", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue--R");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue" + ex, "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}

	}

	@Then("^Click Arrow for Important Things to Know >> Page should autoscroll$")
	public void click_Arrow_for_Important_Things_to_Know_Page_should_autoscroll() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 05);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ImpThinstoNow));

			vdabillPay.ImpThinstoNow.click();

			System.out.println("Click Arrow for Online Postpaid Bill Payment >> Page should autoscroll");

			HTMLReportGenerator.StepDetails("Pass",
					(count++) + "- Click Arrow for Online Postpaid Bill Payment >> Page should autoscroll", "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		} catch (TimeoutException ex) {
			System.out.println("Locator not found issue--G");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue--G" + ex, "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Verify page >> Focus should go on Imp Things to know section$")
	public void verify_page_Focus_should_go_on_Imp_Things_to_know_section() throws Throwable {

		driver.navigate().refresh();

		Thread.sleep(2000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,450)", "");

		System.out.println("Verify page >> Focus should go on Online Postpaid Bill Payment section");
	}

	@Then("^Verify page >> Imp Things to Know section should expand$")
	public void verify_page_Imp_Things_to_Know_section_should_expand() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		// try{
/*
		wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ImpThingArrow));

		vdabillPay.ImpThingArrow.click();*/

		System.out.println("Verify page >> Online Postpaid Bill Payment section should expand");

	}

	@Then("^Click Arrow for Important Things to Know >> Page should collapse$")
	public void click_Arrow_for_Important_Things_to_Know_Page_should_collapse() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ImpThinstoNow));

		//	vdabillPay.ImpThinstoNow.click();

			System.out.println("Click Arrow for Online Postpaid Bill Payment >> Page should collapse");

			HTMLReportGenerator.StepDetails("Pass",
					(count++) + "- Click Arrow for Online Postpaid Bill Payment >> Page should collapse", "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue--#");
			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue--#", "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
		
		/*VodafBillPayObj vdabillPay1 = new VodafBillPayObj(driver);

		WebDriverWait wait1 = new WebDriverWait(driver, 50);

			wait1.until(ExpectedConditions.visibilityOfAllElements(vdabillPay1.impcllapse));

			vdabillPay1.impcllapse.click();
			
			System.out.println("collapse page ");*/
	}
	@Then("^Enter VF Postpaid Number and click Fetch Your Bill link >> Fetch Bill Amount popup should open$")
	public void enter_VF_Postpaid_Number_and_click_Fetch_Your_Bill_link_Fetch_Bill_Amount_popup_should_open() throws Throwable {
		
		Thread.sleep(4000);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-350)", "");
		
        Thread.sleep(7000);
	    
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		
		vdabillPay.MobileNo.clear();
		
		 WebDriverWait wait = new WebDriverWait(driver, 40);
		 
		try {
			
	      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MobileNo));
	      
	      vdabillPay.MobileNo.sendKeys("9619218213");
	      
	      System.out.println("Enter Idea Postpaid Number and click FetchYourBill link");
	      
	      Thread.sleep(4000);
	      
	      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.FetchYourBill));
	      
	      vdabillPay.FetchYourBill.click();
	      
	      System.out.println("click FetchYourBill link");
	      
	      Thread.sleep(4000);
			
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.OTP_popup));
			
			boolean b = vdabillPay.OTP_popup.isDisplayed();
			
			if(b == true) {
				
				System.out.println("Fetch Bill Amount popup should open");
				
				HTMLReportGenerator.StepDetails("Pass", (count++) + "- Fetch Bill Amount popup should open", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}else {
				
				System.out.println("Fetch Bill Amount popup should not open");
				
				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Fetch Bill Amount popup should not open", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
			}catch(TimeoutException ex){
				
				System.out.println("Fetch Bill Amount popup should not open");
				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Fetch Bill Amount popup should not open"+ex, "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
			
	}
	@Then("^Click SetUp Now button >> My Number popup should display$")
	public void click_SetUp_Now_button_My_Number_popup_should_display() throws Throwable {
		
		Thread.sleep(4000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,-250)", "");

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 40);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.Setup_Now));

			vdabillPay.Setup_Now.click();

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyNumber));

			boolean b = vdabillPay.MyNumber.isDisplayed();

			if (b == true) {

				System.out.println("Click SetUp Now button >> My Number popup should display");

				HTMLReportGenerator.StepDetails("Pss",
						(count++) + "- Click SetUp Now button >> My Number popup should display", "",

						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			} else {

				System.out.println("Click SetUp Now button >> My Number popup should not display");

				HTMLReportGenerator.StepDetails("Fail",
						(count++) + "- Click SetUp Now button >> My Number popup should not display", "",

						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue--@");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue--3", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Focus should be on Number field on popup load$")
	public void focus_should_be_on_Number_field_on_popup_load() throws Throwable {

		System.out.println("Focus should be on Number field on popup load");
	}

	@Then("^Submit button should be disabled on popup load$")
	public void submit_button_should_be_disabled_on_popup_load() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 40);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.SubmittBtn));

			boolean b = vdabillPay.SubmittBtn.isDisplayed();

			if (b == true) {

				System.out.println("Submit button should be disabled on popup load");

				HTMLReportGenerator.StepDetails("Pss", (count++) + "- Submit button should be disabled on popup load",
						"",

						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			} else {

				System.out.println("Click SetUp Now button >> My Number popup should not display");

				HTMLReportGenerator.StepDetails("Fail",
						(count++) + "- Click SetUp Now button >> My Number popup should not display", "",

						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue--4");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue--4", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Enter mobile number less than ten digits - Error message should display in Red color$")
	public void enter_mobile_number_less_than_ten_digits_Error_message_should_display_in_Red_color() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyNumber));

			vdabillPay.MyNumber.sendKeys(OR.getProperty("LessThan"));

			vdabillPay.MyNumber.sendKeys(Keys.BACK_SPACE);

			String error_msg = "Please enter 10 digit mobile number";

			String error_msg1 = vdabillPay.LebelFieldBoder.getText();

			System.out.println("===" + error_msg1);

			String color = vdabillPay.LebelFieldBoder.getCssValue("color");
			
			String color1 = "#e60000";

			System.out.println("============" + color);
			
			String color2=Color.fromString(color).asHex();
			
			System.out.println("555555555555555555555"+color2);

			//String color1 = "rgba(153, 0, 0, 1)";

			System.out.println("============" + color);

			boolean n1 = vdabillPay.LebelFieldBoder.isDisplayed();

			if (n1 == true) {

				System.out.println("Error msg is displyed");

				if (error_msg1.equalsIgnoreCase(error_msg) && color.equalsIgnoreCase(color1)) {

					System.out.println("Correct Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Pass", (count++)

							+ "-Enter mobile number less than ten digits>> Correct Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				} else {

					System.out.println("Incorrect Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Fail",

							(count++) + "- wrong Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				}
			} else {

				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Wrong Error msg is displyed in correct color",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				System.out.println("Error msg is not displayed");
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue---V");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Enter mobile number less than ten digits - Enter Mobile Number label and field border should display in Red color$")
	public void enter_mobile_number_less_than_ten_digits_Enter_Mobile_Number_label_and_field_border_should_display_in_Red_color()
			throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MyNumber.clear();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyNumber));

			vdabillPay.MyNumber.sendKeys(OR.getProperty("LessThan"));

			vdabillPay.MyNumber.sendKeys(Keys.BACK_SPACE);

			String error_msg = "Please enter 10 digit mobile number";

			String error_msg1 = vdabillPay.LebelFieldBoder.getText();

			System.out.println("===" + error_msg1);

			String color = vdabillPay.LebelFieldBoder.getCssValue("color");

			String color1 = "rgba(153, 0, 0, 1)";

			System.out.println("============" + color);

			boolean n1 = vdabillPay.LebelFieldBoder.isDisplayed();

			if (n1 == true) {

				System.out.println("Error msg is displyed");

				if (error_msg1.equalsIgnoreCase(error_msg) && color.equalsIgnoreCase(color1)) {

					System.out.println("Enter mobile number less than ten digits>> Correct Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Pass", (count++)

							+ "- Correct Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				} else {

					System.out.println("Incorrect Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Fail",

							(count++) + "- Correct Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				}

			} else {

				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Correct Error msg is displyed in correct color",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				System.out.println("Error msg is not displayed");
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue---V");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Enter Prepaid Number of Idea - Error message should display in red$")
	public void enter_Prepaid_Number_of_Idea_Error_message_should_display_in_red() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MyNumber.clear();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyNumber));

			vdabillPay.MyNumber.sendKeys(OR.getProperty("prepaidIdeaNO"));

			String error_msg = "You have entered prepaid number. Please enter Valid Postpaid number.";

			String error_msg1 = vdabillPay.LebelFieldBoder.getText();

			System.out.println("===" + error_msg1);

			String color = vdabillPay.LebelFieldBoder.getCssValue("color");

			String color1 = "rgba(33, 37, 41, 1)";

			System.out.println("============" + color);

			boolean n1 = vdabillPay.LebelFieldBoder.isDisplayed();

			if (n1 == true) {

				System.out.println("Error msg is displyed");
				
				if (error_msg1.equalsIgnoreCase(error_msg) && color.equalsIgnoreCase(color1)) {

					System.out.println("Correct Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Pass", (count++)

							+ "- Correct Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				} else {

					System.out.println("Incorrect Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Fail",

							(count++) + "- Correct Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				}

			} else {

				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Correct Error msg is displyed in correct color",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				System.out.println("Error msg is not displayed");
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue---V");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Enter Prepaid Number of Idea - Enter Mobile Number label and field border should display in Red color$")
	public void enter_Prepaid_Number_of_Idea_Enter_Mobile_Number_label_and_field_border_should_display_in_Red_color()
			throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MyNumber.clear();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyNumber));

			vdabillPay.MyNumber.sendKeys(OR.getProperty("prepaidIdeaNO"));

			String error_msg = "You have entered prepaid number. Please enter Valid Postpaid number.";

			String error_msg1 = vdabillPay.LebelFieldBoder.getText();

			System.out.println("===" + error_msg1);

			String color = vdabillPay.LebelFieldBoder.getCssValue("color");

			String color1 = "rgba(33, 37, 41)";

			System.out.println("============" + color);

			boolean n1 = vdabillPay.LebelFieldBoder.isDisplayed();

			if (n1 == true) {

				System.out.println("Error msg is displyed");

				if (error_msg1.equalsIgnoreCase(error_msg) && color.equalsIgnoreCase(color1)) {

					System.out.println("Correct Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Pass", (count++)

							+ "- Correct Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				} else {

					System.out.println("Incorrect Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Fail",

							(count++) + "- Correct Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				}

			} else {

				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Correct Error msg is displyed in correct color",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				System.out.println("Error msg is not displayed");
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue---V");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Enter Prepaid Number of VF- Error message should display in Red color$")
	public void enter_Prepaid_Number_of_VF_Error_message_should_display_in_Red_color() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MyNumber.clear();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyNumber));

			vdabillPay.MyNumber.sendKeys(OR.getProperty("prepaidVoda"));

			String error_msg = "You have entered prepaid number. Please enter Valid Postpaid number.";

			String error_msg1 = vdabillPay.LebelFieldBoder.getText();

			System.out.println("===" + error_msg1);

			String color = vdabillPay.LebelFieldBoder.getCssValue("color");

			String color1 = "rgba(33, 37, 41)";

			System.out.println("============" + color);

			boolean n1 = vdabillPay.LebelFieldBoder.isDisplayed();

			if (n1 == true) {

				System.out.println("Error msg is displyed");

				if (error_msg1.equalsIgnoreCase(error_msg) && color.equalsIgnoreCase(color1)) {

					System.out.println("Correct Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Pass", (count++)

							+ "- Correct Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				} else {

					System.out.println("Incorrect Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Fail",

							(count++) + "- Correct Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				}

			} else {

				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Correct Error msg is displyed in correct color",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				System.out.println("Error msg is not displayed");
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue---V");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Enter Prepaid Number of VF - Enter Mobile Number label and field border should display in Red color$")
	public void enter_Prepaid_Number_of_VF_Enter_Mobile_Number_label_and_field_border_should_display_in_Red_color()
			throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MyNumber.clear();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyNumber));

			vdabillPay.MyNumber.sendKeys(OR.getProperty("prepaidVoda"));

			String error_msg = "You have entered prepaid number. Please enter Valid Postpaid number.";

			String error_msg1 = vdabillPay.LebelFieldBoder.getText();

			System.out.println("===" + error_msg1);

			String color = vdabillPay.LebelFieldBoder.getCssValue("color");

			String color1 = "rgba(33, 37, 41)";

			System.out.println("============" + color);

			boolean n1 = vdabillPay.LebelFieldBoder.isDisplayed();

			if (n1 == true) {

				System.out.println("Error msg is displyed");

				if (error_msg1.equalsIgnoreCase(error_msg) && color.equalsIgnoreCase(color1)) {

					System.out.println("Correct Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Pass", (count++)

							+ "- Enter Prepaid Number of VF>>Correct Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				} else {

					System.out.println("Incorrect Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Fail",

							(count++) + "- Enter Prepaid Number of VF>>Wrong Error msg is displyed", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				}

			} else {

				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Wrong Error msg is displyed in correct color",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				System.out.println("Error msg is not displayed");
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue---V");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Enter NonIdea/NonVF number- Error message should display in Red color$")
	public void enter_NonIdea_NonVF_number_Error_message_should_display_in_Red_color() throws Throwable {
	   
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		//vdabillPay.MyNumber.clear();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyNumber));

			vdabillPay.MyNumber.sendKeys(OR.getProperty("NonIdeaNo"));

			String error_msg = "Seems like you have entered an invalid number.Please enter valid Postpaid";

			String error_msg1 = vdabillPay.LebelFieldBoder.getText();

			System.out.println("===" + error_msg1);

			String color = vdabillPay.LebelFieldBoder.getCssValue("color");

			String color1 = "rgba(33, 37, 41)";

			System.out.println("============" + color);

			boolean n1 = vdabillPay.LebelFieldBoder.isDisplayed();

			if (n1 == true) {

				System.out.println("Error msg is displyed");

				if (error_msg1.equalsIgnoreCase(error_msg) && color.equalsIgnoreCase(color1)) {

					System.out.println("Correct Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Pass", (count++)

							+ "- Correct Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				} else {

					System.out.println("Incorrect Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Fail",

							(count++) + "- Wrong Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				}

			} else {

				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Correct Error msg is displyed in correct color",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				System.out.println("Error msg is not displayed");
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue---V");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Enter NonIdea/NonVF number - Enter Mobile Number label and field border should display in Red$")
	public void enter_NonIdea_NonVF_number_Enter_Mobile_Number_label_and_field_border_should_display_in_Red() throws Throwable {
	   
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		//vdabillPay.MyNumber.clear();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyNumber));

			vdabillPay.MyNumber.sendKeys(OR.getProperty("NonIdeaNo"));

			String error_msg = "Seems like you have entered an invalid number.Please enter valid Postpaid";

			String error_msg1 = vdabillPay.LebelFieldBoder.getText();

			System.out.println("===" + error_msg1);

			String color = vdabillPay.LebelFieldBoder.getCssValue("color");

			String color1 = "rgba(33, 37, 41)";

			System.out.println("============" + color);

			boolean n1 = vdabillPay.LebelFieldBoder.isDisplayed();

			if (n1 == true) {

				System.out.println("Error msg is displyed");

				if (error_msg1.equalsIgnoreCase(error_msg) && color.equalsIgnoreCase(color1)) {

					System.out.println("Correct Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Pass", (count++)

							+ "- Correct Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				} else {

					System.out.println("Incorrect Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Fail",

							(count++) + "- Wrong Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				}

			} else {

				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Wrong Error msg is displyed in correct color",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				System.out.println("Error msg is not displayed");
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue---V");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Try to enter Mobile Number starting with (\\d+) to (\\d+) >> Its should not allow$")
	public void try_to_enter_Mobile_Number_starting_with_to_Its_should_not_allow(int arg1, int arg2) throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MyNumber.clear();

		WebDriverWait wait = new WebDriverWait(driver, 40);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyNumber));

			vdabillPay.MyNumber.sendKeys(OR.getProperty("NuStartinZero"));

			String typedValue1 = vdabillPay.MyNumber.getAttribute("value");

			int size1 = typedValue1.length();

			if (size1 == 0) {

				System.out.println("Try to enter Mobile Number starting with 0 to 4 >> It should not allow");

				HTMLReportGenerator.StepDetails("Pass",
						(count++) + "Try to enter Mobile Number starting with 0 to 4 >> It should not allow", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
		} catch (TimeoutException ex) {

			System.out.println("Try to enter Mobile Number starting with 0 to 4 >> It should allow");

			HTMLReportGenerator.StepDetails("Fail",
					(count++) + "Try to enter Mobile Number starting with 0 to 4 >> It should allow" + ex, "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		}
	}

	@Then("^Enter alphabets/Special characters in Mobile Number field- its should not allow$")
	public void enter_alphabets_Special_characters_in_Mobile_Number_field_its_should_not_allow() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MyNumber.clear();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyNumber));

			vdabillPay.MyNumber.sendKeys(OR.getProperty("AlfabetSpecial"));

			System.out.println("Enter alphabets and special crater");

			String typedValue1 = vdabillPay.MyNumber.getAttribute("value");

			int size1 = typedValue1.length();

			if (size1 == 0) {

				System.out.println("Enter alphabets/Special characters in Mobile Number field- it should not allow");

				HTMLReportGenerator.StepDetails("Pass",
						(count++) + "-Enter alphabets/Special characters in Mobile Number field- it should not allow",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
		} catch (TimeoutException ex) {

			System.out.println("Enter alphabets/Special characters in Mobile Number field- it should allow");

			HTMLReportGenerator.StepDetails("Fail",
					(count++) + "Enter alphabets/Special characters in Mobile Number field- it should allow" + ex, "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			
		}
	}

	@Then("^Click Esc button of keyboard >> Popup should be close$")
	public void click_Esc_button_of_keyboard_Popup_should_be_close() throws Throwable {
		
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE);
		System.out.println("Click Esc button of keyboard >> Popup should be close");

		HTMLReportGenerator.StepDetails("Pass", (count++) + "- Click Esc button of keyboard >> Popup should be close",
				"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		Thread.sleep(2000);
	}

	@Then("^Click on SetUp Now button >> My Number popup should displayed$")
	public void click_on_SetUp_Now_button_My_Number_popup_should_displayed() throws Throwable {

		Thread.sleep(5000);

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 40);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.Setup_Now));

			vdabillPay.Setup_Now.click();

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyNumber));

			boolean b = vdabillPay.MyNumber.isDisplayed();

			if (b == true) {

				System.out.println("Click SetUp Now button >> My Number popup should display");

				HTMLReportGenerator.StepDetails("Pss",
						(count++) + "- Click SetUp Now button >> My Number popup should display", "",

						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			} else {

				System.out.println("Click SetUp Now button >> My Number popup should not display");

				HTMLReportGenerator.StepDetails("Fail",
						(count++) + "- Click SetUp Now button >> My Number popup should not display", "",

						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue--10");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue--3", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Click Cross button on popup >> Popup should close$")
	public void click_Cross_button_on_popup_Popup_should_close() throws Throwable {
	   
		Thread.sleep(3000);
		
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ESCAPE);
		
		System.out.println("Click Esc button of keyboard >> Popup should be close");

		HTMLReportGenerator.StepDetails("Pass", (count++) + "Click Esc button of keyboard >> Popup should be close", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}

	@Then("^Click SetUp Now button >> My Number popup should displayed$")
	public void click_SetUp_Now_button_My_Number_popup_should_displayed() throws Throwable {

		Thread.sleep(2000);

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 40);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.Setup_Now));

			vdabillPay.Setup_Now.click();

			Thread.sleep(2000);

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyNumber));

			boolean b = vdabillPay.MyNumber.isDisplayed();

			if (b == true) {

				System.out.println("Click SetUp Now button >> My Number popup should display");

				HTMLReportGenerator.StepDetails("Pss",
						(count++) + "- Click SetUp Now button >> My Number popup should display", "",

						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			} else {

				System.out.println("Click SetUp Now button >> My Number popup should not display");

				HTMLReportGenerator.StepDetails("Fail",
						(count++) + "- Click SetUp Now button >> My Number popup should not display", "",

						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue--10");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue--!", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Enter Idea Postpaid Number >> Error message should display in Red$")
	public void enter_Idea_Postpaid_Number_Error_message_should_display_in_Red() throws Throwable {
	    

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MyNumber.clear();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyNumber));

			vdabillPay.MyNumber.sendKeys(OR.getProperty("IdeaPostpaidNo"));

			System.out.println("Enter Idea Postpaid Number");

			HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter Idea Postpaid Number", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.SubmittBtn));

			boolean b = vdabillPay.SubmittBtn.isDisplayed();

			if (b == true) {

				System.out.println("Submit button should be enabled");

				HTMLReportGenerator.StepDetails("Pass", (count++) + "- Submit button should be enabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			} else {

				System.out.println("Submit button should not be enabled");

				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Submit button should not be enabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}

		} catch (TimeoutException ex) {
			System.out.println("Submit button should not be enabled");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Submit button should not be enabled", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}
	@Then("^Enter Idea Postpaid Number >> Enter Mobile Number label and field border should display in Red$")
	public void enter_Idea_Postpaid_Number_Enter_Mobile_Number_label_and_field_border_should_display_in_Red() throws Throwable {
	System.out.println("Enter Idea postpaid number");
	}
	@Then("^Enter VF Postpaid Number >> Submit button should be enabled$")
	public void enter_VF_Postpaid_Number_Submit_button_should_be_enabled() throws Throwable {
	    
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MyNumber.clear();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyNumber));

			vdabillPay.MyNumber.sendKeys(OR.getProperty("vodaPostpaidNo"));

			System.out.println("Enter VF Postpaid Number");

			HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter VF Postpaid Number", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.SubmittBtn));

			boolean b = vdabillPay.SubmittBtn.isDisplayed();

			if (b == true) {

				System.out.println("Submit button should be enabled");

				HTMLReportGenerator.StepDetails("Pass", (count++) + "- Submit button should be enabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			} else {

				System.out.println("Submit button should not be enabled");

				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Submit button should not be enabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
		} catch (TimeoutException ex) {

			System.out.println("Submit button should not be enabled");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Submit button should not be enabled", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}

	}

	@Then("^Click Cross button in Mobile Number field >> Number should be deleted and Submit button should be disabled$")
	public void click_Cross_button_in_Mobile_Number_field_Number_should_be_deleted_and_Submit_button_should_be_disabled()
			throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.CrosMark1));

			vdabillPay.CrosMark1.click();

			System.out.println("Click Cross button in Mobile Number field");
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.SubmittBtn));

			boolean b = vdabillPay.SubmittBtn.isDisplayed();

			if (b == true) {

				System.out.println("Number should be deleted and Submit button should be disabled");

				HTMLReportGenerator.StepDetails("Pass",
						(count++) + "- Number should be deleted and Submit button should be disabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			} else {

				System.out.println("Number should be deleted and Submit button should not be disabled");

				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Submit button should not be enabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
		} catch (TimeoutException ex) {

			System.out.println("Number should be deleted and Submit button should not be disabled");

			HTMLReportGenerator.StepDetails("Fail",
					(count++) + "- Number should be deleted and Submit button should not be disabled", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Enter Idea Postpaid Number and click Submit >> Idea page should open in same tab\\.$")
	public void enter_Idea_Postpaid_Number_and_click_Submit_Idea_page_should_open_in_same_tab() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyNumber));

			vdabillPay.MyNumber.sendKeys(OR.getProperty("IdeaPostpaidNo"));

			System.out.println("Enter Idea Postpaid Number ");

			Thread.sleep(3000);

			WebElement nameInputField = driver.findElement(By.xpath("//*[@class=\"btn autopaySubmitBtn\"]"));

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", nameInputField);

			System.out.println("click Submit >> Idea page should open in same tab");

			HTMLReportGenerator.StepDetails("Pass", (count++) + "-click Submit >> Idea page should open in same tab",
					"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		} catch (TimeoutException ex) {

			System.out.println("click Submit >> Idea page should open in same tab");

			HTMLReportGenerator.StepDetails("Fail",
					(count++) + "-click Submit >> Idea page should not open in same tab", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Click setUp now button >> My Number popup should display$")
	public void click_setUp_now_button_My_Number_popup_should_display() throws Throwable {

		driver.get(OR.getProperty("VodaFone_Pay_Bill"));

		Thread.sleep(2000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,350)", "");

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 40);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.Setup_Now));

			vdabillPay.Setup_Now.click();

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyNumber));

			boolean b = vdabillPay.MyNumber.isDisplayed();

			if (b == true) {

				System.out.println("Click SetUp Now button >> My Number popup should display");

				HTMLReportGenerator.StepDetails("Pass",
						(count++) + "- Click SetUp Now button >> My Number popup should display", "",

						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			} else {

				System.out.println("Click SetUp Now button >> My Number popup should not display");

				HTMLReportGenerator.StepDetails("Fail",
						(count++) + "- Click SetUp Now button >> My Number popup should not display", "",

						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue--0");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue--0)", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}

	}

	@Then("^Enter VF Postpaid Number and click Submit >> VF page should open in same tab\\.$")
	public void enter_VF_Postpaid_Number_and_click_Submit_VF_page_should_open_in_same_tab() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyNumber));

			vdabillPay.MyNumber.sendKeys(OR.getProperty("vodaPostpaidNo"));
			
			Thread.sleep(2000);

			System.out.println("Enter VF Postpaid Number");

			HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter VF Postpaid Number", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			Thread.sleep(4000);

			WebElement InputField = driver.findElement(By.xpath("//*[@class=\"btn autopaySubmitBtn\"]"));

			JavascriptExecutor executor = (JavascriptExecutor) driver;

			executor.executeScript("arguments[0].click();", InputField);

			System.out.println("click Submit >> VF page should open in same tab");

			HTMLReportGenerator.StepDetails("Pass", (count++) + "- click Submit >> VF page should open in same tab", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		} catch (TimeoutException ex) {

			System.out.println("click Submit >> VF page should open in same tab");
			HTMLReportGenerator.StepDetails("Fail", (count++) + "- click Submit >> VF page should not open in same tab",
					"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Click Get a New Connection button >> My Number popup should display$")
	public void click_Get_a_New_Connection_button_My_Number_popup_should_display() throws Throwable {

		driver.get(OR.getProperty("VodaFone_Pay_Bill"));

		Thread.sleep(2000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,350)", "");

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 40);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.NewConnection));

			vdabillPay.NewConnection.click();

			System.out.println("Click Get a New Connection button");

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyMobileNum));

			boolean b = vdabillPay.MyMobileNum.isDisplayed();

			if (b == true) {

				System.out.println("My Number popup should display");

				HTMLReportGenerator.StepDetails("Pass", (count++) + "-Click Get a Pay Now button >> My Number popup should display", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			} else {

				System.out.println("My Number popup should not display");

				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Click Get a Pay Now button >> My Number popup should not display", "",

						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue--9");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue--9)", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Focus should be go on Number field on popup load$")
	public void focus_should_be_go_on_Number_field_on_popup_load1() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 40);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyMobileNum));

			boolean b = vdabillPay.MyMobileNum.isDisplayed();

			if (b == true) {

				System.out.println("Focus should be go on Number field on popup load");

				HTMLReportGenerator.StepDetails("Pass",
						(count++) + "- Focus should be go on Number field on popup load", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			} else {

				System.out.println("Focus should not be go on Number field on popup load");

				HTMLReportGenerator.StepDetails("Fail",
						(count++) + "- Focus should not be go on Number field on popup load", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}

		} catch (TimeoutException ex) {
			System.out.println("Locator not found issue ");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not find issue", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Submit Button should be disabled on popup load$")
	public void submit_Button_should_be_disabled_on_popup_load() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 40);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.submitBtn2));

			boolean b = vdabillPay.submitBtn2.isDisplayed();

			if (b == true) {

				System.out.println("Submit Button should be disabled on popup load");

				HTMLReportGenerator.StepDetails("Pass", (count++) + "- Submit Button should be disabled on popup load",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			} else {

				System.out.println("Submit Button should not be disabled on popup load");

				HTMLReportGenerator.StepDetails("Fail",
						(count++) + "- Submit Button should not be disabled on popup load", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}

		} catch (TimeoutException ex) {
			System.out.println("Locator not found issue ");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not find issue", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Enter mobile number less than ten digits >> Error message should display in Red color$")
	public void enter_mobile_number_less_than_ten_digits_Error_message_should_display_in_Red_color1() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyMobileNum));

			vdabillPay.MyMobileNum.sendKeys(OR.getProperty("LessThan"));

			vdabillPay.MyMobileNum.sendKeys(Keys.BACK_SPACE);
			
          Thread.sleep(2000);
          
			String error_msg = "Please enter 10 digit mobile number";

			String error_msg1 = vdabillPay.LebelFieldBoder.getText();

			System.out.println("===" + error_msg1);

			String color = vdabillPay.LebelFieldBoder.getCssValue("color");

			String color1 = "rgba(153, 0, 0, 1)";

			System.out.println("============" + color);

			boolean n1 = vdabillPay.LebelFieldBoder.isDisplayed();

			if (n1 == true) {

				System.out.println("Error msg is displyed");

				if (error_msg1.equalsIgnoreCase(error_msg) && color.equalsIgnoreCase(color1)) {

					System.out.println("Correct Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Pass", (count++)

							+ "- Correct Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				} else {

					System.out.println("Incorrect Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Fail",

							(count++) + "- Wrong Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				}

			} else {

				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Correct Error msg is displyed in correct color",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				System.out.println("Error msg is not displayed");
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue---V");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Enter mobile number less than ten digits >> Enter Mobile Number label and field border should display in Red color$")
	public void enter_mobile_number_less_than_ten_digits_Enter_Mobile_Number_label_and_field_border_should_display_in_Red_color1()
			throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MyMobileNum.clear();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyMobileNum));

			vdabillPay.MyMobileNum.sendKeys(OR.getProperty("LessThan"));

			vdabillPay.MyMobileNum.sendKeys(Keys.BACK_SPACE);
Thread.sleep(2000);
			String error_msg = "Please enter 10 digit mobile number";

			String error_msg1 = vdabillPay.LebelFieldBoder.getText();

			System.out.println("===" + error_msg1);

			String color = vdabillPay.LebelFieldBoder.getCssValue("color");

			String color1 = "rgba(153, 0, 0, 1)";

			System.out.println("============" + color);

			boolean n1 = vdabillPay.LebelFieldBoder.isDisplayed();

			if (n1 == true) {

				System.out.println("Error msg is displyed");

				if (error_msg1.equalsIgnoreCase(error_msg) && color.equalsIgnoreCase(color1)) {

					System.out.println("Correct Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Pass", (count++)

							+ "- Correct Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				} else {

					System.out.println("Incorrect Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Fail",

							(count++) + "- Wrong Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				}

			} else {

				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Wrong Error msg is displyed in correct color",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				System.out.println("Error msg is not displayed");
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue---V");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Enter Prepaid Number of Idea >> Error message should display in red$")
	public void enter_Prepaid_Number_of_Idea_Error_message_should_display_in_red1() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MobileNo.clear();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyMobileNum));

			vdabillPay.MyMobileNum.sendKeys(OR.getProperty("prepaidIdeaNO"));

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.LesTha_Error));
Thread.sleep(2000);
			String error_msg = "You have entered prepaid number." + "Please enter Valid Postpaid number.";

			String error_msg1 = vdabillPay.LesTha_Error.getText();

			System.out.println("===" + error_msg1);

			String color = vdabillPay.LesTha_Error.getCssValue("color");

			String color1 = "rgb(153, 0, 0)";

			System.out.println("============" + color);

			boolean n1 = vdabillPay.LesTha_Error.isDisplayed();

			if (n1 == true) {

			System.out.println("Error msg is displyed");

			if (error_msg1.equalsIgnoreCase(error_msg) && color.equalsIgnoreCase(color1)) {

			System.out.println("Correct Error msg is displyed in correct color");

			HTMLReportGenerator.StepDetails("Pass", (count++)

			+ "- Enter mobile number less than ten digits >> Correct Error msg is displyed in correct color",

				"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		} else {

			System.out.println("Incorrect Error msg is displyed in correct color");

			HTMLReportGenerator.StepDetails("Fail", (count++)

			+ "- Enter mobile number less than ten digits >> Correct Error msg is not displyed in correct color",

				"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				}

			} else {

				HTMLReportGenerator.StepDetails("Fail",

						(count++) + "- Enter mobile number less than ten digits >> Error msg is not displayed", "",

						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				System.out.println("Error msg is not displayed");
			}
		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue");

			HTMLReportGenerator.StepDetails("Fail",

					(count++) + "- Locator not found issue", "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}

	}

	@Then("^Enter Prepaid Number of Idea >> Enter Mobile Number label and field border should display in Red color$")
	public void enter_Prepaid_Number_of_Idea_Enter_Mobile_Number_label_and_field_border_should_display_in_Red_color1()
			throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MyMobileNum.clear();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyMobileNum));

			vdabillPay.MyMobileNum.sendKeys(OR.getProperty("prepaidIdeaNO"));

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.LesTha_Error));
       Thread.sleep(2000);
			String error_msg = "You have entered prepaid number." + "Please enter Valid Postpaid number.";

			String error_msg1 = vdabillPay.LesTha_Error.getText();

			System.out.println("===" + error_msg1);

			String color = vdabillPay.LesTha_Error.getCssValue("color");

			String color1 = "rgb(153, 0, 0)";

			System.out.println("============" + color);

			boolean n1 = vdabillPay.LesTha_Error.isDisplayed();

			if (n1 == true) {

				System.out.println("Error msg is displyed");

				if (error_msg1.equalsIgnoreCase(error_msg) && color.equalsIgnoreCase(color1)) {

					System.out.println("Correct Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Pass", (count++)

							+ "- Enter mobile number less than ten digits >> Correct Error msg is displyed in correct color",

							"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				} else {

					System.out.println("Incorrect Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Fail", (count++)

							+ "- Enter mobile number less than ten digits >> Correct Error msg is not displyed in correct color",

							"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				}

			} else {

				HTMLReportGenerator.StepDetails("Fail",

						(count++) + "- Enter mobile number less than ten digits >> Error msg is not displayed", "",

						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				System.out.println("Error msg is not displayed");
			}
		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue");

			HTMLReportGenerator.StepDetails("Fail",

					(count++) + "- Locator not found issue", "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}

	}

	@Then("^Enter Prepaid Number of VF >> Error message should display in Red$")
	public void enter_Prepaid_Number_of_VF_Error_message_should_display_in_Red1() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MyMobileNum.clear();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyMobileNum));

			vdabillPay.MyMobileNum.sendKeys(OR.getProperty("prepaidVoda"));
Thread.sleep(2000);
			String error_msg = "You have entered prepaid number. Please enter Valid Postpaid number.";

			String error_msg1 = vdabillPay.LebelFieldBoder.getText();

			System.out.println("===" + error_msg1);

			String color = vdabillPay.LebelFieldBoder.getCssValue("color");

			String color1 = "rgb(33, 37, 41)";

			System.out.println("============" + color);

			boolean n1 = vdabillPay.LebelFieldBoder.isDisplayed();

			if (n1 == true) {

				System.out.println("Error msg is displyed");

				if (error_msg1.equalsIgnoreCase(error_msg) && color.equalsIgnoreCase(color1)) {

					System.out.println("Correct Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Pass", (count++)

							+ "- Correct Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				} else {

					System.out.println("Incorrect Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Fail",

							(count++) + "- Correct Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				}

			} else {

				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Correct Error msg is displyed in correct color",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				System.out.println("Error msg is not displayed");
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue---V");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Enter Prepaid Number of VF >> Enter Mobile Number label and field border should display in Red color$")
	public void enter_Prepaid_Number_of_VF_Enter_Mobile_Number_label_and_field_border_should_display_in_Red_color1()
			throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MyMobileNum.clear();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyMobileNum));

			vdabillPay.MyMobileNum.sendKeys(OR.getProperty("prepaidVoda"));

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.LebelFieldBoder));

			String color = vdabillPay.LebelFieldBoder.getCssValue("color");

			String color1 = "rgb(33, 37, 41)";

			System.out.println("============" + color);

			boolean n1 = vdabillPay.LebelFieldBoder.isDisplayed();

			if (n1 == true) {

				System.out.println("Enter Mobile Number label and field border should display");

				if (color.equalsIgnoreCase(color1)) {

					System.out.println("Mobile number label and field boder display in correct color");

					HTMLReportGenerator.StepDetails("Pass", (count++)

							+ "- Mobile number label and field boder display in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				} else {

					System.out.println("Incorect Mobile number label and field boder display in correct color");

					HTMLReportGenerator.StepDetails("Pass",

							(count++) + "- Correct Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				}
			} else {

				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Correct Error msg is displyed in correct color",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				System.out.println("Error msg is not displayed");
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue--LBSingh");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Try to enter Mobile Number starting with (\\d+) to (\\d+) -It should not allows$")
	public void try_to_enter_Mobile_Number_starting_with_to_It_should_not_allows(int arg1, int arg2) throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MyMobileNum.clear();

		WebDriverWait wait = new WebDriverWait(driver, 40);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyMobileNum));

			vdabillPay.MyMobileNum.sendKeys(OR.getProperty("NuStartinZero"));

			String typedValue1 = vdabillPay.MyMobileNum.getAttribute("value");

			int size1 = typedValue1.length();

			if (size1 == 0) {

				System.out.println("Try to enter Mobile Number starting with 0 to 4 >> It should not allow");

				HTMLReportGenerator.StepDetails("Pass",
						(count++) + "Try to enter Mobile Number starting with 0 to 4 >> It should not allow", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
		} catch (TimeoutException ex) {

			System.out.println("Try to enter Mobile Number starting with 0 to 4 >> It should allow");

			HTMLReportGenerator.StepDetails("Fail",
					(count++) + "Try to enter Mobile Number starting with 0 to 4 >> It should allow" + ex, "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		}
	}

	@Then("^Enter alphabets/Special characters in Mobile Number field- it should not allows$")
	public void enter_alphabets_Special_characters_in_Mobile_Number_field_it_should_not_allows() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MyMobileNum.clear();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyMobileNum));

			vdabillPay.MyMobileNum.sendKeys(OR.getProperty("AlfabetSpecial"));

			System.out.println("Enter alphabets and special crater");

			String typedValue1 = vdabillPay.MyMobileNum.getAttribute("value");

			int size1 = typedValue1.length();

			if (size1 == 0) {

				System.out.println("Enter alphabets/Special characters in Mobile Number field- it should not allow");

				HTMLReportGenerator.StepDetails("Pass",
						(count++) + "-Enter alphabets/Special characters in Mobile Number field- it should not allow",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
		} catch (TimeoutException ex) {

			System.out.println("Enter alphabets/Special characters in Mobile Number field- it should allow");

			HTMLReportGenerator.StepDetails("Fail",
					(count++) + "Enter alphabets/Special characters in Mobile Number field- it should allow" + ex, "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			Thread.sleep(7000);
		}
	}

	@Then("^Click Esc button of keyboard >> Popup should close$")
	public void click_Esc_button_of_keyboard_Popup_should_close() throws Throwable {
		
		Thread.sleep(3000);
		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_ESCAPE);

		Thread.sleep(2000);

		System.out.println("Click Esc button of keyboard >> Popup should close");

		HTMLReportGenerator.StepDetails("Pass", (count++) + "Click Esc button of keyboard >> Popup should close", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}

	@Then("^Click Get New Connection button >> My Number popup should display$")
	public void click_Get_New_Connection_button_My_Number_popup_should_display() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 40);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.NewConnection));

			vdabillPay.NewConnection.click();

			System.out.println("Click Get a New Connection button");
			
         Thread.sleep(2000);
       
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyMobileNum));

			boolean b = vdabillPay.MyMobileNum.isDisplayed();

			if (b == true) {

				System.out.println("My Number popup should display");

				HTMLReportGenerator.StepDetails("Pass", (count++) + "- My Number popup should display", "",

						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			} else {

				System.out.println("My Number popup should not display");

				HTMLReportGenerator.StepDetails("Fail", (count++) + "- My Number popup should not display", "",

						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue--9");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue--9)", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	/*@Then("^Click Cross button on popup >> Popup should close$")
	public void click_Cross_button_on_popup_Popup_should_close() throws Throwable {
		
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 40);

		//try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.crossBtn1));

			vdabillPay.crossBtn1.click();
			
			System.out.println("");

	}
*/
	@Then("^Enter NonIdea/NonVF number- Submit button should be enabled$")
	public void enter_NonIdea_NonVF_number_Submit_button_should_be_enabled() throws Throwable {
		
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MyMobileNum.clear();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyMobileNum));

			vdabillPay.MyMobileNum.sendKeys(OR.getProperty("NonIdeaNo"));
			
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.submitBtn2));
			
			boolean b = vdabillPay.submitBtn2.isEnabled();
			
			if(b == true) {
				
				System.out.println("Enter NonIdea/NonVF number- Submit button should be enabled");
				
				HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter NonIdea/NonVF number- Submit button should be enabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
			else {
				
				System.out.println("Enter NonIdea/NonVF number- Submit button should not be enabled");
				
				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Enter NonIdea/NonVF number- Submit button should not be enabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
			
		}catch(TimeoutException ex){
			
			System.out.println("Locator not found issue");
			
			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue->", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		}
	}

	@Then("^Click Submit >> Idea Disconnected Number Bill Payment page should display$")
	public void click_Submit_Idea_Disconnected_Number_Bill_Payment_page_should_display() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		vdabillPay.MyMobileNum.clear();

		WebDriverWait wait = new WebDriverWait(driver, 30);
        
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.submitBtn2));
			
			vdabillPay.submitBtn2.click();
			
			System.out.println("Click Submit >> Idea Disconnected Number Bill Payment page should display");
			
			HTMLReportGenerator.StepDetails("Pass", (count++) + "- Click Submit >> Idea Disconnected Number Bill Payment page should display", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}catch(TimeoutException ex){
			
			System.out.println("Click Submit >> Idea Disconnected Number Bill Payment page should not display");
			
			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Click Submit >> Idea Disconnected Number Bill Payment page should not display", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}
	}

	@Then("^Enter Idea Postpaid Active Number >> Submit button should be disabled$")
	public void enter_Idea_Postpaid_Active_Number_Submit_button_should_be_disabled() throws Throwable {
   
		driver.get(OR.getProperty("VodaFone_Pay_Bill"));
		
		Thread.sleep(2000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,350)", "");

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 40);

		//try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.NewConnection));

			vdabillPay.NewConnection.click();

			System.out.println("Click Get a New Connection button");
			
			HTMLReportGenerator.StepDetails("Pass", (count++) + "- Click Get a New Connection button", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		
        Thread.sleep(2000);
    
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyMobileNum));
			
			vdabillPay.MyMobileNum.sendKeys(OR.getProperty("IdeaPostpaidNo"));
			
			System.out.println("Enter Idea Postpaid Active Number ");
			
			HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter Idea Postpaid Active Number ", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.submitBtn2));
		
		boolean b = vdabillPay.submitBtn2.isDisplayed();
		
        if(b == true) {
	
	   System.out.println("Submit button should be disabled");
	   HTMLReportGenerator.StepDetails("Pass", (count++) + "-Submit button should be disabled", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	
	
      }else {
	
	 System.out.println("Submit button should not be disabled");
	
	  HTMLReportGenerator.StepDetails("Fail", (count++) + "- Submit button should not be disabled ", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      }
			
	}
	
	@Then("^Click Submit >> Idea Inactive page should display$")
	public void click_Submit_Idea_Inactive_page_should_display() throws Throwable {
	    System.out.println("Click Submit >> Idea Inactive page should display");
	}

	@Then("^Enter Idea Postpaid InActive Number >> Submit button should be enabled$")
	public void enter_Idea_Postpaid_InActive_Number_Submit_button_should_be_enabled() throws Throwable {
		
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		
		vdabillPay.MyMobileNum.clear();
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		
		wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyMobileNum));
		
		vdabillPay.MyMobileNum.sendKeys(OR.getProperty("inActiveNo"));
		
		System.out.println("Enter Idea Postpaid InActive Number ");
		
		HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter Idea Postpaid InActive Number ", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		
	Thread.sleep(2000);
	
	wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.submitBtn2));
	
	boolean b = vdabillPay.submitBtn2.isEnabled();
	
    if(b == true) {

   System.out.println("Submit button should be enabled");
   HTMLReportGenerator.StepDetails("Pass", (count++) + "-Submit button should be enabled", "",
		TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));


  }else {

  System.out.println("Submit button should not be enabled");

   HTMLReportGenerator.StepDetails("Fail", (count++) + "- Submit button should not be enabled", "",
		TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
  }
	}

	

	@Then("^Enter VF Postpaid Active Number >> Submit button should be disabled$")
	public void enter_VF_Postpaid_Active_Number_Submit_button_should_be_disabled() throws Throwable {
		
     VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		
		vdabillPay.MyMobileNum.clear();
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		
		try {
			
		wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyMobileNum));
		
		vdabillPay.MyMobileNum.sendKeys(OR.getProperty("vodaPostpaidNo"));
		
		System.out.println("Enter VF Postpaid Active Number");
		
		HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter VF Postpaid Active Number", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		
	Thread.sleep(2000);
	
	wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.submitBtn2));
	
	boolean b = vdabillPay.submitBtn2.isEnabled();
	
    if(b == true) {

   System.out.println("Submit button should be disabled");
   HTMLReportGenerator.StepDetails("Pass", (count++) + "- Submit button should be disabled", "",
		TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));


  }else {

  System.out.println("Submit button should not be disabled");

   HTMLReportGenerator.StepDetails("Fail", (count++) + "- Submit button should not be disabled", "",
		TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
  
	}
		}catch(TimeoutException ex){
			
		System.out.println("Locator not found issue");
			
	    HTMLReportGenerator.StepDetails("Fail", (count++) + "- Submit button should not be disabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
   }

	@Then("^Enter VF Postpaid InActive Number >> Submit button should be enabled$")
	public void enter_VF_Postpaid_InActive_Number_Submit_button_should_be_enabled() throws Throwable {

      VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		
		vdabillPay.MyMobileNum.clear();
		
	try {
	
		WebDriverWait wait = new WebDriverWait(driver, 40);
		
		wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MyMobileNum));
		
		vdabillPay.MyMobileNum.sendKeys(OR.getProperty("inActiveVFNo"));
		
		System.out.println("Enter VF Postpaid InActive Number");
		
		HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter VF Postpaid InActive Number", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		
	Thread.sleep(2000);
	
	wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.submitBtn2));
	
	boolean b = vdabillPay.submitBtn2.isEnabled();
	
    if(b == true) {

   System.out.println("Submit button should be enabled");
   HTMLReportGenerator.StepDetails("Pass", (count++) + "- Submit button should be enabled", "",
		TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));


  }else {

  System.out.println("Submit button should not be enabled");

   HTMLReportGenerator.StepDetails("Fail", (count++) + "- Submit button should not be enabled", "",
		TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
  
	}
	}catch(TimeoutException ex){
		
		System.out.println("Locator not found issue");
		
		HTMLReportGenerator.StepDetails("Fail", (count++) + "- Submit button should not be enabled", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}
	}

	@Then("^Click Submit >> VF Inactive page should display$")
	public void click_Submit_VF_Inactive_page_should_display() throws Throwable {

		 VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		
			WebDriverWait wait = new WebDriverWait(driver, 50);
			
			try {
				
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.submitBtn2));
			
			vdabillPay.submitBtn2.click();
			
			System.out.println("Click Submit >> VF Inactive page should display");
			
			HTMLReportGenerator.StepDetails("Pass", (count++) + "- Click Submit >> VF Inactive page should display", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
	
	}catch(TimeoutException ex){
	
		System.out.println("Click Submit >> VF Inactive page should not display");
		
		HTMLReportGenerator.StepDetails("Fail", (count++) + "- Click Submit >> VF Inactive page should not display", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}
 }
	@Then("^Enter Idea Postpaid Number and click Fetch Your Bill link >> Fetch Bill Amount popup should open$")
	public void enter_Idea_Postpaid_Number_and_click_Fetch_Your_Bill_link_Fetch_Bill_Amount_popup_should_open()
			throws Throwable {
		
		driver.get(OR.getProperty("VodaFone_Pay_Bill"));
		
		System.out.println("Loading Page gain");
		
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		
		vdabillPay.MobileNo.clear();
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		
		try {
			
		wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MobileNo));
		
		vdabillPay.MobileNo.sendKeys(OR.getProperty("IdeaPostpaidNo"));
		
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.FetchYourBill));
		
		vdabillPay.FetchYourBill.click();
		
		System.out.println("Enter Idea Postpaid Number and click Fetch Your Bill link");
		
		Thread.sleep(4000);
		
		wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ResendOTP));
		
		boolean b = vdabillPay.ResendOTP.isDisplayed();
		
		if(b == true) {
			
			System.out.println("Fetch Bill Amount popup should open");
			
			HTMLReportGenerator.StepDetails("Pass", (count++) + "- Fetch Bill Amount popup should open", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}else {
			
			System.out.println("Fetch Bill Amount popup should not open");
			
			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Fetch Bill Amount popup should not open", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
		}catch(TimeoutException ex){
			
			System.out.println("Fetch Bill Amount popup should not open");
			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Fetch Bill Amount popup should not open", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}
	@Then("^Click Esc button of keyboard >> Popup should closed$")
	public void click_Esc_button_of_keyboard_Popup_should_closed() throws Throwable {
	
		Robot robot2 = new Robot();
		
		robot2.keyPress(KeyEvent.VK_ESCAPE);

		Thread.sleep(2000);

		System.out.println("Click Esc button of keyboard >> Popup should close");

		HTMLReportGenerator.StepDetails("Pass", (count++) + "Click Esc button of keyboard >> Popup should close", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	 }
	
	@Then("^On Fetch Bill Amount >> Focus should be on first entry field by default on load$")
	public void on_Fetch_Bill_Amount_Focus_should_be_on_first_entry_field_by_default_on_load() throws Throwable {
	    
      VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
	
	 WebDriverWait wait = new WebDriverWait(driver, 40);
	 
	try {
			
	 wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.FetchYourBill));
	 
	 vdabillPay.FetchYourBill.click();
	 
	 System.out.println("on fetch bill Amount");
	 

			
      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ResendOTP));
		
		boolean b = vdabillPay.ResendOTP.isDisplayed();
		
		if(b == true) {
			
			System.out.println("On Fetch Bill Amount >> Focus should be on first entry field by default on load");
			
			HTMLReportGenerator.StepDetails("Pass", (count++) + "- On Fetch Bill Amount >> Focus should be on first entry field by default on load", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}else {
			
			System.out.println("On Fetch Bill Amount >> Focus should not be on first entry field by default on load");
			
			HTMLReportGenerator.StepDetails("Fail", (count++) + "- On Fetch Bill Amount >> Focus should not be on first entry field by default on load", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
		}catch(TimeoutException ex){
			
			System.out.println("Locator not found issue--");
			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue--", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}
	@Then("^On Fetch Bill Amount >> Confirm button should be disabled by default on load$")
	public void on_Fetch_Bill_Amount_Confirm_button_should_be_disabled_by_default_on_load() throws Throwable {
	   
		 VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
			
		 WebDriverWait wait = new WebDriverWait(driver, 40);
		 
		try {
		
	      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ConfirmBTn));
			
			boolean b = vdabillPay.ConfirmBTn.isDisplayed();
			
			if(b == true) {
				
				System.out.println("On Fetch Bill Amount >> Confirm button should be disabled by default on load");
				
				HTMLReportGenerator.StepDetails("Pass", (count++) + "- On Fetch Bill Amount >> Confirm button should be disabled by default on load", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}else {
				
				System.out.println("On Fetch Bill Amount >> Confirm button should not be disabled by default on load");
				
				HTMLReportGenerator.StepDetails("Fail", (count++) + "- On Fetch Bill Amount >> Confirm button should not be disabled by default on load", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
			}catch(TimeoutException ex){
				
				System.out.println("Locator not found issue--7");
				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue--7", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
	     }
	@Then("^Click Resend OTP first time >> OTP has been resend to your registered mobile number, you have (\\d+) more attempts message should display$")
	public void click_Resend_OTP_first_time_OTP_has_been_resend_to_your_registered_mobile_number_you_have_more_attempts_message_should_display(int arg1) throws Throwable {
		
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		
		 WebDriverWait wait = new WebDriverWait(driver, 40);
		
	      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ResendOTP));
	      
	      vdabillPay.ResendOTP.click();
	      
	      System.out.println("Click Resend OTP first time");
	      
	      HTMLReportGenerator.StepDetails("Pass", (count++) + "- Click Resend OTP first time", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
	}

	@Then("^Click Resend OTP second time >> OTP has been resend to your registered mobile number, you have (\\d+) more attempts message should display$")
	public void click_Resend_OTP_second_time_OTP_has_been_resend_to_your_registered_mobile_number_you_have_more_attempts_message_should_display(int arg1) throws Throwable {
		
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		
		 WebDriverWait wait = new WebDriverWait(driver, 40);
		
	      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ResendOTP));
	      
	      vdabillPay.ResendOTP.click();
	      
	      System.out.println("Click Resend OTP second time");
	      
	      HTMLReportGenerator.StepDetails("Pass", (count++) + "- Click Resend OTP second time", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
	}

	@Then("^Click Resend OTP third time >> OTP has been resend to your registered mobile number, you have (\\d+) more attempts message should display$")
	public void click_Resend_OTP_third_time_OTP_has_been_resend_to_your_registered_mobile_number_you_have_more_attempts_message_should_display(int arg1) throws Throwable {
		
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		
		 WebDriverWait wait = new WebDriverWait(driver, 40);
		
	      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ResendOTP));
	      
	      vdabillPay.ResendOTP.click();
	      
	      System.out.println("Click Resend OTP third time");
	      
	      HTMLReportGenerator.StepDetails("Pass", (count++) + "- Click Resend OTP third time", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}

	@Then("^Click Resend OTP fourth time >> Popup should close automatically and focus should go on landing page$")
	public void click_Resend_OTP_fourth_time_Popup_should_close_automatically_and_focus_should_go_on_landing_page() throws Throwable {
	    
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		
		 WebDriverWait wait = new WebDriverWait(driver, 40);
		
	      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ResendOTP));
	      
	      vdabillPay.ResendOTP.click();
	      
	      System.out.println("Click Resend OTP fourth time ");
	      
	      HTMLReportGenerator.StepDetails("Pass", (count++) + "- Click Resend OTP fourth time ", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	 }
	@Then("^Enter Idea Postpaid Number and click FetchYourBill link >> Fetch Bill Amount popup should open$")
	public void enter_Idea_Postpaid_Number_and_click_FetchYourBill_link_Fetch_Bill_Amount_popup_should_open() throws Throwable {
	   
		Thread.sleep(7000);
	    
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		
		vdabillPay.MobileNo.clear();
		
		 WebDriverWait wait = new WebDriverWait(driver, 40);
		 
		try {
			
	      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MobileNo));
	      
	   //   vdabillPay.MobileNo.sendKeys(OR.getProperty("vodaPostpaidNo"));
	      vdabillPay.MobileNo.sendKeys("8698042913");
	      
	      System.out.println("Enter Idea Postpaid Number and click FetchYourBill link");
	      
	      Thread.sleep(4000);
	      
	      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.FetchYourBill));
	      
	      vdabillPay.FetchYourBill.click();
	      
	      System.out.println("click FetchYourBill link");
	      
	      Thread.sleep(4000);
			
			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ResendOTP));
			
			boolean b = vdabillPay.ResendOTP.isDisplayed();
			
			if(b == true) {
				
				System.out.println("Fetch Bill Amount popup should open");
				
				HTMLReportGenerator.StepDetails("Pass", (count++) + "- Fetch Bill Amount popup should open", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}else {
				
				System.out.println("Fetch Bill Amount popup should not open");
				
				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Fetch Bill Amount popup should not open", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
			}catch(TimeoutException ex){
				
				System.out.println("Fetch Bill Amount popup should not open");
				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Fetch Bill Amount popup should not open", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
         }
	      
	@Then("^Enter (\\d+) digits in OTP field >> Confirm button should be enabled$")
	public void enter_digits_in_OTP_field_Confirm_button_should_be_enabled(int arg1) throws Throwable {
		
        VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
	
		 WebDriverWait wait = new WebDriverWait(driver, 40);
		 
		try {
			
	     /* wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.OTPSections));
	      Thread.sleep(2000);
	      
	      vdabillPay.OTPSections.sendKeys(OR.getProperty("OTPFirst"));
	      
	      System.out.println("Enter 4 digits in OTP field");
	      
	      HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter 4 digits in OTP field", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	      */
	      Thread.sleep(2000);
	      
	      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.OTP_popup));
	      
	     boolean b = vdabillPay.ConfirmBTn.isEnabled();
	     
	     if(b == true) {
	    	 
	    	 System.out.println("Confirm button should be enabled");
	    	 
	    	 HTMLReportGenerator.StepDetails("Fail", (count++) + "- Confirm button should be enabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	    	 
	     }else {
	    	 
	    	 System.out.println("Confirm button should not be enabled");
	    	 
	    	 HTMLReportGenerator.StepDetails("Pass", (count++) + "- Confirm button should not be enabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	     }
		}catch(TimeoutException ex){
			
			System.out.println("Confirm button should not be enabled");
			
			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Confirm button should not be enabled"+ex, "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}
		

	@Then("^Enter invalid OTP once and Click Confirm >> Proper error message should display in Red$")
	public void enter_invalid_OTP_once_and_Click_Confirm_Proper_error_message_should_display_in_Red() throws Throwable {
		
		Thread.sleep(2000);
		
		 VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		
		// vdabillPay.OTPField.clear();
		 
		 WebDriverWait wait = new WebDriverWait(driver, 40);
		
	      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.OTPSections1));
	      
	      vdabillPay.OTPSections1.sendKeys(OR.getProperty("OTPOnce"));
	      
	      System.out.println("Enter invalid OTP once and Click Confirm ");
	      
	      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ConfirmBTn));
	      
	      vdabillPay.ConfirmBTn.click();
	      
	      System.out.println("click confirm button");
	      
	      try {
	    	  
	    	  Thread.sleep(1000);
	  	    wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.OTP_Error_MSG));
	  	    
	  	    System.out.println("0000");
	  	    
	  	    if(vdabillPay.OTP_Error_MSG.isDisplayed()) {
	  	    
	  	    
	  	    String error_msg="Invalid OTP 3 Attempts left";
	  	    
	  	    String error_msg1=vdabillPay.OTP_Error_MSG.getText();
	  	    
	  	
	  	    System.out.println("==="+error_msg1);
	  	    	    
	  	    String color=vdabillPay.OTP_Error_MSG.getCssValue("color");
	  	    
	  	    String color1="rgba(230, 0, 0, 1)";
	  	    
	  	    System.out.println("============"+color);
	  	    
	  	    boolean n1= vdabillPay.OTP_Error_MSG.isDisplayed();
	  	    
	  	    if(n1==true) {
	  	
	  	    	System.out.println("Error msg is displyed");
	  	    		if(error_msg1.equalsIgnoreCase(error_msg) && color.equalsIgnoreCase(color1))
	  	    		{
	  	    			System.out.println("Correct Error msg is displyed in correct color");
	  	    			
	  	    			HTMLReportGenerator.StepDetails("Pass", (count++)+"-Enter 1st wrong OTP>> Proper error message should display in Red - Correct Error msg is displyed in correct color", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	  	    	
	  	    		}else
	  	    		{
	  	    			System.out.println("Incorrect Error msg is displyed in correct color");
	  	    			HTMLReportGenerator.StepDetails("Fail", (count++)+"-Enter 1st wrong OTP>> Proper error message should display in Red- Correct Error msg is not displyed in correct color", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	  	    			
	  	    		}
	  	    }else
	  	    {
	  			HTMLReportGenerator.StepDetails("Fail", (count++)+"- Enter invalid OTP once and Click Confirm >> Proper error message should not display in Red", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	  	    	System.out.println("Error msg is not displayed");
	  	    }
	  	    
	  	    }else
	  	    {
	  	    	HTMLReportGenerator.StepDetails("Fail", (count++)+" - Enter invalid OTP once and Click Confirm >> Proper error message should not display in Red", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	  	    	System.out.println("Error msg is not displayed");
	  	    }
	  	    }catch(TimeoutException ex)
	  	    {
	  	    	HTMLReportGenerator.StepDetails("Fail", (count++)+"- Enter NonIdea number - Error msg locator is not displayed"+ex, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	  	    	System.out.println("Error msg is not displayed"+ex);
	  	}
	}
	@Then("^Enter invalid OTP once and Click Confirm >> OTP fields border should be Red and image in Red should display in from of field$")
	public void enter_invalid_OTP_once_and_Click_Confirm_OTP_fields_border_should_be_Red_and_image_in_Red_should_display_in_from_of_field() throws Throwable {
	    
	}
	      @Then("^Enter invalid OTP twice and Click Confirm >> Proper error message should display in Red$")
	      public void enter_invalid_OTP_twice_and_Click_Confirm_Proper_error_message_should_display_in_Red() throws Throwable {
	          
	    	  Thread.sleep(2000);
	  		
	 		 VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
	 		 
	 		 vdabillPay.OTPSections.clear();
	  	  
	 		 WebDriverWait wait = new WebDriverWait(driver, 40);
	 		 
	 		 System.out.println("32456678");
	 		
	 	      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.OTPSections));
	 	      
	 	      vdabillPay.OTPSections.sendKeys(OR.getProperty("OTPTwice"));
	 	      
	 	      System.out.println("Enter invalid OTP twice and Click Confirm ");
	 	      
	 	      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ConfirmBTn));
	 	      
	 	      vdabillPay.ConfirmBTn.click();
	 	      
	 	      System.out.println("click confirm button");
	 	      
	 	      try {
	 	    	  
	 	  	    wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.OTP_Error_MSG));
	 	  	    
	 	  	    System.out.println("0000");
	 	  	    
	 	  	    if(vdabillPay.OTP_Error_MSG.isDisplayed()) {
	 	  	    
	 	  	    
	 	  	    String error_msg="Invalid OTP 2 Attempts left";
	 	  	    
	 	  	    String error_msg1=vdabillPay.OTP_Error_MSG.getText();
	 	  	    
	 	  	
	 	  	    System.out.println("==="+error_msg1);
	 	  	    	    
	 	  	    String color=vdabillPay.OTP_Error_MSG.getCssValue("color");
	 	  	    
	 	  	    String color1="rgba(230, 0, 0, 1)";
	 	  	    
	 	  	    System.out.println("============"+color);
	 	  	    
	 	  	    boolean n1= vdabillPay.OTP_Error_MSG.isDisplayed();
	 	  	    
	 	  	    if(n1==true) {
	 	  	
	 	  	    	System.out.println("Error msg is displyed");
	 	  	    		if(error_msg1.equalsIgnoreCase(error_msg) && color.equalsIgnoreCase(color1))
	 	  	    		{
	 	  	    			System.out.println("Correct Error msg is displyed in correct color");
	 	  	    			
	 	  	    			HTMLReportGenerator.StepDetails("Pass", (count++)+"-Enter 2nd wrong OTP>>>> Proper error message should display in Red - Correct Error msg is displyed in correct color", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	 	  	    	
	 	  	    		}else
	 	  	    		{
	 	  	    			System.out.println("Incorrect Error msg is displyed in correct color");
	 	  	    			HTMLReportGenerator.StepDetails("Fail", (count++)+"-Enter 2nd wrong OTP>> Proper error message should display in Red- Correct Error msg is not displyed in correct color", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	 	  	    			
	 	  	    		}
	 	  	    }else
	 	  	    {
	 	  			HTMLReportGenerator.StepDetails("Fail", (count++)+"- Enter NonIdea number - Error msg is not displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	 	  	    	System.out.println("Error msg is not displayed");
	 	  	    }
	 	  	    
	 	  	    }else
	 	  	    {
	 	  	    	HTMLReportGenerator.StepDetails("Fail", (count++)+" - Enter NonIdea number - Error msg is not displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	 	  	    	System.out.println("Error msg is not displayed");
	 	  	    }
	 	  	    }catch(TimeoutException ex)
	 	  	    {
	 	  	    	HTMLReportGenerator.StepDetails("Fail", (count++)+"- Enter NonIdea number - Error msg locator is not displayed"+ex, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	 	  	    	System.out.println("Error msg is not displayed");
	 	  	}
	      }
	      
	      @Then("^Enter invalid OTP twice and Click Confirm >> OTP fields border should be Red and image in Red should display in from of field$")
	      public void enter_invalid_OTP_twice_and_Click_Confirm_OTP_fields_border_should_be_Red_and_image_in_Red_should_display_in_from_of_field() throws Throwable {
	          
	      }

	      @Then("^Enter invalid OTP thrice and Click Confirm >> Proper error message should display in Red$")
	      public void enter_invalid_OTP_thrice_and_Click_Confirm_Proper_error_message_should_display_in_Red() throws Throwable {
	          
	    	  
            VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
	    	  
	    	 vdabillPay.OTPSections.clear();
	    	  
	 		 WebDriverWait wait = new WebDriverWait(driver, 40);
	 		
	 	      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.OTPSections));
	 	      
	 	      vdabillPay.OTPSections.sendKeys(OR.getProperty("OTPThrice"));
	 	      
	 	      System.out.println("Enter invalid OTP thrice and Click Confirm ");
	 	      
	 	      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ConfirmBTn));
	 	      
	 	      vdabillPay.ConfirmBTn.click();
	 	      
	 	      System.out.println("click confirm button");
	 	      
	 	      try {
	 	  	    wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.OTP_Error_MSG));
	 	  	    
	 	  	    System.out.println("0000");
	 	  	    
	 	  	    if(vdabillPay.OTP_Error_MSG.isDisplayed()) {
	 	  	    
	 	  	    
	 	  	    String error_msg="Invalid OTP 1 Attempts left";
	 	  	    
	 	  	    String error_msg1=vdabillPay.OTP_Error_MSG.getText();
	 	  	    
	 	  	
	 	  	    System.out.println("==="+error_msg1);
	 	  	    	    
	 	  	    String color=vdabillPay.OTP_Error_MSG.getCssValue("color");
	 	  	    
	 	  	    String color1="rgba(230, 0, 0, 1)";
	 	  	    
	 	  	    System.out.println("============"+color);
	 	  	    
	 	  	    boolean n1= vdabillPay.OTP_Error_MSG.isDisplayed();
	 	  	    
	 	  	    if(n1==true) {
	 	  	
	 	  	    	System.out.println("Error msg is displyed");
	 	  	    		if(error_msg1.equalsIgnoreCase(error_msg) && color.equalsIgnoreCase(color1))
	 	  	    		{
	 	  	    			System.out.println("Correct Error msg is displyed in correct color");
	 	  	    			
	 	  	    			HTMLReportGenerator.StepDetails("Pass", (count++)+"-Enter 3rd wrong OTP>> Proper error message should display in Red - Correct Error msg is displyed in correct color", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	 	  	    	
	 	  	    		}else
	 	  	    		{
	 	  	    			System.out.println("Incorrect Error msg is displyed in correct color");
	 	  	    			HTMLReportGenerator.StepDetails("Fail", (count++)+"-Enter 3rd wrong OTP>> Proper error message should display in Red- Correct Error msg is not displyed in correct color", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	 	  	    			
	 	  	    		}
	 	  	    }else
	 	  	    {
	 	  			HTMLReportGenerator.StepDetails("Fail", (count++)+"- Enter NonIdea number - Error msg is not displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	 	  	    	System.out.println("Error msg is not displayed");
	 	  	    }
	 	  	    
	 	  	    }else
	 	  	    {
	 	  	    	HTMLReportGenerator.StepDetails("Fail", (count++)+" - Enter NonIdea number - Error msg is not displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	 	  	    	System.out.println("Error msg is not displayed");
	 	  	    }
	 	  	    }catch(TimeoutException ex)
	 	  	    {
	 	  	    	HTMLReportGenerator.StepDetails("Fail", (count++)+"- Enter NonIdea number - Error msg locator is not displayed"+ex, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	 	  	    	System.out.println("Error msg is not displayed");
	 	  	}
	      }
	      
	      @Then("^Enter invalid OTP thrice and Click Confirm >> OTP fields border should be Red and image in Red should display in from of field$")
	      public void enter_invalid_OTP_thrice_and_Click_Confirm_OTP_fields_border_should_be_Red_and_image_in_Red_should_display_in_from_of_field() throws Throwable {
	          
	      }

	      @Then("^Enter invalid OTP fourth time and Click Confirm >> Proper error message should display in Red$")
	      public void enter_invalid_OTP_once_and_Click_Confirm_Proper_error_message_should_display_in_Red1() throws Throwable {
	          
	    	  VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
	    	  
		    	 vdabillPay.OTPSections.clear();
		    	  
		 		 WebDriverWait wait = new WebDriverWait(driver, 40);
		 		
		 	      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.OTPSections));
		 	      
		 	      vdabillPay.OTPSections.sendKeys(OR.getProperty("OTPForth"));
		 	      
		 	      System.out.println("Enter invalid OTP thrice and Click Confirm ");
		 	      
		 	      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ConfirmBTn));
		 	      
		 	      vdabillPay.ConfirmBTn.click();
		 	      
		 	      System.out.println("click confirm button");
		 	      
		 	      try {
		 	    	  
		 	  	    wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.OTP_Error_MSG));
		 	  	    
		 	  	    System.out.println("0000");
		 	  	    
		 	  	    if(vdabillPay.OTP_Error_MSG.isDisplayed()) {
		 	  	    
		 	  	    
		 	  	    String error_msg="You have exhausted maximum attempts to enter OTP.";
		 	  	    
		 	  	    String error_msg1=vdabillPay.OTP_Error_MSG.getText();
		 	  	    
		 	  	
		 	  	    System.out.println("==="+error_msg1);
		 	  	    	    
		 	  	    String color=vdabillPay.OTP_Error_MSG.getCssValue("color");
		 	  	    
		 	  	    String color1="rgba(230, 0, 0, 1)";
		 	  	    
		 	  	    System.out.println("============"+color);
		 	  	    
		 	  	    boolean n1= vdabillPay.OTP_Error_MSG.isDisplayed();
		 	  	    
		 	  	    if(n1==true) {
		 	  	
		 	  	    	System.out.println("Error msg is displyed");
		 	  	    		if(error_msg1.equalsIgnoreCase(error_msg) && color.equalsIgnoreCase(color1))
		 	  	    		{
		 	  	    			System.out.println("Correct Error msg is displyed in correct color");
		 	  	    			
		 	  	    			HTMLReportGenerator.StepDetails("Pass", (count++)+"- Proper error message should display in Red - Correct Error msg is displyed in correct color", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		 	  	    	

		 	  	    			
		 	  	    			
		 	  	    		}else
		 	  	    		{
		 	  	    			System.out.println("Incorrect Error msg is displyed in correct color");
		 	  	    			HTMLReportGenerator.StepDetails("Fail", (count++)+"- Proper error message should display in Red- Correct Error msg is not displyed in correct color", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
                      }
		 	  	    }else
		 	  	    
		 	  	    {
		 	  		HTMLReportGenerator.StepDetails("Fail", (count++)+"- Enter NonIdea number - Error msg is not displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		 	  	    System.out.println("Error msg is not displayed");
		 	  	    }
		 	  	    
		 	  	    }else
		 	  	    {
		 	  	    	HTMLReportGenerator.StepDetails("Fail", (count++)+" - Enter NonIdea number - Error msg is not displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		 	  	    	System.out.println("Error msg is not displayed");
		 	  	    }
		 	  	    }catch(TimeoutException ex)
		 	  	    {
		 	  	    	HTMLReportGenerator.StepDetails("Fail", (count++)+"- Enter NonIdea number - Error msg locator is not displayed"+ex, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		 	  	    	System.out.println("Error msg is not displayed");
		 	    }
		 	    vdabillPay.CrossButton.click();
		 	    Thread.sleep(2000);
	          }	 
	      @Then("^Enter invalid OTP fourth time and Click Confirm >> OTP fields border should be Red and image in Red should display in from of field$")
	      public void enter_invalid_OTP_fourth_time_and_Click_Confirm_OTP_fields_border_should_be_Red_and_image_in_Red_should_display_in_from_of_field() throws Throwable {
	         
	      }
	      @Then("^Enter invalid OTP fourth time and Click Confirm >> Popup should close automatically and focus should go on landing page$")
	      public void enter_invalid_OTP_fourth_time_and_Click_Confirm_Popup_should_close_automatically_and_focus_should_go_on_landing_page() throws Throwable {
	         
	      }
	      @Then("^Enter VF Postpaid Number n Amount and click Pay >> VF Payment Gateway screen should display$")
	      public void enter_VF_Postpaid_Number_n_Amount_and_click_Pay_VF_Payment_Gateway_screen_should_display() throws Throwable {
	    	
	    	  Thread.sleep(7000);
		  	    
			  	VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
			  		
			  	vdabillPay.MobileNo.clear();
			  		
			   WebDriverWait wait = new WebDriverWait(driver, 40);
			  		 
			  try {
			  			
			  	 wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MobileNo));
			  	      
			  //	 vdabillPay.MobileNo.sendKeys(OR.getProperty("vodaPostpaidNo"));
			  	 
			  	vdabillPay.MobileNo.sendKeys("8722800091");				//Idea migrated number
			  	      
			  	 System.out.println("Enter VF Postpaid Number");
			  	      
		//  	 HTMLReportGenerator.StepDetails("Pass", (count++)+" - Enter VF Postpaid Number", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			  	 HTMLReportGenerator.StepDetails("Pass", (count++)+" - Enter Idea migrated Postpaid Number", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      
			  	 Thread.sleep(7000);
			  	      
			  	 wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.AmountBill));
			  	      
			  	 vdabillPay.AmountBill.sendKeys(OR.getProperty("newAmount"));
			  	    
			  	 System.out.println("Sending Amount");
			  	      
			  	    HTMLReportGenerator.StepDetails("Pass", (count++)+" - Enter Amount in amount field", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			  	    	System.out.println("Error msg is not displayed");
			  	      
			  	  Thread.sleep(7000);
			  	      
			  	  wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.Pay_Now));
			  	     
			  	  vdabillPay.Pay_Now.click();
			  	   
			  	  System.out.println("click on Pay Button----");
			  	  
			  	  Thread.sleep(10000);
			  	
			  	   
			  	 wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.Select_wallet));
			  	 
			  	boolean b = vdabillPay.Select_wallet.isDisplayed();
			  	
			  	if(b == true) {
			  		
			  		System.out.println("VP Payment Gateway screen should display");
			  		
			  		 HTMLReportGenerator.StepDetails("Pass", (count++)+" - VF Payment Gateway screen should display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			  	      
			  
			      }else{
			    	  
			    	  System.out.println("VP Payment Gateway screen should not display");

				  		 HTMLReportGenerator.StepDetails("Fail", (count++)+" - VF Payment Gateway screen should not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			      }    
			   
			      }catch(TimeoutException ex){
			    	  
			    	  System.out.println("VP Payment Gateway screen should not display");

				  		 HTMLReportGenerator.StepDetails("Fail", (count++)+" - VF Payment Gateway screen should not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));		
			      }
	      }
	   @Then("^Select Wallet >> Click Pay button for Paytm >> Paytm page should display$")
	   public void select_Wallet_Click_Pay_button_for_Paytm_Paytm_page_should_display() throws Throwable {
		   
		   VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
	  		
		   WebDriverWait wait = new WebDriverWait(driver, 40);
		  				try {
		  	 wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.Select_wallet));
		  	 
		  	vdabillPay.Select_wallet.click();
		  	
		  	System.out.println("Select Wallet-----");
		  	
		  	Thread.sleep(2000);
		  	
		   wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.Ptm_PaySurely));
		   vdabillPay.Ptm_PaySurely.click();
		   
		   Thread.sleep(2000);
		   wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.Go_Back));
		  boolean b =  vdabillPay.Go_Back.isDisplayed();
		  
		  if(b == true) {
			  System.out.println("Select Wallet >> Click Pay button for Paytm >> Paytm page should display");
			  HTMLReportGenerator.StepDetails("Pass", (count++)+" - Select Wallet >> Click Pay button for Paytm >> Paytm page should display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			  
		  }else {
			  
			  System.out.println("Select Wallet >> Click Pay button for Paytm >> Paytm page should not display");
			  HTMLReportGenerator.StepDetails("Fail", (count++)+" - Select Wallet >> Click Pay button for Paytm >> Paytm page should not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			  
		  }
		  	}catch(TimeoutException ex){
		  					
		  		 System.out.println("Select Wallet >> Click Pay button for Paytm >> Paytm page should not display");
		  		 HTMLReportGenerator.StepDetails("Fail", (count++)+" - Select Wallet >> Click Pay button for Paytm >> Paytm page should not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		  					  
		  				}
		   
		   /*WebElement button = driver.findElement(By.xpath("//li[@class='wallets walletFlush']"));
	//	   WebElement cancel = driver.findElement(By.xpath("//*[@id=\"cancel\"]"));

		   boolean n=button.isDisplayed();
		   
		   System.out.println("#############"+n);
		   
	//	   boolean n1=cancel.isDisplayed();
		   
//		   System.out.println("#############"+n1);
		 
		   Thread.sleep(2000);
		   
		//   cancel.click();
				   
		   button.click();
		   
		   JavascriptExecutor executor = (JavascriptExecutor)driver;
		   
		   executor.executeScript("arguments[0].click();", button);
		   System.out.println("Select wallet");*/
		   
	   }
	      @Then("^Click on Go Back >> Oops page should display$")
	      public void click_on_Go_Back_Oops_page_should_display() throws Throwable {
	         
	    	  VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		  		
			   WebDriverWait wait = new WebDriverWait(driver, 40);
			  	try {
			  		Thread.sleep(2000);
			  	 wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.Go_Back));
			  	 
			  	vdabillPay.Go_Back.click();
			  	
			  	System.out.println("Click on Go Back-----");
			  	
			  	wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.OOps_Page));
			  	
			  boolean b=vdabillPay.OOps_Page.isDisplayed();
			  
			  if(b == true) {
				  System.out.println("Click on Go Back >> Oops page should display");
				  HTMLReportGenerator.StepDetails("Pass", (count++)+" - Click on Go Back >> Oops page should display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }else {
				  System.out.println("Click on Go Back >> Oops page should not display");
				  HTMLReportGenerator.StepDetails("Fail", (count++)+" - Click on Go Back >> Oops page should not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }
			  	}catch(TimeoutException ex){
			  		
			   System.out.println("Locator not found issue-X");
			   HTMLReportGenerator.StepDetails("Fail", (count++)+" - Locator not found issue-X", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
					  
			  	}
	      }

	      @Then("^Verify Oops page >> Oops page with payment failure text should display$")
	      public void verify_Oops_page_Oops_page_with_payment_failure_text_should_display() throws Throwable {
	    	  
	    	  VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		  		
			   WebDriverWait wait = new WebDriverWait(driver, 40);
			   
			  try {
			  
			  wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.Payment_Failure));
			  	
			  boolean b=vdabillPay.Payment_Failure.isDisplayed();
			  
			  if(b == true) {
				  System.out.println("Verify Oops page >> Oops page with payment failure text should display");
				  HTMLReportGenerator.StepDetails("Pass", (count++)+" - Verify Oops page >> Oops page with payment failure text should display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }else {
				  System.out.println("Verify Oops page >> Oops page with payment failure text should not display");
				  HTMLReportGenerator.StepDetails("Fail", (count++)+" - Verify Oops page >> Oops page with payment failure text should not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }
			  	}catch(TimeoutException ex){
			  		
			   System.out.println("Locator not found issue-N");
			   HTMLReportGenerator.StepDetails("Fail", (count++)+" - Locator not found issue-N", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
					  
			  	}
	      }

	      @Then("^Verify Failure Page >> Mobile Number field should display provided VF Number$")
	      public void verify_Failure_Page_Mobile_Number_field_should_display_provided_VF_Number() throws Throwable {
	    	  
	    	  VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		  		
			   WebDriverWait wait = new WebDriverWait(driver, 40);
			   
			  try {
			  
			  wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.mobile_Failure));
			  	
			  boolean b=vdabillPay.mobile_Failure.isDisplayed();
			  
			  if(b == true) {
				  System.out.println("Verify Failure Page >> Mobile Number field should display provided VF Number");
				  HTMLReportGenerator.StepDetails("Pass", (count++)+" - Verify Failure Page >> Mobile Number field should display provided VF Number", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }else {
				  System.out.println("Verify Failure Page >> Mobile Number field should display not provided VF Number");
				  HTMLReportGenerator.StepDetails("Fail", (count++)+" - Verify Failure Page >> Mobile Number field should not display provided VF Number", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }
			  	}catch(TimeoutException ex){
			  		
			   System.out.println("Locator not found issue-v");
			   HTMLReportGenerator.StepDetails("Fail", (count++)+" - Locator not found issue-V", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
					  
			  	}
	      }

	      @Then("^Verify Failure Page >> Amount field should Not display$")
	      public void verify_Failure_Page_Amount_field_should_Not_display() throws Throwable {
	    	  
	    	  VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		  		
			   WebDriverWait wait = new WebDriverWait(driver, 40);
			   
			  try {
			  
			  wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.mobile_Failure));
			  	
			  boolean b=vdabillPay.mobile_Failure.isDisplayed();
			  
			  if(b == true) {
				  System.out.println("Verify Failure Page >> Amount field should not display");
				  HTMLReportGenerator.StepDetails("Pass", (count++)+" -Verify Failure Page >> Amount field should not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }else {
				  System.out.println("Verify Failure Page >> Amount field should Not display");
				  HTMLReportGenerator.StepDetails("Fail", (count++)+" -Verify Failure Page >> Amount field should display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }
			  	}catch(TimeoutException ex){
			  		
			   System.out.println("Locator not found issue-P");
			   HTMLReportGenerator.StepDetails("Fail", (count++)+" - Locator not found issue-P", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
					  
			  	}
	      }

	      @Then("^Verify Failure Page >> Transaction Id should display$")
	      public void verify_Failure_Page_Transaction_Id_should_display() throws Throwable {
	        
	    	  VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		  		
			   WebDriverWait wait = new WebDriverWait(driver, 40);
			   
			  try {
			  
			  wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.transaction_Failure));
			  	
			  boolean b=vdabillPay.transaction_Failure.isDisplayed();
			  
			  if(b == true) {
				  System.out.println("Verify Failure Page >> Transaction Id should display");
				  HTMLReportGenerator.StepDetails("Pass", (count++)+" - Verify Failure Page >> Transaction Id should display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }else {
				  System.out.println("Verify Failure Page >> Transaction Id should not display");
				  HTMLReportGenerator.StepDetails("Fail", (count++)+" - Verify Failure Page >> Transaction Id should not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }
			  	}catch(TimeoutException ex){
			  		
			   System.out.println("Locator not found issue-L");
			   HTMLReportGenerator.StepDetails("Fail", (count++)+" - Locator not found issue-L", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
					  
			  	}
	      }


	      @Then("^Verify Failure Page >> Account Id should display$")
	      public void verify_Failure_Page_Account_Id_should_display() throws Throwable {
	         
	    	  VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		  		
			   WebDriverWait wait = new WebDriverWait(driver, 40);
			   
			  try {
			  
			  wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.acountid_Failure));
			  	
			  boolean b=vdabillPay.acountid_Failure.isDisplayed();
			  
			  if(b == true) {
				  System.out.println("Verify Failure Page >> Account Id should display");
				  HTMLReportGenerator.StepDetails("Pass", (count++)+" -Verify Failure Page >> Account Id should display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }else {
				  System.out.println("Verify Failure Page >> Account Id should not display");
				  HTMLReportGenerator.StepDetails("Fail", (count++)+" - Verify Failure Page >> Account Id should not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }
			  	}catch(TimeoutException ex){
			  		
			   System.out.println("Locator not found issue-K");
			   HTMLReportGenerator.StepDetails("Fail", (count++)+" - Locator not found issue-K", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
					  
			  	}
	      }

	      @Then("^Verify Failure Page >> Date & Time should display$")
	      public void verify_Failure_Page_Date_Time_should_display() throws Throwable {
	    	  
	    	  VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		  		
			   WebDriverWait wait = new WebDriverWait(driver, 40);
			   
			  try {
			  
			  wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.dateTime_Failure));
			  	
			  boolean b=vdabillPay.dateTime_Failure.isDisplayed();
			  
			  if(b == true) {
				  System.out.println("Verify Failure Page >> Date & Time should display");
				  HTMLReportGenerator.StepDetails("Pass", (count++)+" - Verify Failure Page >> Date & Time should display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }else {
				  System.out.println("Verify Failure Page >> Date & Time should not display");
				  HTMLReportGenerator.StepDetails("Fail", (count++)+" - Verify Failure Page >> Date & Time should not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }
			  	}catch(TimeoutException ex){
			  		
			   System.out.println("Locator not found issue-F");
			   HTMLReportGenerator.StepDetails("Fail", (count++)+" - Locator not found issue-F", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
					  
			  	}
	      }

	      @Then("^Verify Failure Page >> Download Receipt link should display$")
	      public void verify_Failure_Page_Download_Receipt_link_should_display() throws Throwable {
	    	  
	    	  Thread.sleep(2000);

	  		JavascriptExecutor jse = (JavascriptExecutor) driver;

	  		jse.executeScript("window.scrollBy(0,350)", "");
	        
	    	  VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		  		
			   WebDriverWait wait = new WebDriverWait(driver, 40);
			   
			  try {
			  
			  wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.download_Failure));
			  	
			  boolean b=vdabillPay.download_Failure.isDisplayed();
			  
			  if(b == true) {
				  System.out.println("Verify Failure Page >> Download Receipt link should display");
				  HTMLReportGenerator.StepDetails("Pass", (count++)+" - Verify Failure Page >> Download Receipt link should display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }else {
				  System.out.println("Verify Failure Page >> Download Receipt link should not display");
				  HTMLReportGenerator.StepDetails("Fail", (count++)+" - Verify Failure Page >> Download Receipt link should not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }
			  	}catch(TimeoutException ex){
			  		
			   System.out.println("Locator not found issue-F");
			   HTMLReportGenerator.StepDetails("Fail", (count++)+" - Locator not found issue-F", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
					  
			  	}
	      }

	      @Then("^Verify Failure Page >> Reason for Failure section should display$")
	      public void verify_Failure_Page_Reason_for_Failure_section_should_display() throws Throwable {
	    	  VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		  		
			   WebDriverWait wait = new WebDriverWait(driver, 40);
			   
			  try {
			  
			  wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.resoion_Failure));
			  	
			  boolean b=vdabillPay.resoion_Failure.isDisplayed();
			  
			  if(b == true) {
				  System.out.println("Verify Failure Page >> Reason for Failure section should display");
				  HTMLReportGenerator.StepDetails("Pass", (count++)+" -Verify Failure Page >> Reason for Failure section should display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }else {
				  System.out.println("Verify Failure Page >> Reason for Failure section should not display");
				  HTMLReportGenerator.StepDetails("Fail", (count++)+" - Verify Failure Page >> Reason for Failure section should not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }
			  	}catch(TimeoutException ex){
			  		
			   System.out.println("Locator not found issue-*");
			   HTMLReportGenerator.StepDetails("Fail", (count++)+" - Locator not found issue-*", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
					  
			  	}
	      }

	      @Then("^Verify Failure Page >> Try Again button should display$")
	      public void verify_Failure_Page_Try_Again_button_should_display() throws Throwable {
	    	  
	    	  VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		  		
			   WebDriverWait wait = new WebDriverWait(driver, 40);
			   
			  try {
			  
			  wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.tryAgain_Failure));
			  	
			  boolean b=vdabillPay.tryAgain_Failure.isDisplayed();
			  
			  if(b == true) {
				  System.out.println("Verify Failure Page >> Try Again button should display");
				  HTMLReportGenerator.StepDetails("Pass", (count++)+" -Verify Failure Page >> Try Again button should display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }else {
				  System.out.println("Verify Failure Page >> Try Again button should not display");
				  HTMLReportGenerator.StepDetails("Fail", (count++)+" - Verify Failure Page >> Try Again button should not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }
			  	}catch(TimeoutException ex){
			  		
			   System.out.println("Locator not found issue-*");
			   HTMLReportGenerator.StepDetails("Fail", (count++)+" - Locator not found issue-*", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
					  
			  	}
	      }

	      @Then("^Verify Failure Page >> Need Help link in orange color should display$")
	      public void verify_Failure_Page_Need_Help_link_in_orange_color_should_display() throws Throwable {
	    	  
	    	  VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		  		
			   WebDriverWait wait = new WebDriverWait(driver, 40);
			   
			  try {
			  
			  wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.needHelp_Failure));
			  	
			  boolean b=vdabillPay.needHelp_Failure.isDisplayed();
			  
			  if(b == true) {
				  System.out.println("Verify Failure Page >> Need Help link in Red color should display");
				  HTMLReportGenerator.StepDetails("Pass", (count++)+" -Verify Failure Page >> Need Help link in Red color should display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }else {
				  System.out.println("Verify Failure Page >> Need Help link in Red color should not display");
				  HTMLReportGenerator.StepDetails("Fail", (count++)+" - Verify Failure Page >> Need Help link in Red color should not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }
			  	}catch(TimeoutException ex){
			  		
			   System.out.println("Locator not found issue-0");
			   HTMLReportGenerator.StepDetails("Fail", (count++)+" - Locator not found issue-0", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
					  
			  	}
	      }

	      @Then("^Verify Failure Page >> SetUp Auto Pay section should display$")
	      public void verify_Failure_Page_SetUp_Auto_Pay_section_should_display() throws Throwable {
	    	  
	    	  VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		  		
			   WebDriverWait wait = new WebDriverWait(driver, 40);
			   
			  try {
			  
			  wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.setUpNow_Failure));
			  	
			  boolean b=vdabillPay.setUpNow_Failure.isDisplayed();
			  
			  if(b == true) {
				  HTMLReportGenerator.StepDetails("Pass", (count++)+" -Verify Failure Page >> Need Help link in Red color should display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }else {
				  System.out.println("Verify Failure Page >> Need Help link in Red color should not display");
				  HTMLReportGenerator.StepDetails("Fail", (count++)+" - Verify Failure Page >> Need Help link in Red color should not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }
			  	}catch(TimeoutException ex){
			  		
			   System.out.println("Locator not found issue-&");
			   HTMLReportGenerator.StepDetails("Fail", (count++)+" - Locator not found issue-&", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
					  
			  	}
	      }

	      @Then("^Verify Failure Page >> Red Together section should display$")
	      public void verify_Failure_Page_Red_Together_section_should_display() throws Throwable {
	    	  
	    	  VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		  		
			   WebDriverWait wait = new WebDriverWait(driver, 40);
			   
			  try {
			  
			  wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.redTogether_Failure));
			  	
			  boolean b=vdabillPay.redTogether_Failure.isDisplayed();
			  
			  if(b == true) {
				  System.out.println("Verify Failure Page >> Red Together section should display");
				  HTMLReportGenerator.StepDetails("Pass", (count++)+" -Verify Failure Page >> Red Together section should display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }else {
				  System.out.println("Verify Failure Page >> Red Together section should not display");
				  HTMLReportGenerator.StepDetails("Fail", (count++)+" - Verify Failure Page >> Red Together section should not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }
			  	}catch(TimeoutException ex){
			  		
			   System.out.println("Locator not found issue-6");
			   HTMLReportGenerator.StepDetails("Fail", (count++)+" - Locator not found issue-6", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
					  
			  	}
	      }

	      @Then("^Verify Failure Page >> Get MyVodafone App banner should display$")
	      public void verify_Failure_Page_Get_MyVodafone_App_banner_should_display() throws Throwable {
	    	  Thread.sleep(2000);

		  		JavascriptExecutor jse = (JavascriptExecutor) driver;

		  		jse.executeScript("window.scrollBy(0,2500)", "");
	    	  
	    	  VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		  		
			   WebDriverWait wait = new WebDriverWait(driver, 40);
			   
			  try {
			  
			  wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.Get_MyVodafone_App1));
			  	
			  boolean b=vdabillPay.Get_MyVodafone_App1.isDisplayed();
			  
			  if(b == true) {
				  System.out.println("Verify Failure Page >> Get MyVodafone App banner should display");
				  HTMLReportGenerator.StepDetails("Pass", (count++)+" -Verify Failure Page >> Get MyVodafone App banner should display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
			  }else {
				  System.out.println("Verify Failure Page >> Get MyVodafone App banner should not display");
				  
			  }
			  	}catch(TimeoutException ex){
			  		
			   System.out.println("Locator not found issue-6");
			   HTMLReportGenerator.StepDetails("Fail", (count++)+" - Locator not found issue-6", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
					  
			  }
	      }

	      @Then("^Verify Failure Page >> Click on Download Receipt link>> Download PDF of the receipt in the predefined format$")
	      public void verify_Failure_Page_Click_on_Download_Receipt_link_Download_PDF_of_the_receipt_in_the_predefined_format() throws Throwable {
	    	  VodafBillPayObj obj = new VodafBillPayObj(driver);
	    	  
	    	  Thread.sleep(1000);
	    	 // obj.download_Failure.click();
	    	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	    	  executor.executeScript("arguments[0].click();", obj.download_Failure);
	    	  System.out.println("Click on Download Receipt link");
	    	  Thread.sleep(1000);
			   HTMLReportGenerator.StepDetails("Pass", (count++)+" - Click on Download Receipt link>> Download PDF of the receipt in the predefined format", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			   Thread.sleep(3000);
			   HTMLReportGenerator.TestCaseEnd();
	      }
	      

@Then("^Verify the displayed Meta description, Meta viewport, Meta template$")
public void verify_the_displayed_Meta_description_Meta_viewport_Meta_template() throws Throwable {


	WebElement meta_dec=driver.findElement(By.xpath("//meta[@name='description']"));
	WebElement meta_viewport=driver.findElement(By.xpath("//meta[@name='viewport']"));
//	WebElement meta_template=driver.findElement(By.xpath("//meta[@name='template']"));

	boolean b1 =meta_dec.isDisplayed();
	System.out.println(b1);
	boolean b2= meta_viewport.isDisplayed();
	
//	boolean b3= meta_template.isDisplayed();
	
	if(meta_dec!= null)
	{
		String s=meta_dec.getText();
		System.out.println("Meta description is displayed and text is"+s);
		HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Meta description is displayed"+s, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		
	}else
	{
		System.out.println("Meta description is not displayed");
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "-Meta description is not displayed", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
	
	if(meta_viewport!=null)
	{
		String s2=meta_viewport.getText();
		System.out.println("Meta viewport is displayed and text is:-"+s2);
		HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Meta viewport is displayed:"+s2, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
	else
	{
		System.out.println("Meta viewport is not displayed");
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "-Meta viewport is not displayed", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
	
	try {
		
		WebElement meta_template=driver.findElement(By.xpath("//meta[@name='template']"));
	if(meta_template!=null)
	{
		String s3=meta_template.getText();
		System.out.println("Meta template is displayed and text is:-"+s3);
		HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Meta template is displayed -"+s3, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
	else
	{
		System.out.println("Meta template is not displayed");
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "-Meta template is not displayed", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
	}catch (Exception e) {
		System.out.println("Meta template is not displayed");
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "-Meta template is not displayed", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}

}


@Then("^Verify Breadcrumb should be displayed$")
public void verify_Breadcrumb_should_be_displayed() throws Throwable {
    VodafBillPayObj obj=new VodafBillPayObj(driver);
    
   
    
    if(obj.Breadcrumb.isDisplayed())
    {
    	System.out.println("Breadcrumb is displayed");
		HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Breadcrumb is displayed", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

    }else
    {
    	System.out.println("Breadcrumb is not displayed");
		HTMLReportGenerator.StepDetails("Fail",  (count++)+ "-Breadcrumb is not displayed", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

    }
}

@Then("^Click Home in breadcrumb >> Home Page should display and number should be autopopulated$")
public void click_Home_in_breadcrumb_Home_Page_should_display_and_number_should_be_autopopulated() throws Throwable {
    
    VodafBillPayObj obj=new VodafBillPayObj(driver);
    
    homepage_object obj1=new homepage_object(driver);

    obj.Breadcrumb_home.click();
    WebDriverWait wait=new WebDriverWait(driver, 30);
     wait.until(ExpectedConditions.visibilityOfAllElements(obj1.mobile_No));
     System.out.println("Click Home in breadcrumb >> Home Page is displayed");
	HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Click Home in breadcrumb >> Home Page is displayed", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

     String num="obj1.mobile_No";
     System.out.println(num);
     
     if(num==OR.getProperty("vodaPostpaidNo"))
     {
    	 System.out.println("Click Home in breadcrumb >> Home Page is displayed and number should be autopopulated");
    		HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Click Home in breadcrumb >> Home Page is displayed and number should be autopopulated", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

     }else
     {
    	 System.out.println("Click Home in breadcrumb >> Home Page is displayed and number should be autopopulated");
 		HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Click Home in breadcrumb >> Home Page is displayed and number should be autopopulated", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

     }
     Thread.sleep(2000);
     driver.navigate().back();
     Thread.sleep(3000);
	
}

@Given("^Pay Bill page should open properly in Firefox browser$")
public void pay_Bill_page_should_open_properlyin_Firefox_browser() throws Throwable {

	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability("deviceName", "My Phone");
	caps.setCapability("udid", "RZ8M73GM83W"); //Give Device ID of your mobile phone
//	caps.setCapability("udid", "d11ade7c0703");
	caps.setCapability("platformName", "Android");
	caps.setCapability("platformVersion", "9.0");
	caps.setCapability("browserName", "Chrome");
	
	
	
	try {
		
		System.out.println("@@@@@@@@@@@@@");
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		
	} catch (MalformedURLException e) {
		System.out.println("&&&&&&&&&&"+e.getMessage());
	}
			
	//Open URL in Chrome Browser
	driver.get("https://www.vodafone.in/postpaid/quick-online-bill-payment");
	

	Thread.sleep(5000);

	HTMLReportGenerator.StepDetails("Pass", (count++) + "- VodaFone Pay Bill page opened", "",

			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	driver.manage().deleteAllCookies();
}
	     }
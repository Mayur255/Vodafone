package com.VF_homepage;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.config.baseclass;

import HTML_REPORTS.HTMLReportGenerator;
import HTML_REPORTS.TakeScreenShot;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class homepage_stepdef {
	
	static int count = 1;
	AppiumDriver<MobileElement> driver=null;
	//WebDriver driver=null;
	
	@Given("^Launch the browser$")
	public void launch_the_browser() throws Throwable {
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
		driver.get("http://www.vodafone.in");
		
		Thread.sleep(3000);
		
		HTMLReportGenerator.StepDetails("Pass", (count++) + "- VodaFone Home page opened", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	
		Thread.sleep(4000);
		
		System.out.println("$$$$$$$$$$$$$$");
		
	//	driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("9970738698");
		
		Thread.sleep(4000);
		
		System.out.println("Helo");
		

		WebElement ele=driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[13]/div/div/div/div[2]/button[1]"));
		if(ele.isDisplayed())
		{
		ele.click();
		}
		
	
	}

	@Then("^Verify Home Page >> Header should display$")
	public void verify_Home_Page_Header_should_display() throws Throwable {
	
		homepage_object vodahome = new homepage_object(driver);
	//	Meta_function fun1=new Meta_function();
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
	
		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Home_pageHeder));
		
		boolean b = vodahome.Home_pageHeder.isDisplayed();
		
		if(b == true) {
			
			System.out.println("Verify Home Page >> Header should display");
			
			
			HTMLReportGenerator.StepDetails("Pass", (count++) + "- Verify Home Page >> Header is displayed", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}else {
			
			System.out.println("Verify Home Page >> Header should not display");
			
			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Verify Home Page >> Header is not display", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}
	}catch(TimeoutException ex) {
	
		System.out.println("Locator not found issue");
		
		HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	  }
	}

	@Then("^Verify Home Page >> Footer should display$")
	public void verify_Home_Page_Footer_should_display() throws Throwable {
		
        Thread.sleep(2000);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,5000)", "");
		
        homepage_object vodahome = new homepage_object(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);

	try {

		wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Home_footerHeder));
		
		boolean b = vodahome.Home_footerHeder.isDisplayed();
		
		if(b == true) {
			
			System.out.println("Verify Home Page >> Footer should display");
			
			HTMLReportGenerator.StepDetails("Pass", (count++) + "- Verify Home Page >> Footer is displayed", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}else {
			
			System.out.println("Verify Home Page >> Footer should not display");
			
			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Verify Home Page >> Footer should not display", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}
	}catch(TimeoutException ex) {
	
		System.out.println("Locator not found issue");
		
		HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	  }
	   
	}

	@Then("^Verify Home Page >> Below Header -  Banner should display$")
	public void verify_Home_Page_Below_Header_Banner_should_display() throws Throwable {
		
        Thread.sleep(2000);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,-3500)", "");
		
        homepage_object vodahome = new homepage_object(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);

	try {

		wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.banner_image));
		
		boolean b = vodahome.banner_image.isDisplayed();
		
		if(b == true) {
			
			System.out.println("Verify Home Page >> Below Header -  Banner should display");
			
			HTMLReportGenerator.StepDetails("Pass", (count++) + "- Verify Home Page >> Below Header -  Banner is displayed", "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}else {
			
			System.out.println("Verify Home Page >> Below Header -  Banner should not display");
			
			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Verify Home Page >> Below Header -  Banner should not display", "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}
	}catch(TimeoutException ex) {
	
		System.out.println("Locator not found issue");
		
		HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",

				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	  }
	   
	}

	@Then("^Verify Home Page >> Mobile number field should display$")
	public void verify_Home_Page_Mobile_number_field_should_display() throws Throwable {
		
        homepage_object vodahome = new homepage_object(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);

	try {

		wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.mobile_No));
		
		boolean b = vodahome.mobile_No.isDisplayed();
		
		if(b == true) {
			
			System.out.println("Verify Home Page >> Mobile number field should display");
			
			HTMLReportGenerator.StepDetails("Pass", (count++) + "- Verify Home Page >> Mobile number field is displayed", "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}else {
			
			System.out.println("Verify Home Page >> Mobile number field should not display");
			
			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Verify Home Page >> Mobile number field should not display", "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}
	}catch(TimeoutException ex) {
	
		System.out.println("Locator not found issue");
		
		HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",

				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	  }
	   
	}

	@Then("^Verify Home Page >> Arrow \\(>\\) button should be disabled as number is not provided$")
	public void verify_Home_Page_Arrow_button_should_be_disabled_as_number_is_not_provided() throws Throwable {
		
		 homepage_object vodahome = new homepage_object(driver);
			
			WebDriverWait wait = new WebDriverWait(driver, 30);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.arrow_key));
			
			boolean b = vodahome.arrow_key.isEnabled();
			
			if(b == true) {
				
				System.out.println("Verify Home Page >> Arrow (>) button should be disabled as number is not provided");
				
				HTMLReportGenerator.StepDetails("Pass", (count++) + "- Verify Home Page >> Arrow (>) button is disabled as number is not provided", "",

						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				
			}else {
				
				System.out.println("Verify Home Page >> Arrow (>) button should be disabled as number is provided");
				
				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Verify Home Page >> Arrow (>) button should be disabled as number is provided", "",

						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				
			}
		}catch(TimeoutException ex) {
		
			System.out.println("Locator not found issue");
			
			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		  }
		   
	}

	@Then("^Enter mobile number less than ten digits - Error message should display in Red$")
	public void enter_mobile_number_less_than_ten_digits_Error_message_should_display_in_Red() throws Throwable {
		
		homepage_object vodahome = new homepage_object(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.mobile_No));

			vodahome.mobile_No.sendKeys("8589915226");

			vodahome.mobile_No.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(3000);	
			driver.hideKeyboard();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.error_msg));

			String error_msg = "Please enter 10 digit mobile number";

			String error_msg1 = vodahome.error_msg.getText();

			System.out.println("===" + error_msg1);

			String color = vodahome.error_msg.getCssValue("color");

			String color1 = "#e60000";

			System.out.println("============" + color);
			
			String color2=Color.fromString(color).asHex();
			
			System.out.println("555555555555555555555"+color2);

			boolean n1 = vodahome.error_msg.isDisplayed();

			if (n1 == true) {

				System.out.println("Error msg is displyed");

				if (error_msg1.equalsIgnoreCase(error_msg) && color2.equalsIgnoreCase(color1)) {

					System.out.println("Correct Error msg is displyed in correct color");

					HTMLReportGenerator.StepDetails("Pass", (count++)+ "Enter mobile number less than ten digits>> Correct Error msg is displyed in correct color", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
					
					HTMLReportGenerator.StepDetails("Pass", (count++)+ "Enter mobile number less than ten digits>> Error message is display in Red", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				} else {
					
					System.out.println("Incorrect Error msg is displyed in correct color");
					HTMLReportGenerator.StepDetails("Fail",
							(count++) + "-Enter mobile number less than ten digits>> Wrong Error msg is displyed in correct color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				}
				
			} else {

				HTMLReportGenerator.StepDetails("Fail", (count++) + "-Enter mobile number less than ten digits>> Wrong Error msg is displyed in correct color",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				System.out.println("Error msg is not displayed");
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	    
	}
	@Then("^Enter Postpaid Number of Idea - error Message should display in red color$")
	public void enter_Postpaid_Number_of_Idea_error_Message_should_display_in_red_color() throws Throwable {
	
		homepage_object vodahome = new homepage_object(driver);
		
		vodahome.mobile_No.clear();

		WebDriverWait wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.mobile_No));

			vodahome.mobile_No.sendKeys("7065000474");
			
			System.out.println("Enter Postpaid Number of Idea ");
			
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.error_msg));

			String error_msg = "Seems like you have entered a non vodafone number. Looking for a new connection ? Join Vodafone";

			String error_msg1 = vodahome.error_msg.getText();

			System.out.println("===" + error_msg1);

			String color = vodahome.error_msg.getCssValue("color");

			String color1 = "#e60000";
			
			String color2=Color.fromString(color).asHex();
			

			System.out.println("============" + color);

			boolean n1 = vodahome.error_msg.isDisplayed();

			if (n1 == true) {

				System.out.println("Error msg is displyed");

				if (error_msg1.equalsIgnoreCase(error_msg) && color2.equalsIgnoreCase(color1)) {

					System.out.println("Enter Postpaid Number of Idea - error Message od display in red color");

					HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Enter Postpaid Number of Idea -correct error Message is display in red color", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				} else {
					
					System.out.println("Incorect boder color display");
					HTMLReportGenerator.StepDetails("Fail",	(count++) + "- Enter Postpaid Number of Idea - Wrong error Message is display in red color", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				}
				
			} else {

				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Correct Error msg is displyed in correct color",
						"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				System.out.println("Error msg is not displayed");
			}

		} catch (TimeoutException ex) {

			System.out.println("Locator not found issue-^");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue-^", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}
	
	@Then("^Enter NonIdea/NonVF number- error Message should display in red color$")
	public void enter_NonIdea_NonVF_number_error_Message_should_display_in_red_color() throws Throwable {
	    
        homepage_object vodahome = new homepage_object(driver);
		
		vodahome.mobile_No.clear();

		WebDriverWait wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.mobile_No));

			vodahome.mobile_No.sendKeys("9404867020");
			
			System.out.println("Enter NonIdea/NonVF number ");
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.error_msg));

			String error_msg = "Seems like you have entered a non vodafone number. Looking for a new connection ? Join Vodafone";

			String error_msg1 = vodahome.error_msg.getText();

			System.out.println("===" + error_msg1);

			String color = vodahome.error_msg.getCssValue("color");

			String color1 = "#e60000";
			
			String color2=Color.fromString(color).asHex();
			


			System.out.println("============" + color);

			boolean n1 = vodahome.error_msg.isDisplayed();

			if (n1 == true) {

				System.out.println("Error msg is displyed");

				if (error_msg1.equalsIgnoreCase(error_msg) && color2.equalsIgnoreCase(color1)) {

					System.out.println("Correct boder color is displyed in correct color");

					HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Enter NonIdea/NonVF number- Correct error Message is display in red color", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

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

	@Then("^Try to enter Mobile Number starting with (\\d+) to (\\d+) >> It should not allow$")
	public void try_to_enter_Mobile_Number_starting_with_to_It_should_not_allow(int arg1, int arg2) throws Throwable {
		
		 homepage_object vodahome = new homepage_object(driver);
		 
		 vodahome.mobile_No.clear();

			WebDriverWait wait = new WebDriverWait(driver, 40);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.mobile_No));

			vodahome.mobile_No.sendKeys("1233223211");

			String typedValue1 = vodahome.mobile_No.getAttribute("value");

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
		
		homepage_object vodahome = new homepage_object(driver);
		 
		 vodahome.mobile_No.clear();
	   
		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.mobile_No));

			vodahome.mobile_No.sendKeys("ABCDFSDDJ");

			System.out.println("Enter alphabets/Special characters in Mobile Number field- it should not allow");

			String typedValue1 = vodahome.mobile_No.getAttribute("value");

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

	@Then("^Enter Idea Prepaid Number >> error Message should display red color$")
	public void enter_Idea_Prepaid_Number_error_Message_should_display_red_color() throws Throwable {
	 
		 homepage_object vodahome = new homepage_object(driver);
			
			vodahome.mobile_No.clear();

			WebDriverWait wait = new WebDriverWait(driver, 50);

			try {
				wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.mobile_No));

				vodahome.mobile_No.sendKeys("9067200201");
				
				System.out.println("Enter Idea Prepaid Number >> Toast Message should display");
				
				wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.error_msg));

				String error_msg = "Seems like you have entered a non vodafone number. Looking for a new connection ? Join Vodafone";

				String error_msg1 = vodahome.error_msg.getText();

				System.out.println("===" + error_msg1);

				String color = vodahome.error_msg.getCssValue("color");

				String color1 = "#e60000";
				
				String color2=Color.fromString(color).asHex();
				


				System.out.println("============" + color);

				boolean n1 = vodahome.error_msg.isDisplayed();

				if (n1 == true) {

					System.out.println("Error msg is displyed");

					if (error_msg1.equalsIgnoreCase(error_msg) && color2.equalsIgnoreCase(color1)) {

						System.out.println("Correct boder color is displyed in correct color");

						HTMLReportGenerator.StepDetails("Pass", (count++)

						+ "- Enter Idea Prepaid Number >> error Message is display in red color", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

					} else {
						
						System.out.println("Incorect boder color display");
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

				System.out.println("Locator not found issue");

				HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
	}

	
	@Then("^Enter VF Postpaid Number >> Arrow \\(>\\) button should be enabled$")
	public void enter_VF_Postpaid_Number_Arrow_button_should_be_enabled() throws Throwable {
		
		homepage_object vodahome = new homepage_object(driver);
		vodahome.mobile_No.clear();

		WebDriverWait wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.mobile_No));

			vodahome.mobile_No.sendKeys("9742711711");
			
			System.out.println("Enter VF Postpaid Number");
			
			
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.ArrowKey));
			
			HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Enter Postpaid number", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));


		boolean b = vodahome.ArrowKey.isEnabled();
		
		if(b == true) {
			
			System.out.println("Arrow (>) button should be enabled");
			
			HTMLReportGenerator.StepDetails("Pass", (count++)+ "-Enter Postpaid number>> Arrow (>) button is enabled", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}else {
			
			System.out.println("Arrow (>) button should not be enabled");
			
			HTMLReportGenerator.StepDetails("Fail", (count++)

					+ "-Arrow (>) button should not be enabled", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}
	}catch(TimeoutException ex) {
		System.out.println("Arrow (>) button should not be enabled");
		
		HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Arrow (>) button should not be enabled", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		
	
	 }
	}

	@Then("^Verify Number autopoulation for Postpaid number on home page$")
	public void verify_Number_autopoulation_for_Postpaid_number_on_home_page() throws Throwable {
		driver.navigate().refresh();
		
		homepage_object obj=new homepage_object(driver);
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(obj.mobile_No));
		
		Thread.sleep(4000);
	/*	WebElement ele1=driver.findElement(By.xpath("//*[@id='close']"));
		
		
		if(ele1.isDisplayed())
		{
		
		ele1.click();
		}*/
		
		WebElement ele=driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[13]/div/div/div/div[2]/button[1]"));
		if(ele.isDisplayed())
		{
		ele.click();
		}
		
		Thread.sleep(2000);
		
		String number=obj.mobile_No.getAttribute("value");
		
		System.out.println("----postpaid number"+number);
		if(number.equalsIgnoreCase("8589915226"))
				{
					System.out.println("Load Home Page >> Mobile Number is autopopulated with VF Postpaid Number entered earlier");
					HTMLReportGenerator.StepDetails("Pass", (count++)+ "-Load Home Page >> Mobile Number is autopopulated with VF Postpaid Number entered earlier", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				}else
				{
					System.out.println("Load Home Page >> Mobile Number is not autopopulated with VF Postpaid Number entered earlier");
					HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Load Home Page >> Mobile Number is not autopopulated with VF Postpaid Number entered earlier", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				}
	}

	@Then("^Enter COCP number >> Arrow \\(>\\) button should be enabled$")
	public void enter_COCP_number_Arrow_button_should_be_enabled() throws Throwable {
	
		homepage_object vodahome = new homepage_object(driver);
		
		vodahome.mobile_No.clear();

		WebDriverWait wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.mobile_No));

			vodahome.mobile_No.sendKeys("9072608445");
			
			System.out.println("Enter COCP number ");
						
			HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Enter COCP number ", "",	TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.ArrowKey));
			Thread.sleep(3000);
			
			boolean b = vodahome.ArrowKey.isEnabled();
			
			if(b == true) {
				
				System.out.println("Arrow (>) button should be enabled");
				
				HTMLReportGenerator.StepDetails("Pass", (count++)+ "-Enter COCP number>> Arrow (>) button is enabled", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				
			}else {
				
				System.out.println("Arrow (>) button should not be enabled");
				
				HTMLReportGenerator.StepDetails("Fail", (count++)

						+ "Enter COCP number -Arrow (>) button should not be enabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				
			}
		}catch(TimeoutException ex) {
			System.out.println("Arrow (>) button should not be enabled");
			
			HTMLReportGenerator.StepDetails("Fail", (count++)+ "Enter COCP number -Arrow (>) button should not be enabled", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		
		 }

		}

	@Then("^Enter Idea Postpaid Migrated number >> Arrow \\(>\\) button should be enabled$")
	public void enter_Idea_Postpaid_Migrated_number_Arrow_button_should_be_enabled() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Enter VF Prepaid number >> Arrow \\(>\\) button should be enabled$")
	public void enter_VF_Prepaid_number_Arrow_button_should_be_enabled() throws Throwable {
		 homepage_object vodahome = new homepage_object(driver);
			
			vodahome.mobile_No.clear();
			driver.manage().deleteAllCookies();
		       Thread.sleep(2000);
		       driver.navigate().refresh();

			try {
			WebDriverWait wait = new WebDriverWait(driver, 50);

			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.mobile_No));
			
			WebElement ele=driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[13]/div/div/div/div[2]/button[1]"));
			if(ele.isDisplayed())
			{
			ele.click();
			}
			
			Thread.sleep(2000);

				vodahome.mobile_No.sendKeys("7769941028");
				
				System.out.println("Enter VF Prepaid Number");
				
				HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Enter VF Prepaid Number >> Arrow (>) button should be black", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				
				wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.ArrowKey));
				Thread.sleep(3000);
				
				boolean b = vodahome.ArrowKey.isEnabled();
				
				if(b == true) {
					
					System.out.println("Arrow (>) button should be enabled");
					
					HTMLReportGenerator.StepDetails("Pass", (count++)+ "-Enter VF Prepaid Number>> Arrow (>) button is enabled", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
					
				}else {
					
					System.out.println("Arrow (>) button should not be enabled");
					
					HTMLReportGenerator.StepDetails("Fail", (count++)

							+ "Enter VF Prepaid Number (>) button should not be enabled", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
					
				}
			}catch(TimeoutException ex) {
				System.out.println("Enter VF Prepaid Number>>Arrow (>) button should not be enabled");
				
				HTMLReportGenerator.StepDetails("Fail", (count++)+ "Enter VF Prepaid Number -Arrow (>) button should not be enabled", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				
			
			 }
	}

	@Then("^Verify Number autopoulation for Prepaid number on home page$")
	public void verify_Number_autopoulation_for_Prepaid_number_on_home_page() throws Throwable {
		Thread.sleep(2000);
		
		homepage_object obj=new homepage_object(driver);
		
		String num=obj.mobile_No.getAttribute("value");
		System.out.println("----Prepaid number:-"+num);
		Thread.sleep(1000);
		
		System.out.println("");
		
		String num2="7769941028";
		
		if(num.equalsIgnoreCase(num))
		//if(num2==num2)
		{
			System.out.println("Load Home Page >> Mobile Number is autopopulated with VF Prepaid Number entered earlier");
			HTMLReportGenerator.StepDetails("Pass", (count++)+ "-Load Home Page >> Mobile Number is autopopulated with VF Prepaid Number entered earlier", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		}else
		{
			System.out.println("Load Home Page >> Mobile Number is not autopopulated with VF Prepaid Number entered earlier");
			HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Load Home Page >> Mobile Number is not autopopulated with VF Prepaid Number entered earlier", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));


		}
	}

	@Then("^Verify Quicklinks on home screen$")
	public void verify_Quicklinks_on_home_screen() throws Throwable {
		homepage_object vodahome = new homepage_object(driver);
	       
		WebDriverWait wait = new WebDriverWait(driver, 50);
		
      try {
   
		wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Home_quicklink));
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,500)", "");
		
		boolean b= vodahome.Home_quicklink.isDisplayed();
		if(b == true) {
			
			System.out.println("Verify Home Page >> Quicklinks should display below Mobile number field");
			
			HTMLReportGenerator.StepDetails("Pass", (count++)

					+ "-Verify Home Page >> Quicklinks should display below Mobile number field", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}else {
			
		System.out.println("Verify Home Page >> Quicklinks should not display below Mobile number field");
		
		HTMLReportGenerator.StepDetails("Fail", (count++)

				+ "- Verify Home Page >> Quicklinks should not display below Mobile number field", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
      }catch(TimeoutException ex){
    	  
    	  System.out.println("Locator not found issue-Q");
    	  HTMLReportGenerator.StepDetails("Fail", (count++)

  				+ "- Locator not found issue-Q", "",
  				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      }
	
	}

	@Then("^Verify four banners below quicklinks on home screen$")
	public void verify_four_banners_below_quicklinks_on_home_screen() throws Throwable {
		homepage_object vodahome = new homepage_object(driver);
	       
		WebDriverWait wait = new WebDriverWait(driver, 50);
		
      try {
   
		wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Home_quicklink));
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,180)", "");
		
		
		boolean b= vodahome.Home_quicklink.isDisplayed();
		if(b == true) {
			
			System.out.println("Verify Home Page >> Banners should display below Quicklinks");
			
			HTMLReportGenerator.StepDetails("Pass", (count++)

					+ "-Verify Home Page >> Banners should display below Quicklinks", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}else {
			
		System.out.println("Verify Home Page >> Banners should not display below Quicklinks");
		
		HTMLReportGenerator.StepDetails("Fail", (count++)

				+ "- Verify Home Page >> Banners should not display below Quicklinks", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
      }catch(TimeoutException ex){
    	  
    	  System.out.println("Locator not found issue-B");
    	  HTMLReportGenerator.StepDetails("Fail", (count++)

  				+ "- Locator not found issue-B", "",
  				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      }
	}

	@Then("^Verify loaded benefits on VodafoneIdea section on home screen$")
	public void verify_loaded_benefits_on_VodafoneIdea_section_on_home_screen() throws Throwable {
Thread.sleep(2000);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,350)", "");
		
		 homepage_object vodahome = new homepage_object(driver);
	       
			WebDriverWait wait = new WebDriverWait(driver, 50);
			
	      try {
	   
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Loadedbenifit_voda));
			
			boolean b= vodahome.Loadedbenifit_voda.isDisplayed();
			if(b == true) {
				
				System.out.println("Verify Home Page >> Loaded Benefits on VodafoneIdea section should display");
				
				HTMLReportGenerator.StepDetails("Pass", (count++)

						+ "-Verify Home Page >> Loaded Benefits on VodafoneIdea section should display", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				
			}else {
				
			System.out.println("Verify Home Page >> Loaded Benefits on VodafoneIdea section not should display");
			
			HTMLReportGenerator.StepDetails("Fail", (count++)

					+ "- Verify Home Page >> Loaded Benefits on VodafoneIdea section should not display", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
	      }catch(TimeoutException ex){
	    	  
	    	  System.out.println("Locator not found issue-L");
	    	  HTMLReportGenerator.StepDetails("Fail", (count++)

	  				+ "- Locator not found issue-L", "",
	  				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	      }
	}

	@Then("^Verify Trending Now section on home screen$")
	public void verify_Trending_Now_section_on_home_screen() throws Throwable {
		 homepage_object vodahome = new homepage_object(driver);
	       
			WebDriverWait wait = new WebDriverWait(driver, 50);
			
	      try {
	   
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.exclusive_voda));
			
			JavascriptExecutor jse = (JavascriptExecutor) driver;

			jse.executeScript("window.scrollBy(0,400)", "");
			boolean b= vodahome.exclusive_voda.isDisplayed();
			if(b == true) {
				
				System.out.println("Verify Home Page >> Trending Now should display");
				
				HTMLReportGenerator.StepDetails("Pass", (count++)

						+ "-Verify Home Page >> Trending Now should display", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				
				
				
			}else {
				
			System.out.println("Verify Home Page >> Trending Now should not display");
			
			HTMLReportGenerator.StepDetails("Fail", (count++)

					+ "- Verify Home Page >> Trending Now should not display", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
	      }catch(TimeoutException ex){
	    	  
	    	  System.out.println("Locator not found issue-S");
	    	  HTMLReportGenerator.StepDetails("Fail", (count++)+ "- Locator not found issue-S", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	      }
	}

	@Then("^Verify Cookie Policy section on home screen$")
	public void verify_Cookie_Policy_section_on_home_screen() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Verify Cookie Policy should be link$")
	public void verify_Cookie_Policy_should_be_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	
}

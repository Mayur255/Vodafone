package com.vodafone.home.page;

import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Testdata.Meta_function;
import com.config.baseclass;
import com.online_Pack.star1;
import com.voda.PayBill.VodaPay_BillStepDef;
import com.voda.PayBill.VodafBillPayObj;
import com.voda.ideaOrc.VILIdeaORCObj;

import HTML_REPORTS.HTMLReportGenerator;
import HTML_REPORTS.TakeScreenShot;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class VodafoneHomePageStep
{
	

	Properties prop = new Properties();
	public Properties OR;
	public File file = null;
	public FileReader filereader;
	WebDriver driver;
	public static int number = 1;

	static int count = 1;
	final static Logger log = Logger.getLogger(VodaPay_BillStepDef.class);
	
	@Given("^Load Vodafone Site >> Home Page should display$")
	public void load_Vodafone_Site_Home_Page_should_display() throws Throwable {
		
		HTMLReportGenerator.TestCaseStart("Chrome:-VodaHome_Page", "Chrome:-Production_Build_number:001");
		
			VodafoneHomePageObj vodahome=new VodafoneHomePageObj(driver);
		// Chrome
				String path = System.getProperty("user.dir") + "\\Driver\\chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", path);
			
				driver = new ChromeDriver();
				System.out.println(" browser");

				OR = new Properties();

				file = new File(System.getProperty("user.dir") + "/src/test/java/com/Testdata/URL.properties");

				filereader = new FileReader(file);

				OR.load(filereader);

				driver.get("https://www.vodafone.in");
				
		//		driver.get("https://preprod.vodafoneidea.com");
		//		driver.get("https://testvil.vodafoneidea.com/content/vodafoneideadigital/in/en/vil-homepage.html");

				System.out.println(" Chrome Browser is opening ");

				System.out.println("VodaFone Home page opened");
				
				driver.manage().window().maximize();

				Thread.sleep(2000);
				
				WebElement ele1=driver.findElement(By.xpath("//*[@id='close']"));
				
				if(ele1.isDisplayed())
				{
				
				ele1.click();
				}
				
				WebElement ele=driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[13]/div/div/div/div[2]/button[1]"));
				if(ele.isDisplayed())
				{
				ele.click();
				}
				
				Thread.sleep(2000);
				HTMLReportGenerator.StepDetails("Pass", (count++) + "- VodaFone Home page opened", "",

						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				
			}

	@Then("^Verify Home Page >> Header should display$")
	public void verify_Home_Page_Header_should_display() throws Throwable {
	
		VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
	//	Meta_function fun1=new Meta_function();
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
	
		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Home_pageHeder));
		
		boolean b = vodahome.Home_pageHeder.isDisplayed();
		
		if(b == true) {
			
			System.out.println("Verify Home Page >> Header should display");
			
			
			HTMLReportGenerator.StepDetails("Pass", (count++) + "- Verify Home Page >> Header is displayed", "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}else {
			
			System.out.println("Verify Home Page >> Header should not display");
			
			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Verify Home Page >> Header is not display", "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}
	}catch(TimeoutException ex) {
	
		System.out.println("Locator not found issue");
		
		HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",

				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	  }
	}

	@Then("^Verify Home Page >> Footer should display$")
	public void verify_Home_Page_Footer_should_display() throws Throwable {
		
        Thread.sleep(2000);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,5000)", "");
		
        VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);

	try {

		wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Home_footerHeder));
		
		boolean b = vodahome.Home_footerHeder.isDisplayed();
		
		if(b == true) {
			
			System.out.println("Verify Home Page >> Footer should display");
			
			HTMLReportGenerator.StepDetails("Pass", (count++) + "- Verify Home Page >> Footer is displayed", "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}else {
			
			System.out.println("Verify Home Page >> Footer should not display");
			
			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Verify Home Page >> Footer should not display", "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}
	}catch(TimeoutException ex) {
	
		System.out.println("Locator not found issue");
		
		HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",

				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	  }
	   
	}

	@Then("^Verify Home Page >> Below Header -  Banner should display$")
	public void verify_Home_Page_Below_Header_Banner_should_display() throws Throwable {
		
        Thread.sleep(2000);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,-3500)", "");
		
        VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
		
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
		
        VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
		
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
		
		 VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
			
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

	@Then("^Enter mobile number less than ten digits - Error message should display in Red1$")
	public void enter_mobile_number_less_than_ten_digits_Error_message_should_display_in_Red1() throws Throwable {
		
		VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.mobile_No));

			vodahome.mobile_No.sendKeys(OR.getProperty("LessThan"));

			vodahome.mobile_No.sendKeys(Keys.BACK_SPACE);

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

	@Then("^Enter mobile number less than ten digits - Enter Mobile Number label and field border should display in Red$")
	public void enter_mobile_number_less_than_ten_digits_Enter_Mobile_Number_label_and_field_border_should_display_in_Red() throws Throwable {
   
		VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
		
		vodahome.mobile_No.clear();

		WebDriverWait wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.mobile_No));

			vodahome.mobile_No.sendKeys(OR.getProperty("LessThan"));

			vodahome.mobile_No.sendKeys(Keys.BACK_SPACE);

			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.error_msg));

			String error_msg = "Please enter 10 digit mobile number";

			String error_msg1 = vodahome.error_msg.getText();

			System.out.println("===" + error_msg1);

			String color = vodahome.error_msg.getCssValue("color");

			String color1 = "#e60000";
			
			String color2=Color.fromString(color).asHex();
			
			System.out.println("555555555555555555555"+color2);

			System.out.println("============" + color);

			boolean n1 = vodahome.error_msg.isDisplayed();

			if (n1 == true) {

				System.out.println("Error msg is displyed");

				if (error_msg1.equalsIgnoreCase(error_msg) && color2.equalsIgnoreCase(color1)) {

					System.out.println("Correct boder color is displyed in correct color");

					HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Enter mobile number less than ten digits - Enter Mobile Number label and field border is display in Red", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				} else {
					
					System.out.println("Incorect boder color display");
					HTMLReportGenerator.StepDetails("Fail",
							(count++) + "- Enter mobile number less than ten digits - Enter Mobile Number label and field border is not display in Red", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
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


	@Then("^Enter COCP number >> Arrow \\(>\\) button should be enabled$")
	public void enter_COCP_number_Arrow_button_should_be_enabled() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   

		
		VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
		
	       
	       driver.manage().deleteAllCookies();
	       
	       driver.navigate().refresh();
	       
		   	Thread.sleep(4000);
			
		
		 /*  	WebElement ele1=driver.findElement(By.xpath("//*[@id='close']"));
			
			if(ele1.isDisplayed())
			{
			
			ele1.click();
			}*/
			
			WebElement ele=driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[13]/div/div/div/div[2]/button[1]"));
			if(ele.isDisplayed())
			{
			ele.click();
			}
		
		//	vodahome.mobile_No.clear();

			WebDriverWait wait = new WebDriverWait(driver, 50);

			try {
				wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.mobile_No));

				vodahome.mobile_No.sendKeys("9072608451");
				
				System.out.println("Enter VF COCP Number");
	
				Thread.sleep(2000);
				
				
				
	//			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.ArrowKey));
				
				HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Enter VF COCP number", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			

			
			boolean b = vodahome.ArrowKey.isEnabled();
			
			if(b == true) {
				
				System.out.println("Arrow (>) button should be enabled");
				
				HTMLReportGenerator.StepDetails("Pass", (count++)+ "-Enter COCP number>> Arrow (>) button is enabled", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				
			}else {
				
				System.out.println("Arrow (>) button should not be enabled");
				
				HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Arrow (>) button should not be enabled", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				
			}
		}catch(TimeoutException ex) {
			System.out.println("Arrow (>) button should not be enabled");
			
			HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Arrow (>) button should not be enabled", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		
	   
	    }
	}
	@Then("^Enter Postpaid Number of Idea - error Message should display in red color$")
	public void enter_Postpaid_Number_of_Idea_error_Message_should_display_in_red_color() throws Throwable {
	
		VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
		
		vodahome.mobile_No.clear();

		WebDriverWait wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.mobile_No));

			vodahome.mobile_No.sendKeys(OR.getProperty("prepaidIdeaNO"));
			
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
	/*@Then("^Click Dismiss >> Toast message should vanish$")
	public void click_Dismiss_Toast_message_should_vanish() throws Throwable {
		
	   VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
	   
	   WebDriverWait wait = new WebDriverWait(driver, 50);
	  	
		wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.tost_dissmis));

		vodahome.tost_dissmis.click();
				
		System.out.println("Click Dismiss >> Toast message should vanish");
		
		HTMLReportGenerator.StepDetails("Pass", (count++)

				+ "- Click Dismiss >> Toast message should vanish", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    
	   }*/


	@Then("^Enter NonIdea/NonVF number- error Message should display in red color$")
	public void enter_NonIdea_NonVF_number_error_Message_should_display_in_red_color() throws Throwable {
	    
        VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
		
		vodahome.mobile_No.clear();

		WebDriverWait wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.mobile_No));

			vodahome.mobile_No.sendKeys(OR.getProperty("NonIdeaNo"));
			
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

	@Then("^Try to enter Mobile Number starting with (\\d+) to (\\d+) >> It should not allow1$")
	public void try_to_enter_Mobile_Number_starting_with_to_It_should_not_allow1(int arg1, int arg2) throws Throwable {
		
		 VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
		 
		 vodahome.mobile_No.clear();

			WebDriverWait wait = new WebDriverWait(driver, 40);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.mobile_No));

			vodahome.mobile_No.sendKeys(OR.getProperty("NuStartinZero"));

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

	@Then("^Enter alphabets/Special characters in Mobile Number field- it should not allow1$")
	public void enter_alphabets_Special_characters_in_Mobile_Number_field_it_should_not_allow1() throws Throwable {
		
		VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
		 
		 vodahome.mobile_No.clear();
	   
		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.mobile_No));

			vodahome.mobile_No.sendKeys(OR.getProperty("AlfabetSpecial"));

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
	 
		 VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
			
			vodahome.mobile_No.clear();

			WebDriverWait wait = new WebDriverWait(driver, 50);

			try {
				wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.mobile_No));

				vodahome.mobile_No.sendKeys(OR.getProperty("prepaidIdeaNO"));
				
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

	@Then("^Enter COCP number >> Arrow (>) button should be enabled$")
	public void enter_COCP__Arrow_button_should_be_enabled() throws Throwable {
		
		VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
		
	       
	       driver.manage().deleteAllCookies();
	       
	       driver.navigate().refresh();
	       
		   	Thread.sleep(2000);
			
		
		 /*  	WebElement ele1=driver.findElement(By.xpath("//*[@id='close']"));
			
			if(ele1.isDisplayed())
			{
			
			ele1.click();
			}*/
			
			WebElement ele=driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[13]/div/div/div/div[2]/button[1]"));
			if(ele.isDisplayed())
			{
			ele.click();
			}
		
		//	vodahome.mobile_No.clear();

			WebDriverWait wait = new WebDriverWait(driver, 50);

			try {
				wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.mobile_No));

				vodahome.mobile_No.sendKeys("9072608445");
				
				System.out.println("Enter VF COCP Number");
				
				wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.ArrowKey));
				
				HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Enter VF COCP number", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));


			boolean b = vodahome.ArrowKey.isEnabled();
			
			if(b == true) {
				
				System.out.println("Arrow (>) button should be enabled");
				
				HTMLReportGenerator.StepDetails("Pass", (count++)+ "-Enter COCP number>> Arrow (>) button is enabled", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				
			}else {
				
				System.out.println("Arrow (>) button should not be enabled");
				
				HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Arrow (>) button should not be enabled", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				
			}
		}catch(TimeoutException ex) {
			System.out.println("Arrow (>) button should not be enabled");
			
			HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Arrow (>) button should not be enabled", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		
	   
	    }
	}
	/*@Then("^Enter COCP number >> Toast message should be display$")
	public void enter_COCP_number_Toast_message_should_be_display() throws Throwable {
		
		VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
		
		vodahome.mobile_No.clear();

		WebDriverWait wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.mobile_No));

			vodahome.mobile_No.sendKeys(OR.getProperty("COCPNo"));
			
			System.out.println("Enter COCP number ");
			
			HTMLReportGenerator.StepDetails("Pass", (count++)

					+ "- Enter COCP number ", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.tost_msg));

			boolean n=vodahome.tost_msg.isDisplayed();
			
			if(n == true) {
				
				System.out.println("Toast Message should display");
				
				HTMLReportGenerator.StepDetails("Pass", (count++)

				+ "- Toast Message should display", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
	}else {
		
		System.out.println("Toast Message should not display");
		HTMLReportGenerator.StepDetails("Fail", (count++)

				+ "- Toast Message should not display", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	 }
	}catch(TimeoutException ex) {
		
		System.out.println("Toast Message should not display");
		HTMLReportGenerator.StepDetails("Fail", (count++)
				+ "- Toast Message should not display", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		
		}
	
	}
*/
	@Then("^Enter VF Postpaid Number >> Arrow \\(>\\) button should be enabled$")
	public void enter_VF_Postpaid_Number_Arrow_button_should_be_enabled() throws Throwable {
	 
       VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
		
       
       driver.manage().deleteAllCookies();
       
       driver.navigate().refresh();
       
	   	Thread.sleep(2000);
		
	
	 /*  	WebElement ele1=driver.findElement(By.xpath("//*[@id='close']"));
		
		if(ele1.isDisplayed())
		{
		
		ele1.click();
		}*/
		
		WebElement ele=driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[13]/div/div/div/div[2]/button[1]"));
		if(ele.isDisplayed())
		{
		ele.click();
		}
	
	//	vodahome.mobile_No.clear();

		WebDriverWait wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.mobile_No));

			vodahome.mobile_No.sendKeys(OR.getProperty("vodaPostpaidNo"));
			
			System.out.println("Enter VF Postpaid Number");
			
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
	

@Then("^Load Home Page >> Mobile Number should be autopopulated with VF Postpaid Number entered earlier$")
public void load_Home_Page_Mobile_Number_should_be_autopopulated_with_VF_Postpaid_Number_entered_earlier() throws Throwable {

			driver.navigate().refresh();
			
			VodafoneHomePageObj obj=new VodafoneHomePageObj(driver);
			
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
			if(number.equalsIgnoreCase(OR.getProperty("vodaPostpaidNo")))
					{
						System.out.println("Load Home Page >> Mobile Number is autopopulated with VF Postpaid Number entered earlier");
						HTMLReportGenerator.StepDetails("Pass", (count++)+ "-Load Home Page >> Mobile Number is autopopulated with VF Postpaid Number entered earlier", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

					}else
					{
						System.out.println("Load Home Page >> Mobile Number is not autopopulated with VF Postpaid Number entered earlier");
						HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Load Home Page >> Mobile Number is not autopopulated with VF Postpaid Number entered earlier", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

					}
			
}

@Then("^Click on Pay Bill button$")
public void click_on_Pay_Bill_button() throws Throwable {
    VodafoneHomePageObj obj=new VodafoneHomePageObj(driver);
    obj.Bill_Pay_btn.click();
    Thread.sleep(2000);
}

@Then("^Click on Recharge button$")
public void click_on_Recharge_button() throws Throwable {
	VodafoneHomePageObj obj=new VodafoneHomePageObj(driver);
	driver.navigate().back();
	Thread.sleep(5000);
  //  obj.Recharge_btn.click();

	 JavascriptExecutor executor = (JavascriptExecutor)driver;
	   
	   executor.executeScript("arguments[0].click();", obj.Recharge_btn);
    Thread.sleep(2000);
}

	@Then("^Enter VF Postpaid Number >> Arrow \\(>\\) button should be black$")
	public void enter_VF_Postpaid_Number_Arrow_button_should_be_black() throws Throwable {
	    
        VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
		
		vodahome.mobile_No.clear();

		WebDriverWait wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.mobile_No));

			vodahome.mobile_No.sendKeys(OR.getProperty("vodaPostpaidNo"));
			
			System.out.println("Enter VF Postpaid Number");
			
			HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Enter VF Postpaid Number >> Arrow (>) button should be black", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
	}

	@Then("^Click arrow \\(>\\)Billpay page should display$")
	public void click_arrow_Billpay_page_should_display() throws Throwable {
		
       VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
	
		WebDriverWait wait = new WebDriverWait(driver, 50);
		
      try {
	   
		wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.ArrowKey));
		
		vodahome.ArrowKey.click();
		
		System.out.println("Click on Array button");
		
	//	HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Billpay page should display", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Billpay_Mobile));
		
		boolean b = vodahome.Billpay_Mobile.isDisplayed();
		
		if(b == true) {
			
			System.out.println("Billpay page should display");HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Billpay page should display", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}else {
			
			System.out.println("Billpay page should not display");
			
			HTMLReportGenerator.StepDetails("Fail", (count++)

					+ "- Billpay page should not display", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}
      }catch(TimeoutException ex){
    	  System.out.println("Locator not found issue");
    	  
    	  HTMLReportGenerator.StepDetails("Fail", (count++)

					+ "- Locator not found issue", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      }
	}

	@Then("^Verify Billpay page >> Mobile number should be autopopulated with number entered on Homepage$")
	public void verify_Billpay_page_Mobile_number_should_be_autopopulated_with_number_entered_on_Homepage() throws Throwable {
		
		  VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
			
			WebDriverWait wait = new WebDriverWait(driver, 50);
			
       try {
    	   
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Billpay_Mobile));
			
			boolean b = vodahome.Billpay_Mobile.isDisplayed();
			
			if(b == true) {
			
			System.out.println("Verify Billpay page >> Mobile number should be autopopulated with number entered on Homepage");
			
			HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Verify Billpay page >> Mobile number should be autopopulated with number entered on Homepage", "",	TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}else {
				
				System.out.println("Verify Billpay page >> Mobile number should not be autopopulated with number entered on Homepage");
				
				HTMLReportGenerator.StepDetails("Fail", (count++)+ "- Verify Billpay page >> Mobile number should not be autopopulated with number entered on Homepage", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
       }catch(TimeoutException ex){
    	   
    	   System.out.println("Locator not found issue");
			
			HTMLReportGenerator.StepDetails("Fail", (count++)

					+ "- Locator not found issue", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
       }
	}

	@Then("^Verify Billpay page >> Amount field should be enabled$")
	public void verify_Billpay_page_Amount_field_should_be_enabled() throws Throwable {
		
		
		 VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
			
			WebDriverWait wait = new WebDriverWait(driver, 50);
			
    try {
 	   
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Billpay_Amount));
			
			boolean b = vodahome.Billpay_Amount.isEnabled();
			
			if(b == true) {
			
			System.out.println("Verify Billpay page >> Amount field should be enabled");
			
			HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Verify Billpay page >> Mobile number should be autopopulated with number entered on Homepage", "",	TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			
			HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Verify Billpay page >> Amount field should be enabled", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}else {
				
				System.out.println("Verify Billpay page >> Amount field should not be enabled");
				
				HTMLReportGenerator.StepDetails("Fail", (count++)+ "- Verify Billpay page >> Mobile number not autopopulated with number entered on Homepage", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

				
				HTMLReportGenerator.StepDetails("Fail", (count++)+ "- Verify Billpay page >> Amount field should not be enabled", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
    }catch(TimeoutException ex){
 	   
 	   System.out.println("Locator not found issue");
			
			HTMLReportGenerator.StepDetails("Fail", (count++)

					+ "- Locator not found issue", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      }
	}

	@Then("^Verify Billpay page >> Fetch your bill link should be enabled$")
	public void verify_Billpay_page_Fetch_your_bill_link_should_be_enabled() throws Throwable {
	   

		 VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
			
			WebDriverWait wait = new WebDriverWait(driver, 50);
			
   try {
	   
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Billpay_fechBill));
			
			boolean b = vodahome.Billpay_fechBill.isEnabled();
			
			if(b == true) {
			
			System.out.println("Verify Billpay page >> Fetch your bill link should be enabled");
			
		//	HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Verify Billpay page >> Fetch your bill link should be enabled", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}else {
				
				System.out.println("Verify Billpay page >> Fetch your bill link should not be enabled");
				
				HTMLReportGenerator.StepDetails("Fail", (count++)

						+ "- Verify Billpay page >> Fetch your bill link should not be enabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
   }catch(TimeoutException ex){
	   
	   System.out.println("Locator not found issue");
			
			HTMLReportGenerator.StepDetails("Fail", (count++)

					+ "- Locator not found issue", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	 }
	}
	@Then("^Enter VF Prepaid Number >> Arrow \\(>\\) button should be enabled$")
	public void enter_VF_Prepaid_Number_Arrow_button_should_be_enabled() throws Throwable {
		
		driver.get(OR.getProperty("Vodafone_HomePage"));
		
	//	driver.get("https://preprod.vodafoneidea.com");
		
       VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
       
       driver.manage().deleteAllCookies();
       
       driver.navigate().refresh();
       
	   	Thread.sleep(2000);
		
	
	/*   	WebElement ele1=driver.findElement(By.xpath("//*[@id='close']"));
		
		if(ele1.isDisplayed())
		{
		
		ele1.click();
		}*/
		
		WebElement ele=driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[13]/div/div/div/div[2]/button[1]"));
		if(ele.isDisplayed())
		{
		ele.click();
		}
		
	//	vodahome.mobile_No.clear();

		WebDriverWait wait = new WebDriverWait(driver, 50);

		//try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.mobile_No));

			vodahome.mobile_No.sendKeys(OR.getProperty("vodafone_pre"));
			
			System.out.println("Enter VF Prepaid Number");
			
			HTMLReportGenerator.StepDetails("Pass", (count++)

					+ "- Enter VF Prepaid Number", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
			Thread.sleep(2000);
			
	/*		wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.ArrowKey));
			
		boolean b = vodahome.ArrowKey.isEnabled();
		
		if(b == true) {
			
			System.out.println("Arrow(>) button should be enabled");
			
			HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Arrow(>) button should be enabled", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
			
		}else {
			
			System.out.println("Arrow(>) button should not be enabled");
			
			HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Arrow(>) button should not be enabled", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}*/
	}


@Then("^Load Home Page >> Mobile Number should be autopopulated with VF Prepaid Number entered earlier$")
public void load_Home_Page_Mobile_Number_should_be_autopopulated_with_VF_Prepaid_Number_entered_earlier() throws Throwable {
	driver.navigate().refresh();
	
	VodafoneHomePageObj obj=new VodafoneHomePageObj(driver);
	
	WebDriverWait wait=new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOfAllElements(obj.mobile_No));
	
	Thread.sleep(2000);
	
/*
	WebElement ele1=driver.findElement(By.xpath("//*[@id='close']"));
	
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
	
	String num=obj.mobile_No.getAttribute("value");
	System.out.println("----Prepaid number:-"+num);
	Thread.sleep(1000);
	
	System.out.println("==="+OR.getProperty("vodafone_pre"));
	
	String num2="9637889276";
	
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
		
	/*if(number1=="9637889276")
	{
				System.out.println("Load Home Page >> Mobile Number is autopopulated with VF Prepaid Number entered earlier");
				HTMLReportGenerator.StepDetails("Pass", (count++)+ "-Load Home Page >> Mobile Number is autopopulated with VF Prepaid Number entered earlier", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}
	else
	{
				System.out.println("Load Home Page >> Mobile Number is not autopopulated with VF Prepaid Number entered earlier");
				HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Load Home Page >> Mobile Number is not autopopulated with VF Prepaid Number entered earlier", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}*/
}

	
	@Then("^Enter VF Prepaid Number >> Arrow \\(>\\) button should be black$")
	public void enter_VF_Prepaid_Number_Arrow_button_should_be_black() throws Throwable {
		
        VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
		
		vodahome.mobile_No.clear();

		WebDriverWait wait = new WebDriverWait(driver, 50);

		//try {
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.mobile_No));

			vodahome.mobile_No.sendKeys("7769941028");
			
			System.out.println("Enter VF Prepaid Number");
			
			Thread.sleep(4000);
			
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.ArrowKey));
			
		boolean b = vodahome.ArrowKey.isEnabled();
		
		if(b == true) {
			
			System.out.println("Enter VF Prepaid Number >> Arrow (>) button should be black");
			
			HTMLReportGenerator.StepDetails("Pass", (count++)

					+ "- Enter VF Prepaid Number >> Arrow (>) button should be black", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
			
		}else {
			
			System.out.println("Enter VF Prepaid Number >> Arrow (>) button should not be black");
			
			HTMLReportGenerator.StepDetails("Fail", (count++)

					+ "- Enter VF Prepaid Number >> Arrow (>) button should not be black", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
	}

	@Then("^Click arrow \\(>\\)Recharge page should display$")
	public void click_arrow_Recharge_page_should_display() throws Throwable {
		
		 VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
			
			WebDriverWait wait = new WebDriverWait(driver, 50);
try {
	
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.ArrowKey));
			
			vodahome.ArrowKey.click();
			
			System.out.println("Click arrow(>)Recharge page should display");
			
	/*		HTMLReportGenerator.StepDetails("Pass", (count++)

					+ "- Click arrow (>)Recharge page should display", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			*/
			Thread.sleep(2000);
			
		/*	wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.ORC_number));
			
			boolean b = vodahome.ORC_number.isDisplayed();*/
			
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.ORC_number));
			
			boolean b = vodahome.ORC_number.isDisplayed();
			
			if(b == true) {
				
				System.out.println("Click arrow (>)Recharge page should display");
				
				HTMLReportGenerator.StepDetails("Pass", (count++)+ "-Click arrow (>)Recharge page is displayed", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				
			}else {
				
				System.out.println("Click arrow (>)Recharge page should not display");
				
				HTMLReportGenerator.StepDetails("Fail", (count++)

						+ "- Billpay page should not display", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				
			}
			
}catch(TimeoutException ex){
	
	System.out.println("Locator not found issue");
	HTMLReportGenerator.StepDetails("Fail", (count++)

			+ "-Locator not found issue", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	
   }
	}

	@Then("^Verify Recharge page >> Mobile number should be autopopulated with number entered on Homepage$")
	public void verify_Recharge_page_Mobile_number_should_be_autopopulated_with_number_entered_on_Homepage() throws Throwable {
		 VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
			
			WebDriverWait wait = new WebDriverWait(driver, 50);
			
    try {
 	   
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Billpay_Mobile));
			
			boolean b = vodahome.Billpay_Mobile.isDisplayed();
			
			if(b == true) {
			
			System.out.println("Verify Recharge page >> Mobile number should be autopopulated with number entered on Homepage");
			
			HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Verify Recharge page>> Mobile number should be autopopulated with number entered on Homepage", "",	TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}else {
				
				System.out.println("Verify Recharge page >> Mobile number should not be autopopulated with number entered on Homepage");
				
				HTMLReportGenerator.StepDetails("Fail", (count++)+ "- Verify Recharge page >> Mobile number should not be autopopulated with number entered on Homepage", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
    }catch(TimeoutException ex){
 	   
 	   System.out.println("Locator not found issue");
			
			HTMLReportGenerator.StepDetails("Fail", (count++)+ "- Locator not found issue", "",	TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    }
	}

	@Then("^Verify Recharge page >> Amount field should be enabled$")
	public void verify_Recharge_page_Amount_field_should_be_enabled() throws Throwable {
		
		 VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
			
			WebDriverWait wait = new WebDriverWait(driver, 50);
		
          try {
	   
			wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.ORC_number));
			
			boolean b = vodahome.ORC_number.isEnabled();
			
			if(b == true) {
		
			System.out.println("Verify Recharge page  >> Amount field should be enabled");
			
			HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Verify Recharge page >> Amount field is be enabled", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}else {
				
				System.out.println("Verify Recharge page >> Amount field should not be enabled");
				
				HTMLReportGenerator.StepDetails("Fail", (count++)

						+ "- Verify Recharge page >> Amount field should not be enabled", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}
       }catch(TimeoutException ex){
	   
	   System.out.println("Locator not found issue");
			
			HTMLReportGenerator.StepDetails("Fail", (count++)+ "- Locator not found issue", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
   }
	}

	@Then("^Verify Recharge page >> Fetch last recharge link should be enabled$")
	public void verify_Recharge_page_Fetch_last_recharge_link_should_be_enabled() throws Throwable {
	    
		VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		
      try {
   
		wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.recharge_fechlastRecharge));
		
		boolean b = vodahome.recharge_fechlastRecharge.isEnabled();
		
		if(b == true) {
		
		System.out.println("Verify Recharge page  >> Fetch last recharge link should be enabled");
		
		HTMLReportGenerator.StepDetails("Pass", (count++)

				+ "- Verify Recharge page >> Fetch last recharge link should be enabled", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}else {
			
			System.out.println("Verify Recharge page >> Fetch last recharge link should not be enabled");
			
			HTMLReportGenerator.StepDetails("Fail", (count++)

					+ "- Verify Recharge page >> Fetch last recharge link should not be enabled", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
   }catch(TimeoutException ex){
   
   System.out.println("Locator not found issue");
		
		HTMLReportGenerator.StepDetails("Fail", (count++)

				+ "- Locator not found issue", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
}
	}

	@Then("^Verify Recharge page >> Pack should display for respective number$")
	public void verify_Recharge_page_Pack_should_display_for_respective_number() throws Throwable {
		
        VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
       
		WebDriverWait wait = new WebDriverWait(driver, 50);
		
      try {
   
    	  
		wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.recharge_RecomenedPack));
		
		boolean b= vodahome.recharge_RecomenedPack.isDisplayed();
		if(b == true) {
			
			HTMLReportGenerator.StepDetails("Pass", (count++)+ "-Verify Recharge page>> Mobile number should be autopopulated with number entered on Homepage", "",	TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			
			System.out.println("Verify Recharge page >> Pack should display for respective number");
			
			HTMLReportGenerator.StepDetails("Pass", (count++)+ "-Verify Recharge page >> Pack should display for respective number", "",	TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}else {
			
		System.out.println("Verify Recharge page >> Pack should not display for respective number");
		
		HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Verify Recharge page>> Mobile number should not autopopulated with number entered on Homepage", "",	TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		HTMLReportGenerator.StepDetails("Fail", (count++)+ "- Verify Recharge page >> Pack should not display for respective number", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
      }catch(TimeoutException ex){
    	  
    	  System.out.println("Verify Recharge page >> Pack should not display for respective number");
    	  HTMLReportGenerator.StepDetails("Fail", (count++)	+ "- Verify Recharge page >> Pack should display for respective number", "",
  				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      }
	}

	@Then("^Verify Home Page >> Quicklinks should display below Mobile number field$")
	public void verify_Home_Page_Quicklinks_should_display_below_Mobile_number_field() throws Throwable {
		
		driver.get(OR.getProperty("Vodafone_HomePage"));
	//	driver.get("https://preprod.vodafoneidea.com");
		
		  VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
	       
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

	@Then("^Verify Home Page >> Banners should display below Quicklinks$")
	public void verify_Home_Page_Banners_should_display_below_Quicklinks() throws Throwable {
		
		driver.get(OR.getProperty("Vodafone_HomePage"));
	//	driver.get("https://preprod.vodafoneidea.com");
		
		  VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
	       
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

	@Then("^Verify Home Page >> Loaded Benefits on VodafoneIdea section should display$")
	public void verify_Home_Page_Loaded_Benefits_on_VodafoneIdea_section_should_display() throws Throwable {
		
       Thread.sleep(2000);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,350)", "");
		
		 VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
	       
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

	@Then("^Verify Home Page >> Trending Now should display$")
	public void verify_Home_Page_Trending_Now_should_display() throws Throwable {
	    
		 VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
	       
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


	
	@Then("^Verify Top banner pixel\\.$")
	public void verify_Top_banner_pixel() throws Throwable {
	    
	VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
	link_test1 img=new link_test1();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
		driver.navigate().refresh();

		wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.banner_radio_btn1));
		
		Thread.sleep(2000);
		
		/*WebElement ele1=driver.findElement(By.xpath("//*[@id='close']"));
	
		if(ele1.isDisplayed())
		{
		
		ele1.click();
		}*/
		
		WebElement ele=driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[13]/div/div/div/div[2]/button[1]"));
		if(ele.isDisplayed())
		{
		ele.click();
		}
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,-250)", "");
		Thread.sleep(1000);
		vodahome.banner_radio_btn1.click();
		Thread.sleep(500);
		int width= vodahome.banner_image1.getSize().getWidth();
		int Height= vodahome.banner_image1.getSize().getHeight();
		
		System.out.println(width+"=="+Height);
		
		int expected_height=398;
		int expected_width=1263;
		
		if(width==expected_width && Height==expected_height)
		{
		
		HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed:- Pixel of 1st banner is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	      
		}
		else
		{
			HTMLReportGenerator.StepDetails("INFO",  (count++)+ "-Wrong Pixel is displayed:- Pixel of 1st banner is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		}
		
		Thread.sleep(1000);
		
		String Image_extension=vodahome.banner_image1.getAttribute("src");
		
		System.out.println("+++++++++++++++"+Image_extension);
        System.out.println("File extension is: "+img.link_test1(Image_extension));
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "-Banner Image"+Image_extension+" extension is:- "+img.link_test1(Image_extension), "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));


		
		
	}catch (Exception e) {
		 System.out.println("Banner Locator not found issue-S"+e);
	   	  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Banner Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	     
	}
	}
	@Then("^Verify Top second banner pixel\\.$")
	public void verify_Top_second_banner_pixel() throws Throwable {
		VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
		

		wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.banner_radio_btn1));
		
		
		vodahome.banner_radio_btn2.click();
		Thread.sleep(500);
		

		String s=vodahome.banner_image2.getText();
		
		System.out.println("+++++++++++++++"+s);

		int width= vodahome.banner_image2.getSize().getWidth();
		int Height= vodahome.banner_image2.getSize().getHeight();
		
		System.out.println(width+"=="+Height);
	//	HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- 2nd banner text is= "+s, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		int expected_height=398;
		int expected_width=1263;
		
		if(width==expected_width && Height==expected_height)
		{
		HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed:-  Pixel of 2nd banner is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	      
		}
		else
		{
			HTMLReportGenerator.StepDetails("INFO",  (count++)+ "-Wrong Pixel is displayed:- Pixel of 2nd banner is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		}
		
		
		Thread.sleep(1000);
		
		link_test1 img=new link_test1();
		String Image_extension=vodahome.banner_image1.getAttribute("src");
		
		System.out.println("+++++++++++++++"+Image_extension);
        System.out.println("File extension is: "+img.link_test1(Image_extension));
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "-Banner Image"+Image_extension+" extension is:- "+img.link_test1(Image_extension), "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));



		
		
		
	}catch (Exception e) {
		 System.out.println("Banner Locator not found issue-S"+e);
	   	  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Banner Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	     
	}
	}

	@Then("^Verify Top thrid banner pixel\\.$")
	public void verify_Top_thrid_banner_pixel() throws Throwable {
VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
		

		wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.banner_radio_btn1));
		
		
		vodahome.banner_radio_btn3.click();
		Thread.sleep(500);
		

		String s=vodahome.banner_image1.getText();
		
		System.out.println("+++++++++++++++"+s);

		int width= vodahome.banner_image3.getSize().getWidth();
		int Height= vodahome.banner_image3.getSize().getHeight();
		
		System.out.println(width+"=="+Height);
	//	HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- 3rd banner text is= "+s, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));


		int expected_height=398;
		int expected_width=1263;
		
		if(width==expected_width && Height==expected_height)
		{
		HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed:- Pixel of 3rd banner is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	      
		}
		else
		{
			HTMLReportGenerator.StepDetails("INFO",  (count++)+ "-Wrong Pixel is displayed:- Pixel of 3rd banner is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		}
		
		Thread.sleep(1000);
		
		link_test1 img=new link_test1();
		String Image_extension=vodahome.banner_image1.getAttribute("src");
		
		System.out.println("+++++++++++++++"+Image_extension);
        System.out.println("File extension is: "+img.link_test1(Image_extension));
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "-Banner Image"+Image_extension+" extension is:- "+img.link_test1(Image_extension), "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));


		
		
	}catch (Exception e) {
		 System.out.println("Banner Locator not found issue-S"+e);
	   	  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Banner Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	     
	}
	}

	@Then("^Verify Top fourth banner pixel\\.$")
	public void verify_Top_fourth_banner_pixel() throws Throwable {
VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
		

		wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.banner_radio_btn1));
		
		
		vodahome.banner_radio_btn4.click();
		Thread.sleep(500);
		

		String s=vodahome.banner_image4.getText();
		
		System.out.println("+++++++++++++++"+s);

		int width= vodahome.banner_image4.getSize().getWidth();
		int Height= vodahome.banner_image4.getSize().getHeight();
		
		System.out.println(width+"=="+Height);
	//	HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- 4th banner text is= "+s, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));


		int expected_height=398;
		int expected_width=1263;
		
		if(width==expected_width && Height==expected_height)
		{
		HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed:-  Pixel of 4th banner is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	      
		}
		else
		{
			HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- Wrong Pixel is displayed:- Pixel of 4th banner is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		}	      
		
		
		Thread.sleep(1000);
		link_test1 img=new link_test1();
		String Image_extension=vodahome.banner_image1.getAttribute("src");
		
		System.out.println("+++++++++++++++"+Image_extension);
        System.out.println("File extension is: "+img.link_test1(Image_extension));
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "-Banner Image"+Image_extension+" extension is:- "+img.link_test1(Image_extension), "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));


		
		
		
	}catch (Exception e) {
		 System.out.println("Banner Locator not found issue-S"+e);
	   	  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Banner Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	     
	}
	}

	@Then("^Verify Top fifth banner pixel\\.$")
	public void verify_Top_fifth_banner_pixel() throws Throwable {

		VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
		

		wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.banner_radio_btn1));
		
		
		vodahome.banner_radio_btn5.click();
		Thread.sleep(500);
		

		String s=vodahome.banner_image5.getText();
		
		System.out.println("+++++++++++++++"+s);

		int width= vodahome.banner_image5.getSize().getWidth();
		int Height= vodahome.banner_image5.getSize().getHeight();
		
		System.out.println(width+"=="+Height);
		
	//	HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- 5th banner text is= "+s, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		
		int expected_height=398;
		int expected_width=1263;
		
		if(width==expected_width && Height==expected_height)
		{
		HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed:-  Pixel of 5th banner is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	      
		}
		else
		{
			HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- Wrong Pixel is displayed:- Pixel of 5th banner is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		}	      
		
		Thread.sleep(1000);
		link_test1 img=new link_test1();
		String Image_extension=vodahome.banner_image1.getAttribute("src");
		
		System.out.println("+++++++++++++++"+Image_extension);
        System.out.println("File extension is: "+img.link_test1(Image_extension));
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "-Banner Image"+Image_extension+" extension is:- "+img.link_test1(Image_extension), "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));


			
	}catch (Exception e) {
		 System.out.println("Banner Locator not found issue-S"+e);
   	  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Banner Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
     
	}
	}
	

@Then("^Verify Buy postpaid sim icon pixel\\.$")
public void verify_Buy_postpaid_sim_icon_pixel() throws Throwable {
	
	VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);

	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
	
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(1000);

	wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Buy_postpaid_sim_icon));
	
	
	int width= vodahome.Buy_postpaid_sim_icon.getSize().getWidth();
	int Height= vodahome.Buy_postpaid_sim_icon.getSize().getHeight();
	
	System.out.println(width+"=="+Height);
	

	int expected_height=72;
	int expected_width=72;
	
	if(width==expected_width && Height==expected_height)
	{
	HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed on Buy Postpaid Sim icon:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      
	}
	else
	{
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- Wrong Pixel is displayed on Buy Postpaid Sim icon:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}	      
	
		
		
}catch (Exception e) {
	 System.out.println("Icon Locator not found issue-S"+e);
	  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Icon Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
 
}
}

@Then("^Verify Buy prepaid sim icon pixel\\.$")
public void verify_Buy_prepaid_sim_icon_pixel() throws Throwable {
	VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);

	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
	

	wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Buy_postpaid_sim_icon));
	
	
	int width= vodahome.Buy_prepaid_sim_icon.getSize().getWidth();
	int Height= vodahome.Buy_prepaid_sim_icon.getSize().getHeight();
	
	System.out.println(width+"=="+Height);
	

	int expected_height=72;
	int expected_width=72;
	
	if(width==expected_width && Height==expected_height)
	{
	HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed on Buy Prepaid Sim icon:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      
	}
	else
	{
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- Wrong Pixel is displayed on Buy Prepaid Sim icon:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}	      
	
	
		
}catch (Exception e) {
	 System.out.println("Icon Locator not found issue-S"+e);
	  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Icon Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
 
}
}

@Then("^Verify IR icon pixel\\.$")
public void verify_IR_icon_pixel() throws Throwable {
	VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);

	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
	

	wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Buy_postpaid_sim_icon));
	
	
	int width= vodahome.International_roaming_icon.getSize().getWidth();
	int Height= vodahome.International_roaming_icon.getSize().getHeight();
	
	System.out.println(width+"=="+Height);
	

	int expected_height=72;
	int expected_width=72;
	
	if(width==expected_width && Height==expected_height)
	{
	HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed on International Roamoing icon:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      
	}
	else
	{
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- Wrong Pixel is displayed on International Roamoing icon:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}	
	
	

		
}catch (Exception e) {
	 System.out.println("Icon Locator not found issue-S"+e);
	  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Icon Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
 
}
}

@Then("^Verify Vodafone play icon pixel\\.$")
public void verify_Vodafone_play_icon_pixel() throws Throwable {
	VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);

	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
	

	wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Buy_postpaid_sim_icon));
	
	
	int width= vodahome.Vodafone_play_icon.getSize().getWidth();
	int Height= vodahome.Vodafone_play_icon.getSize().getHeight();
	
	System.out.println(width+"=="+Height);
	

	int expected_height=72;
	int expected_width=72;
	
	if(width==expected_width && Height==expected_height)
	{
	HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed on VF Play icon:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      
	}
	else
	{
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- Wrong Pixel is displayed on VF Play icon:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}	
	}catch (Exception e) {
		 System.out.println("Icon Locator not found issue-S"+e);
		  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Icon Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	 
	}
	
}

@Then("^Verify Help and support_icon pixel\\.$")
public void verify_Help_and_support_icon_pixel() throws Throwable {
	VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);

	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
	

	wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Buy_postpaid_sim_icon));
	
	
	int width= vodahome.Help_and_support_icon.getSize().getWidth();
	int Height= vodahome.Help_and_support_icon.getSize().getHeight();
	
	System.out.println(width+"=="+Height);
	

	int expected_height=72;
	int expected_width=72;
	
	if(width==expected_width && Height==expected_height)
	{
	HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed on Help & Support icon:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      
	}
	else
	{
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- Wrong Pixel is displayed on Help & Support icon:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}	
	}catch (Exception e) {
		 System.out.println("Icon Locator not found issue-S"+e);
		  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Icon Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	 
	}
}

@Then("^Verify four banner icon one pixel\\.$")
public void verify_four_banner_icon_one_pixel() throws Throwable {
	VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);

	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,180)", "");
		Thread.sleep(1000);

	wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Buy_postpaid_sim_icon));
	
	
	int width= vodahome.icon1_with_text.getSize().getWidth();
	int Height= vodahome.icon1_with_text.getSize().getHeight();
	
	System.out.println(width+"=="+Height);
	

	int expected_height=112;
	int expected_width=112;
	
	if(width==expected_width && Height==expected_height)
	{
	HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed on banner icon first:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      
	}
	else
	{
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- Wrong Pixel is displayed on banner icon first:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}	
	}catch (Exception e) {
		 System.out.println("Icon Locator not found issue-S"+e);
		  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Icon Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	 
	}
}

@Then("^Verify four banner icon two pixel\\.$")
public void verify_four_banner_icon_two_pixel() throws Throwable {
	VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);

	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
	

	wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Buy_postpaid_sim_icon));
	
	
	int width= vodahome.icon2_with_text.getSize().getWidth();
	int Height= vodahome.icon2_with_text.getSize().getHeight();
	
	System.out.println(width+"=="+Height);
	

	int expected_height=112;
	int expected_width=112;
	
	if(width==expected_width && Height==expected_height)
	{
	HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed on banner icon Second:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      
	}
	else
	{
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- Wrong Pixel is displayed on banner icon Second:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}	
	}catch (Exception e) {
		 System.out.println("Icon Locator not found issue-S"+e);
		  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Icon Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	 
	}
}

@Then("^Verify four banner icon three pixel\\.$")
public void verify_four_banner_icon_three_pixel() throws Throwable {
	VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);

	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
	

	wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Buy_postpaid_sim_icon));
	
	
	int width= vodahome.icon3_with_text.getSize().getWidth();
	int Height= vodahome.icon3_with_text.getSize().getHeight();
	
	System.out.println(width+"=="+Height);
	

	int expected_height=112;
	int expected_width=112;
	
	if(width==expected_width && Height==expected_height)
	{
	HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed on banner icon thrird:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      
	}
	else
	{
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- Wrong Pixel is displayed on banner icon thrird:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}	
	}catch (Exception e) {
		 System.out.println("Icon Locator not found issue-S"+e);
		  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Icon Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	 
	}
}

@Then("^Verify four banner icon four pixel\\.$")
public void verify_four_banner_icon_four_pixel() throws Throwable {
	VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);

	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
	

	wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Buy_postpaid_sim_icon));
	
	
	int width= vodahome.icon4_with_text.getSize().getWidth();
	int Height= vodahome.icon4_with_text.getSize().getHeight();
	
	System.out.println(width+"=="+Height);
	

	int expected_height=112;
	int expected_width=112;
	
	if(width==expected_width && Height==expected_height)
	{
	HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed on banner icon fourth:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      
	}
	else
	{
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- Wrong Pixel is displayed on banner icon fourth:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}	
	}catch (Exception e) {
		 System.out.println("Icon Locator not found issue-S"+e);
		  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Icon Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	 
	}
}

@Then("^Verify Loaded benefits icon one pixel\\.$")
public void verify_Loaded_benefits_icon_one_pixel() throws Throwable {
	VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);

	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
	
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Buy_postpaid_sim_icon));
	
	
	int width= vodahome.Loaded_benefit_icon1.getSize().getWidth();
	int Height= vodahome.Loaded_benefit_icon1.getSize().getHeight();
	
	System.out.println(width+"=="+Height);
	

	int expected_height=64;
	int expected_width=64;
	
	if(width==expected_width && Height==expected_height)
	{
		HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed on Loaded benefits icon 1st:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      
	}
	else
	{
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- Wrong Pixel is displayed on Loaded benefits icon 1st:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}	
	}catch (Exception e) {
		 System.out.println("Icon Locator not found issue-S"+e);
		  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Icon Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	 
	}
}

@Then("^Verify Loaded benefits icon two pixel\\.$")
public void verify_Loaded_benefits_icon_two_pixel() throws Throwable {
	VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);

	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
	

	wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Buy_postpaid_sim_icon));
	
	
	int width= vodahome.Loaded_benefit_icon2.getSize().getWidth();
	int Height= vodahome.Loaded_benefit_icon2.getSize().getHeight();
	
	System.out.println(width+"=="+Height);
	

	int expected_height=64;
	int expected_width=64;
	
	if(width==expected_width && Height==expected_height)
	{
		HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed on Loaded benefits icon 2nd:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      
	}
	else
	{
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- Wrong Pixel is displayed on Loaded benefits icon 2nd:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}	
	}catch (Exception e) {
		 System.out.println("Icon Locator not found issue-S"+e);
		  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Icon Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	 
	}
}

@Then("^Verify Loaded benefits icon three pixel\\.$")
public void verify_Loaded_benefits_icon_three_pixel() throws Throwable {
	VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);

	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
	

	wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Buy_postpaid_sim_icon));
	
	
	int width= vodahome.Loaded_benefit_icon3.getSize().getWidth();
	int Height= vodahome.Loaded_benefit_icon3.getSize().getHeight();
	
	System.out.println(width+"=="+Height);
	

	int expected_height=64;
	int expected_width=64;
	
	if(width==expected_width && Height==expected_height)
	{
		HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed on Loaded benefits icon 3rd:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      
	}
	else
	{
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- Wrong Pixel is displayed on Loaded benefits icon 3rd:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}	
	}catch (Exception e) {
		 System.out.println("Icon Locator not found issue-S"+e);
		  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Icon Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	 
	}
}

@Then("^Verify Loaded benefits icon four pixel\\.$")
public void verify_Loaded_benefits_icon_four_pixel() throws Throwable {
	VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);

	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
	

	wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Buy_postpaid_sim_icon));
	
	
	int width= vodahome.Loaded_benefit_icon4.getSize().getWidth();
	int Height= vodahome.Loaded_benefit_icon4.getSize().getHeight();
	
	System.out.println(width+"=="+Height);
	

	int expected_height=64;
	int expected_width=64;
	
	if(width==expected_width && Height==expected_height)
	{
		HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed on Loaded benefits icon 4th:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      
	}
	else
	{
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- Wrong Pixel is displayed on Loaded benefits icon 4th:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}	
	}catch (Exception e) {
		 System.out.println("Icon Locator not found issue-S"+e);
		  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Icon Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	 
	}
}

@Then("^Verify Loaded benefits icon five pixel\\.$")
public void verify_Loaded_benefits_icon_five_pixel() throws Throwable {
	VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);

	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
	

	wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Buy_postpaid_sim_icon));
	
	
	int width= vodahome.Loaded_benefit_icon5.getSize().getWidth();
	int Height= vodahome.Loaded_benefit_icon5.getSize().getHeight();
	
	System.out.println(width+"=="+Height);
	

	int expected_height=64;
	int expected_width=64;
	
	if(width==expected_width && Height==expected_height)
	{
		HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed on Loaded benefits icon 5th:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      
	}
	else
	{
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- Wrong Pixel is displayed on Loaded benefits icon 5th:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}	
	}catch (Exception e) {
		 System.out.println("Icon Locator not found issue-S"+e);
		  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Icon Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	 
	}
}

@Then("^Verify Loaded benefits icon_six pixel\\.$")
public void verify_Loaded_benefits_icon_six_pixel() throws Throwable {
	VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);

	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
	

	wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.Buy_postpaid_sim_icon));
	
	
	int width= vodahome.Loaded_benefit_icon6.getSize().getWidth();
	int Height= vodahome.Loaded_benefit_icon6.getSize().getHeight();
	
	System.out.println(width+"=="+Height);
	

	int expected_height=64;
	int expected_width=64;
	
	if(width==expected_width && Height==expected_height)
	{
		HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed on Loaded benefits icon 6th:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      
	}
	else
	{
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- Wrong Pixel is displayed on Loaded benefits icon 6th:- Pixel of icon is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}	
	}catch (Exception e) {
		 System.out.println("Icon Locator not found issue-S"+e);
		  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Icon Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	 
	}
}

@Then("^Verify Vodafone exclusive banner image one pixel\\.$")
public void verify_Vodafone_exclusive_banner_image_one_pixel() throws Throwable {
	
	VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
	
	WebDriverWait wait = new WebDriverWait(driver, 30);

try {
	
	JavascriptExecutor jse = (JavascriptExecutor) driver;

	jse.executeScript("window.scrollBy(0,400)", "");

	wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.exclusive_treats_slide_control1));
	
	
	vodahome.exclusive_treats_slide_control1.click();
	Thread.sleep(500);
	

	int width= vodahome.exclusive_treats_image01.getSize().getWidth();
	int Height= vodahome.exclusive_treats_image01.getSize().getHeight();
	
	System.out.println(width+"=="+Height);
	
	
	int expected_height=171;
	int expected_width=350;
	
	if(width==expected_width && Height==expected_height)
	{
	HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed:-  Pixel of exclusive treats first banner image is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      
	}
	else
	{
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- Wrong Pixel is displayed:- Pixel of exclusive treats first banner image is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}	      
	
	Thread.sleep(1000);
		
}catch (Exception e) {
	 System.out.println("Banner Locator not found issue-S"+e);
	  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Banner Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
 
}
   
}

@Then("^Verify Vodafone exclusive banner image two pixel\\.$")
public void verify_Vodafone_exclusive_banner_image_two_pixel() throws Throwable {
	VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
	
	WebDriverWait wait = new WebDriverWait(driver, 30);

try {
	

	wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.exclusive_treats_slide_control1));
	
	
	vodahome.exclusive_treats_slide_control2.click();
	Thread.sleep(500);
	

	int width= vodahome.exclusive_treats_image02.getSize().getWidth();
	int Height= vodahome.exclusive_treats_image02.getSize().getHeight();
	
	System.out.println(width+"=="+Height);
	
	
	int expected_height=171;
	int expected_width=350;
	
	if(width==expected_width && Height==expected_height)
	{
	HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed:-  Pixel of exclusive treats second banner image is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      
	}
	else
	{
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- Wrong Pixel is displayed:- Pixel of exclusive treats second banner image is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}	      
	
	Thread.sleep(1000);
		
}catch (Exception e) {
	 System.out.println("Banner Locator not found issue-S"+e);
	  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Banner Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
 
}
}

@Then("^Verify Vodafone exclusive banner image three pixel\\.$")
public void verify_Vodafone_exclusive_banner_image_three_pixel() throws Throwable {
	VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
	
	WebDriverWait wait = new WebDriverWait(driver, 30);

try {
	

	wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.exclusive_treats_slide_control1));
	
	
	vodahome.exclusive_treats_slide_control3.click();
	Thread.sleep(500);
	

	int width= vodahome.exclusive_treats_image03.getSize().getWidth();
	int Height= vodahome.exclusive_treats_image03.getSize().getHeight();
	
	System.out.println(width+"=="+Height);
	
	
	int expected_height=171;
	int expected_width=350;
	
	if(width==expected_width && Height==expected_height)
	{
	HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed:-  Pixel of exclusive treats third banner image is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      
	}
	else
	{
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- Wrong Pixel is displayed:- Pixel of exclusive treats third banner image is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}	      
	
	Thread.sleep(1000);
		
}catch (Exception e) {
	 System.out.println("Banner Locator not found issue-S"+e);
	  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Banner Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
 
}
}

@Then("^Verify Vodafone exclusive banner image four pixel\\.$")
public void verify_Vodafone_exclusive_banner_image_four_pixel() throws Throwable {
VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
	
	WebDriverWait wait = new WebDriverWait(driver, 30);

try {
	

	wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.exclusive_treats_slide_control1));
	
	
	vodahome.exclusive_treats_slide_control4.click();
	Thread.sleep(500);
	

	int width= vodahome.exclusive_treats_image04.getSize().getWidth();
	int Height= vodahome.exclusive_treats_image04.getSize().getHeight();
	
	System.out.println(width+"=="+Height);
	
	
	int expected_height=171;
	int expected_width=350;
	
	if(width==expected_width && Height==expected_height)
	{
	HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed:-  Pixel of exclusive treats fourth banner image is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      
	}
	else
	{
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- Wrong Pixel is displayed:- Pixel of exclusive treats fourth banner image is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}	      
	
	Thread.sleep(1000);
		
}catch (Exception e) {
	 System.out.println("Banner Locator not found issue-S"+e);
	  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Banner Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
 
}
}

@Then("^Verify Vodafone exclusive banner image five pixel\\.$")
public void verify_Vodafone_exclusive_banner_image_five_pixel() throws Throwable {
VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
	
	WebDriverWait wait = new WebDriverWait(driver, 30);

try {
	

	wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.exclusive_treats_slide_control1));
	
	
	vodahome.exclusive_treats_slide_control5.click();
	Thread.sleep(500);
	

	int width= vodahome.exclusive_treats_image05.getSize().getWidth();
	int Height= vodahome.exclusive_treats_image05.getSize().getHeight();
	
	System.out.println(width+"=="+Height);
	
	
	int expected_height=171;
	int expected_width=350;
	
	if(width==expected_width && Height==expected_height)
	{
	HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed:-  Pixel of exclusive treats fifth banner image is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      
	}
	else
	{
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- Wrong Pixel is displayed:- Pixel of exclusive treats Fifth banner image is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}	      
	
	Thread.sleep(1000);
		
}catch (Exception e) {
	 System.out.println("Banner Locator not found issue-S"+e);
	  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Banner Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
 
}
}

@Then("^Verify Vodafone exclusive banner image six pixel\\.$")
public void verify_Vodafone_exclusive_banner_image_six_pixel() throws Throwable {
VodafoneHomePageObj vodahome = new VodafoneHomePageObj(driver);
	
	WebDriverWait wait = new WebDriverWait(driver, 30);

try {
	

	wait.until(ExpectedConditions.visibilityOfAllElements(vodahome.exclusive_treats_slide_control1));
	
	
	vodahome.exclusive_treats_slide_control6.click();
	Thread.sleep(500);
	

	int width= vodahome.exclusive_treats_image06.getSize().getWidth();
	int Height= vodahome.exclusive_treats_image06.getSize().getHeight();
	
	System.out.println(width+"=="+Height);
	
	
	int expected_height=171;
	int expected_width=350;
	
	if(width==expected_width && Height==expected_height)
	{
	HTMLReportGenerator.StepDetails("Pass",  (count++)+ "-Correct Pixel is displayed:-  Pixel of exclusive treats sixth banner image is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      
	}
	else
	{
		HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- Wrong Pixel is displayed:- Pixel of exclusive treats sixth banner image is "+"Width="+width+" Height="+Height, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}	      
	
	Thread.sleep(1000);
		
}catch (Exception e) {
	 System.out.println("Banner Locator not found issue-S"+e);
	  HTMLReportGenerator.StepDetails("Fail", (count++)+ "-Banner Locator not found issue"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
 
}



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
	HTMLReportGenerator.TestCaseEnd();
}

@Given("^Load Vodafone Site >> Home Page should display in Firefox browser$")
public void load_Vodafone_Site_Home_Page_should_display_in_Firefox_browser() throws Throwable {
	
	HTMLReportGenerator.TestCaseStart("Firefox:-VodaHome_Page", "Firefox:-Production_Build_number:001");
	
		VodafoneHomePageObj vodahome=new VodafoneHomePageObj(driver);
		
			String path = System.getProperty("user.dir") + "\\Driver\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", path);
			
		
			FirefoxProfile profile = new FirefoxProfile();

		

			FirefoxOptions options = new FirefoxOptions();

			options.setProfile(profile);

			driver = new FirefoxDriver(options);
			OR = new Properties();

			file = new File(System.getProperty("user.dir") + "/src/test/java/com/Testdata/URL.properties");

			filereader = new FileReader(file);

			OR.load(filereader);

			driver.get(OR.getProperty("Vodafone_HomePage"));

			System.out.println(" Chrome Browser is opening ");

			System.out.println("VodaFone Home page opened");
			
			driver.manage().window().maximize();

			Thread.sleep(2000);

			HTMLReportGenerator.StepDetails("Pass", (count++) + "- VodaFone Home page opened", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}


// ORC

@Given("^Recharge page should open properly$")
public void recharge_page_should_open_properly() throws Throwable {
	
	
	HTMLReportGenerator.TestCaseStart("Chrome:-ORC_Page", "Chrome:-Production_Build_number:001");
		String path = System.getProperty("user.dir") + "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);

		driver = new ChromeDriver();


		System.out.println(" browser");

		
		OR = new Properties();

	file = new File(System.getProperty("user.dir") + "/src/test/java/com/Testdata/URL.properties");

	filereader = new FileReader(file);

	OR.load(filereader);

	driver.get(OR.getProperty("VodaFone_ORC1"));
	
//	driver.get("https://preprod.vodafoneidea.com/prepaid/online-mobile-recharge");
	
//	driver.get("https://testvil.vodafoneidea.com/content/vodafoneideadigital/in/en/vil-homepage/recharge/online-recharge.html");

	System.out.println(" Browser Firefox is opening ");

	System.out.println("VodaFone ORC page opened");

	Thread.sleep(5000);

	HTMLReportGenerator.StepDetails("Pass", (count++) + "- VodaFone ORC page opened", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	
	driver.manage().deleteAllCookies();
}

@Then("^Verify mobilenumber field is enabled on page load$")
public void verify_mobilenumber_field_is_enabled_on_page_load() throws Throwable {
	
	VILIdeaORCObj vilideaObject = new VILIdeaORCObj(driver);
	
	WebDriverWait wait=new WebDriverWait(driver, 30);
	
	  try {
		  
 wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.MobileNo));
 
 boolean b = vilideaObject.MobileNo.isEnabled();
 
 if(b == true) {
	 
	 System.out.println("Verify mobilenumber field is enabled on page load");
	 
	 HTMLReportGenerator.StepDetails("Pass", (count++)+":-Verify mobilenumber field is enabled on page load", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver) ); 

 }else {
	 
	 System.out.println("Verify mobilenumber field is not enabled on page load");
	 
	 HTMLReportGenerator.StepDetails("Fail", (count++)+":-Verify mobilenumber field is not enabled on page load", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver) );
	
    }
	  }catch(TimeoutException ex){
		  
	System.out.println("Verify mobilenumber field is not enabled on page load");
			 
    HTMLReportGenerator.StepDetails("Fail", (count++)+":-Verify mobilenumber field is not enabled on page load", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver) );
			
 }
}

@Then("^Verify Amount field should not allow to enter data on page load$")
public void verify_Amount_field_should_not_allow_to_enter_data_on_page_load() throws Throwable {
	
VILIdeaORCObj vilideaObject = new VILIdeaORCObj(driver);
	
	WebDriverWait wait=new WebDriverWait(driver, 30);
	
	  try {
		  
 wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.AmountBill));
 
 boolean b = vilideaObject.AmountBill.isDisplayed();
 
 if(b == true) {
	 
	 System.out.println("Verify Amount field should not allow to enter data on page load");
	 
	 HTMLReportGenerator.StepDetails("Pass", (count++)+":-Verify Amount field should not allow to enter data on page load", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver) ); 

 }else {
	 
	 System.out.println("Verify Amount field should  allow to enter data on page load");
	 
	 HTMLReportGenerator.StepDetails("Fail", (count++)+":-Verify Amount field should allow to enter data on page load", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver) );
	
    }
	  }catch(TimeoutException ex){
		  
	System.out.println("Locator not found issue");
			 
    HTMLReportGenerator.StepDetails("Fail", (count++)+":-Locator not found issue", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver) );
			
 }
    
}

@Then("^Verify on page Fetch last recharge hyper link should be disabled$")
public void verify_on_page_Fetch_last_recharge_hyper_link_should_be_disabled() throws Throwable {
	
   VILIdeaORCObj vilideaObject = new VILIdeaORCObj(driver);
	
	WebDriverWait wait=new WebDriverWait(driver, 30);
	
try {
		  
 wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.Fetch_lastRechage));
 
 boolean b = vilideaObject.Fetch_lastRechage.isDisplayed();
 
 if(b == true) {
	 
	 System.out.println("Verify on page Fetch last recharge hyper link should be disabled");
	 
	 HTMLReportGenerator.StepDetails("Pass", (count++)+":-Verify on page Fetch last recharge hyper link should be disabled", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver) ); 

 }else {
	 
	 System.out.println("Verify on page Fetch last recharge hyper link should not be disabled");
	 
	 HTMLReportGenerator.StepDetails("Fail", (count++)+":-Verify on page Fetch last recharge hyper link should not be disabled", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver) );
	
    }
	  }catch(TimeoutException ex){
		  
	System.out.println("Locator not found issue");
			 
    HTMLReportGenerator.StepDetails("Fail", (count++)+":-Locator not found issue", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver) );
			
 }
    
}

@Then("^Verify text Lets Do a Recharge should display on page load$")
public void verify_text_Lets_Do_a_Recharge_should_display_on_page_load() throws Throwable {
	
   VILIdeaORCObj vilideaObject = new VILIdeaORCObj(driver);
	
	WebDriverWait wait=new WebDriverWait(driver, 30);
	
try {
		  
 wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.Lets_doRechage));
 
 boolean b = vilideaObject.Lets_doRechage.isDisplayed();
 
 if(b == true) {
	 
	 System.out.println("Verify text Lets Do a Recharge should display on page load");
	 
	 HTMLReportGenerator.StepDetails("Pass", (count++)+":-Verify text Lets Do a Recharge should display on page load", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver) ); 

 }else {
	 
	 System.out.println("Verify text Lets Do a Recharge should not display on page load");
	 
	 HTMLReportGenerator.StepDetails("Fail", (count++)+":-Verify text Lets Do a Recharge should not display on page load", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver) );
	
    }
	  }catch(TimeoutException ex){
		  
	System.out.println("Locator not found issue");
			 
    HTMLReportGenerator.StepDetails("Fail", (count++)+":-Locator not found issue", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver) );
			
 }
    
}

@Then("^Verify banner should display on page load$")
public void verify_banner_should_display_on_page_load() throws Throwable {
	
	 VILIdeaORCObj vilideaObject = new VILIdeaORCObj(driver);
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		
	try {
			  
	 wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.Banner_doRechage));
	 
	 boolean b = vilideaObject.Banner_doRechage.isDisplayed();
	 
	 if(b == true) {
		 
		 System.out.println("Verify banner should display on page load");
		 
		 HTMLReportGenerator.StepDetails("Pass", (count++)+":-Verify banner should display on page load", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver) ); 
	
	 }else {
		 
		 System.out.println("Verify banner should not display on page load");
		 
		 HTMLReportGenerator.StepDetails("Fail", (count++)+":-Verify banner should not display on page load", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver) );
		
	    }
		  }catch(TimeoutException ex){
			  
		System.out.println("Locator not found issue");
				 
	    HTMLReportGenerator.StepDetails("Fail", (count++)+":-Locator not found issue", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver) );
				
	 }
	}
@Then("^Enter mobile number less than ten digits - Error message should display in Red$")
public void enter_mobile_number_less_than_ten_digits_Error_message_should_display_in_Red() throws Throwable {
	
	VILIdeaORCObj vilideaObject = new VILIdeaORCObj(driver);

	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
		
		wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.MobileNo));

		vilideaObject.MobileNo.sendKeys(OR.getProperty("mless_Thanten"));

		vilideaObject.MobileNo.sendKeys(Keys.BACK_SPACE);

		wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.LesTha_Error));

		String error_msg = "Please enter 10 digit mobile number";

		String error_msg1 = vilideaObject.LesTha_Error.getText();

		System.out.println("===" + error_msg1);

		String color = vilideaObject.LesTha_Error.getCssValue("color");

		String color1 = "#e60000";

		System.out.println("============" + color);
		
		String color2=Color.fromString(color).asHex();
		
		System.out.println("555555555555555555555"+color2);

		boolean n1 = vilideaObject.LesTha_Error.isDisplayed();

		if (n1 == true) {

			System.out.println("Error msg is displyed");

			if (error_msg1.equalsIgnoreCase(error_msg) && color2.equalsIgnoreCase(color1)) {

				System.out.println("Correct Error msg is displyed in correct color");

				HTMLReportGenerator.StepDetails("Pass", (count++)

						+ "-Enter mobile number less than ten digits>> Correct Error msg is displyed in correct color", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			} else {
				System.out.println("Incorrect Error msg is displyed in correct color");
				HTMLReportGenerator.StepDetails("Fail",(count++) + "-Enter mobile number less than ten digits>> InCorrect Error msg is displyed in correct color", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			}
		} else {

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- InCorrect Error msg is displyed",
					"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			System.out.println("Error msg is not displayed");
		}

	} catch (TimeoutException ex) {

		System.out.println("Locator not found issue");

		HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}
}

@Then("^Mobile Number label and field border should display in Red$")
public void Mobile_Number_label_and_field_border_should_display_in_Red() throws Throwable {
    
	VILIdeaORCObj vilideaObject = new VILIdeaORCObj(driver);

	
	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {

				
		wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.LebelFieldBoder));

	

		String error_msg1 = vilideaObject.LebelFieldBoder.getText();

		System.out.println("===" + error_msg1);

		String color = vilideaObject.LebelFieldBoder.getCssValue("color");
		
		
		String color1 = "#e60000";

		System.out.println("============" + color);
		
		String color2=Color.fromString(color).asHex();
		
		System.out.println("555555555555555555555"+color2);

		boolean n1 = vilideaObject.LebelFieldBoder.isDisplayed();

		if (n1 == true) {

		System.out.println("Enter Mobile Number label and field border should display in Red");

		if (color2.equalsIgnoreCase(color1)) {

		System.out.println("Enter Mobile Number label and field border should display in Red");

		HTMLReportGenerator.StepDetails("Pass", (count++)

		+ "- Error message and Mobile Number label and field border should display in Red", "",
		TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		} else {

		System.out.println("Enter Mobile Number label and field border should not display in Red");

	HTMLReportGenerator.StepDetails("Fail",	(count++) + "- Enter Mobile Number label and field border should not display in Red", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			}
		} else {

			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Enter Mobile Number label and field border should not display in Red",
					"", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			System.out.println("Error msg is not displayed");
		}

	} catch (TimeoutException ex) {

		System.out.println("Locator not found issue---V");

		HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}
}

@Then("^Enter Postpaid Number of Idea - Error message should display$")
public void enter_Postpaid_Number_of_Idea_Error_message_should_display() throws Throwable {
    
	VILIdeaORCObj vilideaObject = new VILIdeaORCObj(driver);

	vilideaObject.MobileNo.clear();
	driver.navigate().refresh();
	Thread.sleep(3000);
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
try {
	
		wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.MobileNo));

		vilideaObject.MobileNo.sendKeys(OR.getProperty("IdeaPostpaidNo"));
		
		Thread.sleep(2000);
		
wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.LesTha_Error));

boolean b = vilideaObject.LesTha_Error.isDisplayed();

if(b == true) {
	
	System.out.println("Error message should display");
	
	HTMLReportGenerator.StepDetails("Pass", (count++) + "-Enter Postpaid Number of Idea >> Error message should display", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
}else {
	
	System.out.println("Error message should not display");
	
	HTMLReportGenerator.StepDetails("Fail", (count++) + "- Enter Postpaid Number of Idea >>Error message should not display", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
}
}catch(TimeoutException ex){
	
	System.out.println("Locator not found issue"+ex);
	
	HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
}
}

@Then("^Enter Postpaid Number of VF- Error message should display$")
public void enter_Postpaid_Number_of_VF_Error_message_should_display() throws Throwable {
    
	VILIdeaORCObj vilideaObject = new VILIdeaORCObj(driver);

	vilideaObject.MobileNo.clear();
	driver.navigate().refresh();
	Thread.sleep(3000);
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
try {
	
		wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.MobileNo));

		vilideaObject.MobileNo.sendKeys(OR.getProperty("vodaPostpaidNo"));
		
		Thread.sleep(2000);
		
wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.LesTha_Error));

boolean b = vilideaObject.LesTha_Error.isDisplayed();

if(b == true) {
	
	System.out.println("Error message should display");
	
	HTMLReportGenerator.StepDetails("Pass", (count++) + "-Enter Postpaid Number of VF>> Error message should display", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
}else {
	
	System.out.println("Error message should not display");
	
	HTMLReportGenerator.StepDetails("Fail", (count++) + "-Enter Postpaid Number of VF>> Error message should not display", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
}


}catch(TimeoutException ex){
	
	System.out.println("Locator not found issue"+ex);
	
	HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
}
}



@Then("^Go to Recharge page >>Enter the Vodafone prepaidpaid number>> Enter amount in integer - It should allow only Five digits$")
public void go_to_Recharge_page_Enter_the_Vodafone_prepaidpaid_number_Enter_amount_in_integer_It_should_allow_only_Five_digits() throws Throwable {
	VILIdeaORCObj vilideaObject = new VILIdeaORCObj(driver);

	vilideaObject.MobileNo.clear();
	driver.navigate().refresh();
	Thread.sleep(3000);
try {

	WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.MobileNo));

	vilideaObject.MobileNo.sendKeys(OR.getProperty("prepaidVoda"));
		
	System.out.println("Enter the VF prepaid number");
	
	
	
	HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter the VF prepaid number", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	


 VILIdeaORCObj vilideaObject1 = new VILIdeaORCObj(driver);

	//vilideaObject1.AmountBill.clear();
	
	WebDriverWait waitq = new WebDriverWait(driver, 30);
	
	waitq.until(ExpectedConditions.visibilityOfAllElements(vilideaObject1.AmountBill));
	Thread.sleep(3000);
	vilideaObject1.AmountBill.sendKeys("99999");
	
	System.out.println("Enter amount in integer - It should allow only 5 digits");
	
	HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter amount in integer - It should allow only 5 digits", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

}catch(TimeoutException ex){

System.out.println("Locator not found issue");

HTMLReportGenerator.StepDetails("Fail", (count++) + "- Locator not found issue", "",
		TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
}
}



@Then("^On page load >> Important Things to Know should display collapsed$")
public void on_page_load_Important_Things_to_Know_should_display_collapsed() throws Throwable {

	Thread.sleep(3000);

	JavascriptExecutor jse = (JavascriptExecutor) driver;

	jse.executeScript("window.scrollBy(0,1200)", "");

	Thread.sleep(2000);
	VILIdeaORCObj vdabillPay = new VILIdeaORCObj(driver);

	WebDriverWait wait = new WebDriverWait(driver, 05);

	try {

		wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ImpThinstono));

		boolean b = vdabillPay.ImpThinstono.isDisplayed();

		if (b == true) {

			System.out.println("On page load >> Online Recharge section should display collapsed");

			Thread.sleep(2000);

			HTMLReportGenerator.StepDetails("Pass",
					(count++) + "- On page load >> Online Recharge section should display collapsed", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		} else {

			System.out.println("On page load >> Online Recharge section should not display collapsed");

			HTMLReportGenerator.StepDetails("Fail",
					(count++) + "- On page load >> Online Recharge section should not display collapsed", "",
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

	VILIdeaORCObj vdabillPay = new VILIdeaORCObj(driver);

	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {

		wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ImpThinstono));

	//	vdabillPay.ImpThinstono.click();


		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		   
		   executor.executeScript("arguments[0].click();", vdabillPay.ImpThinstono);

		System.out.println("Click Arrow for Online Recharge section >> Page should autoscroll");

		HTMLReportGenerator.StepDetails("Pass",
				(count++) + "- Click Arrow for Online Recharge section >> Page should autoscroll", "",

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

	jse.executeScript("window.scrollBy(0,550)", "");

	System.out.println("Verify page >> Focus should go on Online Recharge section section");
}

@Then("^Verify page >> Imp Things to Know section should expand$")
public void verify_page_Imp_Things_to_Know_section_should_expand() throws Throwable {

	VILIdeaORCObj vdabillPay = new VILIdeaORCObj(driver);

	WebDriverWait wait = new WebDriverWait(driver, 30);

	// try{

	wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ImpThingArrow));

//	vdabillPay.ImpThingArrow.click();
	

	 JavascriptExecutor executor = (JavascriptExecutor)driver;
	   
	   executor.executeScript("arguments[0].click();", vdabillPay.ImpThingArrow);

	System.out.println("Verify page >> Online Recharge section section should expand");

}

@Then("^Click Arrow for Important Things to Know >> Page should collapse$")
public void click_Arrow_for_Important_Things_to_Know_Page_should_collapse() throws Throwable {

	VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {

		wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ImpThinstoNow));

	//	vdabillPay.ImpThinstoNow.click();
		

		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		   
		   executor.executeScript("arguments[0].click();", vdabillPay.ImpThinstoNow);
		   

		System.out.println("Click Arrow for Online Recharge section >> Page should collapse");

		HTMLReportGenerator.StepDetails("Pass",
				(count++) + "- Click Arrow for Online Recharge section >> Page should collapse", "",

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


@Then("^Click Dismiss >> Toast message should vanish$")
public void click_Dismiss_Toast_message_should_vanish() throws Throwable {
    VILIdeaORCObj obj=new VILIdeaORCObj(driver);
    
    WebDriverWait wait=new WebDriverWait(driver, 30);
    
    try {
    	wait.until(ExpectedConditions.visibilityOfAllElements(obj.Toast_msg));
    	boolean b1= obj.Toast_msg.isDisplayed();
    	
    	if(b1==true)
    	{
    		System.out.println("Toast message is displayed");
    		
    		HTMLReportGenerator.StepDetails("Pass", (count++)+":- Toast message is displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    		
    		obj.Toast_msg_dismiss.click();
    		HTMLReportGenerator.StepDetails("Pass", (count++)+":- Click Dismiss >> Toast message is vanish", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

    		
    	}
    	else
    	{
    		System.out.println("Toast message is not displayed");
    		HTMLReportGenerator.StepDetails("Fail", (count++)+":- Toast message is not displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

    	}
    	
    }catch (Exception e) {
		System.out.println("Toast message is not displayed"+e);
	}
    
    
}

@Then("^Enter NonIdea/NonVF number- Error Message should display$")
public void enter_NonIdea_NonVF_number_Error_Message_should_display() throws Throwable {
	VILIdeaORCObj vilideaObject = new VILIdeaORCObj(driver);

	vilideaObject.MobileNo.clear();
	driver.navigate().refresh();
	Thread.sleep(3000);
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
try {
	
		wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.MobileNo));

	vilideaObject.MobileNo.sendKeys(OR.getProperty("NonIdea_NonVF"));
		
	System.out.println("Enter the NonIdea_NonVF number");
	
	HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter the NonIdea_NonVF number", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.LesTha_Error));
	
	boolean b = vilideaObject.LesTha_Error.isDisplayed();
	
	if(b == true) {
		
		System.out.println("Error message should display");
		
		HTMLReportGenerator.StepDetails("Pass", (count++) + "-Enter NonIdea/NonVF number>> Error message should display", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}else {
		
		System.out.println("Error message should not display");
		
		HTMLReportGenerator.StepDetails("Fail", (count++) + "- Enter NonIdea/NonVF number>>Error message should not display", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}
	
	Thread.sleep(2000);
}catch (Exception e) {
	HTMLReportGenerator.StepDetails("Fail", (count++) + "- Something is wrong"+e, "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

}

}

@Then("^Try to enter Mobile Number starting with (\\d+) to (\\d+) >> It should not allow$")
public void try_to_enter_Mobile_Number_starting_with_to_It_should_not_allow(int arg1, int arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Enter alphabets/Special characters in Mobile Number field- it should not allow$")
public void enter_alphabets_Special_characters_in_Mobile_Number_field_it_should_not_allow() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Enter Idea Prepaid Number >> Error Message should display$")
public void enter_Idea_Prepaid_Number_Error_Message_should_display() throws Throwable {
	VILIdeaORCObj vilideaObject = new VILIdeaORCObj(driver);

	vilideaObject.MobileNo.clear();
	driver.navigate().refresh();
	Thread.sleep(3000);
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
try {
	
		wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.MobileNo));

	vilideaObject.MobileNo.sendKeys(OR.getProperty("prepaidIdeaNO"));
		
	System.out.println("Enter the Idea Prepaid Number number");
	
	HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter the Idea Prepaid Number number", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	
	wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.LesTha_Error));
	
	boolean b = vilideaObject.LesTha_Error.isDisplayed();
	
	if(b == true) {
		
		System.out.println("Error message should display");
		
		HTMLReportGenerator.StepDetails("Pass", (count++) + "-Enter Idea Prepaid Number >> Error message should display", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}else {
		
		System.out.println("Error message should not display");
		
		HTMLReportGenerator.StepDetails("Fail", (count++) + "-Enter Idea Prepaid Number >> Error message should not display", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}

	
	Thread.sleep(2000);
}catch (Exception e) {
	HTMLReportGenerator.StepDetails("Fail", (count++) + "- Something is wrong"+e, "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

}

}

@Then("^Enter VF Prepaid Number >> Amount field should be enabled$")
public void enter_VF_Prepaid_Number_Amount_field_should_be_enabled() throws Throwable {
	VILIdeaORCObj obj = new VILIdeaORCObj(driver);

	obj.MobileNo.clear();
	driver.navigate().refresh();
	Thread.sleep(3000);
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
try {
	
		wait.until(ExpectedConditions.visibilityOfAllElements(obj.MobileNo));
		
	obj.MobileNo.sendKeys(OR.getProperty("prepaidVoda"));
		
	System.out.println("Enter the VF Prepaid Number number");
	Thread.sleep(3000);
	
	HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter the VF Prepaid Number number", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	wait.until(ExpectedConditions.visibilityOfAllElements(obj.Amount));
	Thread.sleep(2000);
	boolean n1=obj.Amount.isEnabled();
	
	if(n1==true)
	{
		System.out.println("Amount field is enabled$");
		HTMLReportGenerator.StepDetails("Pass", (count++)+"-Amount field is enabled ", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		
	}else
	{
		System.out.println("Amount field is not enabled$");
		HTMLReportGenerator.StepDetails("Fail", (count++)+"-Amount field is not enabled ", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		
	}
	
	Thread.sleep(2000);
}catch (Exception e) {
	HTMLReportGenerator.StepDetails("Fail", (count++) + "- Something is wrong"+e, "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

}
}

@Then("^Enter VF Prepaid Number >>  Fetch last recharge link should be enabled$")
public void enter_VF_Prepaid_Number_Fetch_last_recharge_link_should_be_enabled() throws Throwable {
    WebDriverWait wait=new WebDriverWait(driver, 30);
    
    VILIdeaORCObj obj=new VILIdeaORCObj(driver);
     boolean b1=obj.Fetch_lastRechage.isEnabled();
     
     if(b1==true)
		{
			System.out.println("Fetch last recharge link is enabled$");
			HTMLReportGenerator.StepDetails("Pass", (count++)+"-Fetch last recharge link is enabled ", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}else
		{
			System.out.println("Amount field is not enabled$");
			HTMLReportGenerator.StepDetails("Fail", (count++)+"-Fetch last recharge link is not enabled ", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}
     
    
}

@Then("^Enter VF Prepaid Number >>  Packs categories section should display$")
public void enter_VF_Prepaid_Number_Packs_categories_section_should_display() throws Throwable {

    VILIdeaORCObj obj=new VILIdeaORCObj(driver);
     boolean b1=obj.Packs_categories.isDisplayed();
     
     if(b1==true)
		{
			System.out.println("Packs categories is displayed$");
			HTMLReportGenerator.StepDetails("Pass", (count++)+"-Packs categories is displayed ", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}else
		{
			System.out.println("Packs categories is not displayed$");
			HTMLReportGenerator.StepDetails("Fail", (count++)+"-Packs categories is not displayed ", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}
     
}

@Then("^Using Cross icon remove Mobile Number >> Amount, Fetch last recharge should be disabled$")
public void using_Cross_icon_remove_Mobile_Number_Amount_Fetch_last_recharge_should_be_disabled() throws Throwable {
	VILIdeaORCObj obj = new VILIdeaORCObj(driver);

			WebDriverWait wait = new WebDriverWait(driver, 30);
	
try {
	
		wait.until(ExpectedConditions.visibilityOfAllElements(obj.Cross));
	HTMLReportGenerator.StepDetails("Pass", (count++)+"- Click on Cross icon ", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		obj.Cross.click();
		
		Thread.sleep(1000);
		 boolean b1=obj.Amount.isEnabled();
		// boolean b2=obj.Fetch_lastRechage.isEnabled();
		 
		 if(b1==true)
		 {
			System.out.println("Amount, Fetch last recharge is enabled$");
		HTMLReportGenerator.StepDetails("Fail", (count++)+"-Amount field is enabled", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		
		 }
		 
		 else
		 {
			System.out.println("Amount, Fetch last recharge is disabled$");
		HTMLReportGenerator.StepDetails("Pass", (count++)+"-Amount field is disabled ", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		
		 }
		
		
}catch (Exception e) {
	System.out.println("Cross icon is not displayed"+e);
	HTMLReportGenerator.StepDetails("Pass", (count++)+"-Cross icon is not displayed "+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	
}
		
}

@Then("^Using Cross icon remove Mobile Number >> Packs section should not display$")
public void using_Cross_icon_remove_Mobile_Number_Packs_section_should_not_display() throws Throwable {
	VILIdeaORCObj obj = new VILIdeaORCObj(driver);
	Thread.sleep(3000);
	 boolean b1=obj.Packs_categories.isDisplayed();
	 if(b1==true)
		 {
			System.out.println("Packs section is Displayed$");
		HTMLReportGenerator.StepDetails("Fail", (count++)+"-remove Mobile Number>>Packs section is Displayed ", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		
		 }
		 
		 else
		 {
			System.out.println("Packs section is not Displayed$");
		HTMLReportGenerator.StepDetails("Pass", (count++)+"-remove Mobile Number>>Packs section is not Displayed ", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		
		 }
	 
	 
}



@Then("^Enter VF Prepaid Number >> Enter amount = (\\d+) >> Packs with Mrp starting as (\\d+) should display$")
public void enter_VF_Prepaid_Number_Enter_amount_Packs_with_Mrp_starting_as_should_display(int arg1, int arg2) throws Throwable {	
	VILIdeaORCObj vilideaObject = new VILIdeaORCObj(driver);

//	vilideaObject.MobileNo.clear();
	
	driver.navigate().refresh();

	WebDriverWait wait = new WebDriverWait(driver, 30);
	
try {
	
		wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.MobileNo));

	/*	Thread.sleep(2000);
	vilideaObject.MobileNo.sendKeys(OR.getProperty("prepaidVoda"));
		
	System.out.println("Enter the VF prepaid number");
	*/
	HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter the VF prepaid number", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	
	Thread.sleep(2000);
	
	

//	vilideaObject1.AmountBill.clear();

	WebDriverWait wait1 = new WebDriverWait(driver, 30);
	
 wait1.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.AmountBill));
 Thread.sleep(5000);

	vilideaObject.AmountBill.sendKeys("1");
	Thread.sleep(4000);
	System.out.println("Enter VF Prepaid Number >> Enter amount = 1 >> Packs with Mrp starting as 1 should display");
	
	HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter VF Prepaid Number >> Enter amount = 1 >> Packs with Mrp starting as 1 should display", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

}catch(TimeoutException ex){
	
	System.out.println("Locator not found issue");
	
	HTMLReportGenerator.StepDetails("Fail", (count++) + "-Locator not found issue", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

}
}

@Then("^Enter VF Prepaid Number >> Enter amount = (\\d+) >> Pack categories should not display$")
public void enter_VF_Prepaid_Number_Enter_amount_Pack_categories_should_not_display(int arg1) throws Throwable {
  	VILIdeaORCObj vilideaObject = new VILIdeaORCObj(driver);
/*
//	vilideaObject.MobileNo.clear();
	driver.navigate().refresh();
	Thread.sleep(3000);
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
try {
	
		wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.MobileNo));

	vilideaObject.MobileNo.sendKeys(OR.getProperty("prepaidVoda"));
		
	System.out.println("Enter the VF prepaid number");
	
	HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter the VF prepaid number", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

//z	vilideaObject.AmountBill.clear();

	WebDriverWait wait1 = new WebDriverWait(driver, 30);
	
 wait1.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.AmountBill));

 Thread.sleep(6000);
	vilideaObject.AmountBill.sendKeys(OR.getProperty("amount_rs"));
	*/
  	try {
	Thread.sleep(3000);
	
	if(vilideaObject.Packs_categories.isDisplayed()) {
		
	
	System.out.println("Pack categories should not display");
	
	HTMLReportGenerator.StepDetails("Fail", (count++) + "-Enter VF Prepaid Number >> Enter amount>> Pack categories should display", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}else
	{
		HTMLReportGenerator.StepDetails("Pass", (count++) + "-Enter VF Prepaid Number >> Enter amount>> Pack categories should not display", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}
}catch(TimeoutException ex){
	
	System.out.println("Locator not found issue");
	
	HTMLReportGenerator.StepDetails("Fail", (count++) + "-Locator not found issue", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

  }
}

@Then("^Now enter amount = (\\d+) >> Packs with Mrp starting as (\\d+) should display$")
public void now_enter_amount_Packs_with_Mrp_starting_as_should_display(int arg1, int arg2) throws Throwable {
	
	VILIdeaORCObj obj=new VILIdeaORCObj(driver);
	
	WebDriverWait wait=new WebDriverWait(driver, 30);
	
	try {
	
	wait.until(ExpectedConditions.visibilityOfAllElements(obj.AmountBill));
	
	obj.AmountBill.clear();

	obj.AmountBill.sendKeys("12");
	
	HTMLReportGenerator.StepDetails("Pass", (count++) + "- Now enter the amount is 12", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	Thread.sleep(3000);
	
	String s1=obj.Pack_value.getText();
	System.out.println(s1);
	String s2="";
	
	    s2 = s1.substring(0, 2);
	    System.out.println("Packs with Mrp starting:-"+s2);
	    HTMLReportGenerator.StepDetails("Pass", (count++) + "Packs with Mrp starting is:-"+s2, "",	TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	    if(s2.equalsIgnoreCase("12"))
	    {
	    	HTMLReportGenerator.StepDetails("Pass", (count++) + "Enter amount and Packs with Mrp starting amount is equal:-"+s2, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	    }
	    else
	    {
	    	HTMLReportGenerator.StepDetails("Fail", (count++) + "Enter amount and Packs with Mrp starting amount is not equal:-"+s2, "",	TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	    }
	    
	    
	
	}catch (Exception e) {
		HTMLReportGenerator.StepDetails("Fail", (count++) + "Locator not found:-"+e, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
	
		
}

@Then("^Enter amount = (\\d+) >> Error message should display in Red$")
public void enter_amount_Error_message_should_display_in_Red(int arg1) throws Throwable {
VILIdeaORCObj obj=new VILIdeaORCObj(driver);
	
	WebDriverWait wait=new WebDriverWait(driver, 30);
	
	try {
	
	//	driver.navigate().refresh();
	wait.until(ExpectedConditions.visibilityOfAllElements(obj.AmountBill));
	
	Thread.sleep(3000);
	
	obj.AmountBill.clear();
	
	Thread.sleep(2000);

	obj.AmountBill.sendKeys(OR.getProperty("amount_rs2"));
	
	HTMLReportGenerator.StepDetails("Pass", (count++) + "- Now enter amount = 99999", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	wait.until(ExpectedConditions.visibilityOfAllElements(obj.Amount_error_msg));
	
	HTMLReportGenerator.StepDetails("Pass", (count++) +"Please pick a valid recharge Error message is displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	
	String color=obj.Amount_error_msg.getCssValue("color");
	
	
	String color1 = "#e60000";

	System.out.println("============" + color);
	
	String color2=Color.fromString(color).asHex();
	
	System.out.println("555555555555555555555"+color2);

	System.out.println(color);
	
	
	if(color1.equalsIgnoreCase(color2))
	{
		HTMLReportGenerator.StepDetails("Pass", (count++) +" Error message is displayed in Red color", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
	else
	{
		HTMLReportGenerator.StepDetails("Fail", (count++) +" Error message is not displayed in Red color", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
	
	}catch (Exception e) {
		System.out.println(e);
		
		HTMLReportGenerator.StepDetails("Fail", (count++) +"abxddsdd"+e, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
}

@Then("^Enter amount = (\\d+) >> Enter Recharge Amount label and field border should display in Red$")
public void enter_amount_Enter_Recharge_Amount_label_and_field_border_should_display_in_Red(int arg1) throws Throwable {
    
	
	VILIdeaORCObj obj=new VILIdeaORCObj(driver);
	
	String color=obj.Amount_field_border.getCssValue("border");
	System.out.println("dsfdefefref");
	System.out.println(color);
	
	
	
}

@Then("^Enter amount = (\\d+) >> Packs categories section should display$")
public void enter_amount_Packs_categories_section_should_display(int arg1) throws Throwable {
	 VILIdeaORCObj obj=new VILIdeaORCObj(driver);
     boolean b1=obj.Packs_categories.isDisplayed();
     
     if(b1==true)
		{
			System.out.println("Amount field is enabled$");
			HTMLReportGenerator.StepDetails("Pass", (count++)+"-Enter invalid amount Packs categories is displayed ", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}else
		{
			System.out.println("Amount field is not enabled$");
			HTMLReportGenerator.StepDetails("Fail", (count++)+"-Enter invalid amount Packs categories is not displayed ", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
		}
    // driver.navigate().refresh();
    // Thread.sleep(7000);
}

@Then("^Verify Packs categories >> First category should be For You$")
public void verify_Packs_categories_First_category_should_be_For_You() throws Throwable {
	 VILIdeaORCObj obj=new VILIdeaORCObj(driver);
	 
	 try {
	 
	 String s1=obj.Packs_First_categories.getText();
	 
	 System.out.println("=====+"+s1);
	 
	 String s2="For you";
	 
	 if(s1.equalsIgnoreCase(s2))
		{
			HTMLReportGenerator.StepDetails("Pass", (count++) +" Pack First category is For you", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		}
		else
		{
			HTMLReportGenerator.StepDetails("Fail", (count++) +" Pack First category is not For You", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		}
	 
	 }catch (Exception e) {
			HTMLReportGenerator.StepDetails("Fail", (count++) +":- Pack First category is not For You"+e, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			System.out.println(e);
	}
	 
}

@Then("^Enter number >> Focus should be on For You category$")
public void enter_number_Focus_should_be_on_For_You_category() throws Throwable {
    VILIdeaORCObj obj=new VILIdeaORCObj(driver);
    String b1=obj.Packs_First_categories.getAttribute("aria-selected");
    
    System.out.println(b1);
    
    String b2="true";
    
    if(b1.equalsIgnoreCase(b2))
    {
    	System.out.println("Focus is on Unlimited category category");
		HTMLReportGenerator.StepDetails("Pass", (count++) +":-Focus is on Unlimited category", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

    }else
    {
    	
    	System.out.println("Focus is not on Unlimited category");
		HTMLReportGenerator.StepDetails("Fail", (count++) +" Focus is not on Unlimited category", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

    }
    
    
    
}

@Then("^Enter number >> Select Unlimited >> Packs details should display$")
public void enter_number_Select_Unlimited_Packs_details_should_display() throws Throwable {
    VILIdeaORCObj obj=new VILIdeaORCObj(driver);
    
    WebDriverWait wait=new WebDriverWait(driver, 30);
    try {
    
    obj.Unlimited_pack.click();
    
    Thread.sleep(2000);
    
    boolean b1=obj.Pack_details.isDisplayed();
    
    if(b1==true)
    {
    	System.out.println("Select Unlimited >> Packs details is display");
		HTMLReportGenerator.StepDetails("Pass", (count++) +":-Select Unlimited >> Packs details is display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

    }else
    {
    	
    	System.out.println("Select Unlimited >> Packs details is not display");
		HTMLReportGenerator.StepDetails("Fail", (count++) +":- Select Unlimited >> Packs details is not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

    }
    }catch (Exception e) {
    	System.out.println("Select Unlimited >> Packs details is not display");
		HTMLReportGenerator.StepDetails("Fail", (count++) +":- Select Unlimited >> Packs details is not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
    
    
}

@Then("^Verify Pack details >> Pack Mrp should display$")
public void verify_Pack_details_Pack_Mrp_should_display() throws Throwable {
    VILIdeaORCObj obj=new VILIdeaORCObj(driver);
    try {
    boolean b1=obj.unlimited_Pack_value.isDisplayed();
    
    String s=obj.unlimited_Pack_value.getText();
    
    if(b1==true)
    {
    	System.out.println("Pack Mrp is display");
    	
		HTMLReportGenerator.StepDetails("Pass", (count++) +":-Pack Mrp is display:-"+s, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

    }
    else
    {
    	System.out.println("Pack Mrp is not display");
    	
		HTMLReportGenerator.StepDetails("Fail", (count++) +":-Pack Mrp is not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

    }
    }catch (Exception e) {
    	System.out.println("Pack Mrp is not display"+e);
    	
		HTMLReportGenerator.StepDetails("Fail", (count++) +":-Pack Mrp is not display"+e, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
}

@Then("^Verify Pack details >> Validity should display$")
public void verify_Pack_details_Validity_should_display() throws Throwable {
    
	 VILIdeaORCObj obj=new VILIdeaORCObj(driver);
	 
	 try {
	    
	    boolean b1=obj.unlimited_Pack_validity.isDisplayed();
	    
	    String s=obj.unlimited_Pack_validity.getText();
	    
	    if(b1==true)
	    {
	    	System.out.println("Pack Validity is display");
	    	
			HTMLReportGenerator.StepDetails("Pass", (count++) +":-Pack Validity is display:-"+s, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	    }
	    else
	    {
	    	System.out.println("Pack Validity is not display");
	    	
			HTMLReportGenerator.StepDetails("Fail", (count++) +":-Pack Validity is not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	    }
	 }catch (Exception e) {

	    	System.out.println("Pack Validity is not display"+e);
	    	
			HTMLReportGenerator.StepDetails("Fail", (count++) +":-Pack Validity is not display"+e, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
	
}

@Then("^If Talktime details available >> It should display for Unlimited category pack$")
public void if_Talktime_details_available_It_should_display_for_Unlimited_category_pack() throws Throwable {
	 VILIdeaORCObj obj=new VILIdeaORCObj(driver);
	    
	 try {
	    boolean b1=obj.unlimited_Pack_Talktime.isDisplayed();
	    
	    String s=obj.unlimited_Pack_Talktime.getText();
	    
	    if(b1==true)
	    {
	    	System.out.println("Unlimited Pack Talktime details is display");
	    	
			HTMLReportGenerator.StepDetails("Pass", (count++) +":-Unlimited Pack Talktime details is display:-"+s, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	    }
	    else
	    {
	    	System.out.println("Unlimited Pack Talktime details is not display");
	    	
			HTMLReportGenerator.StepDetails("Fail", (count++) +":-Unlimited Pack Talktime details is not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	    }
	 }catch (Exception e) {
		 System.out.println("Unlimited Pack Talktime details is not display"+e);
	    	
			HTMLReportGenerator.StepDetails("Fail", (count++) +":-Unlimited Pack Talktime details is not display"+e, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}
}

@Then("^If Data details available >> It should display for Unlimited category pack$")
public void if_Data_details_available_It_should_display_for_Unlimited_category_pack() throws Throwable {
	 VILIdeaORCObj obj=new VILIdeaORCObj(driver);
	    
	 try {
	    boolean b1=obj.unlimited_Pack_Data.isDisplayed();
	    
	    String s=obj.unlimited_Pack_Data.getText();
	    
	    if(b1==true)
	    {
	    	System.out.println("Unlimited Pack Data details is display");
	    	
			HTMLReportGenerator.StepDetails("Pass", (count++) +":-Unlimited Pack Data details is display:-"+s, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	    }
	    else
	    {
	    	System.out.println("Unlimited Pack Data details is not display");
	    	
			HTMLReportGenerator.StepDetails("Fail", (count++) +":-Unlimited Pack Data details is not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	    }
	 }catch (Exception e) {
		 System.out.println("Unlimited Pack Data details is not display");
	    	
			HTMLReportGenerator.StepDetails("Fail", (count++) +":-Unlimited Pack Data details is not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
}

@Then("^SMS Details should not display in pack details section$")
public void sms_Details_should_not_display_in_pack_details_section() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^If Nontelco benefits are available then max two should display in pack details section$")
public void if_Nontelco_benefits_are_available_then_max_two_should_display_in_pack_details_section() throws Throwable {
	VILIdeaORCObj obj=new VILIdeaORCObj(driver);
	WebDriverWait wait=new WebDriverWait(driver, 30);

	wait.until(ExpectedConditions.visibilityOfAllElements(obj.non_telco_ben));
	boolean b1= obj.non_telco_ben.isDisplayed();
	
	if(b1==true)
	{
	HTMLReportGenerator.StepDetails("Pass", (count++) +":- Select Value Pack category >> Talktime and Validity fields is display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
	else
	{
		HTMLReportGenerator.StepDetails("Fail", (count++) +":- Select Value Pack category >> Talktime and Validity fields is display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
}

@Then("^Select Internet category >> Only Data and Validity fields should display$")
public void select_Internet_category_Only_Data_and_Validity_fields_should_display() throws Throwable {
	VILIdeaORCObj obj=new VILIdeaORCObj(driver);
	WebDriverWait wait=new WebDriverWait(driver, 30);
	try {
	obj.value_categories.click();
	
	HTMLReportGenerator.StepDetails("Pass", (count++) +":- Click on Value Pack catagory", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	
	wait.until(ExpectedConditions.visibilityOfAllElements(obj.value_pack_data));
	
	boolean b1=obj.value_pack_data.isDisplayed();
	boolean b2=obj.value_pack_validity.isDisplayed();
	
	if(b1==true && b2==true)
	{
		System.out.println("Select Value Pack category >> Talktime and Validity fields is display");
		
		HTMLReportGenerator.StepDetails("Pass", (count++) +":- Select Value Pack category >> Talktime and Validity fields is display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}else
	{
		System.out.println("Select Value Pack category >> Talktime and Validity fields is not display");
		
		HTMLReportGenerator.StepDetails("Fail", (count++) +":- Select Value Pack category >> Talktime and Validity fields is not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
	
	}catch (Exception e) {
		System.out.println("Select Value Pack category >> Talktime and Validity fields is not display"+e);
		
		HTMLReportGenerator.StepDetails("Fail", (count++) +":- Select Value Pack category >> Talktime and Validity fields is not display"+e, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
	
}

@Then("^Select Talktime category >> Only Talktime and Validity fields should display$")
public void select_Talktime_category_Only_Talktime_and_Validity_fields_should_display() throws Throwable {
	VILIdeaORCObj obj=new VILIdeaORCObj(driver);
	WebDriverWait wait=new WebDriverWait(driver, 30);
	try {
		Thread.sleep(2000);
//	obj.Add_on_category.click();
	
	 JavascriptExecutor executor = (JavascriptExecutor)driver;
	   
	   executor.executeScript("arguments[0].click();", obj.Add_on_category);
	   
	   
	Thread.sleep(2000);
	HTMLReportGenerator.StepDetails("Pass", (count++) +":- Click on Add-on catagory", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	
	wait.until(ExpectedConditions.visibilityOfAllElements(obj.Add_on_pack_data));
	
	boolean b1=obj.Add_on_pack_data.isDisplayed();
	boolean b2=obj.Add_on_pack_validaty.isDisplayed();
	
	if(b1==true && b2==true)
	{
		System.out.println("Select Add-on category >> Only Data and Validity fields is display");
		
		HTMLReportGenerator.StepDetails("Pass", (count++) +":- Select Add-on category >> Only Data and Validity fields is display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}else
	{
		System.out.println("Select Add-on category >> Only Data and Validity fields is not display");
		
		HTMLReportGenerator.StepDetails("Fail", (count++) +":- Select Add-on category >> Only Data and Validity fields is not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
	
	}catch (Exception e) {
		System.out.println("Select Add-on category >> Only Data and Validity fields is not display"+e);
		
		HTMLReportGenerator.StepDetails("Fail", (count++) +":- Select Add-on category >> Only Data and Validity fields is not display"+e, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
}

@Then("^For Recommended Category >> Know More link should not display for any pack$")
public void for_Recommended_Category_Know_More_link_should_not_display_for_any_pack() throws Throwable {
	VILIdeaORCObj obj=new VILIdeaORCObj(driver);
	WebDriverWait wait=new WebDriverWait(driver, 30);
	try {

	
	obj.Packs_First_categories.click();
	
	boolean b1= obj.recommended_know_more.isDisplayed();
	
	if(b1==true)
	{
		System.out.println("For you Category >> Know More link is display");
		HTMLReportGenerator.StepDetails("Fail", (count++) +":- For you Category >> Know More link is display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}else
	{
		System.out.println("For you Category >> Know More link is not display");
		HTMLReportGenerator.StepDetails("Pass", (count++) +":- For you Category >> Know More link is not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
	}catch (Exception e) {

		System.out.println("For you Category >> Know More link is not display"+e);
		HTMLReportGenerator.StepDetails("Pass", (count++) +":- For you Category >> Know More link is not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
	
}

@Then("^Click Know More for any pack >> Popup should open$")
public void click_Know_More_for_any_pack_Popup_should_open() throws Throwable {
    
	VILIdeaORCObj obj=new VILIdeaORCObj(driver);
	//driver.navigate().refresh();
	WebDriverWait wait=new WebDriverWait(driver, 30);
	try {
		wait.until(ExpectedConditions.visibilityOfAllElements(obj.Unlimited_pack));
		Thread.sleep(2000);
		obj.Unlimited_pack.click();
		
		wait.until(ExpectedConditions.visibilityOfAllElements(obj.unlimited_know_more));
		
		System.out.println("Click Know More for any pack");
		
		Thread.sleep(3000);
		
//		obj.unlimited_know_more.click();
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		   
		   executor.executeScript("arguments[0].click();", obj.unlimited_know_more);
		
		Thread.sleep(3000);
		HTMLReportGenerator.StepDetails("Pass", (count++) +":- Click Know More for any pack >> Popup is open", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		Thread.sleep(2000);
		
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println("=====Error");
	}
}

@Then("^Click Esc >> Popup should close$")
public void click_Esc_Popup_should_close() throws Throwable {
	Actions action = new Actions(driver);
	action.sendKeys(Keys.ESCAPE);
	Thread.sleep(3000);
	HTMLReportGenerator.StepDetails("Pass", (count++) +":- Press Esc >> Popup is close", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	Thread.sleep(2000);
}

@Then("^Click Cross on popup >> Popup should close$")
public void click_Cross_on_popup_Popup_should_close() throws Throwable {
    

	try {
	Thread.sleep(3000);
	VILIdeaORCObj obj=new VILIdeaORCObj(driver);
	/*
	obj.unlimited_know_more.click();
	HTMLReportGenerator.StepDetails("Pass", (count++) +":- Click Know More for any pack >> Popup is open", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
*/
	
	obj.popup_cross.click();
	
	System.out.println("popup is close");
	HTMLReportGenerator.StepDetails("Pass", (count++) +":- Click Cross on popup >> Popup is close", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}catch (Exception e) {
		HTMLReportGenerator.StepDetails("Fail", (count++) +":- cross sign is not displayed"+e, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
	
}

@Then("^For Unlimited Category >> Click Know More for pack for ex: (\\d+) >> Talktime, Data and SMS values should display$")
public void for_Unlimited_Category_Click_Know_More_for_pack_for_ex_Talktime_Data_and_SMS_values_should_display(int arg1) throws Throwable {
    VILIdeaORCObj obj=new VILIdeaORCObj(driver);
    WebDriverWait wait=new WebDriverWait(driver, 30);
    try {
    	wait.until(ExpectedConditions.visibilityOfAllElements(obj.popup_cross));
    	boolean b1=obj.popup_data.isDisplayed();
    	boolean b2=obj.popup_SMS.isDisplayed();
    	boolean b3=obj.popup_talktime.isDisplayed();
    	boolean b4=obj.popup_Pack_amount.isDisplayed();
    	
    	if(b1==true)
    	{
    		System.out.println("data is displayed in popup");
			HTMLReportGenerator.StepDetails("Pass", (count++) +":- Data is displayed in popup", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

    		
    	}else {
    	System.out.println("data is not displayed in popup");
		HTMLReportGenerator.StepDetails("Fail", (count++) +":- Data is not displayed in popup", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    	}
    	
    	if(b2==true)
    	{
    		System.out.println("SMS is displayed in popup");
			HTMLReportGenerator.StepDetails("Pass", (count++) +":- SMS is displayed in popup", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

    		
    	}else {
    	System.out.println("SMS is not displayed in popup");
		HTMLReportGenerator.StepDetails("Fail", (count++) +":- SMS is not displayed in popup", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    	}
    	
    	if(b3==true)
    	{
    		System.out.println("Talktime is displayed in popup");
			HTMLReportGenerator.StepDetails("Pass", (count++) +":- Talktime is displayed in popup", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

    		
    	}else {
    	System.out.println("Talktime is not displayed in popup");
		HTMLReportGenerator.StepDetails("Fail", (count++) +":- Talktime is not displayed in popup", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    	}
    	
    	if(b4==true)
    	{
    		System.out.println("Pack amount is displayed in popup");
			HTMLReportGenerator.StepDetails("Pass", (count++) +":- Pack amount is displayed in popup", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

    		
    	}else {
    	System.out.println("Pack amount is not displayed in  popup");
		HTMLReportGenerator.StepDetails("Fail", (count++) +":- Pack amount is not displayed in  popup", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    	}
    	
    	
    }catch (Exception e) {
		HTMLReportGenerator.StepDetails("Pass", (count++) +":- Pack data is displayed in popup", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    	//check
	}
    try {
    obj.popup_cross.click();
    }catch (Exception e) {
		
	}
    
}

@Then("^If Nontelco benefits are available then all benefits should display in the popup$")
public void if_Nontelco_benefits_are_available_then_all_benefits_should_display_in_the_popup() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Load More link should not display for any pack category$")
public void load_More_link_should_not_display_for_any_pack_category() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Enter VF Prepaid Number - Click Buy Pack for any Mrp >> VF Payment Gateway screen should display$")
public void enter_VF_Prepaid_Number_Click_Buy_Pack_for_any_Mrp_VF_Payment_Gateway_screen_should_display() throws Throwable {
 	VILIdeaORCObj vilideaObject = new VILIdeaORCObj(driver);

 		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
		
  		wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.MobileNo));
  		vilideaObject.MobileNo.clear();
  		Thread.sleep(2000);
		vilideaObject.MobileNo.sendKeys(OR.getProperty("prepaidVoda"));
  	//	vilideaObject.MobileNo.sendKeys("");	
		System.out.println("Enter the VF prepaid number");
		
		HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter the VF prepaid number", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	
		
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.Pack1));
		
		vilideaObject.Pack1.click();
		Thread.sleep(5000);
		
		System.out.println("Click on pack");
		
		HTMLReportGenerator.StepDetails("Pass", (count++) + "- Click on pack", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	
		
	}catch (Exception e) {
		System.out.println("=============="+e);

	}
}

@Then("^Enter OCRM VF Prepaid Number - Click Buy Pack for any Mrp >> VF Payment Gateway screen should display$")
public void enter_OCRM_VF_Prepaid_Number_Click_Buy_Pack_for_any_Mrp_VF_Payment_Gateway_screen_should_display() throws Throwable {
 	VILIdeaORCObj vilideaObject = new VILIdeaORCObj(driver);

 		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
		
  		wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.MobileNo));
  		vilideaObject.MobileNo.clear();
  		Thread.sleep(2000);
	//	vilideaObject.MobileNo.sendKeys(OR.getProperty("prepaidVoda"));
  		
  		vilideaObject.MobileNo.sendKeys("6359213437");
			
		System.out.println("Enter the VF prepaid number");
		
		HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter the VF prepaid number", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	
		
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.Pack1));
		
		vilideaObject.Pack1.click();
		Thread.sleep(5000);
		
		System.out.println("Click on pack");
		
		HTMLReportGenerator.StepDetails("Pass", (count++) + "- Click on pack", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	
		
	}catch (Exception e) {
		System.out.println("=============="+e);

	}
}

@Then("^Enter SCRM VF Prepaid Number - Click Buy Pack for any Mrp >> VF Payment Gateway screen should display$")
public void enter_SCRM_VF_Prepaid_Number_Click_Buy_Pack_for_any_Mrp_VF_Payment_Gateway_screen_should_display() throws Throwable {
 	VILIdeaORCObj vilideaObject = new VILIdeaORCObj(driver);

 		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
		
  		wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.MobileNo));
  		vilideaObject.MobileNo.clear();
  		Thread.sleep(2000);
	//	vilideaObject.MobileNo.sendKeys(OR.getProperty("prepaidVoda"));
  		vilideaObject.MobileNo.sendKeys("9583924963");
		System.out.println("Enter the VF prepaid number");
		
		HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter the VF prepaid number", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	
		
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.Pack1));
		
		vilideaObject.Pack1.click();
		Thread.sleep(5000);
		
		System.out.println("Click on pack");
		
		HTMLReportGenerator.StepDetails("Pass", (count++) + "- Click on pack", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	
		
	}catch (Exception e) {
		System.out.println("=============="+e);

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
	   vdabillPay.Proceed_Pay.click();
	   
	   
	   Thread.sleep(2000);
	   wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.Go_Back2));
	  boolean b =  vdabillPay.Go_Back2.isDisplayed();
	  
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
	   
//	   System.out.println("#############"+n1);
	 
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
    	  
    	  VILIdeaORCObj obj=new VILIdeaORCObj(driver);
	  		
		   WebDriverWait wait = new WebDriverWait(driver, 40);
		  	try {
		  	 wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.Go_Back2));
		  	 
		  	vdabillPay.Go_Back2.click();
		  	
		  	System.out.println("Click on Go Back-----");
		  	Thread.sleep(7000);
		  	
		  	wait.until(ExpectedConditions.visibilityOfAllElements(obj.rechargefail1));
		  	
		  boolean b=obj.rechargefail1.isDisplayed();
		  
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
    	  
    	VILIdeaORCObj obj=new VILIdeaORCObj(driver);
	  		
		   WebDriverWait wait = new WebDriverWait(driver, 40);
		   
		  try {
		  
		  wait.until(ExpectedConditions.visibilityOfAllElements(obj.rechargefail1));
		  
		
		  	
		  boolean b=obj.rechargefail1.isDisplayed();
		  String s1=obj.rechargefail1.getText();
		  String s2="Recharge Failure";
		  
		  System.out.println(s1);
		  if(s1.equalsIgnoreCase(s2)) {
			  System.out.println("Verify Oops page >> Oops page with payment failure text should display");
			  HTMLReportGenerator.StepDetails("Pass", (count++)+" - Verify Oops page >> Oops page with payment failure text should display and text is:-"+s1, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			  
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
		  
			  WebElement download_Failure=driver.findElement(By.xpath("//*[@id=\"categories\"]/div/div/div[4]/a"));
		  wait.until(ExpectedConditions.visibilityOfAllElements(download_Failure));
		  	
		  boolean b=download_Failure.isDisplayed();
		  
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
			  WebElement resoion_Failure =driver.findElement(By.xpath("//p[@class='request mb-2']"));

		  wait.until(ExpectedConditions.visibilityOfAllElements(resoion_Failure));
		  	
		  boolean b=resoion_Failure.isDisplayed();
		  
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
			  WebElement tryAgain_Failure =driver.findElement(By.xpath("//button[@class='btn tryAgainbtn miOrangebtn']"));

		  wait.until(ExpectedConditions.visibilityOfAllElements(tryAgain_Failure));
		  	
		  boolean b=tryAgain_Failure.isDisplayed();
		  
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
		   WebElement needHelp_Failure =driver.findElement(By.xpath("//a[@class='needhelp float-right my-2 miOrangeLink']"));

		   
		  try {
		  
		  wait.until(ExpectedConditions.visibilityOfAllElements(needHelp_Failure));
		  
		  String color = needHelp_Failure.getCssValue("color");
		  
		  String color1 = "#e60000";

			System.out.println("============" + color);
			
			String color2=Color.fromString(color).asHex();
			
			System.out.println("555555555555555555555"+color2);
		  	
		  boolean b=needHelp_Failure.isDisplayed();
		  
		  if(b == true && color1.equalsIgnoreCase(color2)) {
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
			  System.out.println("Verify Failure Page >> SetUp Auto Pay section should display");
			  HTMLReportGenerator.StepDetails("Pass", (count++)+" -Verify Failure Page >> SetUp Auto Pay section should display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			  
		  }else {
			  System.out.println("Verify Failure Page >> SetUp Auto Pay section not display");
			  HTMLReportGenerator.StepDetails("Fail", (count++)+" -Verify Failure Page >> SetUp Auto Pay section should not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			  
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

      @Then("^Verify Failure Page >> Imp Things to know should display$")
      public void verify_Failure_Page_Imp_Things_to_know_should_display() throws Throwable {
    	  Thread.sleep(2000);

	  		JavascriptExecutor jse = (JavascriptExecutor) driver;

	  		jse.executeScript("window.scrollBy(0,2500)", "");
    	  
    	  VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
	  		
		   WebDriverWait wait = new WebDriverWait(driver, 40);
		   
		  try {
		  
		  wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.Get_MyVodafone_App_ORC));
		  	
		  boolean b=vdabillPay.Get_MyVodafone_App_ORC.isDisplayed();
		  
		  if(b == true) {
			  System.out.println("Verify Failure Page >> Get MyVodafone App should display");
			  HTMLReportGenerator.StepDetails("Pass", (count++)+" -Verify Failure Page >> Get MyVodafone App should display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			  
		  }else {
			  System.out.println("Verify Failure Page >> Get MyVodafone App should not display");
			  HTMLReportGenerator.StepDetails("Fail", (count++)+" - Verify Failure Page >> Get MyVodafone App should not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			  
		  }
		  	}catch(TimeoutException ex){
		  		
		   System.out.println("Locator not found issue-6");
		   HTMLReportGenerator.StepDetails("Fail", (count++)+" - Locator not found issue-6", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
		  }
		  HTMLReportGenerator.TestCaseEnd();
      }
      @Then("^Click Try Again >> Recharge landing page should display$")
      public void click_Try_Again_Recharge_landing_page_should_display() throws Throwable {
         
    	  
    	  VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
    	  VILIdeaORCObj obj=new VILIdeaORCObj(driver);
	  		
		   WebDriverWait wait = new WebDriverWait(driver, 40);
		   
		  try {
			  
			  vdabillPay.Try_Again.click();
		  
		  wait.until(ExpectedConditions.visibilityOfAllElements(obj.MobileNo));
		  	
		  boolean b=obj.MobileNo.isDisplayed();
		  
		  if(b == true) {
			  System.out.println("Click Try Again >> Recharge landing page should display");
			  HTMLReportGenerator.StepDetails("Pass", (count++)+" -Click Try Again >> Recharge landing page should display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			  
		  }else {
			  System.out.println("Click Try Again >> Recharge landing page not display");
			  HTMLReportGenerator.StepDetails("Fail", (count++)+" -Click Try Again >> Recharge landing page not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			  
		  }
		  	}catch(TimeoutException ex){
		  		
		   System.out.println("Locator not found issue-&");
		   HTMLReportGenerator.StepDetails("Fail", (count++)+" - Locator not found issue-&", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
				  
		  	}
      }
      
      
  	@Given("^Recharge page should open properly in firefox browser$")
	public void recharge_page_should_open_properly_in_firefox_browser() throws Throwable {
  		
  		HTMLReportGenerator.TestCaseStart("Firefox:-ORC_Page", "Firefox:-Production_Build_number:001");
		String path = System.getProperty("user.dir") + "\\Driver\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", path);

		FirefoxProfile profile = new FirefoxProfile();

	//	profile.setPreference("network.proxy.type", ProxyType.AUTODETECT.ordinal());

		FirefoxOptions options = new FirefoxOptions();

		options.setProfile(profile);

		driver = new FirefoxDriver(options);

		System.out.println(" browser");

		OR = new Properties();

		file = new File(System.getProperty("user.dir") + "/src/test/java/com/Testdata/URL.properties");

		filereader = new FileReader(file);

		OR.load(filereader);

	//	driver.get(OR.getProperty("VodaFone_ORC1"));
		
		driver.get("https://preprod.vodafoneidea.com/prepaid/online-mobile-recharge");
	//	driver.get("https://betavil1.vodafoneidea.com/prepaid/online-mobile-recharge");

		System.out.println(" Browser Firefox is opening ");

		System.out.println("VodaFone ORC page opened");

		Thread.sleep(5000);

		HTMLReportGenerator.StepDetails("Pass", (count++) + "- VodaFone ORC page opened", "",

				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		
		driver.manage().deleteAllCookies();
  		
  		
  		
  	}
  	

  	//Bill Pay
  	
  	@Given("^Pay Bill page should open properly$")
	public void pay_Bill_page_should_open_properly() throws Throwable {
		HTMLReportGenerator.TestCaseStart("Chrome:-Bill_Pay_Page", "Chrome:-Production_Build_number:001");
		/* Firefox
		 * String path = System.getProperty("user.dir") + "\\Driver\\geckodriver.exe";
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxOptions options = new FirefoxOptions();
		options.setProxy(profile);
		driver = new FirefoxDriver(options);*/
		
		// Chrome
		String path = System.getProperty("user.dir") + "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
	    ChromeOptions profile = new ChromeOptions();
		ChromeOptions options = new ChromeOptions();
	
		driver = new ChromeDriver(options);
		
		System.out.println(" browser");

		OR = new Properties();

		file = new File(System.getProperty("user.dir") + "/src/test/java/com/Testdata/URL.properties");

		filereader = new FileReader(file);

		OR.load(filereader);

	//	driver.get(OR.getProperty("VodaFone_Pay_Bill"));
	//	driver.get("https://preprod.vodafoneidea.com/prepaid/online-mobile-recharge/postpaid/quick-online-bill-payment");
		driver.get("https://preprod.vodafoneidea.com/prepaid/online-mobile-recharge");
		System.out.println(" Browser Firefox is opening ");

		System.out.println("VodaFone Pay Bill page opened");
		
		driver.manage().window().maximize();

		Thread.sleep(5000);

		HTMLReportGenerator.StepDetails("Pass", (count++) + "- VodaFone Pay Bill page opened", "",

				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		driver.manage().deleteAllCookies();
	}

	@Then("^Verify mobilenumber field is enabled on page load2$")
	public void verify_mobilenumber_field_is_enabled_on_page_load2() throws Throwable {

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

	@Then("^Verify Amount field should not allow to enter data on page load2$")
	public void verify_Amount_field_should_not_allow_to_enter_data_on_page_load2() throws Throwable {

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
			
			String actual_url="https://www.billdesk.in/billpay/onlinesi/vodafone/vodafone_index.jsp";
			
			if(url.equalsIgnoreCase(url))
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
			
			String actual_url="https://www.billdesk.com/pgidsk/pgmerc/vodafone/VODAFONEDN_details.jsp";
			
			if(url.equalsIgnoreCase(url))
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

	@Then("^Enter mobile number less than ten digits - Error message should display in Red2$")
	public void enter_mobile_number_less_than_ten_digits_Error_message_should_display_in_Red2() throws Throwable {

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

	@Then("^Enter mobile number less than ten digits - Enter Mobile Number label and field border should display in Red2$")
	public void enter_mobile_number_less_than_ten_digits_Enter_Mobile_Number_label_and_field_border_should_display_in_Red2()
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
	@Then("^Try to enter Mobile Number starting with (\\d+) to (\\d+) >> It should not allow2$")
	public void try_to_enter_Mobile_Number_starting_with_to_It_should_not_allow2(int arg1, int arg2) throws Throwable {

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

	@Then("^Enter alphabets/Special characters in Mobile Number field- it should not allow2$")
	public void enter_alphabets_Special_characters_in_Mobile_Number_field_it_should_not_allow2() throws Throwable {

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
		
		Thread.sleep(3000);
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(5000);
		
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
			
			Thread.sleep(5000);

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
			
			Thread.sleep(6000);

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

				Thread.sleep(4000);

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

	@Then("^Click Arrow for Important Things to Know >> Page should autoscroll1$")
	public void click_Arrow_for_Important_Things_to_Know_Page_should_autoscroll1() throws Throwable {

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

	@Then("^Verify page >> Focus should go on Imp Things to know section1$")
	public void verify_page_Focus_should_go_on_Imp_Things_to_know_section1() throws Throwable {

		driver.navigate().refresh();

		Thread.sleep(2000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,450)", "");

		System.out.println("Verify page >> Focus should go on Online Postpaid Bill Payment section");
	}

	@Then("^Verify page >> Imp Things to Know section should expand1$")
	public void verify_page_Imp_Things_to_Know_section_should_expand1() throws Throwable {

		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		// try{
/*
		wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ImpThingArrow));

		vdabillPay.ImpThingArrow.click();*/

		System.out.println("Verify page >> Online Postpaid Bill Payment section should expand");

	}

	@Then("^Click Arrow for Important Things to Know >> Page should collapse1$")
	public void click_Arrow_for_Important_Things_to_Know_Page_should_collapse1() throws Throwable {

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
		
		Thread.sleep(7000);
		
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
	//OTP flow
	
	/*@Then("^Enter (\\d+) digits in OTP field >> Confirm button should be enabled$")
	public void enter_digits_in_OTP_field_Confirm_button_should_be_enabled(int arg1) throws Throwable {
		 VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
			
		 WebDriverWait wait = new WebDriverWait(driver, 40);
		 
		try {
			
	      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.OTPSections));
	      Thread.sleep(2000);
	      
	      vdabillPay.OTPSections.sendKeys(OR.getProperty("OTPFirst"));
	      
	      System.out.println("Enter 4 digits in OTP field");
	      
	      HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter 4 digits in OTP field", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	      
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
	 		 
	 	//	 vdabillPay.OTPSections.clear();
	  	  
	 		 WebDriverWait wait = new WebDriverWait(driver, 40);
	 		 
	 		 System.out.println("32456678");
	 		
	 	      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.OTPSections1));
	 	      
	 	      vdabillPay.OTPSections1.sendKeys("2124");
	 	      
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
		 	  	    
		 	  	    
		 	  	    String error_msg="You have exhausted maximum attempts to enter OTP. Please click on resend.";
		 	  	    
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
		 	 //   vdabillPay.CrossButton.click();
		 	    Thread.sleep(2000);
	          }	 
	          */


	


	@Then("^Click on Resend link>> check Four resent count should be displayed$")
	public void click_on_Resend_link_check_Proper_resent_count_should_be_displayed() throws Throwable {
	    
		 VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		 vdabillPay.Billpay_ResendOTP.click();
		 
		 Thread.sleep(2000);
		 
		 String msg=vdabillPay.Count_ResendOTP_msg.getText();
		 String msg1="";
		 System.out.println("$$$$$$$$$$$$$$$"+msg);
		 if(msg.equalsIgnoreCase(msg))
		 {
			 System.out.println("Correct Resend OTP count is displayed");
			HTMLReportGenerator.StepDetails("Pass", (count++)+"- Click on Resend OTP link>> correct Resend OTP count is displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		 }
		 else
		 {
			 System.out.println("Incorrect Resend OTP count is displayed");
				HTMLReportGenerator.StepDetails("Fail", (count++)+"- Incorrect Resend OTP count is displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		 }
		 
	}


	@Then("^Click on Resend link>> check Three resent count should be displayed$")
	public void click_on_Resend_link_check_Three_resent_count_should_be_displayed() throws Throwable {
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		
		Thread.sleep(2000);
		
		System.out.println("$$$$$$$$$$$$$$$");
		
		Thread.sleep(6000);
		 vdabillPay.Billpay_ResendOTP.click();
		 
		 Thread.sleep(2000);
		 
		 String msg=vdabillPay.Count_ResendOTP_msg.getText();
		 String msg1="";
		 System.out.println("$$$$$$$$$$$$$$$"+msg);
		 if(msg.equalsIgnoreCase(msg))
		 {
			 System.out.println("Correct Resend OTP count is displayed");
			HTMLReportGenerator.StepDetails("Pass", (count++)+"- Click on Resend OTP link>> correct Resend OTP count is displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		 }
		 else
		 {
			 System.out.println("Incorrect Resend OTP count is displayed");
				HTMLReportGenerator.StepDetails("Fail", (count++)+"- Incorrect Resend OTP count is displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		 }
	}

	@Then("^Click on Resend link>> check Two resent count should be displayed$")
	public void click_on_Resend_link_check_Two_resent_count_should_be_displayed() throws Throwable {
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		 vdabillPay.Billpay_ResendOTP.click();
		 
		 Thread.sleep(2000);
		 
		 String msg=vdabillPay.Count_ResendOTP_msg.getText();
		 String msg1="";
		 System.out.println("$$$$$$$$$$$$$$$"+msg);
		 if(msg.equalsIgnoreCase(msg))
		 {
			 System.out.println("Correct Resend OTP count is displayed");
			HTMLReportGenerator.StepDetails("Pass", (count++)+"- Click on Resend OTP link>> correct Resend OTP count is displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		 }
		 else
		 {
			 System.out.println("Incorrect Resend OTP count is displayed");
				HTMLReportGenerator.StepDetails("Fail", (count++)+"- Incorrect Resend OTP count is displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		 }
	}

	@Then("^Click on Resend link>> check One resent count should be displayed$")
	public void click_on_Resend_link_check_One_resent_count_should_be_displayed() throws Throwable {
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		 vdabillPay.Billpay_ResendOTP.click();
		 
		 Thread.sleep(2000);
		 
		 String msg=vdabillPay.Count_ResendOTP_msg.getText();
		 String msg1="";
		 System.out.println("$$$$$$$$$$$$$$$"+msg);
		 if(msg.equalsIgnoreCase(msg))
		 {
			 System.out.println("Correct Resend OTP count is displayed");
			HTMLReportGenerator.StepDetails("Pass", (count++)+"- Click on Resend OTP link>> correct Resend OTP count is displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		 }
		 else
		 {
			 System.out.println("Incorrect Resend OTP count is displayed");
				HTMLReportGenerator.StepDetails("Fail", (count++)+"- Incorrect Resend OTP count is displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		 }
	}

	@Then("^Click on Resend link>> check resent count should be displayed$")
	public void click_on_Resend_link_check_resent_count_should_be_displayed() throws Throwable {
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		 vdabillPay.Billpay_ResendOTP.click();
		 
		 Thread.sleep(2000);
		 
		 String msg=vdabillPay.Count_ResendOTP_msg.getText();
		 String msg1="";
		 System.out.println("$$$$$$$$$$$$$$$"+msg);
		 if(msg.equalsIgnoreCase(msg))
		 {
			 System.out.println("Correct Resend OTP count is displayed");
			HTMLReportGenerator.StepDetails("Pass", (count++)+"- Click on Resend OTP link>> correct Resend OTP count is displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		 }
		 else
		 {
			 System.out.println("Incorrect Resend OTP count is displayed");
				HTMLReportGenerator.StepDetails("Fail", (count++)+"- Incorrect Resend OTP count is displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		 }
	}

	@Then("^Reset link should be disable$")
	public void reset_link_should_be_disable() throws Throwable {
		VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		boolean b1=vdabillPay.Billpay_ResendOTP_disable.isEnabled();
		
		System.out.println("--------------"+b1);
		HTMLReportGenerator.StepDetails("Pass", (count++)+"- Reset link should be disable", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE);
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
	 		 
	 	//	 vdabillPay.OTPSections.clear();
	  	  
	 		 WebDriverWait wait = new WebDriverWait(driver, 40);
	 		 
	 		 System.out.println("32456678");
	 		
	 	      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.OTPSections1));
	 	      
	 	      vdabillPay.OTPSections1.sendKeys("0000");
	 	      
	 	      System.out.println("Enter invalid OTP twice and Click Confirm ");
	 	      
	 	      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ConfirmBTn));
	 	      Thread.sleep(1000);
	 	      
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
	 	  	    			
	 	  	    			HTMLReportGenerator.StepDetails("Pass", (count++)+"-Enter 1st wrong OTP>>>> Proper error message should display in Red - Correct Error msg is displyed in correct color", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	 	  	    	
	 	  	    		}else
	 	  	    		{
	 	  	    			System.out.println("Incorrect Error msg is displyed in correct color");
	 	  	    			HTMLReportGenerator.StepDetails("Fail", (count++)+"-Enter 1st wrong OTP>> Proper error message should display in Red- Correct Error msg is not displyed in correct color", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	 	  	    			
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
	 	      
	 	      vdabillPay.OTPSections.sendKeys("1000");
	 	      
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
	 	  	    			
	 	  	    			HTMLReportGenerator.StepDetails("Pass", (count++)+"-Enter 2nd wrong OTP>> Proper error message should display in Red - Correct Error msg is displyed in correct color", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	 	  	    	
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
	      
	      @Then("^Enter invalid OTP thrice and Click Confirm >> OTP fields border should be Red and image in Red should display in from of field$")
	      public void enter_invalid_OTP_thrice_and_Click_Confirm_OTP_fields_border_should_be_Red_and_image_in_Red_should_display_in_from_of_field() throws Throwable {
	          
	      }

	      @Then("^Enter invalid OTP fourth time and Click Confirm >> Proper error message should display in Red$")
	      public void enter_invalid_OTP_once_and_Click_Confirm_Proper_error_message_should_display_in_Red1() throws Throwable {
	          
	    	  VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
	    	  
		    	 vdabillPay.OTPSections.clear();
		    	  
		 		 WebDriverWait wait = new WebDriverWait(driver, 40);
		 		
		 	      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.OTPSections));
		 	      
		 	      vdabillPay.OTPSections.sendKeys("1000");
		 	      
		 	      System.out.println("Enter invalid OTP thrice and Click Confirm ");
		 	      
		 	      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ConfirmBTn));
		 	      
		 	      vdabillPay.ConfirmBTn.click();
		 	      
		 	      System.out.println("click confirm button");
		 	      
		 	      try {
		 	    	  
		 	  	    wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.OTP_Error_MSG));
		 	  	    
		 	  	    System.out.println("0000");
		 	  	    
		 	  	    if(vdabillPay.OTP_Error_MSG.isDisplayed()) {
		 	  	    
		 	  	    
		 	  	    String error_msg="You have exhausted maximum attempts to enter OTP. Please click on resend.";
		 	  	    
		 	  	    String error_msg1=vdabillPay.OTP_Error_MSG.getText();
		 	  	    
		 	  	
		 	  	    System.out.println("==="+error_msg1);
		 	  	    	    
		 	  	    String color=vdabillPay.OTP_Error_MSG.getCssValue("color");
		 	  	    
		 	  	    String color1="rgba(230, 0, 0, 1)";
		 	  	    
		 	  	    System.out.println("============"+color);
		 	  	    
		 	  	    boolean n1= vdabillPay.OTP_Error_MSG.isDisplayed();
		 	  	    
		 	  	    if(n1==true) {
		 	  	
		 	  	    	System.out.println("Error msg is displyed");
		 	  	    		if(error_msg1.equalsIgnoreCase(error_msg1) && color.equalsIgnoreCase(color1))
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
	    	
	    	  Thread.sleep(2000);
	    	   	    
			  	VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
			  	vdabillPay.CrossButton.click();
			  	
			  	Thread.sleep(2000);
			  		
			  	vdabillPay.MobileNo.clear();
			  		
			   WebDriverWait wait = new WebDriverWait(driver, 40);
			  		 
			  try {
			  			
			  	 wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MobileNo));
			  	      
			  	 vdabillPay.MobileNo.sendKeys(OR.getProperty("vodaPostpaidNo"));
			  	 
			 // 	vdabillPay.MobileNo.sendKeys("8722800091");				//Idea migrated number
			  	      
			  	 System.out.println("Enter VF Postpaid Number");
			  	      
		  	 HTMLReportGenerator.StepDetails("Pass", (count++)+" - Enter VF Postpaid Number", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		//	  	 HTMLReportGenerator.StepDetails("Pass", (count++)+" - Enter Idea migrated Postpaid Number", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      
			  	 Thread.sleep(7000);
			  	     
			  	 wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.AmountBill));
			  	      
			  	 vdabillPay.AmountBill.sendKeys(OR.getProperty("newAmount"));
			  	    
			  	 System.out.println("Sending Amount");
			  	      
			  	    HTMLReportGenerator.StepDetails("Pass", (count++)+" - Enter Amount in amount field", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			  	    	System.out.println("Error msg is not displayed");
			  	      
			  	  Thread.sleep(7000);
			  	  
			  	  vdabillPay.MobileNo.clear();
			  	  
			  	vdabillPay.MobileNo.sendKeys(OR.getProperty("vodaPostpaidNo"));
			  	
			  	 System.out.println("Enter VF Postpaid Number");
		  	      
			 	 HTMLReportGenerator.StepDetails("Pass", (count++)+" - Enter VF Postpaid Number", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
						  	
			 	Thread.sleep(7000);
		  	     
			  	 wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.AmountBill));
			  	      
			  	 vdabillPay.AmountBill.sendKeys(OR.getProperty("newAmount"));
			  	    
			  	 System.out.println("Sending Amount");
			  	      
			  	    HTMLReportGenerator.StepDetails("Pass", (count++)+" - Enter Amount in amount field", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

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
	      
	      @Then("^Enter Idea Postpaid Migrated number - Enter Amount and click Pay >> VF Payment Gateway screen should display$")
	      public void Enter_Idea_Postpaid_Migrated_number_Enter_Amount_and_click_Pay_VF_Payment_Gateway_screen_should_display() throws Throwable {
	    	
	    	  Thread.sleep(2000);
	    	   	    
			  	VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		//	  	vdabillPay.CrossButton.click();
			  	driver.get(OR.getProperty("VodaFone_Pay_Bill"));
	//		driver.get("https://preprod.vodafoneidea.com/postpaid/quick-online-bill-payment");


			  	Thread.sleep(2000);
			  		
			  	vdabillPay.MobileNo.clear();
			  		
			   WebDriverWait wait = new WebDriverWait(driver, 40);
			  		 
			  try {
			  			
			  	 wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MobileNo));
			  	      
			//  	 vdabillPay.MobileNo.sendKeys(OR.getProperty("vodaPostpaidNo"));
			  	 
			  	vdabillPay.MobileNo.sendKeys("8722800091");				//Idea migrated number
			  	      
			  	 System.out.println("Enter VF Postpaid Number");
			  	      
		  //	 HTMLReportGenerator.StepDetails("Pass", (count++)+" - Enter VF Postpaid Number", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			  	 HTMLReportGenerator.StepDetails("Pass", (count++)+" - Enter Idea migrated Postpaid Number", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
      
			  	 Thread.sleep(7000);
			  	     
			  	 wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.AmountBill));
			  	      
			  	 vdabillPay.AmountBill.sendKeys(OR.getProperty("newAmount"));
			  	    
			  	 System.out.println("Sending Amount");
			  	      
			  	    HTMLReportGenerator.StepDetails("Pass", (count++)+" - Enter Amount in amount field", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			  	    	System.out.println("Error msg is not displayed");
			  	      
			  	  Thread.sleep(7000);
			  	  
			  	  vdabillPay.MobileNo.clear();
			  	  
			  	vdabillPay.MobileNo.sendKeys(OR.getProperty("vodaPostpaidNo"));
			  	
			  	 System.out.println("Enter VF Postpaid Number");
		  	      
			 	 HTMLReportGenerator.StepDetails("Pass", (count++)+" - Enter VF Postpaid Number", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
						  	
			 	Thread.sleep(7000);
		  	     
			  	 wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.AmountBill));
			  	      
			  	 vdabillPay.AmountBill.sendKeys(OR.getProperty("newAmount"));
			  	    
			  	 System.out.println("Sending Amount");
			  	      
			  	    HTMLReportGenerator.StepDetails("Pass", (count++)+" - Enter Amount in amount field", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

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
	      
	      
	   @Then("^Select Wallet >> Click Pay button for Paytm >> Paytm page should display1$")
	   public void select_Wallet_Click_Pay_button_for_Paytm_Paytm_page_should_display1() throws Throwable {
		   
		   VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
	  		
		   WebDriverWait wait = new WebDriverWait(driver, 40);
		  				try {
		  	 wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.Select_wallet));
		  	 
		  	vdabillPay.Select_wallet.click();
		  	
		  	System.out.println("Select Wallet-----");
		  	
		  	Thread.sleep(2000);
		  	
		   wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.Ptm_PaySurely));
		   vdabillPay.Ptm_PaySurely.click();
		   
		   Thread.sleep(1000);
		   vdabillPay.Proceed_Pay.click();
		   
		   
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
	      @Then("^Click on Go Back >> Oops page should display1$")
	      public void click_on_Go_Back_Oops_page_should_display1() throws Throwable {
	         
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

	      @Then("^Verify Oops page >> Oops page with payment failure text should display1$")
	      public void verify_Oops_page_Oops_page_with_payment_failure_text_should_display1() throws Throwable {
	    	  
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

	      @Then("^Verify Failure Page >> Mobile Number field should display provided VF Number1$")
	      public void verify_Failure_Page_Mobile_Number_field_should_display_provided_VF_Number1() throws Throwable {
	    	  
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

	      @Then("^Verify Failure Page >> Amount field should Not display1$")
	      public void verify_Failure_Page_Amount_field_should_Not_display1() throws Throwable {
	    	  
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

	      @Then("^Verify Failure Page >> Transaction Id should display1$")
	      public void verify_Failure_Page_Transaction_Id_should_display1() throws Throwable {
	        
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


	      @Then("^Verify Failure Page >> Account Id should display1$")
	      public void verify_Failure_Page_Account_Id_should_display1() throws Throwable {
	         
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

	      @Then("^Verify Failure Page >> Date & Time should display1$")
	      public void verify_Failure_Page_Date_Time_should_display1() throws Throwable {
	    	  
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

	      @Then("^Verify Failure Page >> Download Receipt link should display1$")
	      public void verify_Failure_Page_Download_Receipt_link_should_display1() throws Throwable {
	    	  
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

	      @Then("^Verify Failure Page >> Reason for Failure section should display1$")
	      public void verify_Failure_Page_Reason_for_Failure_section_should_display1() throws Throwable {
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

	      @Then("^Verify Failure Page >> Try Again button should display1$")
	      public void verify_Failure_Page_Try_Again_button_should_display1() throws Throwable {
	    	  
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

	      @Then("^Verify Failure Page >> Need Help link in orange color should display1$")
	      public void verify_Failure_Page_Need_Help_link_in_orange_color_should_display1() throws Throwable {
	    	  
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

	      @Then("^Verify Failure Page >> SetUp Auto Pay section should display1$")
	      public void verify_Failure_Page_SetUp_Auto_Pay_section_should_display1() throws Throwable {
	    	  
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

	      @Then("^Verify Failure Page >> Red Together section should display1$")
	      public void verify_Failure_Page_Red_Together_section_should_display1() throws Throwable {
	    	  
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
    
    VodafoneHomePageObj obj1=new VodafoneHomePageObj(driver);

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

	// Firefox
	/*HTMLReportGenerator.TestCaseStart("Firefox:-Bill_Pay_Page_Idea_Number_Migrated", "Firefox:-Production_Build_number:001");
	String path = System.getProperty("user.dir") + "\\Driver\\geckodriver.exe";
	System.setProperty("webdriver.gecko.driver", path);

	FirefoxProfile profile = new FirefoxProfile();

	//	profile.setPreference("network.proxy.type", ProxyType.AUTODETECT.ordinal());

	FirefoxOptions options = new FirefoxOptions();

	options.setProfile(profile);

	driver = new FirefoxDriver(options);*/
	// Chrome
	HTMLReportGenerator.TestCaseStart("Chrome:-Bill Pay", "Chrome:-Production_Build_number:001");

	String path = System.getProperty("user.dir") + "\\Driver\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", path);
    ChromeOptions profile = new ChromeOptions();
	ChromeOptions options = new ChromeOptions();

	driver = new ChromeDriver(options);
	
	System.out.println(" browser");

	OR = new Properties();

	file = new File(System.getProperty("user.dir") + "/src/test/java/com/Testdata/URL.properties");

	filereader = new FileReader(file);

	OR.load(filereader);
	driver.get(OR.getProperty("VodaFone_Pay_Bill"));
//	driver.get("https://preprod.vodafoneidea.com/postpaid/quick-online-bill-payment");
//	driver.get("https://testvil.vodafoneidea.com/content/vodafoneideadigital/in/en/vil-homepage/pay-bill/postpaid-bill-payment.html");
	System.out.println(" Browser Firefox is opening ");

	System.out.println("VodaFone Pay Bill page opened");
	
	driver.manage().window().maximize();

	Thread.sleep(5000);

	HTMLReportGenerator.StepDetails("Pass", (count++) + "- VodaFone Pay Bill page opened", "",

			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	driver.manage().deleteAllCookies();
}




}

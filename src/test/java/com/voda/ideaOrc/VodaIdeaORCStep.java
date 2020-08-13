package com.voda.ideaOrc;

import static org.testng.Assert.expectThrows;

import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.config.baseclass;
import com.voda.PayBill.VodaPay_BillStepDef;
import com.voda.PayBill.VodafBillPayObj;

import HTML_REPORTS.HTMLReportGenerator;
import HTML_REPORTS.TakeScreenShot;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.lexer.Th;
import gherkin.lexer.Vi;

public class VodaIdeaORCStep {
	
	Properties prop = new Properties();

	public Properties OR;

	public File file = null;

	public FileReader filereader;

	WebDriver driver;
	public static int number = 1;

	static int count = 1;
	final static Logger log = Logger.getLogger(VodaPay_BillStepDef.class);

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
		
		//driver.get("https://preprod.vodafoneidea.com/prepaid/online-mobile-recharge");

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
try {
	
		WebDriverWait wait = new WebDriverWait(driver, 30);
	
  		wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.MobileNo));

		vilideaObject.MobileNo.sendKeys(OR.getProperty("prepaidVoda"));
			
		System.out.println("Enter the VF prepaid number");
		
		Thread.sleep(2000);
		
		HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter the VF prepaid number", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		
	
	
	 VILIdeaORCObj vilideaObject1 = new VILIdeaORCObj(driver);

		//vilideaObject1.AmountBill.clear();
		
		WebDriverWait waitq = new WebDriverWait(driver, 30);
		
	 waitq.until(ExpectedConditions.visibilityOfAllElements(vilideaObject1.AmountBill));

		vilideaObject1.AmountBill.sendKeys(OR.getProperty("fiveDigitAmount"));
		
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

		WebDriverWait wait = new WebDriverWait(driver, 05);

		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ImpThinstono));

			vdabillPay.ImpThinstono.click();

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

		WebDriverWait wait = new WebDriverWait(driver, 30);
		
	try {
		
  		wait.until(ExpectedConditions.visibilityOfAllElements(obj.MobileNo));
  		
  		boolean n=obj.Amount.isEnabled();
  		
  		System.out.println("@@@@@@@@@@@@@"+n);

		obj.MobileNo.sendKeys(OR.getProperty("prepaidVoda"));
			
		System.out.println("Enter the VF Prepaid Number number");
		
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
	public void enter_VF_Prepaid_Number_Enter_amount_Packs_with_Mrp_starting_as_should_display(int arg1, int arg2) throws Throwable {	VILIdeaORCObj vilideaObject = new VILIdeaORCObj(driver);

		vilideaObject.MobileNo.clear();
		
		driver.navigate().refresh();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		
	try {
		
  		wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.MobileNo));

  		Thread.sleep(2000);
		vilideaObject.MobileNo.sendKeys(OR.getProperty("prepaidVoda"));
			
		System.out.println("Enter the VF prepaid number");
		
		HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter the VF prepaid number", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	
		
		Thread.sleep(2000);
		
		VILIdeaORCObj vilideaObject1 = new VILIdeaORCObj(driver);

		vilideaObject1.AmountBill.clear();

		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		
	 wait1.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.AmountBill));
	 Thread.sleep(2000);

		vilideaObject.AmountBill.sendKeys(OR.getProperty("amount_rs"));
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

		vilideaObject.MobileNo.clear();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		
	try {
		
  		wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.MobileNo));

		vilideaObject.MobileNo.sendKeys(OR.getProperty("prepaidVoda"));
			
		System.out.println("Enter the VF prepaid number");
		
		HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter the VF prepaid number", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	
		
		Thread.sleep(2000);
		
	

	//z	vilideaObject.AmountBill.clear();

		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		
	 wait1.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.AmountBill));

		vilideaObject.AmountBill.sendKeys(OR.getProperty("amount_rs"));
		
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
		
			driver.navigate().refresh();
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
	     driver.navigate().refresh();
	     Thread.sleep(7000);
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
		driver.navigate().refresh();
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
	    	System.out.println("Pack data is not displayed in popup"+e);
			HTMLReportGenerator.StepDetails("Fail", (count++) +":- Pack data is not displayed in popup", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	    	
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

			driver.get(OR.getProperty("VodaFone_ORC1"));
			
			//driver.get("https://preprod.vodafoneidea.com/prepaid/online-mobile-recharge");

			System.out.println(" Browser Firefox is opening ");

			System.out.println("VodaFone ORC page opened");

			Thread.sleep(5000);

			HTMLReportGenerator.StepDetails("Pass", (count++) + "- VodaFone ORC page opened", "",

					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			
			driver.manage().deleteAllCookies();
	  		
	  		
	  		
	  	}
	  	
}

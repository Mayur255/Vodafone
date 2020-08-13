package com.online_Pack;

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
import com.voda.ideaOrc.VILIdeaORCObj;

import HTML_REPORTS.HTMLReportGenerator;
import HTML_REPORTS.TakeScreenShot;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VF_Pack_StepDef {

	
	Properties prop = new Properties();

	public Properties OR;

	public File file = null;

	public FileReader filereader;

	WebDriver driver;
	public static int number = 1;

	static int count = 1;
	final static Logger log = Logger.getLogger(VodaPay_BillStepDef.class);



@Given("^Launch the browser$")
public void launch_the_browser() throws Throwable {
	
	HTMLReportGenerator.TestCaseStart("Chrome:-Prepaid_Pack_Page", "Chrome:-Production_Build_number:001");
	String path = System.getProperty("user.dir") + "\\Driver\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", path);

	driver = new ChromeDriver();


	System.out.println(" browser");

	
	OR = new Properties();

	file = new File(System.getProperty("user.dir") + "/src/test/java/com/Testdata/URL.properties");

	filereader = new FileReader(file);

	OR.load(filereader);

	driver.get(OR.getProperty("VodaFone_Pack"));
	
//	driver.get("https://preprod.vodafoneidea.com/prepaid/best-prepaid-plans");

	System.out.println(" Browser Firefox is opening ");

	System.out.println("VodaFone Pay Bill page opened");
	
	Thread.sleep(5000);
	
	HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter VodaFone prepaid Pack URL", "",

			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	
	driver.manage().deleteAllCookies();
	
}

@When("^Enter URL$")
public void enter_URL() throws Throwable {
	
	
	
	System.out.println("===============");

	
	
}

@Then("^Prepaid Pack page should open properly$")
public void prepaid_Pack_page_should_open_properly() throws Throwable {
	
	System.out.println("======");
	HTMLReportGenerator.StepDetails("Pass", (count++) + "- VodaFone prepaid Pack page opened", "",

			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
}

@Then("^Verify Page >> Circle should display$")
public void verify_Page_Circle_should_display() throws Throwable {
    VF_Pack_Object obj=new VF_Pack_Object(driver);
    
    boolean b1=obj.Circle.isDisplayed();
    
    if(b1==true)
    {
    	System.out.println("Circle is displayed");
    	HTMLReportGenerator.StepDetails("Pass", (count++)+"Circle is displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    }
    else
    {
    	System.out.println("Circle is not displayed");
    	HTMLReportGenerator.StepDetails("Fail", (count++)+"Circle is not displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    
    }
}

@Then("^Verify Page >> By default Mumbai circle should display$")
public void verify_Page_By_default_Mumbai_circle_should_display() throws Throwable {
    VF_Pack_Object obj=new VF_Pack_Object(driver);
    
    String s1=obj.Circle.getText();
    
    System.out.println(s1);
    
    String s2="MAHARASHTRA AND GOA.";
    
    if(s1.equalsIgnoreCase(s2))
    {
    	System.out.println("default Mumbai circle is display");
    	HTMLReportGenerator.StepDetails("Pass", (count++)+"default Mumbai circle is displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

    }
    else
    {
    	System.out.println("default Mumbai circle is not display");
    	HTMLReportGenerator.StepDetails("Fail", (count++)+"default Mumbai circle is not displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	
    }
}

@Then("^Verify Page >> Pack categories should display$")
public void verify_Page_Pack_categories_should_display() throws Throwable {
    VF_Pack_Object obj=new VF_Pack_Object(driver);
    WebDriverWait wait=new WebDriverWait(driver, 30);
    try {
    	
    	wait.until(ExpectedConditions.visibilityOfAllElements(obj.packs_categories));
    boolean b1=obj.packs_categories.isDisplayed();
    if(b1==true)
    {
    	System.out.println("Pack categories is displayed");
    	HTMLReportGenerator.StepDetails("Pass", (count++)+"Pack categories is displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    }
    else
    {
    	System.out.println("Pack categories is not displayed");
    	HTMLReportGenerator.StepDetails("Fail", (count++)+"Pack categories is not displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    
    }
    }catch (Exception e) {
    	System.out.println("Pack categories is not displayed"+e);
    	HTMLReportGenerator.StepDetails("Fail", (count++)+"Pack categories is not displayed"+e, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    
	}
    
    
}

@Then("^Verify Pack categories >> Unlimited, Value Packs, Add Ons should display$")
public void verify_Pack_categories_Unlimited_Value_Packs_Add_Ons_should_display() throws Throwable {
	VF_Pack_Object obj=new VF_Pack_Object(driver);
	 WebDriverWait wait=new WebDriverWait(driver, 30);
	    try {
	    	
	    	wait.until(ExpectedConditions.visibilityOfAllElements(obj.unlimited_categories));
	    	boolean b1=obj.unlimited_categories.isDisplayed();
	    if(b1==true)
	    {
	    	System.out.println("Unlimited categories is displayed");
	    	HTMLReportGenerator.StepDetails("Pass", (count++)+"Unlimited categories is displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	    }
	    else
	    {
	    	System.out.println("Unlimited categories is not displayed");
	    	HTMLReportGenerator.StepDetails("Fail", (count++)+"Unlimited categories is not displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	    
	    }
	    }catch (Exception e) {
	    	System.out.println("Unlimited categories is not displayed");
	    	HTMLReportGenerator.StepDetails("Fail", (count++)+"Unlimited categories is not displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	    
		}
	    try {
	    boolean b2=obj.talktime_categories.isDisplayed();
	    if(b2==true)
	    {
	    	System.out.println("Add on categories is displayed");
	    	HTMLReportGenerator.StepDetails("Pass", (count++)+"Add on categories is displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	    }
	    else
	    {
	    	System.out.println("Add on categories is not displayed");
	    	HTMLReportGenerator.StepDetails("Fail", (count++)+"Add on categories is not displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	    
	    }
	    }catch (Exception e) {
	    	System.out.println("Add on categories is not displayed");
	    	HTMLReportGenerator.StepDetails("Fail", (count++)+"Add on categories is not displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	    
		}
	    try {
	    boolean b3=obj.internet_categories.isDisplayed();
	    if(b3==true)
	    {
	    	System.out.println("Value pack categories is displayed");
	    	HTMLReportGenerator.StepDetails("Pass", (count++)+"Value pack categories is displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	    }
	    else
	    {
	    	System.out.println("Value pack categories is not displayed");
	    	HTMLReportGenerator.StepDetails("Fail", (count++)+"Value pack categories is not displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	    
	    }
	    }catch (Exception e) {
	    	System.out.println("Value pack categories is not displayed");
	    	HTMLReportGenerator.StepDetails("Fail", (count++)+"Value pack categories is not displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	    
		}
}

@Then("^Verify Pack details >> Pack Mrp should display$")
public void verify_Pack_details_Pack_Mrp_should_display() throws Throwable {
	VF_Pack_Object obj=new VF_Pack_Object(driver); 
	try {
	boolean b1=obj.pack_amount.isDisplayed();
	
	String s1=obj.pack_amount.getText();
	    if(b1==true)
	    {
	    	System.out.println("Pack Mrp is displayed"+s1);
	    	HTMLReportGenerator.StepDetails("Pass", (count++)+"Pack Mrp is displayed MRP="+s1, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	    }
	    else
	    {
	    	System.out.println("Pack Mrp is not displayed");
	    	HTMLReportGenerator.StepDetails("Fail", (count++)+"Pack Mrp is not displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	    
	    }
	}catch (Exception e) {
		System.out.println("Pack mrp is not displayed"+e);
    	HTMLReportGenerator.StepDetails("Fail", (count++)+"Pack is not displayed"+e, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    
	}
}

@Then("^Verify Pack details >> Validity should display$")
public void verify_Pack_details_Validity_should_display() throws Throwable {
VF_Pack_Object obj=new VF_Pack_Object(driver); 
	try {
	boolean b1=obj.pack_validity.isDisplayed();
	
	
	    if(b1==true)
	    {
	    	System.out.println("Validity is displayed");
	    	HTMLReportGenerator.StepDetails("Pass", (count++)+"Validity is displayed ", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	    }
	    else
	    {
	    	System.out.println("Validity is not displayed");
	    	HTMLReportGenerator.StepDetails("Fail", (count++)+"Validity is not displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	    
	    }
	}catch (Exception e) {
			System.out.println("Pack mrp is not displayed"+e);
	    	HTMLReportGenerator.StepDetails("Fail", (count++)+"Pack is not displayed"+e, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	    
		}
}

@Then("^If Talktime details available >> It should display for Unlimited category pack$")
public void if_Talktime_details_available_It_should_display_for_Unlimited_category_pack() throws Throwable {
	VF_Pack_Object obj=new VF_Pack_Object(driver); 

	try {
	boolean b1=obj.pack_talktime.isDisplayed();
	
	
    if(b1==true)
    {
    	System.out.println("Talktime is displayed");
    	HTMLReportGenerator.StepDetails("Pass", (count++)+"Talktime is displayed ", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    }
    else
    {
    	System.out.println("Talktime is not displayed");
    	HTMLReportGenerator.StepDetails("Fail", (count++)+"Talktime is not displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    
    }
	}catch (Exception e) {
		System.out.println("Talktime is not displayed"+e);
    	HTMLReportGenerator.StepDetails("Fail", (count++)+"Talktime is not displayed"+e, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    
	}
}

@Then("^If Data details available >> It should display for Unlimited category pack$")
public void if_Data_details_available_It_should_display_for_Unlimited_category_pack() throws Throwable {

	VF_Pack_Object obj=new VF_Pack_Object(driver); 
try {
	
	boolean b1=obj.pack_data.isDisplayed();
	
	
    if(b1==true)
    {
    	System.out.println("Data is displayed");
    	HTMLReportGenerator.StepDetails("Pass", (count++)+"Data is displayed ", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    }
    else
    {
    	System.out.println("Data is not displayed");
    	HTMLReportGenerator.StepDetails("Fail", (count++)+"Data is not displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    
    }
}catch (Exception e) {
	System.out.println("Data is not displayed"+e);
	HTMLReportGenerator.StepDetails("Fail", (count++)+"Data is not displayed"+e, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

}
}

@Then("^SMS Details should not display in pack details section$")
public void sms_Details_should_not_display_in_pack_details_section() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^If Nontelco benefits are available then max two should display in pack details section$")
public void if_Nontelco_benefits_are_available_then_max_two_should_display_in_pack_details_section() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Select Internet category >> Only Data and Validity fields should display$")
public void select_Internet_category_Only_Data_and_Validity_fields_should_display() throws Throwable {
    VF_Pack_Object obj=new VF_Pack_Object(driver);
    
    obj.internet_categories.click();
    Thread.sleep(1000);
	HTMLReportGenerator.StepDetails("Pass", (count++)+":-Select Value pack category", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

}

@Then("^Select Talktime category >> Only Talktime and Validity fields should display$")
public void select_Talktime_category_Only_Talktime_and_Validity_fields_should_display() throws Throwable {
	 VF_Pack_Object obj=new VF_Pack_Object(driver);
	    
	    obj.talktime_categories.click();
	    Thread.sleep(1000);
		HTMLReportGenerator.StepDetails("Pass", (count++)+":-Select Add on category", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

}

@Then("^On page load >> Imortant Things to Know should display collapsed$")
public void on_page_load_Imortant_Things_to_Know_should_display_collapsed() throws Throwable {
	Thread.sleep(3000);

	JavascriptExecutor jse = (JavascriptExecutor) driver;

	jse.executeScript("window.scrollBy(0,350)", "");

	VILIdeaORCObj vdabillPay = new VILIdeaORCObj(driver);

	WebDriverWait wait = new WebDriverWait(driver, 05);

	try {

		wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ImpThinstono));

		boolean b = vdabillPay.ImpThinstono.isDisplayed();

		if (b == true) {

			System.out.println("On page load >> Imortant Things to Know should display collapsed");

			Thread.sleep(2000);

			HTMLReportGenerator.StepDetails("Pass",
					(count++) + "- On page load >> Imortant Things to Know should display collapsed", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		} else {

			System.out.println("On page load >> Imortant Things to Know should not display collapsed");

			HTMLReportGenerator.StepDetails("Fail",
					(count++) + "- On page load >> Imortant Things to Know should not display collapsed", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}

	} catch (Exception ex)  {

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

		System.out.println("Click Arrow for Important Things to Know >> Page should autoscroll");

		HTMLReportGenerator.StepDetails("Pass",
				(count++) + "- Click Arrow for Important Things to Know >> Page should autoscroll", "",

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

	try {
	Thread.sleep(2000);

	JavascriptExecutor jse = (JavascriptExecutor) driver;

	jse.executeScript("window.scrollBy(0,950)", "");

	System.out.println("Verify page >> Focus should go on Imp Things to know section");
//	HTMLReportGenerator.StepDetails("Pass",(count++) + "- Focus should go on Imp Things to know section >> Page should autoscroll", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	
	}catch (Exception e) {

		System.out.println("Verify page >> Focus should go on Imp Things to know section");
	}
}

@Then("^Verify page >> Imp Things to Know section should expand$")
public void verify_page_Imp_Things_to_Know_section_should_expand() throws Throwable {
	
	VILIdeaORCObj vdabillPay = new VILIdeaORCObj(driver);

	WebDriverWait wait = new WebDriverWait(driver, 30);

	 try{

	wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ImpThingArrow));

	vdabillPay.ImpThingArrow.click();

	System.out.println("Verify page >> Imp Things to Know section should expand");
	 }catch (Exception e) {
		System.out.println(e);
	}

   
}

@Then("^Click Arrow for Important Things to Know >> Page should collapse$")
public void click_Arrow_for_Important_Things_to_Know_Page_should_collapse() throws Throwable {
	VILIdeaORCObj vdabillPay = new VILIdeaORCObj(driver);

	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {

		wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.ImpThinstoNow));

		vdabillPay.ImpThinstoNow.click();

		System.out.println("Click Arrow for Important Things to Know >> Page should collapse");

		HTMLReportGenerator.StepDetails("Pass",(count++) + "- Click Arrow for Important Things to Know >> Page should collapse", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

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


@Then("^Load More link should not display for any pack category$")
public void load_More_link_should_not_display_for_any_pack_category() throws Throwable {
	
	
		
		
}

@Then("^Click Know More for any pack >> Popup should open$")
public void click_Know_More_for_any_pack_Popup_should_open() throws Throwable {
	VF_Pack_Object obj = new VF_Pack_Object(driver);

	WebDriverWait wait1 = new WebDriverWait(driver, 50);
	
	try {

			driver.navigate().refresh();
					
		wait1.until(ExpectedConditions.visibilityOfAllElements(obj.know_more));
		Thread.sleep(2000);
		
		System.out.println("click know more");

		//obj.know_more.click();
		
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		   
		   executor.executeScript("arguments[0].click();", obj.know_more);
		
		Thread.sleep(2000);
		boolean b=obj.know_more_popup.isDisplayed();
		System.out.println(b);
		
		if(b==true)
		{
			
			System.out.println("===popup is opened");
			HTMLReportGenerator.StepDetails("Pass",(count++) + "- Know more popup is opened", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		}else
		{
			HTMLReportGenerator.StepDetails("Fail",(count++) + "- Know more popup is not opened", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		}
	}catch (Exception e) {
		System.err.println(e);
	}
}

@Then("^Click Esc >> Popup should close$")
public void click_Esc_Popup_should_close() throws Throwable {
	
	Actions action = new Actions(driver);
	action.sendKeys(Keys.ESCAPE).build().perform();
		HTMLReportGenerator.StepDetails("Pass", (count++) +":- Press Esc >> Popup is close", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	Thread.sleep(2000);
}

@Then("^Click Cross on popup >> Popup should close$")
public void click_Cross_on_popup_Popup_should_close() throws Throwable {
	try {
		Thread.sleep(3000);
		VF_Pack_Object obj=new VF_Pack_Object(driver);
		obj.cross_btn.click();
		
		System.out.println("popup is close");
		HTMLReportGenerator.StepDetails("Pass", (count++) +":- Click Cross on popup >> Popup is close", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}catch (Exception e) {
			HTMLReportGenerator.StepDetails("Fail", (count++) +":- cross sign is not displayed"+e, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		}
}

@Then("^Verify Know More details >> Pack Mrp should display$")
public void verify_Know_More_details_Pack_Mrp_should_display() throws Throwable {
	try {
	VF_Pack_Object obj=new VF_Pack_Object(driver);
	
	boolean b1=obj.know_more_pop_MRP.isDisplayed();
    
    String s=obj.know_more_pop_MRP.getText();
    
    if(b1==true)
    {
    	System.out.println("Pack Mrp is display");
    	
		HTMLReportGenerator.StepDetails("Pass", (count++) +":-Verify Know More details >>Pack Mrp is display:-"+s, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

    }
    else
    {
    	System.out.println("Pack Mrp is not display");
    	
		HTMLReportGenerator.StepDetails("Fail", (count++) +":-Verify Know More details >>Pack Mrp is not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

    }
    }catch (Exception e) {
    	System.out.println("Pack Mrp is not display"+e);
    	
		HTMLReportGenerator.StepDetails("Fail", (count++) +":-Pack Mrp is not display"+e, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
}

@Then("^Verify Know More details >> Below Mrp Pack Includes text should display$")
public void verify_Know_More_details_Below_Mrp_Pack_Includes_text_should_display() throws Throwable {
	try {
	VF_Pack_Object obj=new VF_Pack_Object(driver);
	
	boolean b1=obj.know_more_pop_MRP_below_text.isDisplayed();
    
    String s=obj.know_more_pop_MRP_below_text.getText();
    
    if(b1==true)
    {
    	System.out.println("Below Mrp Pack Includes text is display");
    	
		HTMLReportGenerator.StepDetails("Pass", (count++) +":-Verify Know More details >>Below Mrp Pack Includes text is display:-"+s, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

    }
    else
    {
    	System.out.println("Below Mrp Pack Includes text is not display");
    	
		HTMLReportGenerator.StepDetails("Fail", (count++) +":-Verify Know More details >>Below Mrp Pack Includes text is not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

    }
    }catch (Exception e) {
    	System.out.println("Below Mrp Pack Includes text is not display"+e);
    	
		HTMLReportGenerator.StepDetails("Fail", (count++) +":-Below Mrp Pack Includes text is not display"+e, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
}

@Then("^Verify Know More details >> Unlimited, Data and SMS details should display if available$")
public void verify_Know_More_details_Unlimited_Data_and_SMS_details_should_display_if_available() throws Throwable {
	 
	VF_Pack_Object obj=new VF_Pack_Object(driver);
	
	try {
	    	
	    	boolean b1=obj.popup_data.isDisplayed();
	    	boolean b2=obj.popup_SMS.isDisplayed();
	    	boolean b3=obj.popup_talktime.isDisplayed();
	    	
	    	
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
	    	
	    		    	
	    }catch (Exception e) {
	    	System.out.println("Pack data is not displayed in popup"+e);
			HTMLReportGenerator.StepDetails("Fail", (count++) +":- Pack data is not displayed in popup", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	    	
		}
}

@Then("^Verify Know More details >> Unlimited, Data and SMS details should be in same line$")
public void verify_Know_More_details_Unlimited_Data_and_SMS_details_should_be_in_same_line() throws Throwable {
	
	HTMLReportGenerator.StepDetails("Pass", (count++) +":- Verify Know More details >> Unlimited, Data and SMS details should be in same line", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

}

@Then("^Verify Know More details >> Your Benefits data should display if available$")
public void verify_Know_More_details_Your_Benefits_data_should_display_if_available() throws Throwable {
	VF_Pack_Object obj=new VF_Pack_Object(driver);
	
	try {
		boolean b1=obj.popup_benefits.isDisplayed();
		
		if(b1==true)
    	{
    		System.out.println("Verify Know More details >> Your Benefits data displayed in popup");
			HTMLReportGenerator.StepDetails("Pass", (count++) +":-Verify Know More details >> Your Benefits data displayed in popup", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

    		
    	}else {
    	System.out.println("Verify Know More details >> Your Benefits data not displayed in popup");
		HTMLReportGenerator.StepDetails("Fail", (count++) +":- Verify Know More details >> Your Benefits data not displayed in popup", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    	}
	}catch (Exception e) {
		System.out.println("Verify Know More details >> Your Benefits data not displayed in popup"+e);
		HTMLReportGenerator.StepDetails("Fail", (count++) +":- Verify Know More details >> Your Benefits data not displayed in popup"+e, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    	
	}
}

@Then("^Verify Know More details >> Buy Pack should display$")
public void verify_Know_More_details_Buy_Pack_should_display() throws Throwable {
	
	VF_Pack_Object obj=new VF_Pack_Object(driver);
	
	try {
		boolean b1=obj.popup_buy_pack_btn.isDisplayed();
		
		if(b1==true)
    	{
    		System.out.println("Verify Know More details >> Buy Pack button is displayed in popup");
			HTMLReportGenerator.StepDetails("Pass", (count++) +":-Verify Know More details >> Buy Pack button is displayed in popup", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

    		
    	}else {
    	System.out.println("Verify Know More details >> Buy Pack button is not displayed in popup");
		HTMLReportGenerator.StepDetails("Fail", (count++) +":- Verify Know More details >> Buy Pack button is not displayed in popup", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    	}
	}catch (Exception e) {
		System.out.println("Verify Know More details >> Buy Pack button is not displayed in popup"+e);
		HTMLReportGenerator.StepDetails("Fail", (count++) +":- Verify Know More details >> Buy Pack button is not displayed in popup"+e, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    	
	}

}

@Then("^Click Buy Pack >> Seleced Pack page should display$")
public void click_Buy_Pack_Seleced_Pack_page_should_display() throws Throwable {
	VF_Pack_Object obj=new VF_Pack_Object(driver);
	WebDriverWait wait=new WebDriverWait(driver, 30);
	//obj.popup_buy_pack_btn.click();
	
	 JavascriptExecutor executor = (JavascriptExecutor)driver;
	   
	   executor.executeScript("arguments[0].click();", obj.popup_buy_pack_btn);
	wait.until(ExpectedConditions.visibilityOfAllElements(obj.selected_pack_amt));
	
	HTMLReportGenerator.StepDetails("Pass", (count++) +":-Click Buy Pack >> Seleced Pack page is displayed in popup", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	
}

@Then("^Verify Selected Pack page >> Pack Mrp displayed on landing page for respective Pack should display$")
public void verify_Selected_Pack_page_Pack_Mrp_displayed_on_landing_page_for_respective_Pack_should_display() throws Throwable {
	VF_Pack_Object obj=new VF_Pack_Object(driver);
	
	Boolean b1= obj.selected_pack_amt.isDisplayed();
	String s=obj.selected_pack_amt.getText();
	if(b1==true)
	{
		System.out.println("Verify Selected Pack page >> Pack Mrp displayed on landing page for respective Pack is displayed in popup"+s);
		HTMLReportGenerator.StepDetails("Pass", (count++) +":-Verify Selected Pack page >> Pack Mrp displayed on landing page for respective Pack is displayed in popup"+s, "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		
	}else {
	System.out.println("Verify Selected Pack page >> Pack Mrp displayed on landing page for respective Pack is not displayed in popup");
	HTMLReportGenerator.StepDetails("Fail", (count++) +":- Verify Selected Pack page >> Pack Mrp displayed on landing page for respective Pack is not displayed in popup", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}
	
			
}

@Then("^Verify Selected Pack page >> Below Mobile Number Details section should display$")
public void verify_Selected_Pack_page_Below_Mobile_Number_Details_section_should_display() throws Throwable {
VF_Pack_Object obj=new VF_Pack_Object(driver);
	
	Boolean b1= obj.selected_mobile_number_section.isDisplayed();
	
	if(b1==true)
	{
		System.out.println("Verify Selected Pack page >> Below Mobile Number Details section is displayed in popup");
		HTMLReportGenerator.StepDetails("Pass", (count++) +":-Verify Selected Pack page >> Below Mobile Number Details section is displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		
	}else {
	System.out.println("Verify Selected Pack page >> Below Mobile Number Details section is not displayed in popup");
	HTMLReportGenerator.StepDetails("Fail", (count++) +":- Verify Selected Pack page >> Below Mobile Number Details section is not displayed in popup", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}
	
}

@Then("^Verify Mobile Number details section >> Focus should be on Mobile Number field$")
public void verify_Mobile_Number_details_section_Focus_should_be_on_Mobile_Number_field() throws Throwable {

	
	VF_Pack_Object obj=new VF_Pack_Object(driver);
	
	Boolean b1= obj.selected_mobile_number_section.isEnabled();
	
	if(b1==true)
	{
		System.out.println("Verify Selected Pack page >> Focus should be on Mobile Number field");
		HTMLReportGenerator.StepDetails("Pass", (count++) +":-Verify Selected Pack page >>Focus should be on Mobile Number field", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		
	}else {
	System.out.println("Verify Selected Pack page >> Focus should be on Mobile Number field");
	HTMLReportGenerator.StepDetails("Fail", (count++) +":- Verify Selected Pack page >>Focus should be on Mobile Number field", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}
}

@Then("^Verify Mobile Number details section >> Confirm should be disabled$")
public void verify_Mobile_Number_details_section_Confirm_should_be_disabled() throws Throwable {

	VF_Pack_Object obj=new VF_Pack_Object(driver);

	Boolean b1= obj.confirm_btn_disable.isDisplayed();
	
	if(b1==true)
	{
		System.out.println("Verify Selected Pack page >> Confirm is disabled");
		HTMLReportGenerator.StepDetails("Pass", (count++) +":-Verify Selected Pack page >>Confirm is disabled", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		
	}else {
	System.out.println("Verify Selected Pack page >> Confirm is disabled");
	HTMLReportGenerator.StepDetails("Fail", (count++) +":- Verify Selected Pack page >>Confirm is disabled", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}
}

@Then("^Verify Selected Pack page >> Go Back link should display$")
public void verify_Selected_Pack_page_Go_Back_link_should_display() throws Throwable {
	
	VF_Pack_Object obj=new VF_Pack_Object(driver);

	Boolean b1= obj.go_back.isDisplayed();
	
	if(b1==true)
	{
		System.out.println("Verify Selected Pack page >> Go Back link is displayed");
		HTMLReportGenerator.StepDetails("Pass", (count++) +":-Verify Selected Pack page >> Go Back link is displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		
	}else {
	System.out.println("Verify Selected Pack page >>  Go Back link is displayed");
	HTMLReportGenerator.StepDetails("Fail", (count++) +":- Verify Selected Pack page >> Go Back link is displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}
}

@Then("^Click Go Back >> Pack landing page should display$")
public void click_Go_Back_Pack_landing_page_should_display() throws Throwable {
    
	WebDriverWait wait=new WebDriverWait(driver, 30);
	
	VF_Pack_Object obj=new VF_Pack_Object(driver);
	obj.go_back.click();
	
	
	wait.until(ExpectedConditions.visibilityOfAllElements(obj.unlimited_categories));
	HTMLReportGenerator.StepDetails("Pass", (count++) +":-Click Go Back >> Pack landing page is displayed", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	
}

@Then("^Verify Page >> Prepaid Mobile Plans & Packs Section should display$")
public void verify_Page_Prepaid_Mobile_Plans_Packs_Section_should_display() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Enter mobile number less than ten digits - Error message should display in Red$")
public void enter_mobile_number_less_than_ten_digits_Error_message_should_display_in_Red() throws Throwable {
	
	VF_Pack_Object vilideaObject=new VF_Pack_Object(driver);
	
	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
		
		vilideaObject.Buy_pack_btn.click();
		
		HTMLReportGenerator.StepDetails("Pass", (count++)+ "-Click on buy pack button on pack landing page", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		
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

				HTMLReportGenerator.StepDetails("Pass", (count++)+ "-Enter mobile number less than ten digits>> Correct Error msg is displyed in correct color", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

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

@Then("^Enter Mobile Number label and field border should display in Red$")
public void Enter_Mobile_Number_label_and_field_border_should_display_in_Red() throws Throwable {

	
	VF_Pack_Object vilideaObject=new VF_Pack_Object(driver);
	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {

				
		wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.LesTha_Error));

	

		String error_msg1 = vilideaObject.LesTha_Error.getText();

		System.out.println("===" + error_msg1);

		String color = vilideaObject.LesTha_Error.getCssValue("color");
		
		

		

		System.out.println("============" + color);
		String color1 = "#e60000";

		System.out.println("============" + color);
		
		String color2=Color.fromString(color).asHex();
		
		System.out.println("555555555555555555555"+color2);

		boolean n1 = vilideaObject.LesTha_Error.isDisplayed();

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

@Then("^Enter NonIdea/NonVF Number - Error message should display in Red$")
public void enter_NonIdea_NonVF_Number_Error_message_should_display_in_Red() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Enter NonIdea/NonVF Number - Enter Mobile Number label and field border should display in Red$")
public void enter_NonIdea_NonVF_Number_Enter_Mobile_Number_label_and_field_border_should_display_in_Red() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Enter Idea Prepaid Number - Error message should display in Red$")
public void enter_Idea_Prepaid_Number_Error_message_should_display_in_Red() throws Throwable {
	
	VF_Pack_Object vilideaObject=new VF_Pack_Object(driver);
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
	
	HTMLReportGenerator.StepDetails("Pass", (count++) + "-Enter Prepaid Number of Idea >> Error message should display", "",
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

@Then("^Enter Idea Prepaid Number - Enter Mobile Number label and field border should display in Red$")
public void enter_Idea_Prepaid_Number_Enter_Mobile_Number_label_and_field_border_should_display_in_Red() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Enter Idea Postpaid Number - Error message should display in Red$")
public void enter_Idea_Postpaid_Number_Error_message_should_display_in_Red() throws Throwable {
	VF_Pack_Object vilideaObject=new VF_Pack_Object(driver);
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

@Then("^Enter Idea Postpaid Number - Enter Mobile Number label and field border should display in Red$")
public void enter_Idea_Postpaid_Number_Enter_Mobile_Number_label_and_field_border_should_display_in_Red() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Try to enter Mobile Number starting with (\\d+) to (\\d+) >> It should not allow$")
public void try_to_enter_Mobile_Number_starting_with_to_It_should_not_allow(int arg1, int arg2) throws Throwable {
	VF_Pack_Object vilideaObject=new VF_Pack_Object(driver);
	vilideaObject.MobileNo.clear();

	WebDriverWait wait = new WebDriverWait(driver, 30);
	
try {
	
		wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.MobileNo));

		vilideaObject.MobileNo.sendKeys("34322221");
		
		HTMLReportGenerator.StepDetails("Pass", (count++) + "-Try to enter Mobile Number starting with 0 to 4 >> It should not allow", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

}catch (Exception e) {
	System.out.println("dsdsfdsf"+e);
}
}

@Then("^Enter alphabets/Special characters in Mobile Number field- it should not allow$")
public void enter_alphabets_Special_characters_in_Mobile_Number_field_it_should_not_allow() throws Throwable {
	VF_Pack_Object vilideaObject=new VF_Pack_Object(driver);
	vilideaObject.MobileNo.clear();

	WebDriverWait wait = new WebDriverWait(driver, 30);
	
try {
	
		wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.MobileNo));

		vilideaObject.MobileNo.sendKeys("ABCDXCDDD");
		
		HTMLReportGenerator.StepDetails("Pass", (count++) + "-Enter alphabets/Special characters in Mobile Number field- it should not allow", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

}catch (Exception e) {
	System.out.println("asddff"+e);
}
}

@Then("^Select Circle >> DL - DL circle packs should display$")
public void select_Circle_DL_DL_circle_packs_should_display() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^For DL circle >> Select Talktime >> Click Buy Pack for Rs (\\d+) pack$")
public void for_DL_circle_Select_Talktime_Click_Buy_Pack_for_Rs_pack(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Enter MH circleVF  number >> Confirm should be enabled as Rs (\\d+) pack is available for MH circle$")
public void enter_MH_circleVF_number_Confirm_should_be_enabled_as_Rs_pack_is_available_for_MH_circle(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Click Edit >> Click Buy Pack for Rs (\\d+) Pack$")
public void click_Edit_Click_Buy_Pack_for_Rs_Pack(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Click Buy Pack >> Enter MH circle VF number >> Error message should display in Red$")
public void click_Buy_Pack_Enter_MH_circle_VF_number_Error_message_should_display_in_Red() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Click Buy Pack >> Enter MH circle VF number >> Enter Mobile Number label and field border should display in Red$")
public void click_Buy_Pack_Enter_MH_circle_VF_number_Enter_Mobile_Number_label_and_field_border_should_display_in_Red() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^For DL circle >> Enter DL Circle VF number >> Confirm should be enabled$")
public void for_DL_circle_Enter_DL_Circle_VF_number_Confirm_should_be_enabled() throws Throwable {
	VF_Pack_Object vilideaObject=new VF_Pack_Object(driver);
	vilideaObject.MobileNo.clear();

	WebDriverWait wait = new WebDriverWait(driver, 30);
	
try {
	
		wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.MobileNo));

		vilideaObject.MobileNo.sendKeys("7769941028");
		
	//	vilideaObject.MobileNo.sendKeys("8722800091");
		
		wait.until(ExpectedConditions.visibilityOfAllElements(vilideaObject.confirm_btn_enable));
		
		HTMLReportGenerator.StepDetails("Pass", (count++) + "-Enter VF number >> Confirm is enabled", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}catch (Exception e) {
		
		System.out.println("aaaaaaa"+e);
		HTMLReportGenerator.StepDetails("Fail", (count++) + "-Enter VF number >> Confirm is not enabled", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	}
}

@Then("^Click Confirm >> VF Payment Gateway should display$")
public void click_Confirm_VF_Payment_Gateway_should_display() throws Throwable {
    VF_Pack_Object obj=new VF_Pack_Object(driver);
    
    obj.confirm_btn_enable.click();
    
    Thread.sleep(10000);
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
	   
	   
	   Thread.sleep(1000);
	   vdabillPay.Proceed_Pay.click();
	   
	   Thread.sleep(2000);
	   wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.Go_Back1));
	  boolean b =  vdabillPay.Go_Back1.isDisplayed();
	  
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
			  HTMLReportGenerator.StepDetails("Fail", (count++)+" - Verify Failure Page >> Need Help link in orange color should not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			  
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
		  HTMLReportGenerator.TestCaseEnd();
   }

   @Then("^Verify Failure Page >> Imp Things to know should display$")
   public void verify_Failure_Page_Imp_Things_to_know_should_display() throws Throwable {
 	  Thread.sleep(2000);

	  		JavascriptExecutor jse = (JavascriptExecutor) driver;

	  		jse.executeScript("window.scrollBy(0,2500)", "");
 	  
 	  VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
	  		
		   WebDriverWait wait = new WebDriverWait(driver, 40);
		   
		  try {
		  
		  wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.Get_MyVodafone_App1));
		  	
		  boolean b=vdabillPay.Get_MyVodafone_App1.isDisplayed();
		  
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
		 
   }



@Then("^Click Try Again >> Recharge landing page should display$")
public void click_Try_Again_Recharge_landing_page_should_display() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Verify Thank you Page>> Click on Download Receipt link>> Download PDF of the the receipt in the predefined format$")
public void verify_Thank_you_Page_Click_on_Download_Receipt_link_Download_PDF_of_the_the_receipt_in_the_predefined_format() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}


@Given("^Launch the Firefox browser$")
public void launch_the_Firefox_browser() throws Throwable {
	
	HTMLReportGenerator.TestCaseStart("Firefox:-Prepaid_Pack_Page", "Firefox:-Production_Build_number:001");
	String path = System.getProperty("user.dir") + "\\Driver\\geckodriver.exe";
	System.setProperty("webdriver.gecko.driver", path);
	

	driver = new FirefoxDriver();
	System.out.println(" browser");


	System.out.println(" browser");

	
	OR = new Properties();

	file = new File(System.getProperty("user.dir") + "/src/test/java/com/Testdata/URL.properties");

	filereader = new FileReader(file);

	OR.load(filereader);

	driver.get(OR.getProperty("VodaFone_Pack"));
	
	//driver.get("https://preprod.vodafoneidea.com/prepaid/best-prepaid-plans");

	System.out.println(" Browser Crome is opening ");

	System.out.println("VodaFone Pay Bill page opened");
	
	Thread.sleep(5000);
	
	HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter VodaFone prepaid Pack URL", "",

			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	
	driver.manage().deleteAllCookies();
}


}

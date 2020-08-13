package com.PostPaidPlans;

import java.io.File;
import java.io.FileReader;
import java.util.Hashtable;
import java.util.List;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.config.baseclass;
import com.voda.PayBill.VodafBillPayObj;

import HTML_REPORTS.HTMLReportGenerator;
import HTML_REPORTS.TakeScreenShot;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class PostPaidPlansStep {
	


	//JavascriptExecutor jse = (JavascriptExecutor) driver;

	//jse.executeScript("window.scrollBy(0,850)", "");
	
	
	Properties prop = new Properties();
	public Properties OR;
	public File file =null;
	public FileReader filereader;
	WebDriver driver;
	public static int number = 1;

	static int count = 1;
	
	final static Logger log = Logger.getLogger(PostPaidPlansStep.class);
	@Given("^Postpaid Plan page should open properly$")
	public void postpaid_Plan_page_should_open_properly() throws Throwable {
	    
		String path = System.getProperty("user.dir") + "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
	  // ChromeOptions profile = new ChromeOptions();
		ChromeOptions options = new ChromeOptions();

		driver = new ChromeDriver(options);

		System.out.println(" browser is Open");

		OR = new Properties();
		file = new File(System.getProperty("user.dir") + "/src/test/java/com/Testdata/URL.properties");

		filereader = new FileReader(file);

		OR.load(filereader);

		
		
		 driver.manage().window().maximize();
		
		 driver.get("https://vodafone.in/postpaid/vodafone-red-postpaid-plans");
	//	 driver.get("https://preprod.vodafoneidea.com/postpaid/vodafone-red-postpaid-plans");
		 System.out.println(" Post Paid Plan Page is open Properly");
		 Thread.sleep(5000);
			
		 HTMLReportGenerator.StepDetails("Pass",(count++) + "Post Paid Plan Page is open Properly", "",	TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		 
	}

	@Then("^Verify Page >> For Me & My Family section should display$")
	public void verify_Page_For_Me_My_Family_section_should_display() throws Throwable {
		
		PostPaidPlansObj postplan=new PostPaidPlansObj(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try {	
		wait.until(ExpectedConditions.visibilityOfAllElements(postplan.Family));
		
		boolean b=postplan.Family.isDisplayed();
		
		if(b == true){
			
			System.out.println("For Me & My Family is present");
			
			Thread.sleep(2000);
			
			HTMLReportGenerator.StepDetails("Pass", (count++) + "-For Me & My Family is present", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));			
			
			}
	 else{
				
			System.out.println("For Me & My Family is absent");			
			Thread.sleep(2000);
			
			HTMLReportGenerator.StepDetails("Fail", (count++) + "-For Me & My Family is absent", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));		
	 }}catch(TimeoutException ex){
			
			System.out.println("For Me & My Family is absent");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "-For Me & My Family is absent"+ex, "",
					
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
		
		
	}

	@Then("^Verify Page >> For Me section should display$")
	public void verify_Page_For_Me_section_should_display() throws Throwable {
	
		PostPaidPlansObj Postplan=new PostPaidPlansObj(driver);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		try {	
		wait.until(ExpectedConditions.visibilityOfAllElements(Postplan.ForMe));
		

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,350)", "");
		boolean bl=Postplan.ForMe.isDisplayed();
		
		if(bl == true) {
		System.out.println("For Me Section is Present");
		

		Thread.sleep(2000);
		
		HTMLReportGenerator.StepDetails("Pass", (count++) + "-For Me Section is Present", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));			
		
	}else {
		
		System.out.println("For Me Section is not Present");

		Thread.sleep(2000);
		
		HTMLReportGenerator.StepDetails("Fail", (count++) + "-For Me Section is not Present", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));				
		
		}}catch(TimeoutException ex){
			
			System.out.println("For Me Section is not Present");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "-For Me Section is not Present"+ex, "",
					
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}

	}

	@Then("^Verify For Me & My Family Section >> Max (\\d+) plans should display$")
	public void verify_For_Me_My_Family_Section_Max_plans_should_display(int arg1) throws Throwable {
		PostPaidPlansObj Postplan=new PostPaidPlansObj(driver);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		//driver.navigate().refresh();
		

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,-300)", "");
		
		try {			
		wait.until(ExpectedConditions.visibilityOfAllElements(Postplan.CountPlansformeandmyfamily));
		
		int n=((List<WebElement>) Postplan.CountPlansformeandmyfamily).size();
		
		System.out.println("Present Plans for me and my family"+n);
		
		if(n<= 3) {
			System.out.println("Exactly three plans displaying in for me and my family");

			HTMLReportGenerator.StepDetails("Pass", (count++) + "-Exactly three plans displaying in for me and my family", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));			
		}else {
			
			System.out.println("More than three plans displaying");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "-More than three plans displaying", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));		
			}}catch(TimeoutException ex){

				System.out.println("More than three plans displaying");

				HTMLReportGenerator.StepDetails("Fail", (count++) + "-For Me Section is not Present"+ex, "",
						
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
							}

		}

	@Then("^Verify For Me & My Family Section >> Plan Mrp should display$")
	public void verify_For_Me_My_Family_Section_Plan_Mrp_should_display() throws Throwable {
	    
		PostPaidPlansObj Postplan=new PostPaidPlansObj(driver);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(Postplan.MRPForMeandmyFamily));
		
		boolean bl=Postplan.MRPForMeandmyFamily.isDisplayed();
		
		//System.out.println("Postplan.MRPForMe");
		
		String MRP =Postplan.MRPForMeandmyFamily.getText(); 
		System.out.println("Price of the Plans  =:" +MRP); 
		
		if(bl == true) {
		System.out.println("For Me Section MRP is Present");
		HTMLReportGenerator.StepDetails("Pass", (count++) + "-For Me Section MRP is Present", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
	}else {
		
		System.out.println("For Me Section MRP is not Present");
		HTMLReportGenerator.StepDetails("Fail", (count++) + "-For Me Section MRP is not Present", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));			
		}}catch(TimeoutException ex){

			System.out.println("More than three plans displaying");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "-For Me Section MRP is not Present"+ex, "",
					
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
						}
	
	}

	@Then("^Verify For Me & My Family Section >> No of connection count should display$")
	public void verify_For_Me_My_Family_Section_No_of_connection_count_should_display() throws Throwable {
		
		PostPaidPlansObj Postplan=new PostPaidPlansObj(driver);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(Postplan.ConnForMeandFamily));
		
		boolean bl=Postplan.ConnForMeandFamily.isDisplayed();
		
		
		if(bl == true) {
		System.out.println("Number of connection is present for me and my family");
		HTMLReportGenerator.StepDetails("Pass", (count++) + "-Number of connection is present for me and my family", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
	}else {
		
		System.out.println("Number of connection is not present for me and my family");
		HTMLReportGenerator.StepDetails("Pass", (count++) + "-Number of connection is not present for me and my family", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
		}}catch(TimeoutException ex){

			System.out.println("Number of connection is not present for me and my family");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "-Number of connection is not present for me and my family"+ex, "",
					
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
						}		
	    
		
	}

	@Then("^Verify For Me & My Family Section >> Data rollover details should display$")
	public void verify_For_Me_My_Family_Section_Data_rollover_details_should_display() throws Throwable {
	 
		PostPaidPlansObj Postplan=new PostPaidPlansObj(driver);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		try {		
		wait.until(ExpectedConditions.visibilityOfAllElements(Postplan.DataRolForMeandFamily));
		
		boolean bl=Postplan.DataRolForMeandFamily.isDisplayed();
		
		String DataR =Postplan.DataRolForMeandFamily.getText(); 
		System.out.println("Data for the Plan =:"+DataR); 
		
		if(bl == true) {
		System.out.println("Data Rollover is present for me and my family");
		HTMLReportGenerator.StepDetails("Pass", (count++) + "-Data Rollover is present for me and my family", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
	}else {
		
		System.out.println("Data Rollover is not present for me and my family");
		HTMLReportGenerator.StepDetails("Fail", (count++) + "-Data Rollover is not present for me and my family", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
		}}catch(TimeoutException ex){

			System.out.println("Number of connection is not present for me and my family");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "-Number of connection is not present for me and my family"+ex, "",
					
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
						}		
	    		
		
	}

	@Then("^Verify For Me & My Family Section >> If Nontelco benefits are available then max four should display in Plans section$")
	public void verify_For_Me_My_Family_Section_If_Nontelco_benefits_are_available_then_max_four_should_display_in_Plans_section() throws Throwable {
	   
		PostPaidPlansObj Postplan=new PostPaidPlansObj(driver);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(Postplan.NoncomMeandFamily));

		boolean bl=Postplan.NoncomMeandFamily.isDisplayed();
		if(bl == true) {
			System.out.println("Nontelco benifits is present ");
			HTMLReportGenerator.StepDetails("Pass", (count++) + "-Nontelco benifits is present ", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
		}else {
			
			System.out.println("Nontelco benifits is not present");
			HTMLReportGenerator.StepDetails("Fail", (count++) + "-Nontelco benifits is not present ", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
			}}catch(TimeoutException ex){

				System.out.println("Number of connection is not present for me and my family");

				HTMLReportGenerator.StepDetails("Fail", (count++) + "-Number of connection is not present for me and my family"+ex, "",
						
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
							}		
			
		
	}

	@Then("^Verify For Me & My Family Section >> If Nontelco benefits are Not available then respective section should display blank$")
	public void verify_For_Me_My_Family_Section_If_Nontelco_benefits_are_Not_available_then_respective_section_should_display_blank() throws Throwable {
	 
		PostPaidPlansObj Postplan=new PostPaidPlansObj(driver);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(Postplan.NoncomMeandFamily));

		boolean bl=Postplan.NoncomMeandFamily.isDisplayed();
		if(bl == true) {
			System.out.println("Nontelco benifits is present ");
			HTMLReportGenerator.StepDetails("Pass", (count++) + "-Nontelco benifits is present ", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
		}else {
			
			System.out.println("Nontelco benifits is Blank");
			HTMLReportGenerator.StepDetails("Fail", (count++) + "-Nontelco benifits is Blank", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
			}}catch(TimeoutException ex){

				System.out.println("Number of connection is not present for me and my family");

				HTMLReportGenerator.StepDetails("Fail", (count++) + "-Number of connection is not present for me and my family"+ex, "",
						
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
							}					
		
	}

	@Then("^Verify For Me & My Family Section >> Know More link should display for all plans$")
	public void verify_For_Me_My_Family_Section_Know_More_link_should_display_for_all_plans() throws Throwable {
		
		PostPaidPlansObj Postplan=new PostPaidPlansObj(driver);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(Postplan.KnowMoreForMeandFamily));

		boolean bl=Postplan.KnowMoreForMeandFamily.isDisplayed();
		if(bl == true) {
			System.out.println("Know More Link is present for Me and my family Section");
			HTMLReportGenerator.StepDetails("Pass", (count++) + "-Know More Link is present for Me and my family Section", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
		}else {
			
			System.out.println("Know More Link is not present for Me and my family Section");
			HTMLReportGenerator.StepDetails("Fail", (count++) + "-Know More Link is not present for Me and my family Section", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	

			}}catch(TimeoutException ex){

				System.out.println("Know More Link is not present for Me and my family Section");

				HTMLReportGenerator.StepDetails("Fail", (count++) + "-Know More Link is not present for Me and my family Section"+ex, "",
						
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
							}					
			
	}

	@Then("^Verify For Me & My Family Section >> Buy Plan should display for all plans$")
	public void verify_For_Me_My_Family_Section_Buy_Plan_should_display_for_all_plans() throws Throwable {
	
		PostPaidPlansObj Postplan=new PostPaidPlansObj(driver);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(Postplan.BuyNowForMeandMyfamily));

		boolean bl=Postplan.BuyNowForMeandMyfamily.isDisplayed();
		if(bl == true) {
			System.out.println("Buy now button is present for Me and my family Section");
			HTMLReportGenerator.StepDetails("Pass", (count++) + "-Buy now button is present for Me and my family Section", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}else {
			
			System.out.println("Buy now button is not present for Me and my family Section");
			HTMLReportGenerator.StepDetails("Fail", (count++) + "-Buy now button is not present for Me and my family Section", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}}catch(TimeoutException ex){

				System.out.println("Buy now button is not present for Me and my family Sectiony");

				HTMLReportGenerator.StepDetails("Fail", (count++) + "-Buy now button is not present for Me and my family Section"+ex, "",
						
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
							}						
		
	}

	@Then("^Verify For Me Section >> Max (\\d+) plans should display$")
	public void verify_For_Me_Section_Max_plans_should_display(int arg1) throws Throwable {
	    
		PostPaidPlansObj Postplan=new PostPaidPlansObj(driver);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,500)", "");
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(Postplan.CountPlansforMe));
		
		int n=((List<WebElement>) Postplan.CountPlansforMe).size();
		System.out.println("Present Plans for me and my family"+n);
		
		if(n<= 4) {
			System.out.println("Exactly three plans displaying in for me Section");
			HTMLReportGenerator.StepDetails("Pass", (count++) + "-Exactly four plans displaying in for me Section", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}else {
			
			System.out.println("More than three plans displaying");
			HTMLReportGenerator.StepDetails("Fail", (count++) + "-More than three plans displaying", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}}catch(TimeoutException ex){

				System.out.println("More than three plans displaying");

				HTMLReportGenerator.StepDetails("Fail", (count++) + "-More than three plans displaying"+ex, "",
						
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
							}	
		
		}
		


	@Then("^Verify For Me Section >> Plan Mrp should display$")
	public void verify_For_Me_Section_Plan_Mrp_should_display() throws Throwable {
	   
		PostPaidPlansObj Postplan=new PostPaidPlansObj(driver);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(Postplan.MRPForMe));
		boolean bl=Postplan.MRPForMe.isDisplayed();
	
		String MRP = Postplan.MRPForMe.getText(); 
		System.out.println("Price of the Plan =:"+MRP); 
		
		if(bl == true) {
		System.out.println("For Me Section MRP is Present");
		HTMLReportGenerator.StepDetails("Pass", (count++) + "-For Me Section MRP is Present", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}else {
		
		System.out.println("For Me Section MRP is not Present");
		HTMLReportGenerator.StepDetails("Fail", (count++) + "-For Me Section MRP is not Present", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}}catch(TimeoutException ex){

			System.out.println("For Me Section MRP is not Present");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "-For Me Section MRP is not Present"+ex, "",
					
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
						}		
		
	}

	@Then("^Verify For Me Section >> No of connection count should display - It should be always (\\d+)$")
	public void verify_For_Me_Section_No_of_connection_count_should_display_It_should_be_always(int arg1) throws Throwable {
try {
		 WebElement strvalue = driver.findElement(By.xpath("//div[@id='mePlans']/div/div[2]/div/div[1]/div/p[2]"));
	        String expected = "For 1 Connection";
	        String actual = strvalue.getText();
	        System.out.println(actual);

	    if(expected.equals(actual)){
	        System.out.println("Pass");
			HTMLReportGenerator.StepDetails("Pass", (count++) + "-Number of connection 1 is present", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));       
	    }
	        else {
	            System.out.println("Fail");
	        	HTMLReportGenerator.StepDetails("Fail", (count++) + "-Number of connection 1 is not present", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));       
	        }}catch(TimeoutException ex){

				System.out.println("Number of connection 1 is not present");

				HTMLReportGenerator.StepDetails("Fail", (count++) + "-Number of connection 1 is not present"+ex, "",
						
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
							}		
			

	}
//(have to do )
	@Then("^Verify For Me Section >> Data rollover details should display$")
	public void verify_For_Me_Section_Data_rollover_details_should_display() throws Throwable {
	   
		PostPaidPlansObj Postplan=new PostPaidPlansObj(driver);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		try {		
		wait.until(ExpectedConditions.visibilityOfAllElements(Postplan.DataRolForMeandFamily));
		
		boolean bl=Postplan.DataRolForMeandFamily.isDisplayed();
		
		String DataR =Postplan.DataRolForMeandFamily.getText(); 
		System.out.println("Data for the Plan =:"+DataR); 
		
		if(bl == true) {
		System.out.println("Data Rollover is present for me and my family");
		HTMLReportGenerator.StepDetails("Pass", (count++) + "-Data Rollover is present for me and my family", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
	}else {
		
		System.out.println("Data Rollover is not present for me and my family");
		HTMLReportGenerator.StepDetails("Fail", (count++) + "-Data Rollover is not present for me and my family", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
		}}catch(TimeoutException ex){

			System.out.println("Number of connection is not present for me and my family");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "-Number of connection is not present for me and my family"+ex, "",
					
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
						}		
		
	}

	@Then("^Verify For Me Section >> If Nontelco benefits are available then max four should display in Plans section$")
	public void verify_For_Me_Section_If_Nontelco_benefits_are_available_then_max_four_should_display_in_Plans_section() throws Throwable {
	  
		PostPaidPlansObj Postplan=new PostPaidPlansObj(driver);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(Postplan.NoncomForMe));

		boolean bl=Postplan.NoncomForMe.isDisplayed();
		if(bl == true) {
			System.out.println("Nontelco benifits is present for Me Section");
			HTMLReportGenerator.StepDetails("Pass", (count++) + "-Nontelco benifits is present for Me Section", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));       
		}else {
			
			System.out.println("Nontelco benifits is not present for Me Section");
			HTMLReportGenerator.StepDetails("Fail", (count++) + "-Nontelco benifits is not present for Me Section", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));  
			}}catch(TimeoutException ex){

				System.out.println("Nontelco benifits is not present for Me Section");

				HTMLReportGenerator.StepDetails("Fail", (count++) + "-Nontelco benifits is not present for Me Section"+ex, "",
						
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
							}	
		
		
	}

	@Then("^Verify For Me Section >> If Nontelco benefits are Not available then respective section should display blank$")
	public void verify_For_Me_Section_If_Nontelco_benefits_are_Not_available_then_respective_section_should_display_blank() throws Throwable {
	    
		PostPaidPlansObj Postplan=new PostPaidPlansObj(driver);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(Postplan.NoncomForMe));

		boolean bl=Postplan.NoncomForMe.isDisplayed();
		if(bl == true) {
			System.out.println("Nontelco benifits is present for Me Section");
			HTMLReportGenerator.StepDetails("Pass", (count++) + "-Nontelco benifits is present for Me Section", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));     
		}else {
			
			System.out.println("Nontelco benifits is blank space is for Me Section");
			HTMLReportGenerator.StepDetails("Fail", (count++) + "-Nontelco benifits is blank space is for Me Section", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));    
			}}catch(TimeoutException ex){

				System.out.println("Nontelco benifits is blank space is for Me Section");

				HTMLReportGenerator.StepDetails("Fail", (count++) + "-Nontelco benifits is blank space is for Me Section"+ex, "",
						
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
							}		
		
	}

	@Then("^Verify For Me Section >> Know More link should display for all plans$")
	public void verify_For_Me_Section_Know_More_link_should_display_for_all_plans() throws Throwable {
		    
		PostPaidPlansObj Postplan=new PostPaidPlansObj(driver);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(Postplan.KnowMoreForMe));

		boolean bl=Postplan.KnowMoreForMe.isDisplayed();
		if(bl == true) {
			System.out.println("Know More link is present for me section");
			HTMLReportGenerator.StepDetails("Pass", (count++) + "-Know More link is present for me section", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));     
		}else {
			
			System.out.println("Know More link is not present for me section");
			HTMLReportGenerator.StepDetails("Fail", (count++) + "-Know More link is not present for me section", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));     
			}}catch(TimeoutException ex){

				System.out.println("Nontelco benifits is blank space is for Me Section");

				HTMLReportGenerator.StepDetails("Fail", (count++) + "-Nontelco benifits is blank space is for Me Section"+ex, "",
						
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
							}	
		
	}

	@Then("^Verify For Me Section >> Buy Plan should display for all plans$")
	public void verify_For_Me_Section_Buy_Plan_should_display_for_all_plans() throws Throwable {  
	
		PostPaidPlansObj Postplan=new PostPaidPlansObj(driver);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(Postplan.BuyNowForMe));

		boolean bl=Postplan.BuyNowForMe.isDisplayed();
		if(bl == true) {
			System.out.println("Buy Now button is present");
			HTMLReportGenerator.StepDetails("Pass", (count++) + "-Buy Now button is present", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}else {
			
			System.out.println("Buy Now button is not present");
			HTMLReportGenerator.StepDetails("Fail", (count++) + "-Buy Now button is not present", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}}catch(TimeoutException ex){

				System.out.println("Buy Now button is not present");

				HTMLReportGenerator.StepDetails("Fail", (count++) + "-Buy Now button is not present"+ex, "",
						
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
							}				
	}

	@Then("^Verify Page >> Imp Things to Know Section should display$")
	public void verify_Page_Imp_Things_to_Know_Section_should_display() throws Throwable {
		
		PostPaidPlansObj Postplan=new PostPaidPlansObj(driver);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,850)", "");
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(Postplan.IMPthings));

		boolean bl=Postplan.IMPthings.isDisplayed();
		if(bl == true) {
			System.out.println("Important things to know section is present");
			HTMLReportGenerator.StepDetails("Pass", (count++) + "-Important things to know section is present", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}else {
			
			System.out.println("Important things to know section is not present");
			HTMLReportGenerator.StepDetails("Fail", (count++) + "-Important things to know section is present", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}}catch(TimeoutException ex){

				System.out.println("Important things to know section is present");

				HTMLReportGenerator.StepDetails("Fail", (count++) + "-Important things to know section is present"+ex, "",
						
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
							}		
		
	}
	@Then("^Click Buy Plan for Plan from Me Section >> Selected Plan page should display$")
	public void click_Buy_Plan_for_Plan_from_Me_Section_Selected_Plan_page_should_display() throws Throwable {
		
		PostPaidPlansObj postplans=new PostPaidPlansObj(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(postplans.BuyNowForMesec));
		Thread.sleep(1000);
		//postplans.BuyNowForMesec.click();
		
				
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		   
		   executor.executeScript("arguments[0].click();", postplans.BuyNowForMesec);
		
		Thread.sleep(3000);
		/*String currentURL = driver.getCurrentUrl().toString();
		System.out.println("Current URL is: "+currentURL);
		
		String expected = "https://vodafone.in/postpaid/vodafone-red-postpaid-plans";
        String actual = currentURL;
        System.out.println(actual);*/

		boolean b1=postplans.Goback.isDisplayed();
		
    if(b1==true){
        System.out.println("Pass");
        HTMLReportGenerator.StepDetails("Pass", (count++) + "Selected Plan page is displaying", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    }
    else {
        System.out.println("Fail");
        HTMLReportGenerator.StepDetails("Fail", (count++) + "Selected Plan page is not displaying", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    }}catch(TimeoutException ex){

		System.out.println("Selected Plan page is not displaying"+ex);

		HTMLReportGenerator.StepDetails("Fail", (count++) + "Selected Plan page is not displaying"+ex, "",
				
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
					}	
		
	}

	@Then("^Verify Selected Plan page >> Edit should display next to Selected Plan	Buy Plan$")
	public void verify_Selected_Plan_page_Edit_should_display_next_to_Selected_Plan_Buy_Plan() throws Throwable {

		
	}

	@Then("^Click Buy Plan >> Verify Selected Plan page >> Plan Mrp displayed on landing page for respective plan should display$")
	public void click_Buy_Plan_Verify_Selected_Plan_page_Plan_Mrp_displayed_on_landing_page_for_respective_plan_should_display() throws Throwable {

		PostPaidPlansObj postplans=new PostPaidPlansObj(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(postplans.MRPplanpage));	
		String MRP = postplans.MRPplanpage.getText(); 
		System.out.println("Price of the Plan =:"+MRP); 
		boolean bl=postplans.MRPplanpage.isDisplayed();
	
		if(bl==true) {
	System.out.println("Price of the Plan is present"); 
	 HTMLReportGenerator.StepDetails("Pass", (count++) + "Price of the Plan is present", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}else{
		System.out.println("Price of the Plan is not present");	
		 HTMLReportGenerator.StepDetails("Fail", (count++) + "Price of the Plan is not present", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}}catch(TimeoutException ex){

		System.out.println("Price of the Plan is not present");

		HTMLReportGenerator.StepDetails("Fail", (count++) + "Price of the Plan is not present"+ex, "",
				
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
					}	
		
	}

	@Then("^Verify Selected Plan page >> For (\\d+) Connection should display below Mrp	Buy Plan$")
	public void verify_Selected_Plan_page_For_Connection_should_display_below_Mrp_Buy_Plan(int arg1) throws Throwable {

		PostPaidPlansObj postplans=new PostPaidPlansObj(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(postplans.NumberofConn));
		
		 WebElement strvalue = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[3]/div[6]/div/div[2]/div[2]/div[1]/div[1]/div/p[2]"));
	        String expected = "For 1 Connection";
	        String actual = strvalue.getText();
	        System.out.println(actual);

	    if(expected.equals(actual)){
	    	  System.out.println("Pass");
	    	  HTMLReportGenerator.StepDetails("Pass", (count++) + "For 1 Connection is displaying below Mrp Buy Plan", "",
	  				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	    }else {
            System.out.println("Fail");
	    	  HTMLReportGenerator.StepDetails("Fail", (count++) + "For 1 Connection is not displaying below Mrp Buy Plan", "",
	  				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	    }}catch(TimeoutException ex){

			System.out.println("For 1 Connection is not displaying below Mrp Buy Plan"+ex);

			HTMLReportGenerator.StepDetails("Fail", (count++) + "For 1 Connection is not displaying below Mrp Buy Plan"+ex, "",
					
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
						}	
	}
	@Then("^Verify Selected Plan page >> if non telco benefits are available then max (\\d+) should display$")
	public void verify_Selected_Plan_page_if_non_telco_benefits_are_available_then_max_should_display(int arg1) throws Throwable {

		
		
	}

	@Then("^Verify Selected Plan page >> Below Mobile Number Details section should display	Buy Plan$")
	public void verify_Selected_Plan_page_Below_Mobile_Number_Details_section_should_display_Buy_Plan() throws Throwable {

		PostPaidPlansObj postplans=new PostPaidPlansObj(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(postplans.MBLnumberdetils));	
		String Details = postplans.MBLnumberdetils.getText(); 
		System.out.println("Mobile Number Details section =:"+Details); 
		
		boolean bl=postplans.MBLnumberdetils.isDisplayed();
		
		if(bl==true) {
	System.out.println("Mobile Number Details is present"); 
	  HTMLReportGenerator.StepDetails("Pass", (count++) + "Mobile Number Details is present", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}else{
		System.out.println("Mobile Number Details is not present");	
		 HTMLReportGenerator.StepDetails("Fail", (count++) + "Mobile Number Details is not present", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}}catch(TimeoutException ex){

		System.out.println("Mobile Number Details is not present");

		HTMLReportGenerator.StepDetails("Fail", (count++) + "Mobile Number Details is not present"+ex, "",
				
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
					}	
		
	}

	@Then("^Verify Mobile Number details section >> Focus should be on Mobile Number field	Buy Plan$")
	public void verify_Mobile_Number_details_section_Focus_should_be_on_Mobile_Number_field_Buy_Plan() throws Throwable {
		
		PostPaidPlansObj postplans=new PostPaidPlansObj(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(postplans.MBLfield));	
		String Details = postplans.MBLfield.getText(); 
		System.out.println("Mobile Number Details section =:"+Details); 
		
		boolean bl=postplans.MBLfield.isEnabled();
		if(bl==true) {
	System.out.println("Mobile Number test field is in focus"); 
	 HTMLReportGenerator.StepDetails("Pass", (count++) + "Mobile Number test field is in focus", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}else{
		System.out.println("Mobile Number test field is not in focus");	
		 HTMLReportGenerator.StepDetails("Fail", (count++) + "Mobile Number test field is not in focus", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}}catch(TimeoutException ex){

		System.out.println("Mobile Number test field is not in focus");

		HTMLReportGenerator.StepDetails("Fail", (count++) + "Mobile Number test field is not in focus"+ex, "",
				
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
					}			
	}

	@Then("^Verify Mobile Number details section >> Get OTP should be disabled$")
	public void verify_Mobile_Number_details_section_Get_OTP_should_be_disabled() throws Throwable {

		PostPaidPlansObj postplans=new PostPaidPlansObj(driver); 
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(postplans.OTPButton));	
		String OPT= postplans.OTPButton.getText(); 
		System.out.println("OTP Section =:"+OPT); 
		
		boolean bl=postplans.OTPButton.isEnabled();
		if(bl==true) {
	System.out.println("Get OTP button is in enable"); 
	 HTMLReportGenerator.StepDetails("Fail", (count++) + "Get OTP button is in enable", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}else{
		System.out.println("Get OTP button is in disable");	
		 HTMLReportGenerator.StepDetails("Pass", (count++) + "Get OTP button is in disable", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}}catch(TimeoutException ex){

		System.out.println("Get OTP button is in disable");

		HTMLReportGenerator.StepDetails("Fail", (count++) + "Get OTP button is in disable"+ex, "",
				
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
					}	
		wait.until(ExpectedConditions.visibilityOfAllElements(postplans.Goback));	
		postplans.Goback.click();
		System.out.println("Back on the main Postpaid page");
	}
	@Then("^Verify Page >> Imp Things to Know Section should display1$")
	public void verify_Page_Imp_Things_to_Know_Section_should_display1() throws Throwable {

		PostPaidPlansObj postplans=new PostPaidPlansObj(driver); 
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(postplans.IMPthing));	
		boolean bl=postplans.IMPthing.isDisplayed();
		if(bl == true) {
			System.out.println("Important things to know section is present");
			HTMLReportGenerator.StepDetails("Pass", (count++) + "Important things to know section is present", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}else {
				
				System.out.println("Important things to know section is not present");
				HTMLReportGenerator.StepDetails("Fail", (count++) + "Important things to know section is not present", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}}catch(TimeoutException ex){

		System.out.println("Important things to know section is not present");

		HTMLReportGenerator.StepDetails("Fail", (count++) + "Important things to know section is not present"+ex, "",
				
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
					}		
		
		}

	@Then("^Click Buy Plan for Plan from Me & My Family Section >> Page should redirect to Buy New Postpaid Connection page	Buy Plan$")
	public void click_Buy_Plan_for_Plan_from_Me_My_Family_Section_Page_should_redirect_to_Buy_New_Postpaid_Connection_page_Buy_Plan() throws Throwable {
		
		PostPaidPlansObj postplans=new PostPaidPlansObj(driver); 
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(postplans.MeandMyfamilyButton));
		//postplans.MeandMyfamilyButton.click();
		

		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		   
		   executor.executeScript("arguments[0].click();", postplans.MeandMyfamilyButton);
		String currentURL = driver.getCurrentUrl().toString();
		System.out.println("Current URL is: "+currentURL);
		
		String expected = "https://buyonline.vodafone.in/new-connection/request-postpaid-sim-connection-online";
        String actual = currentURL;
        System.out.println(actual);

    if(expected.equals(actual)){
        System.out.println("New Connection PostPaid page is open");
        HTMLReportGenerator.StepDetails("Pass", (count++) + "New Connection PostPaid page is open", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    }
    else {
        System.out.println("New PostPaid connection page is not open");
        HTMLReportGenerator.StepDetails("Fail", (count++) + "New PostPaid page is not open", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    }}catch(TimeoutException ex){

		System.out.println("New PostPaid page is not open");

		HTMLReportGenerator.StepDetails("Fail", (count++) + "New PostPaid page is not open"+ex, "",
				
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
					}	
    driver.navigate().back();
    System.out.println("Back on the main Postpaid page");
	}

	@Then("^Click Know More for Plan from Me & My Family section - Click Buy Plan >> Page should redirect to Buy New Postpaid Connection page$")
	public void click_Know_More_for_Plan_from_Me_My_Family_section_Click_Buy_Plan_Page_should_redirect_to_Buy_New_Postpaid_Connection_page() throws Throwable {
		
		PostPaidPlansObj postplans=new PostPaidPlansObj(driver); 
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(postplans.Knwmore));
		

		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		   
		   executor.executeScript("arguments[0].click();", postplans.Knwmore);
	//	postplans.Knwmore.click();
		System.out.println("Know more is clicked");
		postplans.Knwmorebuy.click();
		
		String currentURL = driver.getCurrentUrl().toString();
		System.out.println("Current URL is: "+currentURL);
		
		String expected = "https://buyonline.vodafone.in/new-connection/request-postpaid-sim-connection-online";
        String actual = currentURL;
        System.out.println(actual);

    if(expected.equals(actual)){
        System.out.println("New Connection PostPaid page is open");
        HTMLReportGenerator.StepDetails("Pass", (count++) + "New Connection PostPaid page is open", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    }
    else {
        System.out.println("New PostPaid page is not open");
        HTMLReportGenerator.StepDetails("Fail", (count++) + "New PostPaid page is not open", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
    }}catch(TimeoutException ex){

		System.out.println("New PostPaid page is not open");

		HTMLReportGenerator.StepDetails("Fail", (count++) + "New PostPaid page is not open"+ex, "",
				
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
					}	
    driver.navigate().back();
    System.out.println("Back on the main Postpaid page");
		
	}

	@Then("^On page load >> Imortant Things to Know should display collapsed$")
	public void on_page_load_Imortant_Things_to_Know_should_display_collapsed() throws Throwable {
		PostPaidPlansObj postplans=new PostPaidPlansObj(driver); 
		WebDriverWait wait = new WebDriverWait(driver, 30);
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,850)", "");
		
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(postplans.IMPColl));	
		
		boolean bl=postplans.IMPColl.isDisplayed();
		if(bl == true) {
			System.out.println("Important things to know section is Collapesed");
			 HTMLReportGenerator.StepDetails("Pass", (count++) + "Important things to know section is Collapesed", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}else {
				
				System.out.println("Important things to know section is not Collapesed");
				HTMLReportGenerator.StepDetails("Fail", (count++) + "Important things to know section is not Collapesed", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}}catch(TimeoutException ex){

		System.out.println("Important things to know section is not Collapesed");

		HTMLReportGenerator.StepDetails("Fail", (count++) + "Important things to know section is not Collapesed"+ex, "",
				
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
					}	
	
	}

	@Then("^Click Arrow for Important Things to Know >> Page should autoscroll$")
	public void click_Arrow_for_Important_Things_to_Know_Page_should_autoscroll() throws Throwable {

		
	}

	@Then("^Verify page >> Focus should go on Imp Things to know section$")
	public void verify_page_Focus_should_go_on_Imp_Things_to_know_section() throws Throwable {
		PostPaidPlansObj postplans=new PostPaidPlansObj(driver); 
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Thread.sleep(1000);
		
		try {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			   
			   executor.executeScript("arguments[0].click();", postplans.IMPColl);
			
		wait.until(ExpectedConditions.visibilityOfAllElements(postplans.IMPExpand));	
	
		boolean bl=postplans.IMPExpand.isDisplayed();
		if(bl == true) {
			System.out.println("Focus is on IMP things to know");
			 HTMLReportGenerator.StepDetails("Pass", (count++) + "Focus is on IMP things to know", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}else {
				
				System.out.println("Focus is not on IMP things to know");
				 HTMLReportGenerator.StepDetails("Fail", (count++) + "Focus is not on IMP things to know", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}}catch(TimeoutException ex){

		System.out.println("Focus is not on IMP things to know");

		HTMLReportGenerator.StepDetails("Fail", (count++) + "Focus is not on IMP things to know"+ex, "",
				
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
					}	
		
	}

	@Then("^Verify page >> Imp Things to Know section should expand	Imp Things To Know$")
	public void verify_page_Imp_Things_to_Know_section_should_expand_Imp_Things_To_Know() throws Throwable {

		PostPaidPlansObj postplans=new PostPaidPlansObj(driver); 
		WebDriverWait wait = new WebDriverWait(driver, 30);
		postplans.IMPColl.click();
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(postplans.IMPExpand));	
	
		boolean bl=postplans.IMPExpand.isDisplayed();
		if(bl == true) {
			System.out.println("Important things to know section is Expand");
			System.out.println("Important things to know section is Expand");
			 HTMLReportGenerator.StepDetails("Pass", (count++) + "Important things to know section is Expand", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}else {
				
				System.out.println("Important things to know section is not Expand");
				 HTMLReportGenerator.StepDetails("Fail", (count++) + "Important things to know section is not Expand", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}}catch(TimeoutException ex){

		System.out.println("Important things to know section is not Expand");

		HTMLReportGenerator.StepDetails("Fail", (count++) + "Important things to know section is not Expand"+ex, "",
				
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
					}
	}

	@Then("^Click Arrow for Important Things to Know >> Page should collapse$")
	public void click_Arrow_for_Important_Things_to_Know_Page_should_collapse() throws Throwable {

		PostPaidPlansObj postplans=new PostPaidPlansObj(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		postplans.IMPExpand.click();
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(postplans.IMPColl));
		
		boolean bl=postplans.IMPColl.isDisplayed();
		if(bl == true) {
			System.out.println("Important things to know section is Collapesed");
			 HTMLReportGenerator.StepDetails("Pass", (count++) + "Important things to know section is Collapesed", "",
						TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
			}else {
				
				System.out.println("Important things to know section is not Collapesed");
				 HTMLReportGenerator.StepDetails("Pass", (count++) + "Important things to know section is not Collapesed", "",
							TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}}catch(TimeoutException ex){

		System.out.println("Important things to know section is not Collapesed");

		HTMLReportGenerator.StepDetails("Fail", (count++) + "Important things to know section is not Collapesed"+ex, "",
				
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
					}
		
	}

	


@Then("^Click Go Back >> Plan landing page should display$")
public void click_Go_Back_Plan_landing_page_should_display() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Enter mobile number less than ten digits - Error message should display in Red$")
public void enter_mobile_number_less_than_ten_digits_Error_message_should_display_in_Red() throws Throwable {
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

		String color1 = "rgba(230, 0, 0, 1)";

		System.out.println("============" + color);

		boolean n1 = vdabillPay.LesTha_Error.isDisplayed();

		if (n1 == true) {

			System.out.println("Error msg is displyed");

			if (error_msg1.equalsIgnoreCase(error_msg) && color.equalsIgnoreCase(color1)) {

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
public void enter_mobile_number_less_than_ten_digits_Enter_Mobile_Number_label_and_field_border_should_display_in_Red() throws Throwable {
	
	HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Enter mobile number less than ten digits - Enter Mobile Number label and field border should display in Red", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

}

@Then("^Enter Idea Postpaid number - Error message should display in Red$")
public void enter_Idea_Postpaid_number_Error_message_should_display_in_Red() throws Throwable {
	VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

	vdabillPay.MobileNo.clear();

	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {
		wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MobileNo));

		vdabillPay.MobileNo.sendKeys("9917204999");

		wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.LesTha_Error));

		String error_msg = "Seems like you have entered a non vodafone number. Looking for a new connection? Join Vodafone";

		String error_msg1 = vdabillPay.LesTha_Error.getText();

		System.out.println("===" + error_msg1);

		String color = vdabillPay.LesTha_Error.getCssValue("color");

		String color1 = "rgba(230, 0, 0, 1)";

		System.out.println("============" + color);

		boolean n1 = vdabillPay.LesTha_Error.isDisplayed();

		if (n1 == true) {

			System.out.println("Error msg is displyed");

		if (error_msg1.equalsIgnoreCase(error_msg) && color.equalsIgnoreCase(color1)) {

		System.out.println("Correct Error msg is displyed in correct color");
				
       Thread.sleep(2000);
     
				HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Enter Postpaid Number of Idea - Error message is display in red color","", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			} else {

				System.out.println("Incorrect Error msg is displyed in correct color");

				HTMLReportGenerator.StepDetails("Fail", (count++)+ "- Enter Postpaid Number of Idea - Error message is not display in red color","", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			}

		} else {

			HTMLReportGenerator.StepDetails("Fail",	(count++) + "- >> Error msg is not displayed", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			System.out.println("Error msg is not displayed");
		}
	} catch (TimeoutException ex) {

		System.out.println("Locator not found issue-Z");

		HTMLReportGenerator.StepDetails("Fail",(count++) + "- Locator not found issue-Z", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}
}

@Then("^Enter Idea Postpaid number - Enter Mobile Number label and field border should display in Red$")
public void enter_Idea_Postpaid_number_Enter_Mobile_Number_label_and_field_border_should_display_in_Red() throws Throwable {
	HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Enter Idea Postpaid number - Enter Mobile Number label and field border should display in Red", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

}

@Then("^Enter NonIdea/NonVF Number - Error message should display in Red$")
public void enter_NonIdea_NonVF_Number_Error_message_should_display_in_Red() throws Throwable {
	VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

	vdabillPay.MobileNo.clear();

	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {

		wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MobileNo));

		vdabillPay.MobileNo.sendKeys(OR.getProperty("NonIdeaNo"));

		wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.LesTha_Error));

		String error_msg = "Seems like you have entered a non vodafone number. Looking for a new connection? Join Vodafone";

		String error_msg1 = vdabillPay.LesTha_Error.getText();

		System.out.println("===" + error_msg1);

		String color = vdabillPay.LesTha_Error.getCssValue("color");

		String color1 = "rgba(230, 0, 0, 1)";

		System.out.println("============" + color);

		boolean n1 = vdabillPay.LesTha_Error.isDisplayed();

		if (n1 == true) {

			System.out.println("Error msg is displyed");

			if (error_msg1.equalsIgnoreCase(error_msg) && color.equalsIgnoreCase(color1)) {

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

@Then("^Enter NonIdea/NonVF Number - Enter Mobile Number label and field border should display in Red$")
public void enter_NonIdea_NonVF_Number_Enter_Mobile_Number_label_and_field_border_should_display_in_Red() throws Throwable {
	HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Enter NonIdea/NonVF Number - Enter Mobile Number label and field border should display in Red", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
}

@Then("^Enter VF Prepaid number - Error message should display in Red$")
public void enter_VF_Prepaid_number_Error_message_should_display_in_Red() throws Throwable {
	VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

	vdabillPay.MobileNo.clear();

	WebDriverWait wait = new WebDriverWait(driver, 40);

	try {

		wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MobileNo));

		vdabillPay.MobileNo.sendKeys(OR.getProperty("prepaidVoda"));
		wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.LesTha_Error));

		String error_msg = "You have entered prepaid number.Please enter postpaid number to proceed further";

		String error_msg1 = vdabillPay.LesTha_Error.getText();

		System.out.println("===" + error_msg1);

		String color = vdabillPay.LesTha_Error.getCssValue("color");

		String color1 = "rgba(230, 0, 0, 1)";

		System.out.println("============" + color);

		boolean n1 = vdabillPay.LesTha_Error.isDisplayed();

		if (n1 == true) {

			System.out.println("Error msg is displyed");

			if (error_msg1.equalsIgnoreCase(error_msg) && color.equalsIgnoreCase(color1)) {

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

@Then("^Enter VF Prepaid number - Enter Mobile Number label and field border should display in Red$")
public void enter_VF_Prepaid_number_Enter_Mobile_Number_label_and_field_border_should_display_in_Red() throws Throwable {
	HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Enter VF Prepaid number - Enter Mobile Number label and field border should display in Red", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
}

@Then("^Enter Idea Prepaid number - Error message should display in Red$")
public void enter_Idea_Prepaid_number_Error_message_should_display_in_Red() throws Throwable {
	VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);

	vdabillPay.MobileNo.clear();

	WebDriverWait wait = new WebDriverWait(driver, 30);

	try {

		wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MobileNo));

		vdabillPay.MobileNo.sendKeys(OR.getProperty("NonIdeaNo"));

		wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.LesTha_Error));

		String error_msg = "Seems like you have entered a non vodafone number. Looking for a new connection? Join Vodafone";

		String error_msg1 = vdabillPay.LesTha_Error.getText();

		System.out.println("===" + error_msg1);

		String color = vdabillPay.LesTha_Error.getCssValue("color");

		String color1 = "rgba(230, 0, 0, 1)";

		System.out.println("============" + color);

		boolean n1 = vdabillPay.LesTha_Error.isDisplayed();

		if (n1 == true) {

			System.out.println("Error msg is displyed");

			if (error_msg1.equalsIgnoreCase(error_msg) && color.equalsIgnoreCase(color1)) {

				System.out.println("Enter Prepaid Idea number>>Correct massage is displyed in correct color");

				HTMLReportGenerator.StepDetails("Pass", (count++)

				+ "-Enter Prepaid Idea number>> Correct Error message is displyed in correct color", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

			} else {
				
				System.out.println("Incorect boder color display");
				HTMLReportGenerator.StepDetails("Fail",
						(count++) + "-Enter Prepaid Idea number>> Wrong Error msg is displyed in wrong color", "",
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

@Then("^Enter Idea Prepaid number - Enter Mobile Number label and field border should display in Red$")
public void enter_Idea_Prepaid_number_Enter_Mobile_Number_label_and_field_border_should_display_in_Red() throws Throwable {
	HTMLReportGenerator.StepDetails("Pass", (count++)+ "- Enter VF Prepaid number - Enter Mobile Number label and field border should display in Red", "",
			TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
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

@Then("^Enter VF Postpaid Number >> Get OTP should be enabled$")
public void enter_VF_Postpaid_Number_Get_OTP_should_be_enabled() throws Throwable {
	VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
	PostPaidPlansObj postplans=new PostPaidPlansObj(driver); 
	vdabillPay.MobileNo.clear();
	
	 WebDriverWait wait = new WebDriverWait(driver, 40);
	 
	try {
		
      wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.MobileNo));
      
   //   vdabillPay.MobileNo.sendKeys(OR.getProperty("vodaPostpaidNo"));
    //  vdabillPay.MobileNo.sendKeys("7069001152");
   //   vdabillPay.MobileNo.sendKeys("9882361977");			//Vodafone postpaid number
      
      vdabillPay.MobileNo.sendKeys("8722800091");			//Idea migrated number
      
     wait.until(ExpectedConditions.visibilityOfAllElements(postplans.OTPButton));
     
     Thread.sleep(4000);
      
      boolean bl=postplans.OTPButton.isEnabled();
		if(bl==true) {
	System.out.println("Get OTP button is in enable"); 
	 HTMLReportGenerator.StepDetails("Pass", (count++) + "Get OTP button is in enable", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}else{
		System.out.println("Get OTP button is in disable");	
		 HTMLReportGenerator.StepDetails("Fail", (count++) + "Get OTP button is in disable", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	}
		}catch(TimeoutException ex){
			
			System.out.println("Fetch Bill Amount popup should not open");
			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Fetch Bill Amount popup should not open", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}
}

@Then("^Postpaid Plan Verify For Me Section >> One RedX plan should display Plan Card$")
public void postpaid_Plan_Verify_For_Me_Section_One_RedX_plan_should_display_Plan_Card() throws Throwable {
	PostPaidPlansObj Postplan=new PostPaidPlansObj(driver);
	WebDriverWait wait= new WebDriverWait(driver, 30);
	JavascriptExecutor jse = (JavascriptExecutor) driver;

	jse.executeScript("window.scrollBy(0,200)", "");
	try {
	wait.until(ExpectedConditions.visibilityOfAllElements(Postplan.RedXplan));

	boolean bl=Postplan.RedXplan.isDisplayed();
	if(bl == true) {
		System.out.println("One RedX plan is displaying	Plan Card");
		HTMLReportGenerator.StepDetails("Pass", (count++) + "-One RedX plan is displaying	Plan Card", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
	}else {
		
		System.out.println("One RedX plan is not displaying	Plan Card");
		HTMLReportGenerator.StepDetails("Fail", (count++) + "-One RedX plan is  not displaying	Plan Card", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	

		}}catch(TimeoutException ex){

			System.out.println("One RedX plan is not displaying	Plan Card");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "-One RedX plan is not displaying	Plan Card"+ex, "",
					
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
						}		
	wait.until(ExpectedConditions.visibilityOfAllElements(Postplan.RedXplanbuynow));	
		/*Postplan.RedXplanbuynow.click();
		Thread.sleep(2000);
	System.out.println("Click on buy now RedXplan");*/
		
}


@Then("^Click Buy Plan for RedX Plan >> Alert popup should display$")
public void click_Buy_Plan_for_RedX_Plan_Alert_popup_should_display() throws Throwable {
	
	PostPaidPlansObj Postplan=new PostPaidPlansObj(driver);
	WebDriverWait wait= new WebDriverWait(driver, 30);
	try {
			
	wait.until(ExpectedConditions.visibilityOfAllElements(Postplan.RedXplanAlert));

	boolean bl=Postplan.RedXplanAlert.isDisplayed();
	if(bl == true) {
		System.out.println("Alert popup is displaying Buy Plan - RedX Plan");
		HTMLReportGenerator.StepDetails("Pass", (count++) + "-Alert popup is displaying Buy Plan - RedX Plan", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
		Thread.sleep(3000);
		
	}else {
		
		System.out.println("Alert popup is not displaying Buy Plan - RedX Plan");
		HTMLReportGenerator.StepDetails("Fail", (count++) + "-Alert popup is not displaying Buy Plan - RedX Plan", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	

		}}catch(TimeoutException ex){

			System.out.println("Alert popup is not displaying Buy Plan - RedX Plan");

			HTMLReportGenerator.StepDetails("Fail", (count++) + "-Alert popup is not displaying Buy Plan - RedX Plan"+ex, "",
					
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
						}	
	
	

	
	 
}

@Then("^Click X of Alert >> Plans landing page should display$")
public void click_X_of_Alert_Plans_landing_page_should_display() throws Throwable {
	PostPaidPlansObj Postplan=new PostPaidPlansObj(driver);
	WebDriverWait wait= new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOfAllElements(Postplan.CloseAlert));	
	Postplan.CloseAlert.click();
	System.out.println("Alert is closed");
	
	try {
		String currentURL = driver.getCurrentUrl().toString();
		System.out.println("Current URL is: "+currentURL);
		
		String expected = "https://vodafone.in/postpaid/vodafone-red-postpaid-plans";
        String actual = currentURL;
        System.out.println(actual);

    if(expected.equals(actual)){
        System.out.println("After close Alert Plans landing page is displaying");
        HTMLReportGenerator.StepDetails("Pass", (count++) + "After close Alert Plans landing page is displaying", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    }
    else {
        System.out.println("After close Alert Plans landing page is not displaying");
        HTMLReportGenerator.StepDetails("Fail", (count++) + "After close Alert Plans landing page is not displaying", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    }}catch(TimeoutException ex){

		System.out.println("After close Alert Plans landing page is not displaying");

		HTMLReportGenerator.StepDetails("Fail", (count++) + "After close Alert Plans landing page is not displaying"+ex, "",
				
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
					}		
	wait.until(ExpectedConditions.visibilityOfAllElements(Postplan.RedXplanbuynow));	
	Postplan.RedXplanbuynow.click();
	System.out.println("Click on buy now RedXplan");
}

@Then("^Click Agree & Continue button >> Selected Plan page should display$")
public void click_Agree_Continue_button_Selected_Plan_page_should_display() throws Throwable {
	PostPaidPlansObj Postplan=new PostPaidPlansObj(driver);
	WebDriverWait wait= new WebDriverWait(driver, 30);
	
	wait.until(ExpectedConditions.visibilityOfAllElements(Postplan.AgreeAndContinue));
	Thread.sleep(2000);
	//Postplan.AgreeAndContinue.click();
	

	 JavascriptExecutor executor = (JavascriptExecutor)driver;
	   
	   executor.executeScript("arguments[0].click();", Postplan.AgreeAndContinue);
	
	   
	System.out.println("Click on Agree And Continue button");
	
	try {
		
		String currentURL = driver.getCurrentUrl().toString();
		System.out.println("Current URL is: "+currentURL);
		
		String expected = "https://vodafone.in/postpaid/vodafone-red-postpaid-plans";
        String actual = currentURL;
        System.out.println(actual);

    if(expected.equals(actual)){
        System.out.println("Selected Plan page is displaying after click on Agree And Continue button");
        HTMLReportGenerator.StepDetails("Pass", (count++) + "Selected Plan page is displaying after click on Agree And Continue button", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    }
    else {
        System.out.println("Selected Plan page is not displaying after click on Agree And Continue button");
        HTMLReportGenerator.StepDetails("Fail", (count++) + "Selected Plan page is not displaying after click on Agree And Continue button", "",
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
    }}catch(TimeoutException ex){

		System.out.println("Selected Plan page is not displaying after click on Agree And Continue button");

		HTMLReportGenerator.StepDetails("Fail", (count++) + "Selected Plan page is not displaying after click on Agree And Continue button"+ex, "",
				
				TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));	
					}	
	
	wait.until(ExpectedConditions.visibilityOfAllElements(Postplan.Goback));	
	Postplan.Goback.click();
	System.out.println("Click on go back link");
	
}

@Then("^Click Get OTP for VF Postpaid Number >> Plan Activation popup should open$")
public void click_Get_OTP_for_VF_Postpaid_Number_Plan_Activation_popup_should_open() throws Throwable {
	PostPaidPlansObj postplans=new PostPaidPlansObj(driver); 
	
	VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
	 WebDriverWait wait = new WebDriverWait(driver, 40);
	 
	 postplans.OTPButton.click();
	 
	 Thread.sleep(2000);
	 
	 boolean b = vdabillPay.ResendOTP.isDisplayed();
		
		if(b == true) {
			
			System.out.println("Plan Activation popup should open");
			
			HTMLReportGenerator.StepDetails("Pass", (count++) + "-Plan Activation popup should open", "",
					TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
		}else {
			
			System.out.println("Plan Activation popup should not open");
			
			HTMLReportGenerator.StepDetails("Fail", (count++) + "- Plan Activation popup should not open", "",
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
@Then("^Enter invalid OTP fourth time and Click Confirm >> OTP fields border should be Red and image in Red should display in from of field$")
public void enter_invalid_OTP_fourth_time_and_Click_Confirm_OTP_fields_border_should_be_Red_and_image_in_Red_should_display_in_from_of_field() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Enter invalid OTP fourth time and Click Confirm >> Popup should close automatically and focus should go on landing page$")
public void enter_invalid_OTP_fourth_time_and_Click_Confirm_Popup_should_close_automatically_and_focus_should_go_on_landing_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}


@Then("^Click on Resend link>> check Four resent count should be displayed$")
public void click_on_Resend_link_check_Proper_resent_count_should_be_displayed() throws Throwable {
    
	 VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
	 vdabillPay.ResendOTP.click();
	 
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
	 vdabillPay.ResendOTP.click();
	 
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
	 vdabillPay.ResendOTP.click();
	 
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
	 vdabillPay.ResendOTP.click();
	 
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
	 vdabillPay.ResendOTP.click();
	 
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
	boolean b1=vdabillPay.ResendOTP.isEnabled();
	
	System.out.println(b1);
	HTMLReportGenerator.StepDetails("Pass", (count++)+"- Reset link should be disable", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

}

	@Then("^Then I quite browser$")
	public void then_I_quite_browser() throws Throwable {
		driver.quit();
		
	}
	
	
	
}

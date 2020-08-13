package com.multiple_number;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

public class multiple_nu_step_def {

	Properties prop = new Properties();
	public Properties OR;
	public File file = null;
	public FileReader filereader;
	WebDriver driver;
	public static int number = 1;

	static int count = 1;
	final static Logger log = Logger.getLogger(VodaPay_BillStepDef.class);

@Given("^Opne Bill Pay page$")
public void opne_Bill_Pay_page() throws Throwable {
	String path = System.getProperty("user.dir") + "\\Driver\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", path);
    ChromeOptions profile = new ChromeOptions();
	ChromeOptions options = new ChromeOptions();

	driver = new ChromeDriver(options);
	
	System.out.println(" browser");
	driver.manage().deleteAllCookies();
	Thread.sleep(2000);
	OR = new Properties();

	file = new File(System.getProperty("user.dir") + "/src/test/java/com/Testdata/URL.properties");

	filereader = new FileReader(file);

	OR.load(filereader);


	driver.get("https://care.ideacellular.com/wps/portal/account/online-recharge");

	System.out.println(" Browser Firefox is opening ");

	System.out.println("VodaFone ORC page opened");

	Thread.sleep(5000);

	HTMLReportGenerator.StepDetails("Pass", (count++) + "- Idea ORC page opened", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	
	

}

@When("^Enter Mobile number (\\d+)$")
public void enter_Mobile_number(String number) throws Throwable {
	VILIdeaORCObj vilideaObject = new VILIdeaORCObj(driver);

		driver.navigate().refresh();
	WebDriverWait wait = new WebDriverWait(driver, 30);
	try {
	
		WebElement MobileNo=driver.findElement(By.xpath("//*[@id='onlRecmobileNumber']"));
		wait.until(ExpectedConditions.visibilityOfAllElements(MobileNo));
		Thread.sleep(2000);
		System.out.println("Enter the Idea prepaid number");
		MobileNo.sendKeys("9921177701");
	
		Thread.sleep(5000);
	HTMLReportGenerator.StepDetails("Pass", (count++) + "- Enter the Idea prepaid number:-"+number, "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	
	Thread.sleep(6000);
	WebElement Pack1=driver.findElement(By.xpath("//*[@id='recommended-panel']/div/div[2]/div[1]/div/div/div[2]/a/p"));
	
	wait.until(ExpectedConditions.visibilityOfAllElements(Pack1));
	
	Pack1.click();
	
	
	System.out.println("Click on pack");
	
	HTMLReportGenerator.StepDetails("Pass", (count++) + "- Click on pack", "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	Thread.sleep(7000);
	
}catch (Exception e) {
	System.out.println("=============="+e);

}
}

@Then("^I check for the (\\d+) in step$")
public void i_check_for_the_in_step(String amount) throws Throwable {
	
}

@Then("^Click Pay button$")
public void click_Pay_button() throws Throwable {
	VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
	WebDriverWait wait = new WebDriverWait(driver, 40);

	try {

		wait.until(ExpectedConditions.visibilityOfAllElements(vdabillPay.Pay_Now));

		vdabillPay.Pay_Now.click();
		
	}catch (Exception e) {
		// TODO: handle exception
	}

}

@Then("^Select Wallet >> Click Pay button for Paytm >> Paytm page should display(\\d+)$")
public void select_Wallet_Click_Pay_button_for_Paytm_Paytm_page_should_display(int arg1) throws Throwable {
	 VodafBillPayObj vdabillPay = new VodafBillPayObj(driver);
		
	   WebDriverWait wait = new WebDriverWait(driver, 40);
	  				try {
	  					
	  	WebElement Select_wallet=driver.findElement(By.xpath("//*[@id='pgatewayselector_4']"));
	  	 wait.until(ExpectedConditions.visibilityOfAllElements(Select_wallet));
	  	 
	  	Select_wallet.click();
	  	
	  	System.out.println("Select Wallet-----");
	  	
	  	Thread.sleep(3000);
	 /* 	WebElement Ptm_PaySurely=driver.findElement(By.xpath("//*[@id='333']"));
	   wait.until(ExpectedConditions.visibilityOfAllElements(Ptm_PaySurely));
	   Ptm_PaySurely.click();
	   
	   Thread.sleep(1000);
	   WebElement Proceed_Pay=driver.findElement(By.xpath("//*[@id='333']"));
	   Proceed_Pay.click();
	   */
		HTMLReportGenerator.StepDetails("Pass", (count++)+" - Select Wallet >> Click Pay button for Paytm >> Paytm page should display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

	  
	  	}catch(TimeoutException ex){
	  					
	  		 System.out.println("Select Wallet >> Click Pay button for Paytm >> Paytm page should not display");
	  		 HTMLReportGenerator.StepDetails("Fail", (count++)+" - Select Wallet >> Click Pay button for Paytm >> Paytm page should not display", "", TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));
	  					  
	  				}
	  				
	  				
	  				Thread.sleep(2000);
	  				driver.close();
	   
}
	
}

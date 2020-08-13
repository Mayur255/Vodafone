package com.voda.PayBill;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import HTML_REPORTS.HTMLReportGenerator;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/VodaPay_Bill/VodaFonPay_Bill.feature", glue = "com.voda.PayBill", 

tags = {"@Voda_PayBill_firefox"},plugin = {
		
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/VodaPay_Bill_Report.html",
		
		"json:target/cucumber-reports/Cucumber.json"}, monochrome = true)


  public class VodaPay_BillRuner {
	
	@BeforeClass
	
	public static void setup() {
	
	 System.out.println("Ran the before");
		
		try {
		
			HTMLReportGenerator.TestSuiteStart("C:\\screenshots\\Automation_Reports\\Automation_Reports.html", "BillPay");
			
			HTMLReportGenerator.TestCaseStart("VodaPay_Bill", "Production_Build_number:001");
			
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
    }
	@AfterClass
	public static void teardown() {
		System.out.println("Run the after");
		HTMLReportGenerator.TestCaseEnd();
		HTMLReportGenerator.TestSuiteEnd();

	}
}

package com.pack_category;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import HTML_REPORTS.HTMLReportGenerator;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/Pack_categories/CategorySpecific.feature", glue = "com.pack_category", 

tags = {"@CategoryPage"},plugin = {
		
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/Vodaidea_ORC.html",
		
		"json:target/cucumber-reports/Cucumber.json"}, monochrome = true)

public class CategorySpecificPageRunner {

		@BeforeClass
		
		public static void setup() {
		
		 System.out.println("Ran the before");
			
		  try {
			
				HTMLReportGenerator.TestSuiteStart("C:\\screenshots\\Automation_Reports\\Automation_Reports.html", "HomePage");
				
	//	 HTMLReportGenerator.TestCaseStart("Unlimited_page", "Production_Build_number:001");
	// HTMLReportGenerator.TestCaseStart("Talktime_page", "Production_Build_number:001");
	
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

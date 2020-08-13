package com.voda.ideaOrc;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import HTML_REPORTS.HTMLReportGenerator;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/VFIdeaORC/VF_ideaORC.feature", glue = "com.voda.ideaOrc", 

tags = {"@Vodafone_ORC_Chrome"},plugin = {
		
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/Vodaidea_ORC.html",
		
		"json:target/cucumber-reports/Cucumber.json"}, monochrome = true)

public class VFideaOrcRunner {

		@BeforeClass
		
		public static void setup() {
		
		 System.out.println("Ran the before");
			
		  try {
			
		 HTMLReportGenerator.TestSuiteStart("C:\\screenshots\\Automation_Reports\\Automation_Reports.html", "Online_Recharge");
				
		// HTMLReportGenerator.TestCaseStart("VodaPay_ORC", "Production_Build_number:001");
				
		  } catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
	    }
		@AfterClass
		public static void teardown() {
			System.out.println("Run the after");
		//	HTMLReportGenerator.TestCaseEnd();
			HTMLReportGenerator.TestSuiteEnd();

  }
}

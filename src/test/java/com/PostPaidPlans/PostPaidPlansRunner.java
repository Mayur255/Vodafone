package com.PostPaidPlans;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import HTML_REPORTS.HTMLReportGenerator;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/PostPaidPlanVoda/PostPaidPlanVodafone.Feature", glue = "com.PostPaidPlans", 

tags = {"@Plans_Automation"},plugin = {
		
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/VodaPay_Bill_Report.html",
		
		"json:target/cucumber-reports/Cucumber.json"}, monochrome = true)


public class PostPaidPlansRunner {

@BeforeClass
	
	public static void setup() {
	
	 System.out.println("Ran the before");
		
		try {
		
			HTMLReportGenerator.TestSuiteStart("C:\\screenshots\\Automation_Reports\\Automation_Reports.html", "PostPaid");
			
			HTMLReportGenerator.TestCaseStart("Voda_PostpaidPlans_Idea_Number_Migrated", "Production_Build_number:001");
		//	HTMLReportGenerator.TestCaseStart("Voda_PostpaidPlans", "Production_Build_number:001");
			
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

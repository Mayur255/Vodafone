package com.multiple_number;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import HTML_REPORTS.HTMLReportGenerator;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/multiple_number/multi_num.feature", glue = "com.multiple_number", 

tags = {"@tag2"},plugin = {
		
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/VodafoneHomePage_Report.html",
		
		"json:target/cucumber-reports/Cucumber.json"}, monochrome = true)

public class multiple_number_runner {	
@BeforeClass
	
	public static void setup() {
	
	 System.out.println("Ran the before");
		
		try {
		
			HTMLReportGenerator.TestSuiteStart("C:\\screenshots\\Multiple_number\\Automation_Reports.html", "ORC");
			
			HTMLReportGenerator.TestCaseStart("ORC_Page", "Production_Build_number:001");
			
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





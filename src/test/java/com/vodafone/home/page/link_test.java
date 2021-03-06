package com.vodafone.home.page;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.config.baseclass;

import HTML_REPORTS.HTMLReportGenerator;
import HTML_REPORTS.TakeScreenShot;
public class link_test {

	static int a=1;
	
	public static void main(String[] args) throws InterruptedException 
	{
	
		String homePage = "https://www.vodafone.in/";
		String path = System.getProperty("user.dir") + "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
        
       WebDriver driver = new ChromeDriver();
        
        driver.get(homePage);
		
        Thread.sleep(4000);
	//   List elementList1 = new ArrayList();
	 
        List<WebElement> links=driver.findElements(By.tagName("a"));
		
		System.out.println("Total links are "+links.size());
	//	HTMLReportGenerator.StepDetails("INFO",  (count++)+ "- Total links available on page= "+links.size(), "",TakeScreenShot.TakeScreenShot(baseclass.Get_ImageFilePath(), driver));

		 List<WebElement> activeLink=new ArrayList<WebElement>();
		
		for(int i=0;i<links.size();i++)
		{
			
			WebElement ele= links.get(i);
			
			String url=ele.getAttribute("href");
			
			if((links.get(i).getAttribute("href")!=null) && (!links.get(i).getAttribute("href").contains("javascript")))
			{
			
			activeLink.add(links.get(i));
				
			System.out.println("Active:-"+url);
	//		System.out.println("########## "+url);
			}
		}
		
		System.out.println("Active links:-"+activeLink.size());
		for(int j=0;j<activeLink.size();j++)
		{
			WebElement ele= activeLink.get(j);
			String url=ele.getAttribute("href");
			try {
			
	           HttpURLConnection httpURLConnect=(HttpURLConnection)new URL(activeLink.get(j).getAttribute("href")).openConnection();
	           
	           httpURLConnect.setConnectTimeout(5000);
	           
	           httpURLConnect.connect();
	           
	                      
	           if(httpURLConnect.getResponseCode()==200)
	           {
	        	   
	               System.out.println(a+":-"+url+" - "+httpURLConnect.getResponseMessage());
	               System.out.println(httpURLConnect.getResponseCode());
	               a++;
	            }
	           else {
	        	   System.out.println(a+":-"+url+" - "+httpURLConnect.getResponseMessage());
	               System.out.println(httpURLConnect.getResponseCode());
	               a++;
	           }
	           
	            if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
	           {
	               System.out.println(url+"@@@@ - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
	          a++;
	           }
		
			
			}catch (Exception e) {
				 System.out.println(a+":-"+url+" - "+e);	
				 a++;
				 
			}
		
		
		
		}
		}
	
	
}



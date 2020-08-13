package com.Testdata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Meta_function {

	
	
	public Meta_function() {
		// TODO Auto-generated constructor stub
		WebDriver driver= new ChromeDriver();
	
	WebElement meta_dec=driver.findElement(By.xpath("//meta[@name='description']"));
	WebElement meta_viewport=driver.findElement(By.xpath("//meta[@name='viewport']"));
	WebElement meta_template=driver.findElement(By.xpath("//meta[@name='template']"));

	boolean b1 =meta_dec.isDisplayed();
	
	boolean b2= meta_viewport.isDisplayed();
	
	boolean b3= meta_template.isDisplayed();
	
	if(b1==true)
	{
		String s=meta_dec.getText();
		System.out.println("Meta description is displayed and text is"+s);
		
	}
	else
	{
		System.out.println("Meta description is not displayed");
	}
	
	if(b2==true)
	{
		String s2=meta_viewport.getText();
		System.out.println("Meta viewport is displayed and text is:-"+s2);
	}
	else
	{
		System.out.println("Meta viewport is not displayed");
	}
	

	if(b3==true)
	{
		String s3=meta_template.getText();
		System.out.println("Meta template is displayed and text is:-"+s3);
	}
	else
	{
		System.out.println("Meta template is not displayed");
	}
}
}
	


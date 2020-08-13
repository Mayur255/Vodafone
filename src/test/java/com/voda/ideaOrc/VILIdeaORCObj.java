package com.voda.ideaOrc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class VILIdeaORCObj {
	
public VILIdeaORCObj(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='mobile']")
	public WebElement MobileNo;
	
	@FindBy(how=How.XPATH, using="//*[@id='rechargeamount' and @class ='form-control']")
	public WebElement AmountBill;
	
	@FindBy(how=How.XPATH, using="//input[@id='rechargeamount']")
	public WebElement Amount;
	
	@FindBy(how=How.XPATH, using="//div[@id='nav-tab']")
	public WebElement Packs_categories;
	
	@FindBy(how=How.XPATH, using="//img[@class='clearAll hide']")
	public WebElement Cross;
	
	@FindBy(how=How.XPATH, using="//*[contains(@class, 'btn payBtn px-4 mt-2')]")
	public WebElement Pay_Now;
	
	@FindBy(how=How.XPATH, using="//div[@class='fetchData']/a")
	public WebElement Fetch_lastRechage;
	
	@FindBy(how=How.XPATH, using="//div[@class='orcForm']/div[2]/div/h1")
	public WebElement Lets_doRechage;
	
	@FindBy(how=How.XPATH, using="//div[@class='banner-parent vodafoneredColour']")
	public WebElement Banner_doRechage;
	
	@FindBy(how=How.XPATH, using="//div[@id='errorMsg']")
	public WebElement LesTha_Error;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class, 'invalid-feedback') and contains(@style ,'display: block;')]")
	public WebElement LebelFieldBoder;
	
	@FindBy(how=How.XPATH, using="//span[contains(@class, 'desktop-heading')]")
	public WebElement ideaPostpaid_toastmsg;
	
	@FindBy(how=How.XPATH, using="/html/body/div/div/div[2]/div/div[2]/div/div/div")
	public WebElement Toast_msg;
	
	@FindBy(how=How.XPATH, using="//a[@class='desktop-subheading remove align-self-center miToastLink']")
	public WebElement Toast_msg_dismiss;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"cardAmountSearch\"]/div/div/div[1]/div/div/div[1]/div/div[1]/div/p/span[2]")
	public WebElement Pack_value;
	
	@FindBy(how=How.XPATH, using="//div[@class='col-12 col-md-3 mb-2 mb-md-0']/div/div/div[2]")
	public WebElement Amount_error_msg;
	
	@FindBy(how=How.XPATH, using="//div[@class='col-12 col-md-3 mb-2 mb-md-0']/div/div/input")
	public WebElement Amount_field_border;
	
	@FindBy(how=How.XPATH, using="//div[@class='nav nav-tabs ']/a[1]")
	public WebElement Packs_First_categories;
	
	@FindBy(how=How.XPATH, using="//div[@class='nav nav-tabs ']/a[2]")
	public WebElement Unlimited_pack;
	

	@FindBy(how=How.XPATH, using="//*[@id='unlimited']/div[1]/div[2]/div/div/div")
	public WebElement Pack_details;
	
	
	@FindBy(how=How.XPATH, using="//*[@id='unlimited']/div/div[2]/div/div/div/div[1]/div/div[2]/div/div/div[1]/div/div[1]/div/p/span[2]")
	public WebElement unlimited_Pack_value;
	
	@FindBy(how=How.XPATH, using="//*[@id='unlimited']/div/div[2]/div/div/div/div[1]/div/div[2]/div/div/div[2]/ul[1]/li[5]/div")
	public WebElement unlimited_Pack_validity;
	
	@FindBy(how=How.XPATH, using="//*[@id='unlimited']/div/div[2]/div/div/div/div[1]/div/div[2]/div/div/div[2]/ul[1]/li[1]")
	public WebElement unlimited_Pack_Talktime;
	
	@FindBy(how=How.XPATH, using="//*[@id='unlimited']/div/div[2]/div/div/div/div[1]/div/div[2]/div/div/div[2]/ul[1]/li[2]")
	public WebElement unlimited_Pack_Data;
	
	
	@FindBy(how=How.XPATH, using="//*[@id='nav-home-tab'][4]")
	public WebElement value_categories;
	
	@FindBy(how=How.XPATH, using="//*[@id='valuepack']/div/div[2]/div/div/div/div[1]/div/div/div/div[2]/div/div/div[2]/ul[1]/li[3]")
	public WebElement value_pack_data;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"valuepack\"]/div/div[2]/div/div/div/div[1]/div/div/div/div[2]/div/div/div[2]/ul[1]/li[5]")
	public WebElement value_pack_validity;
	
	
	@FindBy(how=How.XPATH, using="//*[@id='nav-home-tab'][3]")
	public WebElement Add_on_category;
	
	@FindBy(how=How.XPATH, using="//*[@id='addon']/div/div[2]/div/div/div/div[1]/div/div/div/div[2]/div/div/div[2]/ul[1]/li[2]")
	public WebElement Add_on_pack_data;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"addon\"]/div/div[2]/div/div/div/div[1]/div/div/div/div[2]/div/div/div[2]/ul[1]/li[5]/div/div[1]")
	public WebElement Add_on_pack_validaty;

	@FindBy(how=How.XPATH, using="//*[@id='unlimited']/div/div[2]/div/div/div/div[2]/div/div[4]/div/div/div[2]/div/a")
	public WebElement recommended_know_more;
	
	@FindBy(how=How.XPATH, using="//*[@id='unlimited']/div/div[2]/div/div/div/div[1]/div/div[4]/div/div/div[2]/div/a")
	public WebElement unlimited_know_more;
	
	@FindBy(how=How.XPATH, using="//*[@id='recommended']/div[2]/div/div/p/a")
	public WebElement recommended_load_more;
	
	
	@FindBy(how=How.XPATH, using="//*[@id='knowmoreModal']/div/div/div[1]/button/span/img")
	public WebElement popup_cross;
	
	@FindBy(how=How.XPATH, using="//*[@id='knowmoreModal']/div/div/div[2]/div/div[2]/div[2]/ul/li[1]")
	public WebElement popup_talktime;
	
	@FindBy(how=How.XPATH, using="//*[@id='knowmoreModal']/div/div/div[2]/div/div[2]/div[2]/ul/li[2]")
	public WebElement popup_data;
	
	@FindBy(how=How.XPATH, using="//*[@id='knowmoreModal']/div/div/div[2]/div/div[2]/div[2]/ul/li[3]")
	public WebElement popup_SMS;		
	
	@FindBy(how=How.XPATH, using="//*[@id='knowmoreModal']/div/div/div[2]/div[1]/div/p/span")
	public WebElement popup_Pack_amount;	
	
	@FindBy(how=How.XPATH, using="//*[@id='unlimited']/div[1]/div[2]/div/div/div")
	public WebElement Pack_counts;
	
	@FindBy(how=How.XPATH, using="//*[@id='unlimited']/div/div[2]/div/div/div/div[1]/div/div[4]/div/div/div[1]/div/button")
	public WebElement Pack1;
	
	@FindBy(how=How.XPATH, using="//*[@id='unlimited']/div/div[2]/div/div/div/div[1]/div/div[1]/div/div/div[2]/ul[2]")
	public WebElement non_telco_ben;

	@FindBy(how=How.XPATH, using="//div[@class='thankorcImg']/p")
	public WebElement rechargefail1;

	@FindBy(how=How.XPATH, using= "//*[@id='headingTwo']")
	public WebElement ImpThinstoNow;
	
	@FindBy(how=How.XPATH, using= "//*[@id='headingTwo']")
	public WebElement ImpThinstono;
	
	@FindBy(how=How.XPATH, using= "//*[@id='headingTwo']/h2")
	public WebElement ImpThingArrow;
}


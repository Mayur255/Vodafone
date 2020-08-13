package com.online_Pack;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class VF_Pack_Object {

	
public VF_Pack_Object(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='mobile']")
	public WebElement MobileNo;
	
	@FindBy(how=How.XPATH, using="//span[@class='selected-circle']")
	public WebElement Circle;
	
	@FindBy(how=How.XPATH, using="//div[@class='nav nav-tabs navmb']")
	public WebElement packs_categories;
	
	@FindBy(how=How.XPATH, using="//a[@class='nav-item nav-link packsMaincat active']")
	public WebElement unlimited_categories;
	
	@FindBy(how=How.XPATH, using="//a[@class='nav-item nav-link packsMaincat passive'][1]")
	public WebElement talktime_categories;
	
	@FindBy(how=How.XPATH, using="//a[@class='nav-item nav-link packsMaincat passive'][2]")
	public WebElement internet_categories;
	
	@FindBy(how=How.XPATH, using="//div[@class='tab-pane fade show active']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/h4")
	public WebElement pack_amount;
	
	
	@FindBy(how=How.XPATH, using="//*[@id='Unlimited__']/div[1]/div/div[4]/div[1]/div[1]")
	public WebElement pack_talktime;
	
	@FindBy(how=How.XPATH, using="//*[@id='Unlimited__']/div[1]/div/div[4]/div[1]/div[2]")
	public WebElement pack_data;
	
	@FindBy(how=How.XPATH, using="//*[@id='Unlimited__']/div[1]/div/div[4]/div[1]/div[4]")
	public WebElement pack_validity;
	
	@FindBy(how=How.XPATH, using="//*[@id='Unlimited__']/div[1]/div/div[5]/div/p/a")
	public WebElement know_more;
	
	@FindBy(how=How.XPATH, using="//*[@id='Know-more']/div/div/div[1]/button/span/img")
	public WebElement cross_btn;
	
	@FindBy(how=How.XPATH, using="//*[@id='Know-more']/div/div/div[2]")
	public WebElement know_more_popup;
	
	@FindBy(how=How.XPATH, using="//*[@class='knowMoreAmt']")
	public WebElement know_more_popup_pack_amt;
	
	@FindBy(how=How.XPATH, using="//*[@class='my-md-3 my-2']")
	public WebElement know_more_popup_pack_amt_belowtext;
	
	@FindBy(how=How.XPATH, using="//*[@class='planbefenit row']")
	public List<WebElement> know_more_popup_pack_amt_ws;
	
	@FindBy(how=How.XPATH, using="//*[@id='Know-more']/div/div/div[2]/div[1]/div/div/p/span")
	public WebElement know_more_pop_MRP;
	
	@FindBy(how=How.XPATH, using="//*[@id='Know-more']/div/div/div[2]/div[3]/div[1]/div/div/p")
	public WebElement know_more_pop_MRP_below_text;



	@FindBy(how=How.XPATH, using="//*[@id='Know-more']/div/div/div[2]/div[3]/div[1]/div/div/ul/li[1]")
	public WebElement popup_talktime;
	
	@FindBy(how=How.XPATH, using="//*[@id='Know-more']/div/div/div[2]/div[3]/div[1]/div/div/ul/li[2]")
	public WebElement popup_data;
	
	@FindBy(how=How.XPATH, using="//*[@id='Know-more']/div/div/div[2]/div[3]/div[1]/div/div/ul/li[3]")
	public WebElement popup_SMS;
	
	@FindBy(how=How.XPATH, using="//*[@id='Know-more']/div/div/div[2]/div[3]/div[2]/div/div")
	public WebElement popup_benefits;
	
	@FindBy(how=How.XPATH, using="//*[@id='Know-more']/div/div/div[3]/button")
	public WebElement popup_buy_pack_btn;
	
	@FindBy(how=How.XPATH, using="//h4[@class='plan-amount col-auto d-inline-flex p-0 mb-0']")
	public WebElement selected_pack_amt;
	
	@FindBy(how=How.XPATH, using="//div[@class='mobile-number-details ']")
	public WebElement selected_mobile_number_section;
	
	@FindBy(how=How.XPATH, using="//*[@id='mobile']")
	public WebElement selected_mobile_number;
	
	@FindBy(how=How.XPATH, using="//*[@class='btn btn-secondary confirm-btn disabled miBlackbtn']")
	public WebElement confirm_btn_disable;
	
	@FindBy(how=How.XPATH, using="//div[@class='edit goBackEdit']/a")
	public WebElement go_back;
	
	@FindBy(how=How.XPATH, using="//*[@id='Unlimited__']/div[1]/div/div[5]/div/div/button")
	public WebElement Buy_pack_btn;
	
	@FindBy(how=How.XPATH, using="//div[@class='invalid-feedback']")
	public WebElement LesTha_Error;
	
	@FindBy(how=How.XPATH, using="//*[@class='btn btn-secondary confirm-btn miBlackbtn']")
	public WebElement confirm_btn_enable;
	
}

package com.VF_homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class homepage_object {

	
public homepage_object(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
     @FindBy(how=How.XPATH, using="//div[@class='row col-12 px-0']")
     public WebElement Home_pageHeder;
    
     @FindBy(how=How.XPATH, using="//div[@id='footerLinks']")
     public WebElement Home_footerHeder;
     
     @FindBy(how=How.XPATH, using="//*[@id='topbannercarousalhomepage2']")
     public WebElement TopBanner;
     
     @FindBy(how=How.XPATH, using="//*[@id='mobile']")
     public WebElement mobile_No;
     
     @FindBy(how=How.XPATH, using="//div[@class='submitNumber disabled']")
     public WebElement arrow_key;
     
     @FindBy(how=How.XPATH, using="//div[@class='invalid-feedback']")
     public WebElement error_msg;
     
     @FindBy(how=How.XPATH, using="//div[@class='media']")
     public WebElement tost_msg;
     
     @FindBy(how=How.XPATH, using="//div[@class='col-2 row']")
     public WebElement tost_dissmis;
     
     @FindBy(how=How.XPATH, using="//div[@class='submitNumber']")
     public WebElement ArrowKey;
     
     @FindBy(how=How.XPATH, using="//div[@class='col-12']")
     public WebElement Billpay_page;
     
     @FindBy(how=How.XPATH, using="//*[@id='mobile']")
     public WebElement Billpay_Mobile;
     
     @FindBy(how=How.XPATH, using="//input[@id='mobile']")
     public WebElement ORC_number;
     
     @FindBy(how=How.XPATH, using="//div[@class='inputFldBox']")
     public WebElement ORC_number_oldpage;
     
     @FindBy(how=How.XPATH, using="//*[@id='payamount']")
     public WebElement Billpay_Amount;
     
     @FindBy(how=How.XPATH, using="//*[@id='fBill']")
     public WebElement Billpay_fechBill;
     
     @FindBy(how=How.XPATH, using="//*[@id='rechargeamount']")
     public WebElement recharge_page;
     
     @FindBy(how=How.XPATH, using="//a[@href='javascript:void(0)']")
     public WebElement recharge_fechlastRecharge;
     
     @FindBy(how=How.XPATH, using="//*[@id='unlimited']/div/div[2]/div/div")
     public WebElement recharge_RecomenedPack;
     
     @FindBy(how=How.XPATH, using="//span[@id='quickrecharge']")
     public WebElement Home_quicklink;
     
     @FindBy(how=How.XPATH, using="//div[@class='col-12 benefits-heading']")
     public WebElement Loadedbenifit_voda;
     
     @FindBy(how=How.XPATH, using="//div[@class='trending-section-heading']")
     public WebElement exclusive_voda;
     
     @FindBy(how=How.XPATH, using="//*[@id='topBanner']/ol/li[1]")
     public WebElement banner_radio_btn1;
     
     @FindBy(how=How.XPATH, using="//*[@id='topBanner']/ol/li[2]")
     public WebElement banner_radio_btn2;
     
     @FindBy(how=How.XPATH, using="//*[@id='topBanner']/ol/li[3]")
     public WebElement banner_radio_btn3;
     
     @FindBy(how=How.XPATH, using="//*[@id='topBanner']/ol/li[4]")
     public WebElement banner_radio_btn4;
     
     @FindBy(how=How.XPATH, using="//*[@id='topBanner']/ol/li[5]")
     public WebElement banner_radio_btn5;
     
     @FindBy(how=How.XPATH, using="//div[@class='carousel-inner']")
     public WebElement banner_image;
     
     @FindBy(how=How.XPATH, using="//*[@id='topbannercarousalhomepage1']")
     public WebElement banner_image1;
     
     @FindBy(how=How.XPATH, using="//*[@id='topbannercarousalhomepage2']")
     public WebElement banner_image2;
     
     @FindBy(how=How.XPATH, using="//*[@id='topbannercarousalhomepage3']")
     public WebElement banner_image3;
     
     @FindBy(how=How.XPATH, using="//*[@id='topbannercarousalhomepage4']")
     public WebElement banner_image4;
     
     @FindBy(how=How.XPATH, using="//*[@id='topbannercarousalhomepage5']")
     public WebElement banner_image5;
     
     @FindBy(how=How.XPATH, using="//div[3]/div/div/div[1]/div/div/a/div")
     public WebElement Buy_postpaid_sim_icon;
     
     @FindBy(how=How.XPATH, using="//div[3]/div/div/div[2]/div/div/a/div")
     public WebElement Buy_prepaid_sim_icon;
     
     @FindBy(how=How.XPATH, using="//div[3]/div/div/div[3]/div/div/a/div")
     public WebElement International_roaming_icon;
     
     @FindBy(how=How.XPATH, using="//div[3]/div/div/div[4]/div/div/a/div")
     public WebElement Vodafone_play_icon;
     
     @FindBy(how=How.XPATH, using="//div[3]/div/div/div[5]/div/div/a/div")
     public WebElement Help_and_support_icon;
     
     @FindBy(how=How.XPATH, using="//div[1]/div[1]/div/div/div/div[1]/div/p/span")
     public WebElement icon1_with_text;
     
     @FindBy(how=How.XPATH, using="//div[2]/div[1]/div/div/div/div[1]/div/p/span")
     public WebElement icon2_with_text;
     
     @FindBy(how=How.XPATH, using="//div[1]/div[2]/div/div/div/div[1]/div/p/span")
     public WebElement icon3_with_text;
     
     @FindBy(how=How.XPATH, using="//div[2]/div[2]/div/div/div/div[1]/div/p/span")
     public WebElement icon4_with_text;
     
     
     @FindBy(how=How.XPATH, using="//div[@class='row loaded-benefits']/div[2]/img")
     public WebElement Loaded_benefit_icon1;
     
     @FindBy(how=How.XPATH, using="//div[@class='row loaded-benefits']/div[3]/img")
     public WebElement Loaded_benefit_icon2;
     
     @FindBy(how=How.XPATH, using="//div[@class='row loaded-benefits']/div[4]/img")
     public WebElement Loaded_benefit_icon3;
     
     @FindBy(how=How.XPATH, using="//div[@class='row loaded-benefits']/div[5]/img")
     public WebElement Loaded_benefit_icon4;
     
     @FindBy(how=How.XPATH, using="//div[@class='row loaded-benefits']/div[6]/img")
     public WebElement Loaded_benefit_icon5;
     
     @FindBy(how=How.XPATH, using="//div[@class='row loaded-benefits']/div[7]/img")
     public WebElement Loaded_benefit_icon6;
     
     @FindBy(how=How.XPATH, using="//*[@id='slick-slide-control00']")
     public WebElement exclusive_treats_slide_control1;
     
     @FindBy(how=How.XPATH, using="//*[@id='slick-slide-control01']")
     public WebElement exclusive_treats_slide_control2;
     
     @FindBy(how=How.XPATH, using="//*[@id='slick-slide-control02']")
     public WebElement exclusive_treats_slide_control3;
     
     @FindBy(how=How.XPATH, using="//*[@id='slick-slide-control03']")
     public WebElement exclusive_treats_slide_control4;
     
     @FindBy(how=How.XPATH, using="//*[@id='slick-slide-control04']")
     public WebElement exclusive_treats_slide_control5;
     
     @FindBy(how=How.XPATH, using="//*[@id='slick-slide-control05']")
     public WebElement exclusive_treats_slide_control6;
     
     @FindBy(how=How.XPATH, using="//*[@id='slick-slide00']/div/img")
     public WebElement exclusive_treats_image01;
     
     @FindBy(how=How.XPATH, using="//*[@id='slick-slide01']/div/img")
     public WebElement exclusive_treats_image02;
     
     @FindBy(how=How.XPATH, using="//*[@id='slick-slide02']/div/img")
     public WebElement exclusive_treats_image03;
     
     @FindBy(how=How.XPATH, using="//*[@id='slick-slide03']/div/img")
     public WebElement exclusive_treats_image04;
     
     @FindBy(how=How.XPATH, using="//*[@id='slick-slide04']/div/img")
     public WebElement exclusive_treats_image05;
     
     @FindBy(how=How.XPATH, using="//*[@id='slick-slide05']/div/img")
     public WebElement exclusive_treats_image06;
     
     
     
}

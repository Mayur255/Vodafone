package com.pack_category;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CategoryObject {
public CategoryObject(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
@FindBy(how=How.XPATH, using="")
public WebElement MobileNo;

@FindBy(how=How.XPATH, using="//span[@class='selected-circle']")
public WebElement Circle;

@FindBy(how=How.XPATH, using="//div[@class='tab-content col-md-12']")
public WebElement packs_categories;

@FindBy(how=How.XPATH, using="//h4[@class='plan-amount col-6 d-inline-flex p-0 col-md-12 mb-0']")
public WebElement packs_Details;

@FindBy(how=How.XPATH, using="//h4[@class='teleco-benefit validity']")
public WebElement packs_Validity;

@FindBy(how=How.XPATH, using="//h4[@class='teleco-benefit talktime']")
public WebElement packs_UnlimitedTalkTime;

@FindBy(how=How.XPATH, using="//*[@id='Unlimited__']/div[1]/div/div[5]/div/p/a")
public WebElement packs_knowMoreBT;

@FindBy(how=How.XPATH, using="//*[@id='Internet__']/div[1]/div/div[5]/div/p/a")
public WebElement data_packs_knowMoreBT;

@FindBy(how=How.XPATH, using="//*[@id='Know-more']/div/div/div[1]/button/span/img")
public WebElement packs_CrossMoreBT;

@FindBy(how=How.XPATH, using="//span[@class='knowMoreAmt']")
public WebElement packs_MRPpack;

@FindBy(how=How.XPATH, using="//p[@class='modalKnowmoreBenifit container mb-2 includes']")
public WebElement packs_includetext;

@FindBy(how=How.XPATH, using="//*[@id='Talktime__']/div[1]/div/div[5]/div/p/a")
public WebElement talktime_knowMoreBT;

@FindBy(how=How.XPATH, using="//span[@class='knowMoreAmt']")
public WebElement talktime_MRPpack;

@FindBy(how=How.XPATH, using="//*[@id='Know-more']/div/div/div[2]/div[3]/div[1]/div/div/ul/li")
public WebElement talktime_details;

@FindBy(how=How.XPATH, using="//*[@id=\"Know-more\"]/div/div/div[2]/p")
public WebElement talktime_addition_benefits;

}

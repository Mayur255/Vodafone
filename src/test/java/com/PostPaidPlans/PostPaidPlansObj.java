package com.PostPaidPlans;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PostPaidPlansObj {

public PostPaidPlansObj(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}


@FindBy(how = How.XPATH, using = "(//h2[@class='plan-section-heading'])[1]") 
public WebElement Family;

@FindBy(how = How.XPATH, using = "(//h2[@class='plan-section-heading'])[2]") 
public WebElement ForMe;

@FindBy(how = How.XPATH, using = "//div[@class='forMe card-wrapper row plans-card border packshow']") 
public List<WebElement> CountPlansforMe;

@FindBy(how = How.XPATH, using = "//div[@class='forFamily card-wrapper row plans-card border packshow']") 
public List<WebElement> CountPlansformeandmyfamily;

@FindBy(how = How.XPATH, using = "(//span[@class='plan-amount p-0 mb-0'])[1]") 
public WebElement MRPForMeandmyFamily;

@FindBy(how = How.XPATH, using = "//span[@class='plan-amount col-6 p-0 mb-0']") 
public WebElement MRPForMe;

@FindBy(how = How.XPATH, using = "//div[@id='mePlans']/div/div[2]/div/div[1]/div/p[2]") 
public WebElement ConnForMe;

@FindBy(how = How.XPATH, using = "(//p[@class='plan-coupon p-0 mb-0'])[1]") 
public WebElement ConnForMeandFamily;


@FindBy(how = How.XPATH, using = "(//div[@class='non-teleco-feature align-items-center d-flex col col-md col-sm-12 row'])[1]") 
public WebElement NoncomMeandFamily;

	
@FindBy(how = How.XPATH, using = "(//div[@class='non-teleco-feature align-items-center d-flex col col-md col-sm-12 row'])[1]") 
public WebElement NoncomForMe;		

@FindBy(how = How.XPATH, using = "(//a[@class='anchorknowmore miBlackLink'])[5]") 
public WebElement KnowMoreForMe;

@FindBy(how = How.XPATH, using = "(//a[@class='anchorknowmore miBlackLink'])[1]") 
public WebElement KnowMoreForMeandFamily;

@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-secondary buy-btn buybutton btnpd miBlackbtn'])[1]") 
public WebElement BuyNowForMe;

@FindBy(how = How.XPATH, using = "(//button[@class=\"btn btn-secondary buy-btn buybuttonforfamily btnpd miBlackbtn\"])[1]") 
public WebElement BuyNowForMeandMyfamily;

@FindBy(how = How.XPATH, using = "(//span[@class='benAmt mr-0'])[1]") 
public WebElement DataRolForMeandFamily;
		
@FindBy(how = How.XPATH, using = "//div[@id='headingTwo']") 
public WebElement IMPthings;

@FindBy(how = How.XPATH, using = "//*[@id='mePlans']/div[1]/div[2]/div[3]/div/div/button") 
public WebElement BuyNowForMesec;

@FindBy(how = How.XPATH, using = "//div[@class=' card-wrapper row plans-card border']/div/div/div[1]/div/p/span") 
public WebElement MRPplanpage;

@FindBy(how = How.XPATH, using = "(//p[@class='plan-coupon p-0 mb-0'])[9]") 
public WebElement NumberofConn;

@FindBy(how = How.XPATH, using = "(//div[@class=' d-flex edit'])[2]") 
public WebElement MBLnumberdetils;

@FindBy(how = How.XPATH, using = "//input[@class='mobile-number-validate col-12 form-control']") 
public WebElement MBLfield;

@FindBy(how = How.XPATH, using = "(//div[@class='forMe card-wrapper row plans-card border packshow'])[3]") 
public WebElement RedXplan;
		
@FindBy(how = How.XPATH, using = "//button[@id='buyredx']") 
public WebElement RedXplanbuynow;

@FindBy(how = How.XPATH, using = "(//div[@class='modal-content'])[3]") 
public WebElement RedXplanAlert;

@FindBy(how = How.XPATH, using = "//span[@class='close']") 
public WebElement CloseAlert;

@FindBy(how = How.XPATH, using = "//button[@id='switch']") 
public WebElement AgreeAndContinue;



@FindBy(how = How.XPATH, using = "//*[@id='confirmbtn']") 
public WebElement OTPButton;

@FindBy(how = How.XPATH, using = "//div[@class='edit goBackEdit']") 
public WebElement Goback;


@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-secondary buy-btn buybuttonforfamily btnpd miBlackbtn'])[1]") 
public WebElement MeandMyfamilyButton;

@FindBy(how = How.XPATH, using = "//div[@id='headingTwo']") 
public WebElement IMPthing;

@FindBy(how = How.XPATH, using = "(//a[@class='anchorknowmore miBlackLink'])[1]") 
public WebElement Knwmore;

@FindBy(how = How.XPATH, using = "//button[@class='btn btn-secondary btnknowmore miBlackbtn']") 
public WebElement Knwmorebuy;

@FindBy(how = How.XPATH, using = "//h2[@class='mb-0']") 
public WebElement IMPColl;

@FindBy(how = How.XPATH, using = "//h2[@class='mb-0']") 
public WebElement IMPExpand;

		
}

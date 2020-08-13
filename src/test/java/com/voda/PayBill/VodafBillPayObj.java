package com.voda.PayBill;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class VodafBillPayObj {
	
public VodafBillPayObj(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='mobile']")
	public WebElement MobileNo;
	
	@FindBy(how=How.XPATH, using="//*[@id='payamount']")
	public WebElement AmountBill;
	
	@FindBy(how=How.XPATH, using="//button[@class='btn payBtn px-4 miBlackbtn']")
	public WebElement Pay_Now;
	
	@FindBy(how=How.XPATH, using="//*[contains(@class, 'knowYourBill my-2')]")
	public WebElement FetchYBill;
	
	@FindBy(how=How.XPATH, using="//img[@src='/content/dam/vodafoneideadigital/homepage/header/vodafone-india.svg']")
	public WebElement Pay_BillHeader;
	
	@FindBy(how=How.XPATH, using="//button[@id='setupautopaybtnAnalytics']")
	public WebElement Setup_Now;
	
	@FindBy(how=How.XPATH, using="//button[@id='payinactivebtnAnalytics']")
	public WebElement GetNew_Connections;
	
	@FindBy(how=How.XPATH, using="//*[@id='planandpackslink']")
	public WebElement New_connection;
	
	@FindBy(how=How.XPATH, using="//div[@id='errorMsg']")
	public WebElement LesTha_Error;
	
	@FindBy(how=How.XPATH, using="//*[contains(@class, 'clearAll hide')]")
	public WebElement crosMark;
	
	@FindBy(how=How.XPATH, using="//*[contains(@class, 'fetchAmt btn mx-md-4')]")
	public WebElement FetchYourBill;

	@FindBy(how=How.XPATH, using="//*[contains(@class, 'btn payOtp')]")
	public WebElement proceedBtn;
	
	@FindBy(how=How.XPATH, using="//button[@class='btn payBtn px-4 miBlackbtn']")
	public WebElement PayButoon;
	
	@FindBy(how=How.XPATH, using="//*[contains(@class, 'pl-3 normalpay')]")
	public WebElement NetBanking;
	
	@FindBy(how=How.XPATH, using="//*[contains(@class, 'space')]")
	public WebElement LebelFieldBoder;
	
	@FindBy(how=How.XPATH, using= "//*[@id='errorMsg']")
	public WebElement LesThaError;
	
	@FindBy(how=How.XPATH, using= "//*[contains(@class, 'toasMsg')]")
	public WebElement ToastMasg;
	
	@FindBy(how=How.XPATH, using= "//*[contains(@class,'toasMsgBtn remove align-self-center')]")
	public WebElement Dismiss;
	
	@FindBy(how=How.XPATH, using= "//img[@class='clearAll hide']")
	public WebElement CrossMark;
	
	@FindBy(how=How.XPATH, using= "//*[@id='headingTwo']")
	public WebElement ImpThinstoNow;
	
	@FindBy(how=How.XPATH, using= "//*[contains(@class, 'mb-0 collapsed')]")
	public WebElement ImpThinstono;
	
	@FindBy(how=How.XPATH, using= "//input[@id='autoPayMsdn' or @name='autoPayMsdn']")
	public WebElement MyNumber;
	
	@FindBy(how=How.XPATH, using= "//*[@id='autoPostpaidPaySetup']/div/div/div[2]/div/div/div/div/div[3]/button")
	public WebElement SubmittBtn;
	
	@FindBy(how=How.XPATH, using= "//*[@id='autoPayMsdn' and @class ='form-control']")
	public WebElement MobilePopUpNo;
	
	@FindBy(how=How.XPATH, using= "//*[@class='invalid-feedback ml-3' and @style ='display: block;']")
	public WebElement PopUpError;
	
	@FindBy(how=How.XPATH, using= "//*[@class='mb-0 collapsed' and @data-toggle ='collapse']")
	public WebElement ImpThingArrow;
	
	@FindBy(how=How.XPATH, using= "//div[contains(@class='invalid-feedback ml-3']")
	public WebElement ErrorMasage;
	
	@FindBy(how=How.XPATH, using= "//*[contains(@class, 'close') and contains(@type ,'button')]")
	public WebElement CrossButton;
	
	@FindBy(how=How.XPATH, using= "//*[contains(@class, 'clearMsdn hide')]")
	public WebElement CrosMark1;
	
	@FindBy(how=How.XPATH, using= "//*[@class='btn autopaySubmitBtn']")
	public WebElement Submit1;

	@FindBy(how=How.XPATH, using= "//*[contains(@class, 'btn btn-light setupbtn px-4') and contains(@type ,'submit')]")
	public WebElement NewConnection;
	
	@FindBy(how=How.XPATH, using= "//*[contains(@id, 'inactivePayMsdn')]")
	public WebElement MyMobileNum;
	
	@FindBy(how=How.XPATH, using= "//*[@class='btn inactivPaySubmitBtn' and @type='button']")
	public WebElement submitBtn2;
	
	@FindBy(how=How.XPATH, using= "html/body/div[1]/div/div[2]/div/div[2]/div[3]/div/div[4]/div[1]/main/div/div[2]/div/div/div[2]/div/div/div/div[1]/button")
	public WebElement crossBtn1;
	
	@FindBy(how=How.XPATH, using= "//*[contains(@class, 'pl-0 resendOtp') and contains(@href,'javascript:void(0)')]")
	public WebElement ResendOTP;
	
	@FindBy(how=How.XPATH, using= "//*[contains(@class, 'pl-0 btn resendOtp miOrangeLink') and contains(@href,'javascript:void(0)')]")
	public WebElement Billpay_ResendOTP;
	
	@FindBy(how=How.XPATH, using= "//*[@id=\"otpBox\"]/div/div/div/div/div/div/div[3]/a")
	public WebElement Billpay_ResendOTP_disable;
	
	@FindBy(how=How.XPATH, using= "//*[@id='otpBox']/div/div/div/div/div/div/h4")
	public WebElement Count_ResendOTP_msg;
	
	
	@FindBy(how=How.XPATH, using= "//*[@id='otpBox']/div/div/div/div/div")
	public WebElement OTP_popup;
	
	@FindBy(how=How.XPATH, using= "//*[contains(@class, 'btn payOtp') and contains(@type,'button')]")
	public WebElement ConfirmBTn;
	
	@FindBy(how=How.XPATH, using= "//*[contains(@class, 'form-control otpContent mr-2 mr-md-4 invalidOTP') and contains(@id,'otp1')]")
	public WebElement OTPSections;
	
	@FindBy(how=How.XPATH, using= "//*[contains(@class, 'form-control otpContent mr-2 mr-md-4 validOTP') and contains(@id,'otp1')]")
	public WebElement OTPSections1;
	//input[@class=('form-control otpContent mr-2 mr-md-4 invalidOTP')][4]
	
	@FindBy(how=How.XPATH, using= "//div[contains(@class, 'otpSection row')]")
	public WebElement OTPField;
	
	@FindBy(how=How.XPATH, using= "//*[@id='setupautopaybtnAnalytics']")
	public WebElement NewConnection1;
	
	@FindBy(how=How.XPATH, using= "//*[contains(@id,'otpreattempterr') and contains(@class,'resendMsg vodaIdeaColor')]")
	public WebElement OTP_Error_MSG;
	
	@FindBy(how=How.XPATH, using= "//*[contains(@class, 'mb-0')]")
	public WebElement payment_page_mobileNo;
	
	@FindBy(how=How.XPATH, using= "//li[contains(@class, 'pl-3 normalpay') and contains(@rel ,'tab3')]")
	public WebElement net_banking;
	
	@FindBy(how=How.XPATH, using= "//*[contains(@class, \"active paybycreditcard\") and contains(@href ,\" \")]")
	public WebElement Pay_by_Credit;
	
	@FindBy(how=How.XPATH, using= "//*[contains(@class, \"primary-link show-popup\") and contains(@href ,\"#\")]")
	public WebElement Cancel_payment;
	
	@FindBy(how=How.XPATH, using= "//*[contains(@class, \"firstContent\")]")
	public WebElement Voda_payment;
	
	@FindBy(how=How.XPATH, using= "html/body/div[1]/article/div/div/div[2]/div[1]/div/div[4]/div/form[1]/div[3]/a[2]")
	public WebElement Cancel1_payment;
	
	@FindBy(how=How.XPATH, using= "//button[@class='btn tryAgainbtn miOrangebtn']")
	public WebElement Try_Again;
	
	@FindBy(how=How.XPATH, using= "//*[contains(@id, \"selectBank\") and contains(@class ,\"selectedvalue\")]")
	public WebElement Select_bank;
	
   @FindBy(how=How.XPATH, using= "html/body/div/article/div/div/div[2]/div[1]/div/div[4]/div/form[1]/div[2]/div[1]/div/select/option[2]")
   public WebElement Dummy_Bank;
   
   @FindBy(how=How.XPATH, using= "//*[contains(@id, \"makePayment_NB\") and contains(@class ,\"BillButton active\")]")
	public WebElement Pay_surely;
   
   @FindBy(how=How.XPATH, using= "//*[@id=\"txtPassword\"]")
	public WebElement Transaction_password;
   
   @FindBy(how=How.XPATH, using= "//*[@id=\"cmdSubmit\"]")
	public WebElement Submitt_BTN;
   
   @FindBy(how=How.XPATH, using= "//*[@id=\"payamount\"]")
	public WebElement amount_sec;
   
   @FindBy(how=How.XPATH, using= "//*[@id=\"headingTwo\"]/h5")
  	public WebElement impcllapse;
   
   @FindBy(how=How.XPATH, using= "/html/body/div[1]/article/div/h1/span")
 	public WebElement OopsPage;
   
   @FindBy(how=How.XPATH, using= "//*[contains(@class, \"planRental selPlan\")]")
	public WebElement MobileFiels;
   @FindBy(how=How.XPATH, using= "//*[contains(@class, \"WebRupee\")]/span")
	public WebElement AmountFields;
   @FindBy(how=How.XPATH, using= "//*[contains(@class, \"selPlan tableHeadDiv\")]")
	public WebElement TransactionId;
   
   @FindBy(how=How.XPATH, using= "//li[@class='planRental selPlan'][1]")
	public WebElement AccountIds;
   @FindBy(how=How.XPATH, using= "/html/body/div[1]/article/div/section/div[1]/div/div[1]/div/div/div/div/ul[6]/li[1]")
	public WebElement Date_Time;
   
   @FindBy(how=How.XPATH, using= "//*[@id='submitJuspayPDFForm']/li/a")
	public WebElement Download;
	
   @FindBy(how=How.XPATH, using= "//div[@id='150']")
  	public WebElement Select_wallet;
   
   @FindBy(how=How.XPATH, using= "//div[@id='241']")
 	public WebElement Ptm_PaySurely;
   
   @FindBy(how=How.XPATH, using= "/html/body/div[2]/div/div[3]/div/div[2]/div[3]/div/div/div/div[2]/div/div/div[3]/div/div/div/div/div/div[1]/div[2]/div/div/div/div[2]/div[2]")
	public WebElement Proceed_Pay; 
   
   @FindBy(how=How.XPATH, using= "//button[@class='_3sO3']")
	public WebElement Go_Back;
   
   @FindBy(how=How.XPATH, using= "//*[@class='fl']")
	public WebElement Go_Back2;
   
   @FindBy(how=How.XPATH, using= "//*[@id='app']/main/header/section/div/div/span")
	public WebElement Go_Back1;
   
   @FindBy(how=How.XPATH, using= "//div[@class='rechargetxt mb-3']")
	public WebElement OOps_Page;
   
   @FindBy(how=How.XPATH, using= "//div[@class='rechargetxt mb-3']")
	public WebElement Payment_Failure;
   @FindBy(how=How.XPATH, using= "//*[@id=\"categories\"]/div/div/div[1]/p[1]")
	public WebElement mobile_Failure;
   @FindBy(how=How.XPATH, using= "//*[@id=\"categories\"]/div/div/div[3]/p[1]")
  	public WebElement transaction_Failure;
   @FindBy(how=How.XPATH, using= "//*[@id=\"categories\"]/div/div/div[4]/p[1]")
 	public WebElement acountid_Failure;
   @FindBy(how=How.XPATH, using= "//*[@id='categories']/div/div/div[2]/p[1]")
	public WebElement dateTime_Failure;
   @FindBy(how=How.XPATH, using= "//a[contains(@id,'downloadLinkFailureAnalytics') and @href='#']")
	public WebElement download_Failure;
   @FindBy(how=How.XPATH, using= "//p[@class='request mb-3 m-md-0']")
  	public WebElement resoion_Failure;
   @FindBy(how=How.XPATH, using= "//button[@class='btn btn-outline-dark btnpadding tryAgainbtn miOrangebtn']")
 	public WebElement tryAgain_Failure;
   @FindBy(how=How.XPATH, using= "//a[@class='float-right my-2 needhelplink miOrangeLink']")
	public WebElement needHelp_Failure;
   @FindBy(how=How.XPATH, using= "//button[@class='btn btn-light setupbtn px-4 setuppay miOrangebtn']")
  	public WebElement setUpNow_Failure;
   @FindBy(how=How.XPATH, using= "//button[@class='btn btn-light setupbtn px-4 redclick miOrangebtn']")
 	public WebElement redTogether_Failure;
   
   @FindBy(how=How.XPATH, using= "//div[@class='appBannerComp ']")
	public WebElement Get_MyVodafone_App1;
   
   @FindBy(how=How.XPATH, using= "//div[@class='appBannerComp vodafoneblackColour']")
	public WebElement Get_MyVodafone_App_ORC;
   
   @FindBy(how=How.XPATH, using= "//ol[@class='breadcrumb']")
  	public WebElement Breadcrumb;
   
   @FindBy(how=How.XPATH, using= "//ol[@class='breadcrumb']/li[1]")
 	public WebElement Breadcrumb_home;
   
   
   
}


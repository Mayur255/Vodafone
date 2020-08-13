@VodaFone_HomePage

Feature: Vodafone Home Page featurefile

#@Voda_HomePage
@HomePage_Chrome

Scenario: Voda fone Homepage

Given Load Vodafone Site >> Home Page should display
Then Verify Home Page >> Header should display

Then Verify Home Page >> Footer should display
Then Verify Home Page >> Below Header -  Banner should display
Then Verify Home Page >> Mobile number field should display
Then Verify Home Page >> Arrow (>) button should be disabled as number is not provided
#Then Enter mobile number less than ten digits - Error message should display in Red1
#Then Enter mobile number less than ten digits - Enter Mobile Number label and field border should display in Red
#Then Enter Postpaid Number of Idea - error Message should display in red color
#Then Enter NonIdea/NonVF number- error Message should display in red color
Then Try to enter Mobile Number starting with 0 to 4 >> It should not allow1
Then Enter alphabets/Special characters in Mobile Number field- it should not allow1
#Then Enter Idea Prepaid Number >> error Message should display red color
#Then Enter COCP number >> Arrow (>) button should be enabled


#Then Enter VF Postpaid Number >> Arrow (>) button should be enabled
#Then Load Home Page >> Mobile Number should be autopopulated with VF Postpaid Number entered earlier
#Then Enter VF Postpaid Number >> Arrow (>) button should be black
#Then Click arrow (>)Billpay page should display
Then Click on Pay Bill button
Then Enter VF Postpaid Number >> Arrow (>) button should be black
Then Verify Billpay page >> Mobile number should be autopopulated with number entered on Homepage
Then Verify Billpay page >> Amount field should be enabled
Then Verify Billpay page >> Fetch your bill link should be enabled

Then Click on Recharge button
Then Enter VF Prepaid Number >> Arrow (>) button should be enabled
#Then Load Home Page >> Mobile Number should be autopopulated with VF Prepaid Number entered earlier	

#Then Enter VF Prepaid Number >> Arrow (>) button should be black
#Then Click arrow (>)Recharge page should display

#Then Verify Recharge page >> Mobile number should be autopopulated with number entered on Homepage
#Then Verify Recharge page >> Amount field should be enabled
#Then Verify Recharge page >> Fetch last recharge link should be enabled
Then Verify Recharge page >> Pack should display for respective number
Then Verify Home Page >> Quicklinks should display below Mobile number field


Then Verify Home Page >> Banners should display below Quicklinks
Then Verify Home Page >> Loaded Benefits on VodafoneIdea section should display
Then Verify Home Page >> Trending Now should display
Then Verify Top banner pixel.
Then Verify Top second banner pixel.
Then Verify Top thrid banner pixel.
Then Verify Top fourth banner pixel.
Then Verify Top fifth banner pixel.

Then Verify Buy postpaid sim icon pixel.
Then Verify Buy prepaid sim icon pixel.
Then Verify IR icon pixel.
Then Verify Vodafone play icon pixel.
Then Verify Help and support_icon pixel.

Then Verify four banner icon one pixel.
Then Verify four banner icon two pixel.
Then Verify four banner icon three pixel.
Then Verify four banner icon four pixel.

#Then Verify Loaded benefits icon one pixel.
#Then Verify Loaded benefits icon two pixel.
#Then Verify Loaded benefits icon three pixel.
#Then Verify Loaded benefits icon four pixel.
#Then Verify Loaded benefits icon five pixel.
#Then Verify Loaded benefits icon_six pixel.

Then Verify Vodafone exclusive banner image one pixel. 
Then Verify Vodafone exclusive banner image two pixel. 
Then Verify Vodafone exclusive banner image three pixel. 
Then Verify Vodafone exclusive banner image four pixel. 
Then Verify Vodafone exclusive banner image five pixel. 
#Then Verify Vodafone exclusive banner image six pixel. 
Then Verify the displayed Meta description, Meta viewport, Meta template


@Vodafone_ORC_Chrome

Scenario: VFIdea_ORC

Given Recharge page should open properly
Then Verify mobilenumber field is enabled on page load
Then Verify Amount field should not allow to enter data on page load
	#Then Verify on page Fetch last recharge hyper link should be disabled
Then Verify text Lets Do a Recharge should display on page load
Then Verify banner should display on page load
Then Enter mobile number less than ten digits - Error message should display in Red
Then Mobile Number label and field border should display in Red
#Then Enter Postpaid Number of Idea - Error message should display
#Then Mobile Number label and field border should display in Red
#Then Enter Postpaid Number of VF- Error message should display 
#Then Mobile Number label and field border should display in Red
#Then Enter NonIdea/NonVF number- Error Message should display
#Then Mobile Number label and field border should display in Red
#
#
#Then Enter Idea Prepaid Number >> Error Message should display
#Then Mobile Number label and field border should display in Red
Then Enter VF Prepaid Number >> Amount field should be enabled
Then Enter VF Prepaid Number >>  Packs categories section should display
Then Using Cross icon remove Mobile Number >> Amount, Fetch last recharge should be disabled
Then Using Cross icon remove Mobile Number >> Packs section should not display



Then Go to Recharge page >>Enter the Vodafone prepaidpaid number>> Enter amount in integer - It should allow only Five digits
Then On page load >> Important Things to Know should display collapsed
Then Click Arrow for Important Things to Know >> Page should autoscroll
Then Verify page >> Focus should go on Imp Things to know section
Then Verify page >> Imp Things to Know section should expand
Then Click Arrow for Important Things to Know >> Page should collapse

Then Enter VF Prepaid Number >> Enter amount = 1 >> Packs with Mrp starting as 1 should display

Then Enter VF Prepaid Number >> Enter amount = 1 >> Pack categories should not display

Then Now enter amount = 12 >> Packs with Mrp starting as 12 should display

Then Enter amount = 99999 >> Error message should display in Red

Then Enter amount = 99999 >> Enter Recharge Amount label and field border should display in Red

Then Enter amount = 99999 >> Packs categories section should display

Then Verify Packs categories >> First category should be For You
Then Enter number >> Focus should be on For You category
Then Enter number >> Select Unlimited >> Packs details should display
Then Verify Pack details >> Pack Mrp should display
Then Verify Pack details >> Validity should display
Then If Talktime details available >> It should display for Unlimited category pack
Then If Data details available >> It should display for Unlimited category pack
				#Then SMS Details should not display in pack details section
				#Then If Nontelco benefits are available then max two should display in pack details section
Then Select Internet category >> Only Data and Validity fields should display
Then Select Talktime category >> Only Talktime and Validity fields should display
Then For Recommended Category >> Know More link should not display for any pack
Then Click Know More for any pack >> Popup should open
Then Click Esc >> Popup should close
Then Click Know More for any pack >> Popup should open
Then Click Cross on popup >> Popup should close
Then Click Know More for any pack >> Popup should open

Then For Unlimited Category >> Click Know More for pack for ex: 35 >> Talktime, Data and SMS values should display
				#Then If Nontelco benefits are available then all benefits should display in the popup
				
Then Click Esc >> Popup should close
				#Then Load More link should not display for any pack category

Then Enter VF Prepaid Number - Click Buy Pack for any Mrp >> VF Payment Gateway screen should display
Then Select Wallet >> Click Pay button for Paytm >> Paytm page should display
Then Click on Go Back >> Oops page should display
Then Verify Oops page >> Oops page with payment failure text should display
Then Verify Failure Page >> Mobile Number field should display provided VF Number
Then Verify Failure Page >> Amount field should Not display
Then Verify Failure Page >> Transaction Id should display
#Then Verify Failure Page >> Account Id should display
Then Verify Failure Page >> Date & Time should display
Then Verify Failure Page >> Download Receipt link should display
Then Verify Failure Page >> Reason for Failure section should display
Then Verify Failure Page >> Try Again button should display
Then Verify Failure Page >> Need Help link in orange color should display
Then Verify Failure Page >> SetUp Auto Pay section should display
Then Verify Failure Page >> Red Together section should display
Then Verify Failure Page >> Imp Things to know should display
#Then Click Try Again >> Recharge landing page should display

#Then Enter OCRM VF Prepaid Number - Click Buy Pack for any Mrp >> VF Payment Gateway screen should display
#Then Select Wallet >> Click Pay button for Paytm >> Paytm page should display
#Then Click on Go Back >> Oops page should display
#Then Verify Oops page >> Oops page with payment failure text should display
#Then Verify Failure Page >> Mobile Number field should display provided VF Number
#Then Verify Failure Page >> Amount field should Not display
#Then Verify Failure Page >> Transaction Id should display
#Then Verify Failure Page >> Account Id should display
#Then Verify Failure Page >> Date & Time should display
#Then Verify Failure Page >> Download Receipt link should display
#Then Verify Failure Page >> Reason for Failure section should display
#Then Verify Failure Page >> Try Again button should display
#Then Verify Failure Page >> Need Help link in orange color should display
#Then Verify Failure Page >> SetUp Auto Pay section should display
#Then Verify Failure Page >> Red Together section should display
#Then Verify Failure Page >> Imp Things to know should display
#Then Click Try Again >> Recharge landing page should display
#
#Then Enter SCRM VF Prepaid Number - Click Buy Pack for any Mrp >> VF Payment Gateway screen should display
#Then Select Wallet >> Click Pay button for Paytm >> Paytm page should display
#Then Click on Go Back >> Oops page should display
#Then Verify Oops page >> Oops page with payment failure text should display
#Then Verify Failure Page >> Mobile Number field should display provided VF Number
#Then Verify Failure Page >> Amount field should Not display
#Then Verify Failure Page >> Transaction Id should display
#Then Verify Failure Page >> Account Id should display
#Then Verify Failure Page >> Date & Time should display
#Then Verify Failure Page >> Download Receipt link should display
#Then Verify Failure Page >> Reason for Failure section should display
#Then Verify Failure Page >> Try Again button should display
#Then Verify Failure Page >> Need Help link in orange color should display
#Then Verify Failure Page >> SetUp Auto Pay section should display
#Then Verify Failure Page >> Red Together section should display
#Then Verify Failure Page >> Imp Things to know should display
#Then Click Try Again >> Recharge landing page should display

@Voda_PayBill_Chrome

Scenario: Voda fone BillPay

Given Pay Bill page should open properly in Firefox browser

Then Verify mobilenumber field is enabled on page load
Then Verify Amount field should not allow to enter data on page load2
Then Verify Pay Button should not active on page load
Then Verify Breadcrumb should be displayed
Then Verify on page Fetch your bill hyper link should be disabled 
Then Verify the displayed Meta description, Meta viewport, Meta template
Then Verify text PayBillsOnline for your postpaid number should display on page load
Then Verify - Setup AutoPay section - SetUp Now button should display

Then Verify - Inactive Number section - Pay Now button should display

Then On Page load - when valid Postpaid Number is not provided >>New Connection and Postpaid Packs links should display in orange

#Then Enter mobile number less than ten digits - Error message should display in Red2
#Then Enter mobile number less than ten digits - Enter Mobile Number label and field border should display in Red2
#Then Enter Prepaid Number of Idea - Error message should display in red color
#Then Enter Prepaid Number of Idea - Enter Mobile Number label and field border should display in Red
#Then Enter Prepaid Number of VF - Enter Mobile Number label and field border should display in Red
#Then Enter NonIdea/NonVF number- Error Message should display in red color
#Then Try to enter Mobile Number starting with 0 to 4 >> It should not allow2
#Then Enter alphabets/Special characters in Mobile Number field- it should not allow2
#Then Enter VF COCP Number >> Amount field should be enabled
#Then Enter VF COCP Number >>  Fetch your bill link should be enabled
Then Enter VF Postpaid Number >> Amount field should be enabled
Then Enter VF Postpaid Number >>  Fetch your bill link should be enabled
#Then Click Home in breadcrumb >> Home Page should display and number should be autopopulated
Then Enter VF Postpaid Number >>  New Connection and Postpaid Packs links should NOT display


Then Enter amount >> Pay Now button should be enabled
Then Using Cross icon remove Mobile Number >> Amount, Fetch Your Bill and Pay Now button should be disabled
Then Go to Bill Pay page >>Enter the Vodafone postpaid number>> Enter amount in integer - It should allow only 10 digits
Then Go to Bill Pay page >>Enter the Vodafone postpaid number>> Enter amount in decimals - It should allow only 13 digits including decimal point
Then On page load >> Imortant Things to Know should display collapsed
Then Click Arrow for Important Things to Know >> Page should autoscroll
Then Verify page >> Focus should go on Imp Things to know section
Then Verify page >> Imp Things to Know section should expand
Then Click Arrow for Important Things to Know >> Page should collapse

Then Enter VF Postpaid Number and click Fetch Your Bill link >> Fetch Bill Amount popup should open
Then Click on Resend link>> check Four resent count should be displayed
Then Enter invalid OTP twice and Click Confirm >> Proper error message should display in Red
Then Enter invalid OTP thrice and Click Confirm >> Proper error message should display in Red
Then Enter invalid OTP fourth time and Click Confirm >> Proper error message should display in Red


Then Click on Resend link>> check Three resent count should be displayed
Then Enter invalid OTP twice and Click Confirm >> Proper error message should display in Red
Then Enter invalid OTP thrice and Click Confirm >> Proper error message should display in Red
Then Enter invalid OTP fourth time and Click Confirm >> Proper error message should display in Red

Then Click on Resend link>> check Two resent count should be displayed
Then Enter invalid OTP twice and Click Confirm >> Proper error message should display in Red
Then Enter invalid OTP thrice and Click Confirm >> Proper error message should display in Red
Then Enter invalid OTP fourth time and Click Confirm >> Proper error message should display in Red

Then Click on Resend link>> check One resent count should be displayed
Then Enter invalid OTP twice and Click Confirm >> Proper error message should display in Red
Then Enter invalid OTP thrice and Click Confirm >> Proper error message should display in Red
Then Enter invalid OTP fourth time and Click Confirm >> Proper error message should display in Red

#Then Click on Resend link>> check resent count should be displayed
Then Reset link should be disable


Then Enter VF Postpaid Number n Amount and click Pay >> VF Payment Gateway screen should display
Then Select Wallet >> Click Pay button for Paytm >> Paytm page should display1
Then Click on Go Back >> Oops page should display1
Then Verify Oops page >> Oops page with payment failure text should display1
Then Verify Failure Page >> Mobile Number field should display provided VF Number
Then Verify Failure Page >> Amount field should Not display
Then Verify Failure Page >> Transaction Id should display
Then Verify Failure Page >> Account Id should display
Then Verify Failure Page >> Date & Time should display
Then Verify Failure Page >> Download Receipt link should display1
Then Verify Failure Page >> Reason for Failure section should display1
Then Verify Failure Page >> Try Again button should display1
Then Verify Failure Page >> Need Help link in orange color should display1
Then Verify Failure Page >> SetUp Auto Pay section should display1
Then Verify Failure Page >> Red Together section should display1
Then Verify Failure Page >> Get MyVodafone App banner should display
Then Verify Failure Page >> Click on Download Receipt link>> Download PDF of the receipt in the predefined format 
Then Enter Idea Postpaid Migrated number - Enter Amount and click Pay >> VF Payment Gateway screen should display
Then Select Wallet >> Click Pay button for Paytm >> Paytm page should display1
Then Click on Go Back >> Oops page should display1
Then Verify Oops page >> Oops page with payment failure text should display1
Then Verify Failure Page >> Mobile Number field should display provided VF Number



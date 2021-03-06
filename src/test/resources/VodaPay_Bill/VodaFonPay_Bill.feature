@VodaFPayBill
Feature: VodafoneBillPay 

@Voda_IdeaPayBill

Scenario: Voda fone BillPay

Given Pay Bill page should open properly

Then Verify mobilenumber field is enabled on page load
Then Verify Amount field should not allow to enter data on page load
Then Verify Pay Button should not active on page load
Then Verify Breadcrumb should be displayed
Then Verify on page Fetch your bill hyper link should be disabled 
Then Verify the displayed Meta description, Meta viewport, Meta template
Then Verify text PayBillsOnline for your postpaid number should display on page load
Then Verify - Setup AutoPay section - SetUp Now button should display

Then Verify - Inactive Number section - Pay Now button should display

Then On Page load - when valid Postpaid Number is not provided >>New Connection and Postpaid Packs links should display in orange

Then Enter mobile number less than ten digits - Error message should display in Red
Then Enter mobile number less than ten digits - Enter Mobile Number label and field border should display in Red
Then Enter Prepaid Number of Idea - Error message should display in red color
Then Enter Prepaid Number of Idea - Enter Mobile Number label and field border should display in Red
Then Enter Prepaid Number of VF - Enter Mobile Number label and field border should display in Red
Then Enter NonIdea/NonVF number- Error Message should display in red color
Then Try to enter Mobile Number starting with 0 to 4 >> It should not allow
Then Enter alphabets/Special characters in Mobile Number field- it should not allow
Then Enter VF COCP Number >> Amount field should be enabled
Then Enter VF COCP Number >>  Fetch your bill link should be enabled
Then Enter VF Postpaid Number >> Amount field should be enabled
Then Enter VF Postpaid Number >>  Fetch your bill link should be enabled
Then Click Home in breadcrumb >> Home Page should display and number should be autopopulated
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
Then Enter 4 digits in OTP field >> Confirm button should be enabled
#Then Enter invalid OTP once and Click Confirm >> Proper error message should display in Red
#Then Enter invalid OTP once and Click Confirm >> OTP fields border should be Red and image in Red should display in from of field
Then Enter invalid OTP twice and Click Confirm >> Proper error message should display in Red
#Then Enter invalid OTP twice and Click Confirm >> OTP fields border should be Red and image in Red should display in from of field
Then Enter invalid OTP thrice and Click Confirm >> Proper error message should display in Red
#Then Enter invalid OTP thrice and Click Confirm >> OTP fields border should be Red and image in Red should display in from of field
Then Enter invalid OTP fourth time and Click Confirm >> Proper error message should display in Red
#Then Enter invalid OTP fourth time and Click Confirm >> OTP fields border should be Red and image in Red should display in from of field
#Then Enter invalid OTP fourth time and Click Confirm >> Popup should close automatically and focus should go on landing page
#Then Click Esc button of keyboard >> Popup should be close
Then Enter VF Postpaid Number n Amount and click Pay >> VF Payment Gateway screen should display
Then Select Wallet >> Click Pay button for Paytm >> Paytm page should display
Then Click on Go Back >> Oops page should display
Then Verify Oops page >> Oops page with payment failure text should display
Then Verify Failure Page >> Mobile Number field should display provided VF Number
Then Verify Failure Page >> Amount field should Not display
Then Verify Failure Page >> Transaction Id should display
Then Verify Failure Page >> Account Id should display
Then Verify Failure Page >> Date & Time should display
Then Verify Failure Page >> Download Receipt link should display
Then Verify Failure Page >> Reason for Failure section should display
Then Verify Failure Page >> Try Again button should display
Then Verify Failure Page >> Need Help link in orange color should display
Then Verify Failure Page >> SetUp Auto Pay section should display
Then Verify Failure Page >> Red Together section should display
Then Verify Failure Page >> Get MyVodafone App banner should display
Then Verify Failure Page >> Click on Download Receipt link>> Download PDF of the receipt in the predefined format 


@Voda_PayBill_firefox

Scenario: Voda fone BillPay

Given Pay Bill page should open properly in Firefox browser

Then Verify mobilenumber field is enabled on page load
Then Verify Amount field should not allow to enter data on page load
Then Verify Pay Button should not active on page load
Then Verify Breadcrumb should be displayed
Then Verify on page Fetch your bill hyper link should be disabled 
Then Verify the displayed Meta description, Meta viewport, Meta template
Then Verify text PayBillsOnline for your postpaid number should display on page load
Then Verify - Setup AutoPay section - SetUp Now button should display

Then Verify - Inactive Number section - Pay Now button should display

Then On Page load - when valid Postpaid Number is not provided >>New Connection and Postpaid Packs links should display in orange

Then Enter mobile number less than ten digits - Error message should display in Red
Then Enter mobile number less than ten digits - Enter Mobile Number label and field border should display in Red
Then Enter Prepaid Number of Idea - Error message should display in red color
Then Enter Prepaid Number of Idea - Enter Mobile Number label and field border should display in Red
Then Enter Prepaid Number of VF - Enter Mobile Number label and field border should display in Red
Then Enter NonIdea/NonVF number- Error Message should display in red color
Then Try to enter Mobile Number starting with 0 to 4 >> It should not allow
Then Enter alphabets/Special characters in Mobile Number field- it should not allow
Then Enter VF COCP Number >> Amount field should be enabled
Then Enter VF COCP Number >>  Fetch your bill link should be enabled
Then Enter VF Postpaid Number >> Amount field should be enabled
Then Enter VF Postpaid Number >>  Fetch your bill link should be enabled
Then Click Home in breadcrumb >> Home Page should display and number should be autopopulated
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
#
#Then Enter VF Postpaid Number and click Fetch Your Bill link >> Fetch Bill Amount popup should open
#Then Enter 4 digits in OTP field >> Confirm button should be enabled
#Then Enter invalid OTP once and Click Confirm >> Proper error message should display in Red
#
#Then Enter invalid OTP twice and Click Confirm >> Proper error message should display in Red
#
#Then Enter invalid OTP thrice and Click Confirm >> Proper error message should display in Red
#
#Then Enter invalid OTP fourth time and Click Confirm >> Proper error message should display in Red

Then Enter VF Postpaid Number n Amount and click Pay >> VF Payment Gateway screen should display
Then Select Wallet >> Click Pay button for Paytm >> Paytm page should display
Then Click on Go Back >> Oops page should display
Then Verify Oops page >> Oops page with payment failure text should display
Then Verify Failure Page >> Mobile Number field should display provided VF Number
Then Verify Failure Page >> Amount field should Not display
Then Verify Failure Page >> Transaction Id should display
Then Verify Failure Page >> Account Id should display
Then Verify Failure Page >> Date & Time should display
Then Verify Failure Page >> Download Receipt link should display
Then Verify Failure Page >> Reason for Failure section should display
Then Verify Failure Page >> Try Again button should display
Then Verify Failure Page >> Need Help link in orange color should display
Then Verify Failure Page >> SetUp Auto Pay section should display
Then Verify Failure Page >> Red Together section should display
Then Verify Failure Page >> Get MyVodafone App banner should display
Then Verify Failure Page >> Click on Download Receipt link>> Download PDF of the receipt in the predefined format 


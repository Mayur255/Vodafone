@Check_PostpaidPlans


Feature: PostPaid_Plans 


@Plans_Automation

Scenario Outline: PlansAutomation

Given Postpaid Plan page should open properly
Then Verify Page >> For Me & My Family section should display 
Then Verify Page >> For Me section should display
Then Verify For Me & My Family Section >> Max 3 plans should display
Then Verify For Me & My Family Section >> Plan Mrp should display
Then Verify For Me & My Family Section >> No of connection count should display
Then Verify For Me & My Family Section >> Data rollover details should display
Then Verify For Me & My Family Section >> If Nontelco benefits are available then max four should display in Plans section
Then Verify For Me & My Family Section >> If Nontelco benefits are Not available then respective section should display blank
Then Verify For Me & My Family Section >> Know More link should display for all plans
Then Verify For Me & My Family Section >> Buy Plan should display for all plans
Then Verify For Me Section >> Max 3 plans should display
Then Verify For Me Section >> Plan Mrp should display
Then Verify For Me Section >> No of connection count should display - It should be always 1
Then Verify For Me Section >> Data rollover details should display
Then Verify For Me Section >> If Nontelco benefits are available then max four should display in Plans section
Then Verify For Me Section >> If Nontelco benefits are Not available then respective section should display blank
Then Verify For Me Section >> Know More link should display for all plans
Then Verify For Me Section >> Buy Plan should display for all plans
Then Postpaid Plan Verify For Me Section >> One RedX plan should display Plan Card
#Then Click Buy Plan for RedX Plan >> Alert popup should display
#Then Click X of Alert >> Plans landing page should display
#Then Click Agree & Continue button >> Selected Plan page should display
Then Verify Page >> Imp Things to Know Section should display
Then Click Buy Plan for Plan from Me Section >> Selected Plan page should display
Then Verify Selected Plan page >> Edit should display next to Selected Plan	Buy Plan
Then Click Buy Plan >> Verify Selected Plan page >> Plan Mrp displayed on landing page for respective plan should display
Then Verify Selected Plan page >> For 1 Connection should display below Mrp	Buy Plan
Then Verify Selected Plan page >> if non telco benefits are available then max 4 should display
Then Verify Selected Plan page >> Below Mobile Number Details section should display	Buy Plan
Then Verify Mobile Number details section >> Focus should be on Mobile Number field	Buy Plan
Then Verify Mobile Number details section >> Get OTP should be disabled
Then Verify Page >> Imp Things to Know Section should display
Then Click Buy Plan for Plan from Me & My Family Section >> Page should redirect to Buy New Postpaid Connection page	Buy Plan
Then Click Know More for Plan from Me & My Family section - Click Buy Plan >> Page should redirect to Buy New Postpaid Connection page
Then On page load >> Imortant Things to Know should display collapsed
Then Click Arrow for Important Things to Know >> Page should autoscroll
Then Verify page >> Focus should go on Imp Things to know section
Then Verify page >> Imp Things to Know section should expand	Imp Things To Know
Then Click Arrow for Important Things to Know >> Page should collapse
Then Click Buy Plan for Plan from Me Section >> Selected Plan page should display


Then Enter mobile number less than ten digits - Error message should display in Red
Then Enter mobile number less than ten digits - Enter Mobile Number label and field border should display in Red
Then Enter Idea Postpaid number - Error message should display in Red
Then Enter Idea Postpaid number - Enter Mobile Number label and field border should display in Red
Then Enter NonIdea/NonVF Number - Error message should display in Red
Then Enter NonIdea/NonVF Number - Enter Mobile Number label and field border should display in Red
Then Enter VF Prepaid number - Error message should display in Red
Then Enter VF Prepaid number - Enter Mobile Number label and field border should display in Red
Then Enter Idea Prepaid number - Error message should display in Red
Then Enter Idea Prepaid number - Enter Mobile Number label and field border should display in Red
Then Try to enter Mobile Number starting with 0 to 4 >> It should not allow
Then Enter alphabets/Special characters in Mobile Number field- it should not allow
Then Enter VF Postpaid Number >> Get OTP should be enabled

Then Click Get OTP for VF Postpaid Number >> Plan Activation popup should open
Then Click on Resend link>> check Four resent count should be displayed
#Then Enter 4 digits in OTP field >> Confirm button should be enabled
#Then Enter invalid OTP once and Click Confirm >> Proper error message should display in Red
#Then Enter invalid OTP once and Click Confirm >> OTP fields border should be Red and image in Red should display in from of field
Then Enter invalid OTP twice and Click Confirm >> Proper error message should display in Red
#Then Enter invalid OTP twice and Click Confirm >> OTP fields border should be Red and image in Red should display in from of field
Then Enter invalid OTP thrice and Click Confirm >> Proper error message should display in Red
#Then Enter invalid OTP thrice and Click Confirm >> OTP fields border should be Red and image in Red should display in from of field
Then Enter invalid OTP fourth time and Click Confirm >> Proper error message should display in Red
#Then Enter invalid OTP fourth time and Click Confirm >> OTP fields border should be Red and image in Red should display in from of field
#Then Enter invalid OTP fourth time and Click Confirm >> Popup should close automatically and focus should go on landing page

Then Click on Resend link>> check Three resent count should be displayed
#Then Enter 4 digits in OTP field >> Confirm button should be enabled
#Then Enter invalid OTP once and Click Confirm >> Proper error message should display in Red
#Then Enter invalid OTP once and Click Confirm >> OTP fields border should be Red and image in Red should display in from of field
Then Enter invalid OTP twice and Click Confirm >> Proper error message should display in Red
#Then Enter invalid OTP twice and Click Confirm >> OTP fields border should be Red and image in Red should display in from of field
Then Enter invalid OTP thrice and Click Confirm >> Proper error message should display in Red
#Then Enter invalid OTP thrice and Click Confirm >> OTP fields border should be Red and image in Red should display in from of field
Then Enter invalid OTP fourth time and Click Confirm >> Proper error message should display in Red

Then Click on Resend link>> check Two resent count should be displayed
#Then Enter 4 digits in OTP field >> Confirm button should be enabled
#Then Enter invalid OTP once and Click Confirm >> Proper error message should display in Red
#Then Enter invalid OTP once and Click Confirm >> OTP fields border should be Red and image in Red should display in from of field
Then Enter invalid OTP twice and Click Confirm >> Proper error message should display in Red
#Then Enter invalid OTP twice and Click Confirm >> OTP fields border should be Red and image in Red should display in from of field
Then Enter invalid OTP thrice and Click Confirm >> Proper error message should display in Red
#Then Enter invalid OTP thrice and Click Confirm >> OTP fields border should be Red and image in Red should display in from of field
Then Enter invalid OTP fourth time and Click Confirm >> Proper error message should display in Red

Then Click on Resend link>> check One resent count should be displayed
#Then Enter 4 digits in OTP field >> Confirm button should be enabled
#Then Enter invalid OTP once and Click Confirm >> Proper error message should display in Red
#Then Enter invalid OTP once and Click Confirm >> OTP fields border should be Red and image in Red should display in from of field
Then Enter invalid OTP twice and Click Confirm >> Proper error message should display in Red
#Then Enter invalid OTP twice and Click Confirm >> OTP fields border should be Red and image in Red should display in from of field
Then Enter invalid OTP thrice and Click Confirm >> Proper error message should display in Red
#Then Enter invalid OTP thrice and Click Confirm >> OTP fields border should be Red and image in Red should display in from of field
Then Enter invalid OTP fourth time and Click Confirm >> Proper error message should display in Red

Then Click on Resend link>> check resent count should be displayed
Then Reset link should be disable


Examples: 
    
      | Mobile Number | Amount |
      |   4000004689  |  50.00 |
    
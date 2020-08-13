@VodafoneIdeaorc
Feature: VodafoneBillPay 

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
Then Enter Postpaid Number of Idea - Error message should display
Then Mobile Number label and field border should display in Red
#Then Click Dismiss >> Toast message should vanish
Then Enter Postpaid Number of VF- Error message should display 
Then Mobile Number label and field border should display in Red
#Then Click Dismiss >> Toast message should vanish
Then Enter NonIdea/NonVF number- Error Message should display
Then Mobile Number label and field border should display in Red
#Then Click Dismiss >> Toast message should vanish

Then Enter Idea Prepaid Number >> Error Message should display
Then Mobile Number label and field border should display in Red
#Then Click Dismiss >> Toast message should vanish
Then Enter VF Prepaid Number >> Amount field should be enabled
	#Then Enter VF Prepaid Number >>  Fetch last recharge link should be enabled
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
Then Click Try Again >> Recharge landing page should display


@Vodafone_ORC_Firefox

Scenario: VFIdea_ORC

Given Recharge page should open properly in firefox browser
Then Verify mobilenumber field is enabled on page load
Then Verify Amount field should not allow to enter data on page load
	#Then Verify on page Fetch last recharge hyper link should be disabled
Then Verify text Lets Do a Recharge should display on page load
Then Verify banner should display on page load
Then Enter mobile number less than ten digits - Error message should display in Red
Then Mobile Number label and field border should display in Red
Then Enter Postpaid Number of Idea - Error message should display
Then Mobile Number label and field border should display in Red
#Then Click Dismiss >> Toast message should vanish
Then Enter Postpaid Number of VF- Error message should display 
Then Mobile Number label and field border should display in Red
#Then Click Dismiss >> Toast message should vanish
Then Enter NonIdea/NonVF number- Error Message should display
Then Mobile Number label and field border should display in Red
#Then Click Dismiss >> Toast message should vanish

Then Enter Idea Prepaid Number >> Error Message should display
Then Mobile Number label and field border should display in Red
#Then Click Dismiss >> Toast message should vanish
Then Enter VF Prepaid Number >> Amount field should be enabled
	#Then Enter VF Prepaid Number >>  Fetch last recharge link should be enabled
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
Then Click Try Again >> Recharge landing page should display


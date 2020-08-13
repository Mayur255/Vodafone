

@VF_Packs
Feature: VF_packs


  @Prepaid_Pack_Chrome
  Scenario: VF_Pack
  
Given Launch the browser
When Enter URL  
Then Prepaid Pack page should open properly
Then Verify Page >> Circle should display
Then Verify Page >> By default Mumbai circle should display
Then Verify Page >> Pack categories should display
Then Verify Pack categories >> Unlimited, Value Packs, Add Ons should display
Then Verify Pack details >> Pack Mrp should display
Then Verify Pack details >> Validity should display
Then If Talktime details available >> It should display for Unlimited category pack
Then If Data details available >> It should display for Unlimited category pack
#Then SMS Details should not display in pack details section
#Then If Nontelco benefits are available then max two should display in pack details section
Then Select Internet category >> Only Data and Validity fields should display
Then Select Talktime category >> Only Talktime and Validity fields should display
Then On page load >> Imortant Things to Know should display collapsed
Then Click Arrow for Important Things to Know >> Page should autoscroll
#Then Verify page >> Focus should go on Imp Things to know section
Then Verify page >> Imp Things to Know section should expand
Then Click Arrow for Important Things to Know >> Page should collapse

Then Click Know More for any pack >> Popup should open
Then Click Esc >> Popup should close

Then Click Know More for any pack >> Popup should open
Then Click Cross on popup >> Popup should close
Then Click Know More for any pack >> Popup should open
Then Verify Know More details >> Pack Mrp should display
Then Verify Know More details >> Below Mrp Pack Includes text should display
Then Verify Know More details >> Unlimited, Data and SMS details should display if available
Then Verify Know More details >> Unlimited, Data and SMS details should be in same line
Then Verify Know More details >> Your Benefits data should display if available
Then Verify Know More details >> Buy Pack should display
Then Click Buy Pack >> Seleced Pack page should display
Then Verify Selected Pack page >> Pack Mrp displayed on landing page for respective Pack should display
Then Verify Selected Pack page >> Below Mobile Number Details section should display
Then Verify Mobile Number details section >> Focus should be on Mobile Number field
Then Verify Mobile Number details section >> Confirm should be disabled
Then Verify Selected Pack page >> Go Back link should display
Then Click Go Back >> Pack landing page should display
	#Then Verify Page >> Prepaid Mobile Plans & Packs Section should display
Then Enter mobile number less than ten digits - Error message should display in Red
Then Enter Mobile Number label and field border should display in Red
#Then Enter NonIdea/NonVF Number - Error message should display in Red
Then Enter Mobile Number label and field border should display in Red
Then Enter Idea Prepaid Number - Error message should display in Red
Then Enter Mobile Number label and field border should display in Red
Then Enter Idea Postpaid Number - Error message should display in Red
Then Enter Mobile Number label and field border should display in Red
Then Try to enter Mobile Number starting with 0 to 4 >> It should not allow
Then Enter alphabets/Special characters in Mobile Number field- it should not allow
	#Then Select Circle >> DL - DL circle packs should display
	#Then For DL circle >> Select Talktime >> Click Buy Pack for Rs 10 pack
	#Then Enter MH circleVF  number >> Confirm should be enabled as Rs 10 pack is available for MH circle
	#Then Click Edit >> Click Buy Pack for Rs 139 Pack
	#Then Click Buy Pack >> Enter MH circle VF number >> Error message should display in Red
	#Then Click Buy Pack >> Enter MH circle VF number >> Enter Mobile Number label and field border should display in Red
Then For DL circle >> Enter DL Circle VF number >> Confirm should be enabled
Then Click Confirm >> VF Payment Gateway should display
Then Select Wallet >> Click Pay button for Paytm >> Paytm page should display
Then Click on Go Back >> Oops page should display
Then Verify Oops page >> Oops page with payment failure text should display
Then Verify Failure Page >> Mobile Number field should display provided VF Number
#Then Verify Failure Page >> Payment Amount field should display pack Mrp selected by user.
Then Verify Failure Page >> Transaction Id should display
Then Verify Failure Page >> Date & Time should display
Then Verify Failure Page >> Download Receipt link should display
Then Verify Failure Page >> Reason for Failure section should display
Then Verify Failure Page >> Try Again button should display
Then Verify Failure Page >> Need Help link in orange color should display
Then Verify Failure Page >> SetUp Auto Pay section should display
Then Verify Failure Page >> Red Together section should display
#Then Verify Failure Page >> Imp Things to know should display
#Then Click Try Again >> Recharge landing page should display
#Then Verify Thank you Page>> Click on Download Receipt link>> Download PDF of the the receipt in the predefined format 



 @Prepaid_Pack_Firefox
  Scenario: VF_Pack
  
Given Launch the Firefox browser
When Enter URL  
Then Prepaid Pack page should open properly
Then Verify Page >> Circle should display
Then Verify Page >> By default Mumbai circle should display
Then Verify Page >> Pack categories should display
Then Verify Pack categories >> Unlimited, Value Packs, Add Ons should display
Then Verify Pack details >> Pack Mrp should display
Then Verify Pack details >> Validity should display
Then If Talktime details available >> It should display for Unlimited category pack
Then If Data details available >> It should display for Unlimited category pack
#Then SMS Details should not display in pack details section
#Then If Nontelco benefits are available then max two should display in pack details section
Then Select Internet category >> Only Data and Validity fields should display
Then Select Talktime category >> Only Talktime and Validity fields should display
Then On page load >> Imortant Things to Know should display collapsed
Then Click Arrow for Important Things to Know >> Page should autoscroll
Then Verify page >> Focus should go on Imp Things to know section
Then Verify page >> Imp Things to Know section should expand
Then Click Arrow for Important Things to Know >> Page should collapse
#Then Load More link should not display for any pack category
Then Click Know More for any pack >> Popup should open
Then Click Esc >> Popup should close

Then Click Know More for any pack >> Popup should open
Then Click Cross on popup >> Popup should close
Then Click Know More for any pack >> Popup should open
Then Verify Know More details >> Pack Mrp should display
Then Verify Know More details >> Below Mrp Pack Includes text should display
Then Verify Know More details >> Unlimited, Data and SMS details should display if available
Then Verify Know More details >> Unlimited, Data and SMS details should be in same line
Then Verify Know More details >> Your Benefits data should display if available
Then Verify Know More details >> Buy Pack should display
Then Click Buy Pack >> Seleced Pack page should display
Then Verify Selected Pack page >> Pack Mrp displayed on landing page for respective Pack should display
Then Verify Selected Pack page >> Below Mobile Number Details section should display
Then Verify Mobile Number details section >> Focus should be on Mobile Number field
Then Verify Mobile Number details section >> Confirm should be disabled
Then Verify Selected Pack page >> Go Back link should display
Then Click Go Back >> Pack landing page should display
	#Then Verify Page >> Prepaid Mobile Plans & Packs Section should display
Then Enter mobile number less than ten digits - Error message should display in Red
Then Enter Mobile Number label and field border should display in Red
Then Enter Mobile Number label and field border should display in Red
Then Enter Idea Prepaid Number - Error message should display in Red
Then Enter Mobile Number label and field border should display in Red
Then Enter Idea Postpaid Number - Error message should display in Red
Then Enter Mobile Number label and field border should display in Red
Then Try to enter Mobile Number starting with 0 to 4 >> It should not allow
Then Enter alphabets/Special characters in Mobile Number field- it should not allow
	#Then Select Circle >> DL - DL circle packs should display
	#Then For DL circle >> Select Talktime >> Click Buy Pack for Rs 10 pack
	#Then Enter MH circleVF  number >> Confirm should be enabled as Rs 10 pack is available for MH circle
	#Then Click Edit >> Click Buy Pack for Rs 139 Pack
	#Then Click Buy Pack >> Enter MH circle VF number >> Error message should display in Red
	#Then Click Buy Pack >> Enter MH circle VF number >> Enter Mobile Number label and field border should display in Red
Then For DL circle >> Enter DL Circle VF number >> Confirm should be enabled
Then Click Confirm >> VF Payment Gateway should display
Then Select Wallet >> Click Pay button for Paytm >> Paytm page should display
Then Click on Go Back >> Oops page should display
Then Verify Oops page >> Oops page with payment failure text should display
Then Verify Failure Page >> Mobile Number field should display provided VF Number
#Then Verify Failure Page >> Payment Amount field should display pack Mrp selected by user.
Then Verify Failure Page >> Transaction Id should display
Then Verify Failure Page >> Date & Time should display
Then Verify Failure Page >> Download Receipt link should display
Then Verify Failure Page >> Reason for Failure section should display
Then Verify Failure Page >> Try Again button should display
Then Verify Failure Page >> Need Help link in orange color should display
Then Verify Failure Page >> SetUp Auto Pay section should display
Then Verify Failure Page >> Red Together section should display
#Then Verify Failure Page >> Imp Things to know should display
#Then Click Try Again >> Recharge landing page should display
#Then Verify Thank you Page>> Click on Download Receipt link>> Download PDF of the the receipt in the predefined format
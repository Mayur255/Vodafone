@VF_CategorySpecific
Feature: CategorySpecificPage


  @CategoryPage
  Scenario: Vfone_Pack
  
  Given Unlimited Packs page should open properly
  Then Verify Page >> Circle should display
  Then Verify Page >> By default Maharashtra & Goa circle should display
  Then Verify Page >> Pack category as Unlimited should display
  Then Verify Pack details >> Pack Mrp should display
  Then Verify Pack details >> Validity should display
  Then If Talktime details available >> It should display for Unlimited category pack
  Then If Data details available >> It should display for Unlimited category pack
  Then SMS Details should not display in pack details section for Unlimited category pack
  Then Click Know More for any pack >> Popup should open
  Then Click Esc >> Popup should close
  Then Click Know More for any pack >> Popup should be open
  Then Click Cross on popup >> Popup should close
   Then Click Know More for any pack >> Popup should be open
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
Then Verify Page >> Prepaid Mobile Plans & Packs Section should display
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

@Talktime
Scenario: Talktime
Given Talktime Packs page should open properly
When Verify Page >> Circle should display
Then Verify Page >> By default Maharashtra & Goa circle should display
Then Verify Page >> Pack category as Talktime should display
Then Verify Pack details >> Pack Mrp should display
Then Verify Pack details >> Validity should display
Then Verify Pack details >> It should display for Talktime details
Then Click Know More for any pack >> Popup should open1
Then Click Esc >> Popup should close
Then Click Know More for any pack >> Popup should open1
Then Click Cross on popup >> Popup should close1
Then Verify Know More details >> Pack Mrp should display
Then Verify Know More details >> Talktime details should display1
Then Verify Know More details >> Additional Benefits data should display if available
Then Verify Know More details >> Buy Pack should display
Then Click Buy Pack >> Seleced Pack page should display
#Then Click Buy Pack on Landing page >> Seleced Pack page should display

Then Verify Selected Pack page >> Pack Mrp displayed on landing page for respective Pack should display
Then Verify Selected Pack page >> Below Mobile Number Details section should display
Then Verify Mobile Number details section >> Focus should be on Mobile Number field
Then Verify Mobile Number details section >> Confirm should be disabled
Then Verify Selected Pack page >> Go Back link should display
#Then Click Go Back >> Pack landing page should display
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

@Data_pack
Scenario: Data_pack
Given data_Packs page should open properly
When Verify Page >> Circle should display
Then Verify Page >> By default Maharashtra & Goa circle should display
Then Verify Page >> Pack category as Data should display
Then Verify Pack details >> Pack Mrp should display
Then Verify Pack details >> Validity should display
Then Verify Pack details >> It should display for Data details
Then Click data Know More for any pack >> Popup should open
Then Click Esc >> Popup should close
Then Click data Know More for any pack >> Popup should open
Then Click Cross on popup >> Popup should close
Then Click data Know More for any pack >> Popup should open

Then Verify Know More details >> Pack Mrp should display
Then Verify Know More details >> Data  details should display
Then Verify Know More details >> Additional Benefits data should display if available
Then Verify Know More details >> Buy Pack should display
Then Click Buy Pack >> Seleced Pack page should display
#Then Click Buy Pack on landing page >> Seleced Pack page should display
Then Verify Selected Pack page >> Pack Mrp displayed on landing page for respective Pack should display
Then Verify Selected Pack page >> Below Mobile Number Details section should display
Then Verify Mobile Number details section >> Focus should be on Mobile Number field
Then Verify Mobile Number details section >> Confirm should be disabled
Then Verify Selected Pack page >> Go Back link should display
#Then Click Go Back >> Pack landing page should display
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





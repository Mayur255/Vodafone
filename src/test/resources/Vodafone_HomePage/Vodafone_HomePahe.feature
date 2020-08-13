@VodaFone_HomePage

Feature: Vodafone Home Page featurefile

#@Voda_HomePage
@HomePage_Crome

Scenario: Voda fone Homepage

Given Load Vodafone Site >> Home Page should display
Then Verify Home Page >> Header should display

Then Verify Home Page >> Footer should display
Then Verify Home Page >> Below Header -  Banner should display
Then Verify Home Page >> Mobile number field should display
Then Verify Home Page >> Arrow (>) button should be disabled as number is not provided
Then Enter mobile number less than ten digits - Error message should display in Red
Then Enter mobile number less than ten digits - Enter Mobile Number label and field border should display in Red
Then Enter Postpaid Number of Idea - error Message should display in red color
		#Then Click Dismiss >> Toast message should vanish
Then Enter NonIdea/NonVF number- error Message should display in red color
		#Then Click Dismiss >> Toast message should vanish
Then Try to enter Mobile Number starting with 0 to 4 >> It should not allow
Then Enter alphabets/Special characters in Mobile Number field- it should not allow
Then Enter Idea Prepaid Number >> error Message should display red color
#Then Click Dismiss >> Toast message should vanish
#Then Enter COCP number >> Toast message should be display
#Then Click Dismiss >> Toast message should vanish

Then Enter VF Postpaid Number >> Arrow (>) button should be enabled
Then Load Home Page >> Mobile Number should be autopopulated with VF Postpaid Number entered earlier
Then Enter VF Postpaid Number >> Arrow (>) button should be black
Then Click arrow (>)Billpay page should display
#Then Verify Billpay page >> Mobile number should be autopopulated with number entered on Homepage
Then Verify Billpay page >> Amount field should be enabled
Then Verify Billpay page >> Fetch your bill link should be enabled
Then Enter VF Prepaid Number >> Arrow (>) button should be enabled
Then Load Home Page >> Mobile Number should be autopopulated with VF Prepaid Number entered earlier	
Then Enter VF Prepaid Number >> Arrow (>) button should be black
Then Click arrow (>)Recharge page should display

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

Then Verify Loaded benefits icon one pixel.
Then Verify Loaded benefits icon two pixel.
Then Verify Loaded benefits icon three pixel.
Then Verify Loaded benefits icon four pixel.
Then Verify Loaded benefits icon five pixel.
Then Verify Loaded benefits icon_six pixel.

Then Verify Vodafone exclusive banner image one pixel. 
Then Verify Vodafone exclusive banner image two pixel. 
Then Verify Vodafone exclusive banner image three pixel. 
Then Verify Vodafone exclusive banner image four pixel. 
Then Verify Vodafone exclusive banner image five pixel. 
#Then Verify Vodafone exclusive banner image six pixel. 
Then Verify the displayed Meta description, Meta viewport, Meta template







#Then Verify Home Page >> Important Things to Know should display
#Then On page load >> Imortant Things to Know should display collapsed
#Then Click Arrow for Important Things to Know >> Page should autoscroll
#Then Verify page >> Focus should go on Imp Things to know section
#Then Verify page >> Imp Things to Know section should expand
#Then Click Arrow for Important Things to Know >> Page should collapse




@HomePage_Firefox
Scenario: Voda fone Homepage

Given Load Vodafone Site >> Home Page should display in Firefox browser
Then Verify Home Page >> Header should display

Then Verify Home Page >> Footer should display
Then Verify Home Page >> Below Header -  Banner should display
Then Verify Home Page >> Mobile number field should display
Then Verify Home Page >> Arrow (>) button should be disabled as number is not provided
Then Enter mobile number less than ten digits - Error message should display in Red
Then Enter mobile number less than ten digits - Enter Mobile Number label and field border should display in Red
Then Enter Postpaid Number of Idea - error Message should display in red color
		#Then Click Dismiss >> Toast message should vanish
Then Enter NonIdea/NonVF number- error Message should display in red color
		#Then Click Dismiss >> Toast message should vanish
Then Try to enter Mobile Number starting with 0 to 4 >> It should not allow
Then Enter alphabets/Special characters in Mobile Number field- it should not allow
Then Enter Idea Prepaid Number >> error Message should display red color
#Then Click Dismiss >> Toast message should vanish
#Then Enter COCP number >> Toast message should be display
#Then Click Dismiss >> Toast message should vanish

Then Enter VF Postpaid Number >> Arrow (>) button should be enabled
Then Load Home Page >> Mobile Number should be autopopulated with VF Postpaid Number entered earlier
Then Enter VF Postpaid Number >> Arrow (>) button should be black
Then Click arrow (>)Billpay page should display
#Then Verify Billpay page >> Mobile number should be autopopulated with number entered on Homepage
Then Verify Billpay page >> Amount field should be enabled
Then Verify Billpay page >> Fetch your bill link should be enabled
Then Enter VF Prepaid Number >> Arrow (>) button should be enabled
Then Load Home Page >> Mobile Number should be autopopulated with VF Prepaid Number entered earlier	
Then Enter VF Prepaid Number >> Arrow (>) button should be black
Then Click arrow (>)Recharge page should display

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

Then Verify Loaded benefits icon one pixel.
Then Verify Loaded benefits icon two pixel.
Then Verify Loaded benefits icon three pixel.
Then Verify Loaded benefits icon four pixel.
Then Verify Loaded benefits icon five pixel.
Then Verify Loaded benefits icon_six pixel.

Then Verify Vodafone exclusive banner image one pixel. 
Then Verify Vodafone exclusive banner image two pixel. 
Then Verify Vodafone exclusive banner image three pixel. 
Then Verify Vodafone exclusive banner image four pixel. 
Then Verify Vodafone exclusive banner image five pixel. 
#Then Verify Vodafone exclusive banner image six pixel. 
Then Verify the displayed Meta description, Meta viewport, Meta template







#Then Verify Home Page >> Important Things to Know should display
#Then On page load >> Imortant Things to Know should display collapsed
#Then Click Arrow for Important Things to Know >> Page should autoscroll
#Then Verify page >> Focus should go on Imp Things to know section
#Then Verify page >> Imp Things to Know section should expand
#Then Click Arrow for Important Things to Know >> Page should collapse

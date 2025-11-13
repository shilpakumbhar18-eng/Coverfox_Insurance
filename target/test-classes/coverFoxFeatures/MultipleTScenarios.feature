Feature: CoverFox Health Insurance Test
Scenario: TC01: Validate CoverFox Health Insurance plan for single person
Given I am home page
When I click on get started button
And I click on next button
And I provide age as "24" and click on next button
And I provide pincode as "414242" , mobNum as "9999999999" and click on continue button
Then matching Health Insurance Plans should be displayed as "48"
 
 Scenario: TC02: Validate CoverFox Car Insurance
 Given I am home page
 When I click on carInsurance button
 And I provide  valid RTO number and click on view quotes button
 And I provide valid details and click on view quotes button
 Then I should get plan details
 
 Scenario: TC03: Validate CoverFox Bike Insurance
 Given I am home page
 When I click on bikeInsurance button
 And I provide  valid RTO number and click on view quotes button
 And I provide valid details and click on view quotes button
 Then I should get plan details1
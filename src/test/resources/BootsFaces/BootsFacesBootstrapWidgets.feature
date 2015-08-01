Feature: Testing the Bootstrap Widgets submenu of the BootsFaces project page

Scenario: Opening the the Bootstrap Widgets / Alerts page
  Given I am on the BootsFaces start page
  When I navigate to "Bootstrap Widgets" / "Alerts"
  Then I can read "You can make Alerts dismissable"
  
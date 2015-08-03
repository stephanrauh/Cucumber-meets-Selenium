Feature: Testing the forms submenu of the BootsFaces project page

Scenario: Opening the the Forms / Basic Layout and Grid System page
  Given I am on the BootsFaces start page
  When I navigate to "Forms" / "Buttons"
  Then I can read "Button styles can be applied to anything "
   And the page contents equals "Buttons.txt"
  
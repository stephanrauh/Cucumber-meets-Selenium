Feature: Testing the layout submenu of the BootsFaces project page

Scenario: Opening the the Layout / Basic Layout and Grid System page
  Given I am on the BootsFaces start page
  When I navigate to "Layout" / "Basic Layout and Grid System"
  Then I can read "BootsFaces takes full advantage of Bootstrap Grid system while maintaining the benefits of being a JSF framework."
  And the page contents equals "BasicLayout.txt"
  
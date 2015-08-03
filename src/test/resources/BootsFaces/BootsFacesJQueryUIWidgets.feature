Feature: Testing the jQueryUI Widgets submenu of the BootsFaces project page

Scenario: Opening the the jQueryUI Widgets / Sliders page
  Given I am on the BootsFaces start page
  When I navigate to "jQueryUI Widgets" / "Slider"
  Then I can read "BootsFaces derives the Slider component"

Scenario: Opening the the jQueryUI Widgets / DatePicker page
  Given I am on the BootsFaces start page
  When I navigate to "jQueryUI Widgets" / "DatePicker"
  Then I can read "BootsFaces derives the Date Picker component"
   
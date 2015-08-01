Feature: Testing the Getting Started submenu of the BootsFaces project page

// Scenario: Opening the project page
//  Given I am on the BootsFaces start page
//  Then I can download BootsFaces
  
Scenario: Opening the the Getting started / Requirements page
  Given I am on the BootsFaces start page
  When I navigate to "Getting Started" / "Requirements"
  Then I can read "JSF 2.0, 2.1 and 2.2 are supported."

Scenario: Opening the the Getting started / Quick Start page
  Given I am on the BootsFaces start page
  When I navigate to "Getting Started" / "Quick Start"
  Then I can read "Open your favorite IDE"

Scenario: Opening the the Getting started / PrimeFaces page
  Given I am on the BootsFaces start page
  When I navigate to "Getting Started" / "PrimeFaces"
  Then I can read "BootsFaces plays nicely with PrimeFaces."
  
Scenario: Opening the the Getting started / OmniFaces page
  Given I am on the BootsFaces start page
  When I navigate to "Getting Started" / "OmniFaces"
  Then I can read "a good idea to combine it with OmniFaces."
  
Scenario: Opening the the Getting started / AngularFaces page
  Given I am on the BootsFaces start page
  When I navigate to "Getting Started" / "AngularFaces"
  Then I can read "AngularFaces offers special"

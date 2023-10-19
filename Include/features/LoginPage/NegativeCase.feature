#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@LoginActivities
Feature: Login Feature
  I want to use this for Negative Case

  @Case1
  Scenario: Empty All Field
    Given Make sure user navigate to login page
    When User Empty All the Field
    And User click Login button
    And Allert Username is Required Appear
    And User Close Allert
    Then Username Field is Empty
    
  @Case2
  Scenario: Empty Password Field
  Given Make sure user navigate to login page
    When User input Username
    And User click Login button
    And Allert Password is Required Appear
    And User Close Allert
    Then Username Field still Filled
   
  @Case3
  Scenario: Empty Username Field
  Given Make sure user navigate to login page
    When User input Password
    And User click Login button
    And Allert Username is Required Appear
    And User Close Allert
    Then Password Field still Filled 
    
  @Case4
  Scenario: Error User Login
  Given Make sure user navigate to login page
    When User input Error Username
    And User input Password
    And User click Login button
    And User directed to Home Page
    And User Add to Cart
    Then User cant Remove Cart
    
  @Case5
  Scenario: LockedOut User ogin
  Given Make sure user navigate to login page
    When User input LockedOut Username
    And User input Password
    And User click Login button
    And Allert LockedOut User Appear
    And User Close Allert
    Then Username and Password Field still Fiiled
    
  @Case6
  Scenario: Performance Glitch User
  Given Make sure user navigate to login page
    When User input Glitch Username
    And User input Password
    And User click Login button
    And Load HomePage need more time
    Then User directed to Home Page
    
  @Case7
  Scenario: Problem User Login
  Given Make sure user navigate to login page
    When User input Problem Username
    And User input Password
    And User click Login button
    And User directed to Home Page
    Then Wrong Image of Product Appear
    
  @Case8
  Scenario: Wrong Password
  Given Make sure user navigate to login page
    When User input wrong password
    And User input Username
    And User click Login button
    And Allert wrong password Appear
    And User Close Allert
    Then Username Field still Filled
  

    

Feature: Add items to cart

Background:
		Given the correct URL


  Scenario: Log in
    
    When I enter my details
    Then I get logged in

  Scenario: Add to basket
    
    When I add to cart
    Then I see items in my cart
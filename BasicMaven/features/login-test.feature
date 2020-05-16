Feature: LoginTest

  Scenario: Verify Login Is Successful
    Given I login to BayAmp WebMail
    When verify login is successful
    Then logout and close

  Scenario: Login without Username and Password
    Given I open BayAmp WebMail
    When I click login
    Then I see the error message

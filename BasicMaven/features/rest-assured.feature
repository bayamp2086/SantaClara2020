Feature: To verify API automation with Rest Assured

  Scenario Outline: To verify Rest Service - Get Request
    Given GET "<idGET>" to get an engineer
    When I execute the GET request
    Then I get 200 OK status code for GET request
    And Response includes Name as Bayamp
  Examples:
    |idGET|
    |Ekwvu6VYL|

  Scenario: To verify Rest Service - POST Request
    Given POST data to create an engineer
    When I execute the POST request
    Then I get 201 Created status code for POST request

  Scenario Outline: To verify Rest Service - PUT Request
    Given PUT data and "<idPUT>" to update an engineer
    When I execute the PUT request
    Then I get 200 Ok status code for PUT request
    Examples:
      |idPUT|
      |VkGGmfLtI|

  Scenario Outline: To verify Rest Service - DELETE Request
    Given DELETE "<idDELETE>" to delete an engineer
    When I execute the DELETE request
    Then I get 200 Ok status code for DELETE request
    Examples:
      |idDELETE|
      |VyEOJNg5O|
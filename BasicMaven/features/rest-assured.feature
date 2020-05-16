Feature: To verify API automation with Rest Assured

  Scenario Outline: To verify Rest Service - Get Request
    Given GET "<idGET>" to get an engineer
    When I execute the GET request
    Then I get 200 OK status code for GET request
    And Response includes Name as Bayamp
  Examples:
    | idGET |
    | Ekwvu6VYL |

  Scenario Outline: To verify Rest Service - POST Request
    Given POST "<dataPOST>" to create an engineer
    When I execute the POST request
    Then I get 201 Created status code for POST request
    Examples:
      | dataPOST |
      | RestAssuredPost |

  Scenario Outline: To verify Rest Service - PUT Request
    Given PUT "<dataPUT>" and "<idPUT>" to update an engineer
    When I execute the PUT request
    Then I get 200 Ok status code for PUT request
    Examples:
      | dataPUT | idPUT |
      | RestAssuredPut | VkGGmfLtI |

  Scenario Outline: To verify Rest Service - DELETE Request
    Given DELETE "<idDELETE>" to delete an engineer
    When I execute the DELETE request
    Then I get 200 Ok status code for DELETE request
    Examples:
      | idDELETE |
      | V1l0YQOc_ |
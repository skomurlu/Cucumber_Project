#  Daha önceki Crete a Fee, delete Fee Senaryosunu
#  Aşağıdaki 5 farklı değerler için çalıştırınız.

Feature: Fee Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully

      Scenario Outline: Create a Fee, delete Fee

    And Click on the element in the left Nav
    | setupOne   |
    | parameters |
    | fees       |

    And Click on the element in the Dialog
    | addButton |

    And User sending the keys in Dialog content
    | nameInput       | <name>      |
    | codeInput       | <code>      |
    | integrationCode | <intCode>   |
    | priorityCode    | <priority>  |

    And Click on the element in the Dialog
    | saveButton |

    And Success message should be displayed

    And User delete item from Dialog
    | <name>   |

    And Success message should be displayed
      Examples:

    | name             | code        |     intCode   |     priority |
    | safakFee1        | 020001      |     bofa      |     322      |
    | safakFee2        | 020002      |     chase     |     422      |
    | safakFee3        | 020003      |     discover  |     522      |


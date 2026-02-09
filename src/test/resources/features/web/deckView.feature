Feature: Deck is submitted by user on submitted by user decks page

  @Regression
  @severity=critical
  @issue=<TT-2>
  @Owner-Santiago_Lataza
  Scenario Outline: Deck view

    Given user goes to main page
    When user goes to users submitted decks page
    When user goes to deck number: <number>

    Examples:
      | number |
      | 1      |
      | 5      |
      | 25     |


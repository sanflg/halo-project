Feature: Search Test

  @Regression
    @severity=critical
    @issue=<TT-1>
    @Owner-Santiago_Lataza
  Scenario Outline: Search test

    Given user goes to main page
    When user does a search with term: <search_term>
    Then all decks contains in the name the term: <search_term>
    Examples:
      | search_term |
      | azorius     |
      | control     |
      | goblin      |

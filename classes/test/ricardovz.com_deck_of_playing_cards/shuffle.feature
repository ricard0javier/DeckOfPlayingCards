Feature: Shuffle

  Shuffling is a procedure used to randomize a deck of playing cards to provide an
  element of chance in card games. Shuffling is often followed by a cut, to help
  ensure that the shuffler has not manipulated the outcome.

  source: https://en.wikipedia.org/wiki/Shuffling

  Scenario: Shuffle
    Given a deck French playing cards
    And known the position of the card 'seven' of 'Diamonds'
    And known the position of the card 'five' of 'Hearts'
    And known the position of the card 'Ace' of 'Clubs'
    And known the position of the card 'Jack' of 'Spades'
    When I shuffle the deck
    Then the number of cards is the same
    And the position of the card 'seven' of 'Diamonds' has changed
    And the position of the card 'five' of 'Hearts' has changed
    And the position of the card 'Ace' of 'Clubs' has changed
    And the position of the card 'Jack' of 'Spades' has changed

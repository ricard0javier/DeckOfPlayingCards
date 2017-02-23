package com.ricardovz.learning.deck;

import lombok.Value;

/**
 * Represents a Card in the deck
 * @see CardType
 * @see CardValue
 */
@Value
public class Card {
    private final CardType type;
    private final CardValue value;
}

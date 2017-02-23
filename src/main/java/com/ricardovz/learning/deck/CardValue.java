package com.ricardovz.learning.deck;

import lombok.extern.slf4j.Slf4j;

/**
 * Represents all the card values available
 */
@Slf4j
public enum CardValue {
    ACE, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;


    /**
     * Parses a string int a card value matching by name
     *
     * @param value the name of the value
     * @return the card value matching the input
     * @throws CardNotFound if the input provided doesn't match any type defined
     */
    public static CardValue parse(String value) throws CardNotFound {
        log.debug("Finding card type '{}'", value);

        for (CardValue cardValue : CardValue.values()) {
            if (cardValue.name().equalsIgnoreCase(value)) {
                return cardValue;
            }
        }

        throw new CardNotFound("The card value '" + value + "' is invalid");
    }
}

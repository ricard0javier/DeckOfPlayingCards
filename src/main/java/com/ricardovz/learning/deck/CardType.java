package com.ricardovz.learning.deck;

import lombok.extern.slf4j.Slf4j;

/**
 * Represents all the card types available
 */
@Slf4j
public enum CardType {
    CLUBS, DIAMONDS, HEARTS, SPADES;

    /**
     * Parses a string int a card type matching by name
     *
     * @param type the name of the type
     * @return the card type matching the input
     * @throws CardNotFound if the input provided doesn't match any type defined
     */
    public static CardType parse(String type) throws CardNotFound {
        log.debug("Finding card type '{}'", type);

        for (CardType cardType : CardType.values()) {
            if (cardType.name().equalsIgnoreCase(type)) {
                return cardType;
            }
        }

        throw new CardNotFound("The card type '" + type + "' is invalid");
    }
}

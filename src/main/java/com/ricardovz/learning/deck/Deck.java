package com.ricardovz.learning.deck;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

/**
 * Represents a deck of french playing cards. It has 56 cards
 *
 * @see Card
 * @see CardType
 */
@Slf4j
public class Deck {

    /**
     * An array of 56 cards.
     *
     * @see Card
     */
    private LinkedList<Card> deck;


    /**
     * Initialises the deck with 56 Cards.
     * Initially cards are sorted.
     * Use the method shuffle() to randomize the order.
     */
    public Deck() {

        log.debug("Initialise the deck");

        deck = new LinkedList<>();

        for (CardType cardType : CardType.values()) {
            log.debug("setting the cards for the type '{}'", cardType);

            for (CardValue cardValue : CardValue.values()) {
                log.trace("setting the cards for the type '{}' and value '{}'", cardType, cardValue);

                Card card = new Card(cardType, cardValue);

                deck.add(card);
            }
        }
    }


    /**
     * Randomise the order or the cards.
     */
    public void shuffle() {

        log.debug("Shuffling the deck");

        for (int position = deck.size() - 1; position > 0; position--) {

            int rand = (int) (Math.random() * (position + 1));
            Card temp = deck.get(position);
            deck.set(position, deck.get(rand));
            deck.set(rand, temp);
        }
    }

    /**
     * Return the total number of cards
     */
    public int getNumberOfCardsLeft() {
        return deck.size();
    }


    /**
     * Retrieves the last card of the deck
     *
     * @return the last card of the deck
     * @throws CardNotFound when There are no more cards in the deck
     */
    public Card dealCard() throws CardNotFound {
        if (deck.isEmpty()) {
            log.debug("There are no more cards in the deck to withdraw");
            throw new CardNotFound("There are no more cards in the deck");
        }

        Card card = deck.pollLast();

        log.debug("dealing card '{}-{}'", card.getType(), card.getValue());

        return card;
    }


    /**
     * Given the card type and value it returns the position of the card in the deck.
     * if the card is not in the deck it returns -1
     *
     * @param type  the card type: CLUBS, DIAMONDS, HEARTS, SPADES
     * @param value the card value: ACE, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
     * @return the position of the card in the deck.
     * @throws CardNotFound when the card indicated is valid but not into the current deck
     */
    public int getCardPosition(String type, String value) throws CardNotFound {

        // parse the received values
        CardType cardType = CardType.parse(type);
        CardValue cardValue = CardValue.parse(value);

        Card card = new Card(cardType, cardValue);
        int position = deck.indexOf(card);

        // throw exception if not found
        if (position < 0) {
            log.debug("Card not found. Type: '{}', Value: '{}'", type, value);
            throw new CardNotFound("Tha card is not in the deck. Card withdrawn previously");
        }

        return position;
    }

}
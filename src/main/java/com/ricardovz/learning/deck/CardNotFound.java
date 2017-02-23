package com.ricardovz.learning.deck;

/**
 * Represents exception that can occurred when a requested card is not found
 */
public class CardNotFound extends Exception {

    /**
     * Initialises the exception with a message
     * @param message message to inclue in the exception
     */
    public CardNotFound(String message) {
        super(message);
    }
}

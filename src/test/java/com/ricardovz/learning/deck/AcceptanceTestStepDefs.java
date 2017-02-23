package com.ricardovz.learning.deck;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AcceptanceTestStepDefs {

    private int numberOfCards;
    private Map<String, Integer> trackingCards;
    private Deck deck;

    @Given("^a deck French playing cards$")
    public void a_deck_French_playing_cards_cards() throws Throwable {
        deck = new Deck();
        numberOfCards = deck.getNumberOfCardsLeft();
        trackingCards = new HashMap<>();
    }

    @And("^known the position of the card '(.*)' of '(.*)'$")
    public void known_the_position_of_the_card(String value, String type) throws Throwable {
        String key = getTrackingCardId(value, type);
        int position = deck.getCardPosition(type, value);
        trackingCards.put(key, position);
    }

    @When("^I shuffle the deck$")
    public void i_shuffle_the_deck() throws Throwable {
        deck.shuffle();
    }

    @Then("^the number of cards is the same$")
    public void the_number_of_cards_is_the_same() throws Throwable {
        int currentNumberOfCards = deck.getNumberOfCardsLeft();
        assertThat(numberOfCards, is(currentNumberOfCards));
    }

    @Then("^the position of the card '(.*)' of '(.*)' has changed$")
    public void the_number_of_cards_is_the_same(String value, String type) throws Throwable {
        String key = getTrackingCardId(value, type);
        int oldPosition = trackingCards.get(key);
        int newPosition = deck.getCardPosition(type, value);
        assertThat(oldPosition, is(not(newPosition)));
    }

    private String getTrackingCardId(String value, String type) {
        return type + "_" + value;
    }
}

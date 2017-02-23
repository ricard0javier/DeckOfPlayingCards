package com.ricardovz.learning.deck;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class DeckTest {

    private Deck target;

    @Before
    public void setUp() throws Exception {
        target = new Deck();
    }

    @Test
    public void constructor_numberOfCards_is_expected() throws Exception {
        assertThat(target.getNumberOfCardsLeft(), is(56));
    }

    @Test
    public void shuffle_thenNumberOfCardsIsTheSame() throws Exception {
        target.shuffle();
        assertThat(target.getNumberOfCardsLeft(), is(56));
    }

    @Test
    public void shuffle_cardChangedThePosition() throws Exception {
        int cardPositionBeforeShuffle = target.getCardPosition("DIAMONDS", "ACE");
        target.shuffle();
        int cardPositionAfterShuffle = target.getCardPosition("DIAMONDS", "ACE");
        assertThat(cardPositionBeforeShuffle, is(not(cardPositionAfterShuffle)));
    }

    @Test
    public void getNumberOfCardsLeft_decreaseByOneAfterDeal() throws Exception {
        int initialNumberOfCards = target.getNumberOfCardsLeft();
        target.dealCard();
        target.dealCard();
        target.dealCard();
        int finalNumberOfCards = target.getNumberOfCardsLeft();
        assertThat(finalNumberOfCards, is(initialNumberOfCards - 3));
    }

    @Test(expected = CardNotFound.class)
    public void getCardPosition_givenUnknownCard_throwIllegalArgumentException() throws Exception {
        target.getCardPosition("Red", "One");
    }

    @Test(expected = CardNotFound.class)
    public void getCardPosition_givenDealtCard_throwCardNotFoundException() throws Exception {
        Card card = target.dealCard();
        target.getCardPosition(card.getType().name(), card.getValue().name());
    }

}
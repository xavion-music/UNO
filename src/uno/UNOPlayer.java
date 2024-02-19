/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

/**
 *
 * @author palak
 */
import java.util.ArrayList;
import java.util.List;

public class UNOPlayer {
    private String name;
    private List<UNOCard> hand;

    public UNOPlayer(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void drawInitialCards(UNODeck deck) {
        for (int i = 0; i < 7; i++) {
            hand.add(deck.drawCard());
        }
    }

    public UNOCard playCard(int cardIndex, UNOCard currentCard) {
        if (cardIndex >= 0 && cardIndex < hand.size()) {
            UNOCard cardToPlay = hand.get(cardIndex);
            if (cardToPlay.canBePlayedOn(currentCard)) {
                hand.remove(cardIndex);
                return cardToPlay;
            }
        }
        return null;
    }

    public void addCardToHand(UNOCard card) {
        hand.add(card);
    }

    public String getName() {
        return name;
    }

    public boolean hasWon() {
        return hand.isEmpty();
    }

    public String getHandAsString() {
        StringBuilder sb = new StringBuilder();
        for (UNOCard card : hand) {
            sb.append(card.toString() + ", ");
        }
        return sb.toString().trim();
    }
}
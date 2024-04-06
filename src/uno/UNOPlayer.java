package uno;

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

    public UNOCard playCard(int cardIndex) {
        if (cardIndex >= 0 && cardIndex < hand.size()) {
            return hand.remove(cardIndex);
        }
        return null;
    }

    public UNOCard getCard(int cardIndex) {
        if (cardIndex >= 0 && cardIndex < hand.size()) {
            return hand.get(cardIndex);
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
            sb.append(card.toString()).append(", ");
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "";
    }
}
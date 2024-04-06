/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

import java.util.Collections;
import java.util.Stack;

public class UNODeck {
    private Stack<UNOCard> cards;

    public UNODeck() {
        this.cards = new Stack<>();
        initialize();
    }

    private void initialize() {
        String[] colors = {"Red", "Green", "Blue", "Yellow"};
        String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Skip", "Reverse", "Draw Two"};
        // Add one 0 card of each color
        for (String color : colors) {
            cards.push(new UNOCard(color, "0"));
        }

        for (int i = 0; i < 2; i++) {
            for (String color : colors) {
                for (String value : values) {
                    if (!value.equals("0")) {
                        cards.push(new UNOCard(color, value));
                    }
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            cards.push(new UNOCard("Wild", "Color Changer"));
            cards.push(new UNOCard("Wild", "Draw Four"));
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public UNOCard drawCard() {
        if (cards.isEmpty()) {
            initialize(); 
            shuffle();
        }
        return cards.pop();
    }
}
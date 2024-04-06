/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

/**
 *
 * @author palak
 */
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
        String[] values = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "Skip", "Reverse", "Draw Two"};
        
        for (String color : colors) {
            for (String value : values) {
                cards.push(new UNOCard(color, value));
                cards.push(new UNOCard(color, value)); 
            }
        }
        
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public UNOCard drawCard() {
        if (!cards.isEmpty()) {
            return cards.pop();
        }
        
        return null;
    }
}
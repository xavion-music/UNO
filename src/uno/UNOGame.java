/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno;

/**
 *
 * @author palak
 */
import java.util.Scanner;

public class UNOGame {
    private UNODeck deck;
    private UNOPlayer[] players;
    private UNOCard currentCard;
    private Scanner scanner;
    private boolean isGameOver;

    public UNOGame(UNOPlayer[] players) {
        this.players = players;
        this.deck = new UNODeck();
        this.scanner = new Scanner(System.in);
        this.isGameOver = false;
        startGame(); 
    }

    public void startGame() {
        for (UNOPlayer player : players) {
            player.drawInitialCards(deck);
        }
        currentCard = deck.drawCard();
        while (!isGameOver) {
            for (UNOPlayer player : players) {
                takeTurn(player);
                if (player.hasWon()) {
                    System.out.println(player.getName() + " has won the game!");
                    isGameOver = true;
                    break;
                }
            }
        }
    }

    private void takeTurn(UNOPlayer player) {
        boolean playedCard = false;
        while (!playedCard) {
            System.out.println(player.getName() + "'s turn. Current card: " + currentCard);
            System.out.println("Your hand: " + player.getHandAsString());
            System.out.println("Choose a card to play or type 'draw' to draw a card:");
            String input = scanner.nextLine().trim();

            if ("draw".equalsIgnoreCase(input)) {
                UNOCard drawnCard = deck.drawCard();
                player.addCardToHand(drawnCard);
                playedCard = true;
            } else {
                try {
                    int index = Integer.parseInt(input) - 1;
                    UNOCard playedCardResponse = player.playCard(index, currentCard);
                    if (playedCardResponse != null) {
                        currentCard = playedCardResponse; 
                        playedCard = true;
                    } else {
                        System.out.println("Invalid move. Try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Try again.");
                }
            }
        }
    }
}
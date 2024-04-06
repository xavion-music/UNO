package uno;

import java.util.Scanner;

public class UNOGame {
    private UNODeck deck;
    private UNOPlayer[] players;
    private UNOCard currentCard;
    private Scanner scanner;
    private boolean isGameOver;
    private String currentColor; 

    public UNOGame(UNOPlayer[] players) {
        if (players.length < 2 || players.length > 10) {
            throw new IllegalArgumentException("Number of players must be between 2 and 10.");
        }
        this.players = players;
        this.deck = new UNODeck();
        this.scanner = new Scanner(System.in);
        this.isGameOver = false;
        for (UNOPlayer player : players) {
            player.drawInitialCards(deck);
        }
        currentCard = deck.drawCard();
        currentColor = currentCard.getColor(); 
        if (currentCard.getValue().equals("Color Changer") || currentCard.getValue().equals("Draw Four")) {
            chooseColor();
        }
    }

    public void startGame() {
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
        System.out.println(player.getName() + "'s turn. Current card: " + currentCard + " (Color: " + currentColor + ")");
        System.out.println("Your hand: " + player.getHandAsString());
        System.out.println("Choose a card to play or type 'draw' to draw a card:");
        String input = scanner.nextLine().trim();

        if ("draw".equalsIgnoreCase(input)) {
            UNOCard drawnCard = deck.drawCard();
            player.addCardToHand(drawnCard);
            System.out.println("You drew a card: " + drawnCard);
        } else {
            try {
                int index = Integer.parseInt(input) - 1;
                UNOCard playedCard = player.getCard(index);
                if (playedCard != null && (playedCard.getColor().equals(currentColor) || playedCard.getColor().equals("Wild") || playedCard.getValue().equals(currentCard.getValue()))) {
                    player.playCard(index); 
                    currentCard = playedCard;
                    System.out.println(player.getName() + " plays " + playedCard);
                    if (playedCard.getColor().equals("Wild")) {
                        chooseColor();
                    } else {
                        currentColor = playedCard.getColor(); 
                    }
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

    private void chooseColor() {
        System.out.println("Choose a color (Red, Green, Blue, Yellow):");
        currentColor = scanner.nextLine().trim();
        System.out.println("Color changed to " + currentColor);
    }
}
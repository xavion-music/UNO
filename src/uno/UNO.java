package uno;

import java.util.Scanner;

public class UNO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of players:");
        int numberOfPlayers = Integer.parseInt(scanner.nextLine().trim());

        if (numberOfPlayers < 2 || numberOfPlayers > 10) {
            System.out.println("Invalid number of players. Must be between 2 and 10.");
            return;
        }

        UNOPlayer[] players = new UNOPlayer[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Enter player " + (i + 1) + " name:");
            String name = scanner.nextLine().trim();
            players[i] = new UNOPlayer(name);
        }


        UNOGame game = new UNOGame(players);
        game.startGame();

    }
}
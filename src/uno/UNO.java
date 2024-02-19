/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uno;

/**
 *
 * @author palak
 */
import java.util.Scanner;

public class UNO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter number of players:");
        int numberOfPlayers = Integer.parseInt(scanner.nextLine().trim());
        
        UNOPlayer[] players = new UNOPlayer[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Enter player " + (i + 1) + " name:");
            String name = scanner.nextLine().trim();
            players[i] = new UNOPlayer(name);
        }
        // for starting maybe (im not sure)
        UNOGame game = new UNOGame(players);
        game.startGame();
    }
}
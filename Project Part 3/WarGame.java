import java.util.Scanner;

import java.util.Scanner;
import java.util.ArrayList;

public class WarGame {
    private Player player1;
    private Player player2;
    private Deck deck;
    private ArrayList<Card> tableCards;

    public WarGame(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        deck = new Deck();
        tableCards = new ArrayList<>();
    }

    public void shuffleDeck() {
        deck.shuffle();
        deck.shuffle();
        deck.shuffle();
    }

    public void splitDeck() {
        for (int i = 0; i < 26; i++) {
            player1.getPlayerDeck().addToDeck(deck.dealCard());
            player2.getPlayerDeck().addToDeck(deck.dealCard());
        }
    }

    public void playRound() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(player1.getName() + ", press Enter to deal a card.");
        scanner.nextLine();
        Card player1Card = player1.getPlayerDeck().dealCard();
        System.out.println(player1.getName() + " deals: " + player1Card);

        System.out.println(player2.getName() + ", press Enter to deal a card.");
        scanner.nextLine();
        Card player2Card = player2.getPlayerDeck().dealCard();
        System.out.println(player2.getName() + " deals: " + player2Card);
        

        // Add the cards to the table for comparison
        tableCards.clear();
        tableCards.add(player1Card);
        tableCards.add(player2Card);

        // If either card is a Joker, the game proceeds differently
        if (player1Card instanceof Joker && player2Card instanceof Joker) {
            System.out.println("Both players drew Jokers! It's a tie.");
            return; // No one wins, cards are discarded (no one gets the cards)
        } else if (player1Card instanceof Joker) {
            System.out.println(player1.getName() + " draws a Joker and wins the round!");
            player1WinsRound();
            return; // Player 1 wins immediately
        } else if (player2Card instanceof Joker) {
            System.out.println(player2.getName() + " draws a Joker and wins the round!");
            player2WinsRound();
            return; // Player 2 wins immediately
        }

        // Handle ties (same value cards)
        while (player1Card.getValue() == player2Card.getValue()) {
            System.out.println("It's a tie! Dealing more cards...");

            // Dealing additional cards if there is a tie
            System.out.println(player1.getName() + ", press Enter to deal a card.");
            scanner.nextLine();
            player1Card = player1.getPlayerDeck().dealCard();
            tableCards.add(player1Card);
            System.out.println(player1.getName() + " deals: " + player1Card);

            System.out.println(player2.getName() + ", press Enter to deal a card.");
            scanner.nextLine();
            player2Card = player2.getPlayerDeck().dealCard();
            tableCards.add(player2Card);
            System.out.println(player2.getName() + " deals: " + player2Card);
        }

        // Now compare the values of the cards to determine the winner
        if (player1Card.getValue() > player2Card.getValue()) {
            player1WinsRound();
        } else {
            player2WinsRound();
        }
    }

    public void player1WinsRound() {
        System.out.println(player1.getName() + " wins the round!");
        for (Card card : tableCards) {
            player1.getPlayerDeck().addToDeck(card);
        }
        System.out.println(player1.getName() + " now has " + player1.getPlayerDeck().getNumCards() + " cards.");
        System.out.println(player2.getName() + " now has " + player2.getPlayerDeck().getNumCards() + " cards.");
    }

    public void player2WinsRound() {
        System.out.println(player2.getName() + " wins the round!");
        for (Card card : tableCards) {
            player2.getPlayerDeck().addToDeck(card);
        }
        System.out.println(player2.getName() + " now has " + player2.getPlayerDeck().getNumCards() + " cards.");
        System.out.println(player1.getName() + " now has " + player1.getPlayerDeck().getNumCards() + " cards.");
    }

    public void startGame() {
        shuffleDeck();
        splitDeck();
        
        while (player1.getPlayerDeck().getNumCards() > 0 && player2.getPlayerDeck().getNumCards() > 0) {
            playRound();
        }

        // Declare the winner
        if (player1.getPlayerDeck().getNumCards() > 0) {
            System.out.println(player1.getName() + " wins the game!");
        } else {
            System.out.println(player2.getName() + " wins the game!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get player names
        System.out.print("Enter the name of player 1: ");
        String player1Name = scanner.nextLine();
        System.out.print("Enter the name of player 2: ");
        String player2Name = scanner.nextLine();

        // Create the game and start
        WarGame game = new WarGame(player1Name, player2Name);
        game.startGame();
    }
}

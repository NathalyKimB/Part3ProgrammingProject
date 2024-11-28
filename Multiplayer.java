/*Nathaly Kim Barinotto
 * Section #: 00002
 */
import java.util.Scanner;

public class Multiplayer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the name of Player 1: ");
        String player1Name = scan.nextLine();
        System.out.print("Enter the name of Player 2: ");
        String player2Name = scan.nextLine();

        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);

        Deck mainDeck = new Deck();
        //mainDeck.shuffle();

        for (int i = 0; i < 27; i++) {
            player1.getPlayerDeck().addToDeck(mainDeck.dealCard());
            player2.getPlayerDeck().addToDeck(mainDeck.dealCard());
        }

        System.out.println("\nInitial Decks:");
        printPlayerDecks(player1, player2);

        System.out.println("\nDealing all cards from " + player1.getName() + " to " + player2.getName() + ".");
        transferCards(player1.getPlayerDeck(), player2.getPlayerDeck());

        System.out.println("\nAfter Transfer 1:");
        printPlayerDecks(player1, player2);

        System.out.println("\nDealing all cards from " + player2.getName() + " to " + player1.getName() + ".");
        transferCards(player2.getPlayerDeck(), player1.getPlayerDeck());

        System.out.println("\nAfter Transfer 2:");
        printPlayerDecks(player1, player2);
    }

    private static void transferCards(Deck source, Deck target) {
        Card card;
        while ((card = source.dealCard()) != null) {
            target.addToDeck(card);
        }
    }

    private static void printPlayerDecks(Player player1, Player player2) {
        System.out.println(player1.getName() + "'s Deck:");
        player1.getPlayerDeck().printDeck();

        System.out.println("\n" + player2.getName() + "'s Deck:");
        player2.getPlayerDeck().printDeck();
    }
}


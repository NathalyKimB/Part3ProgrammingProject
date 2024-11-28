import java.util.Scanner;

public class WarGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the name of Player 1: ");
        String player1Name = scan.nextLine();
        System.out.print("Enter the name of Player 2: ");
        String player2Name = scan.nextLine();

        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);

        Deck mainDeck = new Deck();
        mainDeck.shuffle();
        mainDeck.shuffle();
        mainDeck.shuffle();

        for (int i = 0; i < 27; i++) {
            player1.getPlayerDeck().addToDeck(mainDeck.dealCard());
            player2.getPlayerDeck().addToDeck(mainDeck.dealCard());
        }

        System.out.println("\nGame Start!");
        printPlayerDecks(player1, player2);

        Deck tablePile = new Deck(54); 

        while (true) {
            if (player1.getPlayerDeck().getNumCards() == 0) {
                System.out.println(player1.getName() + " is out of cards!");
                System.out.println(player2.getName() + " wins the game!");
                break;
            }

            if (player2.getPlayerDeck().getNumCards() == 0) {
                System.out.println(player2.getName() + " is out of cards!");
                System.out.println(player1.getName() + " wins the game!");
                break;
            }

            System.out.println("\n" + player1.getName() + ", press Enter to reveal your card.");
            scan.nextLine();
            Card card1 = player1.getPlayerDeck().dealCard();
            System.out.println(player1.getName() + " drew: " + card1);

            System.out.println(player2.getName() + ", press Enter to reveal your card.");
            scan.nextLine();
            Card card2 = player2.getPlayerDeck().dealCard();
            System.out.println(player2.getName() + " drew: " + card2);

            tablePile.addToDeck(card1);
            tablePile.addToDeck(card2);

            while (card1.getValue() == card2.getValue() || (card1.getSuit() == 5 && card2.getSuit() == 5)) {
                System.out.println("It's a tie! Adding cards to the table pile and drawing again.");

                tablePile.addToDeck(player1.getPlayerDeck().dealCard());
                tablePile.addToDeck(player2.getPlayerDeck().dealCard());

                System.out.println(player1.getName() + ", press Enter to reveal another card.");
                scan.nextLine();
                card1 = player1.getPlayerDeck().dealCard();
                System.out.println(player1.getName() + " drew: " + card1);

                System.out.println(player2.getName() + ", press Enter to reveal another card.");
                scan.nextLine();
                card2 = player2.getPlayerDeck().dealCard();
                System.out.println(player2.getName() + " drew: " + card2);

                tablePile.addToDeck(card1);
                tablePile.addToDeck(card2);
            }

            System.out.println("\nShuffling " + player1.getName() + "'s deck...");
            player1.getPlayerDeck().shuffle();
            player1.getPlayerDeck().shuffle();

            System.out.println("Shuffling " + player2.getName() + "'s deck...");
            player2.getPlayerDeck().shuffle();
            player2.getPlayerDeck().shuffle();

            printPlayerDecks(player1, player2);
        }

        scan.close();
    }

    private static void printPlayerDecks(Player player1, Player player2) {
        System.out.println(player1.getName() + "'s Deck: " + player1.getPlayerDeck().getNumCards() + " cards");
        System.out.println(player2.getName() + "'s Deck: " + player2.getPlayerDeck().getNumCards() + " cards");
    }

    private static void transferTablePile(Deck tablePile, Player winner) {
        while (tablePile.getNumCards() > 0) {
            winner.getPlayerDeck().addToDeck(tablePile.dealCard(0));
        }
        System.out.println(winner.getName() + " collects all the cards on the table!");
    }
}


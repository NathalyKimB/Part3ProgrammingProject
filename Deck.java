/*Jacob almeida
 * Section #: 00002
 */
public class Deck {
  private Card[] deck;
  private int numCards;

  public Deck() {
      deck = new Card[54];
      numCards = 54;
      int index = 0;
      for (int i = 1; i <= 4; i++) {
          for (int j = 1; j <= 13; j++) {
              deck[index++] = new Card(i, j);
          }
      }
      deck[52] = new Joker(14);
      deck[53] = new Joker(14);
  }

  public Deck(int size) {
      deck = new Card[size];
      numCards = 0;
  }

  public void addToDeck(Card card) {
      if (numCards < deck.length) {
          deck[numCards] = card;
          numCards++;
      } else {
          System.out.println("Deck is full, cannot add more cards.");
      }
  }

  public void shuffle() {
      for (int i = deck.length - 1; i > 0; i--) {
          int rand = (int) (Math.random() * (i + 1));
          Card temp = deck[i];
          deck[i] = deck[rand];
          deck[rand] = temp;
      }
  }

  public Card dealCard(int index) {
    if (index >= 0 && index < numCards) {
        return deck[index];
    } else {
        System.out.println("Invalid card index.");
        return null;
    }
}

public Card dealCard() {
    if (numCards > 0) {
        Card topCard = deck[numCards - 1];
        deck[numCards - 1] = null; 
        numCards--; 
        return topCard;
    } else {
        System.out.println("Empty deck.");
        return null;
    }
}

public void printDeck() {
    if (numCards == 0) {
        System.out.println("Empty deck.");
    } else {
        for (int i = 0; i < numCards; i++) {
            System.out.println(deck[i]);
        }
    }
}    
public int getNumCards() {
    return numCards;
}

public int getSize() {
    return deck.length;
    }
}


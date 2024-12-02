/*Nathaly Kim Barinotto
 * Section #: 00002
 */
public class Card{
    protected int suit;
    protected int value;
    
    public Card(int suit, int value){
        this.value = value;
        this.suit = suit;
    }
    public int getValue(){
        return value;
    }
    public int getSuit(){
        return suit;
    }
    public String getSuitAsString(){
        switch(suit){
            case 1:
               return "Spades";
            case 2:
                return "Hearts";
            case 3:
                return "Diamonds";
            case 4:
                return "Clubs";       
        }
        return "invaled suit";
    } 
    public String getValueAsString(){
        switch(value){
            case 1:
                return "Ace";
            case 2: 
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";  
        }
        return "invaled value";
    }
    public String toString(){
        return getValueAsString() + " of " + getSuitAsString();
    }
}


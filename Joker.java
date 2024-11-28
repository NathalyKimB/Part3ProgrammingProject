/*Jacob almeida
 * Section #: 00002
 */
public class Joker extends Card{

    public Joker(int valueJoker){
        super(5, valueJoker);
    }

    public String getValueAsString(){
        return "" + value;
    }

    public String getSuitAsString(){
        return "joker" ;
    }
}


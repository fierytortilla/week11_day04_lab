import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> cards;
    private boolean winner;

    public Player(String name){
        this.name= name;
        cards= new ArrayList<Card>();
    }

    public void receiveCard(Card card){
        this.cards.add(card);
    }

    public int showCardValue(){
        return this.cards.get(this.cards.size()-1).getValueFromCard();
    }

    public void winsGame(){
        this.winner= true;
    }

    public void losesGame(){
        this.winner= false;
    }

    public boolean getGameStatus(){
        return this.winner;
    }


    public String getName() {
        return this.name;
    }
}

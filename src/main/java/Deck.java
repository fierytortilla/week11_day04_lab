import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;

    public Deck(){
        this.cards= new ArrayList<Card>();
    }

    public ArrayList<Card> getCards(){
        return this.cards;
    }

    public void fillDeck(){
        for(Suit suit: Suit.values()){
            for(Rank rank: Rank.values()){
                Card card= new Card(suit, rank);
                this.cards.add(card);
            }
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(this.cards);
    }

    public Card dealFromDeck(){
        Random r= new Random();
        int low= 0;
        int high= this.cards.size()-1;
        int randomCardIndex= r.nextInt(high-low)+low;
        return this.cards.remove(randomCardIndex);
    }

    public void playRound(Player player1, Player player2){
        player1.receiveCard(this.dealFromDeck());
        player2.receiveCard(this.dealFromDeck());
    }

    public boolean playGame(Player player1, Player player2){
        this.playRound(player1, player2);
        boolean gameStillPlaying= true;
        while(gameStillPlaying && this.cards.size()>1){
            if(player1.showCardValue()> player2.showCardValue()){
                player1.winsGame();
                player2.losesGame();
                gameStillPlaying= false;
            } else if(player1.showCardValue()< player2.showCardValue()){
                player2.winsGame();
                player1.losesGame();
                gameStillPlaying= false;
            } else {
                this.playRound(player1, player2);
            }
        }
        return false;
    }
}

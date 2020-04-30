import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PlayerTest {
    private Player player1;
    private Player player2;
    private Player player3;
    private Deck deck;

    @Before
    public void before(){
        deck= new Deck();
        deck.fillDeck();
        deck.shuffleDeck();
        player1= new Player("Jamie");
        player2= new Player("Jim Bob");
    }

    @Test
    public void playGame(){
        assertEquals(false, deck.playGame(player1, player2));
    }
}

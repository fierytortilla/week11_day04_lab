import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DeckTest {
    private Deck deck;

    @Before
    public void before(){
        deck= new Deck();
    }

    @Test
    public void testInitialDeck(){
        assertEquals(0, deck.getCards().size());
        deck.fillDeck();
        assertEquals(52, deck.getCards().size());
    }

    @Test
    public void testShuffling(){
        deck.fillDeck();
        Card card1= new Card(Suit.HEARTS, Rank.ACE);
        Card card2= new Card(Suit.DIAMONDS, Rank.KING);
        assertEquals(card1.getSuit(), deck.getCards().get(0).getSuit());
        assertEquals(card1.getRank(), deck.getCards().get(0).getRank());
        assertEquals(card2.getSuit(), deck.getCards().get(deck.getCards().size()-1).getSuit());
        assertEquals(card2.getRank(), deck.getCards().get(deck.getCards().size()-1).getRank());
        deck.shuffleDeck();
        assertNotEquals(card1.getRank(), deck.getCards().get(0).getRank());
        assertNotEquals(card2.getRank(), deck.getCards().get(deck.getCards().size()-1).getRank());
    }

    @Test
    public void dealCardFromDeck(){
        deck.fillDeck();
        deck.shuffleDeck();
        Card randomCard= deck.dealFromDeck();
        assertEquals(51, deck.getCards().size());
    }

}

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class CardGame {
  public static void main(String[] args) {

    // Create a full deck
    // Use set to get exclusive cards
    CardDeck myDeck = new CardDeck();
    myDeck.shuffleDeck();
    CardHand hand1 = new CardHand();

    System.out.println(myDeck);
    System.out.println();
    System.out.println(hand1);
    System.out.println();
    hand1.drawFromDeck(myDeck, 5);
    System.out.println(hand1);
    System.out.println();
    System.out.println(myDeck);

  }
}

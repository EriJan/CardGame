import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class CardGame {
  public static void main(String[] args) {

    // Create a full deck
    // Use set to get exclusive cards
    Set<PlayingCard> fullDeck = new HashSet<PlayingCard>();
    for (Suit suit : Suit.values()) {
      for (int i = 1; i <=13; i++) {
        fullDeck.add(new PlayingCard(suit,i));
      }
    }

    System.out.println("Printing the full deck from HashSet. Probably shuffled.");
    System.out.println();

    // Print full deck
    for (PlayingCard card : fullDeck) {
      System.out.println(card);
    }

    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println("Printing a sorted version of the deck.");

    // Copy back to new array list
    // Sort the deck
    List<PlayingCard> sortedDeck = new ArrayList<PlayingCard>(fullDeck);
    Collections.sort(sortedDeck);
    for (PlayingCard card : sortedDeck) {
      System.out.println(card);
    }

  }
}

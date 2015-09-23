import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class CardGame {
  public static void main(String[] args) {

    // Create a full deck
    List<PlayingCard> fullDeck = new ArrayList<PlayingCard>();
    for (Suit suit : Suit.values()) {
      for (int i = 1; i <=13; i++) {
        fullDeck.add(new PlayingCard(suit,i));
      }
    }

    // Print full deck
    for (PlayingCard card : fullDeck) {
      System.out.println(card);
    }

    System.out.println();
    System.out.println();
    System.out.println();

    // Copy deck to HashSet
    // Will be shuffled because of how HashSet works
    Set<PlayingCard> shuffledDeck = new HashSet<PlayingCard>(fullDeck);
    for (PlayingCard card : shuffledDeck) {
      System.out.println(card);
    }
    System.out.println();
    System.out.println();
    System.out.println();

    // Copy back to new array list
    // Sort the deck
    List<PlayingCard> copiedDeck = new ArrayList<PlayingCard>(shuffledDeck);
    Collections.sort(copiedDeck);
    for (PlayingCard card : copiedDeck) {
      System.out.println(card);
    }

  }
}

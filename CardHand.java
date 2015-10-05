package CardGame;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class CardHand {
  protected List<PlayingCard> hand;

  // Default hand size 5
  CardHand() {
    hand = new ArrayList<PlayingCard>();
  }

  public void drawFromDeck(CardDeck deck, int noOfCards) {
    for (int i = 0; i < noOfCards; i++) {
      hand.add(deck.drawTop());
    }
  }

  public PlayingCard discardCard(int cardNo) {
    return hand.remove(cardNo);
  }

  public void sortHand() {
    Collections.sort(hand);
  }

  public int getHandSize() {
    return hand.size();
  }

  int getHandValue() {
    int handValue = 0;
    for (PlayingCard card : hand) {
      handValue += card.getValue();
    }
    return handValue;
  }


  @Override
  public String toString() {
    String handStr = "";
    for (PlayingCard card : hand) {
      handStr = handStr + card.toString() + " ";
    }
    return handStr;
  }
}

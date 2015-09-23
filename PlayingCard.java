// This class describes a standard playing card.
// Uses the enum Suit for the suit of each card
// implements the Comparable interface and overrides
// equals, sorted and compareTo for sorting purposes
// NOT FIXED:
// CHECK FOR VALID CARD value
// compareTo is not 100% complying to standard
// NO hashCode method implemented

class PlayingCard implements Comparable<PlayingCard> {

  private Suit suit;
  private int value;

  PlayingCard(Suit suit, int val) {
    this.suit = suit;
    this.value = val;
  }

  PlayingCard(Suit suit, String val) {
    this.suit = suit;
    this.value = Integer.parseInt(val);
  }

  PlayingCard(Suit suit, char val) {
    this.suit = suit;
    if (val == 'J') {
      this.value = 11;
    } else if (val == 'Q') {
      this.value = 12;
    } else if (val == 'K') {
      this.value = 13;
    } else if (val == 'A') {
      this.value = 1;
    } else {
      this.value = Character.getNumericValue(val);
    }
  }

  @Override
  public boolean equals(Object aCard) {
    PlayingCard card = (PlayingCard) aCard;
    boolean isEq = false;
    if (this == card) {
      isEq = true;
    } else if (card.getValue() == this.value && card.getSuit() == this.suit) {
      isEq = true;
    }
    return isEq;
  }

  // To be able to call Collections.sort(collection)
  // on a collection of this object
  // This method is necessary
  @Override
  public int compareTo(PlayingCard card) {
    int compRes;
    if (this.equals(card)) {
      compRes = 0;
    } else if (this.suit == card.getSuit()) {
      compRes = this.value - card.getValue();
    } else {
      compRes = this.suit.value - card.getSuit().value;
    }
    System.out.println(compRes);

    return compRes;
  }

  @Override
  public String toString() {
    String valString;

    switch (value) {
      case 1:
        valString = "Ace";
        break;
      case 11:
        valString = "Jack";
        break;
      case 12:
        valString = "Queen";
        break;
      case 13:
        valString = "King";
        break;
      default:
        valString = Integer.toString(value);
        break;
      }

      return valString + " of " + suit;
  }

  int getValue() {
    return this.value;
  }

  Suit getSuit() {
    return this.suit;
  }

}

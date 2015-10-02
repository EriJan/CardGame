// This class describes a standard playing card.
// Uses the enum Suit for the suit of each card
// implements the Comparable interface and overrides
// equals, sorted and compareTo for sorting purposes
// NOT FIXED:
// CHECK FOR VALID CARD value
// compareTo is not 100% complying to standard
// NO hashCode method implemented

class PlayingCard implements Comparable<PlayingCard> {

  private final Suit suit;
  private final int value;
  private boolean faceUp;

  PlayingCard(Suit suit, int val) {
    this.suit = suit;
    this.value = val;
    faceUp = false;
  }

  PlayingCard(Suit suit, String val) {
    this.suit = suit;
    this.value = Integer.parseInt(val);
    faceUp = false;
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
    } else if (Character.isDigit(val)) {
      this.value = Character.getNumericValue(val);
    } else {
      this.value = 0;
      System.out.println(val + " does not seem to be a valid chatacter or vaue.");
    }
    faceUp = false;
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
    return compRes;
  }

  @Override
  public String toString() {
    String valString;

    if (faceUp) {
      switch (value) {
        case 1:
          valString = "A";
          break;
        case 11:
          valString = "J";
          break;
        case 12:
          valString = "Q";
          break;
        case 13:
          valString = "K";
          break;
        default:
          valString = Integer.toString(value);
          break;
        }
      valString = suit + valString;
    } else {
      valString = "––";
    }
    return suit + valString;
  }

  public void turnUp() {
    faceUp = true;
  }

  public void turnDown() {
    faceUp = false;
  }

  public boolean isFaceUp() {
    return faceUp;
  }

  public int getValue() {
    return value;
  }

  public Suit getSuit() {
    return suit;
  }
}

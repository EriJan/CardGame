// Used of standard 52 card playing deck. Suit values
// will set sort order.
public enum Suit {
    Clubs(1), Diamonds(2), Hearts(4), Spades(3);

    public final int value;

    Suit(int val) {
      value = val;
    }
}

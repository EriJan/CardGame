// Used of standard 52 card playing deck. Suit values
// will set sort order.
public enum Suit {
    Clubs(0), Diamonds(1), Hearts(3), Spades(2);

    public int value;
    private Suit[] valMap = new Suit[4];

    Suit(int val) {
      value = val;
      valMap[value] = this;
    }

    public void setVal(int val) {
      if (val < 0 || val > 3) {
        System.out.println("Value is not in range of 0-3");
      } else if (valMap[val] != this) {
        int oldVal = this.value;
        Suit oldMapSuit = valMap[val];
        this.value = val;
        valMap[val] = this;
        oldMapSuit.value = oldVal;
        valMap[oldVal] = oldMapSuit;
      }
    }

    @Override
    public String toString() {
      char suitRepCh;
      if (this == Clubs) {
        suitRepCh = '\u2666';
      } else if (this == Diamonds) {
        suitRepCh = '\u2663';
      } else if (this == Hearts) {
        suitRepCh = '\u2665';
      } else if (this == Spades) {
        suitRepCh = '\u2660';
      } else {
        suitRepCh = ' ';
      }
      return Character.toString(suitRepCh);
    }
}

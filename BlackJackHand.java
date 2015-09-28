import java.util.Scanner;

public class BlackJackHand extends CardHand {
  BlackJackHand() {
    super();
  }

  boolean isBlackJack() {
    boolean blackJack = false;
    if (getHandSize() == 2) {
      PlayingCard[] handArr = (PlayingCard[]) hand.toArray();
      if ((handArr[0].getValue() == 1 && handArr[1].getValue() >= 10) ||
           handArr[1].getValue() == 1 && handArr[0].getValue() >= 10) {
          blackJack = true;
       }
     }
     return blackJack;
  }

  public int youHaveAnAce () {
    int aceVal = 0;
    Scanner userInput = new Scanner(System.in);
    System.out.println("What is the value of this ace?");
    String usrInputStr = userInput.next();
    if (usrInputStr.equals("1")) {
      aceVal = 1;
    } else {
      aceVal = 11;
    }
    return aceVal;
  }

  @Override
  int getHandValue() {
    int handValue = 0;
    for (PlayingCard card : hand) {
      int cardValue = card.getValue();
      if (cardValue == 1) {
        handValue += youHaveAnAce();
      } else if (cardValue < 10) {
        handValue += cardValue;
      } else {
        handValue += 10;
      }
    }
    return handValue;
  }
}

package CardGame;



import java.util.Scanner;

public class the21  extends CardGame {
	  CardDeck deck;
	  Player player1,player2;
	  the21Hands[] playersHands;
	private String val;

	  the21() {	 
		  deck.shuffleDeck();			  
		  player2 = new Player("PC");
	  }

	  @Override
	  public void runGame() {
		  Methods.printSlowly("* The  Game 21 *");	
		  Methods.printSlowly("* * * * * * * * * * * * * * * * * * * *\n");
		  Methods.printSlowly(" Player enter your name : ");
		  player1 = new Player(Methods.inPutFromNextLine());	
		 
		  while(playersHands[0].isCardToTake() && !playersHands[0].isTjock() && !val.equalsIgnoreCase("N")){
				
			  playersHands[0].drawFromDeck(deck, 1);	
				
				System.out.format("%s, Your cards :\n%s", player1.getName(), playersHands[0].toString());
				
				System.out.println("totally: " + playersHands[0].getHandValue());
				
				if(playersHands[0].isCardToTake() && !playersHands[0].isTjock()){
					System.out.println("vill du ha ett till ? (J/N): ");
					val = Methods.inPutFromNextLine();//�nskades flera kort?	
				}
			}
		  
		  if(!playersHands[0].isTjock()){
				
				System.out.format("nu e' det %s: s tur %n", player2.getName());
				val = "J";
				
				while(playersHands[1].isCardToTake() && !playersHands[1].isTjock() && !val.equalsIgnoreCase("N") && !playersHands[0].isTjock()){
					playersHands[1].drawFromDeck(deck, 1);
					Methods.printSlowly( String.format("%s, (Dealers cards) :\n%s", player2.getName(), playersHands[1].toString() ) );
					
					System.out.println("totally: " + playersHands[1].getHandValue());
					
					if(playersHands[1].getHandValue()<=14 || (playersHands[1].getHandValue() < playersHands[0].getHandValue()) ){
						val = "J";								
					}else{
						val = "N";
					}
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
				Methods.printSlowly( String.format("Result is: %n" ));
				//System.out.println("Resultat:");

				System.out.println(player1.getName() + " : " + playersHands[0].getHandValue());
				System.out.println(player2.getName() + " : " + playersHands[1].getHandValue());
				}  
		  if ( (playersHands[0].isTjock()) 
					|| ((playersHands[0].getHandValue() < playersHands[1].getHandValue())  && !playersHands[1].isTjock()) ) {
				System.out.format("%s vann!! ", player2.getName());
				
			}else if ( (playersHands[1].getHandValue() < playersHands[0].getHandValue() ) || playersHands[1].isTjock() ) {
				System.out.format("%s vann!! ", player1.getName());
			}
			else if ( (playersHands[1].getHandValue() == playersHands[0].getHandValue() ) && ! playersHands[0].isTjock() ) {
				//System.out.format("OAVGJORT!! ");
				System.out.format("%s vann!! ", player2.getName());
			}
		  
		  
	  }
	  
	  

	  // newGame
	  // initialDeal
	  // resolvePostition
	  // resolveHouse
	  // isBust
	  // isBlackJack
	  // handValue
	  //

	}

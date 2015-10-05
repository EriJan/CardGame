package CardGame;

import java.util.Scanner;

public class the21Hands extends CardHand {
	private int summa;

	the21Hands() {
		    super();
		  }

	public boolean isTjock() {
		//kortIHand [0] till 2...
		if(getHandValue()>=22){
			return true;
		}		
		return false;
	}

//	public int getResultat() {		
//		return summa;
//	}

		public int youHaveAnAce () {
		    int aceVal = 0;
		    
		    
		    
		    return aceVal;
		  }

		@Override
		int getHandValue() {
			PlayingCard card1 = hand.get(0);
			PlayingCard card2 = hand.get(1);
			PlayingCard card3 = hand.get(2);
			
			int evTempEss1 = card1.getValue();
			int evTempEss2 = card2.getValue();
			int evTempEss3 = card3.getValue();
			
			summa = card1.getValue() + card2.getValue() + card3.getValue();
			
			if(card1.getValue() == 1){
				evTempEss1 = 14;			
			}
			if(card2.getValue() == 1){
				evTempEss2 = 14;		
			}
			if(card3.getValue() == 1){
				evTempEss3 = 14;		
			}
			
			if( (card1.getValue() == card2.getValue() || card1.getValue() == card3.getValue()) && (card1.getValue() == 1) ){
				//aj aj vi har ju 2 ess  i DENNA VERSION, sätter vi Ett av dessa till 1
				//ex om vi har kung ess ess = föst 10 + 14+ 14, sedan 
				//nu 10 + 14+ 1
				//det andra kontrolleras senare..
				evTempEss1 = 1;
			}
			else if ((card2.getValue() == card3.getValue()) && (card2.getValue() ==1)){
				evTempEss2 = 1;
			}
			//nu har vi endast EN 14 om vi hade fler tidigare...
			//evTempEss3 om alla var ess..
			int temtexxtestsumm = evTempEss1 + evTempEss2 + evTempEss3;
			//System.out.println("temtexxtestsumm : " + temtexxtestsumm);
			if( temtexxtestsumm <= 21 ){ //OM SUMMAN Ã„R UNDER 22..
				summa = evTempEss1 + evTempEss2 + evTempEss3;
				//detta ï¿½r den absolut stï¿½rsta vï¿½rdet vi kan ha..
				 // vi vet ï¿½ven att det ev bara ï¿½r EN som ï¿½r 14
			}
			else{
				//nej om man anvï¿½nde Ess son 14 sï¿½ fick man 21 eller ï¿½ver..
				//suck nu blev det jobbigt..
				//nu vill vi fï¿½ ut det stï¿½rsta vï¿½rdet..
				if( evTempEss1 == 14){
					evTempEss1 = 1;
					summa = evTempEss1 + evTempEss2 + evTempEss3;
					// System.out.println("evTempEss-3: " + evTempEss1 + " "+  evTempEss2 + " "+ evTempEss3 );
					//System.out.println("summa3: " + summa);
				}else if( evTempEss2 == 14){
					evTempEss2 = 1;
					summa = evTempEss1 + evTempEss2 + evTempEss3;
					// System.out.println("evTempEss-4: " + evTempEss1 + " "+  evTempEss2 + " "+ evTempEss3 );
					// System.out.println("summa4: " + summa);
				}else if( evTempEss3 == 14){
					evTempEss3 = 1;
					// System.out.println("evTempEss-5: " + evTempEss1 + " "+  evTempEss2 + " "+ evTempEss3 );
					
					summa = evTempEss1 + evTempEss2 + evTempEss3;
					// System.out.println("summa5: " + summa);
				}//ja nu kan det vara sï¿½ att summan ï¿½r 21 men vi kan inte fï¿½ "lï¿½gre"..
			
		}
			return summa;

		
		}
		
		  
		public boolean isCardToTake() {
			if (getHandSize() >= 3) {
				return false;
			}
			return true;
		}
		}

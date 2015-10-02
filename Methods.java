package CardGame;

import java.util.Scanner;

public class Methods {
	public static String inPutFromNextLine() {
		String input= null;
		Scanner in = new Scanner(System.in);
		input = in.nextLine();
		return input;
	}

public static void printSlowly(String text) {//skriver ut texter långsamt ut en string..
	try {
        for (char character : text.toCharArray()) {
            System.out.print(character);  // skriver varje char (i introText)
            
            if ( character != ' ' ){ //om det inte vara var ett mellanslag!
            	Thread.sleep(50);  // vänta lite tills nästa.. (skapar en tråd och väntar liiite)
            }//annars väntar vi inte...
        }
    } catch (InterruptedException e) {//om tråden blir fel eller liknande
    	System.out.println(text);//skriv ut som vanligt instället..
    }
	}

public static void printSlowly(String text, int mSecondsDelay) {//skriver ut texter långsamt ut en string..
	try {
        for (char character : text.toCharArray()) {
            System.out.print(character);  // skriver varje char (i introText)
            
            if ( character != ' ' ){ //om det inte vara var ett mellanslag!
            	Thread.sleep(mSecondsDelay);  // vänta lite tills nästa.. (skapar en tråd och väntar liiite)
            }//annars väntar vi inte...
        }
    } catch (InterruptedException e) {//om tråden blir fel eller liknande
    	System.out.println(text);//skriv ut som vanligt instället..
    }
	}

/**
 * @param menyElements
 * @return the name of the selected option 
 * 	  switch (Methods.choseFromMeny("TestGame,BlackJack,Patians,21")) {
	case "TestGame":
		System.out.println("Run the testgame");
		break;

	default:
		System.out.println("do nothing..");
		break;
		
	} 
 */
public static String choseFromMeny(String menyElements) {
	
	
	
	String[] menyElements_ = menyElements.split(",");
	StringBuilder sb = new StringBuilder(
			      "*********** Chose ***********\n");
	for(int i = 0; i< menyElements_.length; i++){
		sb.append(" "
				+ (i+1) + " : " + menyElements_[i] + "\n");
	}
	sb.append("*****************************\n");	
	printSlowly(sb.toString());
	String choice;
	do{
		System.out.println("chose:");
		choice = inPutFromNextLine();
	}while ( (Integer.parseInt(choice)<0) && (!choice.matches("-?\\d+(\\.\\d+)?")|| ((Integer.parseInt(choice)-1) > menyElements_.length)) );
	
	
	return menyElements_[(Integer.parseInt(choice)-1)];
}

}

package CardGame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class PlayServer {
		private static final String NEW_LINE = "<LineB>";
		private static int trys = 0;
		static URL file;
		public static String getStatusFromGameFile(String game){
			StringBuilder stb;
			String data = "";
			setUrl(game);
			do {
			stb = getFromFile();
			trys++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {			
			}
		} while (stb.toString().equalsIgnoreCase("false") && !(trys>=  30));
			//det kan inträffa att man får error 500 i dropbox , detta är en dropbox bugg jag slet med..

		System.out.println("number of try's = " + trys);
		
		data = stb.toString();
		return data;
		}
		
		
		public static boolean setStatusToGameFile(String game, String newData[]){
			StringBuilder stb = new StringBuilder("");
			String oldData = "";
			oldData = getStatusFromGameFile(game);	
			String updatedData;
			
			String[] dataAr = oldData.split(NEW_LINE);
			
			for (int i = 0 ; i < dataAr.length ; i++){				
				if (dataAr[i].equals(newData[0])){
					for (int j = 0 ; j < newData.length ; j++){
						dataAr[i] = newData[j];
					}					
				}				
			}
			
			//man har nu ersatt ramen för spelaren men ny info
			
			for (int i = 0 ; i < dataAr.length ; i++){
				stb.append(dataAr[i]);
				stb.append(NEW_LINE);
			}
			
			updatedData = stb.toString(); //nu har vi allt i en string
			
			//sedan skall man skriva till filen ?
			//dvs skriva över innehållet med  stringen: updatedData
			//ev genom att först "mellanlanda lokant" i en txt-fil, men detta är ju jobbigt!
			//om man misslyckas att skriva returneras false, och detta kors ex 30 ggr innan man ger upp..
		
		return true;
		}
		
		
		
		
		private static void setUrl(String game) {
			try {
				switch (game) {
				case "the21":
					file = new URL("https://www.dropbox.com/s/yzyo45zpws2mljm/the21.txt?raw=1");
					break;
					
				case "Blackjack":
					file = new URL("https://www.dropbox.com/s/xuq63faz21ijr1r/Blackjack.txt?raw=1");
					break;

				case "Chicago":
					file = new URL("https://www.dropbox.com/s/a140gk6gt9dkmfm/Chicago.txt?raw=1");
					break;
					
				case "Patians":
					file = new URL("https://www.dropbox.com/s/2q67678yai0r68m/Pasians.txt?raw=1");
					break;
					
				default://"testGame"
					file = new URL("https://www.dropbox.com/s/g1hz653z3tgp1qu/TestGame.txt?raw=1");
					break;
				}
			} catch (MalformedURLException e1) {			
				e1.printStackTrace();
			} 
			
		}

		private static StringBuilder getFromFile() {
			StringBuilder stb;
		try {		
			BufferedReader in = new BufferedReader(new InputStreamReader(
					file.openStream()));

			String inputLine = null;
			stb = new StringBuilder("");
			while ((inputLine = in.readLine()) != null) {
				stb.append(inputLine);
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("bummer");
			stb = new StringBuilder("");
			stb.append("false");
			return stb;
		}
		return stb;
	}
		
}
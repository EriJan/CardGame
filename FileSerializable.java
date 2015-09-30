import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;




public class FileSerializable implements Serializable {

	
	File fileTxt = new File("PlayerText.txt"); // Skapar en fil
	File fileBin = new File("PlayerBinary.txt"); 
	PrintWriter output; //Den klass som används för att skriva till fil
	Scanner scanFile; //Den klass som används för att läsa från fil
	FileOutputStream fOutput; //Strömmande output som skriver ett objekt till binär fil (serialiserar)
	ObjectOutputStream oOutput; //Klass som används för att skriva objekt till binär fil
	FileInputStream fInput; //  //Strömmande input som läser ett objekt från binär fill (deserialiserar)
	ObjectInputStream oInput; //Klass som används för att läsa ett objekt från binär fil
	ArrayList<Player> players; 

	public void writeToFile(String name, int points) throws IOException { //exceptions måsta användas i en try/catch när metoden anropas
		try {
			output = new PrintWriter(fileTxt);
			output.println(name + " " + points);
			output.close(); //Objekt av klasser som öppnar filer måste efter öppnadet stängas
		} catch (IOException e) { //Inte nödvändigt att använda exceptions här om det kastas uppe vid metodhuvudet
			System.out.println("Något har blvit fel. " + e);
		}
	}

	public String readFromFile() throws FileNotFoundException {
		String str = "";
		try {
			scanFile = new Scanner(fileTxt);
			String name = scanFile.nextLine();
			String points = scanFile.nextLine();
			str = "" + name + " " + points + " ";

		} catch (FileNotFoundException e) {
			System.out.println("Något har blivit fel. " + e);
		}
		return str;
	}

	public void serializeObjectToBinaryFile(ArrayList<Player> players) throws IOException {
		fOutput = new FileOutputStream(fileBin);
		oOutput = new ObjectOutputStream(fOutput);
		for (Player s : players) {
			oOutput.writeObject(s);
		}
		fOutput.close();
		oOutput.close();

	}

	public ArrayList deSerializeObjectFromBinaryFile() throws IOException, ClassNotFoundException {
		players = new ArrayList<Player>();
		fInput = new FileInputStream(fileBin);
		oInput = new ObjectInputStream(fInput);
		try {
			while (true) {
				Player p = (Player) oInput.readObject(); //Metoden readObject returerar ett object som sen måste castas om till det ett object av rätt klass
				players.add(p);
			}
		} catch (EOFException ex) {//Ett End of file exception som bryter while när det inte längre finns några objekt

		}

		return players;

	}
	
	public void printSerializedListOfObject(ArrayList<Player> players){
		for (Player q : players){
			System.out.println(q);
		}
	
	}

}


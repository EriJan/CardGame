public class Player implements java.io.Serializable {

	static int numberOfPlayers_;

	private String name_;
	private int win_;
	private int loss_;
	private int numberOfMovesPerGame_;
	private int numberOfGames_;

	public Player() {
		addNumberOfPlayers(); //Alltså, kanske inte helt lyckat? Måste väl i så fall ta bort spelare från listan?
								//Tänkte att man (när jag förstår hur det funkar helt och hållet) kan koppla antaletSpelare
								//till en funktion i FileSerializable så att man från en binär fil kan utläsa hur många
								// Player det finns totalt
	}

	public Player(String name) {
		name_ = name;
		addNumberOfPlayers();
	}

	public String getName() {
		return name_;
	}

	public String toString() {

		return name_;
	}

	public void setWin(int add) {
		win_ += add;
	}

	public int getWin() {
		return win_;
	}

	public void setLoss(int add) {
		loss_ += add;
	}

	public int getLoss() {
		return loss_;
	}

	public void setNumberOfGames(){
		numberOfGames_ += 1;
	}

	public int getNumberOfMovesPerGame(){
		return numberOfMovesPerGame_ /= numberOfGames_;
	}

	private static void addNumberOfPlayers(){
		numberOfPlayers_ += 1;
	}
}

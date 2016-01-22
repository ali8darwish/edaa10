public class Card {
	public static final int SPADES = 1; //Spader
	public static final int HEARTS = SPADES + 1; //Hj�rter
	public static final int DIAMONDS = SPADES + 2; //Ruter
	public static final int CLUBS = SPADES + 3; //Kl�ver
	private int rank; // Skapar val�r
	private int suit; // Skapar f�rg

	/**
	 * Skapar ett spelkort med f�rgen suit (SPADES, HEARTS, DIAMONDS, CLUBS) och
	 * val�ren rank (1-13)
	 */
	public Card(int suit, int rank) {
		this.suit = suit; //Tilldelar f�rg
		this.rank = rank; //Tilldelar val�r
	}

	/** Tar reda p� f�rgen */
	public int getSuit() {
		return suit;
	}

	/** Tar reda p� val�ren */
	public int getRank() {
		return rank;
	}

	/** Returnerar en l�sbar representation av kortet, t ex "spader ess" */
	public String toString() {
		String suitString = "";
		switch (suit) {
		case SPADES:
			suitString = "spader";
			break;
		case HEARTS:
			suitString = "hj�rter";
			break;
		case DIAMONDS:
			suitString = "ruter";
			break;
		case CLUBS:
			suitString = "kl�ver";
			break;
		}
		String rankString = "";
		switch (rank) {
		case 1:
			rankString = "ess";
			break;
		case 11:
			rankString = "knekt";
			break;
		case 12:
			rankString = "dam";
			break;
		case 13:
			rankString = "kung";
			break;
		default:
			rankString = String.valueOf(rank);
		}
		return suitString + " " + rankString;
	}
}
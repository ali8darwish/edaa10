public class TestCardDeck {
	/** Program f�r att testa metoderna i klassen CardDeck */
	public static void main(String[] args) {
		CardDeck deck = new CardDeck(); //Skapar en kortlek
		System.out.println("Oblandad kortlek:"); //Skriver ut texten
		while (deck.moreCards()) {
			Card c = deck.getCard(); //H�mtar kort
			System.out.print(c + " ");
		} // Skriver ut korten
		System.out.println();
		System.out.println();
		System.out.println("Blandad kortlek:"); //Skriver ut texten
		int[] suitVect = new int[4]; // Antal spader, hj�rter etc
		int[] rankVect = new int[13]; // Antal 1:or, 2:or etc
		deck.shuffle(); //Blandar kortleken
		while (deck.moreCards()) {
			Card c = deck.getCard(); //H�mtar kort
			suitVect[c.getSuit() - Card.SPADES]++;
			rankVect[c.getRank() - 1]++;
			System.out.print(c + " "); //Skriver ut korten
		}
		System.out.println();
		System.out.println();
		System.out.print("Antal kort i de olika f�rgerna: "); //Skriver ut texten
		for (int i = 0; i <= 3; i++) { //
			System.out.print(suitVect[i] + " "); //Skriver ut vilken f�rg kortet har
		}
		System.out.println();
		System.out.print("Antal kort i de olika val�rerna: "); //Skriver ut texten
		for (int i = 0; i <= 12; i++) {
			System.out.print(rankVect[i] + " "); //Skriver ut vilken val�r kortet har
		}
		System.out.println();
	}
}
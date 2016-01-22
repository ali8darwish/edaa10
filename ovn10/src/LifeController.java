public class LifeController {

	public static void main(String[] args) {
		LifeBoard board = new LifeBoard(20, 20);
		LifeView window = new LifeView(board);

		// ritar board
		window.drawBoard();

		// variabel som kollar commander
		int commander = 0;

		// Life objekt som ska styra Life-sakerna

		Life life = new Life(board);

		while (true) {
			/* best�mmer vad som h�nder beroende p� vilket v�rde commander har. */

			commander = window.getCommand();

			if (commander == 1) {
				// genom klick �ndrar s� individer lever/d�r

				life.flip(window.getRow(), window.getCol());

			} else if (commander == 2) {

				life.newGeneration();
				// n�sta generation

			} else if (commander == 3) {

				System.exit(0);
				// kollar om vi trycker p� "quit"
			}

			window.update();
		}
	}
}
public class Life {
	private LifeBoard board;

	Life(LifeBoard board) {

		this.board = board; // Spara board
	}

	public void newGeneration() {

		board.increaseGeneration();

		int neighbours = 0; // counter

		boolean[][] temp = new boolean[board.getRows()][board.getCols()];
		/*
		 * temp matris som sparar n�sta gen. detta f�r vi inte kan g�ra
		 * �ndringar samtidigt som vi r�knar m�ste r�kna allas grannar innan det
		 * f�ds/d�r.
		 */

		// Loopar genom hela matrisen
		for (int row = 0; row < board.getRows(); row++) {
			for (int col = 0; col < board.getCols(); col++) {

				// kolla antalet grannar p� plats (row, col).
				neighbours = getNeighbours(row, col);

				// Om individen �r levande:
				if (board.get(row, col) == true) {

					// Denna kollar - individ levande:
					// om grannar < 2 eller >= 4 s� d�r man!
					if (neighbours < 2 || neighbours >= 4) {
						temp[row][col] = false;
					} else {
						// annars ska individen forts�tta leva!
						temp[row][col] = true;
					}

				} else {
					// Rutan �r d�d fr�n b�rjan

					// Om grannar �r exakt 3 st.
					if (neighbours == 3) {
						temp[row][col] = true;
					}
				}

			}
		}
		// uppdatera board med den nya matrisen
		board.matris = temp;
	}

	private int getNeighbours(int row, int col) {

		int neighbours = 0; // R�kna grannar!

		// yttre Loopen, Loopar raderna
		for (int r = row - 1; r <= row + 1; r++) {

			// Inre loop. Loopar kolonnerna
			for (int c = col - 1; c <= col + 1; c++) {

				// H�r inne kollar vi om det finns en granne.
				// Om granne finns - uppdatera

				// Vill inte r�kna med sig sj�lv. Hoppa �ver
				if (r == row && c == col) {
					continue;
				}

				if (board.get(r, c) == true) {
					neighbours++;
				}
			}
		}

		return neighbours;
	}

	/*
	 * flippar v�rdet p� plats (row, col) om true -> false om false -> true
	 */
	public void flip(int row, int col) {

		if (board.get(row, col) == true) {

			board.put(row, col, false);

		} else {

			board.put(row, col, true);
		}

	}

}
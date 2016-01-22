public class LifeBoard {

	private int generation;
	private int rows;
	private int cols;
	public boolean[][] matris;

	/**
	 * Skapar en spelplan med rows rader och cols kolumner. Spelplanen �r fr�n
	 * b�rjan tom, dvs alla rutorna �r tomma och generationsnumret �r 1.
	 */
	public LifeBoard(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		matris = new boolean[rows][cols];
		generation = 1;
	}

	/**
	 * Ger true om det finns en individ i rutan med index row, col, false
	 * annars. Om index row, col �r utanf�r spelplanen returneras false
	 */
	public boolean get(int row, int col) {

		if (row >= rows || col >= cols || col < 0 || row < 0) {
			return false;
		}
		if (matris[row][col] == true) {
			return true;
		} else {
			return matris[row][col];
		}
	}

	/** Lagrar v�rdet val i rutan med index row, col */
	public void put(int row, int col, boolean val) {

		matris[row][col] = val;
	}

	/** Tar reda p� antalet rader */
	public int getRows() {

		return rows;
	}

	/** Tar reda p� antalet kolumner */
	public int getCols() {

		return cols;
	}

	/** Tar reda p� aktuellt generationsnummer */
	public int getGeneration() {

		return generation;
	}

	/** �kar generationsnumret med ett */
	public void increaseGeneration() {

		generation++;
	}
}
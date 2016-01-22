import java.awt.Color;

public class Generator {
	private int pixelSize = 1; // Standarduppl�sning
	private int MAX_ITER = 200; // H�gsta antalet iterationer
	private int count = 0; // R�knare f�r absolutbeloppet

	/** Ritar en bild i f�nstret i anv�ndargr�nssnittet gui */
	public void render(MandelbrotGUI gui) {
		gui.disableInput(); // G�r att knapparna i
		// anv�ndargr�nssnittet inte reagerar p� tryck och
		// att ber�kningarna inte st�rs av att anv�ndaren
		// g�r operationer i f�nstret.

		// Anropar mesh f�r att skapa matrisen med komplexatal.
		Complex[][] complex = mesh(gui.getMinimumReal(), gui.getMaximumReal(),
				gui.getMinimumImag(), gui.getMaximumImag(), gui.getWidth(),
				gui.getHeight());

		Color[] colorScale = new Color[MAX_ITER + 1];

		// Ber�knar f�rgen f�r varje iteration
		for (int i = 0; i < MAX_ITER; i++) {
			colorScale[i] = new Color(i + 1, i, i + 50);

		}

		switch (gui.getResolution()) {
		case MandelbrotGUI.RESOLUTION_VERY_HIGH: // 1x1
			pixelSize = 1;
			break;
		case MandelbrotGUI.RESOLUTION_HIGH: // 3x3
			pixelSize = 3;
			break;
		case MandelbrotGUI.RESOLUTION_MEDIUM: // 5x5
			pixelSize = 5;
			break;
		case MandelbrotGUI.RESOLUTION_LOW: // 7x7
			pixelSize = 7;
			break;
		case MandelbrotGUI.RESOLUTION_VERY_LOW: // 9x9
			pixelSize = 9;
			break;
		}

		// Skapar matrisen som inneh�ller bildpunkterna som ska ritas.
		Color[][] picture = new Color[gui.getHeight() / pixelSize][gui
				.getWidth() / pixelSize];

		for (int i = 0; i < complex.length / pixelSize; i++) {
			for (int j = 0; j < complex[i].length / pixelSize; j++) {
				Complex c = complex[i * pixelSize + pixelSize / 2][j
						* pixelSize + pixelSize / 2];
				Complex z = new Complex(0, 0);

				while (count < MAX_ITER && z.getAbs2() <= 4) {
					z.mul(z);
					z.add(c);
					count++;
				}

				// Programmet i f�rg eller i svartvitt.
				switch (gui.getMode()) {
				case MandelbrotGUI.MODE_COLOR:
					if (count < MAX_ITER) {
						picture[i][j] = colorScale[count];
					} else {
						picture[i][j] = Color.MAGENTA;
					}
					break;
				case MandelbrotGUI.MODE_BW:
					if (z.getAbs2() <= 4) {
						picture[i][j] = Color.BLACK;
					} else {
						picture[i][j] = Color.WHITE;
					}
				}
				count = 0;
			}
		}
		// N�r varje element har f�tt en f�rg ritas bilden med putData i
		// MandelbrotGUI.
		gui.putData(picture, pixelSize, pixelSize);
		gui.enableInput(); // �terst�ller funktionen hos
							// anv�ndargr�nssnittets
							// knappar.
	}

	/**
	 * Skapar en matris d�r varje element �r ett komplext tal som har r�tt
	 * koordinater
	 */
	private Complex[][] mesh(double minRe, double maxRe, double minIm,
			double maxIm, int width, int height) {

		// Generera komplexa tal till matrisen.
		Complex[][] mesh = new Complex[height][width];

		for (int i = 0; i < mesh.length; i++) {
			for (int j = 0; j < mesh[i].length; j++) {
				double x = minRe + (-minRe + maxRe) / (width - 1) * j;
				double y = maxIm - (-minIm + maxIm) / (height - 1) * i;
				mesh[i][j] = new Complex(x, y);
			}
		}
		return mesh;
	}
}

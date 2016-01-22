import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Register {
	private ArrayList<Book> reg; // registret skall lagras i en ArrayList

	/** Skapar ett tomt register */
	public Register() {
		reg = new ArrayList<Book>();
	}

	/** S�tter in boken bok sist i Registret reg */
	public void addBook(Book bok) {
		reg.add(bok);
	}

	/** Tar bort alla b�cker av en viss f�rfattare author */
	public void removeAuthor(String author1) {
		for (int i = 0; i < reg.size(); i++) {
			if (reg.get(i).getAuthor().equals(author1)) {
				reg.remove(i);
			}
		}
	}

	/**
	 * S�ka upp alla b�cker som g�ller f�r en viss f�rfattare. Det skall r�cka
	 * att man anger en del av f�rfattarnamnet. Samtliga b�cker vars f�rfattare
	 * passar in skall presenteras med b�de f�rfattare och titel.
	 */
	public String print() {

		StringBuilder B = new StringBuilder();
		for (int i = 0; i < reg.size(); i++) {
			String author = reg.get(i).getAuthor();
			String title = reg.get(i).getTitle();
			B.append(author + "      " + "\n" + title + "\n");
		}
		return B.toString();
		// Skriver ut listan med hj�lp av stringbuilder, tar reda p� author och
		// title . skriver ut de sen med append.
	}

	public String searchAuthor(String author) {

		StringBuilder B = new StringBuilder();
		for (int i = 0; i < reg.size(); i++) {
			if (reg.get(i).getAuthor().indexOf(author) >= 0) {
				B.append(reg.get(i).getAuthor() + "      " + "\n"
						+ reg.get(i).getTitle() + "\n");
			}

		}
		return B.toString();
	}

	// Skapa en Stringbuilder, en for sats som g�r genom array. Om namnen skulle
	// finnas s� l�gger den till det
	//

	public String searchTitle(String title) {

		StringBuilder B = new StringBuilder();
		for (int i = 0; i < reg.size(); i++) {
			if (reg.get(i).getTitle().equals(title)) {
				B.append(reg.get(i).getAuthor() + "      " + "\n"
						+ reg.get(i).getTitle() + "\n");
			}

		}
		return B.toString();
	}

	public void sortByAuthor() {
		int a;
		for (int t = 0; t < reg.size(); t++) {
			a = 0;
			for (int i = 0; i < reg.size(); i++) {
				if (reg.get(t).getAuthor().toLowerCase()
						.compareTo(reg.get(i).getAuthor().toLowerCase()) > 0) {
					// tar f�rsta namnet i array o j�mf�r med alla namn i array.
					// Varje g�ng namnen skulle f� ett v�rde mindre �n 0 �kar a.
					a++;
				}
			}

			Book b = reg.get(a);
			reg.set(a, reg.get(t));
			reg.set(t, b);
			// Swap d�r Namn p� plats a blir tempor�r.Sedan s�tt namnen som gick
			// genom f�rst o l�ggs p� plats a
			// . D�refter s�tts tempor�ra namnet p� den plats d�r namnet t
			// befann sig.
			// sedan resettas a och loopen g�r genom igen f�r andra namnen tills
			// array e slut.
		}

	}

	public void sortByTitle() {
		int j;
		for (int x = 0; x < reg.size(); x++) {
			j = 0;
			for (int i = 0; i < reg.size(); i++) {
				if (reg.get(x).getTitle().compareTo(reg.get(i).getTitle()) > 0) {
					j++;
				}
			}
			Book b = reg.get(j);
			reg.set(j, reg.get(x));
			reg.set(x, b);
		}
	}

	// ... Konstruktor och alla metoderna f�r registerhanteringen

	/** L�ser registret fr�n filen med namn fileName. */
	public void readFromFile(String fileName) {
		// ... Se ledning f�r filhanteringen sist i uppgiften

		Scanner scan = null; // scanner objekt

		// Kollar om filen g�r att �ppna. Om inte skriver ut fel och avlslutar
		// programmet
		try {
			scan = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.err.println("Filen kunde inte �ppnas");
			System.exit(1);
		}

		// Hj�lp variabler f�r f�rfattare och titel
		String author;
		String title;

		// Loopa genom hela filen. S�l�nge som hasNext() == true -> finns mer
		// att l�sa ur filen.
		while (scan.hasNext()) {
			author = scan.nextLine(); // p� f�rsta raden f�rfattare
			title = scan.nextLine(); // p� andra raden titel
			Book bok = new Book (author, title);
			addBook(bok); // l�gga in bok i listan
		}

		scan.close(); // St�nga scanner
	}

	/** Sparar registret p� fil med namnet fileName. */
	public void writeToFile(String fileName) {
		// ... Se ledning f�r filhanteringen sist i uppgiften

		PrintWriter out = null; // PrintWriter objekt

		// Kolla s� filen g�r �ppna
		try {
			out = new PrintWriter(new File(fileName));
		} catch (FileNotFoundException e) {
			System.err.println("File not found.\n");
			System.exit(1);
		}

		// Hj�lpvariabel
		Book bok;

		// Loopa genom hela listan
		for (int i = 0; i < reg.size(); i++) {
			bok = reg.get(i); // plockar ut bok p� plats i
			out.println(bok.getAuthor()); // Skriver ut f�rfattare p� f�rsta
											// raden
			out.println(bok.getTitle()); // skriver ut titel p� andra raden
		}

		out.close(); // St�nger filen
	}

}

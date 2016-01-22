public class Book {
	private String title; // titel
	private String author; // f�rfattare

	/** Skapar en bok med f�rfattaren author och titeln title */
	public Book(String author, String title) {
		this.author = author;
		this.title = title;
	}

	/** Returnerar namnet p� f�rfattaren */
	public String getAuthor() {
		return author;
	}

	/** Returnerar titeln */
	public String getTitle() {
		return title;
	}

	/** Returnerar en str�ng som best�r av bokens f�rfattare och titel */
	public String toString() {
		return author + "\t" + title;
	}
}
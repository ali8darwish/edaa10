public class Main {
	public static void main(String[] args) {
		Dialog d = new Dialog();
		Register reg = new Register();
		while (true) {
			String menuItems = "Meny" + "\n"
		            + "1: S�tt in en ny bok" + "\n"
					+ "2: Tag bort b�cker" + "\n"
					+ "3: S�k titel fr�n en f�rfattare" + "\n"
					+ "4: S�k titel fr�n alla f�rfattare" + "\n"
					+ "5: Presentera alla b�cker sorterade efter f�rfattare" + "\n"
					+ "6: Presentera alla b�cker sorterade efter titel" + "\n"
					+ "7: Spara registret p� en fil" + "\n"
					+ "8: H�mta uppgifterna till registret fr�n en fil" + "\n"
					+ "0: Avsluta" + "\n";
			int a = d.readInt(menuItems);
			switch (a) {

			case 1:
				String author = "Ange f�rfattare";
				String title = "Ange boktitel";
				Book b = new Book(d.readString(author), d.readString(title));
				reg.addBook(b);
				d.printString(reg.print());

				break;
			case 2:
				String remove = "Ange f�rfattare";
				reg.removeAuthor(d.readString(remove));
				d.printString(reg.print());

				break;
			case 3:
				String author1 = "Ange f�rfattare";
				d.printString(reg.searchAuthor(d.readString(author1)));

				break;

			case 4:
				String title1 = "Ange boktitel";
				d.printString(reg.searchTitle(d.readString(title1)));
				break;

			case 5:
				reg.sortByAuthor();
				d.printString(reg.print());
				break;

			case 6:
				reg.sortByTitle();
				d.printString(reg.print());
				break;
			case 7:
				String fileName = "Ange filnamn";
				d.readString(fileName);
				reg.writeToFile(fileName);
				break;

			case 8:
				String filename = "Ange filnamn";
				d.readString(filename);

				reg.readFromFile(filename);
				break;

			case 9:
				d.printString(reg.print());
				break;
			case 0:
				System.exit(0);
				break;
			}
		}
	}
}

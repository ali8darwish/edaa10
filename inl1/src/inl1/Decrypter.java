package inl1;
import se.lth.cs.p.inl1.*; 
import se.lth.cs.p.inl1.nbr2.*;

public class Decrypter {

	public static void main(String[] args) {
		/** Skapar ett f�nster med namnet title i vilket man kan l�gga 
		 textvyer */
		Key n = new Key();
		Decryptographer d = new Decryptographer(n);
		TextWindow t = new TextWindow ("TextWindow");
		/** Skapar en textvy med rubriken headline och plats f�r rows rader 
		med text och width tecken i varje rad. 
		En textvy syns inte f�rr�n den l�ggs i ett f�nster (se addView 
		i klassen TextWindow). */
		TextView t1 = new TextView ("Klartext:", 10, 30);
		TextView t2 = new TextView ("Chiffertext:", 10, 30);
		TextView t3 = new TextView ("Min chiffertext:", 10, 30);
		/** L�gger in textvyn view nedanf�r tidigare utlagda textvyer */
		t.addView(t1);
		t.addView(t2);
		t.addView(t3);
		TestCase c = new TestCase();
		/** Skapar ett objekt med fem olika klartexter, med nr 1 till 5.
		Till varje klartext finns motsvarande chiffertext. */
		for(int k = 1; k<=5; k++){
			t.waitForMouseClick();
			t1.displayText(c.getClearText(k));
			t2.displayText(c.getCryptoText(k));
			t3.displayText(d.decrypt(c.getCryptoText(k)));
		/** V�ntar tills anv�ndaren har klickat p� en musknapp i f�nstret och visar sedan texten k i textvyn.
		Ev. tidigare inneh�ll raderas. */
		}
	
		


}
}

public class Patiens {

	public static void main(String[] args) {
		int times = 300000; //K�r 300 000 ggr
		int win = 0;
		for (int i = 0; i < times; i++){
			CardDeck deck = new CardDeck();
			deck.shuffle();
			boolean vinst = true;
			for(int x = 0; deck.moreCards(); x++){
				x = x % 3 + 1; //R�knaren g�r fr�n 1-3
				if(deck.getCard().getRank() == x){ // J�mf�r kortet med r�knaren
					vinst = false; //N�r det inte g�r ut
					
				}
			}
			if(vinst == true){ //Ifall det g�r ut
				win++;
			}
		}
		System.out.println((double)win/(double)times);
	}

}

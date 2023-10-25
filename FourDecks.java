import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;

public class FourDecks {
	
	//number of Decks can be modified by users in settings
	public static int numDecks = 4;
	final private ArrayList<String> allCards = new ArrayList<String> (Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"));
	private Stack<String> fd;
	
	public FourDecks() {
		fd = new Stack<String>();
		
	}
	
	public void ifEmpty() {
		if (fd.size()==0) {
			shuffle();
		}
		
	}
	
	private void shuffle() {
		for(int j = 0; j<numDecks; j++) {
			ArrayList<String> oneDeck = new ArrayList<String>(allCards);
			for(int i = 0; i<14; i++) {
				int rnd = (int)(Math.random() * (14-i));
				fd.push(oneDeck.get(rnd));
				oneDeck.remove(rnd);
			}
		}
	}
	
	public String getCard() {
		return fd.pop();
	}
}

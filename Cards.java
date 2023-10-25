/* 
 * Cards class handles everything that has to do with the cards.
 * hitMe() handles card drawing, returns (busted), or if it will bust after adding a new card.
 * DealerMode hitMe() auto hits until val is at least 17. P.S. BlackJack rule: dealer stop on 17.
 * Note: In GameOn if hitMe() return busted = true, then display getHand() and end the game;
 * 		 If busted = false, display getHand() and ask input for the next step is to hit or stay.
*/
import java.util.ArrayList;

public class Cards implements InterfaceCards {
	 
	 protected ArrayList<String> hand;
	 
	 protected int val = 0;
	 private boolean hasA = false;
	 
	 protected boolean busted = false;
	 
	 public Cards() {
		 hand = new ArrayList<String>();
	 }
	 
	 
	 public boolean hitMe(FourDecks fd){
		 	
		 	 fd.ifEmpty();
			 hand.add(fd.getCard());
			 calcVal();
			 ifBust();
			 
		
		 return busted;
	 }
	 
	 
	 protected void calcVal() {
		 
		 int currentVal = 0;
		 String current = null;
		 
		 for(int i=0; i<hand.size(); i++) {
			 current = hand.get(i);
			 
			 if(current.equals("1")||current.equals("2")||current.equals("3")||current.equals("4")||current.equals("5")||current.equals("6")||current.equals("7")||current.equals("8")||current.equals("9")) {
				 currentVal += Integer.parseInt(current);
			 } 
			 else if(current.equals("10") || current.equals("J") || current.equals("Q") || current.equals("K")){
				 currentVal += 10;
			 } 
			 else if(current.equals("A")) {
				 hasA = true;
				 if(currentVal + 11 > 21) {
					 currentVal +=1;
				 } else {
					 currentVal += 11;
				 }
				 
			 }
			 
			 
			 if(hasA)
				 val = reCountA(currentVal);
			 else {
				 val = currentVal;
			 }
		 }
	 }
	 
	 private int reCountA(int currentVal) {
		 int newVal=0;
		 for(String i : hand) {
			 if(i.equals("1")||i.equals("2")||i.equals("3")||i.equals("4")||i.equals("5")||i.equals("6")||i.equals("7")||i.equals("8")||i.equals("9")) {
				 newVal+=Integer.parseInt(i);
			 }
			 else if(i.equals("10")||i.equals("J")||i.equals("Q")||i.equals("K")){
				 newVal+=10;
			 }
		 }
		 
		 for(String i : hand) {
			 if(i.equals("A")){
				 if(newVal + 11 > 21) {
					 newVal += 1;
				 }
				 else {
					 newVal += 11;
				 }
			 }
		 }
		 
		 return newVal;
	 }
	 
	 protected void ifBust() {
		 if(val>21) {
			 busted = true;
		 } else {
			 busted = false;
		 }
	 }
	 
	 public int getVal() {
		 return val;
	 }
	 
	 public boolean getBusted() {
		 return busted;
	 }
	 
	 public void printHands() {
			
				System.out.print("[Player Hand]:\t - ");
				
				for(String i : hand) {
					System.out.print("\t["+i+"]");
				}
				
				System.out.println("\t- ");
	
		}
}

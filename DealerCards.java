
public class DealerCards extends Cards implements InterfaceCards{

	//Dealer automatically hits until 17
	public boolean hitTo17(FourDecks fd) {
		 while(val<17) {
			 hitMe(fd);
		 }
		 
		 return busted;
	 }
	
	//Derivation of Cards.printHands; if hideSecond = true; then the 2nd card will be hidden
	public void printHands(boolean hideSecond) {
			
			if(hideSecond){
				System.out.print("[Dealer Hand]:\t - ");
				System.out.print("\t[" + hand.get(0) + "]\t[*]");
			}
			else
			{
				System.out.print("[Dealer Hand]:\t - ");
				
				for(String i : hand) {
					System.out.print("\t["+i+"]");
				}
				
			}
			
				System.out.println("\t- ");
	
		}
}

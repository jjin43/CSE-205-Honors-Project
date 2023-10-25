import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		
		//pick a card
		int choice = 0;
		Scanner in = new Scanner(System.in);
		
		do {
			System.out.println();
			printMenu();
			choice = in.nextInt();
		
			switch(choice) {
				case 1:
					System.out.println("\t***** NEW GAME *****");
					GameOn game= new GameOn();
					break;
					
				case 2:
					settingsMenu();
					break;
					
				case 3:
					tutorialMenu();
					break;
					
				case 4:
					System.out.println("\t***** Program Closing *****");
					in.close();
					break;
					
				default:
					System.out.println("\t***** Invalid Response, Please Enter a Valid Option: [1-4] *****");
					break;
					
				
			}		
		
		}while(choice != 4);
	}
	
	
	public static void printMenu(){
		System.out.println("\t[Black Jack]");
		System.out.println("  1. Start Game");
		System.out.println("  2. Settings");
		System.out.println("  3. Tuotorial");
		System.out.println("  4. Quit");
	}
	
	public static void tutorialMenu() {
		//WIP- fill in instructions...
		System.out.println("\t***** Tutorial *****");
		System.out.println("Black Jack is a casino game where the player draws cards to reach as close to 21 as possible, but not over.");
		System.out.println("Number cards have their according value, where Face cards all worth 10,");
		System.out.println("Aces can be used as a 1 or 11, depending which puts you closer to 21 but not over.");
		System.out.println("Both the player and the house starts with 2 cards, where one of the House's card is hidden");
		System.out.println("Unless the House draws a Black Jack out right where the player instantly loses,");
		System.out.println("Player can chooses to \"Hit or Stay\", based on their knowledge on the dealer's hand");
		System.out.println("After the player busts or stays, the houses reveals the hidden card,");
		System.out.println("and draws untill the cards value reaches 17, remeber that the house can bust too, where the player wins regardless.");
		System.out.println("The player starts with an amount of chips that's modifiable in the settings, the number of Decks used each game is also modifiable.");
		System.out.println("Before each round, the player has to bet an amount of chips,");
		System.out.println("If the player wins the round, they will win that amount of chips,");
		System.out.println("If the player loses, then they will lose that amount of chips");
		System.out.println("The game is over when the player loses all chips, or when the player indicates to quit after a round");
		System.out.println("Where then the game will show the # of rounds played, and the final amount of chips");
		System.out.println("P.S. Since the cards are randomly choosen, it's equivalent to an infinite deck Black Jack game, making card counting impossible");
		
	}
	
	public static void settingsMenu() {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println();
		System.out.println("[Player] Current # of Chips:\t" + GameOn.defaultPlayerChips);
		System.out.println("1. Modify player starting chips amount");
		System.out.println("2. Modify the number of Decks used per game");
		System.out.println("3. Back");
		
		int select = in.nextInt();
		
		switch(select) {
		case 1:
			System.out.println("[Player] Current # of Chips:\t" + GameOn.defaultPlayerChips);
			System.out.print("Enter new amount of starting chips: ");
			int input = in.nextInt();
			GameOn.defaultPlayerChips = input;
			System.out.println("Changes Saved Successfully:\t" + GameOn.defaultPlayerChips);
			System.out.println();
			break;
			
		case 2:
			System.out.println("[Decks] Numbers of Decks currently used each game:\t" + FourDecks.numDecks);
			System.out.println("Enter the # of Decks used each game;");
			int input2 = in.nextInt();
			FourDecks.numDecks = input2;
			System.out.println("Changes Saved Successfully:\t" + FourDecks.numDecks);
			System.out.println();
			break;
			
		case 3:
			System.out.println("\t***** Returning to Main Menu *****");
			break;
			
		default:
				System.out.println("\t***** Invalid Response, please Enter [1-2] *****");

		}
	}
	

}

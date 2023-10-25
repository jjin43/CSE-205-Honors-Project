/*
 * GameOn handles all win conditions and in-game displays.
 * player wins if wins over all of dealer's chips, loses if loses all chips to dealer.
 */

import java.util.ArrayList;
import java.util.Scanner;
public class GameOn {
	
	public static int defaultPlayerChips = 5000;
	
	private int playerChips;
	private int round = 1;
	private int bets = 0;
	private FourDecks fd = new FourDecks();
	Scanner in = new Scanner(System.in);
	
	
	public GameOn() {
		playerChips = defaultPlayerChips;
		boolean gameOver = false;
		
		do {
			//start new round
			bets = 0;
			boolean playerWon = false;
			boolean tied = false;
			
			System.out.println("\t***** Round " + round + " *****");

			while(bets<=0 || bets>playerChips) {
				try {
					System.out.println("[Current Chips Amount]: "+ playerChips);
					System.out.print("Enter Bet Amount: ");
					bets = Integer.parseInt(in.next());
					if(bets<=0 || bets>playerChips) {
						System.out.println("\t***** Invalid Amount, Please Enter a positive # less than Current Chips *****");
					}
				}
				catch(RuntimeException e) {
					System.out.println("\t***** Invalid Input, Please Enter a positive # less than Current Chips *****");
				}
			}
			System.out.println();
			DealerCards dHand = new DealerCards();
			Cards pHand = new Cards();
			
			//dealer first gets 2 cards, if dealer hand = 21 then bad luck, player loses
			dHand.hitMe(fd);
			dHand.hitMe(fd);
			pHand.hitMe(fd);
			pHand.hitMe(fd);
			if(dHand.getVal()==21) {
				dHand.printHands(false);
				pHand.printHands();
				playerWon = false;
				if(pHand.getVal()==21) {
					tied = true;
					System.out.println("\t***** Woah! Double Black Jack Draw! -TIED- *****");
				}
				else {
					System.out.print("\t**** Unfortunate! Dealer first draws Black Jack! -HOUSE WINS- *****");
				}
			}
			else {
				//Player turn starts;
				dHand.printHands(true);
				pHand.printHands();
				boolean pBust = false;
				boolean pCont = true;
				//Player can Hit or Stay, drawing continues until bust or Stay.
				do {
					System.out.print("Hit or Stay? [H/S]: ");
					String choice = in.next();
					System.out.println();
					switch(choice) {
					
					case "H","h":
						pBust = pHand.hitMe(fd);
						dHand.printHands(true);
						pHand.printHands();
						break;
						
					case "S","s":
						pCont = false;
						break;
						
					default:
						System.out.println("\t*** Invalid Response, Please enter [H/S] ***");
						
					}
				}
				while(!pBust && pCont);
				//Player turn over ^^^
				
				//Dealer finish drawing

				System.out.println();
				System.out.println("\t****** [Dealer] Drawing: house stays on -17- *****");
				dHand.hitTo17(fd);
				dHand.printHands(false);
				pHand.printHands();
				
				//Calculate who wins.
				if(pHand.getBusted()) {
					System.out.println("\t***** Player Busted! -House WINS- *****");
				}
				else if(dHand.getBusted()) {
					System.out.println("\t***** House Busted! -PLAYER WINS- *****");
				}
				else if(!pHand.getBusted() && (pHand.getVal() > dHand.getVal())) {
					//player won, pHand > dHand val;
					playerWon = true;
					if(pHand.getVal()== 21) 
						System.out.println("***** Black Jack! -Player Wins- *****");
					else
						System.out.println("\t***** Player Hand Greater! -PLAYER WINS- *****");
					
				} else if(!pHand.getBusted() && (pHand.getVal() == dHand.getVal())) {
					//player won, pHand == dHand val, ties;
					playerWon = false;
					tied = true;
					System.out.println("\t***** Equal Hands! -TIED- *****");
					
				}
				else {
					//pHand < dHand, then player loses
					playerWon = false;
					System.out.println("\t***** House Hand Greater! -HOUSE WINS- *****");
				}
				
			}
			
			//adding or subtracting the bets
			if(playerWon) {
				//player won, chips + bets
				
				System.out.println("[Player Chips]: " + playerChips + " + " + bets + " = " + (playerChips+bets));
				playerChips += bets;
			}
			else {
				if(tied) {
					//player tied, no chips loss
					System.out.println("[Player Chips]: " + playerChips + " + " + "0" + " = " + playerChips);
				}
				else {
					//player loss, chips - bets
					System.out.println("[Player Chips]: " + playerChips + "-" + bets + "=" + (playerChips-bets));
					playerChips -= bets;
				}
			}
			
			System.out.println();
			System.out.println("\t***** Round " + round +" Over *****");
			
			if(playerChips <= 0) {
				System.out.println("\t***** Out of Chips, Game Over *****");
				gameOver = true;
			}
			else {
				System.out.print("[Continue?] [Y/N]:");
				String choice = in.next();
				System.out.println();
				switch(choice) {
				
				case "Y","y":
					break;
				
				case "N","n":
					gameOver = true;
					System.out.println("\t***** Player Quits, Game Over *****");
					System.out.println("[Round]: " + round);
					System.out.println("[Score/Chips]: "+ playerChips);
					System.out.println("\t***** Returning to Main Menu *****");
					System.out.println();
					break;
				
					default:
						System.out.println("\t***** Invalid input, please enter [Y/N] *****");
				}
			}
			
			round++;
		} while(!gameOver);
		
	}
	
	
}

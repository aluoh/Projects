import java.util.Random;
import java.util.Scanner;

public class BlackJack {

	public int playerHand = 0;
	public int dealerHand = 0;
	public static final int BLACKJACK = 21;
	public String moveChoice;
	private boolean dealerStays;
	private boolean blackJack = false;
	
	
	Random random = new Random();
	
	
	public void move() {
		while(!blackJack) {
			
			Scanner scan = new Scanner(System.in);
			
			int moveChoice = scan.nextInt();
			if(moveChoice == 1) {
				System.out.println(hit());
			
			}else if(moveChoice == 2) {
				System.out.println(stay());
				
			}
			if(playerHand == BLACKJACK || dealerHand == BLACKJACK)
			{
				System.out.println("BLACKJACK! You have: " + playerHand + "\nDealer has: " + dealerHand);
				blackJack = true;
			}
			
			if(playerHand > BLACKJACK && dealerHand < BLACKJACK) {
				if (dealerHand != playerHand) 
				System.out.println("Game Over! You Lost.\nThe Dealer's hand was: " + dealerHand);
				break;
			}
			
			else if (moveChoice == 2 && dealerStays)
			{
				if(dealerHand > playerHand)
				{
					System.out.println("\nDealer's hand has: " + dealerHand + "\nYour hand has: " + playerHand + "\nDealer has won!");
					break;
				}
				
				else if (dealerHand == playerHand) {
					System.out.println("TIE GAME!");
					break;
				}
				else 
				{
					System.out.println("\nYour hand has: " + playerHand + "\nDealer hand has: " + dealerHand + "\nYou won!");
					break;
				}
			}
			
			else if(dealerHand > BLACKJACK) {
				System.out.println("The dealer busted with a hand of " + dealerHand + ". You Win!");
			}
		}

	}
	
	public String hit() {
	int card = random.nextInt(11) + 1;
	int card2 = random.nextInt(11) + 1;
		playerHand += card;
		if(dealerHand < 20) { 
			dealerHand += card2;
		}
		else {
			dealerStays = true;
		}
		return "You drew a: " + card + "\nYour hand: " + playerHand + "\nDealer's hand: " + dealerHand;		
	}

	public String stay() {
		if(dealerHand < 18) {
			int card = random.nextInt(11) + 1;
			dealerHand = dealerHand + card;
		}
		else {
			dealerStays = true;
		}
		return "Your hand is at: " + playerHand + "\nDealer's hand is at: " + dealerHand;
	}
	

	public static void main(String[] args) {
		BlackJack m = new BlackJack();
		System.out.println("Hit 1 to draw and 2 to stay");
		
		m.move();

	
	}
}

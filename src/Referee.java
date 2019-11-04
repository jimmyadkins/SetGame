import java.util.Scanner;

public class Referee {
	private Board myBoard;
	private Deck myDeck;
	private Scanner scan;
	boolean playing;

	public Referee() {

		myDeck = new Deck();
		myBoard = new Board(myDeck);
		scan = new Scanner(System.in);
	}

	public void playGame() {

		System.out.println("Great! Here are the rules: Find three cards that either share all features but one, or find three cards that share exactly 0 features.");
		System.out.println("Now, type each number corresponding to each card that you think makes a set. Remember to type them in separate lines.");
		playing = true;
		while (playing) {
			System.out.println();
			System.out.println(myBoard.toString());
			System.out.println("If you want to choose a set, type 'set'. If you want to quit, type 'quit'. If you want to deal 3 more cards, type 'deal'.");
			String choice = scan.nextLine();
			if (!choice.equals("set") || !choice.equals("quit") || !choice.equals("deal")) {
				boolean retry = true;
				while (retry) {
					System.out.println("We didn't catch that, please try again.");
					choice = scan.nextLine();
					if (choice.equals("set") || choice.equals("quit") || choice.equals("deal")) {
						retry = false;
					}
				}
			}
			if (choice.equals("quit"))
			{
				playing = false;
				break;
			}
			else if (choice.equals("deal"))
			{
				if (myBoard.getNumCardsOnBoard() < 15) {
					System.out.println("Dealing three cards...");
					myBoard.dealThreeCards(myDeck);
				} else if (myBoard.getNumCardsOnBoard() == 15) {
					System.out.println("There are already 15 cards in play!");
				} else if (myDeck.outOfCards()) {
					System.out.println("There are no more cards in the deck!");
				}
			}
			else if (choice.equals("set")) {
				System.out.println("Which cards make a set?");
				int card1 = scan.nextInt() - 1;
				int card2 = scan.nextInt() - 1;
				int card3 = scan.nextInt() - 1;
				if (myBoard.isLegal(card1, card2, card3)) {
					System.out.println("Good job- that's a set!");
					myBoard.remove3Cards(card1, card2, card3);
					myBoard.dealThreeCards(myDeck);
				} else {
					System.out.println("That isn't a set! Try again.");
				}

			}
		}
	}
}


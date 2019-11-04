import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

/**
 * The Referee class keeps track of a Board, which in turn 
 * holds a Deck of Cards. The Referee is responsible for communicating 
 * the player and the board to make sure that the board is displayed 
 * regularly, the user is asked for "SET"s of cards, and the board is
 * consulted on whether the user is correct before removing them.
 * If the board is empty, or the player gives up, the player can play again.
 * Advanced: if the player is stumped with 12 cards, give him/her the
 * chance to add three more cards.
 */
public class Referee {

	// TODO: decide which private member variables the Referee class needs and declare them here.
	private Board myBoard;
    private Deck myDeck;
	private Scanner scan;
	boolean playing;


	/**
	 * constructor
	 */
	// TODO: write the Referee's constructor method.
	public Referee() {

        myDeck = new Deck();
		myBoard = new Board(myDeck);
		scan = new Scanner(System.in);
	}

	
	/**
	 * playGame - the main game loop for the program.
	 */
	public void playGame()
	{

		System.out.println("Great! Here are the rules: Find three cards that either share all features but one, or find three cards that share exactly 0 features.");
		System.out.println("Now, type each number corresponding to each card that you think makes a set. Remember to type them in separate lines.");
		System.out.println("If there isn't a set, or you just give up, type '0' for each line to get 3 cards added and an option to end the game. The maximum amount of cards allowed at once is 15.");
		playing = true;
		while (playing)
		{
					System.out.println();
					System.out.println(myBoard.toString());
					System.out.println("Which cards make a set?");
						int card1 = scan.nextInt()-1;
						int card2 = scan.nextInt()-1;
						int card3 = scan.nextInt()-1;
					if (card1 == -1 && card2 == -1 && card3 == -1) {
						if (myBoard.getNumCardsOnBoard() < 15) {
							System.out.println("Dealing three cards...");
							myBoard.dealThreeCards(myDeck);
						} else if (myBoard.getNumCardsOnBoard() == 15) {
							System.out.println("There are already 15 cards in play!");
						} else if (myDeck.outOfCards()) {
							System.out.println("There are no more cards in the deck!");
						}
						System.out.println("Would you like to keep playing?");
						boolean choosing = true;
						while (choosing) {
							String choice = scan.nextLine();
							if (choice.equals("no"))
							{choosing = false;
								playing = false;
								break;}
							 else if (choice.equals("yes")) {
								System.out.println("Great!");
								choosing = false;
							}
						}
					}
					else if (myBoard.isLegal(card1,card2,card3))
					{
						System.out.println("Good job- that's a set!");
						myBoard.remove3Cards(card1,card2,card3);
						myBoard.dealThreeCards(myDeck);

					}
					else
					{
						System.out.println("That isn't a set! Try again.");
					}

				}
			}
	}


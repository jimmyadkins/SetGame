import java.util.Scanner;

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
	private Scanner keyReader;
	private boolean isSet;
	private Card myCard;


	/**
	 * constructor
	 */
	// TODO: write the Referee's constructor method.
	public Referee() {

		myDeck = Deck.makeDeck();
		myBoard= new Board();
		keyReader = new Scanner(System.in);
	}


	
	/**
	 * playGame - the main game loop for the program.
	 */
	public void playGame()
	{
		// TODO: write the Referee's playGame method.
		//
		boolean gameIsStillPlaying = true;

		System.out.println("Playing game."); // placeholder code
	}
}

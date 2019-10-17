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
	=
	
	/**
	 * playGame - the main game loop for the program.
	 */
	public void playGame()
	{
		// TODO: write the Referee's playGame method.
		//deal deck of cards
		boolean gameIsStillPlaying = true;
			while(gameIsStillPlaying)
			{
				for (int i=0; i<12; i++)
				{
					myDeck.dealCard();
				}
				System.out.println("The cards on the board are "+displayedCards);
			}

        //ask player if there is a set
        //if there is set, and player determines set
                //give them point
        //if there is a set, but player does not see set
                //tell player there is a set and to keep looking
        //if there is no set, and player sees set
                //tell player no set and deal 3 cards
        // if there is no set, and player sees no set
               //deal 3 cards





		boolean gameIsStillPlaying = true;

		System.out.println("Playing game."); // placeholder code
	}
}

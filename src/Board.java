/**
 * the Board class holds and displays 12 - 15 cards. (Typically,
 * it holds 12, but if the player is stumped, they can deal 3 more - this
 * is an advanced feature, so don't worry about it at first.)
 * Cards are selected in groups of three - if they form a "SET," they are
 * removed from the board and another three cards are automatically 
 * dealt into the vacated spots.
 */
public class Board {

	Card[] displayedCards;

	/**
	 * constructor - set up the board's variables, including dealing 12 cards.
	 */

	Board(Deck d)
	{
		displayedCards = new Card[15];
		for (int i = 0; i <= 12; i++)
		{
			displayedCards[i] = d.dealCard();
		}
		for (int i = 12; i < 15; i++)
		{
			displayedCards[i] = null;
		}

		//--------------------
		// fill the first 12 slots with cards from the deck.
		// leave the last 3 as null for now.
		// DONE: Insert your code here.

	}
	
	/**
	 * getCardAtLoc - accesses the card at a given location
	 * @param loc
	 * @return a copy of the card that is stored at location loc,
	 * 			or null, if there is none there.
	 * precondition: loc is a valid location from 0-14, inclusive.
	 */
	public Card getCardAtLoc(int loc)
	{
		Card c = displayedCards[loc];
		//--------------------
		// DONE: Insert your code here
		//--------------------
		return c;
	}


	/**
	 * isLegal - determines whether the three cards at the given locations
	 * are a "SET."/ alternately, use a small array.
	 * @return whether (true/false) these cards are a "SET."
	 * A SET is formed when for each of the four categories, all the cards 
	 * are the same, or all are different. For example, here is a "SET":
	 * 0: {**} {**} {**}
	 * 1: [**] [**]
	 * 2: <**>
	 * this is a "SET" because: a) the brackets are different on all three 
	 * cards; b) the number of groups is different on all three cards; 
	 * c) the size of the groups are the same on all three cards; and d)
	 * the icon is the same on all three cards.
	 * Here's another example of a "SET":
	 * 0: {•} {•}
	 * 1: {ooo} {ooo}
	 * 2: {**} {**}
	 * In this case the brackets and number of groups are constant, but
	 * the icon and the size of the groups are all different.
	 * Here's an example of a non-"SET."
	 * 0: {o} {o}
	 * 1: <•> <•> <•>
	 * 2: [o]
	 * In this case, the group sizes are all the same, the number of groups
	 * are all different, the brackets are all different, BUT two of the
	 * cards have the icon "o" and one has the icon "•." So this is NOT a "SET."
	 * Another example of a non-"SET.":
	 * 0: {**} {**} {**}
	 * 1: {•}
	 * 2: <ooo> <ooo>
	 * In this case, it is the bracket types that fail; there are two cards with
	 * curly brackets and one with angle brackets.
	 * Note: If you are given the same card twice (or three times), it is illegal.
	 * Note: If any of the cards are null, it is illegal.
	 */
	public boolean isLegal(int loc1, int loc2, int loc3)
	{
		Card a = getCardAtLoc(loc1);
		Card b = getCardAtLoc(loc2);
		Card c = getCardAtLoc(loc3);

		boolean legal = false;
		//--------------------
		// Hint: there is a fancy math trick for making this work, involving
		//       factors of 3. You should not need a ton of "if" statements!!!!
		//       See me if you have questions.
		// DONE: insert your code here.
		boolean iconLegal = false;
		boolean sizeLegal = false;
		boolean numberLegal = false;
		boolean bracketLegal = false;

		int iconTotal = a.getIcon() + b.getIcon() + c.getIcon();
		if (iconTotal%3 == 0)
		{
			iconLegal = true;
		}
		int sizeTotal = a.getSize() + b.getSize() + c.getSize();
		if (sizeTotal%3 == 0)
		{
			sizeLegal = true;
		}
		int numberTotal = a.getNumber() + b.getNumber() + c.getNumber();
		if (numberTotal%3 == 0)
		{
			numberLegal = true;
		}
		int bracketTotal = a.getBracket() + b.getBracket() + c.getBracket();
		if (bracketTotal%3 == 0)
		{
			bracketLegal = true;
		}
		if (iconLegal && sizeLegal && numberLegal && bracketLegal)
		{
			legal = true;
		}
		//--------------------
		return legal;
	}
	
	/**
	 * dealThreeCards - if there are fewer than 15 cards on the board,
	 * and if there are still cards in the deck, deal three cards from
	 * the deck and put them into the first three locations that contain
	 * null.
	 */
	public void dealThreeCards(Deck d)
	{

		if (getNumCardsOnBoard() < 15)
		{
			if (!d.outOfCards())
			{
				for(int i=0; i<15; i++)
				{

						if (displayedCards[i] == null) {
							displayedCards[i] = d.dealCard();

					}
				}
			}
		}

		
		//--------------------
	}
	
	/**
	 * remove3Cards - removes three cards from the board by replacing them with null.
	 * Optional: if there are remaining cards in locations 12, 13, or 14, move
	 * them into empty locations.
	 * If there are fewer than 12 cards remaining and there are cards in the deck,
	 * fill in empty places with three cards dealt from the deck.
	 * @param cardLocation0
	 * @param cardLocation1
	 * @param cardLocation2 // alternate version: an array of locations
	 * note: no return value; only private member variables changed.
	 * prerequisite: all three locations are within 0-14, all point to non-null cards,
	 * and there are no duplicates.
	 */
	 // DONE:
	 // 1: write the remove3Cards() method signature. (i.e., return type, method name, parameter list)
	 //    MAKE SURE THAT YOU COMMUNICATE THIS WITH THE REST OF YOUR TEAM.
	 // 2: go to BoardTest.java and write a test to make sure that this is
	 //    working - Look at the test for "testGetNumCardsOnBoardAndDeal3" as an
	 //    example of what to write here.
	 // 3: write the method and make sure that it passes the test.
    public void remove3Cards(int cardLocation0, int cardLocation1, int cardLocation2)
    {
        displayedCards[cardLocation0] = null;
        displayedCards[cardLocation1] = null;
        displayedCards[cardLocation2] = null;
    }
	
	/**
	 * getNumCardsOnBoard
	 * @return the number of non-null cards on the board
	 */
	int getNumCardsOnBoard()
	{
		int numCards = 0;
		//--------------------
		// DONE: insert your code here
		for (int i=0; i<15; i++)
		{
			if (displayedCards[i] != null)
			{
				numCards++;
			}
			else
			{
				return numCards;
			}
		}

		//--------------------
		return numCards;
	}
	
	/**
	 * toString - displays the contents of the board, along with numbers (or letters)
	 * to identify the cards for the user's input.
	 * @return - a string describing the board.
	 */
	public String toString()
	{
		String result = "";
		//--------------------
		// DONE: insert your code here.
		int x = 1;
		for (int i=0; i<15; i++)
		{
			if (displayedCards[i] != null) {
				result = result + x + ". " + displayedCards[i].toString() + "\n";
			}
			else
				{
				//return result;
			}
			x++;
		}
		//--------------------

		return result;
	}
}

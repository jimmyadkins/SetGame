

/**
 * The Deck class represents a stack of cards. 
 */

 public class Deck {
 	Card[] myCards;
	private Card topCard;
	private int topLoc = 0;
	private int numCards = 0;


	/**
	 * constructor - makes a deck containing one card for every
	 * combination of features and sets the topOfDeck to the index
	 * of the last card.
	 */

	public Deck() {
		int[] num = new int[]{1, 2, 3};
		int[] size = new int[]{1, 2, 3};
		char[] icon = new char[]{'&', '@', '#'};
		int[] iconNum = new int[]{1,2,3};
		int[] bracket = new int[]{1,2,3};
		char[] bracket1 = new char[]{'<', '{', '['};
		char[] bracket2 = new char[]{'>', '}', ']'};

		this.myCards = new Card[81];
		int index = 0;
		for (int iconNumber = 0; iconNumber < icon.length; ++iconNumber) {
			for (int bracketNum = 0; bracketNum < bracket1.length; ++bracketNum) {
				for (int sizeNum = 0; sizeNum < icon.length; ++sizeNum) {
					for (int numNum = 0; numNum < num.length; ++numNum) {
						this.myCards[index] = new Card(icon[iconNumber], iconNum[iconNumber], num[numNum], size[sizeNum], bracket[bracketNum], bracket1[bracketNum], bracket2[bracketNum]);
						System.out.println();
						System.out.println(this.myCards[index].toString());
						System.out.println();
						index++;
					}
				}
			}
		}

		shuffle();
	}

	public int getNumCards()
	{
		numCards = 0;
		for (int i=0; i<81; i++)
		{
			if (this.myCards[i] != null)
			{
				numCards++;
			}
			else{return numCards;}
		}
		return numCards;
	}

	private int getTopLoc()
	{
		for (int i = 0; i <81; i++)
		{
			if (this.myCards[i] != null || i == 81)
			{
				topLoc = i-1;
			}
			else
			{
				return topLoc;
			}
		}
		return topLoc;
	}

	private Card getTopCard() {
		for (int i = 0; i < 81; i++) {
			if (this.myCards[i] != null || i == 81) {
				topCard = this.myCards[i];
			}
			else
			{
				return topCard;
			}

		}
		return topCard;
	}



	public void addCard(Card c) {
		this.myCards[getTopLoc() + 1] = c;
	}


	/**
	 * dealCard - returns the card at the "top" of the deck, moving the
	 * "top" down one.
	 * If the "top" is low enough to be past the end of the deck,
	 * then return null.
	 *
	 * @return the next card.
	 */

	public Card dealCard() {
		Card c;

		if (!this.outOfCards())
		{
			c = getTopCard();
			this.myCards[getTopLoc()] = null;
		}
		else
		{
			return null;
		}
		return c;
	}

	/**
	 * shuffle - shuffles the cards in the deck by swapping many times.
	 * resets "top of deck" to the beginning.
	 * Note: no return value; just updates private variables.
	 */

	void shuffle() {
		for (int i = 0; i < numCards * 3; ++i) {
			int a = (int) (Math.random() * (double) getNumCards());
			int b = (int) (Math.random() * (double) getNumCards());
			Card temp = this.myCards[a];
			this.myCards[a] = this.myCards[b];
			this.myCards[b] = temp;
		}
	}

	/**
	 * outOfCards - determines whether the "top of deck" has extended beyond the end of the Deck.
	 *
	 * @return - boolean; whether the top of deck is past the end of the deck
	 */

	public boolean outOfCards() {

		if (getNumCards() > 0) {
			return false;
		}
		else {
			return true;
		}
	}

}


	


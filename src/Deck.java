

/**
 * The Deck class represents a stack of cards. 
 */

public class Deck {
	Card[] Deck;
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
		Deck = new Card[81];
		myCards = new Card[81];
	}

	public static Deck makeDeck() {
		int[] num = new int[]{1, 2, 3};
		int[] size = new int[]{1, 2, 3};
		char[] icon = new char[]{'&', '@', '#'};
		int[] iconNum = new int[]{1,2,3};
		int[] bracket = new int[]{1,2,3};
		char[] bracket1 = new char[]{'<', '{', '['};
		char[] bracket2 = new char[]{'>', '}', ']'};

		Deck result = new Deck();

		for (int iconNumber = 0; iconNumber < icon.length; ++iconNumber) {
			for (int bracketNum = 0; bracketNum < bracket1.length; ++bracketNum) {
				for (int sizeNum = 0; sizeNum < icon.length; ++sizeNum) {
					for (int numNum = 0; numNum < bracket1.length; ++numNum) {
						result.addCard(new Card(icon[iconNumber], iconNum[iconNumber], num[numNum], size[sizeNum], bracket[bracketNum], bracket1[bracketNum], bracket2[bracketNum]));
					}
				}
			}
		}

		result.shuffle();

		return result;
	}

	public int getNumCards(Card x[])
	{
		numCards = 0;
		for (int i=0; i<=81; i++)
		{
			if (x[i] != null)
			{
				numCards++;
			}
			else{break;}
		}
		return numCards;
	}

	public int getTopLoc(Card x[])
	{
		for (int i = 0; i <=81; i++)
		{
			if (x[i] == null || i == 81)
			{
				topLoc = i-1;
				break;
			}
		}
		return topLoc;
	}

	public Card getTopCard(Card x[]) {
		for (int i = 0; i <= 81; i++) {
			if (x[i] == null || i == 81) {
				topCard = x[i - 1];
				break;
			}

		}
		return topCard;
	}



	public void addCard(Card c) {
		Deck[getTopLoc(Deck) + 1] = c;
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

		if (this.outOfCards())
		{
			return null;
		}
		else
		{
			c = getTopCard(Deck);
			Deck[getTopLoc(Deck)] = null;
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
			int a = (int) (Math.random() * (double) numCards);
			int b = (int) (Math.random() * (double) numCards);
			Card temp = this.Deck[a];
			this.Deck[a] = Deck[b];
			this.Deck[b] = temp;
		}
	}

	/**
	 * outOfCards - determines whether the "top of deck" has extended beyond the end of the Deck.
	 *
	 * @return - boolean; whether the top of deck is past the end of the deck
	 */

	public boolean outOfCards() {

		if (getNumCards(Deck) > 0) {
			return true;
		}
		return false;
	}

}


	


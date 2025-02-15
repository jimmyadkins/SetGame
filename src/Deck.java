
public class Deck {
 	Card[] myCards;
	private Card topCard;
	private int topLoc = 0;
	private int numCards = 0;

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

	void shuffle() {
		for (int i = 0; i < getNumCards() * 3; ++i) {
			int a = (int) (Math.random() * (double) getNumCards());
			int b = (int) (Math.random() * (double) getNumCards());
			Card temp = this.myCards[a];
			this.myCards[a] = this.myCards[b];
			this.myCards[b] = temp;
		}
	}

	public boolean outOfCards() {

		if (getNumCards() > 0) {
			return false;
		}
		else {
			return true;
		}
	}

}


	


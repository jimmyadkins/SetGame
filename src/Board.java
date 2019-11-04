
public class Board {

	Card[] displayedCards;

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
	}

	public Card getCardAtLoc(int loc)
	{
		Card c = displayedCards[loc];
		return c;
	}

	public boolean isLegal(int loc1, int loc2, int loc3)
	{
		Card a = getCardAtLoc(loc1);
		Card b = getCardAtLoc(loc2);
		Card c = getCardAtLoc(loc3);

		boolean legal = false;
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
		return legal;
	}

	public void dealThreeCards(Deck d)
	{

		if (getNumCardsOnBoard() < 15)
		{
			if (!d.outOfCards())
			{
				for(int i=11; i<15; i++)
				{

						if (displayedCards[i] == null) {
							displayedCards[i] = d.dealCard();

					}
				}
			}
		}
	}

    public void remove3Cards(int cardLocation0, int cardLocation1, int cardLocation2)
    {
        displayedCards[cardLocation0] = null;
        displayedCards[cardLocation1] = null;
        displayedCards[cardLocation2] = null;
    }

	int getNumCardsOnBoard()
	{
		int numCards = 0;
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

	public String toString()
	{
		String result = "";
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
		return result;
	}
}

import java.util.ArrayList;
import java.util.Iterator;
/**
 * The Deck class represents a stack of cards. 
 */
public class Deck {
	private ArrayList<Card> myCards = new ArrayList();

	/**
	 * constructor - makes a deck containing one card for every
	 * combination of features and sets the topOfDeck to the index
	 * of the last card.
	 */

	public Deck() {
		//--------------------
		// TODO: insert your code here.

		//--------------------

	}

	public static Deck makeDeck() {
		int[] num = new int[]{1, 2, 3};
		int[] size = new int[]{1, 2, 3};
		String[] icon = new String[]{"&", "@", "#"};
		String[] bracket1 = new String[]{"<", "{", "["};
		String[] bracket2 = new String[]{">", "}", "]"};

		Deck result = new Deck();

		for (int iconNum = 0; iconNum < icon.length; ++iconNum) {
			for (int bracketNum = 0; bracketNum < bracket1.length; ++bracketNum) {
				for (int sizeNum = 0; sizeNum < icon.length; ++sizeNum) {
					for (int numNum = 0; numNum < bracket1.length; ++numNum) {
						result.addCard(new Card(icon[iconNum], num[sizeNum], size[sizeNum], bracket1[bracketNum], bracket2[bracketNum]));
					}
				}
			}
		}

		result.shuffle();
		return result;
	}

	public void addCard(Card c) {
		this.myCards.add(c);
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
		Card c = null;


		if (!this.outOfCards()) {

		}

		return c;
	}

	/**
	 * shuffle - shuffles the cards in the deck by swapping many times.
	 * resets "top of deck" to the beginning.
	 * Note: no return value; just updates private variables.
	 */
	public void shuffle() {
		int numCards = this.myCards.size();

		for (int i = 0; i < numCards * 3; ++i) {
			int a = (int) (Math.random() * (double) numCards);
			int b = (int) (Math.random() * (double) numCards);
			Card temp = this.myCards.get(a);
			this.myCards.set(a, this.myCards.get(b));
			this.myCards.set(b, temp);
		}

	}

	/**
	 * outOfCards - determines whether the "top of deck" has extended beyond the end of the Deck.
	 *
	 * @return - boolean; whether the top of deck is past the end of the deck
	 */
	public boolean outOfCards() {
		boolean pastEndOfDeck = false;

		if (this.myCards.size() > 0) {
			pastEndOfDeck = true;
		}

		return pastEndOfDeck;
	}


	/**
	 * toString - lists all the cards in the deck.
	 *
	 * @return a String with all the cards in it, in the current order,
	 * with a marker (e.g., "-->" vs. "   ") where the top of the Deck is.
	 */
	public String toString() {
		String result = "";
		if (this.outOfCards()) {
			return "No more cards...\n";
		} else {
			Card c;
			for (Iterator var2 = this.myCards.iterator(); var2.hasNext(); result = result + c.toString() + "\n") {
				c = (Card) var2.next();
			}

			return result;
		}
	}
}
	


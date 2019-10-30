/**
 * the Card class represents a card in the Set game - it consists 
 * of 1-3 groups of 1-3 characters, which come in 3 varieties. Each of the
 * groups is surrounded by one of three bracket types. On any one card, 
 * there is only one character, but it is likely to be repeated.
 * Likewise, there might be several groups of characters, but each group 
 * on a given card will have the same number of cards.
 * The following are legal cards:
 *    [**] [**] [**] (3 groups of 2 stars in square brackets)
 *    <o> <o> (2 groups of 1 circle in angle brackets)
 *    {•••} (1 group of 3 dots in curly brackets)
 *    <•••> <•••> <•••> (3 groups of three dots in angle brackets)
 * (An analogy might be working out on a nautilus machine - you do a 
 * certain number of sets of a certain number of reps of some weight,
 * on varying machines.)
 * The following are NOT legal cards:
 *    {*} {**} {***} (different size groups on one card)
 *    [o] [•] [•] (different shapes on one card)
 *    <**> <**> {**} (different brackets on one card)
 *    [oooo] [oooo] (more than three in a group)
 *    <•> <•> <•> <•> (more than three groups)
 *      (empty card)
 * So each card can be represented by four numbers - the number of groups, 
 * the size of the groups, which bracket and which icon you are using.
 * Each of these numbers has 3 possible values.
 * Question: how many legal combinations are there???
 */
public class Card {

	// DONE: decide which private member variables the Card class requires and declare them here.
	private char myIcon;
	private int mySize;
	private int myNumber;
	private char myBracket1;
	private char myBracket2;



	public Card(char icon, int number, int size, char bracket1, char bracket2) {

		myIcon = icon;
		mySize = size;
		myNumber = number;
		myBracket1 = bracket1;
		myBracket2 = bracket2;

	}

	// TODO: write accessors for all member variables. In this case,
	 //       you shouldn't write modifiers; a Card never changes.


	public int getIcon() {return myIcon;}
	public int getSize() {return mySize;}
	public int getNumber() {return myNumber;}
	public int getBracket1() {return myBracket1;}
	public int getBracket2() {return myBracket2;}

	/**
	 * toString - get a visual description of this card.
	 * @return the string describing this card, like "<•••>"
	 */
	// TODO: you write the Card's toString

	public String toString()
	{
		String result =  ""+myBracket1+"";
		for (int i = 0; i < mySize; i++) {
			result = ""+result+ +myIcon+"";
		}
		result = ""+result+ +myBracket2+ "";
		for (int i = 0; i <=mySize; i++)
		{
			String single = result;
			result = ""+result+ " " +single+"";
		}
		return result;
	}
	
}

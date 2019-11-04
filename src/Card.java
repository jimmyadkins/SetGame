
public class Card {

	private char myIcon;
	private int myIconNum;
	private int mySize;
	private int myNumber;
	private int myBracket;
	private char myBracket1;
	private char myBracket2;

	public Card(char icon, int iconNum, int number, int size, int bracketNum, char bracket1, char bracket2) {

		myIcon = icon;
		myIconNum = iconNum;
		mySize = size;
		myNumber = number;
		myBracket = bracketNum;
		myBracket1 = bracket1;
		myBracket2 = bracket2;
	}

	int getIcon() {return myIconNum;}
	int getSize() {return mySize;}
	int getNumber() {return myNumber;}
	int getBracket() {return myBracket;}

	public String toString()
	{
		String icons = "";
		String result = "";
		for (int i = 0; i < mySize; i++) {
			icons = icons + myIcon;
		}
		String single = myBracket1 + icons + myBracket2;

		for (int i = 0; i <myNumber; i++)
		{
			result = result + single;
		}
		return result;
	}
	
}

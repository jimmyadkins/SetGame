import java.util.Scanner;

public class SetRunner {
	private static Referee ref;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ref = new Referee();
		System.out.println("Hello there, welcome to the set casino where we only play set!");
		boolean choosing = true;
		while (choosing) {
			System.out.println("Would you like to play? Type 'yes' or 'no'");
			String choice = scan.nextLine();

			if (choice.equals("no")) {
				System.out.println("Ok then... Bye!");
			}
			else if (choice.equals("yes")) {
				ref.playGame();
			}
			else{
				System.out.println("Unknown input. Try again.");
			}
		}
	}
}
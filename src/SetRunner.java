import java.util.Scanner;

public class SetRunner {
	private static Referee ref;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ref = new Referee();
		boolean isPlaying = true;
		System.out.println("Hi, welcome to the set casino where we only play set.");

		while (isPlaying) {
			System.out.println("Would you like to play? Type 'yes' or 'no'");
			String choice = scan.nextLine();
			if (choice.equals("no")) {
				System.out.println("Ok then... Bye!");
				isPlaying = false;
			}
			else if (choice.equals("yes")) {
				ref.playGame();
			}
			else {
				System.out.println("We didn't catch that- Type 'yes' or 'no'.");
			}
		}
	}
}

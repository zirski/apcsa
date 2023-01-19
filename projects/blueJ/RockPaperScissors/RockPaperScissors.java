import java.util.Scanner;

public class RockPaperScissors {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] choices = {"rock", "paper", "scissors"};
		
		while (true) {
			System.out.print("Enter your choice (rock, paper, or scissors): ");
			String usrChoice = input.nextLine();

			if (usrChoice.isBlank()) {
				System.exit(0);
			} else {
				String sysChoice = choices[Randomizer.nextInt(0, 2)];
				System.out.println("\nUser: " + usrChoice);
				System.out.println("System: " + sysChoice);
				System.out.println(getWinner(usrChoice.split(" ").toString(), sysChoice));
			}
		}
	}

	//trashcan algorithm
	public static String getWinner(String user, String computer) {
		String r = "rock";
		String p = "paper";
		String s = "scissors";
		
		if ((user == r && computer == s) || (user == p && computer == r) || (user == s && computer == p)) {
			return "User wins!";
		} else if (user == computer) {
			return "Tie!";
		} else {
			return "Computer wins!";
		}
	}
}


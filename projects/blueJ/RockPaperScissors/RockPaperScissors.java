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
				System.out.println(getWinner(usrChoice, sysChoice));
			}
		}
	}

	//trashcan algorithm
	public static String getWinner(String user, String computer) {
		String r = "rock";
		String p = "paper";
		String s = "scissors";
		
		/*
		 * turns out I'm dumb and I forgot what reference types are. A little ChatGPT (or just as likely Ben, 
		 * basically the same thing in this case) helped me see what was right in front of my 
		 * face.
		 */
		if ((user.equalsIgnoreCase(r) && computer.equalsIgnoreCase(s)) || (user.equalsIgnoreCase(p) && computer.equalsIgnoreCase(r)) || (user.equalsIgnoreCase(s) && computer.equalsIgnoreCase(p))) {
			return "User wins!";
		} else if (user.equals(computer)) {
			return "Tie!";
		} else {
			return "Computer wins!";
		}
	}
}


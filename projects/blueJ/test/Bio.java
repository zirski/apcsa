import java.util.Scanner;
import java.util.HashMap;

public class Bio {
  public static void main(String[] args) {
    // create a HashMap to store user's information
    HashMap<String, String> bio = new HashMap<String, String>();

    // create a Scanner to read user's input
    Scanner input = new Scanner(System.in);

    try {
      while (true) {
        // print options to the user
        System.out.println("What would you like to do?");
        System.out.println("  1. Add information to your bio");
        System.out.println("  2. View your bio");
        System.out.println("  3. Edit your bio");
        System.out.println("  4. Quit");

        // read user's option
        int option = input.nextInt();

        if (option == 1) {
          // add information to the bio
          System.out.println("Enter the information you would like to add (e.g. name, age): ");
          String key = input.next();
          System.out.println("Enter the value for " + key + ": ");
          String value = input.next();
          bio.put(key, value);
        } else if (option == 2) {
          // view the bio
          System.out.println("Here is your bio:");
          for (String key : bio.keySet()) {
            System.out.println(key + ": " + bio.get(key));
          }
        } else if (option == 3) {
          // edit the bio
          System.out.println("Enter the information you would like to edit: ");
          String key = input.next();
          System.out.println("Enter the new value for " + key + ": ");
          String value = input.next();
          bio.put(key, value);
        } else if (option == 4) {
          // quit the program
          break;
        } else {
          // invalid option
          System.out.println("Invalid option. Please try again.");
        }
      }
    } finally {
      // close the Scanner
      input.close();
    }
  }
}

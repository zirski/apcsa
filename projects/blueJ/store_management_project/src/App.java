import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        User myUser = new User(null);

        System.out.println("---------------------Title screen---------------------");
        System.out.println("\nOptions:\t1. Make new License");

        System.out.print("usr: ");
        Scanner sc = new Scanner(System.in);
        
        int i = sc.nextInt();
        if (i == 1) {
            myUser.makeLicense();
        } else {
            System.out.println("Please enter a valid option.");
        }

        System.out.println("Options:\t1. Delete License\t2. Check License");

        i = sc.nextInt();
        if (i == 1) {
            //do stuff
        } else {
            myUser.checkLicense();
        }
        sc.close();
    }
}
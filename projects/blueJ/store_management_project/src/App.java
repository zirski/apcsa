import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //starting value for license; for some reason java throws an error when an argument isn't already initialized
        License myLicense = null;
        User myUser = new User(myLicense);

        System.out.println("---------------------Title screen---------------------");
        System.out.println("\nOptions:\t1. Make new License");
        //you'll see this a lot - user heading (kind of like "$" in bash)
        System.out.print("usr: ");
        Scanner sc = new Scanner(System.in);
        //options for license-building
        int i = sc.nextInt();
        if (i == 1) {
            System.out.println("Options: 1. Build from Preset\t2. Make your own");
            i = sc.nextInt();
            
            if (i == 1) {
                myUser.buildFromPreset();
            } else {
                myUser.makeLicense();
            }
        } else {
            System.out.println("Please enter a valid option.");
        }

        System.out.println("Options:\t1. Delete License\t2. Check License");

        i = sc.nextInt();
        if (i == 1) {
            //effectively deletes any license for current session - fairly sure program will crash if I added the ability to go back and try to check license after it has been deleted
            myLicense = null;
            System.out.println("License deleted!");
        } else {
            myUser.checkLicense();
        }
        sc.close();
    }
}
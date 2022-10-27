import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------Title screen---------------------");
        System.out.println("\nOptions:\t1. Make new License");
        usrHeading();
        
        int i = sc.nextInt();
        if (i == 1) {
            makeLicense();
        } else {
            System.out.println("Please enter a valid option.");
        }
        sc.close();
    }
    
    public static void usrHeading() {
        System.out.print("usr: ");
    }

    public static void makeLicense() {
        System.out.println("Please select 2 products:");
        System.out.println("\n1. Canvas\t2. Darkroom\t3. Marketplace\t4. Collage");
        usrHeading();

        String[] products = {"Canvas", "Darkroom", "marketplace", "Collage"};
        
        ArrayList<Integer> choices = new ArrayList<Integer>(0);
        
        Scanner choiceSc = new Scanner(System.in);
        String choiceString = choiceSc.next();
        choiceSc.close();

        Scanner sc = new Scanner(choiceString).useDelimiter(", ");

        while (sc.hasNext()) {
            String choice = sc.next();
            int choicetoInt = Integer.parseInt(choice);
            choices.add(choicetoInt);
        }
        sc.close();

        System.out.println(choices);

        // Product[] choices = new Product[2];
        
        // License myLicense = new License(null, null);
        
    }
}

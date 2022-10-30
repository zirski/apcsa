import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        System.out.println("---------------------Title screen---------------------");
        System.out.println("\nOptions:\t1. Make new License");

        usrHeading();
        Scanner sc = new Scanner(System.in);
        
        int i = sc.nextInt();
        if (i == 1) {
            makeLicense();
        } else {
            System.out.println("Please enter a valid option.");
        }

        System.out.println("Options:\t1. Delete License\t2. Check License");

        i = sc.nextInt();
        if (i == 1) {
            //do stuff
        } else {
            checkLicense();
        }
        sc.close();
    }
    
    public static void usrHeading() {
        System.out.print("usr: ");
    }

    public static void makeLicense() {
        System.out.println("Please select products:");
        System.out.println("\n1. Canvas\t2. Darkroom\t3. Marketplace\t4. Collage");
        usrHeading();

        Product[] products = new Product[4];

        products[0] = new Product("canvas", 15.00);
        products[1] = new Product("darkroom", 12.00);
        products[2] = new Product("marketplace", 20.00);
        products[3] = new Product("collage", 18.00);
        
        ArrayList<Integer> arliChoices = new ArrayList<Integer>(0);
        
        Scanner sc = new Scanner(System.in);
        String choices = sc.nextLine();

        Scanner strSc = new Scanner(choices);
        while (strSc.hasNext()) {
            arliChoices.add(strSc.nextInt());
        }
        strSc.close();

        
        Product[] myChoices = new Product[arliChoices.size()];
        
        for (int i = 0; i < arliChoices.size(); i++) {
            myChoices[i] = products[arliChoices.get(i)];
        }
        
        System.out.println("Please select your plan:");
        System.out.println("\n1. Monthly\t2. Semiannually\t3. annually");
        usrHeading();
        
        int choice = sc.nextInt();
        sc.close();
        
        Plan myPlan = new Plan(choice);
        License myLicense = new License(myChoices, myPlan);
    }

    public static void checkLicense() {
        System.out.println("License:");
        //System.out.println("Products:\t" + myLicense.toString());
        
    }
}
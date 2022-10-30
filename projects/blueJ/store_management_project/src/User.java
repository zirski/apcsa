import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private License license;

    public User(License license) {
        this.license = license;
    }

    public void makeLicense() {
        System.out.println("Please select products:");
        System.out.println("\n1. Canvas\t2. Darkroom\t3. Marketplace\t4. Collage");
        System.out.print("usr: ");

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
            arliChoices.add(Integer.parseInt(strSc.next()));
        }
        strSc.close();

        
        Product[] myChoices = new Product[arliChoices.size()];
        
        for (int i = 0; i < arliChoices.size(); i++) {
            myChoices[i] = products[arliChoices.get(i)];
        }
        
        System.out.println("Please select your payment plan:");
        System.out.println("\n1. Monthly\t2. Semiannually\t3. annually");
        System.out.print("usr: ");
        
        int choice = sc.nextInt();
        
        Plan myPlan = new Plan(choice);
        License myLicense = new License(myChoices, myPlan);
        license = myLicense;
    }

    public void checkLicense() {
        System.out.println("License:");
        System.out.println("Products:\t" + license.toString());
        
    }
}
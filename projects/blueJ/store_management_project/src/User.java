import java.util.ArrayList;
import java.util.Scanner;

/*I made the User class to call the below methods on an object instead of having
 * them floating in space
 */
public class User {
    private License license;

    public User(License license) {
        this.license = license;
    }
    
    public void makeLicense() {
        //I decided to do the product[] creation twice, because only one of these methods are occuring in any one session
        Product[] products = new Product[4];
    
        products[0] = new Product("Canvas", 15.00);
        products[1] = new Product("Darkroom", 12.00);
        products[2] = new Product("Marketplace", 20.00);
        products[3] = new Product("Collage", 18.00);

        System.out.println("Please select Products:");
        System.out.println("\n1. Canvas ($15.00/mo)\t2. Darkroom ($12.00/mo)\t3. Marketplace ($20.00/mo)\t4. Collage ($18.00/mo)");
        System.out.print("usr: ");
        
        /*
         * The reason for this clusterfuck of arrays is because firstly we have a list of unknown
         * size (the products the user chooses), and we want to end up with an array of products[]
         * in order to create our license. I didn't really want to touch using an arrayList as an 
         * instance variable for a class, so here we are.
         */
        ArrayList<Integer> arliChoices = new ArrayList<Integer>(0);
        
        /*
         * this gets rid of an issue wherein during a while loop, System.in will always have a "next" token 
         * (that being whatever the user types), so I just ported the user input into a string and parsed that
         * into our final array.
         */
        Scanner sc = new Scanner(System.in);
        String choices = sc.nextLine();

        Scanner strSc = new Scanner(choices);
        while (strSc.hasNext()) {
            //our input is still a string at this point, hence Integer.parseInt()
            arliChoices.add(Integer.parseInt(strSc.next()));
        }
        strSc.close();

        //Since now we have a set list size, we can use the length as our array size. Neat!
        Product[] myProducts = new Product[arliChoices.size()];
        
        //populating the myProducts array with the arrayList indices
        for (int i = 0; i < arliChoices.size(); i++) {
            myProducts[i] = products[(arliChoices.get(i) - 1)];
        }
        
        System.out.println("Please select your payment plan:");
        System.out.println("\n1. Monthly (No discount)\t2. Semiannually (10% discount per product)\t3. Annually (20% discount per product)");
        System.out.print("usr: ");
        
        int choice = sc.nextInt();
        
        
        Plan myPlan = new Plan(choice);

        //License created!
        License myLicense = new License(myProducts, myPlan);
        // license = myLicense;
        this.setLicense(myLicense);
        sc.close();
    }

    public void buildFromPreset() {
        Preset myPreset;
        Scanner sc = new Scanner(System.in);
        
        Preset[] presets = new Preset[2];
        Product[] products = new Product[4];

        Plan presetPlan = new Plan(1);
    
        products[0] = new Product("Canvas", 15.00);
        products[1] = new Product("Darkroom", 12.00);
        products[2] = new Product("Marketplace", 20.00);
        products[3] = new Product("Collage", 18.00);

        //I kind of slapped this bit together - definitely a better way of doing this
        Product[] photoProducts = new Product[2];
        photoProducts[0] = products[1];
        photoProducts[1] = products[2];

        //this creates two presets that the user can choose from - with our selected products
        presets[0] = new Preset(products, presetPlan, "Full");
        presets[1] = new Preset(photoProducts, presetPlan, "Photo");

        System.out.println("Please select your preset: ");
        System.out.println("1. Full (all products)\t2. Photo (Darkroom & Marketplace)");
        System.out.print("usr: ");

        int i = sc.nextInt();
        if (i == 1) {
            myPreset = presets[0];
        } else {
            myPreset = presets[1];
        }

        //handy that you can assign a subclass to a superclass variable
        license = myPreset;
        sc.close();
    }

    public void checkLicense() {
        System.out.println("------------------------License-----------------------");
        System.out.println("Products ->\n\t" + this.license.toString());
    }

    public void setLicense(License license) {
        this.license = license;
    }
}
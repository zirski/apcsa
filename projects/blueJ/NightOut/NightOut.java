import java.util.Scanner;

public class NightOut {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //variable storage for prices
        System.out.println("How much did dinner cost? ");
        double dinner = input.nextInt();
        System.out.println("\nHow much is mini-golf for one person? ");
        double miniGolf = (input.nextInt() * 2);
        System.out.println("\nHow much did dessert cost? ");
        double dessert = input.nextInt();

        double grandTotal = dinner + miniGolf + dessert;

        //\n adds a line before the text - looks nicer
        System.out.println("\nDinner: $" + dinner);
        System.out.println("Mini-Golf: $" + miniGolf);
        System.out.println("Dessert: $" + dessert);
        System.out.println("Grand Total: $" + grandTotal);

        input.close();
    }
}

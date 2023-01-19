public class Racecar {
    private final double HUNTINGTON_CONSTANT = 6.290;

    private String name;
    private double weight;
    private double power;
    
    public Racecar(String n, double w, double p) {
        this.name = n;
        this.weight = w;
        this.power = p;
    }
    
    public double computeTime() {
        return HUNTINGTON_CONSTANT * Math.cbrt(this.weight / this.power);
    }
    
    public String toString() {
        return name + "\n" +
            "  Weight: " + weight + " lb\n" +
            "  Power: " + power + " hp";
    }
    
    public static void main(String[] args) {
        // 1. Generate two random numbers between [2000, 5000] for weight
        int w1 = Randomizer.nextInt(2000, 5000);
        int w2 = Randomizer.nextInt(2000, 5000);
        
        // 2. Generate two more random numbers between [500, 1000] for horsepower
        int hp1 = Randomizer.nextInt(500, 100);
        int hp2 = Randomizer.nextInt(500, 100);
        
        // 3. Create two Racecar objects with distinct names, weight, and horsepower.
        //    You need to complete the constructor of the Racecar class.
        Racecar Webber = new Racecar("Webber", w1, hp1);
        Racecar Senna = new Racecar("Senna", w2, hp2);
        
        // 4. Call the computeTime method on each object and print out the results.
        //    You need to complete the computeTime method in the Racecar class based
        //    on the assignment directions.
        double WebberET = Webber.computeTime();
        double SennaET = Senna.computeTime();
        
        // 5. Print finishing times of both cars.
        System.out.println(Webber.name + ": ");
        System.out.println("\tWeight: " + Webber.weight);
        System.out.println("\tPower: " + Webber.power);
        System.out.println("\tFinish time: " + WebberET + "\n");

        System.out.println(Senna.name + ": ");
        System.out.println("\tWeight: " + Senna.weight);
        System.out.println("\tPower: " + Senna.power);
        System.out.println("\tFinish time: " + SennaET);
    }
}
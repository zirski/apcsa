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
        return 0.0;
    }
    
    public String toString() {
        return name + "\n" +
            "  Weight: " + weight + " lb\n" +
            "  Power: " + power + " hp";
    }
    
    public static void main(String[] args) {
        // 1. Generate two random numbers between [2000, 5000] for weight
        
        
        // 2. Generate two more random numbers between [500, 1000] for horsepower
        
        
        // 3. Create two Racecar objects with distinct names, weight, and horsepower.
        //    You need to complete the constructor of the Racecar class.
        
        
        // 4. Call the computeTime method on each object and print out the results.
        //    You need to complete the computeTime method in the Racecar class based
        //    on the assignment directions.
        
        
        // 5. Print finishing times of both cars.
        
    }
}
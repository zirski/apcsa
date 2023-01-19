public class Randomizer {
    public static int nextInt() { 
        return (int)(Math.random() * 11);
    }

    public static int nextInt(int min, int max) {
        return (int)(Math.random() * (max + 1) + min);
    }
}

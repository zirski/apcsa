public class Randomizer {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(nextInt());
        }
    }

    public static int nextInt() { 
        return (int)(Math.random() * 11);
    }

    public static int nextInt(int min, int max) {
        return (int)(Math.random() * (max + 1) + min);
    }
}

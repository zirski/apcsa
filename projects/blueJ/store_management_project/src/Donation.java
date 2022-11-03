public class Donation extends Product {
    private String destination;

    public Donation(String name, double price, String destination) {
        super(name, price);
        this.destination = destination;
    }
}

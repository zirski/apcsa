public class License {
    private Product[] products = new Product[2];
    private Plan plan;

    public License(Product[] products, Plan plan) {
        this.products = products;
        this.plan = plan;
    }

    public double calcEffPrice(double price) {
        double effPrice = price - (price * this.plan.getDiscount());
        return effPrice;
    }

    public double calcLicenseCost() {
        double licenseCost = 0;
        
        for (int i = 0; i < products.length; i++) {
            licenseCost += calcEffPrice(products[i].price);
        }

        return licenseCost;
    }
}

public class License {
    private Product[] products = new Product[2];
    private Plan plan;

    public License() {
        products = null;
        plan = null;
    }
    
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

    public String toString() {
        String productsToString = null;
        for (int i = 0; i < products.length; i++) {
            productsToString += products[i].toString();
        }
        return "Products: " + productsToString + "\nPlan: " + plan.toString();
    }
}

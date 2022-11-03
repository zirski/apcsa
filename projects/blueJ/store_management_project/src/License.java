public class License {
    //oh boy the instance variables are all custom datatypes??? :o
    private Product[] products = new Product[0];
    private Plan plan;
    public License() {
        //same reason as in App.java(ln 5)
        products = null;
        plan = null;
    }
    
    //array of objects is annoying as hell to implement
    public License(Product[] products, Plan plan) {
        this.products = products;
        this.plan = plan;
    }

    //this gets around having to write two variables for discount - this subtracts the n% version of the total price from the price itself to find the actual effective price
    public double calcEffPrice(double price) {
        double effPrice = (price - (price * this.plan.getDiscount())) * this.plan.getBillingPeriod();
        return effPrice;
    }

    //this does the aforementioned math to each product the user selects and then finds the sum
    public double calcLicenseCost() {
        double licenseCost = 0;
        
        for (int i = 0; i < this.products.length; i++) {
            licenseCost += calcEffPrice(this.products[i].price);
        }

        return licenseCost;
    }

    // groups array elements into a single string using the toString() method of each individual product
    public String toString() {
        String productsToString = "";
        for (int i = 0; i < this.products.length; i++) {
            productsToString += products[i].toString() + ", ";
        }

        //actually upset about this - above methods to calc actual price don't work for some reason
        return productsToString.substring(0, (productsToString.length() - 2)) + "\nPlan ->\n\t" + plan.toString() + "\n\nTotal Price per Billing Period -> " + this.calcLicenseCost();
    }
}

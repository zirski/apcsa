public class Plan {
    private int billingPeriod;
    private double discount;

    public Plan(int billingPeriod) {
        this.billingPeriod = billingPeriod;
        
        //this is so I don't have to do any array bullshit with the discount values - instead it assigns the value dynamically based on what the user enters
        if (billingPeriod == 1) {
            discount = 0;
        } else if (billingPeriod == 2) {
            discount = 0.10;
        } else if (billingPeriod == 3) {
            discount = 0.20;
        }
    }

    public double getDiscount() {
        return discount;
    }
    
    public int getBillingPeriod() {
        return billingPeriod;
    }

    //this is so the user actually sees which billing period they entered, not just the option number (1, 2, 3)
    public String toString() {
        String[] planNames = {"Monthly", "Semiannually", "Annually"};
        return "Billing Period: " + planNames[billingPeriod - 1] + "\n\tDiscount: " + (discount * 100) + "%";
    }
}


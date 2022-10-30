public class Plan {
    private int billingPeriod;
    private double discount;

    public Plan(int billingPeriod) {
        this.billingPeriod = billingPeriod;
        
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

    public String toString() {
        return "Billing Period: " + billingPeriod + "\nDiscount: " + discount;
    }


    // private billingPeriod billingPeriod;
    // private double discount;

    // public Plan(billingPeriod billingPeriod) {
    //     this.billingPeriod = billingPeriod;

    //     if (billingPeriod == monthly) {
    //         discount = 0;
    //     } else if (billingPeriod == semiannually) {
    //         discount = 0.10;
    //     } else if (billingPeriod == annually) {
    //         discount = 0.20;
    //     }
    // }

    // billingPeriod myBillingPeriod = new billingPeriod(6);
    // billingPeriod myBillingPeriod = new billingPeriod(1);

    // public double getDiscount() {
    //     return discount;
    // }

    // public billingPeriod getBillingPeriod() {
    //     return billingPeriod;
    // }

    // class billingPeriod {
    //     private int paymentsPerYear;
    
    //     private billingPeriod(int paymentsPerYear) {
    //         this.paymentsPerYear = paymentsPerYear;
    //     }
    // }
}


public class Plan {
    private billingPeriod billingPeriod;
    private double discount;

    public Plan(billingPeriod billingPeriod) {
        this.billingPeriod = billingPeriod;

        if (billingPeriod == monthly) {
            discount = 0;
        } else if (billingPeriod == semiannually) {
            discount = 0.10;
        } else if (billingPeriod == annually) {
            discount = 0.20;
        }
    }

    billingPeriod monthly = new billingPeriod("monthly", 12);
    billingPeriod semiannually = new billingPeriod("semiannually", 6);
    billingPeriod annually = new billingPeriod("annually", 1);

    public double getDiscount() {
        return discount;
    }

    public billingPeriod getBillingPeriod() {
        return billingPeriod;
    }

    class billingPeriod {
        private String name;
        private int paymentsPerYear;
    
        private billingPeriod(String name, int paymentsPerYear) {
            this.name = name;
            this.paymentsPerYear = paymentsPerYear;
        }
    }
}


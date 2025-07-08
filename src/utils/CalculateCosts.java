package utils;

public class CalculateCosts {
    public double calculateShippingFees(double productPrice, double productWeight, int productQty) {
        double percentage = 0.01;
        double fees = productQty * (percentage * (productPrice * (productWeight / 1000)));
        return fees;
    }

    public double calculateEmailFees(double productPrice) {
        double percentage = 0.1;
        double fees = (percentage * productPrice);
        return fees;
    }

    public double calculateEachProductCost(double productPrice, int productQty) {
        return productPrice * productQty;
    }
}

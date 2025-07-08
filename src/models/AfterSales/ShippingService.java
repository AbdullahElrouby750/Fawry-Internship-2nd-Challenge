package models.AfterSales;

import interfaces.AfterSalesServce;

public class ShippingService implements AfterSalesServce {
    
    @Override
    public void afterSalesServce( String address){
        System.out.printf("Your books had been shipped to the address :: %s\n", address);
    }
}

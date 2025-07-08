package models.AfterSales;

import interfaces.AfterSalesServce;

public class MailService implements AfterSalesServce {
        
    @Override
    public void afterSalesServce( String address){
        System.out.printf("Your books had been send to the email address :: %s\n", address);
    }

}

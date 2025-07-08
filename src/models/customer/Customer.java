package models.customer;

import java.util.HashMap;
import java.util.Map;

import models.AfterSales.MailService;
import models.AfterSales.ShippingService;
import models.books.EBook;
import models.books.PaperBook;
import models.inventory.Inventory;
import utils.CalculateCosts;

public class Customer {
    private double balance;

    private Map<String, PaperBook> paperBookCart;
    private Map<String, Integer> paperBookCartQty;
    private Map<String, EBook> EbookCart;

    CalculateCosts calcCost = new CalculateCosts();
    ShippingService shippingService = new ShippingService();
    MailService mailService = new MailService();

    public Customer(double balance) {
        this.balance = balance;

        paperBookCart = new HashMap<>();
        paperBookCartQty = new HashMap<>();
        EbookCart = new HashMap<>();
    }

    public double getBalance() {
        return balance;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }


    public void buyPaperBooks(String ISBN, int qty, Inventory inventory) {
        PaperBook book = inventory.getPaperBooks(ISBN, qty);
        if (book == null) {
            return;
        }
        paperBookCart.put(ISBN, book);
        paperBookCartQty.put(ISBN, qty);
    }

    public double checkPaperBooks(String homeAddress) {
        double totalPrice = 0, totalfees = 0;
        try {
            
            for (Map.Entry<String, Integer> iterable_element : paperBookCartQty.entrySet()) {
                PaperBook book = paperBookCart.get(iterable_element.getKey());
                totalPrice += calcCost.calculateEachProductCost(book.getPrice(), iterable_element.getValue());
                totalfees += calcCost.calculateShippingFees(book.getPrice(), book.getWeight(), iterable_element.getValue());
            }
        } catch (Exception e) {
            System.err.println("err:: " + e);
        }
        double totalPaid = totalPrice + totalfees;
        if (totalPaid > balance) {
            System.out.println("no enough mony in your balance!");
            return -1;
        }
        paperBookCart.clear();
        paperBookCartQty.clear();
        shippingService.afterSalesServce(homeAddress);
        System.out.println("you paid "+ totalPaid);
        return totalPaid;
    }

    public void buyEBooks(String ISBN, Inventory inventory) {
        if (EbookCart.containsKey(ISBN)) {
            System.out.println("you already have this book in your cart and did not check it out yet");
            return;
        }
        EBook book = inventory.gettingEbook(ISBN);
        if (book == null) {
            return;
        }
        EbookCart.put(ISBN, book);
    }

    public double checkoutEbook(String emailAddress) {
        double totalPrice = 0, totalfees = 0;
        for (Map.Entry<String, EBook> iterable_element : EbookCart.entrySet()) {
            totalPrice += iterable_element.getValue().getPrice();
            totalfees += calcCost.calculateEmailFees(iterable_element.getValue().getPrice());
        }

        double totalPaid = totalPrice + totalfees;
        if (totalPaid > balance) {
            System.out.println("no enough mony in your balance!");
            return -1;
        }
        EbookCart.clear();
        mailService.afterSalesServce(emailAddress);
        System.out.println("you paid "+ totalPaid);
        return totalPrice + totalfees;
    }

}

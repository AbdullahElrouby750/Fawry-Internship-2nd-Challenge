import models.books.EBook;
import models.books.PaperBook;
import models.customer.Customer;
import models.inventory.Inventory;
import utils.InputHandler;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Our Store!");
        Inventory inventory = new Inventory();
        InputHandler input = new InputHandler();

        Customer customer = new Customer(20000);

        //!Add a book to the inventory with some details like ISBN(just any string identifier), title, year when the book is published, price
        //creating paper books
        PaperBook paperBook1 = new PaperBook("pb1", "pb1", 2000, 250, 500, true);
        PaperBook paperBook2 = new PaperBook("pb2", "pb2", 2020, 550, 700, true);
        PaperBook paperBook3 = new PaperBook("pb3", "pb3", 2005, 1200, 950, true);

        //creating Ebooks
        EBook eBook1 = new EBook("eb1", "eb1", 1990, 250, "link1", true, ".pdf");
        EBook eBook2 = new EBook("eb2", "eb2", 1980, 250, "link2", false, ".pdf");
        EBook eBook3 = new EBook("eb3", "eb3", 1970, 250, "link3", false, ".pdf");

        //adding paper books
        inventory.addPaperBook(paperBook1.getISBN(), paperBook3);
        inventory.addPaperBooks(paperBook2.getISBN(),paperBook2, 20);
        inventory.addPaperBooks(paperBook1.getISBN(), paperBook1, 5);

        //adding Ebooks
        inventory.addEBook(eBook3.getISBN(), eBook3);
        inventory.addEBook(eBook2.getISBN(), eBook2);
        inventory.addEBook(eBook1.getISBN(), eBook1);

        //!Remove and return outdated books that passed specific number of years
        PaperBook paperBook4 = new PaperBook("pb4", "pb4", 1005, 1200, 950, true);
        inventory.addPaperBooks(paperBook4.getISBN(), paperBook3, 100);
        System.out.println(inventory.remverAllISBNpaperBook(paperBook4.getISBN()).getTitle() + "was removed");

        //!Buy a single book providing its ISBN, quantity, email, address
        //? buing paper book
        String inputISNB = input.getStringInput("enter ISNB for the paper book wanted");
        int qty = input.getIntgerinput("enter the wanted quantity");
        PaperBook paperBook = inventory.getPaperBooks(inputISNB, qty);
        if(paperBook != null){
            customer.buyPaperBooks(paperBook.getISBN(), qty, inventory);
            System.out.printf("you paid %d", customer.checkPaperBooks("London, 22 baker street"));
        }

        
        //? buing Ebook
        inputISNB = input.getStringInput("enter ISNB for the Ebook wanted");
        EBook eBook = inventory.gettingEbook(inputISNB);
        if(eBook != null){
            customer.buyEBooks(inputISNB, inventory);
            System.out.printf("you paid %d",customer.checkoutEbook("customer@customer.com"));
        }

    }
}

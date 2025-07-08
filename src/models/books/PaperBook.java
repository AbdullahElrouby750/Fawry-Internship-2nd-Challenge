package models.books;

import interfaces.booksInterface;

public class PaperBook extends Books implements booksInterface {
    private double weight;

    public PaperBook(String ISBN, String title, int published, double price, double weight, boolean forSale) {
        super(ISBN, title, published, price, forSale);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public void displayBook() {
        // TODO Auto-generated method stub
        String canBuy;
        if(getForSale()){
            canBuy = "true";
        }else{
            canBuy = "false";
        }
        System.out.println("displaying paper book data::");
        System.out.printf("ISBN :: %s\nTitle :: %s\nYear published :: %d\nPrice :: %f\nBook weight :: %f\nCan buy :: %s\n",
            getISBN(), getTitle(), getPublished(), getPrice(), weight, canBuy
        );
    }
}

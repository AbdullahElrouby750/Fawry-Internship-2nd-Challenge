package models.books;

public class Books {
    private String ISBN;
    private String title;
    private int published;
    private double price;
    private boolean forSale;


    public Books(String ISBN, String title, int published, double price, boolean forSale) {
        this.ISBN = ISBN;
        this.title = title;
        this.published = published;
        this.price = price;
        this.forSale = forSale;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    public boolean getForSale() {
        return forSale;
    }

    public void setForSale(boolean forSale) {
        this.forSale = forSale;
    }


}

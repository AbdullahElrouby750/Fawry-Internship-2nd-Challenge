package models.books;

import interfaces.booksInterface;

public class EBook extends Books implements booksInterface {
    private String downloadLink;
    private String fileType;
    public EBook(String ISBN, String title, int published, double price, String downloadLink, boolean forSale, String fileType) {
        super(ISBN, title, published, price, forSale);
        this.downloadLink = downloadLink;
        this.fileType = fileType;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
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
        System.out.printf("ISBN :: %s\nTitle :: %s\nYear published :: %d\nPrice :: %f\ndownload Link :: %f\nCan buy :: %s\n",
            getISBN(), getTitle(), getPublished(), getPrice(), downloadLink, canBuy
        );
    }
}

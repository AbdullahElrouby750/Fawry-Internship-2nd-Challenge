package models.inventory;

import models.books.*;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, PaperBook> paperBookMap;
    private Map<String, Integer> paperBookMapQty;
    private Map<String, EBook> eBookMap;

    public Inventory() {
        paperBookMap = new HashMap<>();
        paperBookMapQty = new HashMap<>();
        eBookMap = new HashMap<>();
    }

    // ? Paprbooks methods Start

    // !adding paperbooks
    public void addPaperBooks(String ISBN, PaperBook book, int qty) {
        try {
            if (paperBookMap.containsKey(ISBN)) {
                int cuurentQty = paperBookMapQty.get(ISBN);
                paperBookMapQty.put(ISBN, cuurentQty + qty);
            } else {
                paperBookMap.put(ISBN, book);
                paperBookMapQty.put(ISBN, qty);
            }
            System.err.printf("Successfully addedd %s to the inventory\n", book.getTitle());
        } catch (Exception e) {
            System.err.printf("faild adding %s\n", book.getTitle());
        }
    }

    // !adding a paperbook
    public void addPaperBook(String ISBN, PaperBook book) {
        addPaperBooks(ISBN, book, 1);
    }

    // !removing paperbooks
    public PaperBook removePaperBooks(String ISBN, int qty) {
        try {
            if (paperBookMap.containsKey(ISBN)) {
                int currentQty = paperBookMapQty.get(ISBN);
                if (currentQty > qty) {
                    PaperBook book = paperBookMap.get(ISBN);
                    paperBookMapQty.put(ISBN, currentQty - qty);
                    System.out.println("the Paper book was successfully removed");
                    return book;
                } else {
                    PaperBook book = paperBookMap.remove(ISBN);
                    paperBookMapQty.remove(ISBN);
                    System.out.println("the Paper book was successfully removed");
                    return book;
                }
            } else {
                System.out.println("this book does not exist in the inventory!");
                return null;
            }
        } catch (Exception e) {
            System.err.println("error removing paper books!");
            return null;
        }
    }

    // !removing a paperbook
    public PaperBook removePaperBook(String ISBN) {
        return removePaperBooks(ISBN, 1);
    }

    public PaperBook remverAllISBNpaperBook(String ISBN) {
        try {
            if (paperBookMap.containsKey(ISBN)) {
                PaperBook book = paperBookMap.remove(ISBN);
                paperBookMapQty.remove(ISBN);
                return book;
            } else {
                System.out.println("this book does not exist in the inventory!");
                return null;
            }
        } catch (Exception e) {
            System.err.println("error removing paper books!");
            return null;
        }
    }

    // !getting paperbooks
    public PaperBook getPaperBooks(String ISBN, int qty) {
        try {
            if (paperBookMap.containsKey(ISBN)) {
                int currentQty = paperBookMapQty.get(ISBN);
                if (currentQty > qty) {
                    PaperBook book = paperBookMap.get(ISBN);
                    paperBookMapQty.put(ISBN, currentQty - qty);
                    System.out.println("the Paper book was successfully retreived");
                    return book;
                } else {
                    System.out.println("Your order exceeds the available inventory!");
                    return null;
                }
            } else {
                System.out.println("This book does not exist in the inventory!");
                return null;
            }
        } catch (Exception e) {
            System.err.println("error removing paper books!");
            return null;
        }
    }

    // !getting a paperbook
    public PaperBook getPaperBook(String ISBN) {
        return getPaperBooks(ISBN, 1);
    }

    // !getting the number of paperbooks
    public int getPaperbooksQty() {
        try {
            if (paperBookMapQty == null || paperBookMapQty.isEmpty()) {
                return 0;
            } else {
                int sum = paperBookMapQty.values().stream().mapToInt(Integer::intValue).sum();
                return sum;
            }
        } catch (Exception e) {
            System.err.println("error getting paper books Quntatity!");
            System.err.println(e);
            return -1;
        }
    }

    // ? Paprbooks methods End

    // ? EBooks methods start

    // !adding Ebooks
    public void addEBook(String ISBN, EBook book) {
        try {
            if (eBookMap.containsKey(ISBN)) {
                System.out.printf("%s allready exist in the inventory\n", book.getTitle());
                return;
            } else {
                eBookMap.put(ISBN, book);
            }
            System.err.printf("Successfully addedd %s to the inventory\n", book.getTitle());
        } catch (Exception e) {
            System.err.printf("faild adding %s\n", book.getTitle());
        }
    }

    // !removing Ebooks
    public EBook removeEbook(String ISBN) {
        try {
            if (eBookMap.containsKey(ISBN)) {
                EBook book = eBookMap.remove(ISBN);
                System.out.println("the Ebook was successfully removed");
                return book;
            } else {
                System.out.println("this book does not exist in the inventory!");
                return null;
            }
        } catch (Exception e) {
            System.err.println("error removing  Ebooks!");
            return null;
        }
    }

    // !removing Ebooks
    public EBook gettingEbook(String ISBN) {
        try {
            if (eBookMap.containsKey(ISBN)) {
                EBook book = eBookMap.remove(ISBN);
                System.out.println("the Ebook was successfully retrived");
                return book;
            } else {
                System.out.println("this book does not exist in the inventory!");
                return null;
            }
        } catch (Exception e) {
            System.err.println("error removing  Ebooks!");
            return null;
        }
    }

    // !geting the numbers of Ebooks
    public int getEbooksQty() {
        try {
            if (eBookMap == null || eBookMap.isEmpty()) {
                return 0;
            } else {
                int sum = eBookMap.values().size();
                return sum;
            }
        } catch (Exception e) {
            System.err.println("error getting Ebooks Quntatity!");
            System.err.println(e);
            return -1;
        }
    }
    // ? EBooks methods end

    // !getting all the quantity in the inventory
    public int gettingAllBooks() {
        int eBooks = 0, paperBooks = 0;
        eBooks = getEbooksQty();
        paperBooks = getPaperbooksQty();
        return eBooks + paperBooks;
    }

}

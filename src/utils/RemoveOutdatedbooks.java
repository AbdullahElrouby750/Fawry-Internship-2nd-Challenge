package utils;

import models.books.EBook;
import models.books.PaperBook;
import models.inventory.Inventory;

public class RemoveOutdatedbooks {
    private int outDateYear = 1900;

    public PaperBook removeOutDatedPaperbooks(String ISBN, Inventory inventory) {
        PaperBook targBook = inventory.getPaperBook(ISBN);
        if (targBook == null) {
            return null;
        }
        int year = targBook.getPublished();
        if (year > outDateYear) {
            System.out.printf("%s is not outDated\n", targBook.getTitle());
            return null;
        }
        System.out.printf("%s is outDated and removed from inventory\n", targBook.getTitle());

        PaperBook removedBook = inventory.remverAllISBNpaperBook(ISBN);
        return removedBook;
    }

    public EBook removeOutDatedEbooks(String ISBN, Inventory inventory) {
        EBook targBook = inventory.gettingEbook(ISBN);
        if (targBook == null) {
            return null;
        }
        int year = targBook.getPublished();
        if (year > outDateYear) {
            System.out.printf("%s is not outDated\n", targBook.getTitle());
            return null;
        }
        System.out.printf("%s is outDated and removed from inventory\n", targBook.getTitle());

        EBook removEBook = inventory.removeEbook(ISBN);
        return removEBook;
    }
}

package main.java.com.library;
import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    private List<LibraryItem> libraryItems;

    public LibraryManager() {
        libraryItems = new ArrayList<>();
    }

    public void addLibraryItem(LibraryItem item) {
        libraryItems.add(item);
        System.out.println("Library item is added: " + item.getId());
    }

    public void removeLibraryItem(LibraryItem item) {
        if (libraryItems.remove(item)) {
            System.out.println("Library item removed: " + item.getId());
        } else {
            System.out.println("Library item not found");
        }
        ;
    }

    public void display() {
        for (LibraryItem item : libraryItems) {
            String status = item.availability ? " is available" : " is borrowed, the return date is " + item.dueToDate;
            if (item instanceof Book) {
                System.out.println("Book " + item.getId() + " : " + ((Book) item).getTitle() + status);
            } else {
                System.out.println("Magzine " + item.getId() + " : " + ((Magazine) item).getIssue() + status);
            }
        }
    }

    public LibraryItem findItemById(int id) {
        for (LibraryItem item : libraryItems) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

}

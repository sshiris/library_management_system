import java.time.LocalDate;

public class Book extends LibraryItem {
    private String title;

    public Book(String title, int id) {
        super(id);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void borrowItem() {
        if (availability) {
            this.availability = false;
            LocalDate borrowDate = LocalDate.now();
            this.dueToDate = borrowDate.plusWeeks(4);
            System.out.println("Book " + title + " has been borrowed. Due date is " + dueToDate);
        } else {
            System.out.println("Book " + title + " is not available.");
        }

    }
}

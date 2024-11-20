package main.java.com.library;
import java.time.LocalDate;

class Magazine extends LibraryItem {
    private String issue;

    public Magazine(String issue, int id) {
        super(id);
        this.issue = issue;
    }

    public String getIssue() {
        return issue;
    }

    public void borrowItem() {
        if (availability) {
            this.availability = false;
            LocalDate borrowDate = LocalDate.now();
            this.dueToDate = borrowDate.plusWeeks(2);
            System.out.println("The magazine " + issue + "  has been borrowed, the due date is " + dueToDate);
        } else {
            System.out.println("The magazine " + issue + " is not available");
        }
    }
}
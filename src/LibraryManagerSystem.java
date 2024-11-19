public class LibraryManagerSystem {
    public static void main(String[] args) {
        Book book1 = new Book("72 laws of power", 1);
        Magazine magazine1 = new Magazine("1980 Vogue", 1);

        LibraryManager library = new LibraryManager();
        library.addLibraryItem(book1);
        library.addLibraryItem(magazine1);

        book1.borrowItem();
        library.removeLibraryItem(magazine1);
        library.display();
    }

}

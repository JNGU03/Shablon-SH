public class Main {
    public static void main(String[] args) {
        Library library = new Library();


        Book book1 = new Book("Абай 1-том", "Мұхтар Әуезов", "111", 3);
        Book book2 = new Book("Абай 2-том", "Мұхтар Әуезов", "222", 2);
        library.addBook(book1);
        library.addBook(book2);


        Reader reader1 = new Reader("Ғалымұлы У", "Чит.1");
        Reader reader2 = new Reader("Азамат А", "Чит.2");
        library.registerReader(reader1);
        library.registerReader(reader2);


        library.issueBook("111", "Чит.1");
        library.issueBook("222", "Чит.2");
        library.returnBook("111");


        library.removeBook("222");
        library.showBooks();
        library.showReaders();
    }
}

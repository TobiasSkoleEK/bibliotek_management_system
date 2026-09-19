import java.util.Objects;

public class Book {
    String author;
    String titel;
    String isbn;
    private int id;

    public Book(String author, String titel, String isbn, int id) {
        this.author = author;
        this.titel = titel;
        this.isbn = isbn;
        this.id = id;

    }
    public int getId(){
        return id;
    }
    @Override
    public boolean equals(Object otherObj) {
        if (otherObj == null || getClass() != otherObj.getClass()) return false;
        Book book = (Book) otherObj;
        return Objects.equals(id, book.id);
    }

    public String toString() {
        return String.format("""
                Author: %s
                Titel: %s
                ISBN: %s
                ID: %d""", author, titel, isbn, id);

    }

}

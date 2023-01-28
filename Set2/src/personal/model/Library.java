package personal.model;

import java.util.List;

public interface Library {
    List<Book> getAllBooks();
    String CreateBook(Book book);


    String CreateUser(Book book);

    void updateBook (Book book);

    void deleteByID(String inputId);
}

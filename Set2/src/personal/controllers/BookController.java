package personal.controllers;

import personal.model.Library;
import personal.model.Book;

import java.util.List;

public class BookController {
    private final Library library;

    public BookController(Library library) {
        this.library = library;
    }

    public void saveBook(Book book) throws Exception {
        validateBook(book);
        library.CreateBook(book);
    }

    public Book readBook(String BookId) throws Exception {
        List<Book> books = library.getAllBooks();
        for (Book book : books) {
            if (book.getId().equals(BookId)) {
                return book;
            }
        }

        throw new Exception("Book not found");
    }

    public List<Book> readList() {
        List<Book> result = library.getAllBooks();
        return result;
    }

    public void updateBook(String idNumber, Book newGuy) throws Exception {
        idPresenceValidation(idNumber);
        newGuy.setId(idNumber);
        validateBooksId(newGuy);
        library.updateBook(newGuy);
    }

    private void validateBook(Book book) throws Exception {

        if (book.getTitle().contains(" "))
            throw new Exception("Book name has unacceptable characters");
        if (book.getText().contains(" "))
            throw new Exception("Book name has unacceptable characters");
    }
    private void validateBooksId (Book book) throws Exception {

        if (book.getId().isEmpty())
            throw new Exception("Book not found");
        validateBook(book);
    }
    public void idPresenceValidation (String inutId) throws Exception {
        List<Book> books = library.getAllBooks();
        for (Book n: books){
            if(n.getId().equals(inutId))
                return;
        }
        throw new Exception("No such ID here");
    }

    public void deleteById(String delId) {
        library.deleteByID(delId);
    }
}

package personal.model;

import java.util.ArrayList;
import java.util.List;

public abstract class LibraryFile implements Library {
    private BookMapper mapper = new BookMapper();
    private FileOperation fileOperation;

    public LibraryFile(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    @Override
    public List<Book> getAllBooks() {
        List<String> lines = fileOperation.readAllLines();
        List<Book> books = new ArrayList<>();
        for (String line : lines) {
            books.add(mapper.map(line));
        }
        return books;
    }

    @Override
    public String CreateBook(Book book) {

        List<Book> books = getAllBooks();
        int max = 0;
        for (Book item : books) {
            int id = Integer.parseInt(item.getId());
            if (max < id){
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        book.setId(id);
        books.add(book);
        writeDown(books);
        return id;
    }

    @Override
    public void updateBook(Book book) {
        List<Book> books = getAllBooks();
        Book target = books.stream().filter(i->i.getId().equals(book.getId())).findFirst().get();
        target.setTitle(book.getTitle());
        target.setText(book.getText());
        target.setData(book.getData());
        writeDown(books);
        }
    @Override
    public void deleteByID(String inputId) {
        List<Book> books = getAllBooks();
        Book target = books.stream().filter(i->i.getId().equals(inputId)).findFirst().get();
        books.remove(target);
        writeDown(books);
    }
    private void  writeDown (List<Book> books){
        List<String> lines = new ArrayList<>();
        for (Book item: books) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
    }
}

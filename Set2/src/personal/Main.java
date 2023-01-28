package personal;

import personal.controllers.BookController;
import personal.model.*;
import personal.views.ViewBook;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperImp("books.txt");
        Library library = new LibraryFile(fileOperation) {
            @Override
            public String CreateUser(Book book) {
                return null;
            }
        };
        BookController controller = new BookController(library);
        ViewBook view = new ViewBook(controller);
        view.run();
    }
}

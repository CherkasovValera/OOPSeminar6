package personal.views;

import personal.controllers.BookController;
import personal.model.Book;

import java.util.List;
import java.util.Scanner;

public class ViewBook {

    private BookController bookController;

    public ViewBook(BookController bookController) {
        this.bookController = bookController;
    }

    public void run(){
        Commands com = Commands.NONE;

        while (true) {
            String command = prompt("Введите команду: ");
            com = Commands.valueOf(command.toUpperCase());
            if (com == Commands.EXIT) return;
            try {
            switch (com) {
                case CREATE:
                    String title = prompt("Заголовок: ");
                    String text = prompt("Текст: ");
                    String data = prompt("Дата: ");
                    bookController.saveBook(new Book(title, text, data));
                    break;
                case READ:
                    String id = prompt("Идентификатор заголовка: ");
                        Book book = bookController.readBook(id);
                        System.out.println(book);
                    break;
                case LIST:
                    List<Book> lst=bookController.readList();
                    lst.forEach(i-> System.out.println(i+"\n"));
                    break;
                case UPDATE:
                    String numId = prompt("Какую запись редактировать? Введите ID: ");
                    bookController.idPresenceValidation(numId);
                    bookController.updateBook(numId, creatAGuy());
                    break;
                case DELETE:
                    String delId = prompt("Какую запись удалить? Введите ID: ");
                    bookController.deleteById(delId);
                    break;
            }
            } catch (Exception e) {
                System.out.println("ERROR\n"+e.getMessage());
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
    private Book creatAGuy(){
        String title = prompt("Заголовок: ");
        String text = prompt("Текст: ");
        String data = prompt("Дата: ");
        Book newGuy = new Book(title, text, data);
        return newGuy;
    }

}

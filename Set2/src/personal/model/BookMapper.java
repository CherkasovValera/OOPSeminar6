package personal.model;

public class BookMapper {
    public String map(Book book) {
        return String.format("%s;%s;%s;%s", book.getId(), book.getTitle(), book.getText(), book.getData());

    }

    public Book map(String line) {
        String[] lines = line.split(";");
        return new Book(lines[0], lines[1], lines[2], lines[3]);
    }
}

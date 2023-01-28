package personal.model;

public class Book {
    private String id = "";
    private String title;
    private String text;
    private String data;

    public Book(String title, String text, String data) {
        this.title = title;
        this.text = text;
        this.data = data;
    }

    public Book(String id, String title, String text, String data) {
        this(title, text, data);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("Идентафикатор: %s\nЗаголовок: %s,\nТекст: %s,\nДата: %s", id, title, text, data);
    }
}

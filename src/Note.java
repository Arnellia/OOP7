import java.time.LocalDateTime;

public class Note {
    private LocalDateTime dateTime; //дата создания заметки
    private String description; //описание заметки

    public Note(LocalDateTime dateTime, String description) { //конструктор
        this.dateTime = dateTime;
        this.description = description;
    }

    public LocalDateTime getDateTime() { //геттер, возвращает значение
        return dateTime;
    }

    public String getDescription() { //геттер, возвращает значение
        return description;
    }

    @Override //переопределение метода из суперкласса
    public String toString() {
        return dateTime.toString() + ": " + description;
    }
}

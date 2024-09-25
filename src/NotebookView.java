import java.time.LocalDateTime;
import java.util.List;


public interface NotebookView {
    void showNotes(List<Note> notes);//метод отображения списка на экране
    void showMessage(String message);//метод отображения сообщения
    LocalDateTime getDateTimeInput();//метод возвращает дату
    LocalDateTime getDescriptionInput();//метод возвращает описание
    String getFileNameInput();//метод возвращает имя файла
}

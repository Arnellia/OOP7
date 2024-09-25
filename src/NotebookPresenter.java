import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class NotebookPresenter {
    private Notebook model;
    private NotebookView view;

    public NotebookPresenter(Notebook model, NotebookView view) { //конструктор
        this.model = model;
        this.view = view;
    }

    public void addNote() {//метод добавляет новую заметку
        LocalDateTime dateTime = view.getDateTimeInput();//получить дату
        String description = view.getDescriptionInput();//получить описание заметок
        model.add(new Note(dateTime, description));
        view.showMessage("Note added.");
    }

    public void showNotesForDay() {//метод отображает список заметок за день
        LocalDateTime dateTime = view.getDateTimeInput();
        List<Note> notes = model.getNotesForDay(dateTime);
        view.showNotes(notes);
        }

    public void showNotesForWeek() {//метод отображает заметки за неделю
        LocalDateTime startOfWeek = view.getDateTimeInput();//получает дату начала от пользователя
        List<Note> notes = model.getNotesForWeek(startOfWeek);//получает список заметок за неделю
        view.showNotes(notes);//отображает заметки
    }
    public void saveNotes() {//метод сохраняет заметки в файл
        String fileName = view.getFileNameInput(); try { //try-catch для отображения сообщения об ошибке
            model.saveToFile(fileName);
            view.showMessage("Notes saved to " + fileName); } catch (IOException e) {
            view.showMessage("Failed to save notes: " + e.getMessage());
        } }
    public void loadNotes() {//загружает заметки из файла
        String fileName = view.getFileNameInput();//ввод от пользователя
        try {//try-catch
            model.loadFromFile(fileName);
            view.showMessage("Notes loaded from " + fileName);
        } catch (IOException e) {
            view.showMessage("Failed to load notes: " + e.getMessage());
        }
    }
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; import java.util.List;
import java.util.Scanner;


public class ConsoleNotebookView implements NotebookView { //реализует интерфейс NotebookView
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void showNotes(List<Note> notes) {
        if (notes.isEmpty()) { //метод выводит заметки
            System.out.println("No notes found.");//если нет заметок
        } else {
            for (Note note : notes) {//если есть заметки
                System.out.println(note);
            }
        }
    }

    @Override
    public void showMessage(String message) { //выводит сообщения
        System.out.println(message);
    }

    @Override
    public LocalDateTime getDateTimeInput() { //запрос даты
        System.out.println("Enter date and time (yyyy-MM-dd'T'HH:mm):");
        String input = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME; //для парсинга (анализ и извлечение структурированой инф-ии)
        return LocalDateTime.parse(input, formatter);
    }

    @Override
    public LocalDateTime getDescriptionInput() { //запрос описания заметки
        System.out.println("Enter note description:");
        return LocalDateTime.parse(scanner.nextLine());
    }

    @Override
    public String getFileNameInput() { //запрос имени файла
        System.out.println("Enter file name:");
        return scanner.nextLine();
    }
}


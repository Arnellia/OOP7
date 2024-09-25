// getNotesForDay() метод относится к бизнес логике,
// сортировка должна учитывать временные метки

// getNotesForWeek() метод относится к бизнес логике
//сортировка должна учитывать временные метки

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.notes;

public class Notebook {
    private List<Note> notes = new ArrayList<>();
    public void add(Note note) { notes.add(note); //метод добавляет новые заметки
    }

    public List<Note> getNotes() { //метод возвращает список заметок
        return new ArrayList<>(notes); //конструктор, инкапсуляция данных
    }

    public List<Note> getNotesForDay(LocalDateTime dateTime) { //метод возвращает список заметок по дате
        //Stream API для сортировки по указанной дате
        return notes.stream()
        //логика фильтрации заметок по дате:
                .filter(note -> note.getDateTime().toLocalDate().isEqual(dateTime.toLocalDate())) //метод filter проверяет соответствие заметки и даты
                //метод getDataTime получает дату заметки и сравнивает ее с помощью метода isEqual с указанной датой
                .sorted(Comparator.comparing(Note::getDateTime)) .collect(Collectors.toList()); //метод сортировки по дате, comparing сравнивает, collect собирает отсортированные заметки
    }
    }

    //метод getNotesForWeek возвращает список заметок по неделям
public List<Note> getNotesForWeek(LocalDateTime startOfWeek) { LocalDateTime endOfWeek = startOfWeek.plusWeeks(1);//метод plusWeeks добавляет неделю
    return notes.stream()
            .filter(note -> !note.getDateTime().isBefore(startOfWeek) && !note.getDateTime().isAfter(endOfWeek)) //фильтр по дате -_-

            .sorted(Comparator.comparing(Note::getDateTime))
        .collect(Collectors.toList());//генерирует новый список

}


public void saveToFile(String fileName) throws IOException { //метод saveToFile оператор try-with-resourсes для правильного закрытия ресурсов даже если будет искл
    try (BufferedWriter writer = new BufferedWriter(new
            FileWriter(fileName))) { //запись в файл
        for (Note note : notes) { writer.write(note.toString()); writer.newLine();//цикл фор с вызовом метода write чтобы записать в файл
        }
    }

}
public void loadFromFile(String fileName) throws IOException { //метод чтения заметок с использованием try-with-resources
    notes.clear();//метод для очистки списка
    try (BufferedReader reader = new BufferedReader(new//для правильного закрытия ресурсов
            FileReader(fileName))) {
        String line;
        while ((line = reader.readLine()) != null) { //цикл while
            String[] parts = line.split(": ", 2); //метод split разделяет дату и заметки
            LocalDateTime dateTime = LocalDateTime.parse(parts[0]);
            String description = parts[1];
            notes.add(new Note(dateTime, description)); }
    }
}






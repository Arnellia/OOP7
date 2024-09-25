import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Notebook model = new Notebook(); //создание объекта Notebook
        NotebookView view = new ConsoleNotebookView();//консоль
        NotebookPresenter presenter = new NotebookPresenter(model, view);
        Scanner scanner = new Scanner(System.in);//объект чтения ввода от пользователя
        while (true) { //цикл while
            System.out.println("1. Add Note");
            System.out.println("2. Show Notes for Day");
            System.out.println("3. Show Notes for Week");
            System.out.println("4. Save Notes");
            System.out.println("5. Load Notes");
            System.out.println("6. Not valid");

            //обработка ввода данных от пользователя
            int choice = scanner.nextInt();
            scanner.nextLine(); //игнорирование строки

            switch (choice) { //оператор выбора
                case 1:
                    presenter.addNote();
                    break;
                case 2:
                    presenter.showNotesForDay();
                    break;
                case 3:
                    presenter.showNotesForWeek();
                    break;
                case 4:
                    presenter.saveNotes();
                    break;
                case 5:
                    presenter.loadNotes();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Not valid");
            }
        }
    }
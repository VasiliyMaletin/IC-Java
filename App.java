import Configs.Config;
import Core.Presenter;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class App {
    public static void buttonClick() {
        Presenter presenter = new Presenter(new ConsoleView(), Config.pathDb);
        presenter.loadFromFile();

        String command;

        while (true) {

            command = prompt("""
                    \n1 -> Добавить игрушку
                    2 -> Удалить игрушку
                    3 -> Начать розыгрыш
                    4 -> Список игрушек
                    5 -> Очистить список
                    6 -> Сохранить список в файл
                    7 -> Загрузить список из файла
                    8 -> Выход
                    Выберите пункт меню:\s""");
            if (command.equals("8")) {
                return;
            }
            try {
                switch (command) {
                    case "1" -> presenter.putForDrawing();
                    case "2" -> presenter.deleteFromDrawing();
                    case "3" -> presenter.getDrawing();
                    case "4" -> presenter.showAll();
                    case "5" -> presenter.clearAll();
                    case "6" -> presenter.saveToFile();
                    case "7" -> presenter.loadFromFile();
                    default -> System.out.println("\n Команда не найдена!");
                }
            } catch (Exception e) {
                System.out.println("Error. " + e.getMessage());
            }
        }
    }

    private static String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}

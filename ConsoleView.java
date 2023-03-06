import Configs.Config;
import Core.IView;
import Core.Toy;

import java.util.List;
import java.util.Scanner;

public class ConsoleView implements IView {
    Scanner in;

    public ConsoleView() {
        in = new Scanner(System.in);
    }

    @Override
    public int getToyId() {
        System.out.print("Идентификатор игрушки: ");
        return Integer.parseInt(in.nextLine());
    }

    @Override
    public String getToyNaming() {
        System.out.print("Название игрушки: ");
        return in.nextLine();
    }

    @Override
    public int getToyWeight() {
        System.out.print("Вес игрушки: ");
        return Integer.parseInt(in.nextLine());
    }

    @Override
    public void showAll(List<Toy> toys) {
        System.out.println("\nСписок всех игрушек:");
        for (Toy toy : toys) {
            System.out.println(toy);
        }
    }

    @Override
    public void showGetToy(Toy toy) {
        System.out.print("\nРезультаты розыгрыша: ");
        System.out.println(toy);
    }

    @Override
    public void loadMessage() {
        System.out.println("\nФайл загружен");
    }

    @Override
    public boolean clearAllDecision() {
        boolean f = false;
        System.out.print("\nВы уверены, что хотите удалить список игрушек? (y/n): ");
        if (in.nextLine().equalsIgnoreCase("Y")) {
            f = true;
        }
        return f;
    }

    @Override
    public void savedAll() {
        System.out.println("\nСохранено в файл: " + Config.pathDb);
    }

    @Override
    public void savedItem() {
        System.out.println("\nУспешно добавлено");
    }

    @Override
    public void saveError() {
        System.out.println("\nНе удалось сохранить");
    }

    @Override
    public void emptyListMessage() {
        System.out.println("\nСписок игрушек пуст!");
    }

    @Override
    public int getDrawTimes() {
        System.out.print("Сколько раз разыграть: ");
        return Integer.parseInt(in.nextLine());
    }
}

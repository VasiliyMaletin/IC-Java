package Core;

import java.util.ArrayList;
import java.util.List;

public class Drawing {
    private final List<Toy> toys;

    public Drawing() {
        this.toys = new ArrayList<>();
    }

    public boolean putForDrawing(Toy toy) {
        boolean flag = false;
        if (!toys.contains(toy)) {
            this.toys.add(toy);
            flag = true;
        }
        return flag;
    }

    public Toy getToy(int index) {
        return toys.get(index);

    }

    public void remove(int toyId) {
        if (indexContains(toyId) != -1) {
            toys.remove(indexContains(toyId));
            System.out.println("Удалено!");
        } else
            System.out.println("Удаление не выполнено. Идентификатор не найден!");
    }

    private int indexContains(int index) {
        int searchIndex = -1;
        for (Toy toy : toys) {
            if (toy.getId() == index)
                searchIndex = toys.indexOf(toy);
        }
        return searchIndex;
    }

    public List<Toy> getToys() {
        return toys;
    }

    public int count() {
        return toys.size();
    }
}

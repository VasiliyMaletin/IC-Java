package Core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Model {
    protected final Drawing currentDrawingService;
    private final String path;

    public Model(String path) {
        currentDrawingService = new Drawing();
        this.path = path;
    }

    public boolean load() {
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String toyId = reader.readLine();
            while (toyId != null) {
                String name = reader.readLine();
                String weight = reader.readLine();
                this.currentDrawingService.putForDrawing(new Toy(Integer.parseInt(toyId), name, Integer.parseInt(weight)));
                toyId = reader.readLine();
            }
            reader.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Ошибка! Пожалуйста, создайте файл " + path);
        }
        return true;
    }

    public void save() {

        try (FileWriter writer = new FileWriter(path, false)) {
            for (int i = 0; i < currentDrawingService.count(); i++) {
                Toy toy = currentDrawingService.getToy(i);
                writer.append(String.format("%s\n", toy.getId()));
                writer.append(String.format("%s\n", toy.getName()));
                writer.append(String.format("%s\n", toy.getWeight()));
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public Drawing currentDrawingService() {
        return this.currentDrawingService;
    }

    public void saveResult(String pathResult, List<Toy> toysList) {
        try (FileWriter writer = new FileWriter(pathResult, false)) {
            for (Toy toy : toysList) {
                writer.append(String.format("%s  ", toy.getId()));
                writer.append(String.format("%s  ", toy.getName()));
                writer.append(String.format("%s  ", toy.getWeight()));
                writer.append("\n");
                writer.flush();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

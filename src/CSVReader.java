import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static void readCSV(String fileName, Storage<Product> pencilStorage, Storage<Product> notebookStorage,
                               Storage<Equipment> maskStorage, Storage<Equipment> gloveStorage) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                String type = parts[0].trim();
                switch (type) {
                    case "Pencil":
                        String pencilColor = parts[1].trim();
                        double pencilPrice = Double.parseDouble(parts[2].trim());
                        int pencilQuantity = Integer.parseInt(parts[3].trim());
                        Pencil pencil = new Pencil(pencilPrice, pencilQuantity, pencilColor);
                        pencilStorage.add(pencil);
                        break;

                    case "Notebook":
                        int notebookPages = Integer.parseInt(parts[1].trim());
                        double notebookPrice = Double.parseDouble(parts[2].trim());
                        int notebookQuantity = Integer.parseInt(parts[3].trim());
                        Notebook notebook = new Notebook(notebookPrice, notebookQuantity, notebookPages);
                        notebookStorage.add(notebook);
                        break;

                    case "Mask":
                        String maskFastening = parts[1].trim();
                        double maskSafetyLevel = Double.parseDouble(parts[2].trim());
                        int maskQuantity = Integer.parseInt(parts[3].trim());
                        Mask mask = new Mask(maskSafetyLevel, maskQuantity, maskFastening);
                        maskStorage.add(mask);
                        break;

                    case "Glove":
                        String gloveSize = parts[1].trim();
                        double gloveSafetyLevel = Double.parseDouble(parts[2].trim());
                        int gloveQuantity = Integer.parseInt(parts[3].trim());
                        Glove glove = new Glove(gloveSafetyLevel, gloveQuantity, gloveSize);
                        gloveStorage.add(glove);
                        break;

                    default:
                        System.out.println("Unknown type: " + type);
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the CSV file.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number from CSV file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

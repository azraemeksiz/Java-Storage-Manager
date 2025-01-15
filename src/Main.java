import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Storage<Product> pencilStorage = new Storage<>();
        Storage<Product> notebookStorage = new Storage<>();
        Storage<Equipment> maskStorage = new Storage<>();
        Storage<Equipment> gloveStorage = new Storage<>();


        CSVReader.readCSV("items.csv", pencilStorage, notebookStorage, maskStorage, gloveStorage);

        // Test lines commented
        // pencilStorage.add(new Mask(3.0, 10, "Elastic"));
        // notebookStorage.add(new Glove(3.5, 5, "Medium"));
        // maskStorage.add(new Pencil(1.2, 50, "Yellow"));
        // gloveStorage.add(new Notebook(2.0, 20, 100));

        pencilStorage.sortByPrice();
        notebookStorage.sortByPrice();
        maskStorage.sortBySafetyLevel();
        gloveStorage.sortBySafetyLevel();

        System.out.println("Pencil Storage (with the increasing price):");
        pencilStorage.getItems().forEach(item -> System.out.println(item.getDescription()));

        System.out.println("Notebook Storage (with the increasing price):");
        notebookStorage.getItems().forEach(item -> System.out.println(item.getDescription()));

        System.out.println("Mask Storage (with the increasing safety level):");
        maskStorage.getItems().forEach(item -> System.out.println(item.getDescription()));

        System.out.println("Glove Storage (with the increasing safety level):");
        gloveStorage.getItems().forEach(item -> System.out.println(item.getDescription()));

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the quantity of the products: ");
        int quantity = scanner.nextInt();

        ArrayList<Product> allProducts = new ArrayList<>();
        allProducts.addAll(pencilStorage.getItems());
        allProducts.addAll(notebookStorage.getItems());

        double avgPrice = calculateAveragePriceOfCheapest(allProducts, quantity);
        System.out.println("Average price of the " + quantity + " cheapest products: " + avgPrice);

        System.out.print("Enter the minimum safety level for equipment: ");
        double minSafetyLevel = scanner.nextDouble();

        int count = maskStorage.searchForEquipment(minSafetyLevel) + gloveStorage.searchForEquipment(minSafetyLevel);
        System.out.println("Total quantity of equipment with safety level >= " + minSafetyLevel + ": " + count);

        scanner.close();
    }

        private static double calculateAveragePriceOfCheapest(ArrayList<Product> products, int quantity) {
        double totalPrice = 0;
        int remainingQuantity = quantity;

        Collections.sort(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));

        for (Product p : products) {
            int productQuantity = p.getQuantity();

            if (productQuantity <= remainingQuantity) {
                totalPrice += p.getPrice() * productQuantity;
                remainingQuantity -= productQuantity;
            } else {
                totalPrice += p.getPrice() * remainingQuantity;
                break;
            }

            if (remainingQuantity <= 0) {
                break;
            }
        }

        return (quantity > 0) ? totalPrice / quantity : 0;
    }
}

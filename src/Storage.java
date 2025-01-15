import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Storage<T> {
    private ArrayList<T> items;

    public Storage() {
        items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
    }

    public ArrayList<T> getItems() {
        return items;
    }

    public void sortByPrice() {
        Collections.sort(items, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1 instanceof Product && o2 instanceof Product) {
                    Product p1 = (Product) o1;
                    Product p2 = (Product) o2;
                    return Double.compare(p1.getPrice(), p2.getPrice());
                }
                return 0;
            }
        });
    }

    public void sortBySafetyLevel() {
        Collections.sort(items, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1 instanceof Equipment && o2 instanceof Equipment) {
                    Equipment e1 = (Equipment) o1;
                    Equipment e2 = (Equipment) o2;
                    return Double.compare(e1.getSafetyLevel(), e2.getSafetyLevel());
                }
                return 0;
            }
        });
    }

    public double searchForProduct(int quantity) {
        ArrayList<Product> sortedItems = new ArrayList<>();
        for (T item : items) {
            if (item instanceof Product) {
                sortedItems.add((Product) item);
            }
        }


        Collections.sort(sortedItems, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.getPrice(), p2.getPrice());
            }
        });

        double totalPrice = 0;
        int remainingQuantity = quantity;

        for (Product p : sortedItems) {
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

    public int searchForEquipment(double minSafetyLevel) {
        int count = 0;
        for (T item : items) {
            if (item instanceof Equipment) {
                Equipment e = (Equipment) item;
                if (e.getSafetyLevel() >= minSafetyLevel) {
                    count += e.getQuantity();
                }
            }
        }
        return count;
    }
}

public class Pencil extends Product {
    private String color;

    public Pencil(double price, int quantity, String color) {
        super(price, quantity);
        this.color = color;
    }

    @Override
    public String getDescription() {
        return "Pencil [Color: " + color + ", Price: " + getPrice() + ", Quantity: " + getQuantity() + "]";
    }
}

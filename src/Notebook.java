public class Notebook extends Product {
    private int numberOfPages;

    public Notebook(double price, int quantity, int numberOfPages) {
        super(price, quantity);
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String getDescription() {
        return "Notebook [Pages: " + numberOfPages + ", Price: " + getPrice() + ", Quantity: " + getQuantity() + "]";
    }
}

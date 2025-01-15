public class Glove extends Equipment {
    private String size;

    public Glove(double safetyLevel, int quantity, String size) {
        super(safetyLevel, quantity);
        this.size = size;
    }

    @Override
    public String getDescription() {
        return "Glove [Size: " + size + ", Safety Level: " + getSafetyLevel() + ", Quantity: " + getQuantity() + "]";
    }
}

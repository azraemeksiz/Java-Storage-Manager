public class Mask extends Equipment {
    private String fasteningType;

    public Mask(double safetyLevel, int quantity, String fasteningType) {
        super(safetyLevel, quantity);
        this.fasteningType = fasteningType;
    }

    @Override
    public String getDescription() {
        return "Mask [Fastening Type: " + fasteningType + ", Safety Level: " + getSafetyLevel() + ", Quantity: " + getQuantity() + "]";
    }
}

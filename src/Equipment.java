public abstract class Equipment {
    private double safetyLevel;
    private int quantity;

    public Equipment(double safetyLevel, int quantity) {
        this.safetyLevel = safetyLevel;
        this.quantity = quantity;
    }

    public double getSafetyLevel() {
        return safetyLevel;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract String getDescription();
}

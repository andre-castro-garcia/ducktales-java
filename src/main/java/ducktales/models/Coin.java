package ducktales.models;

public class Coin {

    private double Weight;

    private double Value;

    public Coin(double weight, double value) {
        Weight = weight;
        Value = value;
    }

    public double getWeight() { return Weight; }

    public double getValue() { return Value; }
}

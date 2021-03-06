package realtimebtcchart.dataproccessing;

/**
 * A Trade consists of a price, amount, and datestamp;
 */
public class Trade {

    private double price;
    private double amount;
    private long date;

    public Trade(double price, double amount, long date) {
        this.amount = amount;
        this.price = price;
        this.date = date;
    }

    public double getPrice() {
        return this.price;
    }

    public double getAmount() {
        return this.amount;
    }

    public long getDate() {
        return this.date;
    }

    @Override
    public String toString() {
        return "price: " + this.price + " date: " + date + " amount: " + this.amount;
    }
}

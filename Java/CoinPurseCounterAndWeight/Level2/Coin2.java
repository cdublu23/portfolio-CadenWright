public class Coin2 {
    private Denomination2 denomination;
    private int year;

    public Coin2(Denomination2 denomination, int year) {
        this.year = year;
        this.denomination = denomination;
    }

    public int getYear() {
        return year;
    }

    public double getValue() {
        return denomination.getValue();
    }

    @Override
    public String toString() {
        return year + " " + denomination.toString();
    }
}
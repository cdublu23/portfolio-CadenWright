public class Coin3 {
    private Denomination3 denomination;
    private int year;

    public Coin3(Denomination3 denomination, int year) {
        this.year = year;
        this.denomination = denomination;
    }

    public int getYear() {
        return year;
    }

    public double getValue() {
        return denomination.getValue();
    }
    public double getWeight(){
        switch(denomination){
            case penny: if(year < 1983) return 3.11;
            else return 2.5;
            case nickel: return 5.00;
            case dime: if (year < 1965) return 2.50;
            else return 2.268;
            case quarter: if (year < 1965) return 6.25;
            else return 5.67;
            default: return 0;
        }
    }

    @Override
    public String toString() {
        return year + " " + denomination.toString();
    }
}
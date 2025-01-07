public class Coin {
        private Denomination denomination;
        private int year;
    public Coin(Denomination denomination, int year){
        this.denomination = denomination;
        this.year = year;
    }
    public double getValue(){
        switch(denomination){
            case penny: return 0.01;
            case nickel: return 0.05;
            case dime: return 0.10;
            case quarter: return 0.25;
            default: return 0.00;
        }
        }
    public int getYear(){
            return year;
        }
}

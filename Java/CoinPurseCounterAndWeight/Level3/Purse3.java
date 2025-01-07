public class Purse3{
    
    public static void main(String [] args){
        Coin3[] coinArray = new Coin3[5];
        double value = 0;
        int lowestYear = 2025, mostYear = 1923;
        double weight = 0;

        coinArray[0] = new Coin3(Denomination3.penny, 2015);
        coinArray[1] = new Coin3(Denomination3.quarter, 1975);
        coinArray[2] = new Coin3(Denomination3.quarter, 2003);
        coinArray[3] = new Coin3(Denomination3.nickel, 1987);
        coinArray[4] = new Coin3(Denomination3.dime, 2023);

        for(Coin3 slot: coinArray){
            value += slot.getValue();
            int year = slot.getYear();
            weight += slot.getWeight();

            if(year < lowestYear){
                lowestYear = year;
            }
            else if(year > mostYear){
                mostYear = year;
            }
            System.out.println(slot);
        }
        System.out.printf("The value of the coins in your purse is:$%.2f\n",value);
        System.out.printf("The earlist year is %d, and the highest year is %d\n", lowestYear, mostYear);
        System.out.printf("The total weight of the coins in your purse is: %.3f\n", weight);
    }
}

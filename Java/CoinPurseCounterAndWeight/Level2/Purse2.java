public class Purse2{
    
    public static void main(String [] args){
        Coin2[] coinArray = new Coin2[5];
        double value = 0;
        int lowestYear = 2025, mostYear = 1923;

        coinArray[0] = new Coin2(Denomination2.penny, 2015);
        coinArray[1] = new Coin2(Denomination2.dime, 1975);
        coinArray[2] = new Coin2(Denomination2.quarter, 2003);
        coinArray[3] = new Coin2(Denomination2.nickel, 1987);
        coinArray[4] = new Coin2(Denomination2.dime, 2023);

        for(Coin2 slot: coinArray){
            value += slot.getValue();
            int year = slot.getYear();

            if(year < lowestYear){
                lowestYear = year;
            }
            else if(year > mostYear){
                mostYear = year;
            }
            System.out.println(slot);
        }
        System.out.printf("The value of the coins in your purse is:$%.2f\n",value);
        System.out.printf("The earlist year is %d, and the highest year is %d", lowestYear, mostYear);
    }
}

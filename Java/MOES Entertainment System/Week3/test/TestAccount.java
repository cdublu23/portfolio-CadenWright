package test;
import customer.Alacarte;
import customer.Unlimited;


public class TestAccount {
    public static void main(String [] args){
        Alacarte account1 = new Alacarte();
        Unlimited account2 = new Unlimited();

        if(account1.getAccountNumber() != 1){
            System.err.println("First Account not 1");
            System.out.println("Expected: 1");
            System.out.println("Actual: " + account1.getAccountNumber());
            System.exit(-1);
        }
        if(account2.getAccountNumber() != 2){
            System.err.println("Second Account not 2");
            System.out.println("Expected: 2");
            System.out.println("Actual: " + account2.getAccountNumber());
            System.exit(-1);
        }
    }
}

package customer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import product.Media;

public abstract class Account {
    private int accountNumber;
    private static int nextAccountNumber = 1;

    public Account(BufferedReader br)throws IOException{
        this.accountNumber = Integer.parseInt(br.readLine());
        if(this.accountNumber >= nextAccountNumber) {
            this.nextAccountNumber = this.accountNumber + 1;
        }
    }
    public void save(BufferedWriter bw)throws IOException{
        bw.write(Integer.toString(accountNumber));
        bw.write(Integer.toString(nextAccountNumber));
    }

    public Account(){
        this.accountNumber = nextAccountNumber;
        nextAccountNumber++;
    }
    public int getAccountNumber(){
        return this.accountNumber;
    }
    public abstract String play(Media media);
}

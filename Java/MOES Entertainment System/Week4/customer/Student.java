package customer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.rmi.UnexpectedException;

import product.Media;

public class Student {
    private String name;
    private int id;
    private String email;
    private Account account;
    
    public Student(BufferedReader br)throws IOException{
        this.name = br.readLine();
        this.id = Integer.parseInt(br.readLine());
        this.email = br.readLine();
        String s = br.readLine();
        if(s.equals("customer.Alacarte")){
            account = new Alacarte(br);
        }
        else if(s.equals("customer.Unlimited")){
            account = new Unlimited(br);
        }
        else throw new UnexpectedException("STUDENT CLASS BUFFERED READER********\n");
    }
    public void save(BufferedWriter bw)throws IOException{
        bw.write(name + "\n");
        bw.write(Integer.toString(id) + "\n");
        bw.write(email + "\n");
        bw.write(account.getClass().getName() + "\n");
    }

    public Student(String name, int id, String email, boolean alacarte){

        if( !email.endsWith("@mavs.uta.edu") && !email.endsWith("@uta.edu")){
            throw new IllegalArgumentException("Non-UTA email: "+ email);
        }
        else{
            this.name = name;
            this.id = id;
            this.email = email;
            if(alacarte){
                this.account = new Alacarte();
            }
            else this.account = new Unlimited();
            }
        }
    public String requestMedia(Media media){
        return account.play(media);
    }
    public Account getAccount(){ // This SHOULD assoociate the account with the student, allowing me to identify the account type
        return account;
    }
    @Override
    public String toString(){
        return name + " (" + id +", " + email + ", Account Number: " + account.getAccountNumber() + ")";
    }
}

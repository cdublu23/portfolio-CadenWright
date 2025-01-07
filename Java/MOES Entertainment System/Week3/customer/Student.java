package customer;
import product.Media;

public class Student {
    private String name;
    private int id;
    private String email;
    private Account account;

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

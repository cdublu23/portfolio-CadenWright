public class Account {
    private int accountNumber;
    private static int nextAccountNumber = 3;

    public Account(){
        this.accountNumber = nextAccountNumber;
        nextAccountNumber++;
    }
    public int getAccountNumber(){
        return this.accountNumber;
    }
    public String play(Media media){
        return "playing" + media.toString();
    }
}

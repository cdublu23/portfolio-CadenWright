public class Student {
    private String name;
    private int id;
    private String email;
    private Account account;

    public Student(String name, int id, String email, Account account){

        if( !email.endsWith("@mavs.uta.edu") && !email.endsWith("@uta.edu")){
            throw new IllegalArgumentException("Non-UTA email: "+ email);
        }
        else{
            this.name = name;
            this.id = id;
            this.email = email;
            this.account = account;
        }
    }
    public String requestMedia(Media media){
        return account.play(media);
    }
    @Override
    public String toString(){
        return name + " (" + id +", " + email + ", " + account.getAccountNumber() + ")";
    }
}

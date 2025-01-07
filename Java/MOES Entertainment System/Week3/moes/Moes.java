package moes;
import java.util.ArrayList;

import customer.Alacarte;
import customer.Student;
import product.Media;
import customer.Account;
import customer.Unlimited;

public class Moes {
    private static ArrayList<Media> library = new ArrayList<>();
    private static ArrayList<Student> customers =  new ArrayList<>();

    public void addMedia(Media media){
        library.add(media);

    }
    String tst = "";
    public String getMediaList(){
        for(int i=0; i < library.size(); i++){
            Media media = library.get(i);
            tst += i + ")\t" + media.toString() + "\n";
        }
        return tst;
    }
    public void addStudent(Student student){
        customers.add(student);
    }
    String tst2 = "";
    public String getStudentList(){
        for(int j=0; j < customers.size(); j++){
            Student student = customers.get(j);
            tst2 += j + ")\t" + student.toString() + "\n";
        }
        return tst2;
    }

    public int getPoints(int studentIndex){
        Student student = customers.get(studentIndex);
        Account account = student.getAccount();

        if(account instanceof Alacarte){
            Alacarte instanceofAlacarte = (Alacarte) account;
            return instanceofAlacarte.getPointsRemaining();
        }
        if(account instanceof Unlimited){
            return Integer.MAX_VALUE;
        }
        else throw new UnsupportedOperationException("Unknown Subclass Unknown");

    }
    public String buyPoints(int studentIndex, int points){
        Student student = customers.get(studentIndex);
        Account account = student.getAccount();

        if(account instanceof Alacarte){
            Alacarte instanceofAlacarte = (Alacarte) account;
            try{
                instanceofAlacarte.buyPoints(points);
                return "\nPoints purchased";
            }catch(Exception e){ return "Error purchasing points" + e.getMessage();} // Have to add try catch for first statement so you can
        }                                                                               //add else to the next if statement (weird)
        else if(account instanceof Unlimited){
            return "This account type does not need points!";
        }
        else throw new UnsupportedOperationException("Unknown Subclass of Account");
    }
    public String playMedia(int studentIndex, int mediaIndex){
        Student student = customers.get(studentIndex);
        Media media = library.get(mediaIndex);

        return student.requestMedia(media);
    }
}

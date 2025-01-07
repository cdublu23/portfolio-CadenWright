package mdi;

import moes.Moes;
import customer.Student;
import product.Media;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private Moes moes;
    private String output;
    private Menu menu;
    private boolean running;
    private final String extension = ".txt";
    private final String magicCookie = "P0tAt0";
    private final String fileVersion = "0.4";
    private String filename = "";


    private void newMoes(){
        moes = new Moes();
        output = "Starting... \n\n";

    }
    private void save(){
        if(filename == null){
            output += "Need file name\t----\tUse SaveAs to specify a name\n";
            return;
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
            bw.write(magicCookie + "\n");
            bw.write(fileVersion + "\n");
            moes.save(bw);
            output += "Saved in " + filename + ".\n";

        }catch(IOException io){
            output += "Could not save file " + io.getMessage() + "\n";
            return;
        }

    }
    private void saveAs(){
        System.out.println("Current file name: " + filename + "\n");
        String newFilename = menu.getString("Enter a new file name(Press Enter to cancel): ", null, null);
        if(newFilename.isEmpty()){
            output += "Save Canceled....\n";
            return;
        }
        else if(!newFilename.endsWith(extension)){
            newFilename += extension;
            output += "Extension Added\n";
        }
        filename = newFilename;
        save();

    }
    private void open(){
        System.out.println("Current filename: " + filename);
        String newFilename = menu.getString("Enter the name of the file you would like to open(Press Enter to cancel): ", null, null);
        if(newFilename.isEmpty()){
            output += "Open canceled...\n";
            return;
        }
        if(!newFilename.endsWith(extension)){
            newFilename += extension;
            output += "Extension Added\n";
        }
        try(BufferedReader br = new BufferedReader(new FileReader(newFilename))){
            String checkCookie = br.readLine();
            String checkFileVersion = br.readLine();
            if(!checkCookie.equals(magicCookie)){
                throw new IOException("Magic Cookie not at the start of file!\n");
            }
            else if(!checkFileVersion.equals(fileVersion)){
                throw new IOException("Incorrect or Missing file version!");
            }
        moes = new Moes(br);
        filename = newFilename;
        output += "Opened: " + filename + "\n";


        }catch(IOException e){
            output += "Could not open file " + e.getMessage() + "\n";
            return;
        }
    }

    private void addStudent(){
        String name = menu.getString("Enter Student Name: ", null, null);
        int id = menu.getInt("Enter Student ID number: ", null, null);
        String email = menu.getString("Enter Student Email: ", name, name);
        boolean alacarte = (menu.getInt("\n(0)Unlimited\n(1)Alacarte\n", null,null)) == 1; //Checks true/false

        Student student = new Student(name, id, email, alacarte);
        moes.addStudent(student);
        output += "\nStudent Added: " + student.toString() + "\n";

    }
    private void listStudents(){
        System.out.println("\n[STUDENT LIST]\n");
        output += moes.getStudentList();
    }
    private void addMedia(){
        String name = menu.getString("Enter the name of the media: ", null, null);
        String url = menu.getString("Enter the URL link for the media: ", null, null);
        int points = menu.getInt("How many points does this media cost? ", null, null);

        Media media = new Media(name, url, points);
        moes.addMedia(media);
        output += "\nMedia Added: " + media.toString() + "\n";
    }
    private void playMedia(){
        int studentIndex = menu.getInt("What is the student's index? ", null, null);
        int mediaIndex = menu.getInt("What is the media's index? ", null, null);

        output += "\n" + moes.playMedia(studentIndex, mediaIndex) + "\n";
        
    }
    private void listMedia(){
        System.out.printf("\n[MEDIA LIST]\n");
        output += "\n" + moes.getMediaList()+"\n";
    }
    private void listAvailablePoints(){
        int studentIndex = menu.getInt("Enter the Student Index: ", null, null);
        int points = moes.getPoints(studentIndex); 
        output += "\nStudent has " + points + " points available\n";
    }
    private void buyPoints(){
        int studentIndex = menu.getInt("Enter the Student Index: ", null, null);
        int additional = menu.getInt("How many points would you like to buy? ", null, null);
        try{if(additional < 0){
            throw new IllegalArgumentException("No negative points!");
        }
        else moes.buyPoints(studentIndex, additional);
        output += "\nPoints purchased: " + additional + "\n";
    }catch(IllegalArgumentException e){
        return;
    }
    }
    public Main(){              //Constructor for class Main
        moes = new Moes();
        output = ""; 
        menu = new Menu();

        menu.addMenuItem(new MenuItem("Exit", () -> endApp()));
        menu.addMenuItem(new MenuItem("Save", () -> save()));
        menu.addMenuItem(new MenuItem("SaveAs", () -> saveAs()));
        menu.addMenuItem(new MenuItem("Open", () -> open()));
        menu.addMenuItem(new MenuItem("Start Over\n\n", () -> newMoes()));

        menu.addMenuItem(new MenuItem("Purchase Points", () -> buyPoints()));
        menu.addMenuItem(new MenuItem("Available Points\n\n", () -> listAvailablePoints()));

        menu.addMenuItem(new MenuItem("Add Student", () -> addStudent()));
        menu.addMenuItem(new MenuItem("Add Media\n\n", () -> addMedia()));
        menu.addMenuItem(new MenuItem("Play Media", () -> playMedia()));
        menu.addMenuItem(new MenuItem("List Students", () -> listStudents()));
        menu.addMenuItem(new MenuItem("List Media\n\n", () -> listMedia()));

    }
    public static void main(String [] args){
        Main app = new Main();

        app.mdi();
    }
    private void mdi(){
        running = true;
        while(running){
            System.out.println(output);
            output = ""; //No repeat steps

            System.out.println(menu);
            Integer command = menu.getInt("What would you like to do? \n", null, null); // int can't hold NULL, so you have to use Integer
            if(command != null){                                                                //type instead.
                menu.run(command);
            }
            else System.out.println("Invalid entry\n");
        }
    }
    private void endApp(){
        System.out.print("Exiting Program....");
        running = false;
    }
}
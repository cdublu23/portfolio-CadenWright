package customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import product.Media;

public class Unlimited extends Account{
    @Override
    public String play(Media media){
        return "playing" + media.toString();
    }
    public Unlimited(){
        super();
    } 
    public Unlimited(BufferedReader br)throws IOException{
        super(br);              //(this reaches to the superclass bufferreader constructor).
    }
    public void save(BufferedWriter bw)throws IOException{
        super.save(bw);             //this reaches to the superclass save method and saves what is stored in unlimited(i think)
    }
}

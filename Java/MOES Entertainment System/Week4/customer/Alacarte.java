package customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import product.Media;

public class Alacarte extends Account{
    private int pointsRemaining;

    public Alacarte(){
        super();
        this.pointsRemaining = pointsRemaining;
    } 
    public Alacarte(BufferedReader br)throws IOException{
        super(br);
        this.pointsRemaining = Integer.parseInt(br.readLine());
    }
    public void save(BufferedWriter bw)throws IOException{
        super.save(bw);
        bw.write(Integer.toString(pointsRemaining) + "\n");
    }

    public int buyPoints(int points){
        return pointsRemaining += points;
    }

    public int getPointsRemaining(){
        return pointsRemaining;
    }
    @Override
    public String play(Media media){
        if(pointsRemaining >= media.getPoints()){
            return "Playing " + media.toString();
        }
        else{return "\nBuy more points: Requires " + media.getPoints() + " points. You have: " + pointsRemaining + "remaining.";} 
    }
}

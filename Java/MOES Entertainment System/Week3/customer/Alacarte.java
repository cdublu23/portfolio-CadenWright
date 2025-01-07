package customer;

import product.Media;

public class Alacarte extends Account{
    private int pointsRemaining;

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

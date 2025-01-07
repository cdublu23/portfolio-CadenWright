package product;

/**
 * @author          Caden Wright
 * @version         0.2
 * @since           0.1
 * 
 * Initializes the fields for Media
 * @param url       initializes the url of the media
 * @param title     initializes the title of the media
 * @param points    initializes the points cost of the media
 * @since           0.1
 * 
 * Overrides toString
 * @returns         title, url, points cost
 * @since           0.1
 * 
 * Get points cost
 * @returns         points
 * @since           0.1
 */

public class Media{
    private String title;
    private String url;
    private int points;

    public Media(String url, String title, int points){
        this.url = url;
        this.title = title;
        this.points = points;
    }
    @Override
    public String toString(){
        return title + " " + "(" + url + ") " + "Points: " + points;
    }
    public int getPoints(){
        return points;
    }
}
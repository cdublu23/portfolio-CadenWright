public class TestMedia {
    public static void main(String [] args){
        Media sampleMedia = new Media("https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0", 
        "The Little Shop of Horrors");

        String expectedString = 
        "The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0)";

        String actualString = sampleMedia.toString();
        
        if(!expectedString.equals(actualString)){
            System.err.println("FAIL");
            System.out.println("Expected: " + expectedString);
            System.out.println("Actual: " + sampleMedia);
            System.exit(-1);
        }

    }
}
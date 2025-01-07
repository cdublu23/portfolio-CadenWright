public class Media{
    private String title;
    private String url;

    public Media(String url, String title){
        this.url = url;
        this.title = title;
    }
    @Override
    public String toString(){
        return title + " " + "(" + url + ")";
    }
}
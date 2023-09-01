package demo2;

/**
 *
 * class mo ta 1 bo phim : cach viet bo khoi tao doi tuong
 */
public class Movie {

    //object initializer
    public String id = "M01", name="Alibaba", runtime="1h30m";
    public float rating = 7.5f;
    
    
    @Override
    public String toString() {
        return String.format("%s, %s, %s, %.2f", id, name, runtime, rating);
    }

    private void setLayout() {
        System.out.println("setup UI");
    }
    
    public static void main(String[] args) {
        Movie m = new Movie();
        System.out.println("movie: " + m);
    }
    
}

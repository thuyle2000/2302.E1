package demo;

/**
 *
 * class mo ta 1 bo phim : cach viet co dien
 */
public class Movie {

    public String id, name, runtime;
    public float rating;

    //constructor
    public Movie() {
        id = "M01";
        name = "Alibaba";
        runtime = "1h30m";
        rating = 7.5f;
        
        setLayout();
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %.2f", id, name, runtime, rating);
    }

    public static void main(String[] args) {
        Movie m = new Movie();
        System.out.println("movie: " + m);
    }

    private void setLayout() {
        System.out.println("setup UI");
    }
    
}

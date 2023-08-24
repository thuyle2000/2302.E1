
package demo;

/**
 *
 * lop con ke thua tu class Laptop
 */
public class Tablet extends Laptop{

    @Override
    public String toString() {
        return String.format("Tablet: %s, %s, %d", id,name, price);
    }
    
}

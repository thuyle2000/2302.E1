/*  thread dem so  */
package demo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Counting extends Thread{
    public int delay, tab, count;

    public Counting() {
        delay=500; //ms
        tab = 0;
        count =20;
    }

    public Counting(int delay, int tab, int count) {
        this.delay = delay;
        this.tab = tab;
        this.count = count;
    }
    

    
    @Override
    public void run() {
        String name = getName();
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < tab; j++) {
                System.out.print("\t");
            }
            System.out.printf("%s - counting: %2d \n",name, i+1);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}

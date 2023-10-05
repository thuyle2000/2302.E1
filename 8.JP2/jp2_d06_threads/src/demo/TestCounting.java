/*
demo cach hoat dong cua Thread
 */
package demo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestCounting {

    public static void main(String[] args) {
        Counting t1 = new Counting(); t1.setName("Viet");
        Counting t2 = new Counting(200,1, 40); t2.setName("Huy");
        Counting t3 = new Counting(1200,2, 15); t3.setName("Mai");
        t1.start();
        t2.start();
        t3.start();
       
        Thread t4 = new Thread(new Drawing(300,4,12)); t4.setName("Hoang");
        Thread t5 = new Thread(new Drawing(200,3,15)); t5.setName("Nhan");
        t4.start();
        t5.start();
        
        System.out.printf("\n *** active threads : %d \n", Thread.activeCount());
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(TestCounting.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("FINISHED DEMO !");
    }
    
}

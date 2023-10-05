/*
Thread ve hinh tron, chu nhat, tam giac, binh hanh, thoi
 */
package demo;

import java.util.Random;

public class Drawing implements Runnable {

    public int delay, tab, count;
    private String[] shapes = {"hinh tron", "hinh tam giac", "hinh chu nhat", "hinh thoi"};
    private String[] colors = {"xanh", "do", "tim", "vang", "trang", "den"};

    public Drawing() {
        delay = 500;
        tab = 0;
        count = 10;
    }

    public Drawing(int delay, int tab, int count) {
        this.delay = delay;
        this.tab = tab;
        this.count = count;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        String hinh ="", mau="";
        int n_hinh = shapes.length;
        int n_mau = colors.length;
        int i_hinh=0, i_mau=0;
        Random r = new Random();
        
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < tab; j++) {
                System.out.print("\t");
            }
            i_hinh = r.nextInt(n_hinh);
            i_mau = r.nextInt(n_mau);
            
            System.out.printf("%s - drawing: %2d, %s-%s \n", name, i + 1, shapes[i_hinh], colors[i_mau]);
            
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}

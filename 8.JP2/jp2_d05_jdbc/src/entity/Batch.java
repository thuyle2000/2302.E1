/*  mo ta cau truc bang tbBatch  */
package entity;

import java.util.Scanner;

public class Batch {

    public String batchno, description;
    public int fee;

    public Batch() {
    }

    public Batch(String batchno, String description, int fee) {
        this.batchno = batchno;
        this.description = description;
        this.fee = fee;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %d", batchno, description, fee);
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap thong tin lop hoc moi");
        while (true) {
            System.out.print(" - nhap ma lop hoc [4 ky tu bat ky]: ");
            batchno = sc.nextLine().trim();
            if (batchno.length() == 4) {
                break;
            }
        }
        while (true) {
            System.out.print(" - nhap chuong trinh hoc [toi da 20 ky tu]: ");
            description = sc.nextLine().trim();
            if (description.length() >= 2 && description.length() <= 20) {
                break;
            }
        }
        
        while(true){
            try {
                System.out.print(" - nhap hoc phi (0-10000]: ");
                fee = Integer.parseInt(sc.nextLine().trim());
                if(fee>0 && fee<=10000){
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}

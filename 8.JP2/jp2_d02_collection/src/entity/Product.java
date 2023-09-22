/*
mo ta cau truc san pham, bao gom:
-thuoc tinh: id, name, price, co
-phuong thuc: input(), toString()
 */
package entity;

import java.util.Scanner;
import java.util.regex.*;

public class Product {

    public String id, name, co;
    public int price;

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %d, %d", id, name, co, price, hashCode());
    }

    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public boolean equals(Object obj) {
        Product p = (Product) obj;
        return this.id.equalsIgnoreCase(p.id);
    }

    
    
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" nhap thong tin SP");

        //nhap ma sp
        while (true) {
            System.out.print(" - ma SP (Pxxx): ");
            id = sc.nextLine().trim();
            if (Pattern.matches("P\\d{3}", id)) {
                break;
            }
            System.out.println(" >> Loi: id KO HOP LE !");
        }

        //nhap ten sp
        System.out.print(" - ten SP: ");
        name = sc.nextLine().trim();

        //nhap cc xuat xu
        while (true) {
            System.out.print(" - chung chi xuat su (vn/tl/us): ");
            co = sc.nextLine().trim();
            if (Pattern.matches("(?i)(vn|tl|us)", co)) {
                break;
            }
            System.out.println(" >> Loi: co KO HOP LE !");
        }

        //nhap don gia
        while (true) {
            try {
                System.out.print(" - don gia (>=0): ");
                price = Integer.parseInt(sc.nextLine().trim());
                if(price>=0) break;
                
                throw new Exception("Don gia phai >=0");
            } catch (Exception e) {
                System.out.println(" >> Loi: " + e.getMessage());
            }
        }
    }
}

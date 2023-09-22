/*
chuong trinh quan ly danh sach cac san pham, bao gom chuc nang:
    - them moi
    - in danh sach
    - tim kiem
    - xoa theo ma so
    - thoat 
 */
package demoSet;

import java.util.Scanner;
import entity.Product;

public class ProductCP {

    public static void main(String[] args) {
        new ProductCP().menu();
    }

    private void menu() {
        Scanner sc = new Scanner(System.in);
        String op = "";
        ProductHashSet pa = new ProductHashSet();

        while (true) {
            System.out.println("\n  --- MENU ---");
            System.out.println("1. Them san pham");
            System.out.println("2. In danh sach sp");
            System.out.println("3. Xoa sp theo ma so");
            System.out.println("4. Tim kiem sp theo ten");
            System.out.println("5. Ket thuc chuong trinh ");
            System.out.print(" >> nhap ma so chuc nang [1-5]: ");
            op = sc.nextLine().trim();
            switch (op) {
                case "1" -> {
                    Product p = new Product();
                    p.input();
                    pa.create(p);
                }
                case "2" ->
                    pa.display();
                case "3" -> {
                    System.out.print(" >> nhap ma so SP: ");
                    pa.remove(sc.nextLine().trim());
                }
                case "4" -> {
                    System.out.print(" >> nhap ten SP: ");
                    pa.display(sc.nextLine().trim());
                }
                case "5" -> {
                    return;
                }
                default ->
                    System.err.println("Loi: Nhap sai ma chuc nang !");
            }

        }
    }
}

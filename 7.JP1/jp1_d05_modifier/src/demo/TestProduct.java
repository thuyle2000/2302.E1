/*
chuong trinh quan ly danh sach cac san pham, bao gom cac chuc nang :
    - them
    - in danh sach
    - tim kiem
    - xoa
 */
package demo;

import java.util.Scanner;

public class TestProduct {

    public static void main(String[] args) {
       menu();
    }
 
    private static void menu(){
        ProductArray pa = new ProductArray();
        String op ="";
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("\n === MENU ===");
            System.out.println(" Cua hang : " + Product.store);
            System.out.println("1. Them san pham");
            System.out.println("2. In danh sach san pham");
            System.out.println("3. Tim san pham theo ma so");
            System.out.println("4. Xoa san pham theo ma so");
            System.out.println("5. Ket thuc chuong trinh ");
            System.out.print("  Nhap ma chuc nang [1-5]: ");
            op = sc.nextLine().trim();
            
            switch (op) {
                case "1":
                    pa.add();
                    break;
                case "2":
                    pa.display();
                    break;
                case "3":
                    System.out.print(" >> nhap ma SP: ");
                    pa.search(sc.nextLine().trim());
                    break;
                case "4":
                    System.out.print(" >> nhap ma SP: ");
                    pa.remove(sc.nextLine().trim());                    
                    break;
                case "5":
                    return;
                default:
                    System.out.println(" >> LOI: nhap sai ma so chuc nang !");
                    break;
            }
        }
    }
}

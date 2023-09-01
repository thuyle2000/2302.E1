/*
    chuong trinh test chuc nang cua StudentCatalog 
 */
package demo_array;

import java.util.Scanner;

public class TestStudentCatalog {
    public static void main(String[] args) {
        TestStudentCatalog tc = new TestStudentCatalog();
        tc.menu();
    }
    
    private void menu(){
        Scanner sc = new Scanner(System.in);
        String op = "";
        StudentCatalog stc = new StudentCatalog();
        
        while(true){
            System.out.println("\n +++ MENU +++");
            System.out.println("1. Them sinh vien");
            System.out.println("2. Xem danh sach");
            System.out.println("3. Xoa sinh vien theo ma so");
            System.out.println("4. Thay doi thong tin sinh vien");
            System.out.println("5. Ket thuc");
            System.out.print(" >> nhap ma so chuc nang [1-5]:  ");
            op = sc.nextLine().trim();
            
            switch (op) {
                case "1":
                    stc.add();
                    break;
                case "2":
                    stc.display();
                case "3": break;
                case "4": break;
                case "5": return;
                default:
                    System.out.println("\n LOI: Nhap sai ma so chuc nang !");
                    break;
            }
        }
    }
}

/*
Chuong trinh quan ly cac doi tuong hinh hoc, bao gom cac chuc nang :
 - them hinh tron,
 - them hinh chu nhat
 - in ds cac doi tuong hinh hoc
 - tim va in ra cac hinh co dt theo yc
 - tim va in ra cac hinh tron
 */
package app;

import java.util.Scanner;
import entity.*;

public class TestShapeList {

    public static void main(String[] args) {
        TestShapeList p = new TestShapeList();
        p.menu();
    }

    void menu() {
        String op = "";
        Scanner sc = new Scanner(System.in);
        ShapeList p = new ShapeList();

        while (true) {
            System.out.println("\n +++ MENU +++");
            System.out.println(" ============");
            System.out.println("1. them hinh tron");
            System.out.println("2. them hinh chu nhat");
            System.out.println("3. xem ds cac hinh tron & chu nhat");
            System.out.println("4. xem ds cac hinh tron");
            System.out.println("5. xem ds cac hinh vuong");
            System.out.println("6. tim va in ra cac hinh co dien tich theo yc");
            System.out.println("7. ket thuc chuong trinh");
            System.out.print("\n >> nhap ma chuc nang [1-6]: ");
            op = sc.nextLine().trim();
            switch (op) {
                case "1":
                    if (p.index >= p.max) {
                        System.err.println(">> LOI: HT het bo nho luu tru ! ");
                    } else {
                        Shape o = new Circle();
                        o.input();
                        p.add(o);
                    }
                    break;
                case "2":
                    if (p.index >= p.max) {
                        System.err.println(">> LOI: HT het bo nho luu tru ! ");
                    } else {
                        Shape o = new Rectangle();
                        o.input();
                        p.add(o);
                    }
                    break;
                case "3":
                    p.display();
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    return;
                default:
                    break;
            }

        }
    }
}

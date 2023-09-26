/*  chupng trinh QL sinh vien trong tap hop Vector  */
package app;

import entity.Student;
import java.util.*;

public class StudentVector {

    public static void main(String[] args) {
        StudentVector v = new StudentVector();
        v.menu();
    }

    private void menu() {
        Scanner sc = new Scanner(System.in);
        String op = "";
        while (true) {
            System.out.println("\n MENU");
            System.out.println("1. Them sv ");
            System.out.println("2. Xem danh sach sinh vien");
            System.out.println("3. THOAT");
            System.out.print("chon chuc nang tu 1-3: q");
            op = sc.nextLine();

            switch (op) {
                case "1" -> createStudent();

                case "2" -> printAll();
                
                case "3" -> {
                    return;
                }
            }

        }
    }
    Vector ds = new Vector();

    //ham tao 1 dt sinh vien, cho nhap lieu chi tiet va luu vo ds
    private void createStudent() {
        Scanner sc = new Scanner(System.in);
        Student<String, Character, Float> sv = new Student<>();

        System.out.println("Nhap thong tin sinh vien :");
        System.out.print(" - nhap id: ");
        sv.id = sc.nextLine().trim();
        System.out.print(" - nhap ho ten: ");
        sv.name = sc.nextLine().trim();
        System.out.print(" - nhap gioi tinh: ");
        sv.gender = sc.nextLine().trim().charAt(0);
        System.out.print(" - nhap diem KQ: ");
        sv.mark = Float.parseFloat(sc.nextLine().trim());

        ds.add(sv);
    }

    private void printAll() {
        if (ds.isEmpty()) {
            System.out.println("LOI: danh sach chua co du lieu! ");
            return;
        }

        System.out.println("\n Danh sach sinh vien");
        ds.forEach(x -> System.out.println(x));
    }
}

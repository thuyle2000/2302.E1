/*  chupng trinh QL sinh vien trong tap hop 2 cot: Hashtable  */
package app;

import entity.Student;
import java.util.*;

public class StudentHashtable {

    public static void main(String[] args) {
        StudentHashtable p = new StudentHashtable();
        p.menu();
    }

    private void menu() {
        Scanner sc = new Scanner(System.in);
        String op = "";
        while (true) {
            System.out.println("\n MENU");
            System.out.println("1. Them sv ");
            System.out.println("2. Xem danh sach tat ca sinh vien");
            System.out.println("3. Xem danh sach sinh vien nam");
            System.out.println("4. Xem danh sach sinh vien nu");
            System.out.println("5. THOAT");
            System.out.print("chon chuc nang tu 1-5: ");
            op = sc.nextLine();

            switch (op) {
                case "1" ->
                    createStudent();
                case "2" ->
                    printAll();
                case "3" ->
                    printAll(true);
                case "4" ->
                    printAll(false);
                case "5" -> {
                    return;
                }
            }

        }
    }

    Hashtable<Integer, Student> ds = new Hashtable<>();

    //ham tao 1 dt sinh vien, cho nhap lieu chi tiet va luu vo ds
    private void createStudent() {
        Scanner sc = new Scanner(System.in);
        Student<Integer, Boolean, String> sv = new Student<>();

        System.out.println("Nhap thong tin sinh vien :");
        System.out.print(" - nhap id: ");
        sv.id = Integer.valueOf(sc.nextLine().trim());
        System.out.print(" - nhap ho ten: ");
        sv.name = sc.nextLine().trim();
        System.out.print(" - nhap gioi tinh (Nam/Nu): ");
        sv.gender = sc.nextLine().trim().equalsIgnoreCase("Nam");
        System.out.print(" - nhap diem KQ: ");
        sv.mark = sc.nextLine().trim();

        ds.put(sv.id, sv);
    }

    //ham in ds sinh vien
    private void printAll() {
        if (ds.isEmpty()) {
            System.out.println("LOI: danh sach chua co du lieu! ");
            return;
        }

        System.out.println("\n Danh sach sinh vien");
        ds.values().forEach(x -> System.out.println(x));
    }

    //ham in ds sinh vien nam hoac nu 
    private void printAll(boolean gender) {
        if (ds.isEmpty()) {
            System.out.println("LOI: danh sach chua co du lieu! ");
            return;
        }

        System.out.printf("\n Danh sach sinh vien %s \n", gender ? "nam" : "nu");
        ds.values().stream().filter(x -> x.gender.equals(gender)).forEach(System.out::println);
    }

}

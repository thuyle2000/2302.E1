/*
mo ta cau truc Sinh Vien, bao gom cac:
 - thuoc tinh du lieu: id, ho ten, gioi tinh, nam sinh
 - phuong thuc xu ly: input(), output() 
 */
package entity;

import java.util.Scanner;

public class Student {
    public String id, name;
    public boolean gender;
    public int yob;
    
    //ham dung (constructor)
    public Student() {
        id="ST01"; name = "no name"; gender=true;yob=2005;
    }
    
    //ham dung co tham so (parameterized constructor)
    public Student(String id, String name, boolean gender, int yob) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.yob = yob;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong tin sinh vien");
        
        System.out.print(" - nhap id: ");
        id = sc.nextLine().trim();
        
        System.out.print(" - nhap ho ten: ");
        name = sc.nextLine().trim();
        
        System.out.print(" - nhap gioi tinh (nam|nu): ");
        gender = sc.nextLine().trim().equalsIgnoreCase("nam");
        
        System.out.print(" - nhap nam sinh: ");
        yob = sc.nextInt();
    }

    @Override
    public String toString() {
        return String.format("%-4s %-25s %-3s %4d", id, name, gender?"nam":"nu", yob);
    }
    
    public static void main(String[] args) {
        Student sv = new Student();
        sv.input();
        Student sv2 = new Student();
        sv2.input();
        
        System.out.println(sv);
        System.out.println(sv2);
    }
}

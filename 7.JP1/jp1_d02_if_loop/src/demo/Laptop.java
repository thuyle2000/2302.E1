/*
 * mo ta cau truc Laptop, bao gom:
    - thuoc tinh: ma so, ten, dvtinh, don gia, thoi gian bao hanh
    - phuong thuc: 
        input() : nhap thong tin sp, 
        toString() : tra ve chuoi mo ta thong tin sp
 */
package demo;

import java.util.Scanner;

public class Laptop {

    String id, name;
    private String unit;
    protected float price;
    public int warranty;

    //ham dung (constructor) ko tham so
    public Laptop() {
//        id = "P01";
//        name = "Lenovo";
//        price = 149.99F;
//        warranty = 24;
        input();
    }

    //ham dung co doi so
    public Laptop(String id, String name, String unit, float dongia, int warranty) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.price = dongia;
        this.warranty = warranty;

    }

    //tra ve chuoi mo ta thong tin may tinh laptop
    @Override
    public String toString() {
        return String.format("id=%s, name=%s, price=%.2f, warranty=%d(months)", id, name, price, warranty);
    }

    //ham nhap thong tin sp
    public void input() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print(" - nhap id: ");
            id = sc.nextLine().trim();
            if (id.length() >= 2) {
                break;
            }
            System.out.println(" >> id ko hop le (phai co it nhat 2 ky tu) !");
        }

        while (true) {
            System.out.print(" - nhap ten SP: ");
            name = sc.nextLine().trim();
            if (name.length() < 2 || name.length() > 30) {
                System.out.println(" >> Ten SP ko hop le (tu 2 -> 30 ky tu) !");
                continue;
            }
            break;
        }

        System.out.print(" - nhap DVT: ");
        unit = sc.nextLine().trim();

        while (true) {
            System.out.print(" - nhap don gia: ");
            price = sc.nextFloat();
            if (price < 0) {
                System.out.println(" >> Don gia ko hop le (phai >= 0) !");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print(" - nhap tg bao hanh: ");
            warranty = sc.nextInt();
            if (warranty < 0) {
                System.out.println(" >> TG ko hop le (phai >= 0) !");
                continue;
            }
            break;
        }
    }

    //test
    public static void main(String[] args) {
        Laptop p2 = new Laptop("P10", "Compaq HP", "unit", 200.49F, 12);
//        Laptop p2 = new Laptop();
//        p2.id = "P10";
//        p2.name = "Compaq HP";
//        p2.unit = "unit";
//        p2.price = 200.49F;
//        p2.warranty = 12;

        System.out.println("p2: " + p2);

        Laptop p = new Laptop();
        System.out.println("p: " + p);

    }
}

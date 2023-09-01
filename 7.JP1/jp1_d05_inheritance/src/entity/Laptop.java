/*
La con cua class Product, mo ta cau truc cua may tinh xach tay
 */
package entity;

import java.util.Scanner;

public class Laptop extends Product {

    public float weight;
    public float size;

    public Laptop() {
        weight = 1.2F;
        size = 10F;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", %.2f(kg), %.2f(inch)", weight, size);
    }

    @Override
    protected void input() {
        super.input(); // goi ham input() cua lop cha (Product)

        //lenh xu ly nhap them kich thuoc va trong luong cua may tinh
        Scanner sc = new Scanner(System.in);
        System.out.print(" - nhap kich thuoc man hinh (inch) : ");
        size = Float.parseFloat(sc.nextLine().trim());
        System.out.print(" - nhap trong luong (kg) : ");
        weight = Float.parseFloat(sc.nextLine().trim());
    }

    public static void main(String[] args) {
        Laptop p = new Laptop();
        p.input();
        System.out.println(p);
    }

}

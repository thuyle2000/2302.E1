/*
La lop con cua lop [Shape]
 */
package entity;

import java.util.Scanner;

public class Rectangle extends Shape {

    public float w, h;

    @Override
    public double area() {
        return w * h;
    }

    @Override
    public double peripheral() {
        return (w + h) * 2;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(" >> nhap chieu rong (>0): ");
            w = Float.parseFloat(sc.nextLine().trim());
            if (w > 0) {
                break;
            }
        }

        while (true) {
            System.out.print(" >> nhap chieu cao (>0): ");
            h = Float.parseFloat(sc.nextLine().trim());
            if (h > 0) {
                break;
            }
        }
    }
}

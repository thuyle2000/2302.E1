/*  demo exceptions  */
package demo;

import java.util.Scanner;
import java.io.*;


public class TestException {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(" - nhap so nguyen thu 1: ");
        int a = Integer.parseInt(sc.nextLine().trim());
        System.out.print(" - nhap so nguyen thu 2: ");
        int b = Integer.parseInt(sc.nextLine().trim());
        System.out.print(" - nhap phep toan [ + - * / ]: ");
        String op = sc.nextLine().trim();
        TestException t = new TestException();
        try {
            t.calc(a, b, op);
        } catch (ArithmeticException e) {
            System.out.println("Loi: " + e.getMessage());
        }

        System.out.println("FINISHED !");
    }

    private void calc(int a, int b, String op) throws ArithmeticException {
        switch (op) {
            case "+" ->
                System.out.printf("%d+%d = %d\n", a, b, a + b);
            case "-" ->
                System.out.printf("%d-%d = %d\n", a, b, a - b);
            case "*" ->
                System.out.printf("%d*%d = %d\n", a, b, a * b);
            case "/" -> {
                if (b == 0) {
                    throw new ArithmeticException("Mau so bang 0 !");
                }
                System.out.printf("%d/%d = %d\n", a, b, a / b);
            }
            default ->
                throw new AssertionError();
        }
    }
    
    
    
}

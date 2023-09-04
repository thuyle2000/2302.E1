/*
chuong trinh cai dat may tinh casio
 */
package demo;

import java.util.Scanner;

public class TestCasio {

    public static void main(String[] args) {
        TestCasio tc = new TestCasio();
        tc.menu();

    }

    double a, b;
    int n;

    private void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap so thu 1: ");
        a = Double.parseDouble(sc.nextLine().trim());
        System.out.print("nhap so thu 2: ");
        b = Double.parseDouble(sc.nextLine().trim());
    }

    private void inputN() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("nhap so nguyen [1-20]: ");
            n = Integer.parseInt(sc.nextLine().trim());
            if (n >= 1 && n <= 20) {
                break;
            }
        }
    }

    private void menu() {
        Casio ca = new Casio();
        Scanner sc = new Scanner(System.in);
        String op = "";
        while (true) {
            System.out.println("\n === MY CASIO ===");
            System.out.println("1. cong 2 so");
            System.out.println("2. tru 2 so");
            System.out.println("3. nhan 2 so ");
            System.out.println("4. chia 2 so");
            System.out.println("5. tinh giai thua");
            System.out.println("6. ket thuc");
            System.out.print("\n chon chuc nang [1-6]: ");
            op = sc.nextLine().trim();
            if (op.equals("6")) {
                return;
            } else if (op.equals("5")) {
                inputN();
                System.out.printf("\n %d! =%.0f", n, ca.factorial(n));
            } else {
                input();
                switch (op) {
                    case "1" ->
                        System.out.printf("\n %.2f + %.2f = %.2f \n", a, b, ca.add(a, b));
                    case "2" ->
                        System.out.printf("\n %.2f - %.2f = %.2f \n", a, b, ca.sub(a, b));
                    case "3" ->
                        System.out.printf("\n %.2f * %.2f = %.2f \n", a, b, ca.mul(a, b));
                    case "4" ->
                        System.out.printf("\n %.2f / %.2f = %.2f \n", a, b, ca.div(a, b));
                    default ->
                        System.out.println("\n Chon sai ma chuc nang !");
                }
            }
        }
    }
}

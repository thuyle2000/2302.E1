/*
chuong trinh cai dat may tinh casio
 */
package demo;

import java.util.Scanner;

public class TestCasio {

    public static void main(String[] args) {

    }

    double a, b;
    int n;

    private void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap so thu 1: ");
        a = Double.parseDouble(sc.nextLine().trim());
        System.out.println("nhap so thu 2: ");
        b = Double.parseDouble(sc.nextLine().trim());
    }

    private void inputN() {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("nhap so nguyen [1-20]: ");
            n = Integer.parseInt(sc.nextLine().trim());
            if (n>=1 && n<=20){
                break;
            }
        }
    }
    
    private void menu(){
        Casio ca = new Casio();
        Scanner sc = new Scanner(System.in);
        String op ="";
        while (true){
            System.out.println("\n === MY CASIO ===");
            System.out.println("1. cong 2 so");
            System.out.println("2. tru 2 so");
            System.out.println("3. nhan 2 so ");
            System.out.println("4. chia 2 so");
            System.out.println("5. tinh giai thua");
            System.out.println("6. ket thuc");
            System.out.print("\n chon chuc nang [1-6]: ");
            op = sc.nextLine().trim();
            switch (op) {
                case "1":
                    input();
                    System.out.printf("\n %.2f + %.2f = %.2f \n", a, b, ca.add(a, b));
                    break;
                case "2": break;
                case "3": break;
                case "4": break;
                case "5": inputN();
                System.out.printf("\n %d! =%.0f", n, ca.factorial(n));
                    break;
                case "6": return;
            }
        }
    }
}

/*
Demo cach lam viec voi mang 2 chieu
 */
package demo_array;

import java.util.Random;
import java.util.Scanner;

public class Demo2 {

    private void demo_2d_array() {
        Scanner sc = new Scanner(System.in);
        int n = 0;

        while (true) {
            System.out.print(" >> nhap so nguyen n [3-6]: ");
            n = sc.nextInt();
            if (n >= 3 && n <= 6) {
                break;
            }
        }

        Random r = new Random();
        //khai bao 3 ma tran vuong nxn a[], b[], c[]
        int[][] a = new int[n][n];
        int[][] b = new int[n][n];

        //khoi tao gia tri ngau nhien cho ma tran a[][], b[][]
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = r.nextInt(0, 20);
                b[i][j] = r.nextInt(5, 25);
            }
        }

        //in ma tran a[][] va b[][] ra man hinh
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d ", a[i][j]);
            }

            System.out.print("    ");
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d ", b[i][j]);
            }

            System.out.print("      ");
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d ", a[i][j]+ b[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Demo2 p = new Demo2();
        p.demo_2d_array();
    }
}

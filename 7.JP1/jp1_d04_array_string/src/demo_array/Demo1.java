/*
demo cach su dung mang so nguyen 1 chieu 
 */
package demo_array;

import java.util.Random;
import java.util.Scanner;

public class Demo1 {
    private void demo_single_array(){
        Scanner sc = new Scanner(System.in);
        System.out.print(" >> Nhap so phan tu [3-10]: ");
        int n = sc.nextInt();
        
        //khai bao mang so nguyen co n-phan tu
        int[] a ;
        //cap phat bo nho
        a = new int[n];
        
        Random r = new Random();
        //khoi tao cac phan tu trong mang a[]
        for (int i = 0; i < a.length; i++) {
            //gan so ngau nhien tu 0-100 cho phan tu i cua mang a
            a[i] = r.nextInt(0, 100);
        }
        
        //in mang a[] ra man hinh
        System.out.printf("\n >> Day so ngau nhien %d-phan tu: \n", n );
        for (int item : a) {
            System.out.printf("%4d ", item);
        }
        System.out.println("\n");
   }
    
    private void demo_string_array(){
        int n =10;
        //khai bao mang ds[] chua toi da n-phantu
        String[] ds = new String[n];
        
        Scanner sc = new Scanner(System.in);
        int cnt = 0;    //bien dem so phan tu da duoc khoi tao trong mang ds[]
        for (int i = 0; i < ds.length; i++) {
            System.out.printf(" >> nhap chuoi thu %d: ", i+1);
            ds[i] = sc.nextLine().trim();
            if(ds[i].length()==0){
                break; //ket thuc nhap lieu khi user nhap chuoi rong
            }
            cnt++;
        }
        
        System.out.println("\n Danh sach chuoi da nhap: ");
        for (int i = 0; i < cnt; i++) {
            System.out.printf(" %2d. %s \n", i+1, ds[i]);
        }
    }

        
    public static void main(String[] args) {
        Demo1 p = new Demo1();
        p.demo_single_array();
        p.demo_string_array();
    }
}

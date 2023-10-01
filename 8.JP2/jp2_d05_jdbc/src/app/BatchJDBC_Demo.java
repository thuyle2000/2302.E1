/*
chuong trinh quan ly danh muc cac lop hoc trong bang tbBatch
 */
package app;

import entity.*;
import java.util.ArrayList;
import java.util.Scanner;
public class BatchJDBC_Demo {
    public static void main(String[] args) {
        new BatchJDBC_Demo().menu();
    }

    private void menu() {
        Scanner sc = new Scanner(System.in);
        String op ="";
        while(true){
            System.out.println("\n MENU");
            System.out.println("1. xem danh sach cac lop hoc");
            System.out.println("2. them lop hoc moi");
            System.out.println("3. xoa lop hoc");
            System.out.println("4. doi hoc phi");
            System.out.println("5. ket thuc");
            System.out.println("----------------");
            System.out.print(" vui long nhap ma so [1-5]: ");
            op = sc.nextLine().trim();
            
            switch (op) {
                case "1":
                    display();
                    break;
                case "2": break;
                case "3": break;
                case "4": break;
                case "5": return;
                
            }
        }
    }

    private void display() {
        ArrayList<Batch> ds = BatchDAO.get();
        if(ds.isEmpty()){
            System.err.println("LOI: HT chua co du lieu !");
            return;
        }
        
        System.out.println("\n Danh sach cac lop hoc");
        ds.forEach(System.out::println);
    }
    
}

/*
Chuong trinh quan ly san pham trong tap hop HashSet
    1. them san pham moi
    2. xem ds san pham
    3. luu ds san pham vo tap tin van ban
    4. ket thuc
 */
package demo;

import java.io.*;
import java.util.*;
import entity.Product;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Product_IO {

    public static void main(String[] args) {
        new Product_IO().menu();
    }

    private HashSet<Product> ds = new HashSet<>();
    private void menu() {
        Scanner sc = new Scanner(System.in);
        String op = "";
        while(true){
            System.out.println("\n === MENU === \n");
            System.out.println("1. them san pham moi");
            System.out.println("2. in danh sach san pham");
            System.out.println("3. luu ds san pham");
            System.out.println("4. ket thuc chuong trinh");
            System.out.println("========================");
            System.out.print(" >> nhap ma so chuc nang [1-4]: ");
            op = sc.nextLine().trim();
            switch (op) {
                case "1":
                    create();
                    break;
                case "2":
                    display();
                    break;
                case "3":
                    saveFileText();
                    break;
                case "4":
                    return;
                default:
                    System.err.println("LOI: Nhap sai ma so chuc nang !");
            }
        }
    }

    private void create() {
        Product p = new Product();
        p.input();
        if(ds.add(p)){
            System.out.println(" >> Them san pham moi thanh cong ! ");
        }
        else{
            System.err.println(" >> LOI: ID da ton tai. Tu choi thao tac! ");
        }
    }
    
    private void display() {
        if(ds.isEmpty()){
            System.err.println(" >> LOI: He thong chua co du lieu !");
            return;
        }
        
        System.out.println("\n Danh sach san pham");
        ds.stream().forEach(System.out::println);
    }

    private String fName = "product.txt";
    private void saveFileText() {
        if(ds.isEmpty()){
            System.err.println(" >> LOI: He thong chua co du lieu !");
            return;
        }
        //luu ds san pham vo tap tin "product.txt", dang van ban.
        try {
            //1. open file
            PrintWriter pw = new PrintWriter(fName);
            
            //2. ghi noi dung cua [ds] vo file
            //ds.stream().forEach(item-> pw.println(item));
            ds.stream().forEach(pw::println);
            
            //3.close file
            pw.close();
            
            System.out.println(">> Da luu file thanh cong !");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Product_IO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

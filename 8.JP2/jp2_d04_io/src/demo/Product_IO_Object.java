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
import java.nio.file.Path;


public class Product_IO_Object {

    public static void main(String[] args) {
        new Product_IO_Object().menu();
    }

    private HashSet<Product> ds = new HashSet<>();

    private void menu() {
        
        readFileObject();
        
        Scanner sc = new Scanner(System.in);
        String op = "";
        while (true) {
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
                    saveFileObject();
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
        if (ds.add(p)) {
            System.out.println(" >> Them san pham moi thanh cong ! ");
        } else {
            System.err.println(" >> LOI: ID da ton tai. Tu choi thao tac! ");
        }
    }

    private void display() {
        if (ds.isEmpty()) {
            System.err.println(" >> LOI: He thong chua co du lieu !");
            return;
        }

        System.out.println("\n Danh sach san pham");
        ds.stream().forEach(System.out::println);
    }

    private String fName = "product.bin";

    private void saveFileObject() {
        if (ds.isEmpty()) {
            System.err.println(" >> LOI: He thong chua co du lieu !");
            return;
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fName))) {
            
            oos.writeObject(ds);
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void readFileObject(){
        java.nio.file.Path path = Path.of(fName);
        if(java.nio.file.Files.exists(path)){
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fName))) {
                ds = (HashSet<Product>) ois.readObject();
                
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            
        }
    }

}

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
        String op = "";
        while (true) {
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
                case "2":
                    create();
                    break;
                case "3":
                    delete();
                    break;
                case "4":
                    update();
                    break;
                case "5":
                    return;

            }
        }
    }

    private void display() {
        ArrayList<Batch> ds = BatchDAO.get();
        if (ds.isEmpty()) {
            System.err.println("LOI: HT chua co du lieu !");
            return;
        }

        System.out.println("\n Danh sach cac lop hoc");
        ds.forEach(System.out::println);
    }

    private void create() {
        Batch b = new Batch();
        b.input();
        if(BatchDAO.get(b.batchno)==null){
            System.err.println("LOI: ma lop da co. Tu choi thao tac !");
            return;
        }
        
        if (BatchDAO.create(b) > 0) {
            System.out.println(" >> Them lop hoc moi thanh cong !");
        }
        else{
            System.err.println(" >> LOI: them moi that bai !!!");
        }
    }

    private void update() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" - nhap ma lop muon doi hoc phi: ");
        String id = sc.nextLine().trim();
        Batch b = BatchDAO.get(id);
        if(b==null){
            System.err.printf(">>LOI: lop hoc co ma so [%s] ko ton tai !\n", id);
            return;
        }
        System.out.println(">> Thong tin lop hoc: ");
        System.out.println("\tma lop: "+ b.batchno);
        System.out.println("\tchuong trinh: " + b.description);
        System.out.println("\thoc phi: "+ b.fee);
        
        System.out.print("\n - nhap hoc phi moi: ");
        b.fee = Integer.parseInt(sc.nextLine().trim());
        
        if(BatchDAO.update(b)>0){
            System.out.println(" >> Thay doi hoc phi thanh cong !");
        }
        else{
            System.err.println(" >> Thay doi hoc phi that bai !");
        }
    }

    private void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" - nhap ma lop muon xoa: ");
        String id = sc.nextLine().trim();
        if(BatchDAO.remove(id)>0){
            System.out.println(" >> Da xoa lop hoc thanh cong");
        }
        else{
            System.err.println(" >> Xoa lop hoc that bai !");
        }
    }

}

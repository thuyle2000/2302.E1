/*
quan ly danh sach sinh vien trong ArrayList ds, thuc hien cac chuc nang:
    - them sinh vien
    - in danh sach sinh vien
    - xoa sv theo ma so
    - thay doi thong tin sinh vien theo ma so
 */
package demo_array;

import entity.Student;
import java.util.ArrayList;

public class StudentArraylist {

    ArrayList ds = new ArrayList();

    //phuong thuc them sinh vien moi vo ds
    public void add() {

        Student sv = new Student(); // tao 1 bien doi tuong sv
        sv.input();                 // nhap thong tin cho bien sv
        ds.add(sv);                 // luu bien sv vo ds

        System.out.println(">> Hoan tat thao tac them sv moi !");
    }

    //phuong thuc in ds sinh vien
    public void display() {
        if (ds.isEmpty()) {
            System.out.println(" >> Loi: HT chua co du lieu !");
            return;
        }

        System.out.println("\n Danh sach sinh vien");
//        for (int i = 0; i < ds.size(); i++) {
//            System.out.println(ds.get(i));
//        }

        for (Object item : ds) {
            System.out.println(item);
        }
    }

    //phuong thuc xoa sinh vien theo ma so [st_id]
    public void remove(String st_id) {
        if (ds.isEmpty()) {
            System.out.println(" >> Loi: HT chua co du lieu !");
            return;
        }
        
        //tim sv co ma so [st_id] trong ds
        for (Object item : ds) {
            Student sv = (Student) item;
            if(sv.id.equals(st_id)){
                ds.remove(item);
                System.out.println(" >> Da xoa thanh cong !");
                return;
            }
        }
        System.out.printf(" >> Loi: Ko tim thay sv co ma so [%s] !\n", st_id);        
    }

}

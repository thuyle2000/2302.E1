/*
quan ly danh sach sinh vien trong mang ds[], thuc hien cac chuc nang:
    - them sinh vien
    - in danh sach sinh vien
    - xoa sv theo ma so
    - thay doi thong tin sinh vien theo ma so
 */
package demo_array;

import entity.Student;
public class StudentCatalog {
    int n = 5;
    Student[] ds = new Student[n] ;
    int cnt =0;
    
    //phuong thuc them sinh vien moi vo ds[]
    public void add(){
        if(cnt>=n){
            System.out.println(" >> Loi: HT het cho luu tru !");
            return;
        }
        Student sv = new Student(); // tao 1 bien doi tuong sv
        sv.input();                 // nhap thong tin cho bien sv
        ds[cnt] = sv;               // luu bien sv vo mang ds[]
        cnt++;                      // cap nhat bien dem so luong sv trong he thong
        System.out.println(">> Hoan tat thao tac them sv moi !");
    }
    
    
    //phuong thuc in ds sinh vien
    public void display(){
        if(cnt==0){
             System.out.println(" >> Loi: HT chua co du lieu !");
             return;
        }
        
        System.out.println("\n Danh sach sinh vien");
        for (int i = 0; i < cnt; i++) {
            System.out.println(ds[i]);
        }
    }
    
}

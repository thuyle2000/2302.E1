/*
class luu tru danh sach cac doi tuong hinh hoc (hinh tron va hinh chu nhat), 
cai dat cac phuong thuc : 
 - them hinh moi vo ds, 
 - in ds cac doi tuong hinh hoc
 - tim va in ra cac hinh co dt theo yc
 - tim va in ra cac hinh tron

 */
package entity;

import java.util.Scanner;
public class ShapeList {
    public int max = 10;
    public int index = 0;
    public Shape[] ds = new Shape[max];
   
    public void add(Shape newShape){
        if(index == max){
            System.err.println(" >> LOI: he thong het bo nho !\n");
            return;
        }
        
        ds[index] = newShape;
        index++;
        System.out.println(" Da them hinh moi thanh cong !");
    }
    
    
    // phuong thuc in ds cac doi tuong hinh hoc
    public void display(){
        if(index==0){
            System.err.println(" >> LOI: HT chua co du lieu ! \n");
            return;
        }
        System.out.println("\n Danh sach cac hinh : ");
        for (int i = 0; i < index; i++) {
            if (ds[i] instanceof Circle){
                System.out.println("Hinh tron    : " + ds[i]);
            }
            else{
                System.out.println("Hinh chu nhat: " + ds[i]);
            }
            
        }
    }
    
}

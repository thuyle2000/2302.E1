/*
  class [ProductArrayList] co nhiem vu:
    - luu cac san pham (doi tuong [Product]) vo trong ArrayList
    - di kem voi cac chuc nang:
      1. Them san pham moi vo ArrayList (C)
      2. In danh sach san pham trong ArrayList (R)
      3. Xoa san pham trong ArrayList theo ma so (D)
      4. Tim san pham trong ArrayList theo ten (ma so, don gia ...)
 */
package demoList;

import entity.Product;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductArrayList {

    private ArrayList ds = new ArrayList();  //tao ra 1 danh sach rong.

    //1. ham them sp moi vo [ds]
    public void create(Product p) {
        //dua san pham moi [p] vo danh sach [ds]
        ds.add(p);

        System.out.println(" >> Them sp moi thanh cong. ");
    }

    //2. ham in danh sach san pham
    public void display() {
        if (ds.isEmpty()) {
            System.err.println(" >> LOI: He thong chua co du lieu !");
            return;
        }

        System.out.println("\n Danh sach san pham");
        ds.forEach(System.out::println);
    }

    //3. ham xoa san pham trong [ds] theo ma so
    public void remove(String id) {
        if (ds.isEmpty()) {
            System.err.println(" >> LOI: He thong chua co du lieu !");
            return;
        }

        //tim sp co ma so [id] trong [ds]
//        for (Object item : ds) {
//            Product p = (Product) item;
//            if (p.id.equalsIgnoreCase(id)) {
//                ds.remove(item);
//                System.out.printf(" >> Da xoa sp co ma so [%s] !", id);
//                return;
//            }
//        }
        for (int i = 0; i < ds.size(); i++) {
            Product p = (Product) ds.get(i);
            if (p.id.equalsIgnoreCase(id)) {
                ds.remove(i);
                System.out.printf(" >> Da xoa sp co ma so [%s] !", id);
                return;
            }
        }

        System.err.println(" >> LOI: Ko tim thay sp muon xoa !");
    }

    //4. ham tim san pham theo ten
    public void display(String tenSP) {
        if (ds.isEmpty()) {
            System.err.println(" >> LOI: He thong chua co du lieu !");
            return;
        }
        
        Pattern p = Pattern.compile(tenSP, Pattern.CASE_INSENSITIVE);
        Matcher m = null;
        int cnt = 0;
        for (Object item : ds) {
            Product sp = (Product) item;
            m = p.matcher(sp.name);
            if(m.find()){
                System.out.println(sp);
                cnt++;
            }
        }
        if(cnt == 0){
            System.err.println(" >> LOI : Ko tim thay !!!");
        }
    }
}

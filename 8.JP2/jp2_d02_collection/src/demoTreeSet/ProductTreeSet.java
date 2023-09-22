/*
  class [ProductTreeSet] co nhiem vu:
    - luu cac san pham (doi tuong [Product]) vo trong TreeSet
    - di kem voi cac chuc nang:
      1. Them san pham moi vo TreeSet (C)
      2. In danh sach san pham trong TreeSet (R)
      3. Xoa san pham trong TreeSet theo ma so (D)
      4. Tim san pham trong TreeSet theo ten (ma so, don gia ...)
 */
package demoTreeSet;

import entity.Product;
import java.util.*;

public class ProductTreeSet {

    private TreeSet<Product> ds2 = new TreeSet<>();  //tao ra 1 danh sach rong.
    
    private TreeSet<Product> ds = new TreeSet<>((o1, o2) -> {
        return o1.id.compareTo(o2.id);
    });

    //1. ham them sp moi vo [ds]
    public void create(Product p) {
        //dua san pham moi [p] vo danh sach [ds]
        if(ds.add(p)){
            System.out.println(" >> Them sp moi thanh cong. ");
        }
        else{
            System.err.println(" >> LOI: id da ton tai. Tu choi thao tac !");
        }
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
        for (Product item : ds) {
            if (item.id.equalsIgnoreCase(id)) {
                ds.remove(item);
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
        
        var ten = tenSP.trim().toLowerCase();
        var cnt = ds.stream().filter(x->x.name.toLowerCase().contains(ten)).count();
        if(cnt == 0){
            System.err.println(" >> LOI : Ko tim thay !!!");
            return;
        }
        ds.stream().filter(x->x.name.toLowerCase().contains(tenSP)).forEach(System.out::println);
            
    }
}

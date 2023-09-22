/*
  class [ProductHashMap] co nhiem vu:
    - luu cac san pham (doi tuong [Product]) vo trong HashMap
    - di kem voi cac chuc nang:
      1. Them san pham moi vo HashMap (C)
      2. In danh sach san pham trong HashMap (R)
      3. Xoa san pham trong HashMap theo ma so (D)
      4. Tim san pham trong HashMap theo ten (ma so, don gia ...)
 */
package demoMap;

import entity.Product;
import java.util.*;

public class ProductHashMap {

    private HashMap<String, Product> ds = new HashMap<>();  //tao ra 1 danh sach rong.

    //1. ham them sp moi vo [ds]
    public void create(Product p) {
        //dua san pham moi [p] vo danh sach [ds]
        if (ds.containsKey(p.id)) {
            System.err.println(" >> LOI: id da ton tai. Tu choi thao tac !");
        } else {
            ds.put(p.id, p);
            System.out.println(" >> Them sp moi thanh cong. ");
        }
    }

    //2. ham in danh sach san pham
    public void display() {
        if (ds.isEmpty()) {
            System.err.println(" >> LOI: He thong chua co du lieu !");
            return;
        }

        System.out.println("\n Danh sach san pham");
        ds.values().forEach(System.out::println);
    }

    //3. ham xoa san pham trong [ds] theo ma so
    public void remove(String id) {
        if (ds.isEmpty()) {
            System.err.println(" >> LOI: He thong chua co du lieu !");
            return;
        }

        //tim sp co ma so [id] trong [ds]
        for (Product item : ds.values()) {
            if (item.id.equalsIgnoreCase(id)) {
                ds.remove(id);
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
        var cnt = ds.values().stream().filter(x -> x.name.toLowerCase().contains(ten)).count();
        if (cnt == 0) {
            System.err.println(" >> LOI : Ko tim thay !!!");
            return;
        }
        ds.values().stream().filter(x -> x.name.toLowerCase().contains(tenSP)).forEach(System.out::println);

    }
}

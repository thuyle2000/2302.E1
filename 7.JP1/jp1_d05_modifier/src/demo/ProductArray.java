/*
la tap hop (array)luu tru cac san pham , cai dat cac phuong thuc:
    - them sp
    - xuat ds san pham
    - tim sp
    - xoa sp
 */
package demo;

public class ProductArray {

    int max = 10;
    int index = 0;
    Product[] ds = new Product[max];

    //ham xu ly them 1 san pham vo ds[]
    public void add() {
        if (index == max) {
            System.out.println(" >> LOI: he thong het bo nho luu tru !");
            return;
        }

        //tao 1 san pham moi
        Product p = new Product();
        p.input(); //goi ham input() tren doi tuong p, de nhap thong tin cho san pham p
        ds[index++] = p; //luu san pham moi p vo mang ds[]
        System.out.println(" Them san pham moi thanh cong.");
    }

    public void display() {
        if (index == 0) {
            System.out.println(" >> HT chua co du lieu !");
            return;
        }

        System.out.println("\n +++ Danh sach san pham +++");
        for (int i = 0; i < index; i++) {
            System.out.println(ds[i]);
        }
    }

    public void search(String sid) {
        if (index == 0) {
            System.out.println(" >> HT chua co du lieu !");
            return;
        }

        int cnt = 0;
        for (int i = 0; i < index; i++) {
            if (ds[i].id.equals(sid)) {
                System.out.println(ds[i]);
                cnt++;
                break;
            }
        }
        if (cnt == 0) {
            System.out.printf(" >> Khong tim thay san pham co ma so [%s] !\n", sid);
        }
    }

    public void remove(String sid) {
        if (index == 0) {
            System.out.println(" >> HT chua co du lieu !");
            return;
        }
        int cnt = 0;
        for (int i = 0; i < index; i++) {
            if (ds[i].id.equals(sid)) {
                cnt++;
                for (int j = i; j < index - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                index--;
                System.out.println(" >> Da xoa SP thanh cong !");
                break;
            }
        }
        if (cnt == 0) {
            System.out.printf(" >> Khong tim thay san pham co ma so [%s] !\n", sid);
        }
    }

}

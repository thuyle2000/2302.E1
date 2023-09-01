/*
mo ta cau truc cua 1 san pham, bao gom cac :
- thuoc tinh (fields) : id, ten, don gia, VAT
- phuong thuc (methods): nhap_thong_tin_sp 
 */
package entity;

import java.util.Scanner;

public class Product {
    public String id, name;
    public int price;
    public static float VAT = 0.05F;
    public static final String store="CMT8";
    
    //ham dung (constructor)
    public Product() {
        id="P01"; name="product"; price=200; 
    }
    
    protected void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print(" - nhap id: ");
        id = sc.nextLine().trim();
        System.out.print(" - nhap ten SP: ");
        name = sc.nextLine().trim();
        System.out.print(" - nhap don gia: ");
        price = Integer.parseInt(sc.nextLine().trim());
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %dUSD, %.2f(+VAT)", id, name, price, price*(1+VAT));
    }
    
}

/*
 * mo ta cau truc san pham, bao gom:
    - thuoc tinh: ma so, ten, dvtinh, don gia
    - phuong thuc: 
        input() : nhap thong tin sp, 
        toString() : tra ve chuoi mo ta thong tin sp
 */
package demo;

import java.util.Scanner;
public class Product {
    public String id, name, unit;
    public float price;
    
    //ham nhap thong tin sp
    public void input(){
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.print(" - nhap id: ");
            id = sc.nextLine().trim();
            if(id.length()>=2){
                break;
            }
            System.out.println(" >> id ko hop le (phai co it nhat 2 ky tu) !");
        }
        
        while(true){
            System.out.print(" - nhap ten SP: ");
            name = sc.nextLine().trim();
            if(name.length()<2 || name.length()>30){
                System.out.println(" >> Ten SP ko hop le (tu 2 -> 30 ky tu) !");
                continue;
            }
            break;
        }
        
        System.out.print(" - nhap DVT: ");
        unit = sc.nextLine().trim();
        
         while(true){
            System.out.print(" - nhap don gia: ");
            price = sc.nextFloat();
            if(price < 0){
                System.out.println(" >> Don gia ko hop le (phai >= 0) !");
                continue;
            }
            break;
        }       
    }
    
    //override toString()

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %.2f", id, name, unit, price);
    }
    
    public static void main(String[] args) {
        Product p = new Product();
        p.id = "P01"; p.name="coca cola"; p.unit="lon 300ml"; p.price=9.49F;
        System.out.println(p);
        
        
        Product p2 = new Product();
        p2.input();
        System.out.println(p2);
    }
}

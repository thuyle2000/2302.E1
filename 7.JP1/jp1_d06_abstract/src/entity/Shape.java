/*
mo ta cau truc lop truu tuong [Shape]
 */
package entity;
public abstract class Shape {
    //dinh nghia 2 phuong thuc truu tuong: tinh dien tich va chu vi
    public abstract double area();
    public abstract double peripheral();
    
    //dinh nghia them phuong thuc truu tuong input, de nhap tt co ban cua 1 hinh
    public abstract void input();

    @Override
    public String toString() {
        return String.format("DT: %13.2f, CV: %13.2f", area(), peripheral());
    }
    
}

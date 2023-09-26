/*
class generic mo ta cau truc Sinh vien, bao gom cac thuoc tinh:
id, name, gender, mark
 */
package entity;

public class Student<K, E, T> {

    public K id;
    public String name;
    public E gender;
    public T mark;

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", id, name, gender, mark);
    }
}

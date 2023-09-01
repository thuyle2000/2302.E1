/*
interface [ICalculate] liet ke cac phuong thuc tinh toan cua 1 may tinh casio. vi du o day:
    - tinh cong, tru, nhan, chia
    - tinh giai thua
 */
package demo;

public interface ICalculate {

    public double add(double x, double y);

    public double sub(double x, double y);

    public double mul(double x, double y);

    public double div(double x, double y);
    
    public double factorial(int n);

}

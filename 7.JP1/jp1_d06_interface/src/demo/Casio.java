/*
class [Casio] xay dung chuc nang cua 1 tinh don gian, cai dat interface ICalculate
 */
package demo;

public class Casio implements ICalculate{

    @Override
    public double add(double x, double y) {
        return x+y;
    }

    @Override
    public double sub(double x, double y) {
        return x-y;
    }

    @Override
    public double mul(double x, double y) {
        return x*y;
    }

    @Override
    public double div(double x, double y) {
        return x/y;
    }

    @Override
    public double factorial(int n) {
        double r = 1;
        for (int i = 2; i <= n; i++) {
            r *= i;
        }
        return r;
    }
    
}

/* demo user-defined exception */
package demo;

public class MyAppException extends Exception {

    public MyAppException() {
        super("Loi sai !!!");
    }
    public MyAppException(String msg){
        super(msg);
    }
    
}

/*
demo ket noi ung dung java voi CSDL ten [Sem2_demo] cua SQL SERVER 
 */
package myLIB;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyConnection {
    public static Connection getConnect(){
        Connection cn = null;
        String db = "sem2_demo";
        String uid = "sa";
        String pwd = "123";
        String driver =
        "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        
        try {
            //1.load driver
            Class.forName(driver);
//            System.out.println("nap driver thanh cong !");
            
            //2. tao ket noi den CSDL [sem2_demo]
            String url="jdbc:sqlserver://localhost:1433;database=sem2_demo"; 
            cn = DriverManager.getConnection(url, uid, pwd);
//            System.out.println("ket noi thanh cong !");
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return cn;
    }
    
    //test
    public static void main(String[] args) {
        MyConnection.getConnect();
    }
}

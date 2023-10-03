/*
demo ResultsetMetadata
 */
package app;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DemoResultsetMetaData {


    public static void main(String[] args) {
        new DemoResultsetMetaData().test();
    }

    private void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" - nhap ten bang : ");
        String table = sc.nextLine().trim();
        
        //1. tao ket noi den CSDL sem2-demo
        Connection cn = myLIB.MyConnection.getConnect();
        
        try {
            //2. thuc hien lenh SELECT bang dc yeu cau
            Statement st = cn.createStatement();
            
            //3. thuc hien lenh truy van
            ResultSet rs = st.executeQuery("select * from "+ table);
            
            //4. lay cau truc cua bang truy van
            ResultSetMetaData meta = rs.getMetaData();
            
            //5. lay so cot trong tap ket qua
            int n = meta.getColumnCount();
            for (int i = 1; i <= n; i++) {
                System.out.printf("%2d. %-20s %-8s %d\n", i, meta.getColumnName(i), meta.getColumnTypeName(i), meta.getColumnDisplaySize(i));
            }
            
            cn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
}

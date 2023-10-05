/*
demo cach chay store procedure trong JDBC
 */
package app;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DemoStoreProcedure {

    public static void main(String[] args) {
        new DemoStoreProcedure().test();
    }

    private void test() {
        //1. Nhap ma so sv muon tinh diem bq
        Scanner sc = new Scanner(System.in);
        System.out.print(">> nhap ma so SV: ");
        String sv = sc.nextLine().trim();

        //2. tao connection
        Connection cn = myLIB.MyConnection.getConnect();
        
        //3. tao callable statement de thi hanh store
        String sql = "{call usp_avg(?, ?)}";
        try {
            CallableStatement cs = cn.prepareCall(sql);
            cs.setString(1, sv);
            cs.registerOutParameter(2, Types.INTEGER);
            
            //thi hanh store
            cs.executeUpdate();
            
            int dbq = cs.getInt(2);
            System.out.printf(">> Diem BQ cua sinh vien : %d\n", dbq);
            
            cn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DemoStoreProcedure.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

}

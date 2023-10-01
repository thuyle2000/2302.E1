/*  Thuc hien chuc nang CRUD tren bang tbBatch  */
package entity;

import myLIB.*;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class BatchDAO {
    //1. lay du lieu cua bang tbBatch, luu vo ArrayList<Batch>
    public static ArrayList<Batch> get(){
        ArrayList<Batch> ds = new ArrayList<>();
        
        //1. get connection  
        Connection cn = MyConnection.getConnect();
        
        try {
            //2. tao statement chua lenh SELECT sql
            Statement st = cn.createStatement();
            
            //3. thi hanh lenh SQL
            var sql ="select * from tbBatch";
            ResultSet rs = st.executeQuery(sql);
            
            //4. duyet cac dong, cot cua resultset -> arraylist [ds]
            while(rs.next()){
                var batch = rs.getString("batchno");
                var desc = rs.getString("description");
                var fee = rs.getInt(3);
                ds.add(new Batch(batch, desc, fee));
            }
            
            //5. dong resultset, connection
            rs.close();
            cn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ds;
    }
}

/*  Thuc hien chuc nang CRUD tren bang tbBatch  */
package entity;

import myLIB.*;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BatchDAO {

    //1. lay du lieu cua bang tbBatch, luu vo ArrayList<Batch>
    public static ArrayList<Batch> get() {
        ArrayList<Batch> ds = new ArrayList<>();

        //1. get connection  
        Connection cn = MyConnection.getConnect();

        try {
            //2. tao statement chua lenh SELECT sql
            Statement st = cn.createStatement();

            //3. thi hanh lenh SQL
            var sql = "select * from tbBatch";
            ResultSet rs = st.executeQuery(sql);

            //4. duyet cac dong, cot cua resultset -> arraylist [ds]
            while (rs.next()) {
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

    //1b. tim lop co ma so theo yc
    public static Batch get(String id) {
        Batch b = null;
        //1. get connection  
        Connection cn = MyConnection.getConnect();
        //2. Tao doi tuong chua lenh SELECT co tham so
        String sql = "Select * from tbBatch Where Batchno Like ?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, id);

            //3. thi hanh lenh select
            ResultSet rs = ps.executeQuery();

            //4. kiem tra co tim thay du lieu truy van
            if (rs.next()) {
                b = new Batch(rs.getString(1), rs.getString(2), rs.getInt(3));
            }

            //5. dong ket noi
            cn.close();

        } catch (SQLException ex) {
            Logger.getLogger(BatchDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

    //2. them 1 doi tuong lop hoc moi vo bang tbBatch
    public static int create(Batch b) {
        int r = 0;
        //1. get connection  
        Connection cn = MyConnection.getConnect();

        //2. tao doi tuong chua lenh insert
        String sql = "INSERT INTO tbBatch (batchno,description,fee) VALUES(?,?,?)";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            //thay the gia tri cu the cho cac vi tri tham so ?
            ps.setString(1, b.batchno);
            ps.setString(2, b.description);
            ps.setInt(3, b.fee);

            //thuc hien lenh INSERT
            r = ps.executeUpdate();

            cn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return r;
    }

    //3. cap nhat noi dung cau lop hoc trong bang tbBatch
    public static int update(Batch b) {
        int r = 0;
        //1. get connection  
        Connection cn = MyConnection.getConnect();

        //2. tao doi tuong chua lenh update
        String sql = "UPDATE tbBatch SET description = ?,fee = ? WHERE batchno LIKE ?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            //thay the gia tri cu the cho cac vi tri tham so ?
            ps.setString(1, b.description);
            ps.setInt(2, b.fee);
            ps.setString(3, b.batchno);

            //thuc hien lenh UPDATE
            r = ps.executeUpdate();

            cn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return r;
    }
    
    //4. xoa lop hoc trong bang tbBatch theo ma so
    public static int remove(String id) {
        int r = 0;
        //1. get connection  
        Connection cn = MyConnection.getConnect();

        //2. tao doi tuong chua lenh delete
        String sql = "DELETE FROM tbBatch WHERE batchno Like ?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            //thay the gia tri cu the cho cac vi tri tham so ?
            ps.setString(1, id);

            //thuc hien lenh DELETE
            r = ps.executeUpdate();

            cn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return r;
    }
}


package crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CRUD {
    static DbUtil du= new DbUtil();
    static PreparedStatement ps;
    static String sql= "";

    public static void main(String[] args) {
        
//        saveStu("Naruto Uzumaki", "naruto@gmail.com", 5000);
//        saveStu("Itachi", "itachi@gmail.com", 6000);
//        saveStu("Madara", "madara@gmail.com", 7000);
//        findStu();


//        deleteStu(3);
//        findStu();


        updateStu(2, "Sasuke Uthciha", "sasuke@gmail.com", 4500);
        findStu();
        
        
        
        
        
    }
    public static  void saveStu(String name, String email, float fee){
    sql= "insert into student(name, email, fee) values(?,?,?)";
        try {
            ps = du.getCon().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setFloat(3, fee);
            
            System.out.println("Save Successfully.");
            System.out.println("---------------------");
            ps.executeUpdate();
            ps.close();
            du.getCon().close();
        } catch (SQLException ex) {
            System.err.println("Save error");
            
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static void findStu(){
    sql= "select * from student";
    
        try {
            ps = du.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                float fee = rs.getFloat("fee");

                System.out.println("Id : " + id + " Name : " + name + " E-mail : " + email + " Fee : " + fee);

            
            }
            ps.executeQuery();
            ps.close();
            rs.close();
            du.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void deleteStu(int id){
    sql= "delete from student where id= ?";
        try {
            ps= du.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            du.getCon().close();
            System.out.println("Data Deleted");
        } catch (SQLException ex) {
            
            System.out.println("Data Not Delete");
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updateStu(int id, String name, String email, float fee){
    sql= "update student set name=?, email=?,fee=? where id = ?";
        try {
            ps= du.getCon().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setFloat(3, fee);
            ps.setInt(4, id);
            
            ps.executeUpdate();
            ps.close();
            du.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

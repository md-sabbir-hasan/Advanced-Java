
package classprac;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassPrac {
   static DbUtil db= new DbUtil();
   static PreparedStatement ps;
   static String sql= "";

    public static void main(String[] args) {
//        saveEmp("Sabbir", 10000, "p");
deleteemp(2);
       findEmp();
//updateEmp(2, "sab", 500, "l=H");
       
    }
    
    public static void saveEmp(String name, double salary, String designation){
        
        sql= "insert into emp(name, salary, designation) values(?,?,?)";
        
       try {
           ps= db.getCon().prepareStatement(sql);
           ps.setString(1, name);
            ps.setDouble(2, salary);
            ps.setString(3, designation);
            
            System.out.println("Save Successfully");
            System.out.println("_______________");
            ps.executeUpdate();
            ps.close();
            db.getCon().close();
       } catch (SQLException ex) {
           Logger.getLogger(ClassPrac.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    
    }
    
     public static void findEmp(){
        
        sql= "select * from emp";
       try {
           ps= db.getCon().prepareStatement(sql);
           ResultSet rs= ps.executeQuery();
            while(rs.next()){
                 int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                String designation = rs.getString("designation");

                System.out.println("id= " + id + " Name= "+ name + " Salary = " + salary + " Desig = "+ designation);

            
            }
            ps.executeQuery();
            ps.close();
            rs.close();
            db.getCon().close();
       } catch (SQLException ex) {
           Logger.getLogger(ClassPrac.class.getName()).log(Level.SEVERE, null, ex);
       }
     
    }
     
     public static void updateEmp(int id, String name, double salary, String designation){
         sql= "update emp set name= ?, salary= ?, designation= ? where id= ?";
         
       try {
           ps= db.getCon().prepareStatement(sql);
           ps.setString(1, name);
            ps.setDouble(2, salary);
            ps.setString(3, designation);
            ps.setInt(4, id);
            ps.executeUpdate();
             ps.close();
         
            db.getCon().close();
       } catch (SQLException ex) {
           Logger.getLogger(ClassPrac.class.getName()).log(Level.SEVERE, null, ex);
       }
     
     }
     public static void deleteemp(int id){
     sql= "delete from emp where id= ?";
       try {
           ps= db.getCon().prepareStatement(sql);
           ps.setInt(1, id);
           ps.executeUpdate();
           ps.close();
           db.getCon().close();
       } catch (SQLException ex) {
           Logger.getLogger(ClassPrac.class.getName()).log(Level.SEVERE, null, ex);
       }
     }
    
}

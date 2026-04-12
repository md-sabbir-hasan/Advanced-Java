
package evdcrud;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EvdCRUD {
   static DbUtil du= new DbUtil();
   static PreparedStatement ps;
   static String sql= "";

    public static void main(String[] args) {
       saveEmp("sabbir", "10-01-2025", "IT", 5000);
       saveEmp("Maruf", "10-01-2020", "Sell", 5000);
       findEmp();
       
      updateEmp("mahabub", "01-02-2025", "sell", 1000, 2);
      findEmp();
        
      deleteEmp(2);
        findEmp();
        
    }
    
    public static void saveEmp(String name, String joinDate, String designation, double salary){
     sql= "insert into emdata(name, joinDate, designation, salary) values(?,?,?,?)";
       try {
           ps= du.getCon().prepareStatement(sql);
           ps.setString(1, name);
            ps.setString(2, joinDate);
           ps.setString(3, designation);
           ps.setDouble(4, salary);
           
           System.out.println("Save Successfully");
            System.out.println("________________");
           ps.executeUpdate();
            ps.close();
           du.getCon().close();
           
       } catch (SQLException ex) {
           Logger.getLogger(EvdCRUD.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public static void findEmp(){
    sql= "select* from emdata";
       try {
           ps= du.getCon().prepareStatement(sql);
           ResultSet rs= ps.executeQuery();
           while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String joinDate = rs.getString("joinDate");
                String designation = rs.getString("designation");
                double salary = rs.getDouble("salary");

               System.out.println("id= " + id + " Name= "+ name + " joinDate "+ joinDate + " designation "+ designation  +" Salary = " + salary );
           
           }
          ps.executeQuery();          
          ps.close();
           rs.close();
            du.getCon().close();
       } catch (SQLException ex) {
           Logger.getLogger(EvdCRUD.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public static void updateEmp(String name, String joinDate, String designation, double  salary, int id){
        
        sql= "update emdata set name= ?, joinDate= ?, designation= ?, salary= ? where id= ?";
        
       try {
           ps= du.getCon().prepareStatement(sql);
           ps.setString(1, name);
           ps.setString(2, joinDate);
           ps.setString(3, designation);
            ps.setDouble(4, salary);
            ps.setInt(5, id);
             ps.executeUpdate();
            ps.close();
            du.getCon().close();
            System.out.println("Data Updated");
           
       } catch (SQLException ex) {
           Logger.getLogger(EvdCRUD.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    
    }
    
    public static void deleteEmp(int id){
    sql= "delete from emdata where id= ?";
       try {
           ps= du.getCon().prepareStatement(sql);
            ps.setInt(1, id);
           ps.executeUpdate();
            ps.close();
           du.getCon().close();
           System.out.println("Data Deleted");
       } catch (SQLException ex) {
           Logger.getLogger(EvdCRUD.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
   
    
}

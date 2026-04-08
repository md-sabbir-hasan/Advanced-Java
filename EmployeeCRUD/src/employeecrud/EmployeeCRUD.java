
package employeecrud;

import employeecrud.util.DbUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeCRUD {
    static DbUtil du = new DbUtil();
    static  PreparedStatement ps;
    static String sql= "";
    
    public static void main(String[] args) {
        
//        saveStu("Thor", 50000, 1);
//        saveStu("Hulk", 60000, 2);

findEmp();
                
    }
    public static  void saveStu(String name, double salary, int department){
        sql= "insert into employee(name, salary, department) values(?,?,?)";
        try {
            ps= du.getCon().prepareStatement(sql);
            ps.setString(1, name);
            ps.setDouble(2, salary);
            ps.setInt(3, department);
            
            System.out.println("Save Successfully");
            System.out.println("_______________");
            ps.executeUpdate();
            ps.close();
            du.getCon().close();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static void findEmp(){
    sql= "select * from employee";
    
        try {
            ps = du.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                int department = rs.getInt("department");

                System.out.println("id= " + id + "Name= "+ name + "Salary = " + salary + "Department = "+ department);

            
            }
            ps.executeQuery();
            ps.close();
            rs.close();
            du.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void deleteEmp(int id){
        sql = "delete from employee where id = ? ";
        try {
            ps = du.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            du.getCon().close();
            System.out.println("Data Deleted");
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    public static void updateEmp(int id, String name, double salary, int department){
        sql= "update employee set name= ?, salary= ?, department= ? where id= ?";
        try {
            ps= du.getCon().prepareStatement(sql);
            ps.setString(1, name);
            ps.setDouble(2, salary);
            ps.setInt(3, department);
            ps.setInt(4, id);
             ps.executeUpdate();
            ps.close();
            du.getCon().close();
            System.out.println("Data Updated");
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}

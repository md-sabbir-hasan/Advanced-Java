
package teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Teacher {
    static Util du= new Util();
    static PreparedStatement ps;
    static String sql= "";
            

    public static void main(String[] args) {
        
    }
    
    public static void saveTeacher(String name, String designation, double salary){
    sql= "insert into teacher(name, qualification, salary) values(?,?,?)";
    
        try {
            ps= du.getCon().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, designation);
            ps.setDouble(3, salary);
            
            System.out.println("Save Successfully");
            System.out.println("________________");
            ps.executeUpdate();
            ps.close();
            du.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void findTeach(){
    sql= "select* from teacher";
        try {
            ps = du.getCon().prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                 int id = rs.getInt("id");
                String name = rs.getString("name");
                String deignation = rs.getString("designation");
                double salary = rs.getDouble("salary");

                System.out.println("id= " + id + " Name= "+ name + "Designation "+deignation+ " Salary = " + salary);

            
            }
            ps.executeQuery();
            ps.close();
            rs.close();
            du.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updateTeach(String name, String designation, double salary, int id){
     sql= "update teacher set name= ?, designation= ?, salary= ? where id= ?";
        try {
            ps= du.getCon().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, designation );
            ps.setDouble(3, salary);
            ps.setInt(4, id);
             ps.executeUpdate();
            ps.close();
            du.getCon().close();
            System.out.println("Data Updated");
            
        } catch (SQLException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public static void deleteTeach(int id){
    
    }
    
}

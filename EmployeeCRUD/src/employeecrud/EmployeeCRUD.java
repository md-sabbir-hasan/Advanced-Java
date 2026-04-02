
package employeecrud;

import employeecrud.util.DbUtil;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeCRUD {
    static DbUtil du = new DbUtil();
    static  PreparedStatement ps;
    static String sql= "";
    
    public static void main(String[] args) {
                
    }
    public static  void saveStu(String name, String email, String phone, double salary){
        sql= "insert into empdata(name, email, phone, salary) values(?,?,?,?)";
        try {
            ps= du.getCon().prepareStatement(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}

package src.com.studentmanagementsystem.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import src.com.studentmanagementsystem.model.Student;
import src.com.studentmanagementsystem.utility.DBConnection;



public class StudentDAO {
    
    public Student validateLogin(String username, String password, String role){
        String query = "SELECT * FROM ? WHERE email = ? AND password = ?";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
        ) {
            ps.setString(1, role.toLowerCase());
            ps.setString(2, username.toLowerCase());
            ps.setString(3, password);

            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setRollNo(rs.getInt("roll_no"));
                student.setDob(rs.getString("dob"));
                student.setAttendance(rs.getInt("attendance"));
                student.setFeesPaid(rs.getInt("fees") == 1 ? true : false);
                
                return student;
            }else{
                throw new Exception("Invalid Credintials!"); 
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }
}

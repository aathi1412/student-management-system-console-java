package src.com.studentmanagementsystem.utility;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
    
    private static String url = "";
    private static String username = "";
    private static String password = "";

    static{
        try {
            FileInputStream fis = new FileInputStream("./db.properties");

            Properties prop = new Properties();
            prop.load(fis);

            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException("Database connection failed");
        }
    }
}

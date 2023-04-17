/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final String url = "jdbc:mysql://localhost:3306/film_tickets_booking";
    private static final String username = "root";
    private static final String password = "khoa";
    Connection connection = null;
    
    public MySQLConnection(){
    }
    
    public Connection Connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection connection;
            connection = DriverManager.getConnection(this.url, this.username, this.password);
            return connection;
//            System.out.print("Noi ket thanh cong");
        }
        catch(Exception ex){
            System.out.print("Noi ket khong thanh cong");
            ex.printStackTrace();
        }
        return null;
    }
}

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
    public Connection connection;
    public String url;
    public String username;
    public String password;
    
    public MySQLConnection(){
        url = "jdbc:mysql://localhost:3306/film_tickets_booking";
        username = "root";
        password = "";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection connection;
            connection = DriverManager.getConnection(this.url, this.username, this.password);
//            return connection;
//            System.out.print("Noi ket thanh cong");
        }
        catch(Exception ex){
//            System.out.print("Noi ket khong thanh cong");
//            ex.printStackTrace();
        }
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
        return connection;
    }
    
    public void main(String args[]){
//        String url = "jdbc:mysql://localhost:3306/film_tickets_booking";
//        String username = "root";
//        String password = "";
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//            Connection connection;
//            connection = DriverManager.getConnection(url, username, password);
//            System.out.print("Noi ket thanh cong");
//        }
//        catch(Exception ex){
//            System.out.print("Noi ket khong thanh cong");
//            ex.printStackTrace();
//        }

//          Connect();
    }
}

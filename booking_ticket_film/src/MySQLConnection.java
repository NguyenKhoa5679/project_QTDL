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
    public static void main(String args[]){
        String url = "jdbc:mysql://localhost:3306/film_tickets_booking";
        String username = "root";
        String password = "";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection connection;
            connection = DriverManager.getConnection(url, username, password);
            System.out.print("Noi ket thanh cong");
        }
        catch(Exception ex){
            System.out.print("Noi ket khong thanh cong");
            ex.printStackTrace();
        }
    }
}

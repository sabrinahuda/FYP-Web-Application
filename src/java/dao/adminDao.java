/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import bean.Admin;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ADMIN
 */
public class adminDao {
    
    public int registerAdmin(Admin admin) throws ClassNotFoundException, SQLException {
    String INSERT_ADMIN_SQL = "INSERT INTO ADMIN" +
                "(admin_id,admin_name,admin_pass,admin_phone) VALUES" + 
                "(?,?,?,?)";
        int result= 0;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        try(Connection connection = DriverManager
                .getConnection("jdbc:derby://localhost:1527/FYP System", "fyp", "fyp") ;
                //create statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADMIN_SQL)) {
                  preparedStatement.setString(1, admin.getAdmin_id());
                  preparedStatement.setString(2, admin.getAdmin_name());
                  preparedStatement.setString(3, admin.getAdmin_pass());
                  preparedStatement.setString(4, admin.getAdmin_phone());
                  preparedStatement.executeUpdate();
                  System.out.print(preparedStatement);
                  //update query
                  result = preparedStatement.executeUpdate();
                  preparedStatement.close();
                  connection.close();
        }
        
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
 }
    
    


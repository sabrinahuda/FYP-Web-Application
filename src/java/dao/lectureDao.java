/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Lecture;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class lectureDao {
    public int registerLecture(Lecture lect) throws ClassNotFoundException, SQLException {
    String INSERT_LECT_SQL = "INSERT INTO LECTURE" +
                "(lect_id,lect_name,lect_email,lect_room,lect_status) VALUES" + 
                "(?,?,?,?,?)";
        int result= 0;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        try(Connection connection = DriverManager
                .getConnection("jdbc:derby://localhost:1527/FYP System", "fyp", "fyp") ;
                //create statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LECT_SQL)) {
                  preparedStatement.setString(1, lect.getLect_id());
                  preparedStatement.setString(2, lect.getLect_name());
                  preparedStatement.setString(3, lect.getLect_email());
                  preparedStatement.setString(4, lect.getRoom_no());
                  preparedStatement.setString(5, lect.getStatus());
                  
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
      public int updateLecture(Lecture lect) throws ClassNotFoundException, SQLException {
    String UPDATE_LECT_SQL = "UPDATE LECTURE SET LECT_NAME= ?, LECT_EMAIL=?,LECT_ROOM=?, LECT_STATUS=? WHERE LECT_ID =?";
        int result= 0;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        try(Connection connection = DriverManager
                .getConnection("jdbc:derby://localhost:1527/FYP System", "fyp", "fyp") ;
                //create statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LECT_SQL);) {
                  
                  
                  preparedStatement.setString(1, lect.getLect_name());
                  preparedStatement.setString(2, lect.getLect_email());
                  preparedStatement.setString(3, lect.getRoom_no());
                  preparedStatement.setString(4, lect.getStatus());
                  preparedStatement.setString(5, lect.getLect_id());
                  
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
      
 public int deleteLecture(Lecture lect) throws ClassNotFoundException, SQLException {
   
    String DELETE_LECT_SQL = "DELETE FROM LECTURE WHERE LECT_ID =?";
        int result= 0;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        try(Connection connection = DriverManager
                .getConnection("jdbc:derby://localhost:1527/FYP System", "fyp", "fyp") ;
                //create statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_LECT_SQL)) {
                  preparedStatement.setString(1, lect.getLect_id());
                 
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import bean.Project;

/**
 *
 * @author ADMIN
 */
public class projectDao {
     public int registerProject(Project proj) throws ClassNotFoundException, SQLException {
    String INSERT_PROJ_SQL = "INSERT INTO PROJECT" +
                "(proj_id,proj_title,objective) VALUES" + 
                "(?,?,?)";
        int result= 0;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        try(Connection connection = DriverManager
                .getConnection("jdbc:derby://localhost:1527/FYP System", "fyp", "fyp") ;
                //create statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROJ_SQL)) {
                  preparedStatement.setString(1, proj.getProj_id());
                  preparedStatement.setString(2, proj.getProj_title());
                  preparedStatement.setString(3, proj.getObjective());
                  
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
      public int updateProject(Project proj) throws ClassNotFoundException, SQLException {
    String UPDATE_PROJ_SQL = "UPDATE PROJECT SET PROJ_TITLE= ?, OBJECTIVE=? WHERE PROJ_ID =?";
        int result= 0;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        try(Connection connection = DriverManager
                .getConnection("jdbc:derby://localhost:1527/FYP System", "fyp", "fyp") ;
                //create statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PROJ_SQL);) {
                  
                  preparedStatement.setString(1, proj.getProj_title());
                  preparedStatement.setString(2, proj.getObjective());
                  preparedStatement.setString(3, proj.getProj_id());
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
      
 public int deleteProject(Project proj) throws ClassNotFoundException, SQLException {
   
    String DELETE_PROJ_SQL = "DELETE FROM PROJECT WHERE PROJ_ID =?";
        int result= 0;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        try(Connection connection = DriverManager
                .getConnection("jdbc:derby://localhost:1527/FYP System", "fyp", "fyp") ;
                //create statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PROJ_SQL)) {
                  preparedStatement.setString(1, proj.getProj_id());
                 
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

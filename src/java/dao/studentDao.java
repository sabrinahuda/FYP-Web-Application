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
import bean.Student;
import bean.Project;
import bean.Lecture;

/**
 *
 * @author ADMIN
 */
public class studentDao {
    public int registerStudent(Student student,Project proj,Lecture lect) throws ClassNotFoundException, SQLException {
    String INSERT_STUD_SQL = "INSERT INTO STUDENT (STUD_ID,STUD_NAME,STUD_EMAIL,STUD_PHONE,PROJ_ID,LECT_ID) VALUES (?,?,?,?,?,?)";
        int result= 0;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        try(Connection connection = DriverManager
                .getConnection("jdbc:derby://localhost:1527/FYP System", "fyp", "fyp") ;
                //create statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUD_SQL)) {
                  preparedStatement.setString(1, student.getStud_id());
                  preparedStatement.setString(2, student.getStud_Name());
                  preparedStatement.setString(3, student.getStud_Email());
                  preparedStatement.setString(4, student.getStud_phone());
                  preparedStatement.setString(5, proj.getProj_id());
                  preparedStatement.setString(6, lect.getLect_id());
                  
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
     
     
public int updateStudent(Student student,Project proj,Lecture lect) throws ClassNotFoundException, SQLException {
   
    String UPDATE_STUD_SQL = "UPDATE STUDENT SET STUD_NAME =?, STUD_EMAIL =?, STUD_PHONE =?, PROJ_ID =?,LECT_ID=? WHERE STUD_ID =? ";
     int resultUpdate = 0;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection connection = DriverManager
                .getConnection("jdbc:derby://localhost:1527/FYP System", "fyp", "fyp") ;
        try(
                //create statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUD_SQL)) {
                 
                  preparedStatement.setString(1, student.getStud_Name());
                  preparedStatement.setString(2, student.getStud_Email());
                  preparedStatement.setString(3, student.getStud_phone());
                  preparedStatement.setString(4, proj.getProj_id());
                  preparedStatement.setString(5,lect.getLect_id());
                  preparedStatement.setString(6, student.getStud_id());
                  preparedStatement.executeUpdate();
                  System.out.print(preparedStatement);
                  //update query
                  resultUpdate = preparedStatement.executeUpdate();
                  preparedStatement.close();
                  connection.close();    
        }
        
        catch (SQLException e){
           e.printStackTrace();
        }
        return  resultUpdate;
    }
   
public int deleteStudent(Student student,Project proj,Lecture lect) throws ClassNotFoundException, SQLException {
   
    String DELETE_STUD_SQL = "DELETE FROM STUDENT WHERE STUD_ID =?";
        int result= 0;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        try(Connection connection = DriverManager
                .getConnection("jdbc:derby://localhost:1527/FYP System", "fyp", "fyp") ;
                //create statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUD_SQL)) {
                  preparedStatement.setString(1, student.getStud_id());
                 
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

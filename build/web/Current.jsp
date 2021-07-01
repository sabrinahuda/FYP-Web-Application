<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : empform
    Created on : Jun 19, 2020, 11:14:32 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<sql:setDataSource var="myDatasource" driver="org.apache.derby.jdbc.ClientDriver" 
                   url="jdbc:derby://localhost:1527/FYP System" 
                   user="fyp"
                   password="fyp"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "java.sql.*" %>
<% Class.forName("org.apache.derby.jdbc.ClientDriver"); %>
<html>
    <head>
        <title>Current List</title>
         <link href="mystyle.css" rel="stylesheet" type="text/css">
         <link href="current.css" rel="stylesheet" type="text/css">
         <link href="update.css" rel="stylesheet" type="text/css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <header>
                <div id ="logo">
                    <img src="C:\Users\ADMIN\Documents\NetBeansProjects\FYP Web Application\uitm logo.png">
                </div>
            
            <ul id="right-nav">
                <li><a class="selected" href=" ">Services</a></li>
                <li><a class="selected" href=" ">Contact</a></li>
                <li><a class="selected" href=" ">About</a></li>
                <li><a class="selected" href="Homepage.jsp">Home</a></li>
            </ul>
            
        </header>
        
        <h1>List</h1>
    
             

    
  <sql:query var="result" dataSource="${myDatasource}">
        SELECT * FROM STUDENT,PROJECT
        WHERE STUDENT.PROJ_ID= PROJECT.PROJ_ID
        
    </sql:query>
                    
   <table id="myTable" style="left">
  <tr class="header">
     <th style="width:10%;">Student ID</th>
    <th style="width:10%;">Name</th>
     <th style="width:20%;">Email</th>
      <th style="width:10%;">Phone No</th>
       
       
         <th style="width:20%;">Project title</th>
         <th style="width:30%;">Description</th>
         <th style="width:20%;">Edit</th>
       
     
  </tr>
  
    <!-- column data -->
  
   
 <c:forEach var="row" items="${result.rowsByIndex}">
    <tr>
        
              <c:forEach var="column" items="${row}">
                <c:if test="${column != row[5] && column !=row[4] }">
                <td> <c:out value="${column}"/> </td>
                </c:if>
                 </c:forEach>
              
      <td>
       <form action="Update.jsp" method="POST">
       <input type="hidden" name="stud_id" value="${row[0]}" />
       <input type="hidden" name="proj_id" value="${row[6]}" />
       <input type="hidden" name="lect_id" value="${row[5]}" />
       <input type="submit" value="Edit" />
       </form>
        <form action="Remove.jsp" method="POST">
       <input type="hidden" name="proj_id" value="${row[6]}" />
       <input type="hidden" name="stud_id" value="${row[0]}" />
       <input type="hidden" name="lect_id" value="${row[5]}" />
       <input type="submit" value="Delete" />
       </form>
       </td>
           
     </tr> 
    </c:forEach>
     
       
   </table>
            
      
    </body>
</html>

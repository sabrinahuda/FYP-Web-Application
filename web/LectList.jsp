<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : LectList
    Created on : Jul 9, 2020, 2:15:57 AM
    Author     : ADMIN
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<sql:setDataSource var="myDatasource" driver="org.apache.derby.jdbc.ClientDriver" 
                   url="jdbc:derby://localhost:1527/FYP System" 
                   user="fyp"
                   password="fyp"/>

<!DOCTYPE html>
<html>
    <head>
         <link href="mystyle.css" rel="stylesheet" type="text/css">
         <link href="current.css" rel="stylesheet" type="text/css">
         
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
   
<sql:query var="result" dataSource="${myDatasource}">
    SELECT * FROM LECTURE
</sql:query>
    
<table border="1">
    <!-- column headers -->
    <tr>
        <c:forEach var="columnName" items="${result.columnNames}">
            <th><c:out value="${columnName}"/></th>
            </c:forEach>
    </tr>
    
    <!-- column data -->
    <c:forEach var="row" items="${result.rowsByIndex}">
        <tr>
            <c:forEach var="column" items="${row}">
                <td><c:out value="${column}"/></td>
            </c:forEach>
            <td>
       <form action="LectUpdate.jsp" method="POST">
       <input type="hidden" name="lect_id" value="${row[0]}" />
       <input type="submit" value="Edit" />
       </form>
        <td>
       <form action="LectDelete.jsp" method="POST">
       <input type="hidden" name="lect_id" value="${row[0]}" />
       <input type="submit" value="Delete" />
       </form>
        
       </td>
    </c:forEach>
</table>
    </body>
</html>

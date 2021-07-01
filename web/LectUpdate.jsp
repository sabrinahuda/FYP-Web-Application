<%-- 
    Document   : LectUpdate
    Created on : Jul 9, 2020, 3:12:29 AM
    Author     : ADMIN
--%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<sql:setDataSource var="myDatasource" driver="org.apache.derby.jdbc.ClientDriver" 
                   url="jdbc:derby://localhost:1527/FYP System" 
                   user="fyp"
                   password="fyp"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link href="register.css" rel="stylesheet" type="text/css">
        <link href="mystyle.css" rel="stylesheet" type="text/css">
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
        <jsp:useBean id="lect" scope="page" class="bean.Lecture" />
    <jsp:setProperty name="lect" property="*" />
     <c:set var="lect_id" value="${lect.lect_id}"/>
     
     <sql:query var="result" dataSource="${myDatasource}">
            SELECT * FROM LECTURE WHERE LECT_ID = ?
        <sql:param value="${lect_id}"/>
        </sql:query>
        <c:forEach var="table" items="${result.rows}">
            <c:set var="lect_name_query" value="${table.lect_name}" />
            <c:set var="lect_email_query" value="${table.lect_email}" />
            <c:set var="room_no_query" value="${table.lect_room}" />
              <c:set var="lect_status_query" value="${table.lect_status}" />
          
        </c:forEach>
            
   <div class="container">
  <form action="LectureUpdate" method="POST">
     <div class="row">
    <div class="col-25">
      <label>Lecture name</label>
    </div>
    <div class="col-75">
      <input type="text" name="lect_name" value="${lect_name_query}" >
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label>Lecture email</label>
    </div>
    <div class="col-75">
      <input type="text" name="lect_email" value="${lect_email_query}" >
    </div>
  </div>
    <div class="row">
    <div class="col-25">
      <label>Lecture room</label>
    </div>
    <div class="col-75">
      <input type="text" name="room_no" value="${room_no_query}" >
    </div>
  </div>  
      <div class="row">
    <div class="col-25">
      <label for="lname">Lecture's Status</label>
    </div>
    <div class="col-75">
      <input type="text" name="lect_status" value="${lect_status_query}" >
    </div>
  </div>
      
    <input type="text" name="lect_id" value="${lect_id}" />
    
        <div class="row">
    <input type="submit" value="Submit">
    
  </div>
  </form>
</div>
    </body>
</html>

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

<html>
    <head>
        <title>Delete Students</title>
         <link href="mystyle.css" rel="stylesheet" type="text/css">
         <link href="register.css" rel="stylesheet" type="text/css">
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
        <h1>Remove Students Details</h1>
          
    <jsp:useBean id="stud" scope="page" class="bean.Student" />
    <jsp:setProperty name="stud" property="*" />
     <c:set var="stud_id" value="${stud.stud_id}"/>
     
        <sql:query var="result" dataSource="${myDatasource}">
            SELECT * FROM STUDENT WHERE STUD_ID = ?
        <sql:param value="${stud_id}"/>
        </sql:query>
            
       
     
     
        <c:forEach var="table" items="${result.rows}">
            <c:set var="stud_Name_query" value="${table.stud_Name}" />
            <c:set var="stud_Email_query" value="${table.stud_Email}" />
            <c:set var="stud_phone_query" value="${table.stud_phone}" />
        </c:forEach>
     
     <jsp:useBean id="proj" scope="page" class="bean.Project" />
    <jsp:setProperty name="proj" property="*" />
     <c:set var="proj_id" value="${proj.proj_id}"/>
     
     <sql:query var="r" dataSource="${myDatasource}">
            SELECT * FROM PROJECT WHERE PROJ_ID = ?
        <sql:param value="${proj_id}"/>
        </sql:query>
        <c:forEach var="t" items="${r.rows}">
            <c:set var="proj_title_query" value="${t.proj_title}" />
            <c:set var="objective_query" value="${t.objective}" />
        </c:forEach>
            
     <jsp:useBean id="lect" scope="page" class="bean.Lecture" />
    <jsp:setProperty name="lect" property="*" />
     <c:set var="lect_id" value="${lect.lect_id}"/>
            
     <sql:query var="r" dataSource="${myDatasource}">
            SELECT * FROM LECTURE WHERE LECT_ID = ?
        <sql:param value="${lect_id}"/>
        </sql:query>
                      
  <div class="container">
  <form action="DeleteServlet" method="POST">

  <div class="row">
    <div class="col-25">
      <label>Name</label>
    </div>
    <div class="col-75">
      <input type="text" name="stud_Name" value="${stud_Name_query}" >
    </div>
  </div>
    <div class="row">
    <div class="col-25">
      <label>Student's Email</label>
    </div>
    <div class="col-75">
      <input type="text" name="stud_Email" value="${stud_Email_query}">
    </div>
  </div>  
      <div class="row">
    <div class="col-25">
      <label for="lname">Student's Phone</label>
    </div>
    <div class="col-75">
      <input type="text"  name="stud_phone" value="${stud_phone_query}">
    </div>
  </div>
    
     
    <div class="row">
    <div class="col-25">
      <label for="lname">Project Title</label>
    </div>
    <div class="col-75">
      <input type="text"  name="proj_title" value="${proj_title_query}">
    </div>
  </div>
    
     <div class="row">
    <div class="col-25">
      <label for="lname">Objective</label>
    </div>
    <div class="col-75">
      <input type="text"  name="objective" value="${objective_query}">
    </div>
  </div>
    
    
    
    <input type="hidden" name="stud_id" value="${stud_id}" />
    <input type="hidden" name="proj_id" value="${proj_id}" />
    <input type="hidden" name="lect_id" value="${lect_id}" />
   
  <div class="row">
    <input type="submit" value="Delete">
    
  </div>
  </form>
</div>
  
    </body>
</html>

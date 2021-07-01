<%-- 
    Document   : AdRegisSuccess
    Created on : Jul 2, 2020, 12:30:19 AM
    Author     : ADMIN
--%>

<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<sql:setDataSource var="myDatasource" driver="org.apache.derby.jdbc.ClientDriver" 
                   url="jdbc:derby://localhost:1527/FYP System" 
                   user="fyp"
                   password="fyp"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var= "scopeRequest" scope = "request" />
<%@page import="bean.Admin"%>
<!DOCTYPE html>
<html>
    <head>
         <link href="mystyle.css" rel="stylesheet" type="text/css">
       <link href="current.css" rel="stylesheet" type="text/css">
       <link href="register.css" rel="stylesheet" type="text/css">
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
        
    <jsp:useBean id="admin" scope="page" class="bean.Admin" />
    <jsp:setProperty name="admin" property="*" />
    
     <c:set var="admin_id" value="${admin.admin_id}" />
    <c:set var="admin_name" value="${admin.admin_name}" />
    <c:set var="admin_pass" value="${admin.admin_pass}" />
    <c:set var="admin_phone" value="${admin.admin_phone}" />   
    
     <c:if test="${(admin_id!=null)  && (admin_name != null) && (admin_pass != null) && (admin_phone != null) }" var="result">
         <sql:update var="result" dataSource="${myDatasource}">
            INSERT INTO ADMIN (admin_id,admin_name,admin_pass,admin_phone)
            VALUES (?,?,?,?)
            <sql:param value="${admin_id}"/>
            <sql:param value="${admin_name}"/>
            <sql:param value="${admin_pass}"/>
            <sql:param value="${admin_phone}"/>
        </sql:update>
         </c:if>
       
  <div class="container">
  <form action="Homepage.jsp" method="POST">

  <div class="row">
    <div class="col-25">
      <label>Id</label>
    </div>
    <div class="col-75">
        <br> <c:out value="${admin.admin_id}" /><br/>
    </div>
  </div>
    <div class="row">
    <div class="col-25">
      <label>Name</label>
    </div>
    <div class="col-75">
      <br><c:out  value="${admin.admin_name}"/><br/>
    </div>
  </div>  
      <div class="row">
    <div class="col-25">
      <label for="lname">Password</label>
    </div>
    <div class="col-75">
        <br> <c:out  value="${admin.admin_pass}"/><br/>
    </div>
  </div>
     <div class="row">
    <div class="col-25">
      <label for="lname">Number Phone</label>
    </div>
    <div class="col-75">
        <br> <c:out  value="${admin.admin_phone}"/><br/>
    </div>
  </div>
    
  <div class="row">
      <input type="submit" value="Homepage">
  </div>
  </form>
</div>
    
    </body>
</html>

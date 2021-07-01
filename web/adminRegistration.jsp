<%-- 
    Document   : adminRegistration
    Created on : Jul 2, 2020, 12:15:10 AM
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
         <link href="register.css" rel="stylesheet" type="text/css">
        <link href="mystyle.css" rel="stylesheet" type="text/css">
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
                <li><a class="selected" href="login.html">Login</a></li>
            </ul>
            
        </header>
        
        
<div class="container">
  <form action="AdminServlet" method="POST">
  <div class="row">
    <div class="col-25">
      <label>Admin ID</label>
    </div>
    <div class="col-75">
      <input type="text"  name="admin_id" value=" " placeholder="id..">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label>Admin Name</label>
    </div>
    <div class="col-75">
      <input type="text" name="admin_name" value=" " placeholder="name..">
    </div>
  </div>
    <div class="row">
    <div class="col-25">
      <label>Password</label>
    </div>
    <div class="col-75">
      <input type="text" name="admin_pass" value=" " placeholder="email..">
    </div>
  </div>  
      <div class="row">
    <div class="col-25">
      <label for="lname">Number Phone</label>
    </div>
    <div class="col-75">
      <input type="text"  name="admin_phone" value=" " placeholder="phone number..">
    </div>
      </div>
 
  <div class="row">
   
    <input type="submit" value="Submit">
  </div>
  </form>
</div>
    </body>
</html>

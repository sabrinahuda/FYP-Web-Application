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
        
        <title> Register FYP </title>
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
    

<h2>Register Form</h2>
  
<div class="container">
  <form action="AddStudent" method="POST">
  <div class="row">
    <div class="col-25">
      <label>Student ID</label>
    </div>
    <div class="col-75">
      <input type="text"  name="stud_id" value=" " placeholder="id..">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label>Name</label>
    </div>
    <div class="col-75">
      <input type="text" name="stud_Name" value=" " placeholder="name..">
    </div>
  </div>
    <div class="row">
    <div class="col-25">
      <label>Student's Email</label>
    </div>
    <div class="col-75">
      <input type="text" name="stud_Email" value=" " placeholder="email..">
    </div>
  </div>  
      <div class="row">
    <div class="col-25">
      <label for="lname">Student's Phone</label>
    </div>
    <div class="col-75">
      <input type="text"  name="stud_phone" value=" " placeholder="phone number..">
    </div>
  </div>
      


      <div class="row">
    <div class="col-25">
      <label>Project ID</label>
    </div>
    <div class="col-75">
      <input type="text"  name="proj_id" value=" " placeholder="id..">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label>Project Title</label>
    </div>
    <div class="col-75">
      <input type="text" name="proj_title" value=" " placeholder="name..">
    </div>
  </div>
      
      <div class="row">
    <div class="col-25">
      <label for="subject">Description</label>
    </div>
    <div class="col-75">
      <textarea id="subject" name="objective" placeholder="Write something.." style="height:100px"></textarea>
    </div>
</div> 
  <div class="row">
    <div class="col-25">
      <label>Lecture ID</label>
    </div>
    <div class="col-75">
      <input type="text"  name="lect_id" value=" " placeholder="id..">
    </div>
  </div>
      <div class="row">
    <div class="col-25">
      <label>Lecture name</label>
    </div>
    <div class="col-75">
      <input type="text"  name="lect_name" value=" " placeholder="id..">
    </div>
  </div>
      <div class="row">
    <div class="col-25">
      <label>Lecture email</label>
    </div>
    <div class="col-75">
      <input type="text"  name="lect_email" value=" " placeholder="id..">
    </div>
  </div>
      <div class="row">
    <div class="col-25">
      <label>Lecture Room</label>
    </div>
    <div class="col-75">
      <input type="text"  name="room_no" value=" " placeholder="id..">
    </div>
  </div>
      <div class="row">
    <div class="col-25">
      <label>Lecture Status</label>
    </div>
    <div class="col-75">
      <input type="text"  name="lect_status" value=" " placeholder="VALID / NOT VALID">
    </div>
  </div>
      
 
  <div class="row">
    <input type="submit" value="Submit">
    
  </div>
  </form>
</div>

</body>
</html>

<%-- 
    Document   : error
    Created on : Jun 7, 2020, 3:11:43 AM
    Author     : User
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>FYP Management System</title>
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
            </ul>
            
        </header>
        <div id="main">
                <h3>ERROR PAGE</h3>
                <h3>WELCOME TO FSKM FYP MANANGMENT SYSTEM</h3>
                <p> This website is create to managed the FSKM students FYP registration </p>
             </div>
        
        <c:if test="${not empty errorMsgs}">
            
                <font color='red'> Please correct the following errors:
                    
                        <c:forEach var="message" items="${errorMsgs}">
                            ${message}
                        </c:forEach>
                    
                </font>
           
        </c:if>
            
            <p><a href="Current.jsp"> BACK TO LIST </a></p>
            
    </body>
</html>

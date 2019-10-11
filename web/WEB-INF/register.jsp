<%-- 
    Document   : register
    Created on : Oct 7, 2019, 6:43:11 PM
    Author     : 797462
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List </title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <form action="shoppingList" method="post">
            <h4> Username: <input rows="1" cols="30" name="inputOne" required></textarea> </h4>  
            <input type="hidden" name="action" value="register">
            <input type="submit" value="Submit">
        </form>
        <br>
        ${inputException}
    </body>
</html>

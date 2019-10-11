<%-- 
    Document   : shoppingList
    Created on : Oct 7, 2019, 6:43:57 PM
    Author     : 797462
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>

        <a>Hello,  ${currentlyLoged}<a>
                
                <h3>List</h3>
                <a href ="shoppingList?action=logout">Log out<a>
                        <br>
                        <form action="shoppingList" method="post">
                            <h4> Add Item: <input rows="1" cols="30" name="item" required></textarea> </h4>         
                            <input type="submit" value="Add">
                            <input type="hidden" name="action" value="add">
                            
                        </form>
                        
                        <form action="shoppingList" method="post">
                        <c:forEach var="ivan" items="${output}">
                            <input type="radio" name="btn" value="${ivan}">${ivan}<br>
                        </c:forEach>
                            <input type="submit" value="delete">
                            <input type="hidden" name="action" value="delete">
                            
                        </form>
    </body>
 </html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <center><h1>Music Store</h1>
            <h2>Enter Music Details</h2>
            
        <form:form method="POST" commandName="musicDetForm" action="AddSong">
              <table style="appearance:dialog ">
                    <tr>
                        <td>Music ID</td>
                        <td><form:input path="musicID" /></td>
                    </tr>
                    <tr>
                        <td>Music Language</td>
                        <td><form:input path="musicLanguage"/></td>
                    </tr>
                    <tr>
                        <td>Music Type(Melody/Devotional/Pop)</td>
                        <td><form:input path="musicType"/></td>
                    </tr>
                    <tr>
                        <td>Song Name</td>
                        <td><form:input path="songName"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><form:button name="addSong" value="Add Song">Add Song</form:button></td>
                        
                    </tr>
                </table>
           </form:form>
            </center>
        <a href="${pageContext.request.contextPath}/list.html">ZOZNAM</a>
      </body>
</html>

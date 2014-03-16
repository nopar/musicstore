<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Zoznam hudby</title>
    </head>
    <body>
        <center><h1>Zoznam z tabulky</h1>
            <h2>Music Details</h2>

            <c:if  test="${!empty polozky}">
                <table class="data" border="1" cellpadding="0" cellspacing="0">
                    <thead>
                        <tr>
                            <th width="5%">ID</th>
                            <th width="20%">LANGUAGE</th>
                            <th width="10%">TYPE</th>
                            <th width="10%">NAME</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${polozky}" var="polozka">
                            <tr>
                                <td>${polozka.musicID}</td>
                                <td>${polozka.musicLanguage}</td>
                                <td>${polozka.musicType}</td>
                                <td>${polozka.songName}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>



        </center>
        <a href="${pageContext.request.contextPath}/">HOME</a>
      </body>
</html>

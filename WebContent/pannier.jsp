<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
         <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<fmt:setLocale value="${pageContext.request.locale}" />
<fmt:setBundle basename="messages" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table  border=1  style=";margin-left:auto;margin-right:auto;text-align:center;">

    <td><fmt:message key="label.titre" /></td>
   
    <c:forEach var="var" items="${panneau}">
        <tr>  
          
            <td>${var.pan}</td>
           
            
        </tr>
    </c:forEach>
</table>
</body>
</html>
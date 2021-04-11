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
<h2><fmt:message key="label.welcome" /></h2>
<br>
<h2><a href="catalogue.jsp"> <fmt:message key="label.a1" /></a></h2>
<h2><a href="#"> <fmt:message key="label.a2" /></a></h2>
<h2><a href="pannier"> <fmt:message key="label.a3" /></a></h2>
</body>
</html>
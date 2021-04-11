<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<fmt:setLocale value="${pageContext.request.locale}" />
<fmt:setBundle basename="messages" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>catalogue <c:if test="${not empty type}">
    <fmt:message key="${type}" />
</c:if></h1>
<form action="Catalogue" method="get">
  <label for="music"><fmt:message key="label.c1" /></label>
  <select name="music" id="music">
    <option value="jazz">jazz</option>
    <option value="rock">rock</option>
    <option value="hiphop">hip hop</option>

  </select>
  
  <input type="submit" value="ok">
</form>

<table  border=1  style=";margin-left:auto;margin-right:auto;text-align:center;">
<td><fmt:message key="label.ref" /></td>
   <td><fmt:message key="label.titre" /></td>
   <td><fmt:message key="label.auteur" /></td>
   <td>cover</td>
   <td><fmt:message key="label.prix" /></td>
    <c:forEach var="var" items="${list}">
        <tr>  
            <td><a href="detail?ref=<c:url value="${var.ref}"/>">${var.ref}</a></td>
            <td>${var.titre}</td>
            <td>${var.auteur}</td>
            <td><img src="<c:url value="${var.img}"/>" width="100" height="100" BORDER=0/></td>
            <td style="width:50px;">${var.prix} <fmt:message key="label.currency" /></td>
            <td><a href="pannier?ref=<c:url value="${var.ref}"/>">ajouter au panier</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
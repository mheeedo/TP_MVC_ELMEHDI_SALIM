<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
<form action="inscrire" method="get">
<label><fmt:message key="label.nom" /></label>
<input type="text" id="nom" name="nom"  > <c:if test="${not empty nom}"><p style="color:red;display:inline;"><fmt:message key="${nom}" /></p></c:if><br/>

<label><fmt:message key="label.prenom" /></label>
<input type="text" id="prenom" name="prenom"  > <c:if test="${not empty prenom}"><p style="color:red;display:inline;"><fmt:message key="${prenom}" /></p> </c:if><br/>

<label><fmt:message key="label.adresse" /></label>
<input type="text" id="adresse" name="adresse"  > <c:if test="${not empty adresse}"><p style="color:red;display:inline;"><fmt:message key="${adresse}" /></p></c:if> <br/>

<label><fmt:message key="label.codepostal" /></label>
<input type="text" id="codepostal" name="codepostal"  ><c:if test="${not empty codepostal}"><p style="color:red;display:inline;"><fmt:message key= "${codepostal}" /></p> </c:if><br/>

<label><fmt:message key="label.ville" /></label> 
<input type="text" id="ville" name="ville"  > <c:if test="${not empty ville}"><p style="color:red;display:inline;"><fmt:message key = "${ville}" /></p> </c:if><br/>

<label><fmt:message key="label.email" /></label>
<input type="text" id="email" name="email"  ><c:if test="${not empty email}"><p style="color:red;display:inline;"><fmt:message key = "${email}" /></p> </c:if><br/>

<label><fmt:message key="label.mdp" /></label>
<input type="password" id="mdp" name="mdp"  > <c:if test="${not empty mdp}"><p style="color:red;display:inline;"><fmt:message key = "${mdp}" /></p></c:if><br/>

<button type="submit" id="ok" value="ok">ok</button>
</form>
</body>
</html>
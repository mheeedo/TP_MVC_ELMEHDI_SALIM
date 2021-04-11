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

<c:if test="${not empty error}">
    <p style="color:red;"><fmt:message key="${error}" /></p>
</c:if>
<form action="connexion" method="get">
<label><fmt:message key="label.email" /></label>
<input type="text" id="login" name="email"  > <br/>
<label><fmt:message key="label.mdp" /></label>
<input type="password" id="mdp" name="mdp"  > <br/>
<button type="submit"  value="ok">ok</button>
</form>

</body>
</html>
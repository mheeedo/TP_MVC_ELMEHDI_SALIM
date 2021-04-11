<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
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
<header><fmt:message key="label.detail" /></header>
<img src="<c:url value="${detail.img}"/>" width="100" height="100" BORDER=0/>
<h2 ><fmt:message key="label.ref" /> : <c:out value = "${detail.ref}" /></h2>
<h2 ><fmt:message key="label.titre" /> : <c:out value = "${detail.titre}" /></h2>
<h2 ><fmt:message key="label.auteur" /> : <c:out value = "${detail.auteur}" /></h2>
<h2 ><fmt:message key="label.prix" /> : <c:out value = "${detail.prix}" /> <fmt:message key="label.currency" /></h2>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello springmvc!!!</h1>
<h2>requestScope
	${ requestScope.student.id} === ${ requestScope.student.name}
</h2>
<h2>sessionScope
	${ sessionScope.student.id} === ${ sessionScope.student.name}
</h2>
<fmt:message key="resource.welcome"></fmt:message>
<fmt:message key="resource.exit"></fmt:message>
<br><br>

<c:forEach items="${requestScope.errors}" var="error">
	${error.getDefaultMessage() }<br>
</c:forEach>


</body>
</html>
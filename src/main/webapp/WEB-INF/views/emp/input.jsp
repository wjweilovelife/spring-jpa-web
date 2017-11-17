<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="${ctx}/js/jquery-1.9.1.min.js"></script>
</head>
<body>

<form:form action="${ctx}/add_emp" method="post" modelAttribute="employeeEntity">
    ID:<form:hidden path="id"/>
    LastName: <form:input path="lastName"/>
    <br>
    Email: <form:input path="email"/>
    <br>
    Birth: <form:input path="birthday"/>
    <br>
    Department:
    <form:select path="departmentId" items="${departments }"
                 itemLabel="departmentName" itemValue="id"></form:select>
    <br>
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>
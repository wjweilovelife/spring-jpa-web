<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<html>
<head>
    <title>部门添加</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="${ctx}/js/jquery-1.9.1.min.js"></script>
</head>
<body>
    <form:form action="${ctx}/add_dep" method="post" modelAttribute="department">
        <form:hidden path="id"/>
        name:<form:input path="departmentName"/>
        <br>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>

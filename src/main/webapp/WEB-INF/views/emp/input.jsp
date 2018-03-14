<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="${ctx}/js/jquery-1.9.1.min.js"></script>
</head>
<style type="text/css">
    input{display: block}
</style>
<script type="text/javascript">
    function submits() {
        $("#form").submit();
    }
</script>
<body>
<form id="form" action="${ctx}/add_emp" method="post">
    <input type="hidden" name="id" id="id">
    <label>name</label>
    <input type="text" name="lastName" id="lastName">
    <label>email</label>
    <input type="text" name="email" id="email">
    <label>Department</label>
    <select name="departmentId">
    <c:forEach items="${departments }" var="d">
        <option value="${d.id}">${d.departmentName}</option>
    </c:forEach>
    </select>
    <input type="button" value="submit" onclick="submits()"/>
</form>
</body>
</html>
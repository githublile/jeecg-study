<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html >
<html>
<head>
<title>ComboBox</title>
<t:base type="jquery,easyui"></t:base>
</head>
<body>
<t:comboBox url="" name="comboBox" text="下拉框" id="comboBox"></t:comboBox>
<%-- <form action="">
<textarea rows="50" cols="100"> ${ComboBox}</textarea>
</form> --%>
</body>
</html>
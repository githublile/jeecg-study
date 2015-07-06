<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html >
<html>
<head>
<title>CkeditorTag</title>
<t:base type="jquery,easyui,ckeditor"></t:base>
</head>
<body>
<t:ckeditor name="ckeditor" isfinder="true"></t:ckeditor>
<%-- <form action="">
<textarea rows="50" cols="100"> ${CkeditorTag}</textarea>
</form> --%>
</body>
</html>
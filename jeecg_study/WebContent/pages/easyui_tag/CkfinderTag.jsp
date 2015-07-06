<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html >
<html>
<head>
<title>CkfinderTag</title>
<t:base type="jquery,easyui,ckfinder"></t:base>
</head>
<body>
<t:ckfinder name="ckfinder" uploadType="Images"></t:ckfinder>
<%-- <form action="">
<textarea rows="50" cols="100"> ${CkfinderTag}</textarea>
</form> --%>
</body>
</html>
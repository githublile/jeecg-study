<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html >
<html>
<head>
<title>BaseTag</title>
<%-- <t:base type="jquery,ckeditor,ckfinder,easyui,DatePicker,jqueryui,jqueryui-sortable,prohibit,tools,autocomplete"></t:base> --%>
<t:base type="ckfinder"></t:base>
</head>
<body style="overflow: auto">
<form action="">
<textarea rows="50" cols="100"> ${BaseTag}</textarea>
</form>
</body>
</html>

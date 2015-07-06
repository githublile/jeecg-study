<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html >
<html>
<head>
<title>UploadTag</title>
<t:base type="jquery,easyui"></t:base>
</head>
<body>
<t:upload name="upload" id="upload" uploader="" extend=""></t:upload>
<%-- <form action="">
<textarea rows="50" cols="100"> ${UploadTag}</textarea>
</form> --%>
</body>
</html>
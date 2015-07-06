<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html >
<html>
<head>
<title>FormValidationTag</title>
<t:base type="jquery,easyui"></t:base>
</head>
<body>
<t:formvalid layout="div" dialog="true" formid="formobj"></t:formvalid>
<%-- <form action="">
<textarea rows="50" cols="100"> ${FormValidationTag}</textarea>
</form> --%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html >
<html>
<head>
<title>DataGridTag</title>
<t:base type="jquery,easyui"></t:base>
</head>
<body>
<t:datagrid actionUrl="" name="datagrid">
	<t:dgCol field="id" title="身份ID"></t:dgCol>
	<%-- <t:dgCol field="opt" title="默认操作"></t:dgCol>
	<t:dgDefOpt url="" title="默认操作"></t:dgDefOpt> --%>
	<%-- <t:dgCol field="opt" title="删除操作"></t:dgCol>
	<t:dgDelOpt url="" title="删除" ></t:dgDelOpt> --%>
	<%-- <t:dgCol field="opt" title="Open操作"></t:dgCol>
	<t:dgOpenOpt url="" title="打开窗口"></t:dgOpenOpt> --%>
	<%-- <t:dgCol field="opt" title="自定义函数操作"></t:dgCol>
	<t:dgFunOpt funname="fun" title="自定义函数操作"></t:dgFunOpt> --%>
	<%-- <t:dgToolBar title="ToolBar" onclick="fun()"></t:dgToolBar> --%>
	<%-- <t:dgCol field="opt" title="ConfOpt"></t:dgCol>
	<t:dgConfOpt url="" message="ConfOpt" title="ConfOpt测试" ></t:dgConfOpt> --%>
</t:datagrid>
<%-- <form action="">
<textarea rows="50" cols="100"> ${DataGridTag}</textarea>
</form>
 --%></body>
</html>
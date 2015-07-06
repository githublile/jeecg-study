<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html >
<html>
<head>
<title>Controller_URL</title>
<t:base type="jquery,easyui"></t:base>
</style>
</head>
<body class="easyui-layout" style="overflow-y: hidden" scroll="no">
Controller_URL_main
<!-- 顶部-->
<div region="north" border="false" title=" JEECG Framework 3.4.3 GA" style="BACKGROUND: #E6E6FA; height: 85px; padding: 1px; overflow: hidden;">
</div>
<!-- 左侧-->
<div region="west" split="true" href="loginController.do?left"  title="导航菜单" style="width: 150px; padding: 1px;"></div>
<!-- 中间-->
<div id="mainPanle" region="center" style="overflow: hidden;">
</div>
<!-- 右侧 -->
<div collapsed="true" region="east" iconCls="icon-reload" title="辅助工具" split="true" style="width: 190px;">
</div>
<!-- 底部 -->
<div region="south" border="false" style="height: 25px; overflow: hidden;">

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html >
<html>
<head>
<title>easyui_tag</title>
<t:base type="jquery,easyui"></t:base>
<script type="text/javascript">
	$(function(){
		 $.getJSON('tags.do?list',function(data){  
			 var html="<option>请选择~~~</option>";
			// console.info(data);
		        $.each(data,function(entryIndex, entry){  
		        	html+="<option>"+entry+"</option>";
		        }); 
		        $('#select').html(html);  
		    });  
		    return false;   	
	});

</script>
</head>
<body>
<form action="tags.do?url" method="get">
  URL: <select id="select" name="url">
  		</select>
	   <input type="submit" value="显示">
</form>
</body>
</html>

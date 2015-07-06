<script type="text/javascript">
	$(document).ready(function() {
		$("#").autocomplete("commonController.do?getAutoList", {
			max : 5,
			minChars : 2,
			width : 200,
			scrollHeight : 100,
			matchContains : true,
			autoFill : false,
			extraParams : {
				featureClass : "P",
				style : "full",
				maxRows : 10,
				labelField : "",
				valueField : "",
				searchField : "",
				entityName : "",
				trem : getTremValue
			}
		}).result(function(event, row, formatted) {
		});
	});
	function getTremValue() {
		return $("#").val();
	}
</script>
<input type="text" id="" datatype="*" nullmsg=""
	errormsg="输入格式不对" />
<input type="hidden" id="" name="" />
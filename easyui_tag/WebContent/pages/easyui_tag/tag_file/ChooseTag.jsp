<a href="#" class="easyui-linkbutton" plain="true" icon=""
	onClick="choose_402842c24dfb9a84014dfb9dfa8b0004()">选择</a>
<script type="text/javascript">
	var windowapi = frameElement.api, W = windowapi.opener;
	function choose_402842c24dfb9a84014dfb9dfa8b0004() {
		if (typeof (windowapi) == 'undefined') {
			$.dialog({
				content : 'url:',
				zIndex : 2100,
				title : '',
				lock : true,
				width : 400,
				height : 350,
				left : '85%',
				top : '65%',
				opacity : 0.4,
				button : [ {
					name : '确认',
					callback : clickcallback_402842c24dfb9a84014dfb9dfa8b0004,
					focus : true
				}, {
					name : '取消',
					callback : function() {
					}
				} ]
			});
		} else {
			$.dialog({
				content : 'url:',
				zIndex : 2100,
				title : '',
				lock : true,
				parent : windowapi,
				width : 400,
				height : 350,
				left : '85%',
				top : '65%',
				opacity : 0.4,
				button : [ {
					name : '确认',
					callback : clickcallback_402842c24dfb9a84014dfb9dfa8b0004,
					focus : true
				}, {
					name : '取消',
					callback : function() {
					}
				} ]
			});
		}
	}
	function clickcallback_402842c24dfb9a84014dfb9dfa8b0004() {
		iframe = this.iframe.contentWindow;
		var choose = iframe.getchooseSelections('choose');
		if ($('#choose').length >= 1) {
			$('#choose').val(choose);
			$('#choose').blur();
		}
		if ($("input[name='choose']").length >= 1) {
			$("input[name='choose']").val(choose);
			$("input[name='choose']").blur();
		}
	}
</script>
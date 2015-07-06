<script type="text/javascript">
	$(function() {
		function addtabs(title, url, id, icon, closable) {
			$('#tabs').tabs('add', {
				id : id,
				title : title,
				content : createFrametabs(id),
				closable : closable = (closable == 'false') ? false : true,
				icon : icon
			});
		}
		$('#tabs').tabs({
			onSelect : function(title) {
				var p = $(this).tabs('getTab', title);
			}
		});
		function createFrametabs(id) {
			var s = '<iframe id="'
					+ id
					+ '" scrolling="no" frameborder="0"  src="about:jeecg" width="100%" height="99.5%"></iframe>';
			return s;
		}
	});
</script>
<div id="tabs" tabPosition="top" border=flase
	style="margin: 0px; padding: 0px; overflow: hidden; width: auto;"
	class="easyui-tabs" fit="true"></div>
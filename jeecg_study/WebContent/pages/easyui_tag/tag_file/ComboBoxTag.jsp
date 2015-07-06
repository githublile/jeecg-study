<script type="text/javascript">
	$(function() {
		$('#comboBox').combobox({
			url : '&id=comboBox&text=下拉框',
			editable : 'false',
			valueField : 'id',
			textField : 'text',
			width : 'null',
			listWidth : 'null',
			listHeight : 'null',
			onChange : function() {
				var val = $('#comboBox').combobox('getValues');
				$('#comboBoxhidden').val(val);
			}
		});
	});
</script>
<input type="hidden" name="comboBox" id="comboBoxhidden">
<input class="easyui-combobox" multiple="true" panelHeight="auto"
	name="comboBoxname" id="comboBox">
<script type="text/javascript">
	$(function() {
		$('#datagrid')
				.datagrid(
						{
							idField : 'id',
							url : '&field=id,',
							fit : true,
							loadMsg : '数据加载中...',
							pageSize : 10,
							pagination : true,
							pageList : [ 10, 20, 30 ],
							sortOrder : 'asc',
							rownumbers : true,
							singleSelect : true,
							fitColumns : true,
							showFooter : true,
							frozenColumns : [ [] ],
							columns : [ [
									{
										field : 'id',
										title : '身份ID',
										sortable : true
									},
									{
										field : 'opt',
										title : 'ConfOpt',
										formatter : function(value, rec, index) {
											if (!rec.id) {
												return '';
											}
											var href = '';
											href += "[<a href='#' onclick=confirm('','ConfOpt','datagrid')> ";
											href += "ConfOpt测试</a>]";
											return href;
										}
									} ] ],
							onLoadSuccess : function(data) {
								$("#datagrid").datagrid("clearSelections");
							},
							onClickRow : function(rowIndex, rowData) {
								rowid = rowData.id;
								gridname = 'datagrid';
							}
						});
		$('#datagrid').datagrid('getPager').pagination({
			beforePageText : '',
			afterPageText : '/{pages}',
			displayMsg : '{from}-{to}共{total}条',
			showPageList : true,
			showRefresh : true
		});
		$('#datagrid').datagrid('getPager').pagination({
			onBeforeRefresh : function(pageNumber, pageSize) {
				$(this).pagination('loading');
				$(this).pagination('loaded');
			}
		});
	});
	function reloadTable() {
		try {
			$('#' + gridname).datagrid('reload');
			$('#' + gridname).treegrid('reload');
		} catch (ex) {
		}
	}
	function reloaddatagrid() {
		$('#datagrid').datagrid('reload');
	}
	function getdatagridSelected(field) {
		return getSelected(field);
	}
	function getSelected(field) {
		var row = $('#' + gridname).datagrid('getSelected');
		if (row != null) {
			value = row[field];
		} else {
			value = '';
		}
		return value;
	}
	function getdatagridSelections(field) {
		var ids = [];
		var rows = $('#datagrid').datagrid('getSelections');
		for ( var i = 0; i < rows.length; i++) {
			ids.push(rows[i][field]);
		}
		ids.join(',');
		return ids
	};
	function getSelectRows() {
		return $('#datagrid').datagrid('getChecked');
	}
	function datagridsearch() {
		var queryParams = $('#datagrid').datagrid('options').queryParams;
		$('#datagridtb').find('*').each(function() {
			queryParams[$(this).attr('name')] = $(this).val();
		});
		$('#datagrid').datagrid({
			url : '&field=id,',
			pageNumber : 1
		});
	}
	function dosearch(params) {
		var jsonparams = $.parseJSON(params);
		$('#datagrid').datagrid({
			url : '&field=id,',
			queryParams : jsonparams
		});
	}
	function searchReset(name) {
		$("#" + name + "tb").find(":input").val("");
		datagridsearch();
	}
</script>
<table width="100%" id="datagrid" toolbar="#datagridtb"></table>
<div id="datagridtb" style="padding: 3px; height: auto">
	<div style="height: 0px;">
		<span style="float: left;"></span>
	</div>
</div>
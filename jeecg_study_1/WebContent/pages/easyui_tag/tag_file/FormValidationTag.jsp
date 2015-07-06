<div id="content">
	<div id="wrapper">
		<div id="steps">
			<form id="formobj" action="null" name="formobj" method="post">
				<input type="hidden" id="btn_sub" class="btn_sub" />
				<link rel="stylesheet" href="plug-in/Validform/css/divfrom.css"
					type="text/css" />
				<link rel="stylesheet" href="plug-in/Validform/css/style.css"
					type="text/css" />
				<link rel="stylesheet" href="plug-in/Validform/css/tablefrom.css"
					type="text/css" />
				<script type="text/javascript"
					src="plug-in/Validform/js/Validform_v5.3.1_min.js"></script>
				<script type="text/javascript"
					src="plug-in/Validform/js/Validform_Datatype.js"></script>
				<script type="text/javascript"
					src="plug-in/Validform/js/datatype.js"></script>
				<script type="text/javascript">
					$(function() {
						$("#formobj")
								.Validform(
										{
											tiptype : 4,
											btnSubmit : "#btn_sub",
											btnReset : "#btn_reset",
											ajaxPost : true,
											callback : function(data) {
												var win = frameElement.api.opener;
												if (data.success == true) {
													frameElement.api.close();
													win.tip(data.msg);
												} else {
													if (data.responseText == ''
															|| data.responseText == undefined) {
														$.messager.alert(
																'错误',
																data.msg);
														$.Hidemsg();
													} else {
														try {
															var emsg = data.responseText
																	.substring(
																			data.responseText
																					.indexOf('错误描述'),
																			data.responseText
																					.indexOf('错误信息'));
															$.messager.alert(
																	'错误',
																	emsg);
															$.Hidemsg();
														} catch (ex) {
															$.messager
																	.alert(
																			'错误',
																			data.responseText
																					+ "");
															$.Hidemsg();
														}
													}
													return false;
												}
												win.reloadTable();
											}
										});
					});
				</script>
			</form>
		</div>
	</div>
</div>
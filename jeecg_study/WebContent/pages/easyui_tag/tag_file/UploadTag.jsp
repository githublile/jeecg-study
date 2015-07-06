<link rel="stylesheet" href="plug-in/uploadify/css/uploadify.css"
	type="text/css"></link>
<script type="text/javascript"
	src="plug-in/uploadify/jquery.uploadify-3.1.js"></script>
<script type="text/javascript" src="plug-in/tools/Map.js"></script>
<script type="text/javascript">
	var flag = false;
	var fileitem = "";
	var fileKey = "";
	var serverMsg = "";
	var m = new Map();
	$(function() {
		$('#upload')
				.uploadify(
						{
							buttonText : '浏览',
							auto : false,
							progressData : 'speed',
							multi : true,
							height : 25,
							overrideEvents : [ 'onDialogClose' ],
							fileTypeDesc : '文件格式:',
							queueID : 'filediv',
							fileTypeExts : '',
							fileSizeLimit : '15MB',
							swf : 'plug-in/uploadify/uploadify.swf',
							uploader : '&sessionId=179E8B0FCCA78619D3F4EC4A5FEE637B',
							onUploadStart : function(file) {
							},
							onQueueComplete : function(queueData) {
								var win = frameElement.api.opener;
								win.reloadTable();
								win.tip(serverMsg);
								frameElement.api.close();
							},
							onUploadSuccess : function(file, data, response) {
								var d = $.parseJSON(data);
								if (d.success) {
									var win = frameElement.api.opener;
									serverMsg = d.msg;
								}
							},
							onFallback : function() {
								tip("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试")
							},
							onSelectError : function(file, errorCode, errorMsg) {
								switch (errorCode) {
								case -100:
									tip("上传的文件数量已经超出系统限制的"
											+ $('#upload').uploadify(
													'settings',
													'queueSizeLimit')
											+ "个文件！");
									break;
								case -110:
									tip("文件 ["
											+ file.name
											+ "] 大小超出系统限制的"
											+ $('#upload')
													.uploadify('settings',
															'fileSizeLimit')
											+ "大小！");
									break;
								case -120:
									tip("文件 [" + file.name
											+ "] 大小异常！");
									break;
								case -130:
									tip("文件 [" + file.name
											+ "] 类型不正确！");
									break;
								}
							},
							onUploadProgress : function(file, bytesUploaded,
									bytesTotal, totalBytesUploaded,
									totalBytesTotal) {
							}
						});
	});
	function upload() {
		$('#upload').uploadify('upload', '*');
		return flag;
	}
	function cancel() {
		$('#upload').uploadify('cancel', '*');
	}
</script>
<span id="uploadspan"><input type="file" name="upload"
	id="upload" /></span>
<textarea id="ckeditor_text" name="ckeditor">null</textarea>
<script type="text/javascript">
	var ckeditor_ckeditor = CKEDITOR
			.replace(
					"ckeditor_text",
					{
						filebrowserBrowseUrl : 'plug-in/ckfinder/ckfinder.html',
						filebrowserImageBrowseUrl : 'plug-in/ckfinder/ckfinder.html?type=Images',
						filebrowserFlashBrowseUrl : 'plug-in/ckfinder/ckfinder.html?type=Flash',
						filebrowserUploadUrl : 'plug-in/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files',
						filebrowserImageUploadUrl : 'plug-in/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images',
						filebrowserFlashUploadUrl : 'plug-in/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash'
					});
	CKFinder.SetupCKEditor(ckeditor_ckeditor);
</script>
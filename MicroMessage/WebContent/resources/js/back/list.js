/**
 * 调用后台进行批量删除方法
 * JavaScript的名字要与调用的JSP页面的名字相同
 */
function deleteBatch(basePath) {
	$("#mainForm").attr("action",basePath + "deleteBatchServlet.action")
	$("#mainForm").submit();
}
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script src="http://open.sojson.com/common/js/canvas-nest.js" count="200" zindex="-2" opacity="0.5" color="47,135,193" type="text/javascript"></script>
	<!-- 代码开始 -->
	<input type="button" value="获取列表" onclick="query_list()">
	
	<!-- 代码结束 -->
	
	<script type="text/javascript">
		
		//ajax登陆
		function query_list() {
			$.ajax({
				url:"<%=request.getContextPath() %>/user/selectUserListJson.jhtml?aaa=xiaoming",
				type:"get",
				dataType:"json",
				success:function(data) {
					console.log(data);
				}
			});
		}
		
	</script>
</body>
</html>
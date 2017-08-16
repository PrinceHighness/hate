<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>金科教育</title>

    <!-- Bootstrap -->
    <link href="<%=request.getContextPath() %>/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- tab页（选项卡）组件 -->
    <link href="<%=request.getContextPath() %>/js/bootStrap-addTabs/bootstrap.addtabs.css" rel="stylesheet">

	<link href="<%=request.getContextPath() %>/js/bootstrap-table/dist/bootstrap-table.min.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/js/bootstrap-dialog/dist/css/bootstrap-dialog.min.css" rel="stylesheet">
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/js/bootstrap-fileinput/css/fileinput.css" />

	<link href="<%=request.getContextPath() %>/js/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
	
	<!-- ztree样式 -->
	<%-- <link rel="stylesheet" href="<%=request.getContextPath() %>/js/ztree_v3/css/demo.css" type="text/css"> --%>
	<%-- <link rel="stylesheet" href="<%=request.getContextPath() %>/js/ztree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css"> --%>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/js/ztree_v3/css/metroStyle/metroStyle.css" type="text/css">
	
	<!-- treegrid -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/js/jquery-treegrid/css/jquery.treegrid.css">
	
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<style type="text/css">
	.lie {
		/*height:300px;*/
		background: #ffffee;
	}
	.navbar {
		height: 52px;
		background: #000000;
	}
	.container-fluid {
		top: 48px;
		position: relative;
	}
	#nav_h3 {
		text-align:center;
		color: gray;
	}
	
</style>

</head>
<body>

	<!-- 导航条 -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<h3 id="nav_h3">金科教育企业平台</h3>
	</nav>
	
	<!-- 流式布局 -->
	<div class="container-fluid">
		<!-- 栅格系统 -->
		<div class="row">
			<!-- 添加列 -->
			<!-- <div class="col-xs-* lie">
				玩呢，演示一下栅格系统
			</div> -->
		</div>
		
		<div class="row">
			<!-- 添加列 -->
			<div class="col-xs-3 lie">
				<!-- 添加列表组（树菜单） -->
				<div id="tree"></div>
			</div>
			<div class="col-xs-9 lie">
				<div id="content-div">
					<!-- 选项卡 -->
					<div id="tabs">
                        <!-- Nav tabs -->
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active">
                                <a href="#home" aria-controls="home" role="tab" data-toggle="tab">主页</a></li>
                        </ul>
                        <!-- Tab panes（放置结果页面） -->
                        <div class="tab-content">
                        </div>
                    </div>
				</div>
			</div>
		</div>
		
	</div>
	




	<!-- jquery -->
	<script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/bootStrap-addTabs/bootstrap.addtabs.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/bootstrap-treeview/dist/bootstrap-treeview.min.js"></script>
	   
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap-table/dist/bootstrap-table.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap-table/dist/locale/bootstrap-table-zh-CN.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap-dialog/dist/js/bootstrap-dialog.min.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap-fileinput/js/fileinput.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap-fileinput/js/locales/zh.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/dateformat/formatDatebox.js"></script>
	
	<!-- 加载ajax重定向设置文件 -->
	<script type="text/javascript" src="js/ajaxSetup.js"></script>
	
	<!-- ztree插件 -->
	<script type="text/javascript" src="js/ztree_v3/js/jquery.ztree.all.min.js"></script>
	
	<!-- treegrid -->
	<script type="text/javascript" src="js/jquery-treegrid/js/jquery.treegrid.min.js"></script>
	<script type="text/javascript" src="js/jquery-treegrid/js/jquery.treegrid.bootstrap3.js"></script>
	<script type="text/javascript" src="js/jquery-treegrid/extension/jquery.treegrid.extension.js"></script>
	
	<script type="text/javascript">
    	/* function link_to_page(name, doc) {
    		//发送ajax请求
    		$.ajax({
    			url:$(doc).attr("href"),
    			success:function(data) {
    				$.addtabs.add({id:$(doc).attr("title"),title:$(doc).attr("title"),content:data});
    			}
    		});
    	} */
    	
    	<%-- //获取菜单数据
    	function getTreeData() {
    		var tree_data = [];
    		//发送ajax请求
    		$.ajax({
    			url:"<%=request.getContextPath() %>/tree/findTreeList.action",
    			dataType:"json",
    			async:false,
    			success:function(data) {
    				tree_data = data;
    			}
    		});
    		return tree_data
    	} --%>
    	
    	
    	var tree_data = [
    	                 	{text:"用户管理",
    	                 		href:"<%=request.getContextPath() %>/user/toUserListPage.jhtml",
    	                 		state: {
    	                 		    selected: true
    	                 		  },},
    	                 	{text:"角色管理",
    	                 		href:"<%=request.getContextPath() %>/role/toRoleListPage.jhtml",},
    	                 	{text:"品牌管理",
    	                 		href:"sdsds",nodes:[{text:"haha"}]},
    	                 	{text:"员工管理",
    	                 		href:"sdsds",},
    	                 	{text:"部门管理",
    	                 		href:"sdsds",},
    	                 ];
    	
    	//初始化树
    	$('#tree').treeview({
    		data:getTreeData(),
    		onNodeSelected:function(event, node) {
    			if (null != node.href && "" != node.href) {
    				//发送ajax请求
            		$.ajax({
            			url:"<%=request.getContextPath() %>" + node.href,
            			success:function(data) {
            				$.addtabs.add({id:node.text,title:node.text,content:data});
            			}
            		});
    			}
    		}
    	});
    	
    	//获取菜单数据
    	function getTreeData() {
    		var tree_data = [];
    		//发送ajax请求
    		$.ajax({
    			async:false,//请求为同步
    			url:"<%=request.getContextPath() %>/user/selectTreeListJson.jhtml",
    			data:{userID:"${userInfo.userID }"},
    			dataType:"json",
    			success:function(data) {
    				tree_data = data;
    			}
    		});
    		return tree_data
    	}
    </script>

</body>
</html>
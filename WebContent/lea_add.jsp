<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>HR医院 - 添加请假信息</title>
	<meta name="keywords" content="">
	<meta name="description" content="">

	<link rel="shortcut icon" href="favicon.ico">
	<link href="<%=path %>/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
	<link href="<%=path %>/css/font-awesome.css?v=4.4.0" rel="stylesheet">

	<!-- Data Tables -->
	<link href="<%=path %>/css/plugins/dataTables/dataTables.bootstrap.css"
		rel="stylesheet">
	<link href="<%=path %>/css/animate.css" rel="stylesheet">
	<link href="<%=path %>/css/style.css?v=4.1.0" rel="stylesheet">

</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>申请请假</h5>
					</div>
					<div class="ibox-content">
						<form method="post" class="form-horizontal" id="commentForm" action="<%=path %>/LeaServlet?method=addLea">
							<div class="form-group">
								<label class="col-sm-3 control-label">工号</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="employee_number">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">部门号</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="department_number">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">开始时间</label>
								<div class="col-sm-7">
									<input type="date" class="form-control" size="1" name="start_time">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">结束时间</label>
								<div class="col-sm-7">
									<input type="date" class="form-control" size="1" name="end_time">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">天数</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" placeholder="" name="days">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">原因</label>
								<div class="col-sm-7" >
									<input type="text" class="form-control" placeholder="" name="reason">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">类型</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" placeholder="" name="type">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">管理员</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" placeholder="" name="manager">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">状态</label>
								<div class="col-sm-7">
									<select class="form-control m-b" name="status" size="1" required>
										<option value="">--请选择状态--</option>
										<option value="1">未批准</option>
										<option value="2">已批准</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">备注</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" placeholder="" name="notes">
								</div>
							</div>
							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<div class="col-sm-4 col-sm-offset-8">
									<button class="btn btn-success" type="submit">添&nbsp;&nbsp;加</button>&nbsp;&nbsp;&nbsp;&nbsp;
									<a href="<%=path %>/LeaServlet?method=findLeaList" class="btn btn-info">返&nbsp;&nbsp;回</a>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 全局js -->
	<script src="<%=path %>/js/jquery.min.js?v=2.1.4"></script>
	<script src="<%=path %>/js/bootstrap.min.js?v=3.3.6"></script>
	<script src="<%=path %>/js/plugins/jeditable/jquery.jeditable.js"></script>
	
	<!-- Data Tables -->
	<script src="<%=path %>/js/plugins/dataTables/jquery.dataTables.js"></script>
	<script src="<%=path %>/js/plugins/dataTables/dataTables.bootstrap.js"></script>

	<!-- 自定义js -->
	<script src="<%=path %>/js/content.js?v=1.0.0"></script>
	
	<!-- 表单验证 -->
	<script src="<%=path %>/js/plugins/validate/jquery.validate.min.js"></script>
	<script src="<%=path %>/js/plugins/validate/messages_zh.min.js"></script>
	
	<!-- layer javascript -->
    <script src="js/plugins/layer/layer.min.js"></script>
	<script>
	$().ready(function() {
	    $("#commentForm").validate();
	});
	$.validator.setDefaults({
	    submitHandler: function() {
	    	parent.layer.alert('添加成功！',{icon: 1}),
	    	form.submit();
	    }
	});
	</script>
</body>
</html>

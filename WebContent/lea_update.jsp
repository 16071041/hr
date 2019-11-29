<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="nuc.web.pojo.Lea" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>HR医院 - 修改请假信息</title>
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
						<h5>修改请假信息</h5>
					</div>
					<div class="ibox-content">
						<% Lea lea = (Lea)request.getAttribute("lea"); %>
						<form method="post" class="form-horizontal" id="commentForm" action="<%=path %>/LeaServlet?method=doUpdateLea">
							<div class="form-group">
								<label class="col-sm-3 control-label">工号</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="employee_number" value="<%=lea.getEmployee_number() %>" readonly="readonly">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">部门号</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="department_number" value="<%=lea.getDepartment_number() %>" readonly="readonly">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">id</label>
								<div class="col-sm-7">
									<input type = "hidden" name = "id" value = "<%=lea.getId()%>" >
									<input type="text" class="form-control" name="name" value="<%=lea.getId() %>" readonly="readonly">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">开始时间</label>
								<div class="col-sm-7">
									<input type="date" class="form-control" name="start_time" value="<%=lea.getStart_time() %>"  required>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">结束时间</label>
								<div class="col-sm-7">
									<input type="date" class="form-control" name="end_time" value="<%=lea.getEnd_time() %>"  required>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">请假天数</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="days" value="<%=lea.getDays() %>" >
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" >事由</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="reason" value="<%=lea.getReason() %>">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">类型</label>
								<div class="col-sm-7" >
									<input type="text" class="form-control" name="type" value="<%=lea.getType() %>">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">状态</label>
								<div class="col-sm-7">
									<select class="form-control m-b" name="status" size="1" required>
									<option value="">--请选择状态--</option>
										<option value="未批准">未批准</option>
										<option value="已批准">已批准</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">备注</label>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="notes" value="<%=lea.getNotes() %>">
								</div>
							</div>
							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<div class="col-sm-4 col-sm-offset-8">
									<button class="btn btn-primary" type="submit">修&nbsp;&nbsp;改</button>&nbsp;&nbsp;&nbsp;&nbsp;
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
	    	parent.layer.msg('修改成功！',{icon: 1});
	    	form.submit();
	    }
	});
	</script>

</body>
</html>

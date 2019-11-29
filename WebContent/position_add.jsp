<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/11/29
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HR医院 - 添加职称</title>
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
                    <h5>添加职称</h5>
                </div>
                <div class="ibox-content">
                    <form method="post" class="form-horizontal" id="commentForm" action="<%=path %>/PstServlet?method=addPst">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">职称编号</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="position_number" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">职称名称</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="" name="name"  required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">职称级别</label>
                            <div class="col-sm-7">
                                <div class="radio i-checks">
                                    <label>
                                        <input type="radio" value="部门员工" name="level" checked="checked"> <i></i>部门员工</label>
                                    <i style="margin-left: 25px"></i>
                                    <label>
                                        <input type="radio" value="人事部员工" name="level"> <i></i>人事部员工</label>
                                    <i style="margin-left: 25px"></i>
                                    <label>
                                        <input type="radio" value="人事部主任" name="level"> <i></i>人事部主任</label>
                                    <i style="margin-left: 25px"></i>
                                    <label>
                                        <input type="radio" value="部门主任" name="level"> <i></i>部门主任</label>
                                    <i style="margin-left: 25px"></i>
                                </div>
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
                                <button class="btn btn-white" type="reset">取&nbsp;&nbsp;消</button>
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


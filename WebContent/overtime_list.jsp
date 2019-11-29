<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="nuc.web.pojo.Overtime" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HR医院 - 加班列表</title>
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

    <link rel="stylesheet" type="text/css" href="<%=path %>/dist/sweetalert.css">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>加班列表</h5>
                </div>
                <div class="ibox-content">
                    <div style="margin-bottom: 8px">
                        <a href="<%=path %>/overtime/toAdd.do" class="btn btn-success">安排加班</a>
                    </div>
                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>部门</th>
                            <th>加班人员</th>
                            <th>日期</th>
                            <th>管理</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<Overtime> list = (List<Overtime>) request.getAttribute("overtime");
                            int index = 1;
                            for (Overtime overtime : list) {
                        %>
                        <tr class="gradeA">
                            <td><%=index++ %>
                            </td>
                            <td><%=overtime.getDepartment_number() %>
                            </td>
                            <td><%=overtime.getEmployee_number() %>
                            </td>
                            <td><%=overtime.getDay() %>
                            </td>
                            <td><a href="<%=path %>/overtime/<%=overtime.getId() %>/toUpdate.do"
                                   class="btn btn-primary">修改</a>&nbsp;&nbsp;
                                <a onclick="del(<%=overtime.getId() %>)" class="btn btn-danger delete">删除</a></td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<%=path %>/js/content.js?v=1.0.0"></script>
<script>
    $(document).ready(function () {
        $('.dataTables-example').dataTable();

        var oTable = $('#editable').dataTable();

        oTable.$('td').editable('../example_ajax.php', {
            "callback": function (sValue, y) {
                var aPos = oTable.fnGetPosition(this);
                oTable.fnUpdate(sValue, aPos[0], aPos[1]);
            },
            "submitdata": function (value, settings) {
                return {
                    "row_id": this.parentNode.getAttribute('id'),
                    "column": oTable.fnGetPosition(this)[2]
                };
            },
            "width": "90%",
            "height": "100%"
        });
    });
</script>

<!-- 全局js -->
<script src="<%=path %>/js/jquery.min.js?v=2.1.4"></script>
<script src="<%=path %>/js/bootstrap.min.js?v=3.3.6"></script>
<script src="<%=path %>/js/plugins/jeditable/jquery.jeditable.js"></script>

<!-- Data Tables -->
<script src="<%=path %>/js/plugins/dataTables/jquery.dataTables.js"></script>
<script src="<%=path %>/js/plugins/dataTables/dataTables.bootstrap.js"></script>

<!-- 自定义js -->
<script src="<%=path %>/js/content.js?v=1.0.0"></script>

<!-- layer javascript -->
<script src="js/plugins/layer/layer.min.js"></script>

<script type="text/javascript">
    function del(id) {
        parent.layer.confirm('确认删除？', {
            btn: ['确认', '取消'], //按钮
            shade: false //不显示遮罩
        }, function () {
            parent.layer.msg('删除成功！', {icon: 1});
            location.href = "/" + id + "/delete.do";
        });
    }
</script>
</body>
</html>

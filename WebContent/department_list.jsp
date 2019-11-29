<%@ page import="nuc.web.pojo.Department" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/11/28
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HR医院 - 部门列表</title>
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
                    <h5>部门列表</h5>
                </div>
                <div class="ibox-content">
                    <div style="margin-bottom: 8px">
                        <a href="<%=path %>/department_add.jsp" class="btn btn-success">添加部门</a>
                    </div>
                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>部门编号</th>
                            <th>部门名称</th>
                            <th>部门领导</th>
                            <th>电话</th>
                            <th>地址</th>
                            <th>备注</th>
                        </tr>
                        </thead>
                        <tbody>
                        <!-- if(null != pe && null != pe.getRecords() && pe.getRecords().size()>0) -->>
                        <%

                            List<Department> dt=(List<Department>)request.getAttribute("dptList");

                            int index=1;

                            for(Department dpt : dt){
                        %>
                        <tr class="gradeA">
                            <td><%=index++ %></td>
                            <td><%=dpt.getDepartment_number()%></td>
                            <td><%=dpt.getName()%></td>
                            <td><%=dpt.getManager() %></td>
                            <td><%=dpt.getTelephone() %></td>
                            <td><%=dpt.getAddress() %></td>
                            <td><%=dpt.getNotes() %></td>
                            <%-- 								<%
                                                                String intime = MTimeUtil.dateFormat(employee.getInTime());
                                                            %> --%>
                            <%--                            <td><%=employee.getIn_time() %></td>--%>
                            <td>&nbsp;
                                <a href="<%=path %>/DptServlet?method=toUpdateDpt&id=<%=dpt.getId()%>" class="btn btn-primary">修改</a>&nbsp;&nbsp;
                                <a onclick="del(<%=dpt.getId()%>)" class="btn btn-danger delete">删除</a>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
    <%--                <div>
							<span style="float: left; padding: 5px">
								当前&nbsp;<span style="color: red;">&lt;%&ndash; <%=pe.getCurrent() %> &ndash;%&gt;</span>&nbsp;/&nbsp;<b>&lt;%&ndash; <%=pe.getPages() %> &ndash;%&gt;</b>&nbsp;页&nbsp;&nbsp;
								总共&nbsp;<b>&lt;%&ndash; <%=pe.getTotal() %> &ndash;%&gt;</b>&nbsp;条</span>
                        <nav aria-label="Page navigation" style="margin: 0 auto; width: 240px">
                            <ul class="pagination" style="margin: 0;">
                                <li>
                                    <a href="#" aria-label="Previous"> <span aria-hidden="true">前一页</span>
                                    </a>
                                </li>
                                 <%
                                     for(int i=1;i<=pe.getPages();i++){
                                %>
                                    <li><a href="<%=path %>/employee/listPage.do?pageNo=<%=i%>"><%=i %></a></li>
                                <%
                                      }
                                %>
                                <li><a href="#" aria-label="Next"> <span aria-hidden="true">后一页</span>
                                </a></li>
                            </ul>
                        </nav>
                    </div>--%>
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

<!-- layer javascript -->
<script src="js/plugins/layer/layer.min.js"></script>

<script type="text/javascript">

    function del(id){
        parent.layer.confirm('确认删除？', {
            btn: ['确认','取消'], //按钮
            shade: false //不显示遮罩
        }, function(){
            parent.layer.msg('删除成功！', {icon: 1});
            location.href="./"+"/DptServlet?method=delDpt&id="+id;
        });
    }
</script>
</body>
</html>


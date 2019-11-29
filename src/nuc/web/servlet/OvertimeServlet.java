package nuc.web.servlet;

import nuc.web.dao.DptDao;
import nuc.web.dao.EmpDao;
import nuc.web.dao.HistoryDao;
import nuc.web.dao.OvertimeDao;
import nuc.web.pojo.Department;
import nuc.web.pojo.Employee;
import nuc.web.pojo.History;
import nuc.web.pojo.Overtime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by barackbao on 2019/11/29
 */
@WebServlet("/OvertimeServlet")
public class OvertimeServlet extends HttpServlet {
    public OvertimeServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取方法参数名称
        String name = req.getParameter("method");

        try {
            //动态获取目标方法名称，参数类型，调用目标方法
            Method method = this.getClass().getDeclaredMethod(name, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求，响应，返回内容编码格式
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        doGet(req, resp);
    }


    /**
     * 查询加班记录
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void findOvertimeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OvertimeDao dao = new OvertimeDao();
        List<Overtime> list = dao.selectOvertimeList();
        System.out.printf("list len is:" + list.size());
        request.setAttribute("overtime", list);
        request.getRequestDispatcher("/overtime_list.jsp").forward(request, response);
    }


    /**
     * 查询所有部门和所有员工
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void toAddOvertime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询出所有的部门
        DptDao dptDao = new DptDao();
        List<Department> dList = dptDao.selectDptList();
        request.setAttribute("dList", dList);
        //查询出所有的员工
        EmpDao empDao = new EmpDao();
        List<Employee> eList = empDao.selectEmpList();
        request.setAttribute("eList", eList);
        request.getRequestDispatcher("/overtime_add.jsp").forward(request, response);
    }

    protected void insertOvertime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OvertimeDao dao = new OvertimeDao();
        String dn = request.getParameter("departmentNumber");
        int departmentNumber = Integer.parseInt(dn);
        String en = request.getParameter("employeeNumber");
        int employeeNumber = Integer.parseInt(en);
        String date = request.getParameter("date");
        Overtime overtime = new Overtime(departmentNumber, employeeNumber, date);
        dao.insertOvertime(overtime);
        List<Overtime> list = dao.selectOvertimeList();
        request.setAttribute("overtime", list);
        request.getRequestDispatcher("/overtime_list.jsp").forward(request, response);
    }

    protected void toUpdateOvertime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OvertimeDao dao = new OvertimeDao();
        String oId = request.getParameter("id");
        int id = Integer.parseInt(oId);
        Overtime overtime = dao.selectOvertimeById(id);
        request.setAttribute("overtime", overtime);
        //查询出所有的部门
        DptDao dptDao = new DptDao();
        List<Department> dList = dptDao.selectDptList();
        request.setAttribute("dList", dList);
        //查询出所有的员工
        EmpDao empDao = new EmpDao();
        List<Employee> eList = empDao.selectEmpList();
        request.setAttribute("eList", eList);
        request.getRequestDispatcher("/overtime_update.jsp").forward(request, response);
    }

    protected void updateOvertimeById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OvertimeDao dao = new OvertimeDao();
        String oId = request.getParameter("id");
        int id = Integer.parseInt(oId);
        String dn = request.getParameter("departmentNumber");
        int departmentNumber = Integer.parseInt(dn);
        String en = request.getParameter("employeeNumber");
        int employeeNumber = Integer.parseInt(en);
        String date = request.getParameter("date");
        Overtime overtime = new Overtime(id, departmentNumber, employeeNumber, date);
        dao.updateOvertime(overtime);
        List<Overtime> list = dao.selectOvertimeList();
        request.setAttribute("overtime", list);
        request.getRequestDispatcher("/overtime_list.jsp").forward(request, response);

    }

    protected void deleteOvertime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oId = request.getParameter("id");
        int id = Integer.parseInt(oId);
        OvertimeDao dao = new OvertimeDao();
        dao.delOvertime(id);
        List<Overtime> list = dao.selectOvertimeList();
        request.setAttribute("overtime", list);
        request.getRequestDispatcher("/overtime_list.jsp").forward(request, response);
    }


}

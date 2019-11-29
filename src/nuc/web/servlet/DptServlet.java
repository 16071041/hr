package nuc.web.servlet;

import nuc.web.dao.DptDao;
import nuc.web.dao.EmpDao;
import nuc.web.pojo.Department;
import nuc.web.pojo.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("/DptServlet")
public class DptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置请求，响应，返回内容编码格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取方法参数名称
        String name = request.getParameter("method");

        try {
            //动态获取目标方法名称，参数类型，调用目标方法
            Method method = this.getClass().getDeclaredMethod(name, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * 跳转部门列表界面
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void findDptList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DptDao dao = new DptDao();
        List<Department> list = dao.selectDptList();
        request.setAttribute("dptList", list);

        System.out.println("find dptlist.");
        request.getRequestDispatcher("/department_list.jsp").forward(request, response);
    }

    /**
     * 处理插入逻辑，跳转部门列表
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addDpt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String snum = request.getParameter("department_number");
        int num = Integer.parseInt(snum);
        String name = request.getParameter("name");
        String manager = request.getParameter("manager");
        String telephone = request.getParameter("telephone");
        String address = request.getParameter("address");
        String notes = request.getParameter("notes");

        Department dpt = new Department(0,num,name,manager,telephone,address,notes);


        DptDao dao = new DptDao();
        dao.insertDepartment(dpt);

        System.out.println("insert ok.");
        request.getRequestDispatcher("/DptServlet?method=findDptList").forward(request, response);
    }

    /**
     * 处理删除逻辑，并跳转列表界面
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void delDpt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DptDao dao = new DptDao();

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);

        dao.delDpt(id);
        System.out.println("delete ok.");
        request.getRequestDispatcher("/DptServlet?method=findDptList").forward(request, response);

    }

    /**
     * 修改部门信息1,跳转修改界面
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void toUpdateDpt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);

        DptDao dao = new DptDao();
        Department dpt = dao.selectDptById(id);


        if (dpt != null) {
            request.setAttribute("dpt", dpt);
            System.out.println("update1 成功。");
            request.getRequestDispatcher("/department_update.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/DptServlet?method=findDptList").forward(request, response);
        }

    }

    /**
     * 修改部门信息2，执行修改内容
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doUpdateDpt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        String name = request.getParameter("name");
        String manager = request.getParameter("manager");
        String telephone = request.getParameter("telephone");
        String address = request.getParameter("address");
        String notes = request.getParameter("notes");

        Department dpt = new Department(id,0,name,manager,telephone,address,notes);

        DptDao dao = new DptDao();
        int i = dao.updateDpt(dpt);

        System.out.println("update2 成功。");
        request.getRequestDispatcher("/DptServlet?method=findDptList").forward(request, response);

    }
}

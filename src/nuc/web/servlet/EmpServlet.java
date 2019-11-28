package nuc.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import nuc.web.dao.EmpDao;
import nuc.web.dao.HistoryDao;
import nuc.web.pojo.Employee;
import nuc.web.pojo.History;


/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

    public EmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
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
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置请求，响应，返回内容编码格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        doGet(request, response);
    }

    /**
     * 处理登录逻辑
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void findLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取session会话对象，保存用户登录信息
        HttpSession session = request.getSession();
        String employeeNumber = request.getParameter("employeeNumber");

        int num = Integer.parseInt(employeeNumber);
        String pwd = request.getParameter("password");
        EmpDao dao = new EmpDao();
        Employee emp = dao.selectLogin(num, pwd);

        if (emp == null) {
            response.sendRedirect("login.jsp");
        } else {
            session.setAttribute("emp", emp);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }


    /**
     * 处理员工列表逻辑
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void findEmpList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpDao dao = new EmpDao();
        List<Employee> list = dao.selectEmpList();
        request.setAttribute("empList", list);
        request.getRequestDispatcher("/employee_list.jsp").forward(request, response);
    }


    /**
     * 删除员工逻辑
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void delEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmpDao dao = new EmpDao();

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);

        dao.delEmp(id);
        System.out.println("delete ok.");
        request.getRequestDispatcher("/EmpServlet?method=findEmpList").forward(request, response);

        //request.setAttribute("empList", list);
        //request.getRequestDispatcher("/employee_list.jsp").forward(request, response);
    }


    /**
     * 增加员工逻辑
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String snum = request.getParameter("employeeNumber");
        int num = Integer.parseInt(snum);
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String education = request.getParameter("education");
        int dnum = Integer.parseInt(request.getParameter("departmentNumber"));
        int pnum = Integer.parseInt(request.getParameter("positionNumber"));
        Employee emp = new Employee(num, name, gender, birthday, telephone, email, address, education, dnum, pnum, password);

        EmpDao dao = new EmpDao();
        dao.insertEmpe(emp);

        System.out.println("insert ok.");
        request.getRequestDispatcher("/EmpServlet?method=findEmpList").forward(request, response);
    }

    /**
     * 通过id查找员工
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void findEmpById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        EmpDao dao = new EmpDao();
        Employee emp = dao.selectEmpById(id);

        System.out.println("查看成功。");
        if (emp != null) {
            request.setAttribute("emp", emp);
            request.getRequestDispatcher("employee_detail.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/EmpServlet?method=findEmpList").forward(request, response);
        }

    }

    /**
     * 修改员工信息1,跳转修改界面
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void toUpdateEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);

        EmpDao dao = new EmpDao();
        Employee emp = dao.selectEmpById(id);

        if (emp != null) {
            request.setAttribute("emp", emp);
            System.out.println("update1 成功。");
            request.getRequestDispatcher("/employee_update.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/EmpServlet?method=findEmpList").forward(request, response);
        }

    }

    /**
     * 修改员工信息2，执行修改内容
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doUpdateEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String date = request.getParameter("date");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String education = request.getParameter("education");


        Employee emp = new Employee(id, name, gender, date, telephone, email, address, education, password);
        EmpDao dao = new EmpDao();
        int i = dao.updateEmp(emp);

        System.out.println("update2 成功。");
        request.getRequestDispatcher("/EmpServlet?method=findEmpList").forward(request, response);

    }

    protected void findHistorylist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HistoryDao dao = new HistoryDao();
		List<History> list = dao.selectHistoryList();
		request.setAttribute("hList", list);
        request.getRequestDispatcher("/history_list.jsp").forward(request, response);
    }
}

package nuc.web.servlet;

import nuc.web.dao.AttendanceDao;
import nuc.web.pojo.Attendance;

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
@WebServlet("/AttendanceServlet")
public class AttendanceServlet extends HttpServlet {

    public AttendanceServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        doGet(req, resp);
    }


    protected void findAttendanceList(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        AttendanceDao dao = new AttendanceDao();
        List<Attendance> aList = dao.selectAttendanceList();
        request.setAttribute("aList", aList);
        request.getRequestDispatcher("/attendance_list.jsp").forward(request, response);
    }
}

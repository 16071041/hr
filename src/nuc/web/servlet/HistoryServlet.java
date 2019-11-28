package nuc.web.servlet;

import nuc.web.dao.EmpDao;
import nuc.web.dao.HistoryDao;
import nuc.web.pojo.Employee;
import nuc.web.pojo.History;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet("/HistoryServlet")
public class HistoryServlet extends HttpServlet {

    public HistoryServlet() {
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

    protected void findHistoryById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String hid = request.getParameter("id");
        int id = Integer.parseInt(hid);
        HistoryDao dao = new HistoryDao();
        History his = dao.selectHistoryById(id);

        System.out.println("查看成功。");
        if (his != null) {
            request.setAttribute("history", his);
            request.getRequestDispatcher("history_detail.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/EmpServlet?method=findHistorylist").forward(request, response);
        }
    }

    protected void toUpdateHistory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hid = request.getParameter("id");
        int id = Integer.parseInt(hid);
        HistoryDao dao = new HistoryDao();
        History his = dao.selectHistoryById(id);
        if (his != null) {
            request.setAttribute("history", his);
            System.out.println("update1 成功。");
            request.getRequestDispatcher("/history_update.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/HistoryServlet?method=findHistorylist").forward(request, response);
        }

    }
}

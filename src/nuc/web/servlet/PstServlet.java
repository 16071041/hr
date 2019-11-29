package nuc.web.servlet;

import javafx.geometry.Pos;
import nuc.web.dao.DptDao;
import nuc.web.dao.PstDao;
import nuc.web.pojo.Department;
import nuc.web.pojo.Position;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("/PstServlet")
public class PstServlet extends HttpServlet {
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
     * 跳转职称列表界面
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void findPstList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PstDao dao = new PstDao();
        List<Position> list = dao.selectPstList();
        request.setAttribute("pstList", list);

        System.out.println("find Pstlist.");
        request.getRequestDispatcher("/position_list.jsp").forward(request, response);
    }

    /**
     * 处理插入逻辑，跳转职称列表
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addPst(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String snum = request.getParameter("position_number");
        int num = Integer.parseInt(snum);
        String name = request.getParameter("name");
        String level = request.getParameter("level");
        String notes = request.getParameter("notes");

        Position pst = new Position(0,num,name,level,notes);

        PstDao dao = new PstDao();
        dao.insertPosition(pst);

        System.out.println("insert pst ok.");
        request.getRequestDispatcher("/PstServlet?method=findPstList").forward(request, response);
    }

    /**
     * 处理删除逻辑，并跳转列表界面
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void delPst(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PstDao dao = new PstDao();

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);

        dao.delPst(id);
        System.out.println("delete ok.");
        request.getRequestDispatcher("/PstServlet?method=findPstList").forward(request, response);

    }

    /**
     * 修改职称信息1,跳转修改界面
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void toUpdatePst(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);

        PstDao dao = new PstDao();
        Position pst = dao.selectPstById(id);

        if (pst != null) {
            request.setAttribute("pst", pst);
            System.out.println("update1 成功。");
            request.getRequestDispatcher("/position_update.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/PstServlet?method=findPstList").forward(request, response);
        }

    }

    /**
     * 修改职称信息2，执行修改内容
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doUpdatePst(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        String name = request.getParameter("name");
        String level = request.getParameter("level");
        String notes = request.getParameter("notes");

        Position pst = new Position(id,0,name,level,notes);
        PstDao dao = new PstDao();
        int i = dao.updatePst(pst);

        System.out.println("update2 成功。");
        request.getRequestDispatcher("/PstServlet?method=findPstList").forward(request, response);

    }
}

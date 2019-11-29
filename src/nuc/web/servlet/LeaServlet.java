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

import com.sun.javafx.css.CssError.InlineStyleParsingError;
import nuc.web.dao.LeaDao;
import nuc.web.pojo.Lea;


/**
 * Servlet implementation class LeaServlet
 */
@WebServlet("/LeaServlet")
public class LeaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("method");
		try {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		doGet(request, response);
	}
	
	protected void findLeaList(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		LeaDao dao = new LeaDao();
		List<Lea> list = dao.selectLeaList();
		request.setAttribute("leaList", list);
		request.getRequestDispatcher("/lea_list.jsp").forward(request, response);	
	}
	
	protected void noLicenceList(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		LeaDao dao = new LeaDao();
		List<Lea> list = dao.selectNoLicence();
		request.setAttribute("leaList", list);
		request.getRequestDispatcher("/lea_nolicencelist.jsp").forward(request, response);	
	}
	
	protected void hasLicenceList(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		LeaDao dao = new LeaDao();
		List<Lea> list = dao.selectHasLicence();
		request.setAttribute("leaList", list);
		request.getRequestDispatcher("/lea_haslicencelist.jsp").forward(request, response);	
	}
	
	protected void delLea(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException{
		LeaDao dao = new LeaDao();
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		int i = dao.delLea(id);
		System.out.println("删除lea结果" + i);
		request.getRequestDispatcher("/LeaServlet?method=findLeaList").forward(request, reponse);
		
	}
	
	protected void addLea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String l_num = request.getParameter("employee_number");
		int lnum = Integer.parseInt(l_num);
		String d_num = request.getParameter("department_number");
		int dnum = Integer.parseInt(d_num);
		String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
		String days = request.getParameter("days");
		String reason = request.getParameter("reason");
		String type = request.getParameter("type");
		String manager = request.getParameter("manager");
		String status = request.getParameter("status");
		
		Lea lea = new Lea(lnum, dnum, start_time, end_time, days, reason, type, manager, status);
		
		LeaDao dao = new LeaDao();
		int i = dao.insertLea(lea);
		System.out.println("增加lea结果" + i);
		request.getRequestDispatcher("/LeaServlet?method=findLeaList").forward(request, response);
		
	}
	
	protected void toUpdateLea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		LeaDao dao = new LeaDao();
		Lea lea = dao.selectLeaById(id);
		if(lea != null){
			request.setAttribute("lea", lea);
			request.getRequestDispatcher("/lea_update.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/LeaServlet?method=findLeaList").forward(request, response);
		}
	}
	
	protected void doUpdateLea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String l_num = request.getParameter("employee_number");
		int lnum = Integer.parseInt(l_num);
		String d_num = request.getParameter("department_number");
		int dnum = Integer.parseInt(d_num);
		String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
		String days = request.getParameter("days");
		String reason = request.getParameter("reason");
		String type = request.getParameter("type");
		String status = request.getParameter("status");
		
		Lea lea = new Lea(id, lnum, dnum, start_time, end_time, days, reason, type, status);
		LeaDao dao = new LeaDao();
		int i = dao.updateLea(lea);
		request.getRequestDispatcher("/LeaServlet?method=findLeaList").forward(request, response);
	}
	
	
}

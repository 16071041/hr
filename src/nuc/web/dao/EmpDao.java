package nuc.web.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import nuc.web.pojo.Employee;
import nuc.web.tools.C3P0Conn;

public class EmpDao {

	//工具类，增删改查
	QueryRunner qr = new QueryRunner();
	private Connection conn = null;	
	/**
	 * 员工登录查询
	 * @param num 工号
	 * @param pwd 密码
	 * @return 返回员工信息
	 */
	public Employee selectLogin(int num,String pwd) {
		Employee emp = null;
		conn = C3P0Conn.getConnection();	
		String sql = "select * from employee where employee_number=? and password=?";
		
		try {
			emp = qr.query(conn,sql, new BeanHandler<Employee>(Employee.class),num,pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			C3P0Conn.closeConnction(conn);
		}	
		return emp;
	}
	
	/**
	 * 查询员工列表
	 * @return 列表
	 */
	public List<Employee> selectEmpList() {
		
		List<Employee> list = null;
		conn = C3P0Conn.getConnection();
		
		String sql = "select * from employee";
		try {
			list = qr.query(conn,sql,new BeanListHandler<Employee>(Employee.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			C3P0Conn.closeConnction(conn);
		}
			
		return list;
	}
	
	/**
	 * 根据员工id删除员工
	 * @param id
	 * @return
	 */
	public int delEmp(int id) {
		int i = 0;
		conn = C3P0Conn.getConnection();
		String sql = "delete from employee where id = ?";
		
		try {
			i = qr.update(conn,sql,id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			C3P0Conn.closeConnction(conn);
		}
		
		return i;
	}
	
	/**
	 * 插入员工记录
	 * @param emp
	 * @return
	 */
	public int insertEmpe(Employee emp) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sdate = sdf.format(date);
		
		int i = 0;
		
		conn = C3P0Conn.getConnection();
		String sql = "insert into employee(employee_number,name,password,gender,birthday,telephone,email,"
				+ "address,education,department_number,position_number,in_time) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			i= qr.update(conn,sql,emp.getEmployee_number(),emp.getName(),emp.getPassword(),emp.getGender(),
					emp.getBirthday(),emp.getTelephone(),emp.getEmail(),emp.getAddress(),emp.getEducation(),
					emp.getDepartment_number(),emp.getPosition_number(),sdate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			C3P0Conn.closeConnction(conn);
		}
		
		return i;
	}
	
	/**
	 * 根据id查询员工信息
	 * @param id
	 * @return
	 */
	public Employee selectEmpById(int id) {
		
		Employee emp = null;
		conn = C3P0Conn.getConnection();
		
		String sql = "select * from employee where id = ?";
		try {
			emp = qr.query(conn,sql,new BeanHandler<Employee>(Employee.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			C3P0Conn.closeConnction(conn);
		}
		
		return emp;
		
	}
	
	/**
	 * 更新员工信息
	 * @param emp
	 * @return
	 */
	public int updateEmp(Employee emp) {
		int i= 0;
		
		conn = C3P0Conn.getConnection();
		String sql = "update employee set name=?,password=?,gender=?,birthday=?,telephone=?,email=?,address=?,education=?"
				+ "  where id=?";

		try {
			i = qr.update(conn,sql,emp.getName(),emp.getPassword(),emp.getGender(),emp.getBirthday(),emp.getTelephone(),
					emp.getEmail(),emp.getAddress(),emp.getEducation(),emp.getId());			
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			C3P0Conn.closeConnction(conn);
		}
		
		return i;
	}
	
	
	public static void main(String[] args) {
		
		EmpDao dao = new EmpDao();
		//dao.selectEmpById(id);
		int i = dao.delEmp(7);
		System.out.println(i);
	}
}

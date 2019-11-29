package nuc.web.dao;

import nuc.web.pojo.Department;
import nuc.web.pojo.Employee;
import nuc.web.tools.C3P0Conn;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *  部门表逻辑处理类
 */

public class DptDao {

    QueryRunner qr = new QueryRunner();
    private Connection conn = null;

    /**
     * 查询部门列表
     *
     * @return  list
     */

    public List<Department> selectDptList() {

        List<Department> list = null;
        conn = C3P0Conn.getConnection();

        String sql = "select * from department";
        try {
            list = qr.query(conn,sql,new BeanListHandler<Department>(Department.class));
            System.out.println("select dptlist ok.");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            C3P0Conn.closeConnction(conn);
        }

        return list;
    }

    /**
     * 插入一条部门记录
     *
     * @param dpt
     * @return
     */
    public int insertDepartment(Department dpt) {

        int i = 0;

        conn = C3P0Conn.getConnection();
        String sql = "insert into department(department_number,name,manager,telephone,address,notes) values(?,?,?,?,?,?)";

        try {
            i= qr.update(conn,sql,dpt.getDepartment_number(),dpt.getName(),dpt.getManager(),dpt.getTelephone(),dpt.getAddress(),dpt.getNotes());
            System.out.println("insert ok.");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            C3P0Conn.closeConnction(conn);
        }

        return i;
    }

    /**
     * 删除一条部门记录
     *
     * @param id
     * @return
     */
    public int delDpt(int id) {
        int i = 0;
        conn = C3P0Conn.getConnection();
        String sql = "delete from department where id = ?";

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
     * 通过id查询某个部门
     *
     * @param id
     * @return
     */
    public Department selectDptById(int id) {

        Department dpt = null;
        conn = C3P0Conn.getConnection();

        String sql = "select * from department where id = ?";
        try {

            dpt = qr.query(conn,sql,new BeanHandler<Department>(Department.class),id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            C3P0Conn.closeConnction(conn);
        }

        return dpt;

    }

    /**
     * 更新部门信息
     *
     * @param emp
     * @return
     */
    public int updateDpt(Department dpt) {
        int i= 0;

        conn = C3P0Conn.getConnection();
        String sql = "update department set name=?,manager=?,telephone=?,address=?,notes=?"
                + "  where id=?";


        try {
            i = qr.update(conn,sql,dpt.getName(),dpt.getManager(),dpt.getTelephone(),dpt.getAddress(),dpt.getNotes(),dpt.getId());
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
        DptDao dao = new DptDao();

        Department dpt = dao.selectDptById(2);
        String str = dpt.toString();

        System.out.println(str);
    }
}

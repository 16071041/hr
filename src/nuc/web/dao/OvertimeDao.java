package nuc.web.dao;

import nuc.web.pojo.Employee;
import nuc.web.pojo.History;
import nuc.web.pojo.Overtime;
import nuc.web.tools.C3P0Conn;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by barackbao on 2019/11/29
 */
public class OvertimeDao {

    QueryRunner qr = new QueryRunner();
    private Connection conn = null;

    /**
     * 查询加班列表
     *
     * @return 列表
     */
    public List<Overtime> selectOvertimeList() {

        List<Overtime> list = null;
        conn = C3P0Conn.getConnection();

        String sql = "select * from overtime";
        try {
            list = qr.query(conn, sql, new BeanListHandler<Overtime>(Overtime.class));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            C3P0Conn.closeConnction(conn);
        }

        return list;
    }


    /**
     * 插入加班记录
     *
     * @param
     * @return
     */
    public int insertOvertime(Overtime over) {

        int i = 0;

        conn = C3P0Conn.getConnection();
        String sql = "insert into overtime(department_number,employee_number,day) values(?,?,?)";
        try {
            i = qr.update(conn, sql, over.getDepartment_number(), over.getEmployee_number(),
                    over.getDay());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            C3P0Conn.closeConnction(conn);
        }

        return i;
    }


    public Overtime selectOvertimeById(int id) {

        Overtime overtime = null;
        conn = C3P0Conn.getConnection();

        String sql = "select * from overtime where id = ?";
        try {
            overtime = qr.query(conn, sql, new BeanHandler<Overtime>(Overtime.class), id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            C3P0Conn.closeConnction(conn);
        }

        return overtime;

    }

    public int updateOvertime(Overtime over) {
        int i = 0;

        conn = C3P0Conn.getConnection();
        String sql = "update overtime set department_number=?,employee_number=?,day=?"
                + "  where id=?";

        try {
            i = qr.update(conn, sql, over.getDepartment_number(), over.getEmployee_number(), over.getDay(),
                    over.getId());
            System.out.println(i);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            C3P0Conn.closeConnction(conn);
        }

        return i;
    }


    public int delOvertime(int id) {
        int i = 0;
        conn = C3P0Conn.getConnection();
        String sql = "delete from overtime where id = ?";

        try {
            i = qr.update(conn, sql, id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            C3P0Conn.closeConnction(conn);
        }

        return i;
    }
}

package nuc.web.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import nuc.web.pojo.Lea;
import nuc.web.tools.C3P0Conn;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


public class LeaDao {
    QueryRunner qr = new QueryRunner();
    private Connection conn = null;

    /**
     * 查询所有请假信息
     */
    public List<Lea> selectLeaList() {
        List<Lea> list = null;
        conn = C3P0Conn.getConnection();
        String sql = "select * from lea";
        try {
            list = qr.query(conn, sql, new BeanListHandler<Lea>(Lea.class));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            C3P0Conn.closeConnction(conn);
        }
        return list;
    }

    public Lea selectLeaById(int id) {
        Lea lea = null;
        conn = C3P0Conn.getConnection();
        String sql = "select * from lea where id=?";
        try {
            lea = qr.query(conn, sql, new BeanHandler<Lea>(Lea.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3P0Conn.closeConnction(conn);
        }
        return lea;
    }

    public List<Lea> selectNoLicence() {
        List<Lea> list = null;
        conn = C3P0Conn.getConnection();
        String sql = "select * from lea where status='未批准'";
        try {
            list = qr.query(conn, sql, new BeanListHandler<Lea>(Lea.class));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            C3P0Conn.closeConnction(conn);
        }
        return list;
    }

    public List<Lea> selectHasLicence() {
        List<Lea> list = null;
        conn = C3P0Conn.getConnection();
        String sql = "select * from lea where status='已批准'";
        try {
            list = qr.query(conn, sql, new BeanListHandler<Lea>(Lea.class));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            C3P0Conn.closeConnction(conn);
        }
        return list;
    }

    public int delLea(int id) {
        int i = 0;
        conn = C3P0Conn.getConnection();
        String sql = "delete from lea where id=?";
        try {
            i = qr.update(conn, sql, id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            C3P0Conn.closeConnction(conn);
        }
        return i;
    }

    public int insertLea(Lea lea) {
        int i = 0;
        conn = C3P0Conn.getConnection();
        String sql = "insert into lea(employee_number, department_number, start_time, "
                + "end_time, days, reason, type) value(?,?,?,?,?,?,?)";
        try {
            i = qr.update(conn, sql, lea.getEmployee_number(), lea.getDepartment_number(), lea.getStart_time(),
                    lea.getEnd_time(), lea.getDays(), lea.getReason(), lea.getType());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            C3P0Conn.closeConnction(conn);
        }
        return i;
    }

    public int updateLea(Lea lea) {
        int i = 0;
        conn = C3P0Conn.getConnection();
        String sql = "update lea set employee_number=?,department_number=?,start_time=?,end_time=?,days=?,"
                + "reason=?,type=?,status=? where id=?";
        try {
            i = qr.update(conn, sql, lea.getEmployee_number(), lea.getDepartment_number(), lea.getStart_time(), lea.getEnd_time(),
                    lea.getDays(), lea.getReason(), lea.getType(), lea.getStatus(), lea.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3P0Conn.closeConnction(conn);
        }
        return i;
    }

}

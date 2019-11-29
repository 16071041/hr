package nuc.web.dao;

import nuc.web.pojo.Attendance;
import nuc.web.tools.C3P0Conn;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by barackbao on 2019/11/29
 * 数据库attendance操作类
 */
public class AttendanceDao {

    QueryRunner qr = new QueryRunner();
    private Connection conn = null;

    public List<Attendance> selectAttendanceList() {
        List<Attendance> list = null;
        conn = C3P0Conn.getConnection();

        String sql = "select * from attendance";
        try {
            list = qr.query(conn, sql, new BeanListHandler<Attendance>(Attendance.class));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            C3P0Conn.closeConnction(conn);
        }

        return list;
    }

}

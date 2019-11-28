package nuc.web.dao;

import nuc.web.pojo.Employee;
import nuc.web.pojo.History;
import nuc.web.tools.C3P0Conn;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by barackbao on 2019/11/28
 */
public class HistoryDao {

    QueryRunner qr = new QueryRunner();
    private Connection conn = null;

    /**
     * 查询档案列表
     *
     * @return 列表
     */
    public List<History> selectHistoryList() {

        List<History> list = null;
        conn = C3P0Conn.getConnection();

        String sql = "select * from history";
        try {
            list = qr.query(conn, sql, new BeanListHandler<History>(History.class));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            C3P0Conn.closeConnction(conn);
        }

        return list;
    }


    /**
     * 根据id查询员工档案信息
     *
     * @param id
     * @return
     */
    public History selectHistoryById(int id) {

        History his = null;
        conn = C3P0Conn.getConnection();

        String sql = "select * from history where id = ?";
        try {
            his = qr.query(conn, sql, new BeanHandler<History>(History.class), id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            C3P0Conn.closeConnction(conn);
        }

        return his;

    }
}

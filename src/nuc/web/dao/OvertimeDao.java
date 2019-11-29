package nuc.web.dao;

import nuc.web.pojo.History;
import nuc.web.pojo.Overtime;
import nuc.web.tools.C3P0Conn;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
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
}

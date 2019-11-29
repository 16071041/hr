package nuc.web.dao;

import javafx.geometry.Pos;
import nuc.web.pojo.Department;
import nuc.web.pojo.Position;
import nuc.web.tools.C3P0Conn;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PstDao {

    QueryRunner qr = new QueryRunner();
    private Connection conn = null;

    /**
     * 查询职称列表
     *
     * @return  list
     */

    public List<Position> selectPstList() {

        List<Position> list = null;
        conn = C3P0Conn.getConnection();

        String sql = "select * from position";
        try {
            list = qr.query(conn,sql,new BeanListHandler<Position>(Position.class));
            System.out.println("select PstList ok.");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            C3P0Conn.closeConnction(conn);
        }

        return list;
    }

    /**
     * 插入一条职称记录
     *
     * @param pst
     * @return
     */
    public int insertPosition(Position pst) {

        int i = 0;

        conn = C3P0Conn.getConnection();
        String sql = "insert into `position`(position_number,name,level,notes) values(?,?,?,?)";

        try {
            i= qr.update(conn,sql,pst.getPosition_number(),pst.getName(),pst.getLevel(),pst.getNotes());
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
     * 删除一条职称记录
     *
     * @param id
     * @return
     */
    public int delPst(int id) {
        int i = 0;
        conn = C3P0Conn.getConnection();
        String sql = "delete from position where id = ?";

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
     * 通过id查询某个职称
     *
     * @param id
     * @return
     */
    public Position selectPstById(int id) {

        Position pst = null;
        conn = C3P0Conn.getConnection();

        String sql = "select * from position where id = ?";
        try {

            pst = qr.query(conn,sql,new BeanHandler<Position>(Position.class),id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            C3P0Conn.closeConnction(conn);
        }

        return pst;
    }

    /**
     * 更新职称信息
     *
     * @param
     * @return
     */
    public int updatePst(Position pst) {
        int i= 0;

        conn = C3P0Conn.getConnection();
        String sql = "update position set name=?,level=?,notes=? where id=?";

        try {
            i = qr.update(conn,sql,pst.getName(),pst.getLevel(),pst.getNotes(),pst.getId());
            System.out.println(pst.toString());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            C3P0Conn.closeConnction(conn);
        }

        return i;
    }

    public static void main(String[] args) {

        PstDao dao = new PstDao();
        Position pst = new Position(10,10,"人事部员工","人事部员工","demo");

        int i = dao.updatePst(pst);

        //Position pst = dao.selectPstById(2);
        String str = pst.toString();

        //System.out.println(i+"  pst"+str);
        System.out.println(str);
    }
}

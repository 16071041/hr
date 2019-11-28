package nuc.web.tools;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Conn {
	
	//读取c3p0配置文件，获取数据源
	private static ComboPooledDataSource ds=new ComboPooledDataSource();
	/**
	 * 获取连接
	 * @return
	 */
	
	public static Connection getConnection(){
		Connection conn=null;
		try {
			//通过数据源获取连接
			conn=ds.getConnection();
			System.out.println("连接成功");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 释放资源
	 * @param conn
	 */
	public static void closeConnction(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		getConnection();
	}
	
}

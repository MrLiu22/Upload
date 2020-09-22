package lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class ProvService {



	public static Connection getConnect()
	{
		//链接数据库
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.print("加载驱动错误！");
			e.printStackTrace();
		}

		String url = "jdbc:mysql://172.21.2.248:3306/dm2018";

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, "root", "111111");
		} catch (SQLException e) {
			System.out.print("数据库连接错误！");
			e.printStackTrace();
		}
		return conn;
	}
	
//获取所有省份数据List 集合接口
	public static List<Prov> getALLProv() throws SQLException
	{

		String sql = "select * from provinces";

		Connection conn = ProvService.getConnect();

		QueryRunner qr = new QueryRunner();

		List<Prov> list = qr.query(conn, sql, new BeanListHandler(Prov.class));

		DbUtils.closeQuietly(conn);

		return list;

	}
	
	public static List<City> getCityByProv(String provinceid) throws SQLException
	{

		String sql = "select * from cities where provinceid=?";

		Connection conn = ProvService.getConnect();

		QueryRunner qr = new QueryRunner();

		List<City> list = qr.query(conn, sql, new BeanListHandler(City.class),provinceid);

		DbUtils.closeQuietly(conn);

		return list;

	}
	

}

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
		//�������ݿ�
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.print("������������");
			e.printStackTrace();
		}

		String url = "jdbc:mysql://172.21.2.248:3306/dm2018";

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, "root", "111111");
		} catch (SQLException e) {
			System.out.print("���ݿ����Ӵ���");
			e.printStackTrace();
		}
		return conn;
	}
	
//��ȡ����ʡ������List ���Ͻӿ�
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

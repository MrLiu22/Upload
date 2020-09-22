package lms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
@WebServlet(urlPatterns="/GetCityByProv")
public class GetCityByProvServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
        
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//String json="[{\"cityid\":\"100021\",\"city\":\"朝阳区\"},{\"cityid\":\"100022\",\"city\":\"五道口\"}]";
        String provid=request.getParameter("provid");
		List<City> list;
		
		try {
			list = ProvService.getCityByProv(provid);
			String json=JSON.toJSONString(list);
			out.print(json);
			/*
			for (Prov p : list) {
				out.print("<option value='"+p.getProvinceid()+"'>"+p.getProvince()+"</option>");
			}
			*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}



}

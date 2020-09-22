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
@WebServlet(urlPatterns="/GetAllProv")
public class GetAllProvServlet extends HttpServlet {





	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
        
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//String json="[{\"id\":\"100021\",\"name\":\"北京\"},{\"id\":\"100022\",\"name\":\"上海\"}]";
		List<Prov> list;
		
		try {
			list = ProvService.getALLProv();
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
